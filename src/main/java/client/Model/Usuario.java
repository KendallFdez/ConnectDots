package client.Model;

public class Usuario {
    private String nombre;
    private int id;

    private boolean esTurno;

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.esTurno = false;
    }

    public void setEsTurno(boolean esTurno) {
        this.esTurno = esTurno;
    }

    public boolean setEsTurno() {
        return esTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
