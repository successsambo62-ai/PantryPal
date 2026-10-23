package com.example.pantrypal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddPantryItemActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etQuantity;
    private EditText etUnit;
    private EditText etExpiryDate;

    private Button btnSave;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pantry_item);

        etName = findViewById(R.id.etName);
        etQuantity = findViewById(R.id.etQuantity);
        etUnit = findViewById(R.id.etUnit);
        etExpiryDate = findViewById(R.id.etExpiryDate);

        btnSave = findViewById(R.id.btnSave);

        db = new DatabaseHelper(this);

        btnSave.setOnClickListener(v -> {

            String name =
                    etName.getText().toString().trim();

            String quantityText =
                    etQuantity.getText().toString().trim();

            String unit =
                    etUnit.getText().toString().trim();

            String expiryDate =
                    etExpiryDate.getText().toString().trim();

            if (name.isEmpty()
                    || quantityText.isEmpty()
                    || unit.isEmpty()
                    || expiryDate.isEmpty()) {

                Toast.makeText(
                        this,
                        "Please complete all fields",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            double quantity;

            try {

                quantity =
                        Double.parseDouble(quantityText);

            } catch (NumberFormatException e) {

                Toast.makeText(
                        this,
                        "Enter a valid quantity",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            PantryItem item =
                    new PantryItem(
                            name,
                            quantity,
                            unit,
                            expiryDate
                    );

            long result =
                    db.addPantryItem(item);

            if (result > 0) {

                Toast.makeText(
                        this,
                        "Ingredient saved successfully",
                        Toast.LENGTH_SHORT
                ).show();

                finish();

            } else {

                Toast.makeText(
                        this,
                        "Failed to save ingredient",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
