package personal.app.appejemplo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //recepcion
        Intent intent=getIntent();
        //recibiento parametro
        String parametro= intent.getStringExtra("TEXTO");

        //recibiendo el bundle con todos los parametros
        Bundle data=intent.getExtras();



        TextView txtTexto=(TextView) findViewById(R.id.txtTexto);
        txtTexto.setText("Nombre: "+data.getString("NOMBRE")+" Edad:"+data.getInt("EDAD"));



    }
}