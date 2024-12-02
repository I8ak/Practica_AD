package org.example.clases;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Profesor {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Asignatura asognatura;
    private Departamento departamento;
    private ArrayList<Alumno> alumnos;

    public Profesor(String id, String nombre, String apellido, Asignatura asognatura, Departamento departamento, ArrayList<Alumno> alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asognatura = asognatura;
        this.departamento = departamento;
        this.alumnos = alumnos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Profesor{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", asognatura=" + asognatura +
                ", departamento=" + departamento +
                ", alumnos=" + alumnos +
                '}';
    }
}
