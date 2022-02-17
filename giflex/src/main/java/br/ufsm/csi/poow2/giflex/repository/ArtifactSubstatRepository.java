package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import br.ufsm.csi.poow2.giflex.model.ArtifactSubstat;
import br.ufsm.csi.poow2.giflex.model.Substat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface ArtifactSubstatRepository extends JpaRepository<ArtifactSubstat, Integer> {

    @Modifying
    @Query(value = "UPDATE artifact_substat SET  substatvalue = ?3 WHERE artifact_id = ?1 AND substat_id = ?2", nativeQuery = true)
    void editArtifactSubstat(int idA, int idS, double value);

    default void getArtifactSubstats(Artifact artifact) {
        Set<ArtifactSubstat> artifactSubstats = artifact.getArtifactSubstats();
        for (ArtifactSubstat as: artifactSubstats) {
            Substat substat = as.getSubstat();
            double value = as.getSubstatValue();
            editArtifactSubstat(artifact.getId(), substat.getId(), value);
           // System.out.printf("********>>\nA id: %d \nS id: %d \nValue: %f\n", artifact.getId(), substat.getId(), value);
           // substat.setArtifactSubstats(artifactSubstats);
        }
        //artifact.editArtifactSubstat(artifactSubstats);
    }

    @Modifying
    @Query(value = "DELETE FROM artifact_substat WHERE artifact_substat.artifact_id = ?1", nativeQuery = true)
    void deleteByArtifactId(int id);
}