package com.oliveiradev.jogoprapp_aula;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadatrarPergunta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadatrarPergunta extends Fragment {

    Button btnJogar;
    Button btnCadastrar;
    EditText cad_pergunta;
    EditText cad_resposta;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadatrarPergunta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadatrarPergunta.
     */
    // TODO: Rename and change types and number of parameters
    public static CadatrarPergunta newInstance(String param1, String param2) {
        CadatrarPergunta fragment = new CadatrarPergunta();
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
        return inflater.inflate(R.layout.fragment_cadatrar_pergunta, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnJogar = getActivity().findViewById(R.id.jogar);
        btnCadastrar = getActivity().findViewById(R.id.cadastrar);
        cad_pergunta = getActivity().findViewById(R.id.cad_pergunta);
        cad_resposta = getActivity().findViewById(R.id.cad_resposta);

        btnJogar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              getActivity().getSupportFragmentManager().beginTransaction()
                      .replace(R.id.main, new Jogar())
                      .addToBackStack(null)
                      .commit();
          }
        });

    }
}