package mx.edu.itl.c18131273.U2Bandera3LayActApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BlancoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blanco);
    }

    public void btnAtrasClick(View v){
        //Terminamos el activity actual y regresa el control al activity que lo invoco
        finish();
    }
    public void btnSiguienteClick(View v){
        //Preparamos la invocacion al RojoActivity
        Intent intent = new Intent(this, RojoActivity.class);
        startActivity(intent);
    }
}