package com.oliveiradev.jogoprapp_aula;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Questoes.class}, version = 1, exportSchema = false)
public abstract class BancoDados extends RoomDatabase {

    public abstract MeuDao questoesDao();

    private static BancoDados INSTANCE;

    // Modelo Singleton
    public static BancoDados getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BancoDados.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    BancoDados.class, "bd_questoes").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
