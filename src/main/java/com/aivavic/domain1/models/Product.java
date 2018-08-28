package com.aivavic.domain1.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;

    @ElementCollection
    Set<IngredientCount> ingredientCounts = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<IngredientCount> getIngredientCounts() {
        return ingredientCounts;
    }

    public void setIngredientCounts(Set<IngredientCount> ingredientCounts) {
        this.ingredientCounts = ingredientCounts;
    }
}
