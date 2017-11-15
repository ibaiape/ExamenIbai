package com.example.dm2.examen;

import android.graphics.drawable.Drawable;

/**
 * Created by dm2 on 15/11/2017.
 */

public class Localidad {

    private String nombre;
    private String provincia;
    private String ubicacion;
    private Drawable imagen;
    private String url;

    public Localidad() {
    }

    public Localidad(String nombre, String provincia, String ubicacion, Drawable imagen, String url) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
