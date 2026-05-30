import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservaCancha sistema = new ReservaCancha();
        int opcion;
        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Registrar reserva");
            System.out.println("4. Actualizar reserva");
            System.out.println("5. Eliminar reserva");
            System.out.println("6. Mostrar reservas");
            System.out.println("7. Total horas reservadas");
            System.out.println("8. Cliente con mayor reserva");
            System.out.println("9. Total clientes");
            System.out.println("10. Total reservas");
            System.out.println("11. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            try {

                switch (opcion) {

                    case 1:

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Cedula: ");
                        String cedula = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Telefono: ");
                        String telefono = sc.nextLine();

                        Cliente cliente =
                                new Cliente(nombre,
                                        cedula,
                                        edad,
                                        telefono);

                        sistema.registrarCliente(cliente);

                        break;

                    case 2:

                        sistema.mostrarClientes();

                        break;

                    case 3:

                        System.out.print("Cedula: ");
                        cedula = sc.nextLine();

                        System.out.print("Horas: ");
                        int horas = sc.nextInt();

                        sistema.registrarReserva(cedula, horas);

                        break;

                    case 4:

                        System.out.print("Cedula: ");
                        cedula = sc.nextLine();

                        System.out.print("Nuevas horas: ");
                        horas = sc.nextInt();

                        sistema.actualizarReserva(
                                cedula,
                                horas);

                        break;

                    case 5:

                        System.out.print("Cedula: ");
                        cedula = sc.nextLine();

                        sistema.eliminarReserva(cedula);

                        break;

                    case 6:

                        sistema.mostrarReservas();

                        break;

                    case 7:

                        System.out.println(
                                "Total horas: "
                                        + sistema.calcularTotalHoras());

                        break;

                    case 8:

                        sistema.clienteMayorReserva();

                        break;

                    case 9:

                        System.out.println(
                                "Clientes registrados: "
                                        + sistema.totalClientes());

                        break;

                    case 10:

                        System.out.println(
                                "Reservas registradas: "
                                        + sistema.totalReservas());

                        break;

                    case 11:

                        System.out.println("Fin del programa.");

                        break;

                    default:

                        System.out.println("Opción inválida.");
                }

            } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage());

                sc.nextLine();
            }

        } while (opcion != 11);

        sc.close();
    }
}