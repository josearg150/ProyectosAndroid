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
:*  Autor       : Jose Angel Rocha Garcia   18131273
:*  Fecha       : 06/03/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Esta clase utiliza un Splash para después invocar a la pantalla de inicio
:*                 (VerdeActivity).
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131273.u2bandera3lay3actapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import mx.edu.itl.c18131273.U2Bandera3LayActApp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // La pantalla de splash se presentara en orientacion vertical y en pantalla completa
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        // Ocultar la barra de acciones ActionBar
        this.getSupportActionBar().hide();

        setContentView(R.layout.activity_splash);

        // Hacer la transicion al siguiente Activity despues de 3 segs
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, VerdeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}