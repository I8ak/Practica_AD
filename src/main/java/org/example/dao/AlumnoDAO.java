package org.example.dao;

import org.example.clases.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlumnoDAO {
    public static void crearAlumno(Alumno alumno) {
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(alumno);
        et.commit();
    }
    //leer

    public static Alumno leerAlumno(String nif){
        EntityManager em= ConexionODB.getConexion();
        Alumno alumno=em.find(Alumno.class, nif);
        em.close();
        return alumno;
    }
    public static void actualizarAlumno(Alumno alumno) {
        EntityManager em = ConexionODB.getConexion();
        EntityTransaction et = em.getTransaction();
        leerAlumno(alumno.getNif());
        et.begin();
        Alumno alumnoExistente = em.find(Alumno.class, alumno.getNif());
        alumnoExistente.setClase(alumno.getClase());
        et.commit();
    }

    public static void eliminarAlumno(Alumno alumno){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        et.begin();
        Alumno alumnoExistente = em.find(Alumno.class, alumno.getNif());
        em.remove(alumnoExistente);
        et.commit();
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

    public static void main(String[] args) {
        Asignatura a=new Asignatura("Matematicas");
        Asignatura a1=new Asignatura("Lengua");
        HashMap<Asignatura,Double> asignaturas=new HashMap<>();
        asignaturas.put(a,10.0);
        Clase c=new Clase("34D");
        Clase c2=new Clase("54A");
        Alumno al1=new Alumno("124312","Ishak","Al Helimi",asignaturas,c);
        Alumno al2=new Alumno("876514","Abdessamad","El gaabouri",asignaturas,c2);
        ArrayList<Alumno> alumnos=new ArrayList<>();
        alumnos.add(al1);
        alumnos.add(al2);
        crearAlumno(al1);
        crearAlumno(al2);
//        al1.setClase(c2);
//        actualizarAlumno(al1);
//        leerAlumno("124312");
//        leerAlumno("876514");
        System.out.println(leerAlumnos());
        System.out.println(leerAlumnosClase("34D"));
    }

}
