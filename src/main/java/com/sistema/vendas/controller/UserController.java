package com.sistema.vendas.controller;


import com.sistema.vendas.dto.request.UserRequestDto;
import com.sistema.vendas.dto.response.ProductResponseDto;
import com.sistema.vendas.dto.response.UserResponseDto;
import com.sistema.vendas.mapper.Mapper;
import com.sistema.vendas.model.User;
import com.sistema.vendas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final Mapper mapper;

    @PostMapping("")
    public ResponseEntity<String>createUser(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.createUser(
                mapper.mapUserRequestToModel(userRequestDto)),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(mapper.mapUserResponseDto(
                userService.getUserById(id)
        ));
    }
}
