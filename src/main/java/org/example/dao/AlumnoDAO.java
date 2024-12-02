package org.example.dao;

import org.example.clases.Alumno;
import org.example.clases.ConexionODB;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AlumnoDAO {
    public static void crearAlumno(Alumno alumno) {
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(alumno);
        et.commit();
    }
    //leer
    public static Alumno leerAlumno(String codigo){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        Alumno alumno=em.find(Alumno.class, codigo);
        System.out.println(alumno);
        em.close();
        return alumno;
    }
    public static void actualizarAlumno(Alumno alumno,String codigo){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        leerAlumno(codigo);
        et.begin();
        alumno.setAsignaturas(alumno.getAsignaturas());
        et.commit();
    }

    public static void eliminarAlumno(Alumno alumno){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(alumno);
        et.commit();
    }

}
