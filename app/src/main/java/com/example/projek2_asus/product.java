package com.example.projek2_asus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }

    public void LAPTOP (View view) {
        Intent intent = new Intent(product.this, LAPTOP.class);
        startActivity(intent);
    }

    public void SMARTPHONE (View view) {
        Intent intent = new Intent(product.this, SMARTPHONE.class);
        startActivity(intent);
    }

    public void HEADSET (View view) {
        Intent intent = new Intent(product.this, HEADSET.class);
        startActivity(intent);
    }

    public void KEYBOARD (View view) {
        Intent intent = new Intent(product.this, KEYBOARD.class);
        startActivity(intent);
    }
}