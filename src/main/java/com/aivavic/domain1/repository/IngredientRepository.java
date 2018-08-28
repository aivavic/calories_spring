package com.aivavic.domain1.repository;

import com.aivavic.domain1.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
