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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    final Integer [] miniPostres = {
            R.drawable.gelatinaroja,
            R.drawable.paylimon,
            R.drawable.brownie,
            R.drawable.strudel,
            R.drawable.chesse,
            R.drawable.chessecookies,
    };

    private GridView grdvPostres;
    private GridAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        grdvPostres = findViewById ( R.id.grdvPostres );
        adaptador = new GridAdaptador ( this, R.layout.gridview_item, miniPostres );
        grdvPostres.setAdapter (adaptador);

        grdvPostres.setOnItemClickListener (this);
    }

    //------------------------------------------------------------------------------------------
    @Override
    public void onItemClick (AdapterView<?> adapterView, View view, int i, long l ) {
        Intent intent = new Intent( this, GridviewPostresDetalle.class );
        intent.putExtra ( "postre", miniPostres [ i ] );
        startActivity ( intent );
    }

    //------------------------------------------------------------------------------------------


    public class GridAdaptador extends ArrayAdapter {
        private Integer [] miniPostres;
        private int        layoutResId;
        private LayoutInflater inflater;

        // Constructor

        public GridAdaptador(@NonNull Context context, int resource, @NonNull Integer [] miniPostres ) {
            super ( context, resource, miniPostres );
            this.miniPostres = miniPostres;
            layoutResId = resource;
            inflater = LayoutInflater.from ( context );
        }

        //------------------------------------------------------------------------------------------

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if ( convertView == null ) {
                convertView = inflater.inflate(layoutResId, parent, false);
            }
            ImageView imgPostre = convertView.findViewById ( R.id.imgvPostreFormato);
            imgPostre.setScaleType ( ImageView.ScaleType.FIT_XY);
            Glide.with( imgPostre.getContext () ).load ( miniPostres [ position ] ).into ( imgPostre);



            return convertView;

            //------------------------------------------------------------------------------------------
        }
    }

}