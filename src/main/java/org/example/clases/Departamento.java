package org.example.clases;

import javax.persistence.Embeddable;

@Embeddable
public class Departamento {
    private String nombre;

    public Departamento(String codigo) {
        this.nombre = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "codigo='" + nombre + '\'' +
                '}';
    }
}
