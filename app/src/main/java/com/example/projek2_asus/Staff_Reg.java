package com.example.projek2_asus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.StaleDataException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Staff_Reg extends AppCompatActivity {

    EditText inputUser, inputPass, conPass;
    String username, password, conpassword;
    Button btnRegister;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://projek2-5acb9-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_reg);

        inputUser = findViewById(R.id.eTusername);
        inputPass = findViewById(R.id.eTpassword);
        conPass = findViewById(R.id.eTconpassword);
        btnRegister = findViewById(R.id.buttonStaffReg);
    }

    public void SIGN (View view) {

        username = inputUser.getText().toString();
        password = inputPass.getText().toString();
        conpassword = conPass.getText().toString();

        if (username.isEmpty() || password.isEmpty() || conpassword.isEmpty()) {
            Toast.makeText(Staff_Reg.this, "Silakan isi semua kolom", Toast.LENGTH_LONG).show();
        }

        else if (!password.equals(conpassword)) {
            Toast.makeText(Staff_Reg.this, "Kata sandi tidak cocok", Toast.LENGTH_LONG).show();
        }

        else {
            databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(username)) {
                        Toast.makeText(Staff_Reg.this, "Username telah terdaftar", Toast.LENGTH_LONG).show();

                    } else {
                        databaseReference.child("users").child(username).child("as").setValue("staff");
                        databaseReference.child("users").child(username).child("password").setValue(password);

                        Toast.makeText(Staff_Reg.this, "Pendaftaran berhasil", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(Staff_Reg.this, Admin_Page.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

    }

}