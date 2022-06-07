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
:*  Archivo     : MenuActivity.java
:*  Autor       : Jose Angel rocha garcia    18131273
:*  Fecha       : 25/ABR/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : Clase para mostrar el menu principal de la app
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131273.u3appusandowidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void btnCatalogoClic ( View v ) {
        Intent intent  = new Intent ( this, CatalogoActivity.class );
        startActivity ( intent );
    }

    public void btnCatalogoPostresClic ( View v ) {
        Intent intent  = new Intent ( this, GridViewActivity.class );
        startActivity ( intent );
    }
    public void btnOrdenarClic ( View v ) {
        Intent intent  = new Intent ( this, OrdenarActivity.class );
        startActivity ( intent );
    }

    public void btnPedidos(View v){
        Intent intent  = new Intent ( this, activity_pedidos.class );
        startActivity ( intent );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate ( R.menu.menu_comun, menu );
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch ( id ) {
            case R.id.mniAcercaDe : Intent intent  = new Intent ( this, acercaDe.class );
                startActivity ( intent );break;
            default               : return super.onOptionsItemSelected(item);
        }
        return true;
    }

}