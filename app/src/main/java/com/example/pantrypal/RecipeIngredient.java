package com.example.pantrypal;

public class RecipeIngredient {

    private int id;
    private int recipeId;
    private String ingredientName;
    private double requiredQty;
    private String unit;

    public RecipeIngredient(int id,
                            int recipeId,
                            String ingredientName,
                            double requiredQty,
                            String unit) {

        this.id = id;
        this.recipeId = recipeId;
        this.ingredientName = ingredientName;
        this.requiredQty = requiredQty;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public double getRequiredQty() {
        return requiredQty;
    }

    public String getUnit() {
        return unit;
    }
}
