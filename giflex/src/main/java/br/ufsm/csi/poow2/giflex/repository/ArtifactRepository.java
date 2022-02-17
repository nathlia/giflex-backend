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
}