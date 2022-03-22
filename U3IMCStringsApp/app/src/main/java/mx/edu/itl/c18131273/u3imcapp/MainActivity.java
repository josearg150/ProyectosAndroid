package mx.edu.itl.c18131273.u3imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText edtPeso;
    private EditText edtEstatura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edtPeso = findViewById(R.id.edtPeso);
        edtEstatura = findViewById(R.id.edtEstatura);

    }
    public void btnCalcularIMCClick (View v){
        float peso = Float.parseFloat(edtPeso.getText().toString());
        float estatura = Float.parseFloat(edtEstatura.getText().toString());
        //Validar que el peso y la estatura no sea 0
        if (peso <= 0){
            edtPeso.setError(getString(R.string.errorPeso));
            edtPeso.requestFocus();
            return;
        }

        if( estatura <= 0){
            edtEstatura.setError(getString(R.string.errorEstatura));
            edtEstatura.requestFocus();
            return;
        }

        float imc = (float)(peso / Math.pow(estatura, 2));

        String condicion = getString(R.string.condicionMensaje);
        if (imc < 15) {
            condicion += getString(R.string.delgadezMuySevera);
        }else if(imc >= 15 && imc < 16){
            condicion += getString(R.string.delgadezSevera);
        }else if(imc >= 16 && imc < 18.5){
            condicion += getString(R.string.delgadez);
        }else if(imc >= 18.5 && imc < 25){
            condicion += getString(R.string.normal);
        }else if(imc >= 25 && imc < 30){
            condicion += getString(R.string.sobrepeso);
        }else if(imc >= 30 && imc < 35){
            condicion += getString(R.string.obesidadM);
        }else if(imc >= 35 && imc < 40){
            condicion += getString(R.string.obesidadS);
        }else if(imc >= 40){
            condicion += getString(R.string.obesidadMS);
        }

        //Desplegamos los resultados en un alertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.IMC))
                .setMessage(getString(R.string.IMC)+"= "+ imc + "\n\n" + condicion)
                .setPositiveButton(getString(R.string.Aceptar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }

    public void acercaDe(View v){
        Intent intent = new Intent(this, acercaDe.class);
        startActivity(intent);
    }
}