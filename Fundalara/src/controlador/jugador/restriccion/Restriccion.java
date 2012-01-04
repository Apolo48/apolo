package controlador.jugador.restriccion;

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
	HORAS_SEMANAL_SOCIAL("min 1 max 30","Ingrese una cantidad de horas vádilas (01-30)"),
	CEDULA("no negative,no empty","Ingrese una cédula válida");

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

}
