package com.example.yanal.tp3yanalvesandroid;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yanal.tp3yanalvesandroid.Domain.Usuario;

import java.io.Serializable;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();

        Serializable usuarioRecebido = intent.getSerializableExtra("usuario");
        Usuario usuario = (Usuario) usuarioRecebido;

        TextView txtDetailCelular = (TextView)findViewById(R.id.txtDetailCelular);
        TextView txtDetailCidade = (TextView)findViewById(R.id.txtDetailCidade);
        TextView txtDetailCpf = (TextView)findViewById(R.id.txtDetailCpf);
        TextView txtDetailEmail = (TextView)findViewById(R.id.txtDetailEmail);
        TextView txtDetailNome = (TextView)findViewById(R.id.txtDetailNome);
        TextView txtDetailSenha = (TextView)findViewById(R.id.txtDetailSenha);
        TextView txtDetailTelefone = (TextView)findViewById(R.id.txtDetailTelefone);

        txtDetailNome.setText("Nome: " + usuario.getNome());
        txtDetailCelular.setText("Celular: " + usuario.getCelular());
        txtDetailCidade.setText("Cidade: " + usuario.getCidade());
        txtDetailCpf.setText("Cpf: " + usuario.getCpf());
        txtDetailEmail.setText("E-mail: " + usuario.getEmail());
        txtDetailSenha.setText("Senha: " + usuario.getSenha());
        txtDetailTelefone.setText("Telefone: " + usuario.getTelefone());
    }
}
