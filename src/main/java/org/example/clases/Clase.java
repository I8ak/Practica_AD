/**
 * Clase que representa un aula o clase en la aplicación.
 * Está marcada como embeddable para ser utilizada como parte de otra entidad JPA.
 */
package org.example.clases;

import javax.persistence.Embeddable;

@Embeddable
public class Clase {

    /** Código que identifica la clase. */
    private String codigo;

    /**
     * Constructor de la clase Clase.
     *
     * @param codigo Código identificador de la clase.
     */
    public Clase(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el código de la clase.
     *
     * @return Código de la clase.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de la clase.
     *
     * @param codigo Código identificador de la clase.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve una representación en cadena de la clase.
     *
     * @return Representación en cadena de la clase.
     */
    @Override
    public String toString() {
        return "Clase: " + codigo;
    }
}
