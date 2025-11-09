package com.oliveiradev.alunosacademia;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oliveiradev.alunosacademia.databinding.ItemAlunoBinding;
import com.oliveiradev.alunosacademia.model.Aluno;

import java.util.List;

/**
 * Adapter para exibir uma lista de Alunos em um RecyclerView.
 */
public class academiaAdapter_alunos extends RecyclerView.Adapter<academiaAdapter_alunos.ViewHolder> {

    private final List<Aluno> mValues;

    public academiaAdapter_alunos(List<Aluno> alunos) {
        mValues = alunos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout do item usando ViewBinding, que é a prática moderna e segura.
        ItemAlunoBinding binding = ItemAlunoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // Obtém o objeto Aluno para a posição atual.
        Aluno aluno = mValues.get(position);

        // Define os dados do aluno nos TextViews do ViewHolder.
        // (Estou assumindo que sua classe Aluno tem métodos como getNome(), getEndereco(), etc.)
        holder.mNameView.setText(aluno.getNome());
        holder.mIdadeView.setText(String.valueOf(aluno.getIdade()));
        holder.mAlturaView.setText(String.valueOf(aluno.getAltura()));
        holder.mPesoView.setText(String.valueOf(aluno.getPeso()));
        holder.mUnidadeView.setText(aluno.getUnidade());

        // Guarda uma referência ao item atual.
        holder.mItem = aluno;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    /**
     * ViewHolder que contém as views para cada item da lista.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Declaração dos TextViews que irão exibir os dados.
        public final TextView mNameView;
        public final TextView mIdadeView;
        public final TextView mAlturaView;
        public final TextView mPesoView;
        public final TextView mUnidadeView;
        public Aluno mItem;

        public ViewHolder(ItemAlunoBinding binding) {
            super(binding.getRoot());
            // Inicializa os TextViews usando o objeto de binding, que já contém as referências
            // diretas e seguras para as views do seu layout (item_nome, item_endereco, etc.).
            mNameView = binding.itemNome;
            mAlturaView = binding.itemAltura;
            mIdadeView = binding.itemIdade;
            mPesoView = binding.itemPeso;
            mUnidadeView = binding.itemUnidade;
        }

        @NonNull
        @Override
        public String toString() {
            // Retorna o nome do aluno para facilitar a depuração.
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}
