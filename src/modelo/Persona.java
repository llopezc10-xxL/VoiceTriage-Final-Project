/**
 * Clase abstracta que representa a una persona y los datos basicos de esta misma como lo es nombre, identificacion y edad.
 * (Pacientes, personal de salud)
 */
public abstract class Persona {
    protected String nombre;
    protected String identificacion;
    protected int edad;
    
    //Constructor de la clase Persona
    public Persona(String nombre, String identificacion, int edad) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        setEdad(edad);
    }

    /**
     * Metodo vacio hecho para cuando se realize la implementacion del reconocimiento de voz
     */
    public Persona(){

    }

    //Metodos Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
        if (edad >=0 && edad <= 120) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("La edad está fuera del rango clinico valido (0-120).");
        }
    }
    /**
     * Metodo abstracto que permite obtener la informacion de la persona (Pacientes y personal de la salud) en su propio formato.
     *Todo esto depende de como la clase hija modifique este metodo por polimorfismo.
     */
    public abstract String obtenerResumenPerfil();
}