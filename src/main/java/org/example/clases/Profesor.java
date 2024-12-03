package org.example.clases;

import org.example.dao.ProfesorDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profesor {
    @Id private String id;
    private String nombre;
    private String apellido;
    @Embedded private Asignatura asignatura;
    @Embedded private Departamento departamento;
    @OneToMany(fetch = FetchType.EAGER) private List<Alumno> alumnos;

    public Profesor(String id, String nombre, String apellido, Asignatura asignatura, Departamento departamento, List<Alumno> alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignatura = asignatura;
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

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {

        return "Profesor{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", asognatura=" + asignatura +
                ", departamento=" + departamento +
                ", alumnos=" +alumnos +
                '}';
    }

    public void eliminarAlumnoArray(Alumno alumno,Profesor p){
        for (Alumno a: alumnos){
            if (a.getNif().equals(alumno.getNif())){
                alumnos.remove(a);
                ProfesorDAO.actualizarProfesor(p);
            }
        }
    }
}
