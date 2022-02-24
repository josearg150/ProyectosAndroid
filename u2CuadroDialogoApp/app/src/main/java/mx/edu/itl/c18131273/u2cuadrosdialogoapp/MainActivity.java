/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*      Clase que despliega distintos cuadros de mensaje y dialogo basicos
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jose angel rocha garcia     18131273
:*  Fecha       : 22/Feb/2022
:*  Compilador  : Android Studio Bumblebee 2021.1.1
:*  Descripci�n : Los dialogos de alerta que se despliegan son los siguientes:
                    Toast de duracion corta
                    Toast de duracion larga
                    SnackBar
                    Cuadro de dialogo basico
                    Dialogo basico con boton OK
                    Dialogo basico con boton Ok y Cancel
                    Dialogo con botones de radio seleccion unica
                    Dialogo con botones casillas de verificacion seleccion multiple
                    Dialogo con layout de login incrustado
                    Acerca de

:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131273.u2cuadrosdialogoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //-------------------------------------------------------------------------------------------

    //Mensaje Toast de duracion corta
    public void btnToastCortoClick(View v){
        Toast.makeText(this, "Toast corto" , Toast.LENGTH_SHORT).show();
    }

    //Mensaje de Toast de duracion larga
    public void btnToastLargoClick(View v){
        Toast.makeText(this, "Toast largo" , Toast.LENGTH_LONG).show();
    }

    //Mensaje snackbar
    public void btnSnackBarClick(View v){
        LinearLayout layoutPrincipal = findViewById(R.id.layoutPrincipal);
        Snackbar.make(layoutPrincipal, "Esto es un snackbar", Snackbar.LENGTH_SHORT).show();
    }

    public void btnDialogoBasicoClick(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Cuadro de dialogo basico").create().show();
    }

    public void mostrarToast(String mensaje){
        Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
    }
    public void btnDialogoBotonOk(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setMessage ( "Dialogo basico con boton OK" )
                .setTitle ( "Android" )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Aceptar");
                    }
                })
                .create ()
                .show ();
    }

    public void btnOkCancel(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setMessage ( "Dialogo basico con boton OK y Cancelar" )
                .setTitle ( "Android" )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Aceptar");
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setCancelable(false)
                .create ()
                .show ();

    }
    private CharSequence colores [] = { "Verde", "Blanco", "Rojo" };
    public void btnDialogoLista(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Escoja un color bonito:" )
                .setItems ( colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick ( DialogInterface dialogInterface, int i ) {
                        mostrarToast ( "Color seleccionado: " + colores [ i ] );
                    }
                } )
                .create ()
                .show ();
    }
    private int iColorFavorito = 2;  // Por default el Rojo
    public void btnDialogoRadio(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Escoge tu color favorito:" )
                .setSingleChoiceItems ( colores, iColorFavorito, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick ( DialogInterface dialogInterface, int i ) {
                        iColorFavorito = i;
                        mostrarToast  ( "Escogi�: " + colores [ i ] );
                    }
                } )
                .setPositiveButton ( "Aceptar", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick ( DialogInterface dialogInterface, int i ) {
                        mostrarToast ( "Nuevo color favorito: " + colores [ iColorFavorito ] );
                    }
                } )
                .create()
                .show();
    }

    private boolean coloresSeleccionados [] = { false, false, false };  // Ninguna aparecera selecccionada
    private ArrayList<String> coloresFavoritos = new ArrayList<>();
    public void btnDialogoCasillas(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Seleccione sus colores favoritos:" )
                .setMultiChoiceItems ( colores, coloresSeleccionados, new DialogInterface.OnMultiChoiceClickListener () {
                    @Override
                    public void onClick ( DialogInterface dialogInterface, int i, boolean b ) {
                        if ( b ) {
                            mostrarToast ( "Color seleccionado: " + colores [ i ] );
                            coloresFavoritos.add ( colores [ i ].toString () );
                        }
                        else {
                            mostrarToast ( "Color deseleccionado: " + colores [ i ] );
                            coloresFavoritos.remove ( colores [ i ].toString () );
                        }
                    }
                })
                .setPositiveButton ( "Aceptar", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick ( DialogInterface dialogInterface, int i ) {
                        mostrarToast ( "Colores favoritos: " + coloresFavoritos );
                    }
                })
                .create()
                .show();

    }

    private EditText edtUsuario;
    private EditText edtContrasena;

    private View login_layout;

    public void btnDialogoLayoutIncrustado(View v){
        //Obtener instancia del layout de login y sus campos usuario y contraseña
        login_layout = getLayoutInflater().inflate(R.layout.login_layout, null);
        edtUsuario = login_layout.findViewById(R.id.edtUsuario);
        edtContrasena = login_layout.findViewById(R.id.edtcontrasena);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acceso")
                .setIcon(R.drawable.itllogo)
                .setView(login_layout)
                .setPositiveButton("Entrar", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        mostrarToast("Bienvenido: "+
                                edtUsuario.getText().toString()+ " ("+
                                edtContrasena.getText().toString()+")");
                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        dialogInterface.dismiss();
                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }

    public void btnAcercaDe(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle("Acerca de")
                .setIcon(R.drawable.itllogo)
                .setMessage(
                        "Instituto tecnologico de la laguna \n\n" +
                        "App cuadros de dialogo\n\n" +
                        "Jose angel rocha garcia 18131273 \n\n")
                .create()
                .show();
        }
    }
