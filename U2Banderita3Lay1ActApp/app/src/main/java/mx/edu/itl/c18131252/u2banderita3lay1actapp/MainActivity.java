/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*           Clase que despliega en pantalla el activity.xml correspondiente
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jesús Daniel López Hernández    18131252
:*  Fecha       : 06/03/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Esta clase carga el diseño de pantalla en activity_verde.xml,
:*                 activity_blanco.xml o activity_rojo.xml según sea el caso.
:*                 Además un botón Acerca de para desplegar la info de la app.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131252.u2banderita3lay1actapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verde);
    }

    public void btnProcesarClick(View v) {
        if(v.getId() == R.id.btnAcercaDe) {
            //Mostramos un AlertDialog con la información de acerca de
        } else if (v.getId() == R.id.btnVerdeSiguiente) {
            //Cambiamos al layout blanco
            setContentView(R.layout.activity_blanco);
        } else if (v.getId() == R.id.btnBlancoAtras) {
            //Regresamos a la seccion verde
            setContentView(R.layout.activity_verde);
        } else if (v.getId() == R.id.btnBlancoSiguiente) {
            //Pasamos a la seccion Rojo
            setContentView(R.layout.activity_rojo);
        } else if (v.getId() == R.id.btnRojoAtras) {
            //Regresdamos a la seccion blanco
            setContentView(R.layout.activity_blanco);
        }
    }

    public void btnAcercaDeClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca de")
                .setMessage("TecNM campus La Laguna\n\n" +
                        "U2Banderita3Lay1ActApp v1.0.0\n\n" +
                        "Por: Jesús Daniel López Hernández (18131252)")
                .setIcon(R.drawable.itl)
                .create()
                .show();
    }

}