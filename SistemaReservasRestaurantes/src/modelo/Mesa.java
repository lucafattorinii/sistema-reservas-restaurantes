package modelo;

public class Mesa extends Entidad {
    private int capacidad;
    private boolean disponible;

    public Mesa(int id, int capacidad) {
        super(id);
        this.capacidad = capacidad;
        this.disponible = true;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
