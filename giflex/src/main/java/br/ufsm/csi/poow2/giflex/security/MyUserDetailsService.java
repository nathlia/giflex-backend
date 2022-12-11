package br.ufsm.csi.poow2.giflex.security;

import br.ufsm.csi.poow2.giflex.model.UserAccount;
import br.ufsm.csi.poow2.giflex.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username: "+username);

        UserAccount userAccount = userAccountRepository.findByUsername(username);

        System.out.println(userAccount);

        if (userAccount == null) {
            throw new UsernameNotFoundException("Username or Password Not Found");
        }
        else {
            String authtority = "";
            if (userAccount.is_admin == true) {
                authtority = "ADMIN";
            } else if (userAccount.is_admin == false) {
                authtority = "USER";
            }
            System.out.println(authtority);
            UserDetails userDetails = User.withUsername(userAccount.getUsername())
                    .password(userAccount.getPassword())
                    .authorities(authtority)
                    .build();

            return userDetails;
        }
    }
}
