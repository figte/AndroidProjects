package personal.app.appejemplo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import personal.app.appejemplo03.model.Persona;
import personal.app.appejemplo03.persistencia.Data;

public class ResgistroActivity extends AppCompatActivity {

    Persona model;

    TextView txtNombre;
    TextView txtEdad;
    TextView txtFecha;
    TextView txtError;

    RadioButton rFemenino;
    RadioButton rMasculino;

    CheckBox chCondiciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro);

        this.model=new Persona();

        this.txtNombre=(TextView) findViewById(R.id.txtNombre);
        this.txtEdad=(TextView) findViewById(R.id.txtEdad);
        this.txtFecha=(TextView) findViewById(R.id.txtFecha);
        this.txtError=(TextView) findViewById(R.id.txtError);

        this.rFemenino=(RadioButton) findViewById(R.id.rfemenino);
        this.rMasculino=(RadioButton) findViewById(R.id.rMasculino);

        this.chCondiciones=(CheckBox) findViewById(R.id.chCondiciones);

        //evento para boton
        Button btnRegistrar=(Button) findViewById(R.id.btnRegistrar);

        //agregar Listener, implenetacion que escuche la accion de evento
        View.OnClickListener evento=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   registrar();

                   Toast not=Toast.makeText(getApplicationContext(),"Registrado correctamente",Toast.LENGTH_LONG);
                   not.show();

               }catch (Exception e){
                   Toast not=Toast.makeText(getApplicationContext(),"Error"+e.getMessage(),Toast.LENGTH_LONG);
                   not.show();
               }


            }
        };

        //asoccioar instancia del evento al boton
        btnRegistrar.setOnClickListener(evento);


        Button btnGuardar=(Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recolectarDatos()==true){
                    //se agrega nuevo resgitro
                    Data.personas.add(model);
                    abrirListado();
                    Toast not=Toast.makeText(getApplicationContext(),"Registrado correctamente",Toast.LENGTH_LONG);
                    not.show();
                }else{
                    Toast not=Toast.makeText(getApplicationContext(),"ERROR AL RESGISTRAR",Toast.LENGTH_LONG);
                    not.show();
                }

            }
        });
    }

    public  void reset(View view){
            this.txtNombre.setText("");
            this.txtEdad.setText("");
            this.txtFecha.setText("");
            this.rFemenino.setChecked(false);
            this.rMasculino.setChecked(false);
            this.chCondiciones.setChecked(false);

    }

    public boolean recolectarDatos() {
        if(this.chCondiciones.isChecked()) {
            this.model.setNombre(this.txtNombre.getText().toString());
            this.model.setEdad(Integer.parseInt(this.txtEdad.getText().toString()));
            this.model.setFecha(new Date(this.txtFecha.getText().toString()));

            if (this.rFemenino.isChecked())
                this.model.setGenero(rFemenino.getText().toString());
            if (this.rMasculino.isChecked())
                this.model.setGenero("Masculino");

            return  true;
        }else{
            this.txtError.setText("Validacion: Tienes que aceptar los terminos y condiciones");
            return  false;
        }

    }

    public  void abrirListado(){
        Intent intent=new Intent(this, ListadoActivity.class);
        startActivity(intent);
    }

    public void registrar(){

        if(this.chCondiciones.isChecked()){
            this.model.setNombre(this.txtNombre.getText().toString());
            this.model.setEdad(Integer.parseInt(this.txtEdad.getText().toString()));
            this.model.setFecha(new Date(this.txtFecha.getText().toString()));

            if(this.rFemenino.isChecked())
                this.model.setGenero(rFemenino.getText().toString());
            if(this.rMasculino.isChecked())
                this.model.setGenero("Masculino");

            Intent intent=new Intent(this,DashActivity.class);

            Bundle data=new Bundle();
            data.putString("Nombre",this.model.getNombre());
            data.putString("Edad",this.model.getEdad().toString());
            data.putString("Genero",this.model.getGenero().toString());
            data.putString("Fecha",this.model.getFecha().toString());


            intent.putExtras(data);

            intent.putExtra("persona",this.model);

            //intent.putParcelableArrayListExtra("PERSONA", (ArrayList<? extends Parcelable>) data);

            startActivity(intent);
        }else{

            this.txtError.setText("Validacion: Tienes que aceptar los terminos y condiciones");
        }

    }
}