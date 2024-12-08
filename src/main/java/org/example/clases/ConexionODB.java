/**
 * Clase de utilidad para gestionar la conexión con la base de datos ObjectDB.
 */
package org.example.clases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase que gestiona la conexión a la base de datos ObjectDB.
 * Esta clase proporciona un método para establecer una conexión con una base de datos ObjectDB
 * y obtener un {@link EntityManager} que se puede utilizar para realizar operaciones en la base de datos.
 */
public class ConexionODB {

    public static EntityManager getConexion() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./db/escuela.odb");
        return emf.createEntityManager();
    }
}
