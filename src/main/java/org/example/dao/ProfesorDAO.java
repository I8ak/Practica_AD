package org.example.dao;

import org.example.Main;
import org.example.clases.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashMap;

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

    public static void main(String[] args) {
        Asignatura a=new Asignatura("Matematicas");
        Departamento d=new Departamento("Informática");
        HashMap<Asignatura,Double> asignaturas=new HashMap<>();
        asignaturas.put(a,10.0);
        Clase c=new Clase("34D");
        Alumno al1=new Alumno("124312","Ishak","Al Helimi",asignaturas,c);
        ArrayList<Alumno> alumnos=new ArrayList<>();
        alumnos.add(al1);
        Profesor p=new Profesor("1545S","Miguel","Anguel",a,d,alumnos);
        crearProfesor(p);

    }
    public static void eliminarAlumnoProfesor(String codigo){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        leerProfesor(codigo);
        et.begin();
        Profesor profesor=null ;
        

    }
}
