/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*                       descripcion breve de la clase (centrado)
:*
:*  Archivo     :GridViewPostresDetalles.java
:*  Autor       : Jose Angel rocha garcia    18131273
:*  Fecha       : 25/ABR/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : Clase para mostrar el grid de los minipostres cuanto se da un toque en alguno
                    De ellos
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c18131273.u3appusandowidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GridviewPostresDetalle extends AppCompatActivity {
    private ImageView imgvPostreDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_postres_detalle);
        getSupportActionBar().hide();

        imgvPostreDetalle = findViewById ( R.id.imgVMiniPostreDetalle);

        Integer miniPostre = getIntent().getIntExtra("postre", 0);
        imgvPostreDetalle.setScaleType(ImageView.ScaleType.FIT_XY);
        //imgvPostreDetalle.setImageResource (miniPostre );
        Glide.with( imgvPostreDetalle.getContext () ).load (miniPostre).into(imgvPostreDetalle);
    }
}