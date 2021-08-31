package personal.app.appejemplo02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import personal.app.appejemplo02.model.Usuario;

public class RegistroActivity extends AppCompatActivity {

    private Usuario model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

       // model=new Usuario();
    }


    public  void registrar(View view){
        EditText nom=(EditText) findViewById(R.id.txtNom);
        EditText dir=(EditText) findViewById(R.id.txtDireccion);
        EditText pass=(EditText) findViewById(R.id.txtPass);
        TextView da=(TextView) findViewById(R.id.datos);

        try {
            model.setNombre(nom.getText().toString());
            model.setDireccion(dir.getText().toString());
            model.setPass(pass.getText().toString());

            da.setText("DATOS: \n"
                    +"NOMBRE: "+model.getNombre()+" \n"
                    +"DIRECCION: "+model.getDireccion());
        }catch (Exception e){

            da.setText(e.getMessage());
        }


    }


}