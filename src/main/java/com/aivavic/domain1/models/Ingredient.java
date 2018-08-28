package com.aivavic.domain1.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;
    private float calories;
    private float carbohydrates;
    private float proteins;
    private float grease;


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

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public float getProteins() {
        return proteins;
    }

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public float getGrease() {
        return grease;
    }

    public void setGrease(float grease) {
        this.grease = grease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;

        Ingredient that = (Ingredient) o;

        if (Float.compare(that.getCalories(), getCalories()) != 0) return false;
        if (Float.compare(that.getCarbohydrates(), getCarbohydrates()) != 0) return false;
        if (Float.compare(that.getProteins(), getProteins()) != 0) return false;
        if (Float.compare(that.getGrease(), getGrease()) != 0) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCalories() != +0.0f ? Float.floatToIntBits(getCalories()) : 0);
        result = 31 * result + (getCarbohydrates() != +0.0f ? Float.floatToIntBits(getCarbohydrates()) : 0);
        result = 31 * result + (getProteins() != +0.0f ? Float.floatToIntBits(getProteins()) : 0);
        result = 31 * result + (getGrease() != +0.0f ? Float.floatToIntBits(getGrease()) : 0);
        return result;
    }
}
