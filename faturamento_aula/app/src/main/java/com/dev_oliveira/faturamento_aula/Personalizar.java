package com.dev_oliveira.faturamento_aula;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Personalizar extends AppCompatActivity {

    private EditText mNomeEmpresa;
    private Button mBtnCadastrarNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personalizar);

        mNomeEmpresa = findViewById(R.id.nomeEmpresa);
        mBtnCadastrarNome = findViewById(R.id.btnCadastrarNome);

        mBtnCadastrarNome.setOnClickListener(view -> {
                    String nomeFantasia = mNomeEmpresa.getText().toString();
                    if (!nomeFantasia.isEmpty()) {
                        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.DADOS_FATURAMENTO, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("nomeFantasia", nomeFantasia);
                        editor.apply();
                        finish();
                    } else {
                        mNomeEmpresa.setError("Informe o nome da empresa");
                    }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}