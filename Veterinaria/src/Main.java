import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControlVacunas control = new ControlVacunas();
        int opcion;
        do {
            System.out.println("\n===== VETERINARIA =====");
            System.out.println("1. Registrar mascota");
            System.out.println("2. Mostrar mascotas");
            System.out.println("3. Registrar vacuna");
            System.out.println("4. Actualizar vacuna");
            System.out.println("5. Eliminar vacuna");
            System.out.println("6. Mostrar vacunas");
            System.out.println("7. Buscar mascota");
            System.out.println("8. Contar mascotas");
            System.out.println("9. Mascotas vacunadas");
            System.out.println("10. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {

                case 1:

                    System.out.print("Código: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();

                    Mascota mascota =
                            new Mascota(codigo,nombre,edad,tipo);

                    control.registrarMascota(mascota);

                    break;

                case 2:
                    control.mostrarMascotas();
                    break;

                case 3:

                    System.out.print("Código mascota: ");
                    codigo = sc.nextLine();

                    System.out.print("Vacuna: ");
                    String vacuna = sc.nextLine();

                    control.registrarVacuna(codigo,vacuna);

                    break;

                case 4:

                    System.out.print("Código mascota: ");
                    codigo = sc.nextLine();

                    System.out.print("Nueva vacuna: ");
                    vacuna = sc.nextLine();

                    control.actualizarVacuna(codigo,vacuna);

                    break;

                case 5:

                    System.out.print("Código mascota: ");
                    codigo = sc.nextLine();

                    control.eliminarVacuna(codigo);

                    break;

                case 6:
                    control.mostrarVacunas();
                    break;

                case 9:
                    control.mascotaMasVacunada();
                    break;

                case 10:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }
        } while(opcion != 10);
        sc.close();
    }
}