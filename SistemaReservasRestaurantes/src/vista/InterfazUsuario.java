package vista;

import modelo.*;
import servicio.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InterfazUsuario {
    private ServicioReserva servicioReserva;
    private ServicioUsuario servicioUsuario;
    private Scanner scanner;

    public InterfazUsuario() {
        this.servicioReserva = new ServicioReserva();
        this.servicioUsuario = new ServicioUsuario();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("Sistema de Reservas de Restaurantes");
            System.out.println("1. Hacer una reserva");
            System.out.println("2. Ver reservas");
            System.out.println("3. Registrar usuario");
            System.out.println("4. Ver usuarios");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    hacerReserva();
                    break;
                case 2:
                    verReservas();
                    break;
                case 3:
                    registrarUsuario();
                    break;
                case 4:
                    verUsuarios();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    private void hacerReserva() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Ingrese la fecha (dd/MM/yyyy):");
        String fechaStr = scanner.nextLine();
        System.out.println("Ingrese la hora (HH:mm):");
        String horaStr = scanner.nextLine();
        System.out.println("Ingrese el ID de la mesa:");
        int idMesa = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));

        Mesa mesa = new Mesa(idMesa, 4); // Ejemplo de mesa con capacidad 4
        if (servicioReserva.verificarDisponibilidad(mesa, fecha, hora)) {
            Reserva reserva = new Reserva(servicioReserva.obtenerReservas().size() + 1, nombreCliente, fecha, hora, mesa);
            servicioReserva.agregarReserva(reserva);
            System.out.println("Reserva realizada con éxito.");
        } else {
            System.out.println("La mesa no está disponible en la fecha y hora seleccionadas.");
        }
    }

    private void verReservas() {
        System.out.println("Reservas:");
        for (Reserva reserva : servicioReserva.obtenerReservas()) {
            System.out.println("ID: " + reserva.getId() + ", Cliente: " + reserva.getNombreCliente() + ", Fecha: " + reserva.getFecha() + ", Hora: " + reserva.getHora() + ", Mesa: " + reserva.getMesa().getId());
        }
    }

    private void registrarUsuario() {
        System.out.println("Ingrese el nombre del usuario:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el email del usuario:");
        String email = scanner.nextLine();
        System.out.println("Ingrese el teléfono del usuario:");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(servicioUsuario.obtenerUsuarios().size() + 1, nombre, email, telefono);
        servicioUsuario.agregarUsuario(cliente);
        System.out.println("Usuario registrado con éxito.");
    }

    private void verUsuarios() {
        System.out.println("Usuarios:");
        for (Usuario usuario : servicioUsuario.obtenerUsuarios()) {
            System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre() + ", Email: " + usuario.getEmail());
        }
    }

    public static void main(String[] args) {
        InterfazUsuario interfaz = new InterfazUsuario();
        interfaz.mostrarMenu();
    }
}
