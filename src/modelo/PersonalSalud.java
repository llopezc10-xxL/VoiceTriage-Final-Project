/**
 * Esta clase representa al personal de salud que trabaja en el hospital.
 * De la misma manera que Paciente, esta hereda atributos de la clase persona
 * y cuenta con atributos propios de esta clase.
 */
public class PersonalSalud extends Persona {
    private String especialidad;
    private String cargo;
    private String registroProfesional;

    public PersonalSalud(String nombre, String identificacion, int edad, String especialidad, String cargo, String registroProfesional) {
        super(nombre, identificacion, edad);
        this.especialidad = especialidad; //Ejemplos: Pediatria, Ginecologia, Medicina Interna, etc.
        this.cargo = cargo; //Ejemplos: Enfermero, Auxiliar, Medico, etc.
        this.registroProfesional = registroProfesional; //Ejemplos: Numero de matricula, numero de registro profesional.
    }

    /**
     * Constructor vacio hecho para cuando se realize la implementacion del reconocimiento de voz
     * esta vaya llenando los datos del personal de salud a medida que se vaya dictando la informacion.
     */
    public PersonalSalud() {
        super();
    }

    //Metodos Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if(especialidad == null || especialidad.isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }
        else {
            this.especialidad = especialidad;
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if(cargo == null || cargo.isEmpty()) {
            throw new IllegalArgumentException("El cargo no puede estar vacío.");
        }
        else {
            this.cargo = cargo;
        }
    }

    public String getRegistroProfesional() {
        return registroProfesional;
    }

    public void setRegistroProfesional(String registroProfesional) {
        if(registroProfesional == null || registroProfesional.isEmpty()) {
            throw new IllegalArgumentException("El registro profesional no puede estar vacío.");
        }
        else {
            this.registroProfesional = registroProfesional;
        }
    }

    //Metodo abstracto heradado de la clase Persona que permite obtener la informacion del personal de salud en su propio formato
    @Override
    public String obtenerResumenPerfil() {
        return "Nombre: " + nombre + "\n" +
                "Identificación: " + identificacion + "\n" +
                "Edad: " + edad + "\n" +
                "Especialidad: " + especialidad + "\n" +
                "Cargo: " + cargo + "\n" +
                "Registro Profesional: " + registroProfesional;
    }