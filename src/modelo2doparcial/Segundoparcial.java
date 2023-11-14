package modelo2doparcial;
import java.sql.*;
import java.util.Scanner;

// 1. Define la clase abstracta Persona con atributos comunes para pacientes y doctores.
abstract class Persona {
    protected String nombre;
    protected int edad;

    // Constructor y métodos necesarios

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

// 2. Implementa la clase Paciente que hereda de Persona con atributos adicionales como historial médico.
class Paciente extends Persona {
    private String historialMedico;
    private int doctorCabecera;
    private Date fechaIngreso;

    public Paciente(String nombre, int edad, String historialMedico, int doctorCabecera, Date fechaIngreso) {
        super( nombre, edad);
        this.historialMedico = historialMedico;
        this.doctorCabecera = doctorCabecera;
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public int getDoctorCabecera() {
        return doctorCabecera;
    }
}


// 3. Implementa la clase Doctor que hereda de Persona con atributos como especialidad.
class Doctor extends Persona {
    private String especialidad;
    private int id;

    public Doctor(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;


    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public String getEspecialidad(){
        return especialidad;
    }



}

class Hospital {
    public void agregarDoctor(Doctor doctor) {
        // Agregar el doctor a la base de datos
        // Modifica la línea en la clase Hospital
        // Modifica la línea en la clase Hospital
        String consulta = "INSERT INTO doctores (nombre, edad, especialidad) VALUES ('" + doctor.getNombre() + "', " + doctor.getEdad() + ", '" + doctor.getEspecialidad() + "')";


        DBHelper.ejecutarConsulta(consulta);
    }
    public void agregarPaciente(Paciente paciente) {
        // Agregar el paciente a la base de datos
        String consulta = "INSERT INTO pacientes (nombre, edad, historial_medico, doctor, fecha_ingreso) VALUES ('" + paciente.getNombre() + "', " + paciente.getEdad() + ", '" + paciente.getHistorialMedico() + "', " + paciente.getDoctorCabecera() + ", '" + paciente.getFechaIngreso() + "')";
        DBHelper.ejecutarConsulta(consulta);
    }
    // elimine un paciente indicando su nombre
    public void eliminarPaciente(String nombre) {
        // Eliminar el paciente de la base de datos
        String consulta = "DELETE FROM pacientes WHERE nombre = '" + nombre + "'";
        DBHelper.ejecutarConsulta(consulta);
    }

    //método para asignar un doctor de cabecera a un paciente indicando el nombre del doctor y el nombre del paciente
    public void asignarDoctorCabecera(String nombreDoctor, String nombrePaciente) {
        String consulta = "UPDATE pacientes SET doctor = (SELECT id FROM doctores WHERE nombre = '"+nombreDoctor+"') WHERE nombre = '"+nombrePaciente+"'";
        DBHelper.ejecutarConsulta(consulta);
    }

    public void listarPacientes() {
        String consulta = "SELECT * FROM pacientes";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        listarPacientes(resultado);
    }

    public void listarPacientesEntreDosFechas(Date fechaDesde, Date fechaHasta) {
        String consulta = "SELECT * FROM pacientes WHERE fecha_ingreso BETWEEN '"+fechaDesde+"' AND '"+fechaHasta+"';";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        listarPacientes(resultado);
    }
    //mostrar listado de pacientes
    public void listarPacientes(ResultSet resultado){
        if (resultado != null) {
            try {
                System.out.println("Lista de Pacientes:");
                System.out.printf("%-10s %-15s %-5s %-20s %-12s %-10s\n", "ID", "Nombre", "Edad", "Historial Médico", "Fecha Ingreso", "Doctor");

                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nombre = resultado.getString("nombre");
                    int edad = resultado.getInt("edad");
                    String historialMedico = resultado.getString("historial_medico");
                    Date fechaIngreso = resultado.getDate("fecha_ingreso");
                    int idDoctor = resultado.getInt("doctor");

                    System.out.printf("%-10d %-15s %-5d %-20s %-12s %-10d\n", id, nombre, edad, historialMedico, fechaIngreso, idDoctor);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



class DBHelper {
    private static final String URL = "jdbc:mariadb://localhost:3306/hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para ejecutar una consulta sin devolver resultados
    public static void ejecutarConsulta(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                // Ejecutar la consulta
                statement.executeUpdate();
            }

            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para ejecutar una consulta y devolver un conjunto de resultados
    public static ResultSet ejecutarConsultaConResultado(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            PreparedStatement statement = connection.prepareStatement(consulta);

            // Ejecutar la consulta y devolver el conjunto de resultados
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}

class HospitalBasesDeDatos {
    public static void main(String[] args) {
        // Crear un objeto de la clase Hospital
        Hospital hospital = new Hospital();

        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Menú principal
        int opcion;
        do {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Añadir paciente");
            System.out.println("2. Eliminar paciente");
            System.out.println("3. Ver lista de pacientes");
            System.out.println("4. Mostrar la lista de pacientes que ingresaron entre dos fechas");
            System.out.println("5. Asignar un doctor de cabecera a un paciente");
            System.out.println("6. Añadir un nuevo doctor");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            // Leer la opción del usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            // Realizar la acción correspondiente según la opción seleccionada
            switch (opcion) {
                case 1:
                    // Añadir paciente
                    agregarPaciente(hospital, scanner);
                    break;
                case 2:
                    // Eliminar paciente
                    eliminarPaciente(hospital, scanner);
                    break;
                case 3:
                    // Ver lista de pacientes
                    hospital.listarPacientes();
                    break;
                case 4:
                    // Mostrar la lista de pacientes que ingresaron entre dos fechas
                    mostrarListaEntreFechas(hospital, scanner);
                    break;
                case 5:
                    // Asignar un doctor de cabecera a un paciente
                    asignarDoctorCabecera(hospital, scanner);
                    break;
                case 6:
                    // Añadir nuevo doctor
                    agregarNuevoDoctor(hospital, scanner);
                    break;
                case 0:
                    // Salir
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }

        } while (opcion != 0);

        // Cerrar el escáner
        scanner.close();
    }

    private static void agregarPaciente(Hospital hospital, Scanner scanner) {
        // Obtener información del paciente
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del paciente: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Ingrese el historial médico del paciente: ");
        String historialMedico = scanner.nextLine();

        System.out.print("Ingrese el ID del doctor de cabecera: ");
        int idDoctorCabecera = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Crear objeto Paciente y agregarlo al hospital
        Date fechaActual = new Date(System.currentTimeMillis());
        Paciente paciente = new Paciente(nombre, edad, historialMedico, idDoctorCabecera, fechaActual);
        hospital.agregarPaciente(paciente);

        System.out.println("Paciente agregado con éxito.");
    }

    private static void eliminarPaciente(Hospital hospital, Scanner scanner) {
        // Obtener el nombre del paciente a eliminar
        System.out.print("Ingrese el nombre del paciente a eliminar: ");
        String nombrePaciente = scanner.nextLine();

        // Eliminar el paciente del hospital
        hospital.eliminarPaciente(nombrePaciente);

        System.out.println("Paciente eliminado con éxito.");
    }

    private static void mostrarListaEntreFechas(Hospital hospital, Scanner scanner) {
        // Obtener fechas del usuario
        System.out.print("Ingrese la fecha de inicio (formato yyyy-mm-dd): ");
        String fechaInicioStr = scanner.nextLine();
        Date fechaInicio = Date.valueOf(fechaInicioStr);

        System.out.print("Ingrese la fecha de fin (formato yyyy-mm-dd): ");
        String fechaFinStr = scanner.nextLine();
        Date fechaFin = Date.valueOf(fechaFinStr);

        // Mostrar la lista de pacientes entre las dos fechas
        hospital.listarPacientesEntreDosFechas(fechaInicio, fechaFin);
    }

    private static void asignarDoctorCabecera(Hospital hospital, Scanner scanner) {
        // Obtener nombres del paciente y doctor del usuario
        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        System.out.print("Ingrese el nombre del doctor de cabecera: ");
        String nombreDoctor = scanner.nextLine();

        // Asignar el doctor de cabecera al paciente
        hospital.asignarDoctorCabecera(nombreDoctor, nombrePaciente);

        System.out.println("Doctor de cabecera asignado con éxito.");
    }
    private static void agregarNuevoDoctor(Hospital hospital, Scanner scanner) {
        // Obtener información del doctor
        System.out.print("Ingrese el nombre del doctor: ");
        String nombreDoctor = scanner.nextLine();

        System.out.print("Ingrese la edad del doctor: ");
        int edadDoctor = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Ingrese la especialidad del doctor: ");
        String especialidadDoctor = scanner.nextLine();


        // Crear objeto Doctor y agregarlo al hospital
        Doctor nuevoDoctor = new Doctor(nombreDoctor, edadDoctor, especialidadDoctor);
        hospital.agregarDoctor(nuevoDoctor);

        System.out.println("Doctor agregado con éxito.");
    }
}