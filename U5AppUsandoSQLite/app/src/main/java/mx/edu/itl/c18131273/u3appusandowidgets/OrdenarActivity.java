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
:*  Descripci�n : Clase para mostrar el menu para ordenar y guardar el pedido
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
    29/05/2022 jose angel rocha garcia, se agrega apartado para guardar el pedido y para registrar
    el codigo
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131273.u3appusandowidgets;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class OrdenarActivity extends AppCompatActivity{
    EditText domicilio;
    EditText nombre;
    EditText codigoPedido;
    TextView etiquetaPrecio;
    private Spinner spnPostres;
    private Spinner spnPostres1;
    private Spinner spnPostres2;
    private ArrayList<Postre> postres;
    private ArrayList<Postre> miniPostres;
    int precioPastel;
    int precioPostre1;
    int precioPostre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenar);
        precioPastel = 0;
        precioPostre1 = 0;
        precioPostre2 = 0;
        spnPostres = findViewById(R.id.spnPostre);
        spnPostres1 = findViewById(R.id.spnMiniPostre1);
        spnPostres2 = findViewById(R.id.spnMiniPostre2);
        domicilio = (EditText) findViewById(R.id.editTextDomicilio);
        nombre = (EditText) findViewById(R.id.EditTextNombreC);
        codigoPedido = (EditText) findViewById(R.id.editTextCodigo);
        TextView etiquetaPrecio = (TextView) findViewById(R.id.txtPrecio);
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


        precioPastel = ((Postre) spnPostres.getSelectedItem()).getPrecio();
        precioPostre1 = ((Postre) spnPostres1.getSelectedItem()).getPrecio();
        precioPostre2 = ((Postre) spnPostres2.getSelectedItem()).getPrecio();
        etiquetaPrecio.setText("Precio: "+(precioPastel+precioPostre1+precioPostre2));

        spnPostres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precioPastel = ((Postre) spnPostres.getSelectedItem()).getPrecio();
                etiquetaPrecio.setText("Precio: "+(precioPastel+precioPostre1+precioPostre2));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spnPostres1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precioPostre1 = ((Postre) spnPostres1.getSelectedItem()).getPrecio();
                etiquetaPrecio.setText("Precio: "+(precioPastel+precioPostre1+precioPostre2));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spnPostres2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precioPostre2 = ((Postre) spnPostres2.getSelectedItem()).getPrecio();
                etiquetaPrecio.setText("Precio: "+(precioPastel+precioPostre1+precioPostre2));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

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

    public void btnConfirmar(View v){
        int precioTotal = precioPastel+precioPostre1+precioPostre2;
        AlertDialog.Builder builder = new AlertDialog.Builder(OrdenarActivity.this);
        builder.setTitle("Pedido confirmado").
                setMessage(
                "Tu pedido para "+nombre.getText() +" tiene un costo de "+precioTotal+
                " y llegara a "+domicilio.getText())
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }

    public void btnGuardar(View v){
        if(domicilio.getText().toString().isEmpty() || nombre.getText().toString().isEmpty()
        || codigoPedido.getText().toString().isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(OrdenarActivity.this);
            builder.setTitle("Datos de envio vacios").
                    setMessage("Favor de llenar todos los campos")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create()
                    .show();
        }else {
            AdminSQLiteOpenHelper baseDeDatos = new AdminSQLiteOpenHelper(this);
            int numPedido = Integer.parseInt(codigoPedido.getText().toString());
            String pastel = ((Postre) spnPostres.getSelectedItem()).getNombre();
            String postre1 = ((Postre) spnPostres1.getSelectedItem()).getNombre();
            String postre2 = ((Postre) spnPostres2.getSelectedItem()).getNombre();
            String dom = domicilio.getText().toString();
            String nom = nombre.getText().toString();
            int precioF = precioPastel + precioPostre1 + precioPostre2;

            baseDeDatos.guardarRegistro(numPedido,pastel,precioPastel,postre1,precioPostre1,
                        postre2,precioPostre2,dom,nom,precioF);

            AlertDialog.Builder builder = new AlertDialog.Builder(OrdenarActivity.this);
            builder.setTitle("Pedido Guardado").
                    setMessage("Pedido guardado con exito")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create()
                    .show();
        }
    }
}