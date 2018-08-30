package com.aivavic.domain1.resources;

import com.aivavic.domain1.models.Product;
import com.aivavic.domain1.service.ProductService;
import com.aivavic.domain1.vo.ProductRequest;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
@Api(tags = "product", description = "Product API")
public class ProductResource {
    private final ProductService productService;
    private final Logger logger = LoggerFactory.getLogger(ProductResource.class);

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ApiOperation(value = "List products", notes = "List all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "products found"),
            @ApiResponse(code = 404, message = "products not found")
    })
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(this.productService.findAll());
    }

    /*{
        "ingredientCounts": [
        {
            "count": 200,
                "ingredient": {
            "id": "ff808181657810690165781408d50000"
        }
        }
  ],
        "name": "Борщ"
    }*/
    @PostMapping
    @ApiOperation(value = "Create product", notes = "It permits to create a new product")
    public ResponseEntity<?> newProduct(@RequestBody ProductRequest request, BindingResult result) {
        if (result.hasErrors()) {
            this.logger.info("Error validation");
            this.logger.info(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.productService.create(request), HttpStatus.CREATED);
    }
}
