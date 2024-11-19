package com.sistema.vendas.service;

import com.sistema.vendas.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product>getAllProdutos();
    String createProduto(Product product);
    String updateStockProduct(Product productUpdate);
    Product getProductById(Long id);
    String removeProductById(Long id);
}
