package com.example.gadsdtchoferes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity3 extends AppCompatActivity {

    TextView tvListaChoferes;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitivy_main3);

        tvListaChoferes = findViewById(R.id.tvListaChoferes);
        btnRegresar = findViewById(R.id.btnRegresar);

        btnRegresar.setOnClickListener(v -> finish());

        obtenerChoferes();
    }

    private void obtenerChoferes() {
        String url = "https://uteqia.com/api/choferes";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                response -> {
                    try {
                        JSONArray array = new JSONArray(response);
                        StringBuilder lista = new StringBuilder();

                        for (int i = 0; i < array.length(); i++) {
                            JSONObject chofer = array.getJSONObject(i);
                            String nombre = chofer.getString("nombre");
                            String cedula = chofer.getString("cedula");

                            lista.append("Nombre: ").append(nombre).append("\n");
                            lista.append("Cédula: ").append(cedula).append("\n\n");
                        }

                        tvListaChoferes.setText(lista.toString());

                    } catch (Exception e) {
                        tvListaChoferes.setText("Error al procesar datos");
                        e.printStackTrace();
                    }
                },
                error -> {
                    tvListaChoferes.setText("Error de conexión");
                    Toast.makeText(this, "No se pudo conectar a la API", Toast.LENGTH_SHORT).show();
                });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
