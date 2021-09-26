package com.example.apptareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.apptareas.Adaptadores.TareaAdapter;
import com.example.apptareas.Data.Data;
import com.example.apptareas.model.Tarea;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListadoTareasActivity extends AppCompatActivity {


    ListView l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_tareas);



         l=(ListView) findViewById(R.id.listaTareas);

         //crear adptador
        TareaAdapter adapter=new TareaAdapter(this,R.layout.item_tarea,Data.tareas);

        l.setAdapter(adapter);


         //abrir vista nueva tarea
        Intent intent =new Intent(this,NuevaTareaActivity.class);

        FloatingActionButton btnNuevo=(FloatingActionButton)findViewById(R.id.btnNuevo);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("estado",0);
                startActivity(intent);
            }
        });

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               intent.putExtra("tarea",Data.tareas.get(i));
                intent.putExtra("estado",1);
                startActivity(intent);
            }
        });

    }
}