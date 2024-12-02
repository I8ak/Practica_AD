package org.example.clases;

import javax.persistence.Entity;
import java.util.HashMap;

@Entity
public class Alumnos {
    private String nif;
    private String nombre;
    private String apellido;
    private HashMap<Asignatura,Double> asignaturas;
    private Clase clase;


    public Alumnos(String nif, String nombre, String apellido, HashMap<Asignatura,Double> asignaturas, Clase clase) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignaturas = asignaturas;
        this.clase = clase;
    }


    public String getNif() {
        return nif;
    }


    public void setNif(String nif) {
        this.nif = nif;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    @Override
    public String toString() {
        return "Alumnos{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", asignaturas=" + asignaturas +
                ", clase=" + clase +
                '}';
    }


}
