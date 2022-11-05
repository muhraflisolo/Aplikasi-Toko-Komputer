package com.example.projek2_asus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
    }
    public void ADDSTAFF (View view) {
        Intent intent = new Intent(Admin_Page.this, Staff_Reg.class);
        startActivity(intent);
    }

    public void ADDSTOCK (View view) {
        Intent intent = new Intent(Admin_Page.this, add_stock.class);
        startActivity(intent);
    }
}