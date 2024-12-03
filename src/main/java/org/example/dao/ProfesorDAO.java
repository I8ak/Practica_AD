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
        em.close();
    }
    //leer
    public static Profesor leerProfesor(String codigo){
        EntityManager em= ConexionODB.getConexion();
        Profesor profesor=em.find(Profesor.class, codigo);
        em.close();
        return profesor;
    }
    public static void actualizarProfesor(Profesor profesor){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        leerProfesor(profesor.getId());
        et.begin();
        Profesor profesorExistente = em.find(Profesor.class, profesor.getId());

        profesorExistente.setAsignatura(profesor.getAsignatura());
        profesorExistente.setDepartamento(profesor.getDepartamento());
        profesorExistente.setAlumnos(profesor.getAlumnos());
        et.commit();
    }
    public static void eliminarProfesor(Profesor profesor){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        et.begin();
        Profesor profesorExistente = em.find(Profesor.class, profesor.getId());
        profesorExistente.setAlumnos(null);
        em.remove(profesorExistente);
        et.commit();
    }

    public static void eliminarAlumnoProfesor(String codigo,Alumno al){
        EntityManager em= ConexionODB.getConexion();
        EntityTransaction et=em.getTransaction();
        Profesor profesor=leerProfesor(codigo);
        et.begin();
        for (Alumno a:profesor.getAlumnos()){
            if (a.getNif().equals(al.getNif())){
                AlumnoDAO.eliminarAlumno(a);
                profesor.eliminarAlumnoArray(al,profesor);
            }
        }
    }


    public static void main(String[] args) {
        Asignatura a=new Asignatura("Matematicas");
        Asignatura a1=new Asignatura("Lengua");
        Departamento d=new Departamento("Informática");
        Departamento d1=new Departamento("Idiomas");
        HashMap<Asignatura,Double> asignaturas=new HashMap<>();
        asignaturas.put(a,10.0);
        Clase c=new Clase("34D");
        Alumno al1=new Alumno("124312","Ishak","Al Helimi",asignaturas,c);
        Alumno al2=new Alumno("876514","Abdessamad","El gaabouri",asignaturas,c);
        ArrayList<Alumno> alumnos=new ArrayList<>();
        alumnos.add(al1);
        alumnos.add(al2);
        Profesor p=new Profesor("1545S","Miguel","Anguel",a,d,alumnos);
        AlumnoDAO.crearAlumno(al1);
        AlumnoDAO.crearAlumno(al2);
        crearProfesor(p);
        System.out.println(leerProfesor("1545S"));
//        Profesor pActualizado=leerProfesor("1545S");
//        System.out.println(pActualizado);
//        p.setAsignatura(a1);
//        p.setDepartamento(d1);
//        actualizarProfesor(p);
        //System.out.println(p.getAlumnos());
//        System.out.println(p.getAlumnos());
//        AlumnoDAO.eliminarAlumno(al1);
//        AlumnoDAO.eliminarAlumno(al2);
//        eliminarProfesor(p);
//        System.out.println(leerProfesor("1545S"));
        eliminarAlumnoProfesor("1545S",al1);
        System.out.println(leerProfesor("1545S"));

//        System.out.println(leerProfesor("1545S"));
//        Profesor pLeido=
//        actualizarProfesor(pLeido);


    }
}
