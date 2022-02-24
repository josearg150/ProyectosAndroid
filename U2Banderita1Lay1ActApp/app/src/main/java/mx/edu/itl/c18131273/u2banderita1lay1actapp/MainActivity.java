package mx.edu.itl.c18131273.u2banderita1lay1actapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAcercaDeClick(View V){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca de")
               .setMessage(" TecNM campus La Laguna \n\n" +
                           "U2Banderita1Lay1ActApp v1.0.0\n\n" +
                           "Por: Jose angel rocha garcia 18131273")
               .setIcon(R.drawable.loguitoitl)
               .create()
               .show();
    }
}