package mx.edu.itl.c18131273.U2Bandera3LayActApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VerdeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verde);
    }

    public void btnSiguienteClick(View V){
        //Preparamos la invocacion al BlancoActivity
        Intent intent = new Intent(this, BlancoActivity.class);
        startActivity(intent);
    }
}