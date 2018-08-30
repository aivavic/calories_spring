package com.aivavic.domain1.resources;

import com.aivavic.domain1.models.IngredientCount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/{productId}/ingredient_count")
@Api(tags="ingredientCount", description = "Вспомогательный локатор для количества ингредиентов")
public class IngredientCountResource {

    @GetMapping
    @ApiOperation(value = "List products", notes = "List all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "products found"),
            @ApiResponse(code = 404, message = "products not found")
    })
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok("ok");
    }
}
