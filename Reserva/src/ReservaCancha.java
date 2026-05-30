import java.util.HashMap;
import java.util.HashSet;

public class ReservaCancha implements CrudReserva {

    private HashSet<Cliente> clientes;
    private HashMap<String, Integer> reservas;

    public ReservaCancha() {
        clientes = new HashSet<>();
        reservas = new HashMap<>();
    }

    // Registrar cliente
    public void registrarCliente(Cliente cliente) {

        if (!clientes.add(cliente)) {
            System.out.println("Cliente duplicado.");
        } else {
            System.out.println("Cliente registrado.");
        }
    }

    // Buscar cliente
    private boolean existeCliente(String cedula) {

        for (Cliente c : clientes) {

            if (c.getCedula().equals(cedula)) {
                return true;
            }
        }

        return false;
    }

    // Mostrar clientes
    public void mostrarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    @Override
    public void registrarReserva(String cedula, int horas) {

        if (!existeCliente(cedula)) {
            System.out.println("Cliente inexistente.");
            return;
        }

        if (horas < 1 || horas > 5) {
            System.out.println("Las horas deben estar entre 1 y 5.");
            return;
        }

        reservas.put(cedula, horas);

        System.out.println("Reserva registrada.");
    }

    @Override
    public void actualizarReserva(String cedula, int horas) {

        if (!reservas.containsKey(cedula)) {
            System.out.println("Reserva no encontrada.");
            return;
        }

        reservas.put(cedula, horas);

        System.out.println("Reserva actualizada.");
    }

    @Override
    public void eliminarReserva(String cedula) {

        if (reservas.remove(cedula) != null) {
            System.out.println("Reserva eliminada.");
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

    public void mostrarReservas() {

        if (reservas.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }

        for (String cedula : reservas.keySet()) {
            System.out.println(
                    "Cedula: " + cedula +
                            " | Horas: " + reservas.get(cedula));
        }
    }

    @Override
    public int calcularTotalHoras() {

        int total = 0;

        for (int horas : reservas.values()) {
            total += horas;
        }

        return total;
    }

    @Override
    public void clienteMayorReserva() {

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
            return;
        }

        String cedulaMayor = "";
        int mayor = 0;

        for (String cedula : reservas.keySet()) {

            if (reservas.get(cedula) > mayor) {
                mayor = reservas.get(cedula);
                cedulaMayor = cedula;
            }
        }

        System.out.println(
                "Cliente con mayor reserva: "
                        + cedulaMayor
                        + " (" + mayor + " horas)");
    }
    public int totalClientes() {
        return clientes.size();
    }
    public int totalReservas() {
        return reservas.size();
    }
}