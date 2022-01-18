package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {
}