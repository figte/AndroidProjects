package personal.app.appejemplo02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //funcion a ejecutar en clic del boton Aceptar
    @SuppressLint("ResourceAsColor")
    public void salida(View view){

        //obtener el texto del elemnto digitado por el usuario
        EditText nombre= (EditText) findViewById(R.id.txtNombre);

        // enlaza con componente de salida
        TextView salida=(TextView) findViewById(R.id.txtSalida);

        //setter y getter
        String nom=nombre.getText().toString();
        salida.setText("Bienvenido "+nom);

        //asignando formato al texto
        salida.setTextColor(R.color.purple_700);
        salida.setTextSize(20);
    }


}