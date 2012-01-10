package dao.general;

import modelo.Jugador;
import modelo.PersonaNatural;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.generico.GenericDao;

/**
 * Clase de acceso y manejo de los datos relacionados a los
 * jugadores
 * 
 * @author Robert A
 * @author German L
 * @version 0.1.7 23/12/2011
 * 
 */
public class DaoJugador extends GenericDao {
	
	/**
	 * Guarda los datos de un jugador en las correspondintes entidades que lo conforman
	 * @param c Objeto Jugador a ser guardado 
	 * @param pn Objeto persona Natural a ser guardado
	 */
	public void guardar(Jugador c, PersonaNatural pn){
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		session.save(c.getPersonaNatural().getPersona());
		session.save(c.getPersonaNatural());
		session.save(c);
		tx.commit();	
		
	}
	
	
	/**
	 * Actualiza los datos de un jugador en las correspondintes entidades que lo conforman
	 * @param c Objeto Jugador a ser actualizado 
	 * @param pn Objeto persona Natural a ser actualizado
	 */
	public void actualizar(Jugador c, PersonaNatural pn){
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		session.saveOrUpdate(c.getPersonaNatural().getPersona());
		session.saveOrUpdate(c.getPersonaNatural());
		session.saveOrUpdate(c);
		tx.commit();	
		
		
	}

}
