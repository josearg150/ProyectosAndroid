package mx.edu.itl.c18131273.u2cuadrosdialogoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //-------------------------------------------------------------------------------------------
    //Mensaje Toast de duracion corta
    public void btnToastCortoClick(View v){
        Toast.makeText(this, "Toast corto" , Toast.LENGTH_SHORT).show();
    }

    //Mensaje de Toast de duracion larga
    public void btnToastLargoClick(View v){
        Toast.makeText(this, "Toast largo" , Toast.LENGTH_LONG).show();
    }

    //Mensaje snackbar
    public void btnSnackBarClick(View v){

    }

    public void btnDialogoBasicoClick(View v){

    }

    public void btnDialogoBotonOk(View v){

    }

    public void btnOkCancel(View v){

    }

    public void btnDialogoLista(View v){

    }

    public void btnDialogoRadio(View v){

    }

    public void btnDialogoCasillas(View v){

    }

    public void btnDialogoLayoutIncrustado(View v){

    }

    public void btnAcercaDe(View v){

    }
}