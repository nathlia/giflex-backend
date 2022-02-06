package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import br.ufsm.csi.poow2.giflex.model.ArtifactSubstat;
import br.ufsm.csi.poow2.giflex.repository.ArtifactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "*")
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
            //artifactRepository.getSubstatValue(artifactData.get());
            return new ResponseEntity<>(artifactData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //TODO POST and PUT

    @PostMapping("/artifacts")
    public ResponseEntity<Artifact> addArtifact(@RequestBody Artifact artifact) {
        //artifactRepository.addArtifactSubstats(artifact);
        Artifact _artifact = artifactRepository.save(new Artifact(
                artifact.getMainStatValue(),
                artifact.getArtifactType(),
                artifact.getArtifactSetType(),
                artifact.getMainstat(),
                artifact.getArtifactSubstats()
        ));
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
            _artifact.setArtifactType(artifact.getArtifactType());
            _artifact.setArtifactSetType(artifact.getArtifactSetType());
            _artifact.setMainstat(artifact.getMainstat());
            _artifact.setMainStatValue(artifact.getMainStatValue());
            _artifact.setArtifactSubstats(artifact.getArtifactSubstats());

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
