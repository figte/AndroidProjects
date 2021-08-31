package personal.app.appejemplo02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
    }


    //funcion de clic en boton SUMAR
    public  void sumar(View view){

        //creando instancias  de los componentes graficos
        //creado en XML.
        // clase padre VIEW----> EditText,TextView, Button...

        try {


                EditText num1=(EditText) findViewById(R.id.num1);
                EditText num2= (EditText) findViewById(R.id.num2);

                TextView salida=(TextView) findViewById(R.id.total);


                try {
                    //realizando la suma:
                    Integer total;
                    Integer n1=Integer.parseInt(num1.getText().toString());
                    Integer n2=Integer.parseInt(num2.getText().toString());
                    total=n1+n2;

                    //salida
                    salida.setText("El total es: "+total.toString());

                }catch (Exception e){
                    salida.setText("Error en los datos colocados:  "+e.getMessage());
                }

        }catch (Exception e){
            System.err.println("Error de ejecucion: "+e.getMessage());
        }
    }

}