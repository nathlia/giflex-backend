package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.CharacterArtifact;
import br.ufsm.csi.poow2.giflex.repository.CharacterArtifactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class CharacterArtifactController {

    final
    CharacterArtifactRepository characterArtifactRepository;

    public CharacterArtifactController(CharacterArtifactRepository characterArtifactRepository) {
        this.characterArtifactRepository = characterArtifactRepository;
    }

    @GetMapping("/character-artifacts")
    public ResponseEntity<List<CharacterArtifact>> getAllEquippedArtifacts() {
        try {
            ArrayList<CharacterArtifact> characterArtifacts = new ArrayList<>(characterArtifactRepository.findAll());

            if (characterArtifacts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(characterArtifacts, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/character-artifacts/{id}")
    public ResponseEntity<CharacterArtifact> getEquippedArtifactById(@PathVariable("id") int id) {
        Optional<CharacterArtifact> characterArtifactData = characterArtifactRepository.findById(id);

        return characterArtifactData.map(characterArtifact -> new ResponseEntity<>(characterArtifact, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/character-artifacts/{id}")
    public ResponseEntity<CharacterArtifact> deleteEquippedArtifactById(@PathVariable("id") int id) {

        try {
            characterArtifactRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
