package dao.general;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.generico.GenericDao;
import dao.generico.SessionManager;

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
}
