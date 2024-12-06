package org.example;


import org.example.clases.*;
import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;

import java.util.*;
//Main
public class Main {
    private static List<Asignatura> listaAsignaturas = new ArrayList();
    private static List<Alumno> listaAlumnos = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean comprobar = true;

        while(comprobar) {
            mostrar();
            int opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    comprobar = false;
                    break;
                case 1:
                    System.out.println("Crear alumnos");
                    crearAlumno();
                    break;
                case 2:
                    System.out.println("Crear profesor");
                    crearProfesor();
                    break;
                case 3:
                    System.out.println("Eliminar alumnos");
                    eliminarAlumno();
                    break;
                case 4:
                    System.out.println("Eliminar profesor");
                    eliminarProfesor();
                    break;
                case 5:
                    eliminarAlumnosProfe();
                    break;
                case 6:
                    System.out.println("Leer alumno");
                    leerAlumno();
                    break;
                case 7:
                    System.out.println("Leer profesor");
                    leerProfesor();
                    break;
                case 8:
                    actualizarAlumno();
                    break;
                case 9:
                    actualizarProfesor();
                    break;
                case 10:
                    AlumnoDAO.leerAlumnos();
                    break;
                case 11:
                    ProfesorDAO.leerTodosProfes();
                    break;
                case 12:
                    leerAlumnosProfesor();
                    break;
                case 13:
                    leerAlumnosClase();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }


    public static void mostrar() {
        System.out.println("Introduce opción: ");
        System.out.println("1. Crear alumnos");
        System.out.println("2. Crear profesor");
        System.out.println("3. Eliminar alumno");
        System.out.println("4. Eliminar profesor");
        System.out.println("5. Eliminar alumno de un profesor");
        System.out.println("6. Leer alumno");
        System.out.println("7. Leer profesor");
        System.out.println("8. Actualizar aula del alumno");
        System.out.println("9. Actualizar departamento, asignatura y alumnos de un profesor");
        System.out.println("10.Leer todos los alumnos");
        System.out.println("11.Leer todos los profesores");
        System.out.println("12.Leer alumnos de un profesor");
        System.out.println("13.Leer los alumnos de un aula");
        System.out.println("0. Salir");
    }


    public static Asignatura crearAsignatura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de la asignatura:");
        String nombre = sc.nextLine();
        Asignatura asignatura = new Asignatura(nombre);
        return asignatura;
    }


    public static Clase crearClase() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del aula:");
        String c = sc.nextLine();
        Clase clase = new Clase(c);
        System.out.println("Clase creada: " + c);
        return clase;
    }


    public static Departamento crearDepartamento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del departamento:");
        String nombre = sc.nextLine();
        Departamento departamento = new Departamento(nombre);
        return departamento;
    }


    public static List<Alumno> crearAlumno() {
        List<Alumno> alumnos = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nif del alumno:");
        String nif = sc.nextLine();
        System.out.println("Introduce el nombre del alumno");
        String nombre = sc.nextLine();
        System.out.println("Introduce el apellido del alumno");
        String apellido = sc.nextLine();
        System.out.println("¿Cuantas asignaturas?");
        int numAsignaturas = sc.nextInt();

        HashMap<Asignatura, Double> alumnoNotas = new HashMap();

        for(int i = 0; i < numAsignaturas; ++i) {
            Asignatura asignatura = crearAsignatura();
            System.out.println("Escribe la nota");
            double nota = sc.nextDouble();
            alumnoNotas.put(asignatura, nota);
        }

        Clase c = crearClase() ;

        Alumno alumno = new Alumno(nif, nombre, apellido, alumnoNotas, c);
        AlumnoDAO.crearAlumno(alumno);
        alumnos.add(alumno);
        listaAlumnos.add(alumno);
        return alumnos;
    }


    public static void crearProfesor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce id de profesor");
        String id = sc.nextLine();
        System.out.println("Introduce nombre del profesor");
        String nombre = sc.nextLine();
        System.out.println("Introduce apellido del profesor");
        String apellido = sc.nextLine();
        Asignatura a = crearAsignatura();
        Departamento d = crearDepartamento();
        Profesor p = new Profesor(id, nombre, apellido, a, d, listaAlumnos);
        ProfesorDAO.crearProfesor(p);
        System.out.println(p);
    }

    public static void eliminarAlumno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF del alumno:");
        String nif = sc.nextLine();
        Alumno a = AlumnoDAO.leerAlumno(nif);
        if (a != null) {
            AlumnoDAO.eliminarAlumno(a);
            System.out.println("Alumno eliminado.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    public static void eliminarProfesor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        Profesor p = ProfesorDAO.leerProfesor(codigo);
        if (p != null) {
            ProfesorDAO.eliminarProfesor(p);
            System.out.println("Profesor eliminado.");
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    public static void leerProfesor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        System.out.println(ProfesorDAO.leerProfesor(codigo));
    }

    public static void leerAlumno(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF alumno:");
        String nif = sc.nextLine();
        System.out.println(AlumnoDAO.leerAlumno(nif));
    }

    public static void actualizarAlumno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF alumno:");
        String nif = sc.nextLine();
        Alumno a = AlumnoDAO.leerAlumno(nif);
        a.setClase(crearClase());
        AlumnoDAO.actualizarAlumno(a);
    }

    public static void actualizarProfesor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        Profesor p = ProfesorDAO.leerProfesor(codigo);
        p.setDepartamento(crearDepartamento());
        p.setAlumnos(crearAlumno());
        p.setAsignatura(crearAsignatura());
        ProfesorDAO.actualizarProfesor(p);
    }
    public static void eliminarAlumnosProfe(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        System.out.println("Introduce el NIF alumno:");
        String nif = sc.nextLine();
        Alumno a = AlumnoDAO.leerAlumno(nif);
        ProfesorDAO.eliminarAlumnoProfesor(codigo,a);
    }
    public static void leerAlumnosProfesor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        ProfesorDAO.leerAlumnosProfesor(codigo);
    }
    public static void leerAlumnosClase(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el codigo del aula:");
        String codigo = sc.nextLine();
        AlumnoDAO.leerAlumnosClase(codigo);
    }






}
