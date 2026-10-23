package com.example.pantrypal;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private int id;
    private String name;
    private String steps;
    private List<RecipeIngredient> requiredIngredients;

    public Recipe(int id,
                  String name,
                  String steps) {

        this.id = id;
        this.name = name;
        this.steps = steps;
        this.requiredIngredients = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSteps() {
        return steps;
    }

    public List<RecipeIngredient> getRequiredIngredients() {
        return requiredIngredients;
    }

    public void setRequiredIngredients(
            List<RecipeIngredient> requiredIngredients) {

        this.requiredIngredients = requiredIngredients;
    }
}
