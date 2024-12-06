/**
 * Clase que representa un alumno en la aplicación.
 * Contiene información sobre su NIF, nombre, apellido, asignaturas y la clase a la que pertenece.
 */
package org.example.clases;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Alumno {

    /** NIF del alumno, utilizado como identificador único. */
    @Id
    private String nif;

    /** Nombre del alumno. */
    private String nombre;

    /** Apellido del alumno. */
    private String apellido;

    /** Mapa que relaciona asignaturas con sus respectivas notas. */
    @Embedded @OneToMany(fetch = FetchType.EAGER)
    private Map<Asignatura, Double> asignaturas;

    /** Clase a la que pertenece el alumno. */
    @Embedded
    private Clase clase;

    /**
     * Constructor de la clase Alumno.
     *
     * @param nif NIF del alumno.
     * @param nombre Nombre del alumno.
     * @param apellido Apellido del alumno.
     * @param asignaturas Mapa de asignaturas y sus notas.
     * @param clase Clase a la que pertenece el alumno.
     */
    public Alumno(String nif, String nombre, String apellido, HashMap<Asignatura, Double> asignaturas, Clase clase) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignaturas = asignaturas;
        this.clase = clase;
    }

    /**
     * Obtiene el NIF del alumno.
     *
     * @return NIF del alumno.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Obtiene la clase a la que pertenece el alumno.
     *
     * @return Clase del alumno.
     */
    public Clase getClase() {
        return clase;
    }

    /**
     * Establece la clase a la que pertenece el alumno.
     *
     * @param clase Clase a establecer para el alumno.
     */
    public void setClase(Clase clase) {
        this.clase = clase;
    }

    /**
     * Devuelve una representación en cadena del alumno.
     *
     * @return Representación en cadena del alumno.
     */
    @Override
    public String toString() {
        return "Alumno\n"
                + "\tNIF: " + nif
                + "\n\tNombre: " + nombre
                + "\n\tApellido: " + apellido
                + "\n\t" + asignaturas
                + "\n\t" + clase;
    }
}
