package com.oliveiradev.meusfornecedores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListagemAdaptador extends RecyclerView.Adapter<ListagemAdaptador.ViewHolder> {

    private final List<Fornecedor> mFornecedores;
    public ListagemAdaptador(List<Fornecedor> fornecedores) {
        mFornecedores = fornecedores;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ItemFornecedorBinding binding = ItemFornecedorBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fornecedor, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListagemAdaptador.ViewHolder holder, int position) {
        Fornecedor fornecedor = mFornecedores.get(position);
        holder.mCnpj.setText(fornecedor.getCnpj());
        holder.mRazao.setText(fornecedor.getRazaoSocial());

        holder.mLocalizacao.setText(fornecedor.getLocalizacao());
        holder.mTelefone.setText(fornecedor.getTelefone());

        holder.mItem = fornecedor;
    }

    @Override
    public int getItemCount() {
        return mFornecedores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mCnpj;
        public final TextView mRazao;
        public final TextView mLocalizacao;
        public final TextView mTelefone;
        public Fornecedor mItem;

        public ViewHolder(View itemView) {
            super(itemView);
            mCnpj = itemView.findViewById(R.id.cnpj);
            mRazao = itemView.findViewById(R.id.razao_social);
            mLocalizacao = itemView.findViewById(R.id.localizacao);
            mTelefone = itemView.findViewById(R.id.telefone);
        }
    }
}
