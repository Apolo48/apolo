package dao.general;

import java.util.List;

import modelo.Familiar;
import modelo.FamiliarJugador;
import modelo.Jugador;
import modelo.PersonaNatural;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;

/**
 * Clase de acceso y manejo de los datos relacionados a los familiares de los
 * jugadores
 * 
 * @author Robert A
 * @author German L
 * @version 0.1.3 21/01/2012
 * 
 */

public class DaoFamiliar extends GenericDao {

	public List<Familiar> cargarlista(String filtro1, String filtro2,
			String filtro3) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		Criteria c = session.createCriteria(Familiar.class)
				.add(Restrictions.like("cedulaRif", filtro1 + "%"))
				.createCriteria("personaNatural")
				.add(Restrictions.like("primerNombre", filtro2 + "%"))
				.add(Restrictions.like("primerApellido", filtro3 + "%"));
		List<Familiar> lista = c.list();

		return lista;
	}

	public void guardar(List<Familiar> familiares, Jugador jugador) {
		int cantidad = 0;
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		for (Familiar familiar : familiares) {
			Criteria c = session.createCriteria(Familiar.class).add(
					Restrictions.eq("cedulaRif", familiar.getCedulaRif()));
			c.setProjection(Projections.rowCount());
			cantidad = (Integer) c.list().get(0);
			if (cantidad != 0) {// Actualizar
				session.update(familiar.getPersonaNatural().getPersona());
				session.update(familiar.getPersonaNatural());
				session.update(familiar);
			} else {// guardar
				
				
				session.save(familiar.getPersonaNatural().getPersona());
				session.save(familiar.getPersonaNatural());
				session.save(familiar);
			}
			
			//FamiliarJugador familiar
		}
		tx.commit();
	}

}
