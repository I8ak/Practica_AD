/**
 * Clase DAO para gestionar las operaciones CRUD relacionadas con la entidad {@link Profesor}.
 * Utiliza JPA para interactuar con la base de datos.
 */
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

    /**
     * Crea un nuevo profesor en la base de datos.
     *
     * @param profesor Objeto {@link Profesor} que se desea persistir.
     */
    public static void crearProfesor(Profesor profesor) {
        try {
            EntityManager em = ConexionODB.getConexion();
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(profesor);
            et.commit();
            em.close();
        } catch (RollbackException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    /**
     * Lee un profesor de la base de datos utilizando su código único.
     *
     * @param codigo Identificador único del profesor.
     * @return Objeto {@link Profesor} correspondiente al código, o {@code null} si no se encuentra.
     */
    public static Profesor leerProfesor(String codigo) {
        EntityManager em = ConexionODB.getConexion();
        Profesor profesor = em.find(Profesor.class, codigo);
        em.close();
        return profesor;
    }

    /**
     * Actualiza los datos de un profesor existente en la base de datos.
     *
     * @param profesor Objeto {@link Profesor} con los datos actualizados.
     */
    public static void actualizarProfesor(Profesor profesor) {
        try {
            EntityManager em = ConexionODB.getConexion();
            EntityTransaction et = em.getTransaction();
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

    /**
     * Elimina un profesor de la base de datos.
     *
     * @param profesor Objeto {@link Profesor} que se desea eliminar.
     */
    public static void eliminarProfesor(Profesor profesor) {
        try {
            EntityManager em = ConexionODB.getConexion();
            EntityTransaction et = em.getTransaction();
            et.begin();
            Profesor profesorExistente = em.find(Profesor.class,profesor.getId());
            em.remove(profesorExistente);
            et.commit();
        } catch (RollbackException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    /**
     * Elimina un alumno asociado a un profesor en la base de datos.
     *
     * @param codigo Código único del profesor.
     * @param al     Objeto {@link Alumno} que se desea eliminar de los alumnos asociados al profesor.
     */
    public static void eliminarAlumnoProfesor(String codigo, Alumno al) {
        EntityManager em = ConexionODB.getConexion();
        EntityTransaction et = em.getTransaction();
        Profesor profesor = leerProfesor(codigo);
        et.begin();
        for (Alumno a : profesor.getAlumnos()) {
            if (a.getNif().equals(al.getNif())) {
                AlumnoDAO.eliminarAlumno(a);
            }
        }
        et.commit();
    }

    /**
     * Obtiene una lista de todos los profesores registrados en la base de datos.
     *
     * @return Lista de objetos {@link Profesor}.
     */
    public static List<Profesor> leerTodosProfes() {
        String sql = "SELECT p FROM Profesor p";
        EntityManager em = ConexionODB.getConexion();
        Query query = em.createQuery(sql);
        List<Profesor> profesores = query.getResultList();
        return profesores;
    }

    /**
     * Obtiene una lista de alumnos asociados a un profesor específico.
     *
     * @param id Identificador único del profesor.
     * @return Lista de objetos {@link Alumno} asociados al profesor.
     */
    public static List<Alumno> leerAlumnosProfesor(String id) {
        String sql = "SELECT a FROM Profesor p JOIN p.alumnos a WHERE p.id = ?1";
        EntityManager em = ConexionODB.getConexion();
        Query query = em.createQuery(sql);
        query.setParameter(1, id);
        List alumnos = query.getResultList();
        return alumnos;
    }
}
