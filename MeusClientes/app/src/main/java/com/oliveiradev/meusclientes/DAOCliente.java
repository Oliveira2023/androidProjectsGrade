package com.oliveiradev.meusclientes;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class DAOCliente {

    @Insert
    public abstract long inserir(Cliente cliente);
    @Delete
    public abstract int excluirCliente(Cliente cliente);
    @Update
    public abstract int atualizarCliente(Cliente cliente);

    @Query("SELECT * FROM clientes")
    public abstract List<Cliente> listarClientes();

    @Query("SELECT * FROM clientes WHERE id = :id")
    public abstract Cliente buscarCliente(int id);

    @Query("SELECT * FROM clientes WHERE nome LIKE :nome")
    public abstract List<Cliente> buscarPorNome(String nome);

}
