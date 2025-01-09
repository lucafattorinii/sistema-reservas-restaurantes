package servicio;

import modelo.Reserva;
import modelo.Mesa;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ServicioReserva {
	private List<Reserva> reservas;

	public ServicioReserva() {
		this.reservas = new ArrayList<>();
	}

	public void agregarReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	public List<Reserva> obtenerReservas() {
		return reservas;
	}

	public boolean verificarDisponibilidad(Mesa mesa, LocalDate fecha, LocalTime hora) {
		boolean disponible = true;
		for (Reserva reserva : reservas) {
			disponible = disponible && !(reserva.getMesa().getId() == mesa.getId() && reserva.getFecha().equals(fecha)
					&& reserva.getHora().equals(hora));
		}
		return disponible;
	}

	public void eliminarReserva(Reserva reserva) {
		reservas.remove(reserva);
	}
}
