/**
 * Clase que representa un profesor en la aplicación.
 * Incluye atributos como su identificación, nombre, apellido, asignatura que imparte,
 * departamento al que pertenece y la lista de alumnos asociados.
 */
package org.example.clases;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un profesor dentro del sistema educativo.
 * Los objetos de esta clase se corresponden con registros en la tabla de profesores.
 * El profesor tiene un identificador único, un nombre, un apellido, una asignatura que imparte,
 * un departamento al que pertenece y una lista de alumnos asignados.
 */
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
        return "Profesor:\n"
                + "\tCodigo " + id
                + "\n\tNombre: " + nombre
                + "\n\tApellido: " + apellido
                + "\n\t" + asignatura
                + "\n\t" + departamento
                + "\n\t" + alumnos;
    }
}
