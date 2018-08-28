package com.aivavic.domain1.exceptions;

import lombok.Getter;

public class IngredientNotFoundException extends RuntimeException {
    @Getter
    private final String id;

    public IngredientNotFoundException(String id){
        this.id = id;
    }
}
