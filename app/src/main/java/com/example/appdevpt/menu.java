package com.example.appdevpt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button productsButton = findViewById(R.id.products_button);
        Button offersButton = findViewById(R.id.offers_button);
        Button cartButton = findViewById(R.id.cart_button);
        Button profileButton = findViewById(R.id.profile_button);

        productsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, product.class);
                startActivity(intent);
            }
        });

        offersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle navigation to OffersActivity
            }
        });

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle navigation to CartActivity
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle navigation to ProfileActivity
                Intent intent = new Intent(menu.this, Profile.class);
                startActivity(intent);
            }
        });

    }
}