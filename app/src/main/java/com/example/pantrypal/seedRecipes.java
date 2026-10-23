package com.example.pantrypal;

import android.content.Context;

public class seedRecipes {

    public static void seedRecipes(Context context) {
        DatabaseHelper db = new DatabaseHelper(context);

        long id;

        // 1. Pancakes
        id = db.addRecipe(new Recipe(0,
                "Pancakes",
                "Mix flour, eggs and milk. Fry until golden."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Flour", 200, "g"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Eggs", 2, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Milk", 500, "ml"));

        // 2. Omelette
        id = db.addRecipe(new Recipe(0,
                "Omelette",
                "Beat eggs and cook in a pan."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Eggs", 3, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Salt", 1, "tsp"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Oil", 1, "tbsp"));

        // 3. Spaghetti
        id = db.addRecipe(new Recipe(0,
                "Spaghetti",
                "Cook pasta and combine with sauce."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Spaghetti", 200, "g"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Tomato Sauce", 150, "ml"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Salt", 1, "tsp"));

        // 4. Salad
        id = db.addRecipe(new Recipe(0,
                "Salad",
                "Mix vegetables and serve."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Lettuce", 100, "g"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Tomato", 2, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Cucumber", 1, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Olive Oil", 2, "tbsp"));

        // 5. Fried Rice
        id = db.addRecipe(new Recipe(0,
                "Fried Rice",
                "Stir fry rice and vegetables."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Rice", 200, "g"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Carrot", 1, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Peas", 50, "g"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Soy Sauce", 2, "tbsp"));

        // 6. Grilled Cheese Sandwich
        id = db.addRecipe(new Recipe(0,
                "Grilled Cheese Sandwich",
                "Toast bread with cheese."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Bread", 2, "slices"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Cheese", 2, "slices"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Butter", 1, "tbsp"));

        // 7. Garlic Bread
        id = db.addRecipe(new Recipe(0,
                "Garlic Bread",
                "Spread garlic butter and bake."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Bread", 4, "slices"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Garlic", 2, "cloves"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Butter", 2, "tbsp"));

        // 8. Scrambled Eggs
        id = db.addRecipe(new Recipe(0,
                "Scrambled Eggs",
                "Whisk eggs and cook gently."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Eggs", 3, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Milk", 50, "ml"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Butter", 1, "tbsp"));

        // 9. French Toast
        id = db.addRecipe(new Recipe(0,
                "French Toast",
                "Dip bread in egg mixture and fry."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Bread", 4, "slices"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Eggs", 2, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Milk", 100, "ml"));

        // 10. Tomato Soup
        id = db.addRecipe(new Recipe(0,
                "Tomato Soup",
                "Cook tomatoes and blend."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Tomato", 4, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Water", 500, "ml"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Salt", 1, "tsp"));

        // 11. Smoothie
        id = db.addRecipe(new Recipe(0,
                "Banana Smoothie",
                "Blend everything together."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Banana", 2, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Milk", 250, "ml"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Honey", 1, "tbsp"));

        // 12. Chicken Wrap
        id = db.addRecipe(new Recipe(0,
                "Chicken Wrap",
                "Fill wrap and roll."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Chicken", 200, "g"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Tortilla", 2, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Lettuce", 50, "g"));

        // 13. Veggie Stir Fry
        id = db.addRecipe(new Recipe(0,
                "Veggie Stir Fry",
                "Cook vegetables quickly over high heat."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Broccoli", 100, "g"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Carrot", 1, "pcs"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Soy Sauce", 2, "tbsp"));

        // 14. Pizza Toast
        id = db.addRecipe(new Recipe(0,
                "Pizza Toast",
                "Top bread and bake."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Bread", 2, "slices"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Tomato Sauce", 2, "tbsp"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Cheese", 50, "g"));

        // 15. Tuna Salad
        id = db.addRecipe(new Recipe(0,
                "Tuna Salad",
                "Mix ingredients and chill."));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Tuna", 1, "can"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Lettuce", 100, "g"));
        db.addRecipeIngredient(new RecipeIngredient(0, (int) id, "Tomato", 2, "pcs"));
        System.out.println(
                db.getAllRecipes().size());
    }

}
