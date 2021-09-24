package personal.app.appejemplo03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import personal.app.appejemplo03.model.Persona;
import personal.app.appejemplo03.persistencia.Data;

public class ListadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        cargarDatos();
    }

    public  void cargarDatos(){
        TextView datos=(TextView)findViewById(R.id.txtDatos2);
        List<Persona> personas= Data.personas;
        String texto="";
        for (Persona item :personas) {
           texto=texto+" \n \n"
                   +"Nombre: "+item.getNombre()
                   +"\n Edad:"+item.getEdad();
        }

        datos.setText(texto);
    }
}