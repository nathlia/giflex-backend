package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.ArtifactSetType;
import br.ufsm.csi.poow2.giflex.repository.ArtifactSetTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ArtifactSetTypeController {

    final
    ArtifactSetTypeRepository artifactSetTypeRepository;

    public ArtifactSetTypeController(ArtifactSetTypeRepository artifactSetTypeRepository) {
        this.artifactSetTypeRepository = artifactSetTypeRepository;
    }

    @GetMapping("/artifact-set-types")
    public ResponseEntity<List<ArtifactSetType>> getAllArtifactSetTypes(@RequestParam(required = false) String name) {
        try {
            List<ArtifactSetType> artifactSetTypes = new ArrayList<ArtifactSetType>();

            if (name == null) {
                artifactSetTypes.addAll(artifactSetTypeRepository.findAll());
            } else {
                artifactSetTypes.addAll(artifactSetTypeRepository.findByName(name));
            }

            if (artifactSetTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(artifactSetTypes, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/artifact-set-types/{id}")
    public ResponseEntity<ArtifactSetType> getArtifactSetTypeById(@PathVariable("id") int id) {
        Optional<ArtifactSetType> artifactSetTypeData = artifactSetTypeRepository.findById(id);

        if (artifactSetTypeData.isPresent()) {
            return new ResponseEntity<>(artifactSetTypeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

