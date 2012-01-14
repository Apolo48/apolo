package comun;

/**
 * Clase para el manejo constantes realcionadas con los estatus de los registros
 * Cada estatus mantiene un unico significado en todo el negocio.
 * 
 * @author Robert A.
 * @author German L.
 * @version 0.1 14/01/2012
 */
public class EstatusRegistro {
	/**
	 * Indica que un registro existe de manera logica en la aplicacion y esta
	 * disponible para ser usado
	 */
	public static final char ACTIVO = 'A';

	/**
	 * Indica que un registro se ha eliminado de manera logica en la aplicacion.
	 * ya no se encuentar disponible para su uso.
	 */
	public static final char ELIMINADO = 'E';

	/**
	 * Indica que un registro esta almacenado de manera temporal en la base de
	 * datos, esperando la confirmacion/completar datos por otros procesos/
	 * acciones del usuario.
	 */
	public static final char TEMPORAL = 'T';

	/**
	 * Indica que un registro se encuentra en modo historico
	 */
	public static final char INACTIVO = 'I';

	/**
	 * Indica que el registro(aplicabale a jugadores) se encuentra temporalmente
	 * inactivo por lesi�n o sanci�n
	 */
	public static final char SUSPENDIDO = 'S';

}
