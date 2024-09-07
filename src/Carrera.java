import java.util.ArrayList;

public class Carrera {
    public String nombre;
    public int duracion;
    public Coordinador coordinador;
    public double precioInscripcion;
    public double precioCuota;
    public ArrayList<Materia> materias;

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
    public void addAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }
    public void removeAlumno(Alumno alumno){
        this.alumnos.remove(alumno);
    }

    private ArrayList<Alumno> alumnos;

    public Carrera(String nombre, int duracion, Coordinador coordinador, double precioInscripcion, double precioCuota,ArrayList<Materia> materias) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.coordinador = coordinador;
        this.precioInscripcion = precioInscripcion;
        this.precioCuota = precioCuota;
        this.materias = materias;
    }
}

