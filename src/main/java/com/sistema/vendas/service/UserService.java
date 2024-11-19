package com.sistema.vendas.service;

import com.sistema.vendas.model.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    String createUser(User user);
    User getUserById(Long id);
}
