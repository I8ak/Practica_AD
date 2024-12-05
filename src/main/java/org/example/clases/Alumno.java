package org.example.clases;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Alumno {
    @Id
    private String nif;
    private String nombre;
    private String apellido;
    @Embedded @OneToMany(fetch = FetchType.EAGER)  private Map<Asignatura,Double> asignaturas;
    @Embedded private Clase clase;


    public Alumno(String nif, String nombre, String apellido, HashMap<Asignatura,Double> asignaturas, Clase clase) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignaturas = asignaturas;
        this.clase = clase;
    }


    public String getNif() {
        return nif;
    }


    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "Alumno\n"
                + "\tNIF: "+nif
                +"\n\tNombre: "+nombre
                +"\n\tApellido: "+apellido
                +"\n\t"+asignaturas
                +"\n\t"+clase;
    }


}
