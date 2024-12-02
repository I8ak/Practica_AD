package org.example;

import org.example.clases.Alumno;
import org.example.clases.Asignatura;
import org.example.clases.Departamento;
import org.example.clases.Profesor;
import org.example.dao.ProfesorDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Introduce opción: " +
                "\n1. Crear asignatura" +
                "\n2. Crear departamento " +
                "\n3. Crear alumnos" +
                "\n4. Crear profesor" +
                "\n5. Eliminar asignatura" +
                "\n6. Eliminar departamento" +
                "\n7. Eliminar alumnos" +
                "\n8. Eliminar profesor" +
                "\n9. Leer profesor");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 0:
                System.out.println("Crear asignatura");
                break;
            case 1:
                System.out.println("Crear departamento");
                break;
            case 2:
                System.out.println("Crear alumnos");
                break;
            case 3:
                System.out.println("Crear profesor");
                crearProfesor();
                break;
            case 4:
                System.out.println("Eliminar asignatura");
                break;
            case 5:
                System.out.println("Eliminar departamento");
                break;
            case 6:
                System.out.println("Eliminar alumnos");
                break;
            case 7:
                System.out.println("Eliminar profesor");
                break;
            case 8:
                System.out.println("Leer profesor");
                break;
            case 9:
                System.out.println("Leer asignatura");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    public static void crearAsignatura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de la asignatura:");
        String nombre = sc.nextLine();
        Asignatura asignatura = new Asignatura(nombre);
        System.out.println("Asignatura creada: " + asignatura);
    }

    public static void crearDepartamento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del departamento:");
        String nombre = sc.nextLine();
        Departamento departamento = new Departamento(nombre);
        // Aquí puedes llamar al DAO para persistir el departamento
        System.out.println("Departamento creado: " + departamento);
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
        Alumno alumno = new Alumno(nif, nombre, apellido, null, null);
        alumnos.add(alumno);
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
        System.out.println("Introduce edad del profesor");
        int edad = sc.nextInt();
        System.out.println("Introduce asignatura del profesor");
        String asignatura = sc.nextLine();
        System.out.println("Introduce departamento del profesor");
        String departamento = sc.nextLine();


        Profesor p = new Profesor(id, nombre, apellido, null, null, crearAlumno());
    }
}