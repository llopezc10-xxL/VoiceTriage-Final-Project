package logica.entradavoz;

/**
 * Entrada de voz: captura el audio que dicta el personal de salud.

 * Con base en investigaciones y consultas previas sobre programas de entrada
 de voz, se encontró que la mayoría se desarrollan en Python, Java o
 JavaScript, por ser los lenguajes con mejor rendimiento y más soporte para
 esta tarea. Por eso se planteó realizar el reconocimiento de voz en dos
 partes independientes: la entrada de voz (esta clase) y la transcripción de
 voz (clase TranscripcionVoz).

 * Responsabilidad: obtener el audio del micrófono y entregarlo, sin interpretar
 su contenido. No sabe nada de pacientes ni de triaje.

 * Separar ambas partes permite que cada una trabaje de forma independiente: si
 hay errores o mejoras en la captura del audio, se corrige o se cambia esta
 clase sin tocar la transcripción, lo que hace el código más práctico de
 mantener.

 * Estado: estructura base. Aún no se ha implementado ni integrado al programa.
 La tecnología concreta se define a partir de las investigaciones en curso.
 */
public class EntradaVoz {

}