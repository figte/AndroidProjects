package personal.app.appejemplo03.model;

import java.io.Serializable;
import java.util.Date;


public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    String nombre;
    Integer edad;
    String genero;
    Date fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
