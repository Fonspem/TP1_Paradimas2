import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Alumno extends Persona{

    private int legajo;

    public int getLegajo() {return legajo;}

    private Map<Materia,Situacion> situaciones = new HashMap<Materia,Situacion>();

    public Map<Materia, Situacion> getSituaciones() {
        return situaciones;
    }

    public void addSituacionMateria(Materia materia, Situacion situacion){
        situaciones.put(materia, situacion);
    }

    public Alumno(String nombre, String apellido, long dni, String email, Sexo sexo, String direccion, int legajo) {
        super(nombre, apellido, dni, email, sexo, direccion);
        this.legajo = legajo;
    }

}
