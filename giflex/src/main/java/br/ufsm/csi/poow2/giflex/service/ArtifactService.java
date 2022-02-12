package br.ufsm.csi.poow2.giflex.service;

import br.ufsm.csi.poow2.giflex.model.Artifact;
import br.ufsm.csi.poow2.giflex.model.ArtifactSubstat;
import br.ufsm.csi.poow2.giflex.model.Substat;
import br.ufsm.csi.poow2.giflex.repository.ArtifactRepository;
import br.ufsm.csi.poow2.giflex.repository.ArtifactSubstatRepository;
import br.ufsm.csi.poow2.giflex.repository.SubstatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtifactService {
    @Autowired
    private ArtifactRepository artifactRepository;

    @Autowired
    private SubstatRepository substatRepository;

    @Autowired
    private ArtifactSubstatRepository artifactSubstatRepository;

    public List<Artifact> getAllArtifacts() {
        return artifactRepository.findAll();
    }

//    public Artifact addArtifact(Artifact artifact) {
//
//    }
}
