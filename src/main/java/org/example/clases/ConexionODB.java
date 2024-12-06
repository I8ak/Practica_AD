/**
 * Clase de utilidad para gestionar la conexión con la base de datos ObjectDB.
 */
package org.example.clases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionODB {

    /**
     * Establece una conexión con la base de datos ObjectDB y devuelve un
     * {@link EntityManager} para realizar operaciones en la base de datos.
     *
     * @return Un objeto {@link EntityManager} conectado a la base de datos.
     */
    public static EntityManager getConexion() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./db/escuela.odb");
        return emf.createEntityManager();
    }
}
