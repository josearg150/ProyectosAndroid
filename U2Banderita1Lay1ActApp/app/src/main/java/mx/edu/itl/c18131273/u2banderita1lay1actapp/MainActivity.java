/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*           Clase que despliega en pantalla la bandera de México completa
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jesús Daniel López Hernández    18131252
:*  Fecha       : 03/03/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : Esta clase carga el diseño de pantalla en activity_main.xml
:*                 que contiene las 3 seciones de la bandera de México y
:*                 el escudo nacional. Se base en el uso de 3 componentes
:*                 LinearLayout y un ImageView para mostrar el escudo.
:*                 Además un botón Acerca de para desplegar la info de la app.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131273.u2banderita1lay1actapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //----------------------------------------------------------------------------------------------a
    public void btnAcercaDeClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca de")
                .setMessage("TecNM campus La Laguna\n\n" +
                        "U2Banderita1LayActApp v1.0.0\n\n" +
                        "Por: Jose angel rocha garcia (18131273)")
                .setIcon(R.drawable.itl)
                .create()
                .show();
   }

}