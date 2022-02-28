package mx.edu.itl.c18131273.u2banderita3layactapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verde);
    }

    public void btnProcesarClick(View v){
        if(v.getId() == R.id.btnAcercaDe){
            //mostramos un AlertDialog con la informacion de acerca de
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Acerca de")
                    .setMessage(" TecNM campus La Laguna \n\n" +
                            "U2Banderita3Lay1ActApp v1.0.0\n\n" +
                            "Por: Jose angel rocha garcia 18131273")
                    .setIcon(R.drawable.loguitoitl)
                    .create()
                    .show();
        }
        else if(v.getId() == R.id.btnVerdeSiguiente){
            //Cambiamos al layout blanco
            setContentView(R.layout.activity_blanco);
        }
        else if(v.getId() == R.id.btnAtrasBlanco){
            //Regresamos  a la seccion verde
            setContentView(R.layout.activity_verde);
        }
        else if(v.getId() == R.id.btnBlancoSiguiente){
            //Pasamos a la seccion blanco
            setContentView(R.layout.activity_rojo);
        }
        else if(v.getId() == R.id.btnAtrasRojo){
            //Regresamos  a la seccion blanco
            setContentView(R.layout.activity_blanco);
        }

    }
}