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
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

public class add_stock extends AppCompatActivity {

    EditText inputId, inputStock;
    String idProd, countStock;
    Integer intStock, addStock, totalStock;
    Button btnAddStock, btnCheckStock;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://projek2-5acb9-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);

        inputId = findViewById(R.id.eTidprod);
        inputStock = findViewById(R.id.eTstock);
        btnAddStock = findViewById(R.id.buttonAddStock);
        btnCheckStock = findViewById(R.id.buttonCheckStock);

    }

    public void STOCKCOUNT (View view) {
        idProd = inputId.getText().toString();
        countStock = inputStock.getText().toString();
        addStock = Integer.parseInt(countStock);

        if (idProd.isEmpty() || countStock.isEmpty()) {
            Toast.makeText(add_stock.this, "Silakan isi ID produk dan jumlah stok yang ditambah", Toast.LENGTH_LONG).show();

        } else {
            databaseReference.child("product").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(idProd)) {
                        intStock = Integer.parseInt(snapshot.child(idProd).child("stock").getValue(String.class));
                        totalStock = intStock += addStock;
                        String finalStock = String.valueOf(totalStock);

                        databaseReference.child("product").child(idProd).child("stock").setValue(finalStock);

                        Toast.makeText(add_stock.this, "Jumlah stok berhasil diperbarui", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(add_stock.this, "ID produk tidak ditemukan", Toast.LENGTH_LONG).show();

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }


    }

    public void VIEWPROD (View view) {
        Intent intent = new Intent(add_stock.this, product.class);
        startActivity(intent);
    }
}