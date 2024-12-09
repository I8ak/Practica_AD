/**
 * Clase que representa un departamento en la aplicación.
 * Está marcada como embeddable para ser utilizada como parte de otra entidad JPA.
 */
package org.example.clases;

import javax.persistence.Embeddable;

/**
 * Clase que representa un departamento dentro de un sistema educativo u organizativo.
 * La clase es embebida (@Embeddable), lo que significa que sus atributos
 * se integran dentro de otras entidades sin ser mapeada como una entidad independiente en la base de datos.
 */
@Embeddable
public class Departamento {

    private String nombre;


    public Departamento(String codigo) {
        this.nombre = codigo;
    }


    @Override
    public String toString() {
        return "Departamento: " + nombre;
    }
}
