package personal.app.appejemplo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import personal.app.appejemplo03.model.Persona;

public class DashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        Intent intent=getIntent();

    //    Persona model= (Persona) intent.getParcelableExtra("PERSONA");
        Bundle data=intent.getExtras();

        Persona persona= (Persona) intent.getSerializableExtra("persona");

        TextView txtDatos=(TextView) findViewById(R.id.txtDatos);

       /* txtDatos.setText("Nombre: "+data.getString("Nombre")
                        +" \nEdad: "+data.getString("Edad")
                        +"\nGenero:  "+data.getString("Genero")
                        +"\nFecha nacimiento: "+data.getString("Fecha"));*/
        txtDatos.setText("Nombre: "+persona.getNombre()
                +" \nEdad: "+persona.getEdad()
                +"\nFecha nacimiento: "+persona.getFecha());


    }
}