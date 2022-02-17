package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.ArtifactSubstat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ArtifactSubstatRepository extends JpaRepository<ArtifactSubstat, Integer> {
    @Modifying
    @Query(value = "DELETE FROM artifact_substat WHERE artifact_substat.artifact_id = ?1", nativeQuery = true)
    void deleteByArtifactId(int id);
}