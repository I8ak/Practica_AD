package org.example.clases;

public class Clase {
    private String codigo;

    public Clase(String codigo) {
        this.codigo = codigo;
    }// aaaa

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "codigo='" + codigo + '\'' +
                '}';
    }
}
