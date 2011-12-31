package dao.general;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.generico.GenericDao;
import dao.generico.SessionManager;

import modelo.Equipo;
import modelo.Roster;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoRoster extends GenericDao {

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
		c.createCriteria("persona").createCriteria("personaNatural")
				.add(Restrictions.like("primerNombre", filtro3 + "%"))
				.add(Restrictions.like("primerApellido", filtro4 + "%"))
				.add(Restrictions.eq("estatus", 'A'));
		List<Roster> lista = c.list();
		return lista;
	}
}
