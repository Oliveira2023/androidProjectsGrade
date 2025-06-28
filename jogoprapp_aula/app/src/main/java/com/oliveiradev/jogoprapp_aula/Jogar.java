package com.oliveiradev.jogoprapp_aula;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Jogar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Jogar extends Fragment {

    private Button btnCadastrar;
    private Button btnExibir;
    private Button btnPular;
    private TextView pergunta;
    private TextView resposta;
    List<Questoes> questoesList;
    private Button btnReiniciar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Jogar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Jogar.
     */
    // TODO: Rename and change types and number of parameters
    public static Jogar newInstance(String param1, String param2) {
        Jogar fragment = new Jogar();
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
        return inflater.inflate(R.layout.fragment_jogar, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCadastrar = requireActivity().findViewById(R.id.btnCadastrar);
        btnExibir = requireActivity().findViewById(R.id.btnExibir);
        btnPular = requireActivity().findViewById(R.id.btnPular);
        pergunta = requireActivity().findViewById(R.id.pergunta);
        resposta = requireActivity().findViewById(R.id.resposta);
        btnReiniciar = requireActivity().findViewById(R.id.btnReiniciar);
        btnReiniciar.setVisibility(View.INVISIBLE);

        questoesList = BancoDados.getDatabase(getContext()).questoesDao().pesquisarTodasQuestoes();

        proximaQuestao();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.main, new CadatrarPergunta())
                        .addToBackStack(null)
                        .commit();
            }
        });
        btnPular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximaQuestao();
            }
        });
        btnExibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resposta.setVisibility(View.VISIBLE);
            }
        });
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questoesList = BancoDados.getDatabase(getContext()).questoesDao().pesquisarTodasQuestoes();
                proximaQuestao();
                btnReiniciar.setVisibility(View.INVISIBLE);
            }
        });
    }


    private void proximaQuestao() {
        if (!questoesList.isEmpty()) {
            int indice = (int) (Math.random() * questoesList.size());
            Questoes questao = questoesList.get(indice);
            pergunta.setText(questao.getPergunta());
            resposta.setText(questao.getResposta());
            resposta.setVisibility(View.INVISIBLE);
            questoesList.remove(indice);
        } else {
            pergunta.setText("Nenhuma pergunta disponível");
            resposta.setText("");
            btnReiniciar.setVisibility(View.VISIBLE);
        }
    }

}