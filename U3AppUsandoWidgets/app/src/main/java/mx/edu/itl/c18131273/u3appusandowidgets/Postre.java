/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2022    HORA: 10-11 HRS
:*
:*                       descripcion breve de la clase (centrado)
:*
:*  Archivo     : Postre.java
:*  Autor       : Jose Angel rocha garcia    18131273
:*  Fecha       : 25/ABR/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : Clase para crear un objeto postre
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c18131273.u3appusandowidgets;

public class Postre {
    private String nombre;
    private int imagen;
    private int precio;

    public Postre(String nombre, int imagen, int precio){
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int escudoID) {
        this.imagen = imagen;
    }

    public int getPrecio(){return precio;}

    public void setPrecio(){this.precio = precio;}
}


