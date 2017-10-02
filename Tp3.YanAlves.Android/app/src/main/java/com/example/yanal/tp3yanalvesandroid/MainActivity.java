package com.example.yanal.tp3yanalvesandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yanal.tp3yanalvesandroid.Domain.Usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        databaseNode = database.getReference("Usuarios");
    }

    public void LimparFormulario(View view)
    {
        List<EditText> campos = new ArrayList<EditText>();

        campos.add((EditText)findViewById(R.id.txtBoxCelular));
        campos.add((EditText)findViewById(R.id.txtBoxCidade));
        campos.add((EditText)findViewById(R.id.txtBoxCpf));
        campos.add((EditText)findViewById(R.id.txtBoxEmail));
        campos.add((EditText)findViewById(R.id.txtBoxNome));
        campos.add((EditText)findViewById(R.id.txtBoxSenha));
        campos.add((EditText)findViewById(R.id.txtBoxTelefone));

        LimparCampos(campos);
    }

    public void SalvarFormulario(View view)
    {
        Usuario usuario = new Usuario();

        EditText txtBoxCelular = (EditText)findViewById(R.id.txtBoxCelular);
        EditText txtBoxCidade = (EditText)findViewById(R.id.txtBoxCidade);
        EditText txtBoxCpf = (EditText)findViewById(R.id.txtBoxCpf);
        EditText txtBoxEmail = (EditText)findViewById(R.id.txtBoxEmail);
        EditText txtBoxNome = (EditText)findViewById(R.id.txtBoxNome);
        EditText txtBoxSenha = (EditText)findViewById(R.id.txtBoxSenha);
        EditText txtBoxTelefone = (EditText)findViewById(R.id.txtBoxTelefone);

        String celular = txtBoxCelular.getText().toString();
        String cidade = txtBoxCidade.getText().toString();
        String cpf = txtBoxCpf.getText().toString();
        String email = txtBoxEmail.getText().toString();
        String nome = txtBoxNome.getText().toString();
        String senha = txtBoxSenha.getText().toString();
        String telefone = txtBoxTelefone.getText().toString();

        if (celular.isEmpty() ||
            cidade.isEmpty() ||
            cpf.isEmpty() ||
            email.isEmpty() ||
            nome.isEmpty() ||
            senha.isEmpty() ||
            telefone.isEmpty())
        {
            Toast("Preencha todos os campos do formulario");

            return;
        }

        usuario.setCelular(celular);
        usuario.setCidade(cidade);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setTelefone(telefone);

        SalvarUsuario(usuario);

        LimparFormulario(view);

        Toast("Usuário salvo com sucesso");

    }

    public void VisualizarUsuarios(View view)
    {
        Intent intent = new Intent(MainActivity.this, Activity_list.class);
        startActivity(intent);
    }

    private void SalvarUsuario(Usuario usuario) {
        String userId = databaseNode.push().getKey();

        databaseNode.child(userId).setValue(usuario);
    }

    private void LimparCampos(List<EditText> campos)
    {
        for (EditText campo: campos) {
            campo.setText("");
        }
    }

    private void Toast(String mensagem)
    {
        Context contexto = getApplicationContext();
        String texto = mensagem;
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();
    }
}
