package com.example.pantrypal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PantryAdapter adapter;
    private DatabaseHelper db;

    private Button btnAdd;
    private Button btnRecipes;
    private Button btnDeleteIngredient;
    private Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);
        btnRecipes = findViewById(R.id.btnRecipes);

        db = new DatabaseHelper(this);

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddPantryItemActivity.class);
            startActivity(intent);
        });

        btnRecipes.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SuggestedRecipesActivity.class);
            startActivity(intent);
        });
        btnDeleteIngredient =
                findViewById(R.id.btnDeleteIngredient);

        btnDeleteIngredient.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            DeleteIngredientActivity.class);

            startActivity(intent);
        });
        btnSettings =
                findViewById(R.id.btnSettings);

        btnSettings.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            MainActivity.this,
                            SettingsActivity.class));
        });


        loadPantryItems();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadPantryItems();
    }

    private void loadPantryItems() {
        List<PantryItem> pantryItems = db.getAllPantryItems();
        adapter = new PantryAdapter(this, pantryItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        checkExpiredIngredients();
    }

    private void checkExpiredIngredients() {
        List<PantryItem> items = db.getAllPantryItems();
        int expiredCount = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date today = new Date();

        for (PantryItem item : items) {
            if (item.getExpiryDate() != null && !item.getExpiryDate().isEmpty()) {
                try {
                    Date expiryDate = sdf.parse(item.getExpiryDate());
                    if (expiryDate != null && expiryDate.before(today)) {
                        expiredCount++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        TextView txtExpiryWarning = findViewById(R.id.txtExpiryWarning);

        if (expiredCount > 0) {
            if (txtExpiryWarning != null) {
                txtExpiryWarning.setVisibility(View.VISIBLE);
                txtExpiryWarning.setText("⚠ " + expiredCount + " expired ingredient(s) found");
            }

            new AlertDialog.Builder(this)
                    .setTitle("Expired Ingredients")
                    .setMessage("You have " + expiredCount + " expired ingredient(s) in your pantry.")
                    .setPositiveButton("OK", null)
                    .show();
        } else if (txtExpiryWarning != null) {
            txtExpiryWarning.setVisibility(View.GONE);
        }
    }
}
