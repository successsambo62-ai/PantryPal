package com.example.pantrypal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteIngredientActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnDelete;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_ingredient);

        etName = findViewById(R.id.etName);
        btnDelete = findViewById(R.id.btnDelete);

        db = new DatabaseHelper(this);

        btnDelete.setOnClickListener(v -> {

            String name =
                    etName.getText()
                            .toString()
                            .trim();

            if (name.isEmpty()) {

                Toast.makeText(
                        this,
                        "Please enter ingredient name",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            int rowsDeleted =
                    db.deletePantryItemByName(name);

            if (rowsDeleted > 0) {

                Toast.makeText(
                        this,
                        "Ingredient deleted successfully",
                        Toast.LENGTH_SHORT
                ).show();

                finish();

            } else {

                Toast.makeText(
                        this,
                        "Ingredient not found",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
