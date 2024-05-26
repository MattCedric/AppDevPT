package com.example.appdevpt;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class cart extends AppCompatActivity {

    private LinearLayout layoutAddedItems;
    private TextView tvTotal;
    private double total = 0.00;
    private HashMap<String, Double> itemPrices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        layoutAddedItems = findViewById(R.id.layout_added_items);
        tvTotal = findViewById(R.id.tv_total);

        // Initialize item prices
        itemPrices = new HashMap<>();
        itemPrices.put("Carbonara", 8.00);
        itemPrices.put("Spaghetti", 7.50);
        itemPrices.put("Pansit", 6.50);
        itemPrices.put("Ramen", 9.00);
        itemPrices.put("Palabok", 7.00);
        itemPrices.put("Coke", 1.50);
        itemPrices.put("Cobra", 2.00);
        itemPrices.put("Water", 1.00);
        itemPrices.put("Mountain Dew", 1.75);
        itemPrices.put("Royal", 1.50);

        // Set up button click listeners
        setButtonListener(R.id.btn_add_carbonara, "Carbonara");
        setButtonListener(R.id.btn_add_spaghetti, "Spaghetti");
        setButtonListener(R.id.btn_add_pansit, "Pansit");
        setButtonListener(R.id.btn_add_ramen, "Ramen");
        setButtonListener(R.id.btn_add_palabok, "Palabok");
        setButtonListener(R.id.btn_add_coke, "Coke");
        setButtonListener(R.id.btn_add_cobra, "Cobra");
        setButtonListener(R.id.btn_add_water, "Water");
        setButtonListener(R.id.btn_add_mountain_dew, "Mountain Dew");
        setButtonListener(R.id.btn_add_royal, "Royal");

        // Set up back button
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(cart.this, menu.class);
            startActivity(intent);
            finish(); // Finish the current activity so it is removed from the back stack
        });
    }

    private void setButtonListener(int buttonId, String itemName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> addItem(itemName));
    }

    private void addItem(String itemName) {
        Double itemPrice = itemPrices.get(itemName);
        if (itemPrice != null) {
            total += itemPrice;
            updateTotal();
            addItemToView(itemName, itemPrice);
        }
    }

    private void updateTotal() {
        tvTotal.setText(String.format("Total: $%.2f", total));
    }

    private void addItemToView(String itemName, Double itemPrice) {
        TextView newItem = new TextView(this);
        newItem.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        newItem.setText(String.format("%s - $%.2f", itemName, itemPrice));
        layoutAddedItems.addView(newItem);
    }
}