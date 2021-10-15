package com.example.apptareas02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.apptareas02.adapter.TareaAdapter;
import com.example.apptareas02.dao.TareaDao;
import com.example.apptareas02.dao.TareaDaoImpRoom;
import com.example.apptareas02.dao.TareaDaoImpSharedPreference;
import com.example.apptareas02.model.Tarea;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnNuevaTarea;
    RecyclerView rwTareas;

    List<Tarea> tareas;

    TareaDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao=new TareaDaoImpRoom(getApplicationContext());

        //instancias a componentes graficos
        this.btnNuevaTarea=(FloatingActionButton) findViewById(R.id.btnNuevaTarea);
        this.rwTareas=(RecyclerView) findViewById(R.id.rwTareas);

        Intent intent=new Intent(this, NuevaTareaActivity.class);

        //eventos
        this.btnNuevaTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        //cargando datos
        this.cargarDatos();

        //configurando recyclerview
        //instancia del adaptador
        TareaAdapter adapter=new TareaAdapter(this.tareas,getApplicationContext(),dao);

        rwTareas.setLayoutManager(new LinearLayoutManager(this));

        //config del adaptador
        rwTareas.setAdapter(adapter);


    }

    void  cargarDatos(){
        tareas=new ArrayList<Tarea>();
        tareas=dao.getAll();
    }
}