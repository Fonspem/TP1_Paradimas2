import java.util.ArrayList;
import java.util.Objects;
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
            System.out.println("""
                    -Menú -
                    1. Matricular Alumno
                    2. Inscribir Alumno en Materia
                    3. Cargar situación final del cursado
                    4. Mostrar Alumnos de Carrera/Materia
                    0. Salir
                    """);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1://Matricular Alumno
                    while (opcion != 0) {
                        System.out.println("Seleccione la carrera:");
                        for (int i = 0; i < carreras.length; i++) {
                            System.out.println((i + 1) + ". " + carreras[i].getNombre().toUpperCase());
                        }
                        System.out.println("0. Cancelar Matriculación");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 0) {
                            break;
                        } else if (opcion > 0 && opcion <= carreras.length) {
                            matricularNuevoAlumno(scanner, carreras[opcion - 1]);
                            opcion = 0;
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    }
                    break;

                case 2://Inscribir Alumno en Materia
                    while (opcion != 0) {
                        System.out.println("Seleccione la carrera:");
                        for (int i = 0; i < carreras.length; i++) {
                            System.out.println((i + 1) + ". " + carreras[i].getNombre().toUpperCase());
                        }
                        System.out.println("0. Cancelar Inscripción");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 0) {
                            break;
                        } else if (opcion > 0 && opcion <= carreras.length) {
                            inscribirAlumnoEnMateria(scanner, carreras[opcion - 1]);
                            opcion = 0;
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    }
                    break;

                case 3://Cargar situación final del cursado
                    while (opcion != 0) {
                        System.out.println("Seleccione la carrera:");
                        for (int i = 0; i < carreras.length; i++) {
                            System.out.println((i + 1) + ". " + carreras[i].getNombre().toUpperCase());
                        }
                        System.out.println("0. Cancelar carga de situación final");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 0) {
                            break;
                        } else if (opcion > 0 && opcion <= carreras.length) {
                            cargarSituacionFinal(scanner, carreras[opcion - 1]);
                            opcion = 0;
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    }
                    break;

                case 4://Mostrar Alumnos de Carrera/Materia
                    while (opcion != 1 && opcion != 2 && opcion != 0) {
                        System.out.println("""
                                1.Ver por carrera
                                2.Ver por materia
                                0.Cancelar operacion
                                """);
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                    }
                    while (opcion == 1) {
                        System.out.println("Seleccione la carrera:");
                        for (int i = 0; i < carreras.length; i++) {
                            System.out.println((i + 1) + ". " + carreras[i].getNombre().toUpperCase());
                        }
                        System.out.println("0. Cancelar visualización de alumnos");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 0) {
                            break;
                        } else if (opcion > 0 && opcion <= carreras.length) {
                            for(Alumno salida : getAlumnosDeCarrera(scanner, carreras[opcion - 1])){
                                System.out.println("Apellido,Nombre,DNI,Legajo");
                                System.out.println(salida.getApellido()+","
                                        +salida.getNombre()+","
                                        +salida.getDni()+","
                                        +salida.getLegajo());
                            }
                            opcion = 0;
                        } else {
                            opcion = 1;
                            System.out.println("Opción no válida.");
                        }
                    }
                    while (opcion == 2) {
                        System.out.println("Seleccione la carrera:");
                        for (int i = 0; i < carreras.length; i++) {
                            System.out.println((i + 1) + ". " + carreras[i].getNombre().toUpperCase());
                        }
                        System.out.println("0. Cancelar visualización de alumnos");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 0) {
                            break;
                        } else if (opcion > 0 && opcion <= carreras.length) {
                            while (opcion != 0) {
                                System.out.println("Seleccione la materia:");
                                for (int i = 0; i < carreras[opcion - 1].getMaterias().size(); i++) {
                                    System.out.println((i + 1) + ". " + carreras[opcion - 1].getMaterias().get(i));
                                }
                                System.out.println("0. Cancelar visualización de alumnos");
                                opcion = scanner.nextInt();
                                scanner.nextLine();
                                if (opcion == 0) {
                                    break;
                                } else if(opcion <= carreras[opcion - 1].getMaterias().size()){
                                    for(Alumno salida : carreras[opcion-1].getMaterias().get(opcion-1).getAlumnos()){
                                        System.out.println("Apellido,Nombre,DNI,Legajo");
                                        System.out.println(salida.getApellido()+","
                                                +salida.getNombre()+","
                                                +salida.getDni()+","
                                                +salida.getLegajo());
                                    }
                                    opcion = 0;
                                }
                            }

                        } else {
                            opcion = 2;
                            System.out.println("Opción no válida.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo");
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
    public static void inscribirAlumnoEnMateria(Scanner scanner, Carrera carrera) {
        System.out.println("Ingrese el nombre del alumno a inscribir:");
        String nombreAlumno = scanner.nextLine();
        Alumno alumno = buscarAlumnoPorNombre(nombreAlumno);

        if (alumno != null) {
            System.out.println("Seleccione la materia:");
            for (int i = 0; i < carrera.getMaterias().size(); i++) {
                System.out.println((i + 1) + ". " + carrera.getMaterias().get(i).getNombre());
            }

            int opcionMateria = scanner.nextInt();
            scanner.nextLine();  // Limpiar

            if (opcionMateria > 0 && opcionMateria <= carrera.getMaterias().size()) {
                Materia materia = carrera.getMaterias().get(opcionMateria - 1);
                materia.inscribirAlumno(alumno);
                System.out.println("Alumno inscrito en la materia " + materia.getNombre());
            } else {
                System.out.println("Opción de materia no válida.");
            }
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    public static void cargarSituacionFinal(Scanner scanner, Carrera carrera) {
        System.out.println("Ingrese el nombre del alumno:");
        String nombreAlumno = scanner.nextLine();
        Alumno alumno = buscarAlumnoPorNombre(nombreAlumno);


        //Agregar funcion a alumno que devuelva las materias en que este inscripto??????


        if (alumno != null) {
            System.out.println("Ingrese la materia:");
            String nombreMateria = scanner.nextLine();
            Materia materia = getMateria(nombreMateria);

            if (materia != null) {
                System.out.println("Ingrese la situación final (Aprobado/Desaprobado):");
                String situacionFinal = scanner.nextLine();
                System.out.println("Ingrese la cantidad de inasistencias:");
                int inasistencias = scanner.nextInt();
                scanner.nextLine();  // Limpiar buffer

                materia.cargarSituacionFinal(alumno, situacionFinal, inasistencias);
                System.out.println("Situación final cargada.");
            } else {
                System.out.println("Materia no encontrada.");
            }
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    public static ArrayList<Alumno> getAlumnosDeCarrera(Scanner scanner, Carrera carrera) {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        for (Materia materia : carrera.getMaterias()) {
            if (!materia.getAlumnos().isEmpty()) {
                alumnos.addAll(materia.getAlumnos());
            }
        }
        return alumnos;
    }

    public static Alumno buscarAlumnoPorNombre(String nombre) {
        for (Carrera carrera : carreras) {
            for (Alumno alumno : carrera.getAlumnos()) {
                if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                    return alumno;
                }
            }
        }
        return null;
    }

    public static Carrera buscarCarreraPorNombre(String nombre) {
        for (Carrera carrera : carreras) {
            if (Objects.equals(carrera.getNombre(), nombre)) {
                return carrera;
            }
        }
        return null;
    }
}