package com.doctordocplus.espotifai;

/**
 * Created by Bryam Soto on 03/06/2017.
 */

public class Musica {

    private String nombre;
    private String artista;
    private int imagen;

    public Musica(){

    }

    public Musica(String nombre, String artista, int imagen) {
        this.nombre = nombre;
        this.artista = artista;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
