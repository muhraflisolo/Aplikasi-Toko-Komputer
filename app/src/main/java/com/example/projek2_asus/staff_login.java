package com.example.projek2_asus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class staff_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);
    }

    public void STF (View view) {
        Intent intent = new Intent(staff_login.this, add_stock.class);
        startActivity(intent);
    }

}