package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import br.ufsm.csi.poow2.giflex.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
@Transactional
public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {

    @Modifying
    @Query(value = "DELETE FROM artifact a WHERE  a.id = ?1", nativeQuery = true)
    void deleteArtifact(int id);

    default void deleteEquippedCharacters(Artifact artifact) {
        Set<Character> characters = artifact.getCharacters();
        for (Character c: characters) {
            artifact.removeCharacter(c);
        }
    }

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


}