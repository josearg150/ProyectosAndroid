package mx.edu.itl.c18131273.U2Bandera3LayActApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class RojoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rojo);
    }

    public void btnAtrasClick(View v){
        //Terminamos el activity actual y regresa el control al activity que lo invoco
        finish();
    }
}