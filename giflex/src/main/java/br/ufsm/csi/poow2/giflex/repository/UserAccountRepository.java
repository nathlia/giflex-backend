package br.ufsm.csi.poow2.giflex.repository;

import br.ufsm.csi.poow2.giflex.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    @Query(value = "SELECT *  FROM useraccount WHERE username = ?1", nativeQuery = true)
    UserAccount findByUsername(String username);

//    public default UserAccount findByUsername(String username) {
//        if(username.equals("natty")) {
//            return new UserAccount("Nathalia","natty", new BCryptPasswordEncoder().encode("123"), true);
//        } else {
//            return null;
//        }
//    }
}

