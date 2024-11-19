package com.sistema.vendas.service.impl;

import com.sistema.vendas.dto.request.LoginRequestForUser;
import com.sistema.vendas.dto.response.TokenResponseDto;
import com.sistema.vendas.model.Token;
import com.sistema.vendas.model.User;
import com.sistema.vendas.repository.TokenRepository;
import com.sistema.vendas.repository.UserRepository;
import com.sistema.vendas.security.JWTService;
import com.sistema.vendas.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    @Override
    public TokenResponseDto userLogin(LoginRequestForUser loginRequestForUser) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestForUser.getEmail(),
                        loginRequestForUser.getPassword()
                )
        );

        var user = userRepository.findByEmail(loginRequestForUser.getEmail()).orElseThrow();
        var token = jwtService.generateToken(user);
        saveUserToken(user,token);
        return TokenResponseDto.builder()
                .accessToken(token)
                .build();
    }

    private void saveUserToken(User user, String token){
        var jwtToken = Token.builder()
                .user(user)
                .token(token)
                .expired(false)
                .revoked(false)
                .createdAt(LocalDateTime.now())
                .build();
        tokenRepository.save(jwtToken);
    }
}
