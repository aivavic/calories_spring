package com.aivavic.domain1.vo;

public class IngredientRequest {
    private String name;
    private float calories;
    private float carbohydrates;
    private float proteins;
    private float grease;

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
}
