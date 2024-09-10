import java.util.ArrayList;

public class Materia {
    public String nombre;
    public int curso;
    public boolean segundoCuatrimestre;
    public Profesor profesor;
    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

    public Materia(String nombre, int curso, boolean segundoCuatrimestre, Profesor profesor ) {
        this.nombre = nombre;
        this.curso = curso;
        this.segundoCuatrimestre = segundoCuatrimestre;
        this.profesor = profesor;
    }

    public ArrayList<Alumno> getAlumnos() {
        return this.alumnos;
    }
    public void addAlumno(Alumno alumno){ this.alumnos.add(alumno);}

    public String getNombre() {
        return this.nombre;
    }


}
