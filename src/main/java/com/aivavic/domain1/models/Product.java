package com.aivavic.domain1.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "product")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = IngredientCount.class)
public class Product {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    Set<IngredientCount> ingredientCounts = new HashSet<>();

}
