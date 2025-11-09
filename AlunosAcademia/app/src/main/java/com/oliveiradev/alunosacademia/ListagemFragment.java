package com.oliveiradev.alunosacademia;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.oliveiradev.alunosacademia.model.Aluno;
import java.util.ArrayList;
import java.util.List;

/**
 * Um fragmento para exibir uma lista de alunos usando uma RecyclerView.
 */
public class ListagemFragment extends Fragment {

    private RecyclerView recyclerView;
    private academiaAdapter_alunos adapter;
    private List<Aluno> alunos = new ArrayList<>();

    public ListagemFragment() {
        // Construtor público vazio obrigatório
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Passo 1: Preparar os dados
        // (No futuro, isso virá de um banco de dados ou API)
        prepararDadosDeExemplo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Passo 2: Inflar o layout do fragmento
        return inflater.inflate(R.layout.fragment_listagem, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Passo 3: Configurar a RecyclerView
        // A view já foi criada, então agora podemos configurá-la.

        // 1. Encontre a RecyclerView pelo seu ID.
        recyclerView = view.findViewById(R.id.recyclerview);

        // 2. Crie o adapter com a lista de alunos.
        adapter = new academiaAdapter_alunos(alunos);

        // 3. Defina o LayoutManager (como os itens serão exibidos: linearmente, em grade, etc.).
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        // 4. Conecte o adapter à RecyclerView.
        recyclerView.setAdapter(adapter);
    }

    private void prepararDadosDeExemplo() {
        // Limpa a lista para evitar duplicatas
        alunos.clear();
        // Adiciona alguns alunos para teste
        alunos.add(new Aluno("Luciano Oliveira", 23, 65.4, 60.2, "Centro"));
        alunos.add(new Aluno("Maria Silva", 45, 98, 53.2, "Alto da Lapa"));
        alunos.add(new Aluno("João Santos", 19, 77.2, 69, "Perdizes"));
    }
}
