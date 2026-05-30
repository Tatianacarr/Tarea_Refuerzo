import java.util.*;

public class ControlVacunas implements CrudVacuna {

    private Set<Mascota> mascotas;
    private Map<String,String> vacunas;

    public ControlVacunas() {

        mascotas = new HashSet<>();
        vacunas = new HashMap<>();
    }

    public void registrarMascota(Mascota mascota) {

        if(mascotas.add(mascota)) {
            System.out.println("Mascota registrada.");
        } else {
            System.out.println("Mascota duplicada.");
        }
    }

    public void mostrarMascotas() {

        if(mascotas.isEmpty()) {
            System.out.println("No existen mascotas.");
            return;
        }

        for(Mascota m : mascotas) {
            System.out.println(m);
        }
    }

    public boolean existeMascota(String codigo) {

        for(Mascota m : mascotas) {

            if(m.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void registrarVacuna(String codigo, String vacuna) {

        if(!existeMascota(codigo)) {
            System.out.println("La mascota no existe.");
            return;
        }

        vacunas.put(codigo, vacuna);

        System.out.println("Vacuna registrada.");
    }

    @Override
    public void actualizarVacuna(String codigo, String nuevaVacuna) {

        if(!vacunas.containsKey(codigo)) {
            System.out.println("Vacuna inexistente.");
            return;
        }

        vacunas.put(codigo, nuevaVacuna);

        System.out.println("Vacuna actualizada.");
    }

    @Override
    public void eliminarVacuna(String codigo) {

        if(!vacunas.containsKey(codigo)) {
            System.out.println("Vacuna inexistente.");
            return;
        }

        vacunas.remove(codigo);

        System.out.println("Vacuna eliminada.");
    }

    @Override
    public void mostrarVacunas() {

        if(vacunas.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }
        for(Map.Entry<String,String> dato : vacunas.entrySet()) {
            System.out.println("Código: " + dato.getKey());
            System.out.println("Vacuna: " + dato.getValue());
            System.out.println("----------------");
        }
    }
    @Override
    public void mascotaMasVacunada() {
        if(vacunas.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }
        System.out.println("Mascotas vacunadas:");
        for(String codigo : vacunas.keySet()) {
            System.out.println(codigo);
        }
    }
}