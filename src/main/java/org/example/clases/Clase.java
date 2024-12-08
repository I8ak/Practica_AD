/**
 * Clase que representa un aula o clase en la aplicación.
 * Está marcada como embeddable para ser utilizada como parte de otra entidad JPA.
 */
package org.example.clases;

import javax.persistence.Embeddable;

/**
 * Clase que representa una clase en el sistema.
 * La clase es embebida (@Embeddable), lo que significa que sus atributos
 * se integran dentro de otras entidades sin ser mapeada como una entidad independiente en la base de datos.
 */
@Embeddable
public class Clase {

    private String codigo;



    public Clase(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Clase: " + codigo;
    }
}
