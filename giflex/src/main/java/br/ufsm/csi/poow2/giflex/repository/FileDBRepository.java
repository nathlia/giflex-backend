package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
