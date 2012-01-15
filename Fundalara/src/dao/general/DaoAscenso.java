package dao.general;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import modelo.Ascenso;
import modelo.Roster;
import dao.generico.GenericDao;

/**
 * Clase de acceso y manejo para el ascenso por edad y especial 
 * de los jugadores 
 * 
 * @author Maria F
 * @author Romel V
 * @version 0.2 13/01/2012
 */
public class DaoAscenso extends GenericDao {

	/**
	 * Busca y Cambia de estatus el registro anterior del ascenso
	 * 
	 * @param Objeto
	 *            roster
	 */
	public void actualizar(Roster r) {
		Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Ascenso.class)
				.add(Restrictions.eq("roster", r))
				.add(Restrictions.eq("estatus", 'A'));
		Ascenso ascenso = (Ascenso) c.uniqueResult();
		if (ascenso != null) {
			ascenso.setEstatus('E');
			session.saveOrUpdate(ascenso);
		}
		tx.commit();
	}

	/**
	 *  Para agregar un nuevo registro de ascenso de la interfaz de Ascenso especial
	 * @param o
	 */
	public void guardar(Roster o) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(o);
		tx.commit();
	}

	/**
	 * Busca si un jugador ya fue ascendido en la interfaz de ascenso especial
	 * @param r datos de roster 
	 * @return datos de ascenso
	 */
	public Ascenso buscarAscenso(Roster r) {
		Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Ascenso.class)
				.add(Restrictions.eq("fechaAscenso", r.getFechaIngreso()))
				.add(Restrictions.eq("tipoAscenso", "ESPECIAL"))
				.add(Restrictions.eq("estatus", 'A'));
		return (Ascenso) c.uniqueResult();
	}
}
