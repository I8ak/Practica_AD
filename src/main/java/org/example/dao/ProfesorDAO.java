package org.example.dao;

import org.example.clases.ConexionODB;
import org.example.clases.Profesor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProfesorDAO {
    public static void crearProfesor(Profesor profesor) {
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(profesor);
        et.commit();
    }
}
