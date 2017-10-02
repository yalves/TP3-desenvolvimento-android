package com.example.yanal.tp3yanalvesandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yanal.tp3yanalvesandroid.Adapter.UsuarioCustomAdapter;
import com.example.yanal.tp3yanalvesandroid.Domain.Usuario;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_list extends AppCompatActivity {
    private UsuarioCustomAdapter usuarioCustomAdapter;
    private FirebaseDatabase database;
    private DatabaseReference databaseNode;
    private ListView _listView;
    private FirebaseListAdapter<Usuario> _usuariosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        database = FirebaseDatabase.getInstance();
        databaseNode = database.getReference("Usuarios");
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        _listView = (ListView) findViewById(R.id.lstUsuarios);

        _usuariosAdapter = new FirebaseListAdapter<Usuario>(this, Usuario.class, R.layout.layout_list, databaseNode) {
            @Override
            protected void populateView(View view, Usuario usuario, int position) {
                //Set the value for the views
                ((TextView)view.findViewById(R.id.txtNameList)).setText(usuario.getNome());
                //...
            }
        };

        _listView.setEmptyView(findViewById(R.id.listaVazia));
        _listView.setAdapter(_usuariosAdapter);

        _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Activity_list.this, DetailActivity.class);

                Usuario usuario = _usuariosAdapter.getItem(position);

                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });
    }
}
