package com.sistema.vendas.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponseDto {

    public Long id;
    public String produtoNome;
    public double preco;
    public double precoCompra;
    public int quantidade;
}
