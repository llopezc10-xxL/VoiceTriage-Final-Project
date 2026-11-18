/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Lucho
 */
/**
 * Esta clase representa al personal de salud que trabaja en el hospital. De la
 * misma manera que Paciente, esta hereda atributos de la clase persona y cuenta
 * con atributos propios de esta clase.
 */
public class PersonalSalud extends Persona {
    
    private String especialidad;
    private String cargo;
    private String registroProfesional;
    //Usuario y contraseña pero inicio de sesion dentro del sistema, para así tener un mayor orden por cada personal de salud, y un mejor registro de pacientes
    private String user;
    private String password;

    public PersonalSalud(String nombre, String identificacion, int edad, String especialidad, String cargo, String registroProfesional) {
        super(nombre, identificacion, edad);
        setEspecialidad(especialidad); //Ejemplos: Pediatria, Ginecologia, Medicina Interna, etc.
        setCargo(cargo); //Ejemplos: Enfermero, Auxiliar, Medico, etc.
        setRegistroProfesional(registroProfesional); //Ejemplos: Numero de matricula, numero de registro profesional.
    }

    /**
     * Constructor vacio hecho para cuando se realize la implementacion del
     * reconocimiento de voz esta vaya llenando los datos del personal de salud
     * a medida que se vaya dictando la informacion.
     * Aun en desarrollo.
     */
    public PersonalSalud() {
        super();
    }

    //Metodos Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("Rspecialidad no puede estar vacía.");
        } else {
            this.especialidad = especialidad;
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("Rargo no puede estar vacío.");
        } else {
            this.cargo = cargo;
        }
    }

    public String getRegistroProfesional() {
        return registroProfesional;
    }

    public void setRegistroProfesional(String registroProfesional) {
        if (registroProfesional == null || registroProfesional.trim().isEmpty()) {
            throw new IllegalArgumentException("Registro profesional no puede estar vacío.");
        } else {
            this.registroProfesional = registroProfesional;
        }
    }
    
    public String getUser(){
        return user;
    }
    
    public void setUser(String user){
        if(user == null || user.trim().isEmpty()){
            throw new IllegalArgumentException("User no puede estar vacio");
        }
        this.user = user;
    }
    //Metodo analizador para verificar que el User y password ingresados por el personal de salud sea correcto
    public boolean validarCredenciales(String userIngresado, String passIngresada) {
        if (this.user == null || this.password == null) {
            return false;
        }
        return this.user.equals(userIngresado) && this.password.equals(passIngresada);
    }
    //Metodo modificador de la contraseña con revision de seguridad
    public boolean cambiarPassword(String passActual, String passNueva) {
        if (this.password != null && this.password.equals(passActual)) {
            if (passNueva == null || passNueva.length() < 4) {
                throw new IllegalArgumentException("La nueva contraseña debe tener al menos 4 caracteres.");
            }
            this.password = passNueva;
            return true; // Cambio exitoso
        }
        return false; // Clave actual incorrecta, no se permite el cambio
    }
    
    //Metodo abstracto heradado de la clase Persona que permite obtener la informacion del personal de salud en su propio formato
    @Override
    public String obtenerResumenPerfil() {
        return "Nombre: " + nombre + "\n"
                + "Identificación: " + identificacion + "\n"
                + "Edad: " + edad + "\n"
                + "Especialidad: " + especialidad + "\n"
                + "Cargo: " + cargo + "\n"
                + "Registro Profesional: " + registroProfesional;
    }
}
