
package org.example.clases;

import javax.persistence.Embeddable;

/**
 * Clase que representa una asignatura en el sistema.
 * La clase es embebida (@Embeddable), lo que significa que sus atributos
 * se integran dentro de otras entidades sin ser mapeada como una entidad independiente en la base de datos.
 */
@Embeddable
public class Asignatura {

    private String nombre;

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Asignatura: " + nombre;
    }
}
