package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import br.ufsm.csi.poow2.giflex.model.Character;
import br.ufsm.csi.poow2.giflex.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ArtifactController {

    @Autowired
    ArtifactRepository artifactRepository;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    CharacterArtifactRepository characterArtifactRepository;

    @GetMapping("/artifacts")
    public ResponseEntity<List<Artifact>> getAllArtifacts() {
        try {
            List<Artifact> artifacts = new ArrayList<Artifact>(artifactRepository.findAll());

            if (artifacts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(artifacts, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/artifacts/{id}")
    public ResponseEntity<Artifact> getArtifactById(@PathVariable("id") int id) {
        Optional<Artifact> artifactData = artifactRepository.findById(id);

        if (artifactData.isPresent()) {
            return new ResponseEntity<>(artifactData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/artifacts/{charaId}")
    public ResponseEntity<Artifact> addArtifact(
            @RequestBody Artifact artifact,
            @PathVariable("charaId") int charaId
    ) {
        //add artifact
        Artifact _artifact = artifactRepository.save(new Artifact(
                artifact.getMainStatValue(),
                artifact.getArtifactType(),
                artifact.getArtifactSetType(),
                artifact.getMainstat()
        ));

        //add artifact to character
        Optional<Character> characterData = characterRepository.findById(charaId);

        if (characterData.isPresent()) {
            Character _character = characterData.get();
            _character.getEquippedArtifacts().add(_artifact);
            _artifact.getCharacters().add(_character);

            characterRepository.save(_character);
            artifactRepository.save(_artifact);

            return new ResponseEntity<>(_artifact, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/artifacts/{artId}")
    public ResponseEntity<Artifact> editArtifact(@PathVariable("artId") int artId, @RequestBody Artifact artifact) {
        Optional<Artifact> artifactData = artifactRepository.findById(artId);

        if (artifactData.isPresent()) {
            Artifact _artifact = artifactData.get();
            _artifact.setMainStatValue(artifact.getMainStatValue());
            _artifact.setArtifactType(artifact.getArtifactType());
            _artifact.setArtifactSetType(artifact.getArtifactSetType());
            _artifact.setMainstat(artifact.getMainstat());
            _artifact.setMainStatValue(artifact.getMainStatValue());

            return new ResponseEntity<>(artifactRepository.save(_artifact), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/artifacts/{id}")
    public ResponseEntity<Artifact> deleteArtifactById(@PathVariable("id") int id) {
        try {

            Optional<Artifact> artifactData = artifactRepository.findById(id);

            if (artifactData.isPresent()) {
                Artifact _artifact = artifactData.get();
                artifactRepository.deleteEquippedCharacters(_artifact);
            }

            characterArtifactRepository.deleteByArtifactId(id);
            artifactRepository.deleteArtifact(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
