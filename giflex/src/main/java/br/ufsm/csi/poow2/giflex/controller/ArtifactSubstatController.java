package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import br.ufsm.csi.poow2.giflex.model.ArtifactSubstat;
import br.ufsm.csi.poow2.giflex.repository.ArtifactSubstatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ArtifactSubstatController {

    final
    ArtifactSubstatRepository artifactSubstatRepository;

    public ArtifactSubstatController(ArtifactSubstatRepository artifactSubstatRepository) {
        this.artifactSubstatRepository = artifactSubstatRepository;
    }

    @GetMapping("/artifact-substat")
    public ResponseEntity<List<ArtifactSubstat>> getAllArtifactSubstats() {
        try {
            List<ArtifactSubstat> artifactSubstats = new ArrayList<ArtifactSubstat>(artifactSubstatRepository.findAll());

            if (artifactSubstats.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(artifactSubstats, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/artifact-substat")
    public ResponseEntity<ArtifactSubstat> addArtifact(
            @RequestBody ArtifactSubstat artifactSubstat
    ) {
        ArtifactSubstat _artifactSubstat = artifactSubstatRepository.save( new ArtifactSubstat(
                artifactSubstat.getArtifact(),
                artifactSubstat.getSubstat(),
                artifactSubstat.getSubstatValue()
        ));
        return new ResponseEntity<>(_artifactSubstat, HttpStatus.CREATED);
    }
}
