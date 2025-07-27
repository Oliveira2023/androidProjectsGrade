package com.oliveiradev.meusclientes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewCliente#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewCliente extends Fragment {

    private TextView nome;
    private TextView email;
    private TextView telefone;
    private TextView telefoneCel;
    private TextView local;
    private TextView observacoes;
    private Button btn_anterior;
    private Button btn_proximo;
    private Button btn_cadastrar;
    private Button btn_excluir;
    private List<Cliente> listaClientes;
    private int posicao = 0;

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

        nome = view.findViewById(R.id.nomeCliente);
        email = view.findViewById(R.id.emailCliente);
        telefone = view.findViewById(R.id.telefoneCliente);
        telefoneCel = view.findViewById(R.id.celularCliente);
        local = view.findViewById(R.id.localCliente);
        observacoes = view.findViewById(R.id.observacoesCliente);
        btn_anterior = view.findViewById(R.id.btn_anterior);
        btn_proximo = view.findViewById(R.id.btn_proximo);
        btn_cadastrar = view.findViewById(R.id.btn_cadastrar);
        btn_excluir = view.findViewById(R.id.btn_excluir);

        BDClientes bdClientes = BDClientes.getInstance(getContext());
        listaClientes = bdClientes.daoCliente().listarClientes();

        proximoCliente(posicao);

        btn_anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (posicao > 0) {
                    posicao -= 1;
                    proximoCliente(posicao);
                }
            }

        });

        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaClientes.size() > 0 && posicao < listaClientes.size() - 1) {
                    posicao += 1;
                    proximoCliente(posicao);
                }
            }
        });
        if (btn_cadastrar != null) {
            btn_cadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.main, new CadastrarCliente())
                            .commit();
                }
            });
        }

        btn_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaClientes.size() > 0) {
                    Cliente cliente = listaClientes.get(posicao);
                    int id = cliente.getId();
                    BDClientes.databaseWriteExecutor.execute(() -> {
                        bdClientes.daoCliente().excluirCliente(cliente);
                        listaClientes = bdClientes.daoCliente().listarClientes();
                        posicao = 0;
                        proximoCliente(posicao);
                    });
                }

            }
        });
    }

    private void proximoCliente(int posicao) {
        if (!listaClientes.isEmpty()) {
            Cliente cliente = listaClientes.get(posicao);
            nome.setText(cliente.getNome());
            email.setText(cliente.getEmail());
            telefone.setText(cliente.getTelefone());
            telefoneCel.setText(cliente.getTelefoneCel());
            local.setText(cliente.getLocal());
            observacoes.setText(cliente.getObservacoes());
        }
    }
}