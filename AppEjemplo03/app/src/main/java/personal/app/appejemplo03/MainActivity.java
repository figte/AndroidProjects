package personal.app.appejemplo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Abrir(View view){
        //instanciamos un intent y le indicamos la activity a ejecutar
        Intent intent=new Intent(this,Activity2.class);


        //----------------------------------------------------------------------------
        Map<String,Object> map=new HashMap<String,Object>();
        //insertar valor
        map.put("TEXTO1","Valor de texto 1");
        map.put("TEXTO2","Valor de texto 2");
        map.put("NOMBRE","Juan Perez");

        //obtener valor
        String valor=(String) map.get("NOMBRE");


          //-----------------------------------------------------------------------------------------
        List<String> list=new ArrayList<String>();
        list.add("Valor 1");

        String v=list.get(0);

        //------------------------------------------------------------------------------


        //paso de parametros
        intent.putExtra("TEXTO","Esto es el valor del parametro");

        //paso de parametros por BUNDLE
        Bundle data=new Bundle();
        data.putString("NOMBRE","Jose Perez");
        data.putInt("EDAD",21);

        //pasando todos los elementos al intent
        intent.putExtras(data);


        //inicializamos la nueva activity a traves del intent
        startActivity(intent);
    }
}