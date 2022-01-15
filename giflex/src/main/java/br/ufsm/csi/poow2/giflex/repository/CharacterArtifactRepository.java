package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.CharacterArtifact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterArtifactRepository extends JpaRepository<CharacterArtifact, Integer> {
}