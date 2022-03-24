package mx.edu.itl.c18131273.u3ocultartecladoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import util.OcultarTecladoAdaptador;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layoutPrincipal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtenemos la referencia del layout principal
        layoutPrincipal = findViewById(R.id.layoutPrincipal);
        //Al dar clic en el layout, ocultar el teclado
        layoutPrincipal.setOnClickListener(new OcultarTecladoAdaptador(this));
    }

    public void btnSalirClick(View v){
        finish();
    }

    @Override
    public void onBackPressed() {
        //Anulamos la accion del boton atras
    }
}