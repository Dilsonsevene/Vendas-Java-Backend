package com.sistema.vendas.controller;


import com.sistema.vendas.dto.request.ProductRequestDto;
import com.sistema.vendas.dto.request.ProductUpdateDto;
import com.sistema.vendas.dto.response.ProductResponseDto;
import com.sistema.vendas.mapper.Mapper;
import com.sistema.vendas.model.Product;
import com.sistema.vendas.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final Mapper mapper;
    private final ProductService productService;



    @GetMapping("")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        return ResponseEntity.ok(mapper.mapProductListToResponseDtoList(
           productService.getAllProdutos()
        ));
    }

    @PostMapping("/")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequestDto productRequestDto){
        return new ResponseEntity<>(productService.createProduto(
                mapper.mapProductRequestToModel(productRequestDto)),
                HttpStatus.CREATED
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(mapper.mapProductResponseDto(
           productService.getProductById(id)
        ));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeProductById(@PathVariable Long id) {
        try {
            productService.removeProductById(id);
            String responseMessage = "O produto com ID: " + id + "foi removido com sucesso";
            return ResponseEntity.ok(responseMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto nao encotrado");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String>updateStockProduct(@RequestBody ProductUpdateDto productUpdateDto){
        return new ResponseEntity<>(productService.updateStockProduct(
                mapper.mapProductUpdateToModel(productUpdateDto)),
                HttpStatus.CREATED
        );
    }
}
