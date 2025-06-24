package com.oliveiradev.imc_aula;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText altura;
    EditText peso;
    Button btn_calcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        altura = findViewById(R.id.altura);
        peso = findViewById(R.id.peso);
        btn_calcular = findViewById(R.id.btn_calcular);

        btn_calcular.setOnClickListener(v -> {
            String altura_str = altura.getText().toString().replace(",", ".");
            String peso_str = peso.getText().toString().replace(",", ".");
            if (!altura_str.isEmpty() && !peso_str.isEmpty()) {
                double altura_double = Double.parseDouble(altura_str);
                double peso_double = Double.parseDouble(peso_str);
                double imc = peso_double / (altura_double * altura_double);
                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtra("imc", imc);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}