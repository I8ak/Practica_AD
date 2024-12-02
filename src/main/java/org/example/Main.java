package org.example;

import org.example.clases.Profesor;
import org.example.dao.ProfesorDAO;

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
        Profesor p = new Profesor(id, nombre, apellido, departamento, alumnos);
    }
}