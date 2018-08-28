package com.aivavic.domain1.vo;

import lombok.Data;

@Data
public class IngredientRequest {
    private String name;
    private float calories;
    private float carbohydrates;
    private float proteins;
    private float grease;
}
