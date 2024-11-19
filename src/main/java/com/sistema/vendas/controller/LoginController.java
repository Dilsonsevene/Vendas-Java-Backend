package com.sistema.vendas.controller;

import com.sistema.vendas.dto.request.LoginRequestForUser;
import com.sistema.vendas.dto.response.TokenResponseDto;
import com.sistema.vendas.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/userlogin")
    public ResponseEntity<TokenResponseDto>userLogin(@RequestBody LoginRequestForUser loginRequestForUser){
        return ResponseEntity.ok(loginService.userLogin(loginRequestForUser));
    }
}
