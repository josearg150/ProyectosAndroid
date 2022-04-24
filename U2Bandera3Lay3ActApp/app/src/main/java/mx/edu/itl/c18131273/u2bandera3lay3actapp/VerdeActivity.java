/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*             Clase que despliega en pantalla el activity_verde.xml
:*
:*  Archivo     : VerdeActivity.java
:*  Autor       : Jose Angel Rocha Garcia   18131273
:*  Fecha       : 06/03/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Esta clase carga el diseño de pantalla en activity_verde.xml, el cual
:*                contiene un layout con background de color verde, un botón Acerca de para
:*                desplegar la info de la app y otro para comenzar la actividad del BlancoActivity
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131273.u2bandera3lay3actapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import mx.edu.itl.c18131273.U2Bandera3LayActApp.R;
public class VerdeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verde);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }


    public void btnSiguienteClick(View v) {
        // Preparamos la invocación al BlancoActivity
        Intent intent = new Intent(this, BlancoActivity.class);
        startActivity(intent);
    }

    public void btnAcercaDeClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca de")
                .setMessage("TecNM campus La Laguna\n\n" +
                        "U2Banderita3Lay1ActApp v1.0.0\n\n" +
                        "Por: Jose Angel Rocha Garcia (18131273)")
                .setIcon(R.drawable.itl)
                .create()
                .show();
    }
}