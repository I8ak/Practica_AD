package org.example.dao;

import org.example.clases.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import java.util.List;
/**
 * Clase DAO para gestionar operaciones CRUD de la entidad {@link Alumno}.
 * Utiliza JPA para interactuar con la base de datos.
 */
public class AlumnoDAO {

    /**
     * Crea un nuevo alumno en la base de datos.
     *
     * @param alumno Objeto {@link Alumno} a ser persistido en la base de datos.
     */
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

    /**
     * Lee un alumno de la base de datos por su NIF.
     *
     * @param nif Identificador único del alumno (NIF).
     * @return Objeto {@link Alumno} correspondiente al NIF, o {@code null} si no se encuentra.
     */
    public static Alumno leerAlumno(String nif){
        EntityManager em= ConexionODB.getConexion();
        Alumno alumno=em.find(Alumno.class, nif);
        em.close();
        return alumno;
    }

    /**
     * Actualiza un alumno existente en la base de datos.
     *
     * @param alumno Objeto {@link Alumno} con los datos actualizados.
     */
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

    /**
     * Elimina un alumno de la base de datos.
     *
     * @param alumno Objeto {@link Alumno} que se desea eliminar.
     */
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

    /**
     * Obtiene una lista de todos los alumnos registrados en la base de datos.
     *
     * @return Lista de objetos {@link Alumno}.
     */
    public static List<Alumno> leerAlumnos(){
        String sql="SELECT a FROM Alumno a";
        EntityManager em= ConexionODB.getConexion();
        Query query=em.createQuery(sql);
        List<Alumno> alumnos= query.getResultList();
        return alumnos;
    }

    /**
     * Obtiene una lista de alumnos asociados a una clase específica.
     *
     * @param clase Código de la clase cuyos alumnos se desean leer.
     * @return Lista de objetos {@link Alumno} pertenecientes a la clase especificada.
     */
    public static List<Alumno> leerAlumnosClase(String clase){
        String sql="SELECT a FROM Alumno a WHERE a.clase.codigo = :claseCodigo";
        EntityManager em= ConexionODB.getConexion();
        Query query=em.createQuery(sql);
        query.setParameter("claseCodigo", clase);
        List<Alumno> alumnos= query.getResultList();
        return alumnos;
    }
}
