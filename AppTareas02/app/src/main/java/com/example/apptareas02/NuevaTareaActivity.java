package com.example.apptareas02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apptareas02.dao.TareaDao;
import com.example.apptareas02.dao.TareaDaoImpRoom;
import com.example.apptareas02.dao.TareaDaoImpSharedPreference;
import com.example.apptareas02.model.Tarea;

public class NuevaTareaActivity extends AppCompatActivity {

    TextView txtTarea;
    Button btnRegresar;
    Button btnGuardar;

    TareaDao dao;

    Tarea tarea;

    int estado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_tarea);

        estado=0;

        //instancias a los componentes graficos
        this.txtTarea=(TextView) findViewById(R.id.txtTareaNueva);
        this.btnRegresar=(Button) findViewById(R.id.btnRegresar);
        this.btnGuardar=(Button) findViewById(R.id.btnGuardarTarea);



         Intent intent =new Intent(this,MainActivity.class);

         dao=new TareaDaoImpRoom(getApplicationContext());

         cargar();

         //eventos
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                startActivity(intent);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                   if(estado==0){
                       guardar();
                   }else{
                       actualizar();

                   }

                    reset();
                    startActivity(intent);
            }
        });
    }

    void  guardar(){
        tarea=new Tarea();
        //tarea.setId(0);
        tarea.setNombre(txtTarea.getText().toString());
        dao.save(tarea);

    }

    void actualizar(){
        tarea.setNombre(txtTarea.getText().toString());
        dao.update(tarea);
    }

    void  reset(){
       txtTarea.setText("");
       btnGuardar.setText("Guardar");
    }

    void cargar(){
        Intent intent;
        try {
            intent=getIntent();
            tarea=(Tarea) intent.getSerializableExtra("tarea");
            estado=intent.getIntExtra("estado",0);
            txtTarea.setText(tarea.getNombre());
            btnGuardar.setText("Actualizar");

        }catch (Exception e){
            estado=0;

        }
    }
}