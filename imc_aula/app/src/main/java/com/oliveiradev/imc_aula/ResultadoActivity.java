package com.oliveiradev.imc_aula;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class ResultadoActivity extends AppCompatActivity {

    TextView resultado_peso;
    TextView resultado;
    double imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        resultado_peso = findViewById(R.id.resultado_peso);
        resultado = findViewById(R.id.resultado);

        imc = getIntent().getDoubleExtra("imc", 0.00);
        resultado_peso.setText(String.format(Locale.getDefault(), "%.2f", imc));

        calculoImc(imc);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void calculoImc(double imc) {
        if (imc < 18.5) {
            resultado.setText(R.string.abaixo_peso);
        } else if (imc < 24.9) {
            resultado.setText(R.string.peso_normal);
        } else if (imc < 29.9) {
            resultado.setText(R.string.sobrepeso);
        } else if (imc < 34.9) {
            resultado.setText(R.string.obesidade_1);
        } else if (imc < 39.9) {
            resultado.setText(R.string.obesidade_2);
        } else {
            resultado.setText(R.string.obesidade_3);
        }
    }
}