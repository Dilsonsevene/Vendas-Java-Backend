package com.sistema.vendas.service.impl;

import com.sistema.vendas.exception.EntityNotFoundException;
import com.sistema.vendas.model.Product;
import com.sistema.vendas.repository.ProductRepository;
import com.sistema.vendas.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProdutos() {
        return productRepository.findAll();
    }

    @Override
    public String createProduto(Product product) {

        var result = productRepository.save(product);
        return "Dados registados com sucesso o Produto " + result.produtoNome;
    }

    @Override
    public String updateStockProduct(Product productUpdate) {

        Product product = getProductById(productUpdate.getId());
        int newQuantidade = product.getQuantidade() + productUpdate.getQuantidade();
        product.setQuantidade(newQuantidade);
        productRepository.save(product);
        return "Produto atualizado com sucesso";
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Produto Nao encontrado"));
    }

    @Override
    public String removeProductById(Long id) {
        productRepository.deleteById(id);
        return "Produto removido com sucesso";
    }
}
