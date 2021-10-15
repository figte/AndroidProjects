package com.example.apptareas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //modelo de datos
    List<String> nombres=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //agregando
        nombres.add("Jose");
        nombres.add("Maria");

        ListView l=(ListView) findViewById(R.id.lista);

        //adaptador
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.item_nombre,R.id.txtNombre,nombres);

        //cargando adaptador
        l.setAdapter(adapter);

        //evento de seleccion en el listview
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Seleccionado: "+nombres.get(i),Toast.LENGTH_LONG).show();
            }
        } );


    }
}