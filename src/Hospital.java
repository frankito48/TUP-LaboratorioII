import java.io.*;
import java.util.*;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Doctor> doctores = cargarDoctores();
        List<Paciente> pacientes = new ArrayList<>();

        cargarDatosDeContacto();

        int opcion;
        do {
            System.out.println("Hospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399");
            System.out.println("Menú:");
            System.out.println("1. Listar Doctores.");
            System.out.println("2. Registrar un nuevo paciente.");
            System.out.println("3. Actualizar información personal de un paciente.");
            System.out.println("4. Consultar el historial médico de un paciente.");
            System.out.println("5. Nuevo historial para un paciente.");
            System.out.println("6. Guardar Historial de pacientes en archivo.");
            System.out.println("7. Cargar Historial de pacientes desde archivo.");
            System.out.println("8. Salir.");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listarDoctores(doctores);
                    break;
                case 2:
                    registrarNuevoPaciente(pacientes);
                    break;
                case 3:
                    actualizarInformacionPaciente(pacientes);
                    break;
                case 4:
                    consultarHistorialMedico(pacientes);
                    break;
                case 5:
                    cargarNuevoHistorialMedico(pacientes);
                    break;
                case 6:
                    guardarPacientesEnArchivo(pacientes);
                    break;
                case 7:
                    pacientes = cargarPacientesDesdeArchivo();
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static List<Doctor> cargarDoctores() {
        List<Doctor> doctores = new ArrayList<>();
        // Cargar doctores directamente en el código
        doctores.add(new Doctor("Dr. Juan Pérez", 12345678, "10/05/1970", "Cardiología"));
        doctores.add(new Doctor("Dr. María González", 98765432, "25/09/1985", "Pediatría"));
        doctores.add(new Doctor("Dr. Martin Cedrolla ", 3042304, "23/03/1978", "Neurologia"));
        return doctores;
    }

    private static void listarDoctores(List<Doctor> doctores) {
        System.out.println("LISTA DE DOCTORES: \n");
        for (Doctor doctor : doctores) {
            doctor.mostrarInformacion();
            System.out.println();
        }
    }

    private static void cargarDatosDeContacto() {
        try (Scanner entrada = new Scanner(new File("datos.txt"))) {
            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();
                System.out.println(linea);
            }
            System.out.println("Datos de contacto cargados desde el archivo con éxito.");
        } catch (FileNotFoundException e) {
            System.err.println("Error al cargar los datos de contacto desde el archivo: " + e.getMessage());
        }
    }

    private static void registrarNuevoPaciente(List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el DNI del paciente: ");
        int DNI = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la fecha de nacimiento del paciente (dd/MM/yyyy): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono del paciente: ");
        int telefono = scanner.nextInt();
        System.out.print("Ingrese el tipo de sangre del paciente: ");
        int tipoSangre = scanner.nextInt();

        Paciente paciente = new Paciente(nombre, DNI, fechaNacimiento, telefono, tipoSangre);
        pacientes.add(paciente);
        System.out.println("Paciente registrado exitosamente.");
    }

    private static void actualizarInformacionPaciente(List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del paciente que desea actualizar: ");
        int DNI = scanner.nextInt();

        for (Paciente paciente : pacientes) {
            if (paciente.getDNI() == DNI) {
                System.out.print("Ingrese el nuevo número de teléfono: ");
                int telefono = scanner.nextInt();
                System.out.print("Ingrese el nuevo tipo de sangre: ");
                int tipoSangre = scanner.nextInt();

                paciente.setTelefono(telefono);
                paciente.setTipoSangre(tipoSangre);
                System.out.println("Información actualizada exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró un paciente con el DNI ingresado.");
    }

    private static void consultarHistorialMedico(List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indique el DNI del paciente a buscar: ");
        int DNI = scanner.nextInt();

        for (Paciente paciente : pacientes) {
            if (paciente.getDNI() == DNI) {
                System.out.println("\nHISTORIAL MÉDICO para " + paciente.getNombre() + " (DNI: " + DNI + "):");
                paciente.verHistorialDeEventos();
                return;
            }
        }

        System.out.println("No se encontró un paciente con el DNI ingresado.");
    }

    private static void cargarNuevoHistorialMedico(List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indique el DNI del paciente al que desea agregar un nuevo historial médico: ");
        int DNI = scanner.nextInt();

        for (Paciente paciente : pacientes) {
            if (paciente.getDNI() == DNI) {
                System.out.print("Ingrese la fecha del nuevo evento (dd/MM/yyyy): ");
                scanner.nextLine(); // Consumir la nueva línea
                String fecha = scanner.nextLine();
                System.out.print("Ingrese las observaciones del nuevo evento: ");
                String observaciones = scanner.nextLine();

                paciente.agregarEventoHistorial(fecha, observaciones);
                System.out.println("Nuevo evento del historial médico agregado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró un paciente con el DNI ingresado.");
    }

    private static void guardarPacientesEnArchivo(List<Paciente> pacientes) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("pacientes.dat"))) {
            salida.writeObject(pacientes);
            System.out.println("Pacientes guardados en archivo exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los pacientes en el archivo: " + e.getMessage());
        }
    }

    private static List<Paciente> cargarPacientesDesdeArchivo() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("pacientes.dat"))) {
            List<Paciente> pacientes = (List<Paciente>) entrada.readObject();
            System.out.println("Pacientes cargados desde el archivo con éxito.");
            return pacientes;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los pacientes desde el archivo: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

class Persona1 implements Serializable {
    private String nombre;
    private int DNI;
    private String fechaNacimiento;

    public Persona1(String nombre, int DNI, String fechaNacimiento) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getDNI() {
        return DNI;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + DNI);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
    }
}

class Doctor extends Persona1 {
    private String especialidad;

    public Doctor(String nombre, int DNI, String fechaNacimiento, String especialidad) {
        super(nombre, DNI, fechaNacimiento);
        this.especialidad = especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Especialidad: " + especialidad);
    }
}

interface Informacion {
    void verHistorialDeEventos();
}

class Paciente extends Persona1 implements Informacion, Serializable {
    private int telefono;
    private int tipoSangre;
    private List<String> historialMedico;

    public Paciente(String nombre, int DNI, String fechaNacimiento, int telefono, int tipoSangre) {
        super(nombre, DNI, fechaNacimiento);
        this.telefono = telefono;
        this.tipoSangre = tipoSangre;
        this.historialMedico = new ArrayList<>();
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTipoSangre(int tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public int getTipoSangre() {
        return tipoSangre;
    }

    public void agregarEventoHistorial(String fecha, String observaciones) {
        String evento = fecha + " - " + observaciones;
        historialMedico.add(evento);
    }

    @Override
    public void verHistorialDeEventos() {
        for (String evento : historialMedico) {
            System.out.println(evento);
        }
    }
}
