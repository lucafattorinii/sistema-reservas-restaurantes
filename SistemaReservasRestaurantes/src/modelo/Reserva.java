package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva extends Entidad {
    private String nombreCliente;
    private LocalDate fecha;
    private LocalTime hora;
    private Mesa mesa;

    public Reserva(int id, String nombreCliente, LocalDate fecha, LocalTime hora, Mesa mesa) {
        super(id);
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.hora = hora;
        this.mesa = mesa;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Mesa getMesa() {
        return mesa;
    }
}
