package com.example.apptareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptareas.Data.Data;
import com.example.apptareas.model.Tarea;

public class NuevaTareaActivity extends AppCompatActivity {


    Intent intent2;
    TextView tId;
    TextView tTitulo;
    TextView tDescripcion;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_tarea);

        try {
            Intent intent= new Intent(this,ListadoTareasActivity.class);


            this.intent2=getIntent();
            int estado= intent2.getIntExtra("estado",3);


             this.tId=(TextView) findViewById(R.id.tID);
             this.tTitulo=(TextView) findViewById(R.id.tTitulo);
             this.tDescripcion=(TextView) findViewById(R.id.tDescripcion);

             this.btnGuardar=findViewById(R.id.btnGuardar);

            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        guardar();
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Tarea Guardada",Toast.LENGTH_SHORT);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Error: "+e.getMessage(),Toast.LENGTH_SHORT);
                    }


                }
            });


                if(this.intent2!=null && estado==1){
                    cargarTarea();
                }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error: "+e.getMessage(),Toast.LENGTH_SHORT);

        }


    }


    public  void cargarTarea(){
           Tarea model=(Tarea) this.intent2.getSerializableExtra("tarea");

           tId.setText(model.getId().toString());
           tTitulo.setText(model.getTitulo());
           tDescripcion.setText(model.getDescripcion());
           this.btnGuardar.setText("Actualizar");


    }

    private void guardar(){


        Tarea model=new Tarea();

        model.setId(Integer.parseInt(tId.getText().toString()));
        model.setTitulo(tTitulo.getText().toString());
        model.setDescripcion(tDescripcion.getText().toString());

        Data.tareas.add(model);
    }
}