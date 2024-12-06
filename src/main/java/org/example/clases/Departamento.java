/**
 * Clase que representa un departamento en la aplicación.
 * Está marcada como embeddable para ser utilizada como parte de otra entidad JPA.
 */
package org.example.clases;

import javax.persistence.Embeddable;

@Embeddable
public class Departamento {

    /** Nombre del departamento. */
    private String nombre;

    /**
     * Constructor de la clase Departamento.
     *
     * @param codigo Nombre o código del departamento.
     */
    public Departamento(String codigo) {
        this.nombre = codigo;
    }

    /**
     * Obtiene el nombre del departamento.
     *
     * @return Nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del departamento.
     *
     * @param nombre Nombre del departamento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve una representación en cadena del departamento.
     *
     * @return Representación en cadena del departamento.
     */
    @Override
    public String toString() {
        return "Departamento: " + nombre;
    }
}
