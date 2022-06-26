package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.UserAccount;
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

    @PostMapping("/login")
    public ResponseEntity<Object> auth(@RequestBody UserAccount userAccount) {
        System.out.println("Username: " + userAccount.getUsername());

        try {
            final Authentication authenticaticon = this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userAccount.getUsername(), userAccount.getPassword()));
            if (authenticaticon.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authenticaticon);

                System.out.println("*** Generating Authorization Token ***");
                String token = new JWTUtil().geraToken(userAccount.getUsername());

                userAccount.setToken(token);
                userAccount.setPassword("");

                return new ResponseEntity<>(userAccount, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("User or Password Incorrect", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User or Password Incorrect", HttpStatus.BAD_REQUEST);
    }
}
