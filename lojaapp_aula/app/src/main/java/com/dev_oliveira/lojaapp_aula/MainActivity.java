package com.dev_oliveira.lojaapp_aula;

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

    private List<Product> productList;
    RecyclerView mainRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();
        productList.add(new Product("Camiseta", 29.99F, R.drawable.camiseta_azul));
        productList.add(new Product("Calça", 59.99F, R.drawable.jeans));
        productList.add(new Product("Tênis", 99.99F, R.drawable.tenis));
        productList.add(new Product("Meia", 19.99F));
        productList.add(new Product("Blusa", 39.99F));
        productList.add(new Product("Sapato", 79.99F));
        productList.add(new Product("Bermuda", 49.99F));
        productList.add(new Product("Jaqueta", 69.99F));
        productList.add(new Product("Vestido", 89.99F));
        productList.add(new Product("Saia", 59.99F));
        productList.add(new Product("Blusa", 39.99F));
        productList.add(new Product("Sapato", 79.99F));
        productList.add(new Product("Bermuda", 49.99F));
        productList.add(new Product("Jaqueta", 69.99F));
        productList.add(new Product("Vestido", 89.99F));

        // instancia o recyclerView
        mainRV = findViewById(R.id.mainRV);
        mainRV.setHasFixedSize(true);

        // define os items que serão exibidos no reciclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mainRV.setLayoutManager(layoutManager);

        // adiciona uma linha entre cada item da listagem
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        mainRV.addItemDecoration(itemDecoration);

        // define adapter para recycler view
        Adaptador adaptador = new Adaptador();
        mainRV.setAdapter(adaptador);
        adaptador.atualizarLista(productList);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainRV), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}