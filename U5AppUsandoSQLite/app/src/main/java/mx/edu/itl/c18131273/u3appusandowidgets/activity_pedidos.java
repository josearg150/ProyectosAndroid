/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*                       Clase para ver los pedidos guardados
:*
:*  Archivo     : activity_pedidos.java
:*  Autor       : jose angel rocha garcia 18131273
:*  Fecha       : 29/05/2022
:*  Compilador  : Android Studio bumblebee 2021.1.1
:*  Descripcion : Esta clase contiene los metodos para mostrar informacion de pedidos
:*  Ultima modif:
:*  Fecha       Modifico             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c18131273.u3appusandowidgets;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class activity_pedidos extends AppCompatActivity {
    EditText codigoABuscar;
    TextView pedidoEncontrado;
    private Button botonEntregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        codigoABuscar = (EditText) findViewById(R.id.editTextCodigoBuscar);
        pedidoEncontrado = (TextView) findViewById(R.id.textViewPedido);
        botonEntregar = (Button) findViewById(R.id.btnConfirmar);
        botonEntregar.setEnabled(false);
    }
    public void entregarPedido(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity_pedidos.this);
        builder.setTitle("Pedido confirmado").
                setMessage("Tu pedido llegara en un momento")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }

    public void eliminarTodo(View v){
        AdminSQLiteOpenHelper baseDeDatos = new AdminSQLiteOpenHelper(this);
        baseDeDatos.eliminarRegistros();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity_pedidos.this);
        builder.setTitle("Pedidos eliminados").
                setMessage("Se eliminaron todos tus pedidos con exito")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
        pedidoEncontrado.setText("");
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
            AdminSQLiteOpenHelper baseDeDatos = new AdminSQLiteOpenHelper(this);
            String numP = codigoABuscar.getText().toString();
            String pedido = baseDeDatos.consultarRegistro(numP);
            if(!pedido.isEmpty()){
                pedidoEncontrado.setText(pedido);
                botonEntregar.setEnabled(true);
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