package dao.general;

import java.util.ArrayList;
import java.util.List;

import modelo.Jugador;
import modelo.Persona;
import modelo.PersonaNatural;
import modelo.RetiroTraslado;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;

/**
 * Clase de acceso y manejo de los datos relacionados a los jugadores
 * 
 * @author Robert A
 * @author German L
 * @author Edgar L
 * @version 0.1.9 10/01/2012
 * 
 */
public class DaoJugador extends GenericDao {

	/**
	 * Guarda los datos de un jugador en las correspondintes entidades que lo
	 * conforman
	 * 
	 * @param c
	 *            Objeto Jugador a ser guardado
	 */
	public void guardar(Jugador c) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(c.getPersonaNatural().getPersona());
		session.save(c.getPersonaNatural());
		session.save(c);
		tx.commit();
	}

	/**
	 * Actualiza los datos de un jugador en las correspondintes entidades que lo
	 * conforman
	 * 
	 * @param c
	 *            Objeto Jugador a ser actualizado
	 */
	public void actualizar(Jugador c) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(c.getPersonaNatural().getPersona());
		session.saveOrUpdate(c.getPersonaNatural());
		session.saveOrUpdate(c);
		tx.commit();
	}

	/**
	 * @param jugador
	 *            El jugador que desea retirarse
	 */
	public void retirar(Jugador jugador) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		Criteria c = session.createCriteria(PersonaNatural.class).add(
				Restrictions.eq("cedulaRif", jugador.getCedulaRif()));

		PersonaNatural personaN = (PersonaNatural) c.uniqueResult();
		personaN.setEstatus('E');
		session.update(personaN);

		Criteria c2 = session.createCriteria(Persona.class).add(
				Restrictions.eq("cedulaRif", jugador.getCedulaRif()));

		Persona persona = (Persona) c2.uniqueResult();
		persona.setEstatus('E');
		session.update(persona);

		Criteria c3 = session.createCriteria(Jugador.class).add(
				Restrictions.eq("cedulaRif", jugador.getCedulaRif()));

		Jugador jugador2 = (Jugador) c3.uniqueResult();
		jugador2.setEstatus('E');
		session.update(jugador2);
		tx.commit();
	}

	public List buscarJugadores(String filtro2, String filtro3, String filtro4,
			String filtro1, char estatus) {
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		if (estatus == 'E') {
			Criteria c = session.createCriteria(Jugador.class)
					.add(Restrictions.eq("estatus", estatus))
					.add(Restrictions.like("cedulaRif", filtro2 + "%"));
			if (filtro1 != "") {
				c.add(Restrictions.eq("numero", Integer.valueOf(filtro1)));
			}
			c.createCriteria("personaNatural")
					.add(Restrictions.like("primerNombre", filtro3 + "%"))
					.add(Restrictions.like("primerApellido", filtro4 + "%"));
			List<Jugador> lista2 = c.list();
			Criteria c1 = session.createCriteria(RetiroTraslado.class).add(
					Restrictions.eq("estatus", 'A'));
			List<RetiroTraslado> lista1 = c1.list();
			List<Jugador> lista = new ArrayList<Jugador>();
			for (int i = 0; i < lista2.size(); i++) {
				for (int j = 0; j < lista1.size(); j++) {
					if (lista2.get(i).getCedulaRif()
							.equals(lista1.get(j).getJugador().getCedulaRif())) {
						lista.add(lista2.get(i));

					}
				}
			}
			return lista;
		} else {
			Criteria c = session.createCriteria(Jugador.class)
					.add(Restrictions.eq("estatus", estatus))
					.add(Restrictions.like("cedulaRif", filtro2 + "%"));
			if (filtro1 != "") {
				c.add(Restrictions.eq("numero", Integer.valueOf(filtro1)));
			}
			c.createCriteria("personaNatural")
					.add(Restrictions.like("primerNombre", filtro3 + "%"))
					.add(Restrictions.like("primerApellido", filtro4 + "%"));
			List<Jugador> lista = c.list();
		
			return lista;
		}

	}
}
