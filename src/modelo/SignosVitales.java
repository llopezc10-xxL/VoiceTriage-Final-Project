/**
 * Esta clase almacena los signos vitales del paciente, como lo son la PresionSistolica, PresionDiastolica, FrecuenciaCardiaca
 * entre muchas otras.
 * Esta hace imposible el ingreso de datos erroneos, ya que se establecen rangos clinicos validos para cada uno de los signos vitales.
 */

public class SignosVitales{
    private int presionSistolica;       //mmHg
    private int presionDiastolica;      //mmHg
    private int saturacionOxigeno;      //Porcentaje
    private int frecuenciaCardiaca;     //Latidos por minuto
    private double temperatura;         //Grados Celsius
    private int escalaDolor;            //Rango de 0-10


    private String marcaSistolica = "[Sin registrar]";
    private String marcaDiastolica = "[Sin registrar]";
    private String marcaSaturacion = "[Sin registrar]";
    private String marcaFrecuencia = "[Sin registrar]";
    private String marcaTemperatura = "[Sin registrar]";
    private String marcaDolor = "[Sin registrar]";

//Constuctor vacio hecho para cuando se realize la implementacion del reconocimiento de voz
public SignosVitales(){

}

    //Contructor de la clase
    public SignosVitales(int presionSistolica, int presionDiastolica, int saturacionOxigeno, int frecuenciaCardiaca, double temperatura, int escalaDolor) {
        setPresionSistolica(presionSistolica);
        setPresionDiastolica(presionDiastolica);
        setSaturacionOxigeno(saturacionOxigeno);
        setFrecuenciaCardiaca(frecuenciaCardiaca);
        setTemperatura(temperatura);
        setEscalaDolor(escalaDolor);
    }

    //Metodos Getters y Setters
    /**
     * No usamos exepciones en este apartado para una mayor facilidad del llenado de informacion por parte del equipo de salud,
     * y es menos practico que el sistema se detenga por un error de digitacion, por lo que se opto por mostrar un mensaje de error
     * en el mismo campo y asi poder corregirlo de forma mas rapida y sencilla, sin necesidad de reiniciar el sistema.
     */
    public void setPresionSistolica(int sistolica){
        if(sistolica <40 || sistolica > 300){
            this.presionSistolica = "[! Error de dictado (" + sistolica + " mmHg) Fuera de rango -Corregir]";
            return;
        }

        this.presionSistolica = sistolica;
        if(sistolica < 90){
            this.marcaSistolica = "[¡ALERTA! Presion Baja (Hipotension)]";
        } else if(sistolica >= 90 && sistolica <= 120){
            this.marcaSistolica = "[Normal]";
        }else if(sistolica > 120 && sistolica <= 140){
            this.marcaSistolica = "[¡ALERTA! Presion Elevada (Hipertension)]";
        }else{
            this.marcaSistolica = "[¡CRISIS! Presion Muy Elevada (Hipertensiva)]";
        }
    }

    public void setPresionDiastolica(int diastolica){
        if(diastolica < 20 || diastolica > 300){
            this.presionDiastolica = "[! Error de dictado (" + diastolica + " mmHg) Fuera de rango -Corregir]";
            return;
        }

        this.presionDiastolica = diastolica;
        if(diastolica < 60){
            this.marcaDiastolica = "[¡ALERTA! Presion Baja (Hipotension)]";
        } else if(diastolica >= 60 && diastolica <= 80){
            this.marcaDiastolica = "[Normal]";
        }else if(diastolica > 80 && diastolica <= 90){
            this.marcaDiastolica = "[¡ALERTA! Presion Elevada (Hipertension)]";
        }else{
            this.marcaDiastolica = "[¡CRISIS! Presion Muy Elevada (Hipertensiva)]";
        }
    }

    public void setSaturacionOxigeno(int saturacion){
        if(saturacion < 30 || saturacion > 100){
            this.saturacionOxigeno = "[! Error de dictado (" + saturacion + ") Fuera de rango -Corregir]";
            return;
        }

        this.saturacionOxigeno = saturacion;
        if(saturacion < 90){
            this.marcaSaturacion = "[¡ALERTA! Saturacion Baja (Hipoxemia)]";
        } else if(saturacion >= 90 && saturacion <= 100){
            this.marcaSaturacion = "[Normal]";
        }
    }


    public void setFrecuenciaCardiaca(int frecuencia){
        if(frecuencia < 20 || frecuencia > 250){
            this.frecuenciaCardiaca = "[! Error de dictado (" + frecuencia + " lpm) Fuera de rango -Corregir]";
            return;
        }

        this.frecuenciaCardiaca = frecuencia;
        if(frecuencia < 60){
            this.marcaFrecuencia = "[¡ALERTA! Frecuencia Baja (Bradicardia)]";
        } else if(frecuencia >= 60 && frecuencia <= 100){
            this.marcaFrecuencia = "[Normal]";
        }else{
            this.marcaFrecuencia = "[¡ALERTA! Frecuencia Elevada (Taquicardia)]";
        }
    }

    public void setTemperatura(double temp) {
        if (temp < 30.0 || temp > 44.0) {
            this.marcaTemperatura = "[! ERROR DE DICTADO (" + temp + " °C): Fuera de rango - CORREGIR]";
            return;
        }

        this.temperatura = temp;
        if (temp < 35.5) {
            this.marcaTemperatura = "[ALERTA: Hipotermia]";
        } else if (temp <= 37.5) {
            this.marcaTemperatura = "[Normal]";
        } else if (temp <= 39.5) {
            this.marcaTemperatura = "[ALERTA: Fiebre moderada]";
        } else {
            this.marcaTemperatura = "[*** PELIGRO: Fiebre alta ***]";
        }
    }

    public void setEscalaDolor(int dolor){
        if(dolor < 0 || dolor > 10){
            this.escalaDolor = "[! Error de dictado (" + dolor + ") Fuera de rango -Corregir]";
            return;
        }

        this.escalaDolor = dolor;
        if(dolor == 0){
            this.marcaDolor = "[Sin Dolor]";
        } else if(dolor >= 1 && dolor <= 3){
            this.marcaDolor = "[Dolor Leve]";
        }else if(dolor >= 4 && dolor <= 6){
            this.marcaDolor = "[Dolor Moderado]";
        }else if(dolor >= 7 && dolor <= 9){
            this.marcaDolor = "[Dolor Severo]";
        }else{
            this.marcaDolor = "[¡ALERTA! Dolor Extremo]";
        }
    }

    public int getPresionSistolica() {
        return presionSistolica;
    }

    public int getPresionDiastolica() {
        return presionDiastolica;
    }
    public int getSaturacionOxigeno() {
        return saturacionOxigeno;
    }
    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }
    public double getTemperatura() {
        return temperatura;
    }
    public int getEscalaDolor() {
        return escalaDolor;
    }

    public boolean tieneErroresDeCaptura(){
        return marcaSistolica.contains("Error") ||
              marcaDiastolica.contains("Error") || 
              marcaSaturacion.contains("Error") ||
              marcaFrecuencia.contains("Error") || 
             marcaTemperatura.contains("Error") || 
             marcaDolor.contains("Error");
    }

   //Metodo toString para obtener los datos de los signos vitales en un formato legible y entendible para el personal de salud
    @Override
    public String toString() {
        return "Signos Vitales:\n" +
                "Presion Sistolica: " + presionSistolica + " mmHg " + marcaSistolica + "\n" +
                "Presion Diastolica: " + presionDiastolica + " mmHg " + marcaDiastolica + "\n" +
                "Saturacion de Oxigeno: " + saturacionOxigeno + "% " + marcaSaturacion + "\n" +
                "Frecuencia Cardiaca: " + frecuenciaCardiaca + " lpm " + marcaFrecuencia + "\n" +
                "Temperatura: " + temperatura + " °C " + marcaTemperatura + "\n" +
                "Escala de Dolor: " + escalaDolor + "/10 " + marcaDolor;
    } 


}