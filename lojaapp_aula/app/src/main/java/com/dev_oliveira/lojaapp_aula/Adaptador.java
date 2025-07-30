package com.dev_oliveira.lojaapp_aula;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private List<Product> productList;

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        //recupera um produto do objeto List de acordo com a posçição recebida no parâmetro

        Product produto = productList.get(position);
        // exibimos os dados ddo item para o usuário através da referências criadas no viewholder
        holder.textviewDescricao.setText(produto.getDescricao());
        holder.textviewPreco.setText(String.format(Locale.getDefault(), "R$ %.2f", produto.getPreco()));
        holder.imageView.setImageResource(produto.getImagRes());

    }

    @Override
    public int getItemCount() {
        //retorna a quantidade de items que serão exibidos na tela
        if(productList != null){
            return productList.size();
        }
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textviewDescricao, textviewPreco;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textviewDescricao = itemView.findViewById(R.id.textviewDescricao);
            textviewPreco = itemView.findViewById(R.id.textviewPreco);
            imageView = itemView.findViewById(R.id.prodImage);
        }
    }
    public void atualizarLista(List<Product> lista){
        //atualiza a lista de produtos
        this.productList = lista;
        //notifica o adapter que a lista foi alterada
        notifyDataSetChanged();
    }

    public void inserir(Product produto){
        productList.add(produto);
        int position = this.productList.size()-1;
        notifyItemInserted(position);
    }
    public void remover(int posicao){
        productList.remove(posicao);
        notifyItemRemoved(posicao);
    }
    public void editar(Product produto, int posicao){
        productList.set(posicao, produto);
        notifyItemChanged(posicao);
    }

}
