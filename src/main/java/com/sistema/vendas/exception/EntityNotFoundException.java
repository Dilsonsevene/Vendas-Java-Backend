package com.sistema.vendas.exception;

public class EntityNotFoundException extends BadRequestException{

    public EntityNotFoundException(String message) {
        super(message);
    }
}
