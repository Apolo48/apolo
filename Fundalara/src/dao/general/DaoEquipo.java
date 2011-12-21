package dao.general;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import modelo.Categoria;
import modelo.Equipo;


import dao.generico.GenericDao;
import dao.generico.SessionManager;

/**
 * @author Robert A
 * @author German L
 *
 */
public class DaoEquipo extends GenericDao {
	public List<Equipo> buscarEquiposPorCategoria(Categoria categoria){
		Session session = SessionManager.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session
				.createCriteria(Equipo.class)
				.add(Restrictions.eq("categoria", categoria))
				.add(Restrictions.eq("estatus", 'A'));
		List<Equipo> lista =  c.list();
		return lista;
	}

}
