package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import br.ufsm.csi.poow2.giflex.repository.ArtifactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ArtifactController {

    final
    ArtifactRepository artifactRepository;

    public ArtifactController(ArtifactRepository artifactRepository) {
        this.artifactRepository = artifactRepository;
    }

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

    @PostMapping("/artifacts")
    public ResponseEntity<Artifact> addArtifact(@RequestBody Artifact artifact) {
        Artifact _artifact = artifactRepository.save(new Artifact
                (artifact.getMainStatValue()));
        return new ResponseEntity<>(_artifact, HttpStatus.CREATED);
    }

    @PutMapping("/artifacts/{id}")
    public ResponseEntity<Artifact> editArtifact(
            @PathVariable("id") int id,
            @RequestBody Artifact artifact ) {
        Optional<Artifact> artifactData = artifactRepository.findById(id);

        if (artifactData.isPresent()) {
            Artifact _artifact = artifactData.get();
            _artifact.setMainStatValue(artifact.getMainStatValue());

            return new ResponseEntity<>(artifactRepository.save(_artifact), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/artifacts/{id}")
    public ResponseEntity<Artifact> deleteUserById(@PathVariable("id") int id) {

        try {
            artifactRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
