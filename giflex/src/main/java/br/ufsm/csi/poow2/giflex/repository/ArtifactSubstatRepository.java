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

//    @Modifying
//    @Query(value = "INSERT INTO artifact_substat (artifact_id, substat_id, substatvalue) VALUES (?1, ?2, ?3)", nativeQuery = true)
//    void addArtifactSubstat(int idA, int idS, double value);
//
//    default void getArtifactSubstats(Artifact artifact) {
//        //Artifact artifact1 = artifact;
//        Set<ArtifactSubstat> artifactSubstats = artifact.getArtifactSubstats();
//        for (ArtifactSubstat as: artifactSubstats) {
//            Substat substat = as.getSubstat();
//            double value = as.getSubstatValue();
//            addArtifactSubstat(artifact.getId(), substat.getId(), value);
//            System.out.printf("********>>\nA id: %d \nS id: %d \nValue: %f\n", artifact.getId(), substat.getId(), value);
//
//        }
//    }
}