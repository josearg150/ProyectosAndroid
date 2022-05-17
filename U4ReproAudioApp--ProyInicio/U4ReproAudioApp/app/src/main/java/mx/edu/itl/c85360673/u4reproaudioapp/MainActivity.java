package mx.edu.itl.c85360673.u4reproaudioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
                            implements View.OnTouchListener
{

    private Button btnFiesta;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFiesta = findViewById ( R.id.btnFiesta );
        //Registramos un listener para los eventos touch
        btnFiesta.setOnTouchListener(this);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if( view.getId() == R.id.btnFiesta ){
            if( motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                reproducir_audio();
            }else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                detener_audio();
            }
            return true;
        }
        return false;
    }
    public void acercaDe(View v){
        Intent intent = new Intent(this, acercaDe.class);
        startActivity(intent);
    }
    public void reproducir_audio(){
        if (mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.tropicalisimo);
        }
        mediaPlayer.start();
    }
    public void detener_audio(){
        if ( mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }
}