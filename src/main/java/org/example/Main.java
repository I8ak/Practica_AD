package org.example;


import org.example.clases.*;
import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;


import java.util.*;

/**
 * Clase  principal que actúa como punto de entrada para la aplicación.
 * Proporciona un menú interactivo que permite gestionar las entidades de alumnos, profesores, asignaturas, aulas y departamentos.
 * Utiliza Data Access Objects (DAOs) para realizar las operaciones de persistencia de las entidades en la base de datos.
 * La aplicación permite crear, eliminar, leer y actualizar la información de alumnos y profesores, así como gestionar asignaturas y aulas.
 */


public class Main {


    private static List<Asignatura> listaAsignaturas = new ArrayList();
    private static List<Alumno> listaAlumnos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    /**
     * Método principal que ejecuta la lógica del programa y presenta un menú interactivo al usuario.
     * Este método maneja las interacciones con el usuario y ejecuta la acción correspondiente según la opción seleccionada.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
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
     * El menú ofrece varias opciones para crear, leer, actualizar y eliminar entidades.
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
     * Crea una nueva asignatura solicitando el nombre al usuario.
     *
     * @return Objeto Asignatura creado o {@code null} si el nombre del asignatura está vacío.
     */
    public static Asignatura crearAsignatura() {
        System.out.println("Introduce el nombre de la asignatura:");
        String nombre = sc.nextLine();
        if (!NoEstaVacio(nombre)) {
            return null;
        }
        Asignatura asignatura = new Asignatura(nombre);
        return asignatura;
    }


    /**
     * Crea una nueva clase solicitando el nombre del aula al usuario.
     *
     * @return Objeto Clase creado o {@code null} si el nombre del aula es vacío o nulo.
     */
    public static Clase crearClase() {
        System.out.println("Introduce el nombre del aula:");
        String c = sc.nextLine();
        if (!NoEstaVacio(c)) {
            return null;
        }
        Clase clase = new Clase(c);
        System.out.println("Clase creada: " + c);
        return clase;
    }


    /**
     * Crea un nuevo departamento solicitando el nombre al usuario.
     *
     * @return Objeto Departamento creado o {@code null} si el nombre del departamento está vacío.
     */
    public static Departamento crearDepartamento() {
        System.out.println("Introduce el nombre del departamento:");
        String nombre = sc.nextLine();
        if (!NoEstaVacio(nombre)) {
            return null;
        }
        Departamento departamento = new Departamento(nombre);
        return departamento;
    }


    /**
     * Crea una lista de alumnos solicitando datos al usuario.
     * El método gestiona la creación de un alumno consu NIF, nombre,apellido, asignaturas, nota y una clase asociada.
     *
     * @return Lista de alumnos creada o vacía si la creación fue cancelada en algún paso.
     */
    public static List<Alumno> crearAlumno() {
        List<Alumno> alumnos = new ArrayList();
        //VERIFICAMOS PROFESOR 1º
        Profesor profesorExistente = ProfesorDAO.leerProfesor("ejemploID"); // ID de prueba
        if (profesorExistente == null) {
            System.out.println("No existen profesores. Primero, cree un profesor.");
            return alumnos;
        }


        //NIF
        String nif;
        while (true) {
            System.out.println("Introduce el NIF del alumno a crear:");
            nif = sc.nextLine();
            if (NoEstaVacio(nif)) {
                if (AlumnoDAO.leerAlumno(nif) != null) {
                    System.out.println("El NIF del alumno ya existe.");
                    return alumnos;
                }
                break;
            }
        }


        //NOMBRE
        String nombre;
        while (true) {
            System.out.println("Introduce el nombre del alumno a crear:");
            nombre = sc.nextLine();
            if (NoEstaVacio(nombre)) {
                break;
            }
        }


        //APELLIDO
        String apellido;
        while (true) {
            System.out.println("Introduce el apellido del alumno a crear:");
            apellido = sc.nextLine();
            if (NoEstaVacio(apellido)) {
                break;
            }
        }


        //ASIGNATURAS
        int numAsignaturas = 0;
        boolean valido = false;
        while (!valido) {
            System.out.println("¿Cuántas asignaturas tiene?");
            try {
                numAsignaturas = sc.nextInt();
                sc.nextLine();
                if (numAsignaturas < 1) {
                    System.out.println("Debe ingresar un número mayor que 0.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
                sc.nextLine();
            }
        }


        HashMap<Asignatura, Double> alumnoNotas = new HashMap();


        for (int i = 0; i < numAsignaturas; ++i) {
            Asignatura asignatura = crearAsignatura();
            if (asignatura == null) {
                return alumnos;
            }
            //NOTA
            System.out.println("Escribe la nota");
            double nota = 0;
            boolean correcto = true;
            while (correcto) {
                try {
                    nota = sc.nextDouble();
                    sc.nextLine();
                    correcto = false;
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número.");
                    sc.nextLine();
                    correcto = true;
                }
            }


            alumnoNotas.put(asignatura, nota);
        }


        //CLASE
        Clase c = crearClase();
        if (c == null) {
            System.out.println("Clase no válida, el proceso de creación del alumno se ha cancelado.");
            return alumnos;
        }
        Alumno alumno = new Alumno(nif, nombre, apellido, alumnoNotas, c);
        AlumnoDAO.crearAlumno(alumno);
        alumnos.add(alumno);
        listaAlumnos.add(alumno);
        

        return alumnos;
    }


    /**
     * Crea un nuevo profesor solicitando su ID, nombre, apellido, asignatura y departamento.
     *
     * @return Un nuevo profesor creado.
     */
    public static void crearProfesor() {
        //ID
        String id;
        while (true) {
            System.out.println("Introduce el ID del profesor:");
            id = sc.nextLine();
            if (NoEstaVacio(id)) {
                if (ProfesorDAO.leerProfesor(id) != null) {
                    System.out.println("El ID del profesor ya existe.");
                    return;
                }
                break;
            }
        }


        //NOMBRE
        String nombre;
        while (true) {
            System.out.println("Introduce el nombre del profesor:");
            nombre = sc.nextLine();
            if (NoEstaVacio(nombre)) {
                break;
            }
        }


        //APELLIDO
        String apellido;
        while (true) {
            System.out.println("Introduce el apellido del profesor:");
            apellido = sc.nextLine();
            if (NoEstaVacio(apellido)) {
                break;
            }
        }


        //ASIGNATURA
        Asignatura a;
        while (true) {
            a = crearAsignatura();
            if (a != null) {
                break;
            }
        }


        //DEPARTAMENTO
        Departamento d;
        while (true) {
            d = crearDepartamento();
            if (d != null) {
                break;
            }
        }
        listaAlumnos = AlumnoDAO.leerAlumnos();
        Profesor p = new Profesor(id, nombre, apellido, a, d, listaAlumnos);
        ProfesorDAO.crearProfesor(p);
        System.out.println(p);
    }


    /**
     * Elimina un alumno solicitando su NIF.
     * Si el alumno existe, se elimina de la base de datos; si no, muestra un mensaje indicando que el alumno no fue encontrado.
     */
    public static void eliminarAlumno() {
        System.out.println("Introduce el NIF del alumno:");
        String nif = sc.nextLine();
        if (!NoEstaVacio(nif)) {
            return;
        }
        Alumno a = AlumnoDAO.leerAlumno(nif);
        if (a != null) {
            AlumnoDAO.eliminarAlumno(a);
            recorrerProfes(a);
            System.out.println("Alumno eliminado.");
        } else {
            System.out.println("No se encontró un alumno con el NIF proporcionado.");
        }
    }


    /**
     * Elimina un profesor solicitando su ID.
     * Si el profesor existe, se elimina de la base de datos; si no, muestra un mensaje indicando que el profesor no fue encontrado.
     */
    public static void eliminarProfesor() {
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        if (!NoEstaVacio(codigo)) {
            return;
        }
        Profesor p = ProfesorDAO.leerProfesor(codigo);
        if (p != null) {
            ProfesorDAO.eliminarProfesor(p);
            System.out.println("Profesor eliminado.");
        } else {
            System.out.println("No se encontró un profesor con el ID proporcionado.");
        }
    }


    /**
     * Elimina un alumno asociado a un profesor especificando ambos identificadores.
     * El alumno será removido de la lista de alumnos del profesor correspondiente.
     * Si no se encuentra al alumno o profesor, se muestra un mensaje indicando que no se encontró .
     */
    public static void eliminarAlumnosProfe() {
        //ID PROFESOR
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        if (!NoEstaVacio(codigo)) {
            return;
        }
        Profesor p = ProfesorDAO.leerProfesor(codigo);
        if (p == null) {
            System.out.println("No se encontró un profesor con el ID proporcionado.");
            return;
        }


        //NIF ALUMNO
        System.out.println("Introduce el NIF alumno:");
        String nif = sc.nextLine();
        if (!NoEstaVacio(nif)) {
            return;
        }
        Alumno a = AlumnoDAO.leerAlumno(nif);
        if (a == null) {
            System.out.println("No se encontró un alumno con el NIF proporcionado.");
            return;
        }


        ProfesorDAO.eliminarAlumnoProfesor(codigo, a);
        System.out.println("Alumno eliminado del profesor.");


    }


    /**
     * Lee los datos de un alumno solicitando su NIF.
     * Muestra la información del alumno con el NIF proporcionado si existe, de lo contrario muestra un mensaje indicando que no se encontró.
     */
    public static void leerAlumno() {
        System.out.println("Introduce el NIF alumno:");
        String nif = sc.nextLine();
        if (!NoEstaVacio(nif)) {
            return;
        }
        Alumno a = AlumnoDAO.leerAlumno(nif);
        if (a != null) {
            System.out.println(a);
        } else {
            System.out.println("No se encontró un alumno con el NIF proporcionado.");
        }
    }


    /**
     * Lee los datos de un profesor solicitando su ID.
     * Muestra la información del profesor con el ID proporcionado si existe, de lo contrario muestra un mensaje indicando que no se encontró.
     */
    public static void leerProfesor() {
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        if (!NoEstaVacio(codigo)) {
            return;
        }
        Profesor p = ProfesorDAO.leerProfesor(codigo);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("No se encontró un profesor con el ID proporcionado.");
        }


    }

    /**
     * Actualiza el aula de un alumno solicitando su NIF.
     * El usuario debe proporcionar un nuevo aula, que reemplazará la clase actual del alumno.
     * Si el alumno no existe, se muestra un mensaje indicando que no se encontró.
     */
    public static void actualizarAlumno() {
        System.out.println("Introduce el NIF alumno:");
        String nif = sc.nextLine();
        if (!NoEstaVacio(nif)) {
            return;
        }
        Alumno a = AlumnoDAO.leerAlumno(nif);
        if (a == null) {
            System.out.println("No se encontró un alumno con el NIF proporcionado.");
            return;
        }
        a.setClase(crearClase());
        AlumnoDAO.actualizarAlumno(a);
        System.out.println("Aula del alumno actualizada correctamente.");
    }


    /**
     * Actualiza los datos de un profesor solicitando su ID.
     * El usuario debe proporcionar un nuevo departamento, asignatura y lista de alumnos asociados al profesor.
     * Si el profesor no existe, se muestra un mensaje indicando que no se encontró.
     */
    public static void actualizarProfesor() {
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        if (!NoEstaVacio(codigo)) {
            return;
        }
        Profesor p = ProfesorDAO.leerProfesor(codigo);
        if (p == null) {
            System.out.println("No se encontró un profesor con el ID proporcionado.");
            return;
        }
        p.setDepartamento(crearDepartamento());
        p.setAlumnos(crearAlumno());
        p.setAsignatura(crearAsignatura());
        ProfesorDAO.actualizarProfesor(p);
        System.out.println("Datos del profesor actualizados correctamente.");
    }


    /**
     * Lee y muestra los alumnos asociados a un profesor especificando el ID del profesor.
     * Muestra la lista de alumnos que están asignados a ese profesor.
     */
    public static void leerAlumnosProfesor() {
        System.out.println("Introduce el ID profesor:");
        String codigo = sc.nextLine();
        if (!NoEstaVacio(codigo)) {
            return;
        }
        System.out.println(ProfesorDAO.leerAlumnosProfesor(codigo));
    }


    /**
     * Lee y muestra los alumnos de un aula especificando el código del aula.
     * Muestra la lista de alumnos que están asignados a esa aula.
     */
    public static void leerAlumnosClase() {
        System.out.println("Introduce el codigo del aula:");
        String codigo = sc.nextLine();
        if (!NoEstaVacio(codigo)) {
            return;
        }
        System.out.println(AlumnoDAO.leerAlumnosClase(codigo));
    }


    /**
     * Método auxiliar para comprobar si una cadena no está vacía o es nula
     *
     * @param apartado La cadena que se desea verificar.
     * @return {@code true} si el apartado no está vacío ni es nulo, {@code false} en caso contrario.
     */
    public static boolean NoEstaVacio(String apartado) {
        if (apartado == null || apartado.isEmpty()) {
            System.out.println("Es obligatorio rellenar este apartado.");
            return false;
        }
        return true;
    }

    private static void recorrerProfes(Alumno alumno){
        ArrayList<Alumno> alumnos=new ArrayList<>();
        for (Profesor p:ProfesorDAO.leerTodosProfes()){
            alumnos.addAll(p.getAlumnos());
            for (Alumno a:alumnos){
                if (a.getNif().equals(alumno.getNif())) {
                    p.getAlumnos().remove(a);
                    ProfesorDAO.actualizarProfesor(p);
                    break;
                }
            }
        }
    }


}
