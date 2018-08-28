package com.aivavic.domain1.service;

import com.aivavic.domain1.exceptions.IngredientNotFoundException;
import com.aivavic.domain1.models.Ingredient;
import com.aivavic.domain1.repository.IngredientRepository;
import com.aivavic.domain1.vo.IngredientRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient update(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    public Ingredient create(IngredientRequest request){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(UUID.randomUUID().toString());
        ingredient.setName(request.getName());
        ingredient.setCalories(request.getCalories());
        ingredient.setCarbohydrates(request.getCarbohydrates());
        ingredient.setProteins(request.getProteins());
        ingredient.setGrease(request.getGrease());
        return this.ingredientRepository.save(ingredient);
    }

    public void delete(String id){
        final Optional<Ingredient> ingredient = this.ingredientRepository.findById(id);
        if(ingredient.isPresent()){
            this.ingredientRepository.delete(ingredient.get());
        } else {
            throw new IngredientNotFoundException(id);
        }
    }

    public Iterable<Ingredient> findAll() {
        return this.ingredientRepository.findAll();
    }

    public Ingredient findOne(String id) {
        final Optional<Ingredient> ingredient = this.ingredientRepository.findById(id);
        if(ingredient.isPresent()){
            return ingredient.get();
        } else {
            throw new IngredientNotFoundException(id);
        }
    }
}
