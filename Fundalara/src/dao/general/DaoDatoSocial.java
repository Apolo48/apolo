package dao.general;

import java.util.List;

import modelo.DatoSocial;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.generico.GenericDao;

/**
 * Clase de acceso y manejo de los datos relacionados a los datos sociales del
 * jugador
 * 
 * @author Robert A
 * @author German L
 * @version 0.1 02/01/2012
 * 
 */
public class DaoDatoSocial extends GenericDao {
	public static String SECUENCIA = "dato_social_codigo_dato_social_seq_1";

	/**
	 * Guarda los datos de las actividades sociales (extra-academicas) en las
	 * que participa un jugador
	 * 
	 * @param datos
	 *            lista de actividades sociales
	 */
	public void guardar(List<DatoSocial> datos) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		for (DatoSocial dato : datos) {
			session.save(dato);
		}
		tx.commit();
	}
}
