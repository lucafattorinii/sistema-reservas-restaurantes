package servicio;

import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ServicioUsuario {
    private List<Usuario> usuarios;

    public ServicioUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }
    
    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    
    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }


}
