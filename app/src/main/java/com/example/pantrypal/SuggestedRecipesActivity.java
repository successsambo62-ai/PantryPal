package com.example.pantrypal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SuggestedRecipesActivity extends AppCompatActivity {

    private RecyclerView recyclerRecipes;
    private TextView txtRecipeCount;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_recipes);

        recyclerRecipes = findViewById(R.id.recyclerRecipes);
        txtRecipeCount = findViewById(R.id.txtRecipeCount);

        db = new DatabaseHelper(this);

        loadSuggestedRecipes();
    }

    private void loadSuggestedRecipes() {
        List<PantryItem> pantryItems = db.getAllPantryItems();
        List<Recipe> recipes = db.getAllRecipes();

        for (Recipe recipe : recipes) {
            if (recipe.getRequiredIngredients() == null || recipe.getRequiredIngredients().isEmpty()) {
                recipe.setRequiredIngredients(db.getIngredientsForRecipe(recipe.getId()));
            }
        }

        List<Recipe> suggestedRecipes = RecipeMatcher.getSuggestedRecipes(
                pantryItems,
                recipes);

        txtRecipeCount.setText(suggestedRecipes.size() + " recipe(s) found");

        RecipeAdapter adapter = new RecipeAdapter(suggestedRecipes);

        recyclerRecipes.setLayoutManager(new LinearLayoutManager(this));
        recyclerRecipes.setAdapter(adapter);
    }
}
