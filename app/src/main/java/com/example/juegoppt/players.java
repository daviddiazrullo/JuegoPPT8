package com.example.juegoppt;

public class players {
    int id;
    String nombre;
    int puntuacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    @Override
    public String toString(){
    return ( "ID : "+id+ " \n"+
             "Nombre : " + nombre +"\n"+
            "Puntuacion : "+ puntuacion
            );
   }
}
