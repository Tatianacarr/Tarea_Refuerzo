import java.util.Objects;

public class Mascota {

    private String codigo;
    private String nombre;
    private int edad;
    private String tipo;

    public Mascota(String codigo, String nombre, int edad, String tipo) {
        setCodigo(codigo);
        this.nombre = nombre;
        setEdad(edad);
        setTipo(tipo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if(codigo != null && !codigo.trim().isEmpty()) {
            this.codigo = codigo;
        } else {
            System.out.println("Código inválido.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad >= 0 && edad <= 20) {
            this.edad = edad;
        } else {
            System.out.println("Edad fuera de rango.");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {

        if(tipo.equalsIgnoreCase("Perro") ||
                tipo.equalsIgnoreCase("Gato") ||
                tipo.equalsIgnoreCase("Conejo") ||
                tipo.equalsIgnoreCase("Otro")) {
            this.tipo = tipo;
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        Mascota mascota = (Mascota) obj;
        return codigo.equals(mascota.codigo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
    @Override
    public String toString() {
        return "\nCódigo: " + codigo +
                "\nNombre: " + nombre +
                "\nEdad: " + edad +
                "\nTipo: " + tipo;
    }
}