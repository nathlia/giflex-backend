package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.UserAccount;
import br.ufsm.csi.poow2.giflex.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    final
    UserAccountRepository userAccountRepository;

    public PlayerController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        try {
            List<UserAccount> users = new ArrayList<UserAccount>(userAccountRepository.findAll());

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable("id") int id) {
        Optional<UserAccount> userData = userAccountRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<UserAccount> addPlayer(@RequestBody UserAccount userAccount) {
        UserAccount _userAccount = userAccountRepository.save(new UserAccount(
                userAccount.getUsername(),
                userAccount.getName(),
                userAccount.getPassword(),
                userAccount.isAdmin()
        ));
        return new ResponseEntity<>(_userAccount, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserAccount> editUser(@PathVariable("id") int id, @RequestBody UserAccount userAccount) {
        Optional<UserAccount> playerData = userAccountRepository.findById(id);

        if (playerData.isPresent()) {
            UserAccount _userAccount = playerData.get();
            _userAccount.setUsername(userAccount.getUsername());
            _userAccount.setName(userAccount.getName());
            _userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));

            return new ResponseEntity<>(userAccountRepository.save(_userAccount), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserAccount> deleteUserById(@PathVariable("id") int id) {

        try {
            userAccountRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
