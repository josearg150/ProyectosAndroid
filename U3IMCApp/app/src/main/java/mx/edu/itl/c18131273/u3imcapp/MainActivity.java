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

        float imc = (float)(peso / Math.pow(estatura, 2));

        String condicion = "Su condicion de salud es: ";
        if (imc < 15) {
            condicion += "Delgadez severa";
        }else if(imc >= 15 && imc < 16){
            condicion += "Delgadez severa";
        }else if(imc >= 16 && imc < 18.5){
            condicion += "Delgadez";
        }else if(imc >= 18.5 && imc < 25){
            condicion += "Peso saludable";
        }else if(imc >= 25 && imc < 30){
            condicion += "Sobrepeso";
        }else if(imc >= 30 && imc < 35){
            condicion += "Obesidad moderada";
        }else if(imc >= 35 && imc < 40){
            condicion += "Obesidad severa";
        }else if(imc >= 40){
            condicion += "Obesidad muy severa";
        }

        //Desplegamos los resultados en un alertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("IMC")
                .setMessage("IMC = "+ imc + "\n\n" + condicion)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
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