package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.UserAccount;
import br.ufsm.csi.poow2.giflex.repository.UserAccountRepository;
import br.ufsm.csi.poow2.giflex.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    final
    UserAccountRepository userAccountRepository;

    public LoginController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> auth(@RequestBody UserAccount userAccount) {
        System.out.println("Username: " + userAccount.getUsername());
        System.out.println("Is_Admin:" + userAccount.isAdmin());

        try {
            final Authentication authenticaticon = this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userAccount.getUsername(), userAccount.getPassword()));
            if (authenticaticon.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authenticaticon);

                System.out.println("*** Generating Authorization Token ***");
                String token = new JWTUtil().geraToken(userAccount.getUsername());

                new UserAccount();
                UserAccount loggedUser;
                loggedUser = this.userAccountRepository.findByUsername(userAccount.getUsername());

                userAccount.setToken(token);
                userAccount.setPassword("");
                userAccount.setAdmin(loggedUser.isAdmin());
                System.out.println("Is_Admin:" + loggedUser.isAdmin());

                return new ResponseEntity<>(userAccount, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("User or Password Incorrect", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User or Password Incorrect", HttpStatus.BAD_REQUEST);
    }
}
