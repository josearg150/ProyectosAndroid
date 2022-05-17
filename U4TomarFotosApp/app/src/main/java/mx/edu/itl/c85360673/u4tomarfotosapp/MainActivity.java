package mx.edu.itl.c85360673.u4tomarfotosapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import util.permisos.ChecadorDePermisos;
import util.permisos.PermisoApp;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final int CODIGO_CAPTURA_FOTO = 123;

    private PermisoApp [] permisosReq = {
            new PermisoApp  ( Manifest.permission.CAMERA, "Camara", true  ),
            new PermisoApp  ( Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", true  ),
            new PermisoApp  ( Manifest.permission.WRITE_EXTERNAL_STORAGE, "Almacenamiento", true )
    };

    private Uri uriFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChecadorDePermisos.checarPermisos ( this, permisosReq );

    }

    public void btnCapturaSimpleClick ( View v ) {
        // Formar el nombre del archivo basado en la fecha y hora para que sea nombre unico
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "yyyyMMddHHmmss" );
        String strFechaHora = simpleDateFormat.format ( new Date() );
        String archFoto = "foto" + strFechaHora + ".jpg";

        File fileFoto = new File ( Environment.getExternalStorageDirectory ().getAbsolutePath () +
                                   File.separator +
                                   "DCIM" +
                                   File.separator +
                                   archFoto );

        // Creamos el URI correspondiente al archivo de destino de la foto
        // FileProvider para respetar las politicas de seguridad,
        uriFoto = FileProvider.getUriForFile ( this,
                    BuildConfig.APPLICATION_ID + ".provider",
                    fileFoto
                );

        // Creamos el intent que llamara a la app de la camara de fotos y le pasamos el uri
        // del archivo donde se debera guardar la foto si es que se captura una
        Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE );
        intent.putExtra ( MediaStore.EXTRA_OUTPUT, uriFoto );
        startActivityForResult ( intent, CODIGO_CAPTURA_FOTO );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == CODIGO_CAPTURA_FOTO ) {
            if ( resultCode == RESULT_OK ) {
                // Abrir el activity para mostrar la foto en pantalla completa.
                // Se envia como argumento el URI de la foto como un string
                Intent intent = new Intent ( this, MuestraFotoActivity.class );
                intent.putExtra ( "uri", uriFoto.toString () );
                startActivity ( intent );

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult ( requestCode, permissions, grantResults );

        if ( requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS ) {
            ChecadorDePermisos.verificarPermisosSolicitados ( this, permisosReq, permissions, grantResults );
        }
    }

    public void btnCapturaOpcionesClick (View v ) {
        Intent intent = new Intent ( this, CamaraActivity.class ) ;
        startActivity ( intent );
    }

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }

}
