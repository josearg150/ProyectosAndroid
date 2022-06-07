/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*                       Clase para conectarse con la base de datos
:*
:*  Archivo     : AdminSQLiteOpenHelper.java
:*  Autor       : jose angel rocha garcia 18131273
:*  Fecha       : 29/05/2022
:*  Compilador  : Android Studio bumblebee 2021.1.1
:*  Descripcion : Esta clase contiene los metodos para modificar o crear la base de datos
:*  Ultima modif:
:*  Fecha       Modifico             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c18131273.u3appusandowidgets;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public static final String nombreBD = "pasteleriaTec.db";
    public static final String tabla = "pedidosGuardados";

    public AdminSQLiteOpenHelper(Context context){
        super(context, nombreBD,null,1);}


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Creacion de la base de datos
       sqLiteDatabase.execSQL("create table "+tabla+"" +
               "(num_pedido int primary key, " +
               "pastel text, " +
               "precio_pastel int, " +
               "postre1 text, " +
               "precio_postre1 int, " +
               "postre2 text, " +
               "precio_postre2 int, " +
               "domicilio text, " +
               "nombre text, " +
               "precio_final int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void guardarRegistro(int numPedido, String pastel,int precio_pastel,
                                String postre1, int precio_postre1,
                                String postre2, int precio_postre2,
                                String domicilio, String nombre, int precioFinal){

        SQLiteDatabase baseDeDatos = this.getWritableDatabase();
        ContentValues registro = new ContentValues();

        registro.put("num_pedido", numPedido);
        registro.put("pastel", pastel);
        registro.put("precio_pastel", precio_pastel);
        registro.put("postre1", postre1);
        registro.put("precio_postre1", precio_postre1);
        registro.put("postre2", postre2);
        registro.put("precio_postre2", precio_postre2);
        registro.put("domicilio", domicilio);
        registro.put("nombre", nombre);
        registro.put("precio_final", precioFinal);

        baseDeDatos.insert(tabla,null,registro);
        baseDeDatos.close();
    }
    public void eliminarRegistros(){
        SQLiteDatabase baseDeDatos = getWritableDatabase();
        baseDeDatos.execSQL("delete from "+tabla);
        baseDeDatos.close();
    }
    public String consultarRegistro(String numPedido){
        String pedido = "";
        SQLiteDatabase baseDeDatos = this.getReadableDatabase();
        Cursor cursor  = baseDeDatos.rawQuery
                ("select pastel,precio_pastel,postre1,precio_postre1,postre2,precio_postre2,domicilio,nombre,precio_final from "+tabla+" where num_pedido = "+numPedido,null);
       // Cursor cursor  = baseDeDatos.rawQuery("select pastel from "+tabla,null);
        if(cursor.moveToFirst()){
            pedido = "Numero de pedido:"+numPedido+
                    "\nPastel:"+cursor.getString(0)+
                    "\nPrecio de pastel: "+cursor.getString(1)+
                    "\nPostre 1: "+cursor.getString(2)+
                    "\nPrecio postre 1: "+cursor.getString(3)+
                    "\nPostre 2: "+cursor.getString(4)+
                    "\nPrecio postre 2: "+cursor.getString(5)+
                    "\nDomicilio de entrega:"+cursor.getString(6)+
                    "\nNombre: "+cursor.getString(7)+
                    "\nTotal a pagar: "+cursor.getString(8);
        }while(cursor.moveToNext());

        cursor.close();
        baseDeDatos.close();
        return pedido;
    }
}
