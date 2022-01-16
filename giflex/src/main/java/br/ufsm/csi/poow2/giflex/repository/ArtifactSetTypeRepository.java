package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.ArtifactSetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.text.CollationElementIterator;
import java.util.Collection;

@Repository
public interface ArtifactSetTypeRepository extends JpaRepository<ArtifactSetType, Integer> {
    Collection<? extends ArtifactSetType> findByName(String name);
}