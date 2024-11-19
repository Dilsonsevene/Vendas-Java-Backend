package com.sistema.vendas.service.impl;

import com.sistema.vendas.exception.BadRequestException;
import com.sistema.vendas.exception.EntityNotFoundException;
import com.sistema.vendas.model.User;
import com.sistema.vendas.model.enums.UserRole;
import com.sistema.vendas.repository.UserRepository;
import com.sistema.vendas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public String createUser(User user) {

        if(userRepository.existsByEmail(user.getEmail())){
            throw new BadRequestException("Este Usuario Ja existe");
        }
        user.setRole(UserRole.ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Usuario Criado com Sucesso";
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Usuario nao encotrado"));
    }
}
