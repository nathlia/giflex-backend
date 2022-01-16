package br.ufsm.csi.poow2.giflex.controller;

import br.ufsm.csi.poow2.giflex.model.Character;
import br.ufsm.csi.poow2.giflex.repository.CharacterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
//@RequestMapping("character")
public class CharacterController {

    final
    CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping("/characters")
    public ResponseEntity<List<Character>> getAllCharacters(@RequestParam(required = false) String name ) {
        try {
            List<Character> characters = new ArrayList<Character>();

            if (name == null) {
                characters.addAll(characterRepository.findAll());
            }
            else {
                characters.addAll(characterRepository.findByName(name));
            }

            if (characters.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(characters, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable("id") long id) {
        Optional<Character> characterData = characterRepository.findById(id);

        if (characterData.isPresent()) {
            return new ResponseEntity<>(characterData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/characters/add")
    public ResponseEntity<Character> addCharacter(@RequestBody Character character) {
        Character _character = characterRepository.save(new Character(character.getName(), character.getLevel(), character.getCritRate(), character.getCritDmg()));
        return new ResponseEntity<>(_character, HttpStatus.CREATED);
    }

    @PutMapping("/characters/{id}/edit")
    public ResponseEntity<Character> editCharacter(@PathVariable("id") long id, @RequestBody Character character ) {
        Optional<Character> characterData = characterRepository.findById(id);

        if (characterData.isPresent()) {
            Character _character = characterData.get();
            _character.setName(character.getName());
            _character.setLevel(character.getLevel());
            _character.setCritRate(character.getCritRate());
            _character.setCritDmg(character.getCritDmg());

            return new ResponseEntity<>(characterRepository.save(_character), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/characters/{id}")
    public ResponseEntity<Character> deleteCharacterById(@PathVariable("id") long id) {

        try {
            characterRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
