package com.example.pantrypal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PantryPal.db";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_PANTRY = "PantryItem";
    private static final String TABLE_RECIPE = "Recipe";
    private static final String TABLE_RECIPE_INGREDIENT = "RecipeIngredient";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createPantryTable =
                "CREATE TABLE " + TABLE_PANTRY + "(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "name TEXT," +
                        "quantity REAL," +
                        "unit TEXT," +
                        "expiryDate TEXT" +
                        ")";

        String createRecipeTable =
                "CREATE TABLE " + TABLE_RECIPE + "(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "name TEXT," +
                        "steps TEXT" +
                        ")";

        String createIngredientTable =
                "CREATE TABLE " + TABLE_RECIPE_INGREDIENT + "(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "recipeId INTEGER," +
                        "ingredientName TEXT," +
                        "requiredQty REAL," +
                        "unit TEXT" +
                        ")";

        db.execSQL(createPantryTable);
        db.execSQL(createRecipeTable);
        db.execSQL(createIngredientTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PANTRY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE_INGREDIENT);

        onCreate(db);
    }

    // =====================================
    // PANTRY CRUD
    // =====================================

    public long addPantryItem(PantryItem item) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", item.getName());
        values.put("quantity", item.getQuantity());
        values.put("unit", item.getUnit());
        values.put("expiryDate", item.getExpiryDate());

        long result =
                db.insert(TABLE_PANTRY,
                        null,
                        values);

        db.close();

        return result;
    }

    public List<PantryItem> getAllPantryItems() {

        List<PantryItem> items =
                new ArrayList<>();

        SQLiteDatabase db =
                getReadableDatabase();

        Cursor cursor =
                db.rawQuery(
                        "SELECT * FROM " + TABLE_PANTRY,
                        null);

        if(cursor.moveToFirst()) {

            do {

                PantryItem item =
                        new PantryItem(
                                cursor.getString(
                                        cursor.getColumnIndexOrThrow("name")),
                                cursor.getDouble(
                                        cursor.getColumnIndexOrThrow("quantity")),
                                cursor.getString(
                                        cursor.getColumnIndexOrThrow("unit")),
                                cursor.getString(
                                        cursor.getColumnIndexOrThrow("expiryDate"))
                        );

                item.setId(
                        cursor.getInt(
                                cursor.getColumnIndexOrThrow("id")));

                items.add(item);

            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return items;
    }

    public int updatePantryItem(PantryItem item) {

        SQLiteDatabase db =
                getWritableDatabase();

        ContentValues values =
                new ContentValues();

        values.put("name", item.getName());
        values.put("quantity", item.getQuantity());
        values.put("unit", item.getUnit());
        values.put("expiryDate", item.getExpiryDate());

        int result =
                db.update(
                        TABLE_PANTRY,
                        values,
                        "id=?",
                        new String[]{
                                String.valueOf(item.getId())
                        });

        db.close();

        return result;
    }

    public int deletePantryItem(int id) {

        SQLiteDatabase db =
                getWritableDatabase();

        int result =
                db.delete(
                        TABLE_PANTRY,
                        "id=?",
                        new String[]{
                                String.valueOf(id)
                        });

        db.close();

        return result;
    }

    public int deletePantryItemByName(String name) {

        SQLiteDatabase db =
                getWritableDatabase();

        int result =
                db.delete(
                        TABLE_PANTRY,
                        "name = ?",
                        new String[]{
                                name
                        });

        db.close();

        return result;
    }

    // =====================================
    // RECIPE CRUD
    // =====================================

    public long addRecipe(Recipe recipe) {

        SQLiteDatabase db =
                getWritableDatabase();

        ContentValues values =
                new ContentValues();

        values.put("name",
                recipe.getName());

        values.put("steps",
                recipe.getSteps());

        long result =
                db.insert(
                        TABLE_RECIPE,
                        null,
                        values);

        db.close();

        return result;
    }

    public List<Recipe> getAllRecipes() {

        List<Recipe> recipes =
                new ArrayList<>();

        SQLiteDatabase db =
                getReadableDatabase();

        Cursor cursor =
                db.rawQuery(
                        "SELECT * FROM "
                                + TABLE_RECIPE,
                        null);

        if(cursor.moveToFirst()) {

            do {

                Recipe recipe =
                        new Recipe(
                                cursor.getInt(
                                        cursor.getColumnIndexOrThrow("id")),
                                cursor.getString(
                                        cursor.getColumnIndexOrThrow("name")),
                                cursor.getString(
                                        cursor.getColumnIndexOrThrow("steps"))
                        );

                recipes.add(recipe);

            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recipes;
    }

    public Recipe getRecipeById(int recipeId) {

        SQLiteDatabase db =
                getReadableDatabase();

        Cursor cursor =
                db.rawQuery(
                        "SELECT * FROM Recipe WHERE id=?",
                        new String[]{
                                String.valueOf(recipeId)
                        });

        Recipe recipe = null;

        if(cursor.moveToFirst()) {

            recipe =
                    new Recipe(
                            cursor.getInt(
                                    cursor.getColumnIndexOrThrow("id")),
                            cursor.getString(
                                    cursor.getColumnIndexOrThrow("name")),
                            cursor.getString(
                                    cursor.getColumnIndexOrThrow("steps"))
                    );

            recipe.setRequiredIngredients(
                    getIngredientsForRecipe(recipeId));
        }

        cursor.close();

        return recipe;
    }

    // =====================================
    // RECIPE INGREDIENT CRUD
    // =====================================

    public long addRecipeIngredient(
            RecipeIngredient ingredient) {

        SQLiteDatabase db =
                getWritableDatabase();

        ContentValues values =
                new ContentValues();

        values.put(
                "recipeId",
                ingredient.getRecipeId());

        values.put(
                "ingredientName",
                ingredient.getIngredientName());

        values.put(
                "requiredQty",
                ingredient.getRequiredQty());

        values.put(
                "unit",
                ingredient.getUnit());

        long result =
                db.insert(
                        TABLE_RECIPE_INGREDIENT,
                        null,
                        values);

        db.close();

        return result;
    }

    public List<RecipeIngredient> getIngredientsForRecipe(
            int recipeId) {

        List<RecipeIngredient> ingredients =
                new ArrayList<>();

        SQLiteDatabase db =
                getReadableDatabase();

        Cursor cursor =
                db.rawQuery(
                        "SELECT * FROM "
                                + TABLE_RECIPE_INGREDIENT
                                + " WHERE recipeId=?",
                        new String[]{
                                String.valueOf(recipeId)
                        });

        if(cursor.moveToFirst()) {

            do {

                RecipeIngredient ingredient =
                        new RecipeIngredient(
                                cursor.getInt(
                                        cursor.getColumnIndexOrThrow("id")),
                                cursor.getInt(
                                        cursor.getColumnIndexOrThrow("recipeId")),
                                cursor.getString(
                                        cursor.getColumnIndexOrThrow("ingredientName")),
                                cursor.getDouble(
                                        cursor.getColumnIndexOrThrow("requiredQty")),
                                cursor.getString(
                                        cursor.getColumnIndexOrThrow("unit"))
                        );

                ingredients.add(ingredient);

            } while(cursor.moveToNext());
        }

        cursor.close();

        return ingredients;
    }
}
