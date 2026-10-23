package com.example.pantrypal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {

    private TextView txtRecipeName;
    private TextView txtIngredients;
    private TextView txtSteps;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        txtRecipeName = findViewById(R.id.txtRecipeName);
        txtIngredients = findViewById(R.id.txtIngredients);
        txtSteps = findViewById(R.id.txtSteps);

        db = new DatabaseHelper(this);

        int recipeId =
                getIntent().getIntExtra(
                        "recipe_id",
                        -1);

        loadRecipe(recipeId);
    }

    private void loadRecipe(int recipeId) {

        Recipe recipe =
                db.getRecipeById(recipeId);

        if(recipe == null){
            return;
        }

        txtRecipeName.setText(
                recipe.getName());

        List<RecipeIngredient> ingredients =
                recipe.getRequiredIngredients();

        StringBuilder ingredientText =
                new StringBuilder();

        for(RecipeIngredient ingredient :
                ingredients){

            ingredientText.append("• ")
                    .append(
                            ingredient.getIngredientName())
                    .append(" - ")
                    .append(
                            ingredient.getRequiredQty())
                    .append(" ")
                    .append(
                            ingredient.getUnit())
                    .append("\n");
        }

        txtIngredients.setText(
                ingredientText.toString());

        txtSteps.setText(
                recipe.getSteps());
    }
}