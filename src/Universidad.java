import java.util.ArrayList;
import java.util.Scanner;

public class Universidad {
    private static ArrayList<Carrera> carreras;
    
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 1;
        while(opcion != 0) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Matricular Alumno");
            System.out.println("2. Inscribir Alumno en Materia");
            System.out.println("3. Cargar situación final del cursado");
            System.out.println("4. Mostrar Alumnos de Carrera/Materia");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar 
            
            switch (opcion) {
                case 1:
                    matricularAlumno(scanner);
                    break;
                case 2:
                    inscribirAlumnoEnMateria(scanner);
                    break;
                case 3:
                    cargarSituacionFinal(scanner);
                    break;
                case 4:
                    mostrarAlumnosDeCarreraMateria(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    public static Alumno matricularAlumno(Scanner scanner,Carrera carrera) {
        Alumno alumno = null;
        boolean datosValidos = false;
        while (!datosValidos) {
            try {
                System.out.println("Ingrese los datos del alumno en el siguiente formato: ");
                System.out.println("nombre,apellido,dni,email,sexo,direccion,legajo");
                String input = scanner.nextLine();
                String[] datos = input.split(",");

                if (datos.length != 7) {
                    throw new IllegalArgumentException("Debe ingresar exactamente 7 valores separados por comas.");
                }

                String nombre = datos[0].trim();
                String apellido = datos[1].trim();
                int dni = Integer.parseInt(datos[2].trim());
                String email = datos[3].trim();
                String insexo = datos[4].trim().toLowerCase();
                String direccion = datos[5].trim();
                int legajo = Integer.parseInt(datos[6].trim());

                Sexo sexo;
                if (insexo.equalsIgnoreCase("masculino")) {
                    sexo = Sexo.MASCULINO;
                } else if (insexo.equalsIgnoreCase("femenino")) {
                    sexo = Sexo.FEMENINO;
                } else {
                    throw new IllegalArgumentException("El sexo debe ser 'masculino' o 'femenino'.");
                }

                alumno = new Alumno(nombre, apellido, dni, email, sexo, direccion, legajo);
                datosValidos = true;
                System.out.println("Alumno matriculado con éxito.");
            } catch (NumberFormatException e) {
                System.out.println("Error: DNI y Legajo deben ser números enteros. Intente de nuevo.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
            }
        }

        return alumno;

        public static void inscribirAlumnoEnMateria(Scanner scanner) {
        // Similar para inscribir alumno en una materia de una carrera
    }
    
    public static void cargarSituacionFinal(Scanner scanner) {
        // Implementar funcionalidad para cargar la situación final del alumno
    }
    
    public static void mostrarAlumnosDeCarreraMateria(Scanner scanner) {
        // Mostrar alumnos inscriptos en una carrera y materia
    }
}
