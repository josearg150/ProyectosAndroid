/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*              Clase que utiliza un Splash con la bandera de México
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : Jesús Daniel López Hernández    18131252
:*  Fecha       : 03/03/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : Esta clase utiliza un Splash para después invocar a la pantalla principal
:*                 (MainActivity).
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131273.u2banderita1lay1actapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // La pantalla de splash se presentara en orientacion vertical y en pantalla completa
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_splash);

        // Hacer la transicion al siguiente Activity despues de 3 segs
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}