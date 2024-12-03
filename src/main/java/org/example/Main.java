package org.example;

import org.example.clases.*;
import org.example.dao.ProfesorDAO;

import java.util.*;

public class Main {
    private static List<Asignatura> listaAsignaturas = new ArrayList<>();
    private static List<Alumno> listaAlumnos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean comprobar = true;

        while (comprobar) {
            mostrar();
            int opcion = sc.nextInt();
            sc.nextLine();

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
                    System.out.println("Eliminar asignatura");
                    break;
                case 4:
                    System.out.println("Eliminar departamento");
                    break;
                case 5:
                    System.out.println("Leer profesor");
                    break;
                case 6:
                    System.out.println("Leer asignatura");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }


    public static void mostrar() {
        System.out.println("Introduce opción: ");
        System.out.println("1. Crear alumnos");
        System.out.println("2. Crear profesor");
        System.out.println("3. Eliminar asignatura");
        System.out.println("4. Eliminar departamento");
        System.out.println("5. Leer profesor");
        System.out.println("6. Leer asignatura");
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
        System.out.println("Introduce el nombre de la clase:");
        String clas = sc.nextLine();
        Clase clase = new Clase(clas);
        System.out.println("Clase creada: " + clas);
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
        List<Alumno> alumnos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nif del alumno:");
        String nif = sc.nextLine();
        System.out.println("Introduce el nombre del alumno");
        String nombre = sc.nextLine();
        System.out.println("Introduce el apellido del alumno");
        String apellido = sc.nextLine();
        System.out.println("¿Cuantas asignaturas?");
        int numAsignaturas = sc.nextInt();
        Asignatura asignatura = null;
        HashMap<Asignatura, Double> alumnoNotas = new HashMap<>();

        for (int i = 0; i < numAsignaturas; ++i) {
            asignatura = crearAsignatura();
            System.out.println("Escribe la nota");
            double nota = sc.nextDouble();
            alumnoNotas.put(asignatura, nota);
        }

        Clase c = crearClase();
        Alumno alumno = new Alumno(nif, nombre, apellido, alumnoNotas, c);
        alumnos.add(alumno);
        System.out.println(alumno);
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
        System.out.println(p);
    }


    public static void eliminarProfesor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF profesor:");
        String codigo = sc.nextLine();
        Profesor p = ProfesorDAO.leerProfesor(codigo);
        ProfesorDAO.eliminarProfesor(p);
    }


    public static void eliminarAlumno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF del alumno:");
        String nif = sc.nextLine();
        Alumno alumno = buscarAlumnoPorNif(nif);
        if (alumno == null) {
            System.out.println("No se encontró un alumno con ese NIF.");
        } else {
            Map<Asignatura, Double> asignaturas = alumno.getAsignaturas();
            if (asignaturas.isEmpty()) {
                System.out.println("El alumno no tiene asignaturas registradas.");
            } else {
                System.out.println("Asignaturas del alumno:");
                Iterator var4 = asignaturas.keySet().iterator();

                Asignatura asignaturaAEliminar;
                while (var4.hasNext()) {
                    asignaturaAEliminar = (Asignatura) var4.next();
                    System.out.println("- " + asignaturaAEliminar.getNombre());
                }

                System.out.println("Introduce el nombre de la asignatura que deseas eliminar:");
                String nombreAsignatura = sc.nextLine();
                asignaturaAEliminar = null;
                Iterator var6 = asignaturas.keySet().iterator();

                while (var6.hasNext()) {
                    Asignatura asignatura = (Asignatura) var6.next();
                    if (asignatura.getNombre().equalsIgnoreCase(nombreAsignatura)) {
                        asignaturaAEliminar = asignatura;
                        break;
                    }
                }

                if (asignaturaAEliminar != null) {
                    asignaturas.remove(asignaturaAEliminar);
                    System.out.println("Asignatura eliminada con éxito.");
                } else {
                    System.out.println("No se encontró una asignatura con ese nombre.");
                }

            }
        }
    }


    public static Alumno buscarAlumnoPorNif(String nif) {
        Iterator var1 = listaAlumnos.iterator();

        Alumno alumno;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            alumno = (Alumno) var1.next();
        } while (!alumno.getNif().equalsIgnoreCase(nif));

        return alumno;
    }
}
