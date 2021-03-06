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
:*  Archivo     : MainActivity.java
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


package mx.edu.itl.c85360673.u4smsenvioapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.itl.c18131273.androidlib.util.permisos.ChecadorDePermisos;
import mx.edu.itl.c18131273.androidlib.util.permisos.PermisoApp;

public class MainActivity extends AppCompatActivity {
    private EditText      edtTelefonoDestino;
    private EditText      edtMensaje;

    private PermisoApp[] permisosReq = new PermisoApp [] {
            new PermisoApp( Manifest.permission.SEND_SMS, "SMS", true ),
            new PermisoApp ( Manifest.permission.CALL_PHONE, "Telefono", false ),
            new PermisoApp ( Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", false )
    };

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTelefonoDestino = findViewById(R.id.edtTelefonoDestino);
        edtMensaje = findViewById(R.id.edtMensaje);

        ChecadorDePermisos.checarPermisos ( this, permisosReq );
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS) {
            ChecadorDePermisos.verificarPermisosSolicitados(this, permisosReq, permissions, grantResults);
        }

    }

    //----------------------------------------------------------------------------------------------

    public void btnVerPermisosClick ( View v ) {
    }

    //----------------------------------------------------------------------------------------------

    public void btnEnviarClick (View v ) {
        if ( validarDatos () == false )
            return;

        SmsManager smsMgr = SmsManager.getDefault();
        smsMgr.sendTextMessage (
                edtTelefonoDestino.getText().toString(),
                null,
                edtMensaje.getText().toString(),
                null,
                null
        );

        Toast.makeText (this, "SMS enviado",
                         Toast.LENGTH_SHORT ).show();
        edtMensaje.setText ( "" );
    }

    //----------------------------------------------------------------------------------------------

    private boolean validarDatos () {
        if ( edtTelefonoDestino.getText().toString().isEmpty() ) {
            edtTelefonoDestino.setError ( "Telefono no puede ser vacio" );
            return false;
        }

        if ( edtMensaje.getText().toString().isEmpty() ) {
            edtMensaje.setError ( "Proporcione un mensaje a enviar" );
            return false;
        }
        return true;
    }

    public void acercaDe(View v){
        Intent intent = new Intent(this, acercaDe.class);
        startActivity(intent);
    }

    //----------------------------------------------------------------------------------------------
}
