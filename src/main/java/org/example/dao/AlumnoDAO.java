package org.example.dao;

import org.example.clases.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashMap;

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
    public static void actualizarAlumno(Alumno alumno) {
        EntityManager em = ConexionODB.getConexion();
        EntityTransaction et = em.getTransaction();
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

    public static void main(String[] args) {
        Asignatura a=new Asignatura("Matematicas");
        Asignatura a1=new Asignatura("Lengua");
        HashMap<Asignatura,Double> asignaturas=new HashMap<>();
        asignaturas.put(a,10.0);
        Clase c=new Clase("34D");
        Clase c2=new Clase("54A");
        Alumno al1=new Alumno("124312","Ishak","Al Helimi",asignaturas,c);
        Alumno al2=new Alumno("876514","Abdessamad","El gaabouri",asignaturas,c);
        ArrayList<Alumno> alumnos=new ArrayList<>();
        alumnos.add(al1);
        alumnos.add(al2);
        crearAlumno(al1);
        crearAlumno(al2);
        al1.setClase(c2);
        actualizarAlumno(al1);
        leerAlumno("124312");
        leerAlumno("876514");
    }

}
