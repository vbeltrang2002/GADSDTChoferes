package com.example.gadsdtchoferes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button btnChofer, btnVolqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnChofer = findViewById(R.id.btnChofer);
        btnVolqueta = findViewById(R.id.btnVolqueta);

        btnChofer.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        });

        btnVolqueta.setOnClickListener(v -> {
            // Aquí puedes poner otra actividad o funcionalidad
        });
    }
}
