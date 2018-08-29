package com.aivavic.domain1.service;

import com.aivavic.domain1.models.IngredientCount;
import com.aivavic.domain1.models.Product;
import com.aivavic.domain1.repository.ProductRepository;
import com.aivavic.domain1.vo.ProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(ProductRequest request) {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(request.getName());
        for (IngredientCount ingredient : request.getIngredientCounts()) {
            product.getIngredientCounts().add(ingredient);
        }
        return this.productRepository.save(product);
    }

    public Iterable<Product> findAll() {
        return this.productRepository.findAll();
    }
}
