package com.oliveiradev.conteudo_de_estudos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// 1. A classe do Adapter deve estender RecyclerView.Adapter e passar o ViewHolder.
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    // Lista de dados que o Adapter vai exibir
    private List<String> dataList;

    // Construtor para receber a lista de dados
    public MyAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    // 2. A classe ViewHolder representa a View de cada item da lista.
    // Ela precisa herdar de RecyclerView.ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            // Encontra a View no layout do item pelo ID
            itemTextView = itemView.findViewById(R.id.item_text);
        }
    }

    // 3. Método onCreateViewHolder:
    // Chamado quando o RecyclerView precisa de um novo ViewHolder para representar um item.
    // Aqui você "infla" (cria) a View a partir do XML do layout do item.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    // 4. Método onBindViewHolder:
    // Chamado para vincular os dados a um ViewHolder existente.
    // Pega os dados na posição 'position' e coloca no ViewHolder.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String item = dataList.get(position);
        holder.itemTextView.setText(item);
    }

    // 5. Método getItemCount:
    // Retorna o número total de itens na lista.
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
