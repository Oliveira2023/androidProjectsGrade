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
        btnCadastrar = getActivity().findViewById(R.id.btnCadastrar);
        btnExibir = getActivity().findViewById(R.id.btnExibir);
        btnPular = getActivity().findViewById(R.id.btnPular);
        pergunta = getActivity().findViewById(R.id.pergunta);
        resposta = getActivity().findViewById(R.id.resposta);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main, new CadatrarPergunta())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}