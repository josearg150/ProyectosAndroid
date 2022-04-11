/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*                       Clase que despliega en pantalla la bandera de mexico completa
:*
:*  Archivo     : MainActivity.java
:*  Autor       : jose angel rocha garcia 18131273
:*  Fecha       : 03/03/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : Esta clase carga el diseño de pantalla en activity_main.xml
                   que contiene las 3 secciones de la bandera de mexico y el escudo
                   nacional. Se basa en el uso de componenetes Linear Layout y un image View
                   para mostrar el escudo
                   Ademas un boton acerca de para desplegar la info de la app
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.*/

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