public class Persona {
    private String nombre;
    private String apellido;
    private long dni;
    private String email;
    private Sexo sexo;
    private String direccion;

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public long getDni() {
        return this.dni;
    }

    public String getEmail() {
        return this.email;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public Persona(String nombre, String apellido, long dni, String email, Sexo sexo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.sexo = sexo;
        this.direccion = direccion;
    }
}