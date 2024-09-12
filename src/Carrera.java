import java.util.ArrayList;

public class Carrera {
    private String nombre;
    private int duracion;
    private Coordinador coordinador;
    private double precioInscripcion;
    private double precioCuota;

    private ArrayList<Materia> materias;

    private ArrayList<Alumno> alumnos = new ArrayList<>();

    public ArrayList<Materia> getMaterias() {
        return this.materias;
    }

    public ArrayList<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public void addAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    public void removeAlumno(Alumno alumno) {
        this.alumnos.remove(alumno);
    }

    public Carrera(String nombre, int duracion, Coordinador coordinador, double precioInscripcion, double precioCuota, ArrayList<Materia> materias) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.coordinador = coordinador;
        this.precioInscripcion = precioInscripcion;
        this.precioCuota = precioCuota;
        this.materias = materias;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Materia getMateria(String nombreMateria) {
        for (Materia materia : this.materias) {
            if (materia.getNombre().equalsIgnoreCase(nombreMateria)) {
                return materia;
            }
        }
        return null;
    }
}