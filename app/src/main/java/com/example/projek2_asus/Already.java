package com.example.projek2_asus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Already extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already);
    }
    public void PROD (View view) {
        Intent intent = new Intent(Already.this, product.class);
        startActivity(intent);
    }
}