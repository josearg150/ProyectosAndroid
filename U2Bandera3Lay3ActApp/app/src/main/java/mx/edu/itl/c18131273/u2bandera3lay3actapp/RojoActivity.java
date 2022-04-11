/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*             Clase que despliega en pantalla el activity_rojo.xml
:*
:*  Archivo     : RojoActivity.java
:*  Autor       : Jose Angel Rocha Garcia   18131273
:*  Fecha       : 06/03/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Esta clase carga el diseño de pantalla en activity_rojo.xml, el cual
:*                contiene un layout con background de color rojo y un botón Atras para finalizar
:*                el activity actual.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131273.u2bandera3lay3actapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import c18131273.u2bandera3lay3actapp.R;

public class RojoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rojo);
    }

    public void btnAtrasClick(View v) {
        // Terminamos el activity actual y regresa el control al activity que lo invocó
        finish();
    }
}