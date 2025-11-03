package com.oliveiradev.recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Produto> mListProdutos;

    public Adapter(List<Produto> listProdutos) {
        mListProdutos = listProdutos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto produto = mListProdutos.get(position);
        holder.mTextViewDescricao.setText(produto.getDescr());
        holder.mTextViewValor.setText(String.valueOf(produto.getValor()));
    }

    @Override
    public int getItemCount() {
        if (mListProdutos == null) {
            return 0;
        }
        return mListProdutos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewDescricao, mTextViewValor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewDescricao = itemView.findViewById(R.id.textViewDescricao);
            mTextViewValor = itemView.findViewById(R.id.textViewValor);
        }
    }
}
