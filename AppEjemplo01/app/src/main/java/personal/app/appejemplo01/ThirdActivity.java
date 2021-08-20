package personal.app.appejemplo01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void cambiar(View view){
        //enlace
        TextView txtMensaje=(TextView) findViewById(R.id.txtMensaje);
        EditText texto= (EditText)findViewById(R.id.editTextTextPersonName);
        txtMensaje.setText(texto.getText());
    }



}