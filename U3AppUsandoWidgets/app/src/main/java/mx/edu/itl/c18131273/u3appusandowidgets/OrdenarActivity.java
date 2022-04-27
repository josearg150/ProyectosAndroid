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
:*  Archivo     : OrdenarActivity.java
:*  Autor       : Jose Angel rocha garcia    18131273
:*  Fecha       : 25/ABR/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : Clase para mostrar el menu para ordenar el pedido
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131273.u3appusandowidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class OrdenarActivity extends AppCompatActivity {

    private Spinner spnPostres;
    private Spinner spnPostres1;
    private Spinner spnPostres2;
    private ArrayList<Postre> postres;
    private ArrayList<Postre> miniPostres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenar);

        spnPostres = findViewById(R.id.spnPostre);
        spnPostres1 = findViewById(R.id.spnMiniPostre1);
        spnPostres2 = findViewById(R.id.spnMiniPostre2);
        inicializarPostres();
        inicializarMinipostres();

        SpinnerAdapter adaptador = new SpinnerAdapter(this, postres );
        adaptador.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        SpinnerAdapter adaptador1 = new SpinnerAdapter(this, miniPostres );
        adaptador.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        SpinnerAdapter adaptador2 = new SpinnerAdapter(this, miniPostres );
        adaptador.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        spnPostres.setAdapter(adaptador);
        spnPostres1.setAdapter(adaptador1);
        spnPostres2.setAdapter(adaptador2);

    }

    private void inicializarPostres() {
        postres = new ArrayList<>();
        // Agregar elementos al ArrayList
        postres.add(new Postre("Moka", R.drawable.moka,200));
        postres.add(new Postre("Mouse de guayaba", R.drawable.mousse,190));
        postres.add(new Postre("Tres leches fresa", R.drawable.tresleches,210));
        postres.add(new Postre("Duque de fresa", R.drawable.duque,220));
        postres.add(new Postre("Arcoiris", R.drawable.arcoiris,200));
        postres.add(new Postre("Tarta de limon", R.drawable.tartalimon,190));
        postres.add(new Postre("Chesse cake", R.drawable.chessecake,210));
        postres.add(new Postre("Ponche ruso", R.drawable.ponche,220));
    }

    public void inicializarMinipostres() {
        miniPostres = new ArrayList<>();
        // Agregar elementos al ArrayList
        miniPostres.add(new Postre("Gelatina roja", R.drawable.gelatinaroja,23));
        miniPostres.add(new Postre("Pay limon", R.drawable.paylimon,28));
        miniPostres.add(new Postre("Brownie", R.drawable.brownie,30));
        miniPostres.add(new Postre("Strudel", R.drawable.strudel,33));
        miniPostres.add(new Postre("Chesse", R.drawable.chesse, 35));
        miniPostres.add(new Postre("Chesse cookies", R.drawable.chessecookies, 35));
    }

    public void btnConfirmar(){
        int precioPastel = ((Postre) spnPostres.getSelectedItem()).getPrecio();
        int precioPostre1 = ((Postre) spnPostres1.getSelectedItem()).getPrecio();
        int precioPostre2 = ((Postre) spnPostres2.getSelectedItem()).getPrecio();
        int precioTotal = precioPastel+precioPostre1+precioPostre2;

        TextView precio = findViewById(R.id.txtPrecio);
        precio.setText(precioTotal);

    }
}