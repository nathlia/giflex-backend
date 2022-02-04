package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.Player;
import br.ufsm.csi.poow2.giflex.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class PlayerController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    final
    PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Player>> getAllUsers() {
        try {
            List<Player> users = new ArrayList<Player>(playerRepository.findAll());

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Player> getUserById(@PathVariable("id") int id) {
        Optional<Player> userData = playerRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player _player = playerRepository.save(new Player(
                player.getUsername(),
                player.getName(),
                player.getPassword()
        ));
        return new ResponseEntity<>(_player, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Player> editUser(@PathVariable("id") int id, @RequestBody Player player) {
        Optional<Player> playerData = playerRepository.findById(id);

        if (playerData.isPresent()) {
            Player _player = playerData.get();
            _player.setUsername(player.getUsername());
            _player.setName(player.getName());
            _player.setPassword(passwordEncoder.encode(player.getPassword()));

            return new ResponseEntity<>(playerRepository.save(_player), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Player> deleteUserById(@PathVariable("id") int id) {

        try {
            playerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
