package com.aivavic.domain1.vo;

import com.aivavic.domain1.models.IngredientCount;
import lombok.Data;

import java.util.Set;
@Data
public class ProductRequest {
    String name;
    Set<IngredientCount> ingredientCounts;
}
