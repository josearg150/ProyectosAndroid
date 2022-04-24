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
:*  Archivo     : nombreArchivo.java
:*  Autor       : nombre completo del alumno(s)     numero(s) de control
:*  Fecha       : dd/mmm/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : descripcion funcional m�s detallada de lo que hace esta clase
:*                puede usar varios renglones
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c18131273.u3appusandowidgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Postre> {
    //----------------------------------------------------------------------------------------------
    // Constructor

    public SpinnerAdapter (@NonNull Context context, ArrayList<Postre> postres ) {
        super ( context, 0, postres );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return inicializarView ( position, convertView, parent );
    }

    @Override
    public View getDropDownView ( int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return inicializarView ( position, convertView, parent );
    }

    //----------------------------------------------------------------------------------------------
    // Metodo personalizado para inicializar la vista del elemento dado por el argumento position

    private View inicializarView ( int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
        // Configurar el View llamado convertView para inflar  spinner_fila_imagen_texto  y
        // establecer la imagen del logo del club y el nombre del club en el layout.
        if (convertView == null) {
            convertView = LayoutInflater.from ( getContext () )
                    .inflate ( R.layout.spinner_fila_imagen, parent,false );
            // Se obtienen las referencias a los widgets del layout
            ImageView imgvPostre = convertView.findViewById ( R.id.imgVSpinnerPostre ) ;
            TextView nombre = convertView.findViewById ( R.id.txtNombrePostre );

            // Obtenemos el objeto club correspondiente a position
            Postre postre = getItem ( position );

            // Establecemos los valores del club en los vidgets
            imgvPostre.setImageResource( postre.getImagen ( ));
            nombre.setText ( postre.getNombre () );
        }
        return convertView;
    }
}
