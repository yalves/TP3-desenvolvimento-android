package com.example.yanal.tp3yanalvesandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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
        List<EditText> campos = new ArrayList<>();

        campos.add((EditText)findViewById(R.id.txtBoxCelular));
        campos.add((EditText)findViewById(R.id.txtBoxCidade));
        campos.add((EditText)findViewById(R.id.txtBoxCpf));
        campos.add((EditText)findViewById(R.id.txtBoxEmail));
        campos.add((EditText)findViewById(R.id.txtBoxNome));
        campos.add((EditText)findViewById(R.id.txtBoxSenha));
        campos.add((EditText)findViewById(R.id.txtBoxTelefone));

        LimparCampos(campos);
    }

    private void LimparCampos(List<EditText> campos)
    {
        for (EditText campo: campos) {
            campo.setText("");
        }
    }
}
