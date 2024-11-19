package com.sistema.vendas.config;

import com.sistema.vendas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Configuration
@RequiredArgsConstructor

public class UserDetailsConfig implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.contains("@")){
            return userRepository.findByEmail(username).orElseThrow(()->
                    new UsernameNotFoundException("Usuario Nao encotrado")
                    );
        }
        return null;
    }
}
