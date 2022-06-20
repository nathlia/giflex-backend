package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    public default UserAccount findByUsername(String username) {
           if(username.equals("natty")) {
               return new UserAccount("Nathalia","natty", new BCryptPasswordEncoder().encode("123"), true);
           } else {
               return null;
           }
    }
}
