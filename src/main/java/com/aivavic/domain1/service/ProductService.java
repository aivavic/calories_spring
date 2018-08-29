package com.aivavic.domain1.service;

import com.aivavic.domain1.models.Ingredient;
import com.aivavic.domain1.models.IngredientCount;
import com.aivavic.domain1.models.Product;
import com.aivavic.domain1.repository.IngredientRepository;
import com.aivavic.domain1.repository.ProductRepository;
import com.aivavic.domain1.vo.ProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(ProductRequest request) {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(request.getName());
        float calories = 0;
        for (IngredientCount ingredient : request.getIngredientCounts()) {

            this.logger.info("Ингредиент " + ingredient.toString());
            this.logger.info("Ингредиент " + ingredient.getIngredient().getId());
            Optional<Ingredient> ing = ingredientRepository.findById(ingredient.getIngredient().getId());
            if(ing.isPresent()){
                Ingredient ingredient1 = ing.get();
                calories = calories + ((ingredient.getCount() * ingredient1.getCalories())/100);
            }

            product.getIngredientCounts().add(ingredient);
        }
        this.logger.info("Всего каллорий: " + calories);
        product.setCalories(calories);
        return this.productRepository.save(product);
    }

    public Iterable<Product> findAll() {
        return this.productRepository.findAll();
    }
}
