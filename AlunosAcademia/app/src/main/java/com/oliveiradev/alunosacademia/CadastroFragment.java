package com.oliveiradev.alunosacademia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.oliveiradev.alunosacademia.databinding.FragmentCadastroBinding;
import com.oliveiradev.alunosacademia.model.Aluno;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CadastroFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // 1. Declare a variável para o View Binding
    private FragmentCadastroBinding binding;
    private DatabaseReference databaseReference;

    public CadastroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CadastroFragment.
     */
    // TODO: Rename and change types and number of parameters
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 2. Inflar o layout usando o View Binding
        binding = FragmentCadastroBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        binding.buttonSalvar.setOnClickListener(v -> {
            salvarAluno();
        });
    }
    private int randonId() {
        return (int) (Math.random() * 10000000);
    }
    private void salvarAluno() {
        String nome = binding.editTextNome.getText().toString().trim();
        String idadeStr = binding.editTextIdade.getText().toString().trim();
        String alturaStr = binding.editTextAltura.getText().toString().trim();
        String pesoStr = binding.editTextPeso.getText().toString().trim();
        String unidade = binding.editTextUnidade.getText().toString().trim();

        if (nome.isEmpty() || idadeStr.isEmpty() || alturaStr.isEmpty() || pesoStr.isEmpty() || unidade.isEmpty()) {
            Toast.makeText(getContext(), "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            int id = randonId();
            int idade = Integer.parseInt(idadeStr);
            double altura = Double.parseDouble(alturaStr);
            double peso = Double.parseDouble(pesoStr);
            Aluno aluno = new Aluno(nome, idade, altura, peso, unidade);

            databaseReference.push().setValue(aluno).addOnSuccessListener(aVoid -> {
                Toast.makeText(getContext(), "Aluno cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                limparCampos();
            }).addOnFailureListener(e -> {
                Toast.makeText(getContext(), "Erro ao cadastrar aluno", Toast.LENGTH_SHORT).show();
            });
        }catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Por favor, insira valores válidos para idade, altura e peso", Toast.LENGTH_SHORT).show();
        }
    }
    private void limparCampos() {
        binding.editTextNome.setText("");
        binding.editTextIdade.setText("");
        binding.editTextAltura.setText("");
        binding.editTextPeso.setText("");
        binding.editTextUnidade.setText("");
        // Coloca o foco de volta no primeiro campo
        binding.editTextNome.requestFocus();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}