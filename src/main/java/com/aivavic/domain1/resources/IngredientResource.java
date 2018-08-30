package com.aivavic.domain1.resources;

import com.aivavic.domain1.models.Ingredient;
import com.aivavic.domain1.service.IngredientService;
import com.aivavic.domain1.vo.IngredientRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ingredient")
@Api(tags = "ingredient", description = "Ingredient API")
public class IngredientResource {
    private final IngredientService ingredientService;
    private final Logger logger = LoggerFactory.getLogger(IngredientResource.class);

    public IngredientResource(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    @ApiOperation(value = "Create ingredient", notes = "It permits to create a new ingredient")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ingredient created successfully"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Ingredient> newIngredient(@RequestBody IngredientRequest ingredient) {
        return new ResponseEntity<>(this.ingredientService.create(ingredient), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "List ingredients", notes = "List all ingredients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ingredients found"),
            @ApiResponse(code = 404, message = "Ingredients not found")
    })
    public ResponseEntity<Iterable<Ingredient>> findAll() {
        return ResponseEntity.ok(this.ingredientService.findAll());
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find ingredient", notes = "Find the Ingredient by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ingredient found"),
            @ApiResponse(code = 404, message = "Ingredient not found"),
    })
    public ResponseEntity<Ingredient> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.ingredientService.findOne(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update ingredient", notes = "It permits to update a ingredient")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ingredient update successfully"),
            @ApiResponse(code = 404, message = "Ingredient not found"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable("id") String id, IngredientRequest ingredient) {
        Ingredient found = this.ingredientService.findOne(id);
        found.setName(ingredient.getName());
        found.setCalories(ingredient.getCalories());
        found.setCarbohydrates(ingredient.getCarbohydrates());
        found.setProteins(ingredient.getProteins());
        found.setGrease(ingredient.getGrease());
        return new ResponseEntity<>(this.ingredientService.update(found), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove Ingredient",notes = "It permits to remove a Ingredient")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Ingredient removed successfully"),
            @ApiResponse(code = 404,message = "Ingredient not found")
    })
    public void removeCategory(@PathVariable("id") String id){ingredientService.delete(id);}
}
