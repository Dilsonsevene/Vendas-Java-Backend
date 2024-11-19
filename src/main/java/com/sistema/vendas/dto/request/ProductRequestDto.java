package com.sistema.vendas.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDto {

    public String produtoNome;
    public double preco;
    public double precoCompra;
    public int Quantidade;
}
