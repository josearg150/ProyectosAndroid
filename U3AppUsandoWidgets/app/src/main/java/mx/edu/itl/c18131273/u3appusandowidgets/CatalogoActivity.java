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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CatalogoActivity extends AppCompatActivity {
    private ListView lstvPasteles;

    private final String []pasteles = {"Moka","Mouse de guayaba", "Tres leches fresa",
                                        "Duque de fresa", "Arcoiris", "Tarta de limon",
                                        "Chesee Cake","Ponche ruso"};

    private final String []descripciones = {
            "Pan de chocolate envinado con crema de cafe y chocolate, decorado con laminas de chocolate",
            "Base de pan de vainilla con mousse de guayaba naturales, decoracon con jarabe de guayaba",
            "Pan de vainilla humectado con 3 leches, relleno de fresa y crema dulce",
            "Discos de merengue rellenos de crema batida dulce y fresa, decorado con tapas de merengue",
            "Pan de chocolate y vainllia relleno de trufa, fresa y durazno, decorado con fruta",
            "Base de pasta sucre con almendra, crema de limon y merengue flameado",
            "Pastel de queso con base de galleta y mermelada de zarzamora",
            "Pan de vainilla envinado relleno de crema pastelera y almendras cubierto de yema dulce"};

    private final int []logos = {   R.drawable.moka,
                                    R.drawable.mousse,
                                    R.drawable.tresleches,
                                    R.drawable.duque,
                                    R.drawable.arcoiris,
                                    R.drawable.tartalimon,
                                    R.drawable.chessecake,
                                    R.drawable.ponche};
    private final String []precios = {  "$200",
                                        "$190",
                                        "$210",
                                        "$220",
                                        "$200",
                                        "$190",
                                        "$210",
                                        "$220",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lstvPasteles = findViewById(R.id.lstvPasteles);

        // Establecemos el Adapter para el ListView, el adapter será un objeto MiAdaptador
        MiAdaptador adaptador = new MiAdaptador(this, pasteles, descripciones, logos, precios);
        lstvPasteles.setAdapter(adaptador);

        // Establecemos un listener para el evento onItemClick del ListView
        lstvPasteles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Para mostrar descripciones de los pasteles en un toast
                //Toast.makeText(CatalogoActivity.this, descripciones[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
        //----------------------------------------------------------------------------------------------

        class MiAdaptador extends ArrayAdapter {
            private Context contexto;
            private String [] pasteles;
            private String [] descripciones;
            private int [] logos;
            private String []precios;

            public MiAdaptador (Context contexto,
                                String [] pasteles,
                                String [] descripciones,
                                int [] logos,
                                String []precios)
            {
                super(contexto, R.layout.activity_catalogo, R.id.txtvTitulo, pasteles);
                this.contexto = contexto;
                this.pasteles = pasteles;
                this.descripciones = descripciones;
                this.logos = logos;
                this.precios = precios;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
            {
                if(convertView == null)
                {
                    LayoutInflater layoutInflater = (LayoutInflater)
                            contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = layoutInflater.inflate (R.layout.activity_catalogo, parent, false);
                }
                ImageView logo = convertView.findViewById(R.id.imgvMuestras);
                TextView titulo = convertView.findViewById(R.id.txtvTitulo);
                TextView subtitulo = convertView.findViewById(R.id.txtvDescripcion);
                TextView precio = convertView.findViewById(R.id.txtPrecios);

                //Poner nuestros recursos en los Views
                logo.setImageResource(logos [position]);
                titulo.setText(pasteles [position]);
                subtitulo.setText(descripciones[position]);
                precio.setText(precios[position]);

                return convertView;
            }
        }
}