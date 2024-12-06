package org.example.dao;

import org.example.clases.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlumnoDAO {
    public static void crearAlumno(Alumno alumno) {
        try {
            EntityManager em= ConexionODB.getConexion();
            EntityTransaction et=em.getTransaction();
            et.begin();
            em.persist(alumno);
            et.commit();
        } catch (RollbackException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }
    public static Alumno leerAlumno(String nif){
        EntityManager em= ConexionODB.getConexion();
        Alumno alumno=em.find(Alumno.class, nif);
        em.close();
        return alumno;
    }
    public static void actualizarAlumno(Alumno alumno) {
        try {
            EntityManager em = ConexionODB.getConexion();
            EntityTransaction et = em.getTransaction();
            leerAlumno(alumno.getNif());
            et.begin();
            Alumno alumnoExistente = em.find(Alumno.class, alumno.getNif());
            alumnoExistente.setClase(alumno.getClase());
            et.commit();
        } catch (RollbackException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void eliminarAlumno(Alumno alumno){
        try {
            EntityManager em= ConexionODB.getConexion();
            EntityTransaction et=em.getTransaction();
            et.begin();
            Alumno alumnoExistente = em.find(Alumno.class, alumno.getNif());
            em.remove(alumnoExistente);
            et.commit();
        } catch (RollbackException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    public static List<Alumno> leerAlumnos(){
        String sql="select a from Alumno a";
        EntityManager em= ConexionODB.getConexion();
        Query query=em.createQuery(sql);
        List<Alumno> alumnos= query.getResultList();
        return alumnos;
    }
    public static List<Alumno> leerAlumnosClase(String clase){
        String sql="select a from Alumno a where a.clase.codigo = :claseCodigo";
        EntityManager em= ConexionODB.getConexion();
        Query query=em.createQuery(sql);
        query.setParameter("claseCodigo", clase);
        List<Alumno> alumnos= query.getResultList();
        return alumnos;
    }
}
