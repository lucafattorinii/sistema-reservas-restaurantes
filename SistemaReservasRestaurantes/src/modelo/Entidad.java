package modelo;

public abstract class Entidad {
    protected int id;

    public Entidad(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
