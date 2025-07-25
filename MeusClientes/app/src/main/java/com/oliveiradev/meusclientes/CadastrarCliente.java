package com.oliveiradev.meusclientes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastrarCliente#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastrarCliente extends Fragment {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTelefone;
    private EditText edtTelefoneCel;
    private EditText edtLocal;
    private EditText edtObservacoes;
    private Button btn_cadastrar;
    private Button btn_cancelar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastrarCliente() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastrarCliente.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastrarCliente newInstance(String param1, String param2) {
        CadastrarCliente fragment = new CadastrarCliente();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastrar_cliente, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtNome = view.findViewById(R.id.nome);
        edtEmail = view.findViewById(R.id.email);
        edtTelefone = view.findViewById(R.id.telefone);
        edtTelefoneCel = view.findViewById(R.id.telefoneCel);
        edtLocal = view.findViewById(R.id.local);
        edtObservacoes = view.findViewById(R.id.observacoes);
        btn_cadastrar = view.findViewById(R.id.btn_cadastrar);
        btn_cancelar = view.findViewById(R.id.btn_cancelar);

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();
                String telefone = edtTelefone.getText().toString();
                String telefoneCel = edtTelefoneCel.getText().toString();
                String local = edtLocal.getText().toString();
                String observacoes = edtObservacoes.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || telefoneCel.isEmpty()) {
                    return;
                }

                Cliente cliente = new Cliente();
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setTelefone(telefone);
                cliente.setTelefoneCel(telefoneCel);
                cliente.setLocal(local);
                cliente.setObservacoes(observacoes);

                BDClientes bdClientes = BDClientes.getInstance(getContext());
                BDClientes.databaseWriteExecutor.execute(() -> {
                    // Esta operação roda em background
                    bdClientes.daoCliente().inserir(cliente);

                    Objects.requireNonNull(getActivity()).runOnUiThread(() -> {
                        // Esta operação roda na UI Thread
                        Toast.makeText(getContext(), "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                        limparCampos();
                    });
                });
            }
        });
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }
    private void limparCampos() {
        edtNome.setText("");
        edtEmail.setText("");
        edtTelefone.setText("");
        edtTelefoneCel.setText("");
        edtLocal.setText("");
        edtObservacoes.setText("");
        edtNome.requestFocus(); // Opcional: focar no primeiro campo novamente
    }
}