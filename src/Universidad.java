import java.util.Scanner;

public class Universidad {
    private static Carrera[] carreras;

    public static void setCarreras(Carrera[] carreras) {
        Universidad.carreras = carreras;
    }

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while(opcion != 0) {
            System.out.println("\n--- Menú ---\n"
                    +"1. Matricular Alumno\n"
                    +"2. Inscribir Alumno en Materia"
                    +"3. Cargar situación final del cursado"
                    +"4. Mostrar Alumnos de Carrera/Materia"
                    +"0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine(); // Limpiar
            
            switch (opcion) {
                case 1:
                    opcion = -1;
                    while (opcion != 0){
                        System.out.println("Seleccione la carrera:");
                        for (int i = 0; i < carreras.length; i++ ){
                            System.out.println(i+1 + ". "+ carreras[i].nombre.toUpperCase());
                        }
                        System.out.println("0.Cancelar Matriculacion");
                            opcion = scanner.nextInt();

                            if(opcion == 0){
                                break;
                            } else if (opcion > 0 && opcion <= carreras.length + 1) {
                                matricularNuevoAlumno(scanner,carreras[opcion-1]);
                                opcion = 0;
                            }else {
                                System.out.println("Opción no válida.");
                            }
                    }
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

    public static void matricularNuevoAlumno(Scanner scanner, Carrera carrera) {
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
       carrera.addAlumno(alumno);
    }
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
