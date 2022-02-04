package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query("select p from Player p where p.username = ?1")
    public default Player findByUsername(String username) {
            return new Player("Natty", "natty", new BCryptPasswordEncoder().encode("123"));
    }

    //Player findByUsername(String username);
}