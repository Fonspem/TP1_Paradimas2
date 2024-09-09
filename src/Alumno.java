
public class Alumno extends Persona{

    private int legajo;

    public Alumno(String nombre, String apellido, long dni, String email, Sexo sexo, String direccion, int legajo) {
        super(nombre, apellido, dni, email, sexo, direccion);
        this.legajo = legajo;
    }
    public int getLegajo() {return legajo;}
}
