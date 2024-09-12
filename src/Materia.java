import java.util.ArrayList;

public class Materia {
    private String nombre;
    private int curso;
    private boolean segundoCuatrimestre;
    private Profesor profesor;
    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

    public Materia(String nombre, int curso, boolean segundoCuatrimestre, Profesor profesor) {
        this.nombre = nombre;
        this.curso = curso;
        this.segundoCuatrimestre = segundoCuatrimestre;
        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return this.profesor;
    }

    public ArrayList<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public void addAlumno(Alumno alumno) {
        alumno.addSituacionMateria(this, Situacion.CURSANDO);
        this.alumnos.add(alumno);
    }

    public String getNombre() {
        return this.nombre;
    }


}
