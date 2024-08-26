package com.ulpmovil.tp1;

import java.io.Serializable;

public class Palabra implements Serializable {

    private String palabra;

    private String traduccion;

    private int imageId;


    public Palabra(String palabra, String traduccion, int imageId) {
        this.imageId = imageId;
        this.palabra = palabra;
        this.traduccion = traduccion;


    }

    public String getPalabra() {
        return palabra;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public int getImageId() {
        return imageId;
    }
}
