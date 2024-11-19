package com.sistema.vendas.service;

import com.sistema.vendas.dto.request.LoginRequestForUser;
import com.sistema.vendas.dto.response.TokenResponseDto;

public interface LoginService {
    TokenResponseDto userLogin(LoginRequestForUser loginRequestForUser);
}
