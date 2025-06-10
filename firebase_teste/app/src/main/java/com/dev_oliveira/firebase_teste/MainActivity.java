package com.dev_oliveira.firebase_teste;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText edtId, edtNome, edtTelefone;
    Button btnSalvar, btnPesquisar, btnAtualizar, btnRemover, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser  != null) {
            Toast.makeText(this, "Please login first", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return;
        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, "Welcome " + currentUser.getEmail(), Toast.LENGTH_SHORT).show();

        edtId = findViewById(R.id.edtId);
        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnPesquisar = findViewById(R.id.btnPesquisar);
        btnAtualizar = findViewById(R.id.btnAtualizar);
        btnRemover = findViewById(R.id.btnRemover);
        btnSair = findViewById(R.id.btnSair);

        btnSair.setOnClickListener(v -> {
            mAuth.signOut();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        btnSalvar.setOnClickListener(v -> {
            salvarContato();
        });
        btnPesquisar.setOnClickListener(v -> {
            pesquisarContato();
        });
        btnAtualizar.setOnClickListener(v -> {
            atualizarContato();
        });
        btnRemover.setOnClickListener(v -> {
            removerContato();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void salvarContato() {
        String idStr = edtId.getText().toString();
        int id = Integer.parseInt(idStr);
        String nome = edtNome.getText().toString();
        String telefone = edtTelefone.getText().toString();

        Agenda agenda = new Agenda(id, nome, telefone);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.getReference("agenda").child(String.valueOf(id)).setValue(agenda);
        edtId.setText("");
        edtNome.setText("");
        edtTelefone.setText("");

    }
    private void pesquisarContato() {
        String idStr = edtId.getText().toString();
        int id = Integer.parseInt(idStr);

        edtNome.setText("");
        edtTelefone.setText("");

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("agenda").orderByChild("id").equalTo(id).addChildEventListener(childEventListener);
    }
    private void atualizarContato() {
        String idStr = edtId.getText().toString();
        if (idStr.isEmpty()) {
            Toast.makeText(this, "Please enter an ID", Toast.LENGTH_SHORT).show();
            return;
        }
        int id = Integer.parseInt(idStr);
        String nome = edtNome.getText().toString();
        String telefone = edtTelefone.getText().toString();

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("agenda").child(String.valueOf(id)).child("nome").setValue(nome);
        database.child("agenda").child(String.valueOf(id)).child("telefone").setValue(telefone);
    }
    private void removerContato() {
        String idStr = edtId.getText().toString();
        if (idStr.isEmpty()) {
            Toast.makeText(this, "Please enter an ID", Toast.LENGTH_SHORT).show();
            return;
        }
        int id = Integer.parseInt(idStr);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("agenda").child(String.valueOf(id)).removeValue();
    }

    private ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot,@NonNull String previousChildName) {
            // Handle new data
            Agenda agenda = dataSnapshot.getValue(Agenda.class);
            Log.i("Firebase_Consulta", Objects.requireNonNull(dataSnapshot.getValue()).toString());
            //edtId.setText(agenda.getId());
            edtNome.setText(agenda.getNome());
            edtTelefone.setText(agenda.getTelefone());
        }
        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {

        }
        @Override
        public void onChildRemoved(DataSnapshot snapshot){

        }
        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {

        }
        @Override
        public void onCancelled(com.google.firebase.database.DatabaseError databaseError) {

        }
    };


}