package modelo;

public abstract class Usuario extends Entidad {
	protected String nombre;
	protected String email;

	public Usuario(int id, String nombre, String email) {
		super(id);
		this.nombre = nombre;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
