package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {



//    default void addArtifactSubstats(Artifact artifact) {
        //Set<ArtifactSubstat> artifactSubstat = artifact.getArtifactSubstats();

//        for (ArtifactSubstat artifactSubstat : artifact.getArtifactSubstats()) {
//            Artifact artifact1 = artifactSubstat.getArtifact();
//            Substat substat = artifactSubstat.getSubstat();
//            double value = artifactSubstat.getSubstatValue();
//
//
//            artifactSubstat.setArtifact(artifact1);
//            artifactSubstat.setSubstat(substat);
//            artifactSubstat.setSubstatValue(value);
//
//            ArtifactSubstat artifactSubstat1 = new ArtifactSubstat(artifact1, substat, value);

//        }

 //   }

//    @Query(value = "select substatvalue from artifact_substat where artifact_id = ?1 and substat_id = ?2",
//            nativeQuery = true)
//    Double getArtifactValue(int idA, int idS);
//
//    public default void getSubstatValue(Artifact artifact) {
//        for (ArtifactSubstat substat : artifact.getSubstats()) {
//
//            double value = getArtifactValue(artifact.getId(), substat.getId());
//            substat.setSubstatValue(value);
//        }
//    }

//    @Transactional
//    public default void insertSubstatsWithQuery(ArtifactSubstat artifactSubstat) {
//        entityManager.createNativeQuery("INSERT INTO artifact_substat (artifact_id, substat_id, substatvalue) VALUES (?, ?, ?)")
//                .setParameter(1, artifactSubstat.getArtifact())
//                .setParameter(2, artifactSubstat.getSubstat())
//                .setParameter(3, artifactSubstat.getSubstatValue())
//                .executeUpdate();
//    }


}