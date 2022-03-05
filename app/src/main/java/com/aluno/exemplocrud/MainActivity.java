package com.aluno.exemplocrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nome;
    private EditText telefone;
    private EditText cpf;
    private AlunoDAO dao;
    private Button salvar;
    TextView ID;
    long id;
    Aluno a;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editNome);
        telefone = findViewById(R.id.editTelefone);
        cpf = findViewById(R.id.editCPF);
        dao = new AlunoDAO(this);
        salvar = findViewById(R.id.salvar);
        ID = findViewById(R.id.id);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = new Aluno();
                a.setNome(nome.getText().toString());
                a.setCpf(cpf.getText().toString());
                a.setTelefone(telefone.getText().toString());
                id = dao.inserir(a);
                ID.setText(Long.toString(id));
                exibirMensagem(salvar);

            }
        });
    }
    public void exibirMensagem(View view){
        toast.makeText(this,
                "Aluno inserido com id" + id,
                Toast.LENGTH_LONG);
        
    }

}