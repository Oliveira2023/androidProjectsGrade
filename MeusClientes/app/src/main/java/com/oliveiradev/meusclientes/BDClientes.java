package com.oliveiradev.meusclientes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Cliente.class}, version = 1, exportSchema = false)
public abstract class BDClientes extends RoomDatabase {

    public abstract DAOCliente daoCliente();

    private static BDClientes INSTANCE;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(4);

    public static BDClientes getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (BDClientes.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BDClientes.class, "clientes.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
