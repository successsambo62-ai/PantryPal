package com.example.pantrypal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Switch switchNotifications;
    private Switch switchHideExpired;

    private EditText etWarningDays;

    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        switchNotifications =
                findViewById(R.id.switchNotifications);

        switchHideExpired =
                findViewById(R.id.switchHideExpired);

        etWarningDays =
                findViewById(R.id.etWarningDays);

        btnSave =
                findViewById(R.id.btnSaveSettings);

        loadSettings();

        btnSave.setOnClickListener(v -> saveSettings());
    }

    private void loadSettings() {

        SharedPreferences prefs =
                getSharedPreferences(
                        "PantryPalSettings",
                        MODE_PRIVATE);

        switchNotifications.setChecked(
                prefs.getBoolean(
                        "notifications",
                        true));

        switchHideExpired.setChecked(
                prefs.getBoolean(
                        "hideExpired",
                        true));

        etWarningDays.setText(
                String.valueOf(
                        prefs.getInt(
                                "warningDays",
                                7)));
    }

    private void saveSettings() {

        SharedPreferences prefs =
                getSharedPreferences(
                        "PantryPalSettings",
                        MODE_PRIVATE);

        SharedPreferences.Editor editor =
                prefs.edit();

        editor.putBoolean(
                "notifications",
                switchNotifications.isChecked());

        editor.putBoolean(
                "hideExpired",
                switchHideExpired.isChecked());

        editor.putInt(
                "warningDays",
                Integer.parseInt(
                        etWarningDays.getText().toString()));

        editor.apply();

        Toast.makeText(
                        this,
                        "Settings Saved",
                        Toast.LENGTH_SHORT)
                .show();

        finish();
    }
}
