package com.example.projek2_asus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class New_Reg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reg);
    }

    public void SIGN (View view) {
        Intent intent = new Intent(New_Reg.this, Already.class);
        startActivity(intent);
    }

}