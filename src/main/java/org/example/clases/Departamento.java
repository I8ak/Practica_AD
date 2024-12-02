package org.example.clases;

import javax.persistence.Embeddable;

@Embeddable
public class Departamento {
    private String codigo;

    public String getCodigo() {
        return codigo;
    }
// aaaa
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "codigo='" + codigo + '\'' +
                '}';
    }
}