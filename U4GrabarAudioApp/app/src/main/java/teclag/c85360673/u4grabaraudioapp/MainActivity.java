package teclag.c85360673.u4grabaraudioapp;


import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;

import mx.edu.itl.c18131273.androidlib.util.permisos.ChecadorDePermisos;
import mx.edu.itl.c18131273.androidlib.util.permisos.PermisoApp;


public class MainActivity extends AppCompatActivity {

    private TextView txtvMensajes;
    private EditText edtGuardarComo;
    private Button   btnGrabar;
    private Button   btnDetener;
    private Button   btnReproducir;
    private PermisoApp[] permisosReq = {
            new PermisoApp(Manifest.permission.RECORD_AUDIO,"Audio", true),
            new PermisoApp(Manifest.permission.WRITE_EXTERNAL_STORAGE,"Almacenamiento",true),
            new PermisoApp(Manifest.permission.READ_EXTERNAL_STORAGE, "Lectura", true)
    };
    private MediaRecorder   mediaRecorder;
    private MediaPlayer mediaPlayer;
    private String ruta = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    private String fichero ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChecadorDePermisos.checarPermisos(this,permisosReq);
        txtvMensajes     = findViewById ( R.id.txtvMensaje );
        edtGuardarComo   = findViewById ( R.id.edtGuardarComo );
        btnGrabar        = findViewById ( R.id.btnGrabar );
        btnDetener       = findViewById ( R.id.btnDetener );
        btnReproducir    = findViewById ( R.id.btnReproducir );

        txtvMensajes.setText("");
        btnGrabar.setEnabled(true);
        btnDetener.setEnabled(false);
        btnReproducir.setEnabled(false);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS){
            ChecadorDePermisos.verificarPermisosSolicitados(this,permisosReq, permissions,grantResults);

        }
    }

    public void btnGrabarClick (View v ) {
        fichero = ruta + edtGuardarComo.getText().toString()+".3gp";
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);
        mediaRecorder.setOutputFile(fichero);
        try{
            txtvMensajes.setText("Grabando...");
            btnGrabar.setEnabled(false);
            btnDetener.setEnabled(true);
            btnReproducir.setEnabled(false);
            mediaRecorder.prepare();
            mediaRecorder.start();
        }catch (IOException ex){
            txtvMensajes.setText("");
            btnGrabar.setEnabled(true);
            btnDetener.setEnabled(false);
            btnReproducir.setEnabled(false);
            Toast.makeText(this,"Fallo al hacer la grabación: "+ex.toString(), Toast.LENGTH_LONG).show();

        }

    }

    public void btnDetenerClick ( View v ) {
        mediaRecorder.stop();
        mediaRecorder.release();
        txtvMensajes.setText("");
        btnGrabar.setEnabled(true);
        btnDetener.setEnabled(false);
        btnReproducir.setEnabled(true);
    }
    public void btnAcercaDeClick( View v){
        // Lanzamos
        Intent intent = new Intent(MainActivity.this, AcercaDeActivity.class);
        startActivity(intent);
    }
    public void btnReproducirClick ( View v ) {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(fichero);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    txtvMensajes.setText("Reproduciendo...");
                    btnGrabar.setEnabled(false);
                    btnDetener.setEnabled(false);
                    btnReproducir.setEnabled(false);
                    mediaPlayer.start();
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    txtvMensajes.setText("");
                    btnGrabar.setEnabled(true);
                    btnDetener.setEnabled(false);
                    btnReproducir.setEnabled(true);
                    mediaPlayer.release();

                }
            });
            mediaPlayer.prepare();
        }catch (IOException ex){
            txtvMensajes.setText("");
            btnGrabar.setEnabled(true);
            btnDetener.setEnabled(false);
            btnReproducir.setEnabled(false);
            Toast.makeText(this,"Fallo al reproducir la grabación", Toast.LENGTH_SHORT).show();

        }
    }


}
