import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cafeteria cafe = new Cafeteria("Smart Coffee");
        int op;
        do {
            System.out.println("\n===== SMART COFFEE =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Registrar pedido");
            System.out.println("4. Actualizar pedido");
            System.out.println("5. Eliminar pedido");
            System.out.println("6. Mostrar promedio");
            System.out.println("7. Mejor cliente");
            System.out.println("8. Mostrar pedidos");
            System.out.println("9. Salir");
            System.out.println("Ingrese una opcion:");
            op = sc.nextInt();
            sc.nextLine();
            switch(op) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Membresía: ");
                    String mem = sc.nextLine();
                    Cliente cli = new Cliente(nombre, correo, edad, codigo, mem
                    );
                    cafe.agregarCliente(cli);
                    break;
                case 2:
                    cafe.mostrarClientes();
                    break;
                case 3:
                    System.out.print("Correo: ");
                    correo = sc.nextLine();
                    System.out.print("Consumo: ");
                    double consumo = sc.nextDouble();
                    cafe.registrarPedido(correo, consumo);
                    break;
                case 4:
                    System.out.print("Correo: ");
                    correo = sc.nextLine();
                    System.out.print("Nuevo consumo: ");
                    consumo = sc.nextDouble();
                    cafe.actualizarPedido(correo, consumo);
                    break;
                case 5:
                    System.out.print("Correo: ");
                    correo = sc.nextLine();
                    cafe.eliminarPedido(correo);
                    break;
                case 6:
                    System.out.println("Promedio: "
                            + cafe.promedioConsumo());
                    break;
                case 7:
                    cafe.mejorCliente();
                    break;
                case 8:
                    cafe.mostrarPedidos();
                    break;
            }
        } while(op != 9);
    }
}