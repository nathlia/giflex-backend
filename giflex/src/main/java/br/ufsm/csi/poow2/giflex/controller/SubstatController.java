package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.Substat;
import br.ufsm.csi.poow2.giflex.repository.SubstatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class SubstatController {

    final
    SubstatRepository substatRepository;

    public SubstatController(SubstatRepository substatRepository) {
        this.substatRepository = substatRepository;
    }

    @GetMapping("/substats")
    public ResponseEntity<List<Substat>> getAllSubstats(@RequestParam(required = false) String name ) {
        try {
            List<Substat> substats = new ArrayList<Substat>();

            if (name == null) {
                substats.addAll(substatRepository.findAll());
            }
            else {
                substats.addAll(substatRepository.findByName(name));
            }

            if (substats.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(substats, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/substats/{id}")
    public ResponseEntity<Substat> getSubstatById(@PathVariable("id") int id) {
        Optional<Substat> substatData = substatRepository.findById(id);

        if (substatData.isPresent()) {
            return new ResponseEntity<>(substatData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//TODO delete comments

//    @PostMapping("/substats/add")
//    public ResponseEntity<Substat> addSubstat(@RequestBody Substat substat) {
//        Substat _substat = substatRepository.save(new Substat(
//               substat.getName()));
//        return new ResponseEntity<>(_substat, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/substats/{id}/edit")
//    public ResponseEntity<Substat> editSubstat(@PathVariable("id") int id, @RequestBody Substat substat ) {
//        Optional<Substat> substatData =substatRepository.findById(id);
//
//        if (substatData.isPresent()) {
//            Substat  _substat = substatData.get();
//            _substat.setName(substat.getName());
//
//            return new ResponseEntity<>(substatRepository.save( _substat), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/substats/{id}/delete")
//    public ResponseEntity<Substat> deleteSubstatById(@PathVariable("id") int id) {
//
//        try {
//            substatRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
