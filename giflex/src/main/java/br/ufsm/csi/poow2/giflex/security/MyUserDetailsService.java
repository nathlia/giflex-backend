package br.ufsm.csi.poow2.giflex.security;

import br.ufsm.csi.poow2.giflex.model.Player;
import br.ufsm.csi.poow2.giflex.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username: "+username);

        Player player = playerRepository.findByUsername(username);

        if (player == null) {
            throw new UsernameNotFoundException("Username or Password Not Found");
        }
        else {
            UserDetails userDetails = User.withUsername(player.getUsername())
                    .password(player.getPassword())
                    .authorities("USER")
                    .build();

            return userDetails;
        }
    }
}