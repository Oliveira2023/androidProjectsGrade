package com.oliveiradev.meusclientes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewCliente#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewCliente extends Fragment {

    private TextView edtNome;
    private TextView edtEmail;
    private TextView edtTelefone;
    private TextView edtTelefoneCel;
    private TextView edtLocal;
    private TextView edtObservacoes;
    private Button btn_anterior;
    private Button btn_proximo;
    private Button btn_cadastrar;
    private Button btn_excluir;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ViewCliente() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewCliente.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewCliente newInstance(String param1, String param2) {
        ViewCliente fragment = new ViewCliente();
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
        return inflater.inflate(R.layout.fragment_view_cliente, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtNome = requireActivity().findViewById(R.id.nomeCliente);
        edtEmail = view.findViewById(R.id.emailCliente);
        edtTelefone = view.findViewById(R.id.telefoneCliente);
        edtTelefoneCel = view.findViewById(R.id.celularCliente);
        edtLocal = view.findViewById(R.id.localCliente);
        edtObservacoes = view.findViewById(R.id.observacoesCliente);
        btn_anterior = view.findViewById(R.id.btn_anterior);
        btn_proximo = view.findViewById(R.id.btn_proximo);
        btn_cadastrar = view.findViewById(R.id.btn_cadastrar);
        btn_excluir = view.findViewById(R.id.btn_excluir);

        btn_anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }


        });

        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.main, new CadastrarCliente())
                        .commit();
            }
        });

        btn_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}