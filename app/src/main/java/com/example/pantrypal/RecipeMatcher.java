package com.example.pantrypal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RecipeMatcher {

    public static List<Recipe> getSuggestedRecipes(
            List<PantryItem> pantryItems,
            List<Recipe> recipes) {

        List<Recipe> suggestedRecipes = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date today = new Date();

        for (Recipe recipe : recipes) {
            boolean canCook = true;

            if (recipe.getRequiredIngredients() == null) {
                continue;
            }

            for (RecipeIngredient ingredient : recipe.getRequiredIngredients()) {
                boolean found = false;

                for (PantryItem pantryItem : pantryItems) {
                    if (pantryItem.getName().equalsIgnoreCase(ingredient.getIngredientName())
                            && pantryItem.getQuantity() >= ingredient.getRequiredQty()
                            && pantryItem.getUnit().equalsIgnoreCase(ingredient.getUnit())) {

                        if (pantryItem.getExpiryDate() != null && !pantryItem.getExpiryDate().isEmpty()) {
                            try {
                                Date expiryDate = sdf.parse(pantryItem.getExpiryDate());
                                if (expiryDate != null && expiryDate.before(today)) {
                                    continue;
                                }
                            } catch (Exception ignored) {
                            }
                        }

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    canCook = false;
                    break;
                }
            }

            if (canCook) {
                suggestedRecipes.add(recipe);
            }
        }

        return suggestedRecipes;
    }
}
