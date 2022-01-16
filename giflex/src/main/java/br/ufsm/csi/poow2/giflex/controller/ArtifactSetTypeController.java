package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.ArtifactSetType;
import br.ufsm.csi.poow2.giflex.repository.ArtifactSetTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ArtifactSetTypeController {

    final
    ArtifactSetTypeRepository artifactSetTypeRepository;

    public ArtifactSetTypeController(ArtifactSetTypeRepository artifactSetTypeRepository) {
        this.artifactSetTypeRepository = artifactSetTypeRepository;
    }

    @GetMapping("/artifact-set-type")
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

    @GetMapping("/artifact-set-type/{id}")
    public ResponseEntity<ArtifactSetType> getArtifactSetTypeById(@PathVariable("id") int id) {
        Optional<ArtifactSetType> artifactSetTypeData = artifactSetTypeRepository.findById(id);

        if (artifactSetTypeData.isPresent()) {
            return new ResponseEntity<>(artifactSetTypeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/artifact-set-type/add")
    public ResponseEntity<ArtifactSetType> addArtifactSetType(@RequestBody ArtifactSetType artifactSetType) {
        ArtifactSetType _artifactSetType = artifactSetTypeRepository.save(new ArtifactSetType(
                artifactSetType.getName(), artifactSetType.getTwopieces(), artifactSetType.getFourpieces()));
        return new ResponseEntity<>(_artifactSetType, HttpStatus.CREATED);
    }

    @PutMapping("artifact-set-type/{id}/edit")
    public ResponseEntity<ArtifactSetType> editArtifactSetType(@PathVariable("id") int id, @RequestBody ArtifactSetType artifactSetType ) {
        Optional<ArtifactSetType> artifactSetTypeData = artifactSetTypeRepository.findById(id);

        if (artifactSetTypeData.isPresent()) {
            ArtifactSetType _artifactSetType = artifactSetTypeData.get();
            _artifactSetType.setName(artifactSetType.getName());
            _artifactSetType.setTwopieces(artifactSetType.getTwopieces());
            _artifactSetType.setFourpieces(artifactSetType.getFourpieces());

            return new ResponseEntity<>(artifactSetTypeRepository.save(_artifactSetType), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("artifact-set-type/{id}")
    public ResponseEntity<ArtifactSetType> deleteArtifactSetType(@PathVariable("id") int id) {

        try {
            artifactSetTypeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

