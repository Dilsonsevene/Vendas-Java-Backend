package com.sistema.vendas.mapper;

import com.sistema.vendas.dto.request.ProductRequestDto;
import com.sistema.vendas.dto.request.ProductUpdateDto;
import com.sistema.vendas.dto.request.UserRequestDto;
import com.sistema.vendas.dto.response.ProductResponseDto;
import com.sistema.vendas.dto.response.TokenResponseDto;
import com.sistema.vendas.dto.response.UserResponseDto;
import com.sistema.vendas.model.Product;
import com.sistema.vendas.model.Token;
import com.sistema.vendas.model.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper modelMapper;

    public ProductResponseDto mapProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .id(product.getId())
                .produtoNome(product.getProdutoNome())
                .preco(product.getPreco())
                .precoCompra(product.getPrecoCompra())
                .quantidade(product.getQuantidade())
                .build();
    }

    public List<ProductResponseDto> mapProductListToResponseDtoList(List<Product> products){
        return products.stream().map(this::mapProductResponseDto)
                .collect(Collectors.toList());
    }

    public Product mapProductRequestToModel(ProductRequestDto productRequestDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(productRequestDto,Product.class);
    }

    public Product mapProductUpdateToModel(ProductUpdateDto productUpdateDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(productUpdateDto,Product.class);
    }

    public User mapUserRequestToModel(UserRequestDto userRequestDto){
        return modelMapper.map(userRequestDto,User.class);
    }

    public UserResponseDto mapUserResponseDto(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public TokenResponseDto mapTokenResponseDto(Token token){
        return TokenResponseDto.builder()
                .accessToken(token.getToken())
                .build();
    }

}
