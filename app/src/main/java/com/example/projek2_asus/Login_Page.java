package com.example.projek2_asus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void ADM (View view) {
        Intent intent = new Intent(Login_Page.this, admin_login.class);
        startActivity(intent);
    }

    public void ABOUTME (View view) {
        Intent intent = new Intent(Login_Page.this, About.class);
        startActivity(intent);
    }

    public void STAFFLOG (View view) {
        Intent intent = new Intent(Login_Page.this, staff_login.class);
        startActivity(intent);
    }

    public void NEWUS (View view) {
        Intent intent = new Intent(Login_Page.this, New_Reg.class);
        startActivity(intent);
    }

    public void ALREADY (View view) {
        Intent intent = new Intent(Login_Page.this, Already.class);
        startActivity(intent);
    }

}