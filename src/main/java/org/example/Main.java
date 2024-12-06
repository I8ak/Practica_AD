package org.example;


import org.example.clases.*;
import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;

import java.util.*;
/**
 * Clase principal que actúa como punto de entrada para la aplicación.
 * Proporciona un menú interactivo para gestionar alumnos, profesores, asignaturas, aulas y departamentos.
 * Utiliza DAOs para realizar operaciones de persistencia en las entidades.
 */
public class Main {
    /**
     * Lista estática para almacenar las asignaturas.
     */
    private static List<Asignatura> listaAsignaturas = new ArrayList();
    /**
     * Lista estática para almacenar los alumnos.
     */
    private static List<Alumno> listaAlumnos = new ArrayList<>();

    /**
     * Método principal que ejecuta la lógica del programa y presenta un menú interactivo al usuario.
     *
     * @param args Argumentos de línea de comandos.
     */
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
                    System.out.println(AlumnoDAO.leerAlumnos());
                    break;
                case 11:
                    System.out.println(ProfesorDAO.leerTodosProfes());
                    break;
                case 12:
                    leerAlumnosProfesor();
                    break;
                case 13:
                    leerAlumnosClase();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
    /**
     * Muestra el menú de opciones al usuario.
     */
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

    /**
     * Crea una nueva asignatura solicitando datos al usuario.
     *
     * @return Objeto Asignatura creado.
     */
    public static Asignatura crearAsignatura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de la asignatura:");
        String nombre = sc.nextLine();
        Asignatura asignatura = new Asignatura(nombre);
        return asignatura;
    }

    /**
     * Crea una nueva clase solicitando datos al usuario.
     *
     * @return Objeto Clase creado.
     */
    public static Clase crearClase() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del aula:");
        String c = sc.nextLine();
        Clase clase = new Clase(c);
        System.out.println("Clase creada: " + c);
        return clase;
    }

    /**
     * Crea un nuevo departamento solicitando datos al usuario.
     *
     * @return Objeto Departamento creado.
     */
    public static Departamento crearDepartamento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del departamento:");
        String nombre = sc.nextLine();
        Departamento departamento = new Departamento(nombre);
        return departamento;
    }

    /**
     * Crea una lista de alumnos solicitando datos al usuario.
     *
     * @return Lista de alumnos creada.
     */
    public static List<Alumno> crearAlumno() {
        List<Alumno> alumnos = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nif del alumno a crear:");
        String nif = sc.nextLine();
        System.out.println("Introduce el nombre del alumno a crear");
        String nombre = sc.nextLine();
        System.out.println("Introduce el apellido del alumno a crear");
        String apellido = sc.nextLine();
        System.out.println("¿Cuántas asignaturas tiene?");
        int numAsignaturas = sc.nextInt();

        HashMap<Asignatura, Double> alumnoNotas = new HashMap();

        for(int i = 0; i < numAsignaturas; ++i) {
            Asignatura asignatura = crearAsignatura();
            System.out.println("Escribe la nota");
            double nota = 0;
            boolean correcto =true;
            while (correcto) {
                try {
                    nota = sc.nextDouble();
                    correcto = false;
                }catch (InputMismatchException e){
                    System.out.println("Introudce un numero");
                    sc.nextLine();
                    correcto =true;
                }
            }

            alumnoNotas.put(asignatura, nota);
        }

        Clase c = crearClase() ;

        Alumno alumno = new Alumno(nif, nombre, apellido, alumnoNotas, c);
        AlumnoDAO.crearAlumno(alumno);
        alumnos.add(alumno);
        listaAlumnos.add(alumno);
        return alumnos;
    }

    /**
     * Crea un nuevo profesor solicitando datos al usuario.
     */
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
    /**
     * Elimina un alumno solicitando su NIF.
     */
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

    /**
     * Elimina un profesor solicitando su NIF.
     */
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

    /**
     * Lee los datos de un profesor solicitando su NIF.
     */
    public static void leerProfesor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        System.out.println(ProfesorDAO.leerProfesor(codigo));
    }

    /**
     * Lee los datos de un alumno solicitando su NIF.
     */
    public static void leerAlumno(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF alumno:");
        String nif = sc.nextLine();
        System.out.println(AlumnoDAO.leerAlumno(nif));
    }

    /**
     * Actualiza el aula de un alumno solicitando su NIF.
     */
    public static void actualizarAlumno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF alumno:");
        String nif = sc.nextLine();
        Alumno a = AlumnoDAO.leerAlumno(nif);
        a.setClase(crearClase());
        AlumnoDAO.actualizarAlumno(a);
    }

    /**
     * Actualiza los datos de un profesor solicitando su NIF.
     * Actualiza el departamento, la asignatura y la lista de alumnos asociados.
     */
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
    /**
     * Elimina un alumno asociado a un profesor especificando ambos identificadores.
     */
    public static void eliminarAlumnosProfe(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        System.out.println("Introduce el NIF alumno:");
        String nif = sc.nextLine();
        Alumno a = AlumnoDAO.leerAlumno(nif);
        ProfesorDAO.eliminarAlumnoProfesor(codigo,a);
    }
    /**
     * Lee y muestra los alumnos asociados a un profesor especificando el NIF del profesor.
     */
    public static void leerAlumnosProfesor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        System.out.println(ProfesorDAO.leerAlumnosProfesor(codigo));
    }
    /**
     * Lee y muestra los alumnos de un aula especificando el código del aula.
     */
    public static void leerAlumnosClase(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el codigo del aula:");
        String codigo = sc.nextLine();
        System.out.println(AlumnoDAO.leerAlumnosClase(codigo));
    }
}
