package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.ArtifactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ArtifactTypeRepository extends JpaRepository<ArtifactType, Integer> {
    Collection<? extends ArtifactType> findByName(String name);
}