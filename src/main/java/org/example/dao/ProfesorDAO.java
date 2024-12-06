package org.example.dao;

import org.example.Main;
import org.example.clases.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfesorDAO {
    public static void crearProfesor(Profesor profesor) {
        try {
            EntityManager em= ConexionODB.getConexion();
            EntityTransaction et=em.getTransaction();
            et.begin();
            em.persist(profesor);
            et.commit();
            em.close();
        } catch(RollbackException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    //leer
    public static Profesor leerProfesor(String codigo){
        EntityManager em= ConexionODB.getConexion();
        Profesor profesor=em.find(Profesor.class, codigo);
        em.close();
        return profesor;
    }
    public static void actualizarProfesor(Profesor profesor){
        try {
            EntityManager em= ConexionODB.getConexion();
            EntityTransaction et=em.getTransaction();
            leerProfesor(profesor.getId());
            et.begin();
            Profesor profesorExistente = em.find(Profesor.class, profesor.getId());
            profesorExistente.setAsignatura(profesor.getAsignatura());
            profesorExistente.setDepartamento(profesor.getDepartamento());
            profesorExistente.setAlumnos(profesor.getAlumnos());
            et.commit();
        } catch (RollbackException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }

    }
    public static void eliminarProfesor(Profesor profesor){
        try {
            EntityManager em= ConexionODB.getConexion();
            EntityTransaction et=em.getTransaction();
            et.begin();
            em.remove(profesor);
            et.commit();
        } catch (RollbackException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void eliminarAlumnoProfesor(String codigo,Alumno al){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        Profesor profesor=leerProfesor(codigo);
        et.begin();
        for (Alumno a:profesor.getAlumnos()){
            if (a.getNif().equals(al.getNif())){
                AlumnoDAO.eliminarAlumno(a);
            }
        }
        et.commit();

    }

    public static List<Profesor> leerTodosProfes(){
        String sql="select p from Profesor p";
        EntityManager em= ConexionODB.getConexion();
        Query query=em.createQuery(sql);
        List<Profesor> profesores=query.getResultList();
        return profesores;
    }
    public static List<Alumno> leerAlumnosProfesor(String id){
        String sql="select a from Profesor p join p.alumnos a where p.id = ?1";
        EntityManager em= ConexionODB.getConexion();
        Query query=em.createQuery(sql);
        query.setParameter(1, id);
        List alumnos=query.getResultList();
        return alumnos;
    }
}
