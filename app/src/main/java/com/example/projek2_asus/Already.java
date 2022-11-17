package com.example.projek2_asus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Already extends AppCompatActivity {

    EditText inputUser, inputPass;
    String username, password, getPassword, getRole;
    Button btnLogin;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://projek2-5acb9-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already);

        inputUser = findViewById(R.id.eTusername);
        inputPass = findViewById(R.id.eTpassword);
        btnLogin = findViewById(R.id.buttonUserLogin);
    }
    public void PROD (View view) {

        username = inputUser.getText().toString();
        password = inputPass.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(Already.this, "Silakan isi username atau kata sandi", Toast.LENGTH_LONG).show();

        } else {
            databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(username)) {
                        getPassword = snapshot.child(username).child("password").getValue(String.class);
                        getRole = snapshot.child(username).child("as").getValue(String.class);

                        if (getPassword.equals(password)) {

                            if (getRole.equals("user")) {
                                Toast.makeText(Already.this, "Login berhasil", Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(Already.this, product.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(Already.this, "Username tidak terdaftar", Toast.LENGTH_LONG).show();

                            }

                        } else {
                            Toast.makeText(Already.this, "Kata sandi salah", Toast.LENGTH_LONG).show();

                        }
                    } else {
                        Toast.makeText(Already.this, "Username tidak terdaftar", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }

    }
}