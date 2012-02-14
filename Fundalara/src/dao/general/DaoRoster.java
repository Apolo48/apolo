package dao.general;

import java.util.Date;
import java.util.List;

import dao.generico.GenericDao;

import modelo.Equipo;
import modelo.Jugador;
import modelo.Roster;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * Clase de acceso y manejo de los datos relacionados al roster de los equipos
 * 
 * @author Robert A
 * @author German L
 * @author Maria F
 * @author Romel V
 * @author Miguel B
 * @version 0.1 02/01/2012
 * 
 */
public class DaoRoster extends GenericDao {
	public static String SECUENCIA ="roster_codigo_roster_seq1";
	
	public List buscarJugadores(String filtro2, String filtro3,
			String filtro4, String filtro1) {
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Roster.class)
				.add(Restrictions.eq("estatus", 'A'))
				.add(Restrictions.like("jugador.cedulaRif", filtro2 + "%"))
				.createCriteria("jugador");
		if (filtro1 != "") {
			c.add(Restrictions.eq("numero", Integer.valueOf(filtro1)));
		}
		c.createCriteria("personaNatural")
				.add(Restrictions.like("primerNombre", filtro3 + "%"))
				.add(Restrictions.like("primerApellido", filtro4 + "%"))
				.add(Restrictions.eq("estatus", 'A'));
		List<Roster> lista = c.list();
		return lista;
	}
	
	/**
	 * Busca el ultimo valor de la clave primaria de la tabla Roster
	 * 
	 * @return int ultimo id
	 */
	public int obtenerUltimoId() {
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query query = session
				.createSQLQuery("SELECT last_value FROM "+SECUENCIA);
		int id = Integer.valueOf(query.uniqueResult().toString());
		tx.commit();

		return id;
	}
	
	/**
	 * Busca el registro del roster al que pertenece un jugador
	 * 
	 * @param Nro de C�dula del jugador
	 * @return Un objeto Roster sino null
	 */
	public Roster buscarRoster(String ced) {
		Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Roster.class)
				.add(Restrictions.eq("jugador.cedulaRif", ced))
				.add(Restrictions.eq("estatus", 'A'));
		return (Roster) c.uniqueResult();
	}
	
	 /**
	  * Guarda los datos de roster
	 * @param o objeto roster
	 */
	public void guardar(Roster o) {		
			Session session = getSession();
			Transaction tx =  session.beginTransaction();
			session.save(o);
			tx.commit();		
		}
	
	public List<Roster> buscarEquipo(Jugador jugador, Date fecha) {
		Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Roster.class).addOrder(
				Order.desc("fechaIngreso"));
		c.add(Restrictions.eq("jugador", jugador));
		if (c.list().size() == 0)
			return null;
		else
			return c.list();
	}
	
	/**
	 * Busca los jugadores que estan en un equipo
	 * 
	 * @param Objeto Equipo 
	 * @return Lista de jugadores en ese equipo sino null
	 */
	public List listarJugadores(Equipo equipo) {
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Roster.class)
				.add(Restrictions.eq("equipo", equipo))
				.add(Restrictions.eq("estatus", 'A'));
		List<Roster> lista = c.list();
		return lista;
	}
	
	public Roster buscarRosterPendiente(Jugador jugador){
		Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Roster.class)
				.add(Restrictions.eq("jugador", jugador))
				.add(Restrictions.eq("estatus", 'P'));
		return (Roster) c.uniqueResult();
	}
	
	public void confirmarRoster(Roster roster){
		Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		roster.setEstatus('A');
		session.update(roster);
		tx.commit();	
	}
	
}
