package org.example.clases;

import javax.persistence.Embeddable;

@Embeddable
public class Asignatura {
    private String nombre;
// aaaaa

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Asignatura: " + nombre ;
    }
}
