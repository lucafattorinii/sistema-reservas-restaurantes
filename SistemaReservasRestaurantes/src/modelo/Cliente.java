package modelo;

public class Cliente extends Usuario {
    private String telefono;

    public Cliente(int id, String nombre, String email, String telefono) {
        super(id, nombre, email);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }
}
