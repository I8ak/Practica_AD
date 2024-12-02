package org.example.clases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionODB {
    public static EntityManager getConexion() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("./db/escuela.odb");
        return emf.createEntityManager();
    }
}
