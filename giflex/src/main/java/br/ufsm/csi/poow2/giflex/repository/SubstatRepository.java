package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.Substat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface SubstatRepository extends JpaRepository<Substat, Integer> {
    Collection<? extends Substat> findByName(String name);
}