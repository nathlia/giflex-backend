package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import br.ufsm.csi.poow2.giflex.model.ArtifactSubstat;
import br.ufsm.csi.poow2.giflex.model.Substat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ArtifactSubstatRepository extends JpaRepository<ArtifactSubstat, Integer> {

    //Optional<Substat> findById(Set<ArtifactSubstat> substats);
//    default ArtifactSubstat addArtifactSubstat( ArtifactSubstat artifactSubstat){
//
//        Artifact artifact1 = artifactSubstat.getArtifact();
//        Substat substat = artifactSubstat.getSubstat();
//        double value = artifactSubstat.getSubstatValue();
//
//        artifactSubstat.setArtifact(artifact1);
//        artifactSubstat.setSubstat(substat);
//        artifactSubstat.setSubstatValue(value);
//
//        return new ArtifactSubstat(artifact1, substat, value);
//    }
}