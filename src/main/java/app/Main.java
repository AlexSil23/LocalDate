package app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 * @author Alexander Silvera
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		String patternNacimiento = "d 'de' MMMM 'de' yyyy";
		LocalDateTime fechaHoy = LocalDateTime.now();
		String patternFecha = "EEEE, "+patternNacimiento+" 'a las' HH:mm";
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(patternFecha, Locale.forLanguageTag("es-ES"));
		System.out.println("Hoy es "+fechaHoy.format(formatoFecha)+"\n");
		LocalDate fechaNacimiento = null;
		try (Scanner entradaEsc = new Scanner(System.in)) {
			boolean validador= true;
			while(validador) {
				try {
					System.out.println("Introduzca su fecha de nacimiento en formato AAAA-MM-DD:");
					String datoCumple=entradaEsc.next();
					fechaNacimiento=LocalDate.parse(datoCumple.trim());
					validador = fechaNacimiento.isAfter(LocalDate.now()) ? true : false;
				} catch (DateTimeParseException e) {
					System.out.println("Formato de fecha incorrecto. Intentelo nuevamente.");
					System.out.println("Ej: 1990-09-24\n");
					}			
			}
		}
		DateTimeFormatter formatoNacimiento = DateTimeFormatter.ofPattern(patternNacimiento, Locale.forLanguageTag("es-ES"));
		System.out.println("Su fecha de nacimiento es el "+fechaNacimiento.format(formatoNacimiento)+"\n");
		
		System.out.println("Faltan "+cuentaRegresiva(fechaNacimiento)+" días para su próximo cumpleaños.");
		
		
	}

	/**
	 * Cuenta regresiva.
	 * 
	 * Calcula el número de días restantes hasta la próxima ocurrencia de una fecha de nacimiento.
	 * Si la fecha ya pasó en el año actual, calcula los días restantes para la próxima ocurrencia en el siguiente año.
	 *
	 * @param cumple la fecha de cumpleaños como un objeto {@code LocalDate}.
	 *               Solo se considera el día y mes de la fecha proporcionada; el año no es relevante.
	 * @return el número de días restantes hasta la próxima ocurrencia de la fecha proporcionada.
	 *         Si la fecha es hoy, devuelve 0. Si la fecha ya pasó en el año actual, devuelve el número de días hasta la fecha
	 *         en el próximo año.
	 */
	public static int cuentaRegresiva(LocalDate cumple) {
		LocalDate today = LocalDate.now();
		boolean isBisiesto = Year.isLeap(today.getYear());
		int numAnios = isBisiesto ? 366 : 365;		
		int num = (int) (cumple.withYear(today.getYear()).toEpochDay() - today.toEpochDay());		
		if (0 <= num) {
			return num;
		} else {
			return numAnios + num;
		}
	}
	
}
