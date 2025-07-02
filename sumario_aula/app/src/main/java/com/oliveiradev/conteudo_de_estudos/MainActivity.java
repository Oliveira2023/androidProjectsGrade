package com.oliveiradev.conteudo_de_estudos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnSumario;
    private Button btnConteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSumario = findViewById(R.id.btnSumario);
        btnConteudo = findViewById(R.id.btnConteudo);

        Conteudo conteudoFragment = new Conteudo();
        Sumario sumarioFragment = new Sumario();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainframe, conteudoFragment)
                .commit();

        btnSumario.setOnClickListener(v -> {
                    Toast.makeText(this, "Btn1 clicado", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.mainframe, sumarioFragment)
                            .commit();
                }
                );

        btnConteudo.setOnClickListener(v -> {
                    Toast.makeText(this, "Btn2 clicado", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.mainframe, conteudoFragment)
                            .commit();
                }
        );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}