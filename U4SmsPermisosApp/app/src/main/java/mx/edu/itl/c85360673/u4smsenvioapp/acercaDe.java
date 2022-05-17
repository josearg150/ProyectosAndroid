/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*                       Aplicacion para calcular el imc
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : jose angel rocha garcia 18131273
:*  Fecha       : 16/03/2022
:*  Compilador  : Android Studio bumblebee 2021.1.1
:*  Descripcion : Esta clase contiene los datos del creador de la app
:*  Ultima modif:
:*  Fecha       Modifico             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u4smsenvioapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class acercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
    }
}