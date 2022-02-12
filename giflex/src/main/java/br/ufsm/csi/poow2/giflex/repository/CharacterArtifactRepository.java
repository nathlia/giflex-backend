package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.CharacterArtifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CharacterArtifactRepository extends JpaRepository<CharacterArtifact, Integer> {
    @Modifying
    @Query(value = "DELETE FROM character_artifact WHERE  character_artifact.artifact_id = ?1", nativeQuery = true)
    void deleteByArtifactId(int id);
}