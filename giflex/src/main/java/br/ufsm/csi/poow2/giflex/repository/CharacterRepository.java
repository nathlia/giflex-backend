package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    Collection<? extends Character> findByName(String name);
}