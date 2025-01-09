package modelo;

public class Administrador extends Usuario {
    private String rol;

    public Administrador(int id, String nombre, String email, String rol) {
        super(id, nombre, email);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}
