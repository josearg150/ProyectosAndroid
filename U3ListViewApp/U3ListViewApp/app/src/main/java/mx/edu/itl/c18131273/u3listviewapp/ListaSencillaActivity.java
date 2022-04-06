package mx.edu.itl.c18131273.u3listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaSencillaActivity extends AppCompatActivity {

    private final String [] estados   = { "Aguascalientes", "Baja California", "Coahuila", "Edo. de Mexico", "Yucatan",
                                          "Hidalgo", "Guerrero", "Veracruz", "Sinaloa", "Zacatecas",
                                          "Tamaulipas", "Nuevo Leon", "Jalisco", "Quintana Roo" };
    private final String [] capitales = { "Aguascalientes", "Mexicali", "Saltillo", "Toluca", "Merida",
                                          "Pachuca", "Chilpancingo", "Xalapa", "Culiacan", "Zacatecas",
                                          "Cd. Victoria", "Monterrey", "Guadalajara", "Chetumal"
                                        };

    private TextView txtvResultado;
    private ListView lstvEstados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sencilla);

        txtvResultado = findViewById ( R.id.txtvResultado );
        lstvEstados   = findViewById ( R.id.lstvEstados   );

        // Se crea un ArrayAdapter: El 2o argumento debe ser el id de un recurso TEXTVIEW
        //                          El 3er argumento es la lista de Strings con los que se va a llenar
        ArrayAdapter adaptador = new ArrayAdapter(this, R.layout.list_fila_sencilla, estados);

        lstvEstados.setAdapter(adaptador);
        // Establecemos el listener para el evento OnItemClick  del ListView
        lstvEstados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtvResultado.setText(
                        "La capital del estado de " + estados[position] +
                        " es " + capitales [position]
                );

                //Otra forma de obtener el nombre del Estado seleccionado
                String estado = ((TextView) view).getText().toString();
                Toast.makeText(getApplicationContext(),
                        "Selecciono: " + estado,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }


}
