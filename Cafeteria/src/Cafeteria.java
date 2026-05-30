import java.util.*;

public class Cafeteria implements CrudPedido {

    private String nombreCafeteria;

    HashSet<Cliente> clientes = new HashSet<>();

    Map<String, Double> mapaPedidos = new HashMap<>();

    public Cafeteria(String nombreCafeteria) {
        this.nombreCafeteria = nombreCafeteria;
    }

    public void agregarCliente(Cliente c) {
        if(clientes.add(c)) {
            System.out.println("Cliente registrado.");
        } else {
            System.out.println("Cliente duplicado.");
        }
    }

    public void mostrarClientes() {
        for(Cliente c : clientes) {
            System.out.println(c);
            System.out.println("------------------");
        }
    }

    private boolean existeCorreo(String correo) {
        for(Cliente c : clientes) {
            if(c.getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void registrarPedido(String correo, double consumo) {

        if(!existeCorreo(correo)) {
            System.out.println("Cliente inexistente");
            return;
        }

        if(consumo <= 0) {
            System.out.println("Consumo inválido");
            return;
        }

        mapaPedidos.put(correo, consumo);

        System.out.println("Pedido registrado");
    }

    @Override
    public void actualizarPedido(String correo, double nuevoConsumo) {

        if(!mapaPedidos.containsKey(correo)) {
            System.out.println("Pedido no existe");
            return;
        }

        mapaPedidos.put(correo, nuevoConsumo);

        System.out.println("Pedido actualizado");
    }

    @Override
    public void eliminarPedido(String correo) {

        if(!mapaPedidos.containsKey(correo)) {
            System.out.println("Pedido no existe");
            return;
        }

        mapaPedidos.remove(correo);

        System.out.println("Pedido eliminado");
    }

    @Override
    public double promedioConsumo() {

        if(mapaPedidos.isEmpty()) {
            return 0;
        }

        double suma = 0;

        for(double valor : mapaPedidos.values()) {
            suma += valor;
        }

        return suma / mapaPedidos.size();
    }

    @Override
    public void mejorCliente() {

        if(mapaPedidos.isEmpty()) {
            System.out.println("No hay datos");
            return;
        }

        String correoMayor = "";
        double mayor = 0;

        for(Map.Entry<String, Double> dato : mapaPedidos.entrySet()) {

            if(dato.getValue() > mayor) {
                mayor = dato.getValue();
                correoMayor = dato.getKey();
            }
        }

        System.out.println("Mejor cliente: " + correoMayor);
        System.out.println("Consumo: $" + mayor);
    }

    public void mostrarPedidos() {
        System.out.println(mapaPedidos);
    }
}