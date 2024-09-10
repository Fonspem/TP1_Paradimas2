import java.util.ArrayList;
import java.util.Random;

public class Profesor extends Persona {
    ArrayList<Materia> materias = new ArrayList<>();

    public Profesor(String nombre, String apellido, long dni, String email, Sexo sexo, String direccion) {
        super(nombre, apellido, dni, email, sexo, direccion);
    }

    public ArrayList<Materia> getMaterias() {
        return this.materias;
    }

    public void agregarMateria(Materia materia) {
        this.materias.add(materia);
    }

    public void removerMateria(Materia materia) {
        this.materias.remove(materia);
    }

    //cargar situacion alumnos
    public Situacion get_situacion_de_alumno(Alumno alumno) {
        // Usa el legajo del alumno como semilla entonces siempre devuelve
        // el mismo resultado por alumno
        Random random = new Random(alumno.getLegajo());
        Situacion[] situaciones = Situacion.values();
        return situaciones[random.nextInt(situaciones.length)];
    }

}

