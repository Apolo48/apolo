package dao.general;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.AfeccionJugador;

import dao.generico.GenericDao;

/**
 * Clase de acceso y manejo de los datos relacionados a las afecciones  de los
 * jugadores
 * 
 * @author Robert A
 * @author German L
 * @version 0.1 20/12/2011
 * 
 */
public class DaoAfeccionJugador extends GenericDao {

	/**
	 * Guarda las afecciones que padece un jugador
	 * @param afecciones Lista de afecciones padecidas  por un jugador
	 */
	public void guardar(List<AfeccionJugador> afecciones){
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		for (AfeccionJugador afeccionJugador : afecciones) {
			session.save(afeccionJugador);	
		}
		tx.commit();
	}

}
