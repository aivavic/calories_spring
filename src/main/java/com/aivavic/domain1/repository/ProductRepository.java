package com.aivavic.domain1.repository;

import com.aivavic.domain1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
