import java.util.Objects;

public class Cliente {

    private String nombre;
    private String cedula;
    private int edad;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String cedula, int edad, String telefono) {
        this.nombre = nombre;
        setCedula(cedula);
        setEdad(edad);
        setTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {

        if (!cedula.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                    "La cédula debe tener exactamente 10 dígitos.");
        }

        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {

        if (edad < 15 || edad > 60) {
            throw new IllegalArgumentException(
                    "La edad debe estar entre 15 y 60 años.");
        }

        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        if (!telefono.matches("\\d+")) {
            throw new IllegalArgumentException(
                    "El teléfono debe contener solo números.");
        }

        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Cliente cliente = (Cliente) obj;

        return cedula.equals(cliente.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}