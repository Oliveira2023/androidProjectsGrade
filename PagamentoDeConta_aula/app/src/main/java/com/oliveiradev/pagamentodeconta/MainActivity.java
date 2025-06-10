package com.oliveiradev.pagamentodeconta;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText mEditValor;
    private EditText mEditDinheiro;
    private TextView mTaxa;
    private TextView mTotal;
    private TextView mTroco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mEditValor = findViewById(R.id.edit_valor);
        mEditDinheiro = findViewById(R.id.edit_dinheiro);
        mTaxa = findViewById(R.id.taxa);
        mTotal = findViewById(R.id.total);
        mTroco = findViewById(R.id.troco);

        findViewById(R.id.btn_limpar).setOnClickListener(v -> {
            mEditValor.setText("");
            mEditDinheiro.setText("");
            mTaxa.setText("R$ 0");
            mTotal.setText("R$ 0");
            mTroco.setText("R$ 0");
        });

        findViewById(R.id.btn_calcular).setOnClickListener(v -> {
                    String valor = mEditValor.getText().toString();
                    String dinheiro = mEditDinheiro.getText().toString();
                    if (valor.isEmpty() || dinheiro.isEmpty()) {
                        return;
                    }

                    double valorConta = Double.parseDouble(valor);
                    double valorDinheiro = Double.parseDouble(dinheiro);
                    double taxa = valorConta * 0.1;
                    double total = valorConta + taxa;
                    double troco = valorDinheiro - total;

                    mTaxa.setText("R$ " + String.format("%.2f", taxa));
                    mTotal.setText("R$ " + String.format("%.2f", total));
                    mTroco.setText("R$ " + String.format("%.2f", troco));
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}