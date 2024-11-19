package com.sistema.vendas.dto.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestForUser {
    private String email;
    private String password;
}
