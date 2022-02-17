package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    public default Player findByUsername(String username) {
           if(username.equals("natty")) {
               return new Player("Nathalia","natty", new BCryptPasswordEncoder().encode("123"));
           } else {
               return null;
           }
    }
}