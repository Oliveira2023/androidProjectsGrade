package com.oliveiradev.jogoprapp_aula;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MeuDao {

    @Insert
    long inserirQuestao(Questoes questoes);

    @Query("SELECT * FROM questoes")
    List<Questoes> pesquisarTodasQuestoes();

    @Query("SELECT * FROM questoes WHERE id = :id")
    Questoes pesquisarQuestao(int id);

    @Query("DELETE FROM questoes WHERE id = :id")
    void deletarQuestao(int id);

    @Query("DELETE FROM questoes")
    void apagarTabela();
}
