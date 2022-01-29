package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import br.ufsm.csi.poow2.giflex.model.ArtifactSubstat;
import br.ufsm.csi.poow2.giflex.model.Substat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {

    @Query(value = "select substatvalue from artifact_substat where artifact_id = ?1 and substat_id = ?2",
            nativeQuery = true)
    Double getArtifactValue(int idA, int idS);

    public default void getSubstatValue(Artifact artifact) {
//        for (ArtifactSubstat substat : artifact.getSubstats()) {
//
//            double value = getArtifactValue(artifact.getId(), substat.getId());
//            substat.setSubstatValue(value);
//        }
    }

}