package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Documento clínico del triaje que consolida al Paciente, al PersonalSalud
 * y compone los SignosVitales capturados mediante dictado por voz.
 */
public class FormularioTriaje {

    private LocalDateTime fechaHoraRegistro;
    private Paciente paciente;
    private PersonalSalud personalSalud;
    private SignosVitales signosVitales;
    private String motivoConsulta;
    private String textoTranscritoOriginal;
    private int nivelTriajeSugerido; // Prioridad de 1 a 5
    private boolean confirmado;

    public FormularioTriaje(Paciente paciente, PersonalSalud personalSalud) {
        this.fechaHoraRegistro = LocalDateTime.now();
        this.paciente = paciente;
        this.personalSalud = personalSalud;
        // Composición: los signos vitales se crean a partir de este apartado, ya que forman parte del formulario de triaje.
        this.signosVitales = new SignosVitales();
        this.confirmado = false;
    }

    public LocalDateTime getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PersonalSalud getPersonalSalud() {
        return personalSalud;
    }

    public void setPersonalSalud(PersonalSalud personalSalud) {
        this.personalSalud = personalSalud;
    }

    public SignosVitales getSignosVitales() {
        return signosVitales;
    }

    public void setSignosVitales(SignosVitales signosVitales) {
        this.signosVitales = signosVitales;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getTextoTranscritoOriginal() {
        return textoTranscritoOriginal;
    }

    public void setTextoTranscritoOriginal(String textoTranscritoOriginal) {
        this.textoTranscritoOriginal = textoTranscritoOriginal;
    }

    public int getNivelTriajeSugerido() {
        return nivelTriajeSugerido;
    }

    public void setNivelTriajeSugerido(int nivelTriajeSugerido) {
        if (nivelTriajeSugerido >= 1 && nivelTriajeSugerido <= 5) {
            this.nivelTriajeSugerido = nivelTriajeSugerido;
        } else {
            throw new IllegalArgumentException("El nivel de triaje debe ser entre 1 y 5.");
        }
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void confirmarFormulario() {
        this.confirmado = true;
    }

    public String generarResumenFormulario() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "==================================================\n" +
               "          FORMULARIO DE TRIAJE - URGENCIAS        \n" +
               "==================================================\n" +
               "Fecha/Hora : " + fechaHoraRegistro.format(formato) + "\n" +
               (personalSalud != null ? personalSalud.obtenerResumenPerfil() : "Atendido por: Pendiente") + "\n" +
               "--------------------------------------------------\n" +
               (paciente != null ? paciente.obtenerResumenPerfil() : "Paciente: Pendiente") + "\n" +
               "Motivo     : " + motivoConsulta + "\n" +
               "Signos     : " + signosVitales.toString() + "\n" +
               "--------------------------------------------------\n" +
               "Dictado Voz: \"" + textoTranscritoOriginal + "\"\n" +
               "TRIAJE SUGERIDO: NIVEL " + nivelTriajeSugerido + "\n" +
               "Estado     : " + (confirmado ? "CONFIRMADO" : "PENDIENTE DE REVISIÓN") + "\n" +
               "==================================================";
    }
}