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
    //leer
    public static Profesor leerProfesor(String codigo){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        Profesor profesor=em.find(Profesor.class, codigo);
        System.out.println(profesor);
        em.close();
        return profesor;
    }
    public static void actualizarProfesor(Profesor profesor,String codigo){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        leerProfesor(codigo);
        et.begin();
        profesor.setAsignatura(profesor.getAsignatura());
        profesor.setDepartamento(profesor.getDepartamento());
        et.commit();
    }
    public static void eliminarProfesor(Profesor profesor){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(profesor);
        et.commit();
    }
}
