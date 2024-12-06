/**
 * Clase que representa una asignatura en la aplicación.
 * Está marcada como embeddable para ser utilizada como parte de otra entidad JPA.
 */
package org.example.clases;

import javax.persistence.Embeddable;

@Embeddable
public class Asignatura {

    /** Nombre de la asignatura. */
    private String nombre;

    /**
     * Constructor de la clase Asignatura.
     *
     * @param nombre Nombre de la asignatura.
     */
    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la asignatura.
     *
     * @return Nombre de la asignatura.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la asignatura.
     *
     * @param nombre Nombre de la asignatura.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve una representación en cadena de la asignatura.
     *
     * @return Representación en cadena de la asignatura.
     */
    @Override
    public String toString() {
        return "Asignatura: " + nombre;
    }
}
