package com.aivavic.domain1.repository;

import com.aivavic.domain1.models.IngredientCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientCountRepository extends JpaRepository<IngredientCount, String> {
    Page<IngredientCount> findByProductId(String productId, Pageable pageable);
}
