package mx.edu.itl.c18131273.u3appusandowidgets;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_pedidos extends AppCompatActivity {
    EditText codigoABuscar;
    TextView pedidoEncontrado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        codigoABuscar = (EditText) findViewById(R.id.editTextCodigoBuscar);
        pedidoEncontrado = (TextView) findViewById(R.id.textViewPedido);
    }

    public void verPedidos(View v){


        String codigo = codigoABuscar.getText().toString();
        if(codigo.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(activity_pedidos.this);
            builder.setTitle("Codigo de pedido vacio").
                    setMessage("Por favor llena el codigo")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create()
                    .show();
        }else{
            AdminSQLiteOpenHelper openHelp = new AdminSQLiteOpenHelper(this, "pasteleriaTec", null, 1);
            SQLiteDatabase baseDeDatos = openHelp.getWritableDatabase();
            String numP = codigoABuscar.getText().toString();
            String pastel,precioPastel,postre1,precioPostre1,postre2,precioPostre2, dom, nom,precioF = "";
            //Cursor fila = baseDeDatos.rawQuery("select pastel,precio_pastel,postre1,precio_postre1,postre2,precio_postre2,domicilio,nombre,precio_final from pedidosGuardados where num_pedido = "+numP,null);
            Cursor fila = baseDeDatos.rawQuery("select pastel from pedidosGuardados where num_pedido = "+numP,null);
            if(fila.moveToFirst()){
                pastel = fila.getString(0);
              /*  precioPastel = fila.getString(1);
                postre1 = fila.getString(2);
                precioPostre1 = fila.getString(3);
                postre2 = fila.getString(4);
                precioPostre2 = fila.getString(5);
                dom = fila.getString(6);
                nom = fila.getString(7);
                precioF = fila.getString(8);
                baseDeDatos.close();*/
                pedidoEncontrado.setText("Pastel = "+pastel);
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(activity_pedidos.this);
                builder.setTitle("El pedido no existe").
                        setMessage("Por favor escribe un codigo valido")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create()
                        .show();
                baseDeDatos.close();
            }

        }
    }
}