package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.ArtifactType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtifactTypeRepository extends JpaRepository<ArtifactType, Integer> {
}