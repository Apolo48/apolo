package controlador.jugador.restriccion;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Enumerado para mantener los valores constantes de los diferentes
 * restricciones y sus mensajes de error asociados
 * 
 * @author Robert A.
 * @author German L.
 * @version 0.1 03/01/2012
 */
public enum Restriccion {
	EMAIL("/.+@.+\\.[a-z]+/","Ingrese un correo electrónico válido, Ej: correo@servidor.com"),
	HORAS_SEMANAL_SOCIAL("min 1 max 30","Ingrese una cantidad de horas válidas (01-30)"),
	CEDULA("no negative,no empty","Ingrese una cédula válida"),
	TELEFONO("/[0-9]{7}/","Ingrese un número válido, Ej: 2660011"),
	TEXTO_SIMPLE("/^[a-zA-Z áéíóúAÉÍÓÚÑñ]+$/","Ingrese un texto válido"),
	FECHA_NACIMIENTO("between "+ getFecha(17,'1') + " and "+ getFecha(3,'2'),"Ingrese una fecha válida");

	private String constraint;
	private String mensaje;
	
	private Restriccion(String constraint, String mensaje) {
		this.constraint = constraint;
		this.mensaje = mensaje;
	}

	public String getConstraint() {
		return constraint;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getRestriccion() {
		return constraint + " : " + mensaje;
	}
	
	/**
	 * Genera texto de restriccion tomando como base el constraint del enumerado añadiendo los pasados por parametro
	 * @param restricciones arreglo de restricciones validas para objetos inputElement
	 * @return restriccion nueva con su mensaje de error
	 */
	public String asignarRestriccionExtra(String... restricciones) {
		String restriccion = constraint;
		for (String string : restricciones) {
			if (string != "") {
				restriccion += "," + string.trim();
			}
		}
		return restriccion + " : " + mensaje;
	}
	
	/**
	 * Obtiene la fecha correspondiente al limite inferior del rango de fechas de nacimiento.
	 * @param Valor int (numerico) correspondiente a la edad minima o maxima.
	 * @param Valor tipo char que define si la fecha solicitada es el limite inferior('1') o superior('2').
	 * @return Cadena String con fecha en formato "yyyyMMdd".
	 */
	public static String getFecha (int valor, char opc) {
 		Calendar hoy = Calendar.getInstance();
		int anno = hoy.get(Calendar.YEAR) - valor;
		Calendar fecha = Calendar.getInstance();
		if (opc == '1'){
			fecha.set(anno, Calendar.JANUARY, 1);
		} else {
			fecha.set(anno, Calendar.DECEMBER, 31);
		}
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
		return formato.format(fecha.getTime());
 	}

}
