public class Persona {
    private String nombre;
    private String correo;
    private int edad;

    public Persona(String nombre, String correo, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if(correo.contains("@")) {
            this.correo = correo;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad >= 18 && edad <= 60) {
            this.edad = edad;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nCorreo: " + correo +
                "\nEdad: " + edad;
    }
}