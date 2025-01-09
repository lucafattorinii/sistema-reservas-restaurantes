package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import modelo.*;
import servicio.*;

@TestMethodOrder(OrderAnnotation.class)
public class TestSistemaReservas {
    private ServicioReserva servicioReserva;
    private ServicioUsuario servicioUsuario;

    @BeforeEach
    public void setUp() {
        servicioReserva = new ServicioReserva();
        servicioUsuario = new ServicioUsuario();
    }

    private Reserva crearReserva(int id, String nombreCliente, LocalDate fecha, LocalTime hora, Mesa mesa) {
        return new Reserva(id, nombreCliente, fecha, hora, mesa);
    }

    @Test
    @Order(1)
    public void testAgregarReserva() {
        System.out.println("\n==========================\n");
        System.out.println("Test 1: Agregar Reserva\n");
        Mesa mesa = new Mesa(1, 4);
        Reserva reserva = crearReserva(1, "Juan Perez", LocalDate.of(2025, 1, 10), LocalTime.of(20, 0), mesa);
        servicioReserva.agregarReserva(reserva);
        assertEquals(1, servicioReserva.obtenerReservas().size());
        System.out.println("Reserva agregada correctamente.");
        System.out.println("\n==========================\n");
    }

    @Test
    @Order(2)
    public void testVerificarDisponibilidad() {
        System.out.println("\n==========================\n");
        System.out.println("Test 2: Verificar Disponibilidad\n");
        Mesa mesa = new Mesa(1, 4);
        Reserva reserva = crearReserva(1, "Juan Perez", LocalDate.of(2025, 1, 10), LocalTime.of(20, 0), mesa);
        servicioReserva.agregarReserva(reserva);
        boolean disponible = servicioReserva.verificarDisponibilidad(mesa, LocalDate.of(2025, 1, 10), LocalTime.of(20, 0));
        assertFalse(disponible);
        System.out.println("Disponibilidad verificada correctamente.");
        System.out.println("\n==========================\n");
    }

    @Test
    @Order(3)
    public void testAgregarUsuario() {
        System.out.println("\n==========================\n");
        System.out.println("Test 3: Agregar Usuario\n");
        Cliente cliente = new Cliente(1, "Maria Lopez", "maria@example.com", "123456789");
        servicioUsuario.agregarUsuario(cliente);
        assertEquals(1, servicioUsuario.obtenerUsuarios().size());
        System.out.println("Usuario agregado correctamente.");
        System.out.println("\n==========================\n");
    }

    @Test
    @Order(4)
    public void testBuscarUsuarioPorEmail() {
        System.out.println("\n==========================\n");
        System.out.println("Test 4: Buscar Usuario por Email\n");
        Cliente cliente = new Cliente(1, "Maria Lopez", "maria@example.com", "123456789");
        servicioUsuario.agregarUsuario(cliente);
        Usuario usuarioEncontrado = servicioUsuario.buscarUsuarioPorEmail("maria@example.com");
        assertNotNull(usuarioEncontrado);
        assertEquals("Maria Lopez", usuarioEncontrado.getNombre());
        System.out.println("Usuario encontrado correctamente.");
        System.out.println("\n==========================\n");
    }

    @Test
    @Order(5)
    public void testMesaDisponible() {
        System.out.println("\n==========================\n");
        System.out.println("Test 5: Mesa Disponible\n");
        Mesa mesa = new Mesa(1, 4);
        assertTrue(mesa.isDisponible());
        mesa.setDisponible(false);
        assertFalse(mesa.isDisponible());
        System.out.println("Disponibilidad de la mesa verificada correctamente.");
        System.out.println("\n==========================\n");
    }

    @Test
    @Order(6)
    public void testActualizarReserva() {
        System.out.println("\n==========================\n");
        System.out.println("Test 6: Actualizar Reserva\n");
        Mesa mesa = new Mesa(1, 4);
        Reserva reserva = crearReserva(1, "Juan Perez", LocalDate.of(2025, 1, 10), LocalTime.of(20, 0), mesa);
        servicioReserva.agregarReserva(reserva);
        reserva.setFecha(LocalDate.of(2025, 1, 11));
        reserva.setHora(LocalTime.of(21, 0));
        assertEquals(LocalDate.of(2025, 1, 11), reserva.getFecha());
        assertEquals(LocalTime.of(21, 0), reserva.getHora());
        System.out.println("Reserva actualizada correctamente.");
        System.out.println("\n==========================\n");
    }

    @Test
    @Order(7)
    public void testErrorIntencional() {
        System.out.println("\n==========================\n");
        System.out.println("Test 7: Error Intencional\n");
        Mesa mesa = new Mesa(1, 4);
        Reserva reserva = crearReserva(1, "Juan Perez", LocalDate.of(2025, 1, 10), LocalTime.of(20, 0), mesa);
        servicioReserva.agregarReserva(reserva);
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Error intencional para prueba");
        });
        System.out.println("Error intencional verificado.");
        System.out.println("\n==========================\n");
    }

    @Test
    @Order(8)
    public void testEliminarReserva() {
        System.out.println("\n==========================\n");
        System.out.println("Test 8: Eliminar Reserva\n");
        Mesa mesa = new Mesa(1, 4);
        Reserva reserva = crearReserva(1, "Juan Perez", LocalDate.of(2025, 1, 10), LocalTime.of(20, 0), mesa);
        servicioReserva.agregarReserva(reserva);
        servicioReserva.eliminarReserva(reserva);
        assertEquals(0, servicioReserva.obtenerReservas().size());
        System.out.println("Reserva eliminada correctamente.");
        System.out.println("\n==========================\n");
    }

    @Test
    @Order(9)
    public void testBuscarUsuarioPorId() {
        System.out.println("\n==========================\n");
        System.out.println("Test 9: Buscar Usuario por ID\n");
        Cliente cliente = new Cliente(1, "Maria Lopez", "maria@example.com", "123456789");
        servicioUsuario.agregarUsuario(cliente);
        Usuario usuarioEncontrado = servicioUsuario.buscarUsuarioPorId(1);
        assertNotNull(usuarioEncontrado);
        assertEquals("Maria Lopez", usuarioEncontrado.getNombre());
        System.out.println("Usuario encontrado correctamente por ID.");
        System.out.println("\n==========================\n");
    }

    @Test
    @Order(10)
    public void testActualizarUsuario() {
        System.out.println("\n==========================\n");
        System.out.println("Test 10: Actualizar Usuario\n");
        Cliente cliente = new Cliente(1, "Maria Lopez", "maria@example.com", "123456789");
        servicioUsuario.agregarUsuario(cliente);
        cliente.setNombre("Maria Gonzalez");
        cliente.setEmail("maria.gonzalez@example.com");
        assertEquals("Maria Gonzalez", cliente.getNombre());
        assertEquals("maria.gonzalez@example.com", cliente.getEmail());
        System.out.println("Usuario actualizado correctamente.");
        System.out.println("\n==========================\n");
    }

    @Test
    @Order(11)
    public void testEliminarUsuario() {
        System.out.println("\n==========================\n");
        System.out.println("Test 11: Eliminar Usuario\n");
        Cliente cliente = new Cliente(1, "Maria Lopez", "maria@example.com", "123456789");
        servicioUsuario.agregarUsuario(cliente);
        servicioUsuario.eliminarUsuario(cliente);
        assertEquals(0, servicioUsuario.obtenerUsuarios().size());
        System.out.println("Usuario eliminado correctamente.");
        System.out.println("\n==========================\n");
    }
}
