package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.ArtifactType;
import br.ufsm.csi.poow2.giflex.repository.ArtifactTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ArtifactTypeController {

    final
    ArtifactTypeRepository artifactTypeRepository;

    public ArtifactTypeController(ArtifactTypeRepository artifactTypeRepository) {
        this.artifactTypeRepository = artifactTypeRepository;
    }

    @GetMapping("/artifact-type")
    public ResponseEntity<List<ArtifactType>> getAllArtifactTypes(@RequestParam(required = false) String name ) {
        try {
            List<ArtifactType> artifactTypes = new ArrayList<ArtifactType>();

            if (name == null) {
                artifactTypes.addAll(artifactTypeRepository.findAll());
            }
            else {
                artifactTypes.addAll(artifactTypeRepository.findByName(name));
            }

            if (artifactTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(artifactTypes, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/artifact-type/{id}")
    public ResponseEntity<ArtifactType> getArtifactTypeById(@PathVariable("id") int id) {
        Optional<ArtifactType> artifactTypeData = artifactTypeRepository.findById(id);

        if (artifactTypeData.isPresent()) {
            return new ResponseEntity<>(artifactTypeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
