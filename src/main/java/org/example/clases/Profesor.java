/**
 * Clase que representa un profesor en la aplicación.
 * Incluye atributos como su identificación, nombre, apellido, asignatura que imparte,
 * departamento al que pertenece y la lista de alumnos asociados.
 */
package org.example.clases;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profesor {

    /** Identificador único del profesor. */
    @Id
    private String id;

    /** Nombre del profesor. */
    private String nombre;

    /** Apellido del profesor. */
    private String apellido;

    /** Asignatura que imparte el profesor. */
    @Embedded
    private Asignatura asignatura;

    /** Departamento al que pertenece el profesor. */
    @Embedded
    private Departamento departamento;

    /** Lista de alumnos asociados al profesor. */
    @OneToMany(fetch = FetchType.EAGER)
    private List<Alumno> alumnos;

    /**
     * Constructor de la clase Profesor.
     *
     * @param id          Identificador único del profesor.
     * @param nombre      Nombre del profesor.
     * @param apellido    Apellido del profesor.
     * @param asignatura  Asignatura que imparte el profesor.
     * @param departamento Departamento al que pertenece el profesor.
     * @param alumnos     Lista de alumnos asociados al profesor.
     */
    public Profesor(String id, String nombre, String apellido, Asignatura asignatura, Departamento departamento, List<Alumno> alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignatura = asignatura;
        this.departamento = departamento;
        this.alumnos = alumnos;
    }

    /**
     * Obtiene el identificador único del profesor.
     *
     * @return ID del profesor.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del profesor.
     *
     * @param id ID del profesor.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del profesor.
     *
     * @return Nombre del profesor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del profesor.
     *
     * @param nombre Nombre del profesor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del profesor.
     *
     * @return Apellido del profesor.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del profesor.
     *
     * @param apellido Apellido del profesor.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la asignatura que imparte el profesor.
     *
     * @return Asignatura del profesor.
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     * Establece la asignatura que imparte el profesor.
     *
     * @param asignatura Asignatura del profesor.
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    /**
     * Obtiene el departamento al que pertenece el profesor.
     *
     * @return Departamento del profesor.
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento al que pertenece el profesor.
     *
     * @param departamento Departamento del profesor.
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene la lista de alumnos asociados al profesor.
     *
     * @return Lista de alumnos.
     */
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * Establece la lista de alumnos asociados al profesor.
     *
     * @param alumnos Lista de alumnos.
     */
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Devuelve una representación en cadena del profesor con sus atributos.
     *
     * @return Representación en cadena del profesor.
     */
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
