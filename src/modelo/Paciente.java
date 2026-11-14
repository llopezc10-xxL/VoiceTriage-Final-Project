/**
 * Esta clase representa al paciente que ingresa al hospital.
 * Este hereda los atributos de la clase Persona y se agregan los atributos propios de esta clase)
 */
public class Paciente extends Persona{
    private String sexo;
    private String eps;


    public Paciente(String nombre, String identificacion, int edad, String sexo, String eps) {
        super(nombre, identificacion, edad);
        this.sexo = sexo;
        this.eps = eps;
    }

    /**
     * Constructor vacio hecho para cuando se realize la implementacion del reconocimiento de voz
     * esta vaya llenando los datos del paciente a medida que se vaya dictando la informacion.
     */
    public Paciente() {
        super();
    }


    //Metodos Getters y Setters
    public String getSexo() {
        return sexo;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        if(eps == null || eps.isEmpty()) {
            throw new IllegalArgumentException("La EPS no puede estar vacía.");
        }
        else {
            this.eps = eps;
        }
    }

    //Metodo abstracto heradado de la clase Persona que permite obtener la informacion del paciente en su propio formato
    @Override
    public String obtenerResumenPerfil() {
        return "Nombre: " + nombre + "\n" +
                "Identificación: " + identificacion + "\n" +
                "Edad: " + edad + "\n" +
                "Sexo: " + sexo + "\n" +
                "EPS: " + eps;
    }
}