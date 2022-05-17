/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jesús Francisco Aguielera Guajardo (18131210)
:*  Fecha       : 15/03/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Muestra en un activity la información del creador de la app y la materia en la
                  que se está realizando
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================

:*------------------------------------------------------------------------------------------*/
package teclag.c85360673.u4grabaraudioapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_acerca_de);
    }
}