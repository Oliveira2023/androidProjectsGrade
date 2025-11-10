package com.oliveiradev.meusfornecedores;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fornecedor> fornecedores = new ArrayList<>();
    private RecyclerView recyclerViewFornecedores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fornecedores.add(new Fornecedor("12345", "Descrição do Fornecedor 1", "São Paulo", "1234567890"));
        fornecedores.add(new Fornecedor("23456", "Descrição do Fornecedor 2", "Rio de Janeiro", "9876543210"));
        fornecedores.add(new Fornecedor("34567", "Descrição do Fornecedor 3", "Belo Horizonte", "5555555555"));

        recyclerViewFornecedores = findViewById(R.id.main);
        ListagemAdaptador adapter = new ListagemAdaptador(fornecedores);
        recyclerViewFornecedores.setLayoutManager(new LinearLayoutManager(this));


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewFornecedores.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewFornecedores.addItemDecoration(dividerItemDecoration);

        recyclerViewFornecedores.setAdapter(adapter);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}