package org.example.clases;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Alumno {
    @Id
    private String nif;
    private String nombre;
    private String apellido;
    @Embedded private Map<Asignatura,Double> asignaturas;
    @Embedded private Clase clase;


    public Alumno(String nif, String nombre, String apellido, HashMap<Asignatura,Double> asignaturas, Clase clase) {
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

    public Map<Asignatura, Double> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Map<Asignatura, Double> asignaturas) {
        this.asignaturas = asignaturas;
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
