public class Persona {
    private String nombre;
    private String apellido;
    private long dni;
    private String email;
    private Sexo sexo;
    private String direccion;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getDireccion() {
        return direccion;
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