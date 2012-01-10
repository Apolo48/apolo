package dao.general;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.generico.GenericDao;
import dao.generico.SessionManager;

import modelo.Equipo;
import modelo.Roster;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	public List<Object> buscarCategoria(String ced) {
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		List<Object> arr = new ArrayList<Object>();

		Object o = session
				.createSQLQuery(
						"select categoria.nombre from categoria,roster,equipo where roster.cedula_rif='"
								+ ced
								+ "' and roster.estatus='A' and roster.codigo_equipo=equipo.codigo_equipo and categoria.codigo_categoria > equipo.codigo_categoria")
				.list();

		arr.add(o);
		for (Object object : arr) {
			System.out.println(object.toString());
		}
		;
		return arr;
	}

	public List buscarJugadores(Equipo equipo, String filtro2, String filtro3,
			String filtro4, String filtro1) {
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Roster.class)
				.add(Restrictions.eq("equipo", equipo))
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
	 * @param Nro de Cédula del jugador
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
}
