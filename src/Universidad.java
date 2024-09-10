import java.util.ArrayList;
import java.util.Scanner;

public class Universidad {
    private ArrayList<Carrera> carreras = new ArrayList<>();

    public void addCarreras(Carrera carrera) {
        this.carreras.add(carrera);
    }

    public Universidad(){}

    public void mostrarMenu() {
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
                case 1:
                    while (opcion != 0) {
                        System.out.println("Seleccione la carrera:");
                        for (int i = 0; i < carreras.size(); i++) {
                            System.out.println((i + 1) + ". " + carreras.get(i).getNombre().toUpperCase());
                        }
                        System.out.println("0. Cancelar Matriculación");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 0) {
                            opcion = -1;
                            break;
                        } else if (opcion > 0 && opcion <= carreras.size()) {
                            this.matricularNuevoAlumno(scanner, carreras.get(opcion - 1));
                            opcion = 0;
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    }
                    opcion = -1;
                    break;

                case 2://Inscribir Alumno en Materia
                    while (opcion != 0) {
                        System.out.println("Seleccione la carrera:");
                        for (int i = 0; i < carreras.size(); i++) {
                            System.out.println((i + 1) + ". " + carreras.get(i).getNombre().toUpperCase());
                        }
                        System.out.println("0. Cancelar Inscripción");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 0) {
                            opcion = -1;
                            break;
                        } else if (opcion > 0 && opcion <= carreras.size()) {
                            inscribirAlumnoEnMateria(scanner, carreras.get(opcion - 1));
                            opcion = 0;
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    }
                    opcion = -1;
                    break;

                case 3://Cargar situación final del cursado
                    while (opcion != 0) {
                        System.out.println("Seleccione la carrera:");
                        for (int i = 0; i < carreras.size(); i++) {
                            System.out.println((i + 1) + ". " + carreras.get(i).getNombre().toUpperCase());
                        }
                        System.out.println("0. Cancelar carga de situación final");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 0) {
                            opcion = -1;
                            break;
                        } else if (opcion > 0 && opcion <= carreras.size()) {
                            cargarSituacionFinal(scanner);
                            opcion = 0;
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    }
                    opcion = -1;
                    break;

                case 4://Mostrar Alumnos de Carrera/Materia
                    while (opcion != 1 && opcion != 2 ) {
                        System.out.println("""
                                1.Ver por carrera
                                2.Ver por materia
                                0.Cancelar operacion
                                """);
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        if (opcion == 0) {
                            opcion = -1;
                            break;
                        }
                    }
                    while (opcion == 1) {
                        System.out.println("Seleccione la Materia:");
                        for (int i = 0; i < carreras.size(); i++) {
                            System.out.println((i + 1) + ". " + carreras.get(i).getNombre().toUpperCase());
                        }
                        System.out.println("0. Cancelar visualización de alumnos");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 0) {
                            opcion = -1;
                            break;
                        } else if (opcion > 0 && opcion <= carreras.size()) {
                            for(Alumno salida : getAlumnosDeCarrera(carreras.get(opcion - 1))){
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
                        for (int i = 0; i < carreras.size(); i++) {
                            System.out.println((i + 1) + ". " + carreras.get(i).getNombre().toUpperCase());
                        }
                        System.out.println("0. Cancelar visualización de alumnos");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 0) {
                            opcion = -1;
                            break;
                        } else if (opcion > 0 && opcion <= carreras.size()) {
                            while (opcion != 0) {
                                System.out.println("Seleccione la materia:");
                                for (int i = 0; i < carreras.get(opcion - 1).getMaterias().size(); i++) {
                                    System.out.println((i + 1) + ". " + carreras.get(opcion - 1).getMaterias().get(i));
                                }
                                System.out.println("0. Cancelar visualización de alumnos");
                                opcion = scanner.nextInt();
                                scanner.nextLine();
                                if (opcion == 0) {
                                    opcion = -1;
                                    break;
                                } else if(opcion <= carreras.get(opcion - 1).getMaterias().size()){
                                    for(Alumno salida : carreras.get(opcion-1).getMaterias().get(opcion-1).getAlumnos()){
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
                    opcion = -1;
                    break;

                case 0:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    opcion = -1;
            }
        }
        scanner.close();
    }

    public void matricularNuevoAlumno(Scanner scanner, Carrera carrera) {
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

    public void inscribirAlumnoEnMateria(Scanner scanner, Carrera carrera) {
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
                materia.addAlumno(alumno);
                System.out.println("Alumno inscrito en la materia " + materia.getNombre());
            } else {
                System.out.println("Opción de materia no válida.");
            }
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    public void cargarSituacionFinal(Scanner scanner) {
        System.out.println("Ingrese el nombre del alumno:");
        String nombreAlumno = scanner.nextLine();
        Alumno alumno = buscarAlumnoPorNombre(nombreAlumno);
        ArrayList<Materia> listado = getMateriasInscripto(alumno);

        if (alumno != null) {
            System.out.println("Seleccione la materia entre");
            for (int i = 0; i < listado.size(); i++) {
                System.out.println((i + 1) + ". " + listado.get(i).getNombre().toUpperCase());
            }
            int opcion = scanner.nextInt();

            if (opcion != 0 && opcion <= listado.size()) {
                Situacion sit_actual = listado.get(opcion-1).profesor.get_situacion_de_alumno(alumno);
                alumno.addSituacionMateria(listado.get(opcion),sit_actual);
                System.out.println("Situación final cargada.");
            } else {
                System.out.println("Materia no encontrada.");
            }
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    public ArrayList<Alumno> getAlumnosDeCarrera( Carrera carrera) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        for (Materia materia : carrera.getMaterias()) {
            if (materia.getAlumnos() == null | !materia.getAlumnos().isEmpty()) {
                alumnos.addAll(materia.getAlumnos());
            }
        }
        return alumnos;
    }

    public Alumno buscarAlumnoPorNombre(String nombre) {
        for (Carrera carrera : carreras) {
            for (Alumno alumno : carrera.getAlumnos()) {
                if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                    return alumno;
                }
            }
        }
        return null;
    }

    public ArrayList<Materia> getMateriasInscripto(Alumno alumno_encontrar){
        ArrayList<Materia> listado = new ArrayList<>();
        for (Carrera carrera : carreras){
            for (Materia materia : carrera.getMaterias()){
                    if(materia.getAlumnos().contains(alumno_encontrar)){
                        listado.add(materia);
                    }
            }
        }
        return listado;
    }

    public static void main(String[] args) {

        Universidad universidad = new Universidad();

        Coordinador co1 = new Coordinador("Matias","Hernandez",441212,"matu@hernandez.com",Sexo.MASCULINO,"donde e diablo perdio el poncho");
        Coordinador co2 = new Coordinador("Juan","Perez",476843,"Juanma@perez.com",Sexo.MASCULINO,"donde e diablo perdio la bota");
        Profesor p1 = new Profesor("Snape","Severus",13535,"",Sexo.MASCULINO,"Hogwarts");
        Profesor p2 = new Profesor("Hagrid","",26334,"",Sexo.MASCULINO,"Afuera de Hogwarts");

        ArrayList<Materia> materias_c1 = new ArrayList<>();
        materias_c1.add( new Materia("Defensa contra las artes oscuras",1,false,p1,null));
        materias_c1.add( new Materia("Pociones",1,true,p2,null));

        ArrayList<Materia> materias_c2 = new ArrayList<>();
        materias_c2.add( new Materia("Herbologia",2,false,p1,null));
        materias_c2.add( new Materia("Transformaciones",2,true,p2,null));

        Carrera c1 = new Carrera("Hechicero",10,co1,0,0, materias_c1);
        Carrera c2 = new Carrera("Cuidador de criaturas Magicas",10,co2,0,0, materias_c2);

        universidad.addCarreras(c1);
        universidad.addCarreras(c2);

        universidad.mostrarMenu();

    }
}