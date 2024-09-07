import java.util.ArrayList;

public class Materia {
    public String nombre;
    public int curso;
    public boolean segundoCuatrimestre;
    public Profesor profesor;
    public ArrayList<Alumno> alumnos;

    public Materia(String nombre, int curso, boolean segundoCuatrimestre, Profesor profesor, ArrayList<Alumno> alumnos) {
        this.nombre = nombre;
        this.curso = curso;
        this.segundoCuatrimestre = segundoCuatrimestre;
        this.profesor = profesor;
        this.alumnos = alumnos;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
}
