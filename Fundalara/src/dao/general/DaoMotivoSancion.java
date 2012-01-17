package dao.general;

import java.util.List;

import modelo.MotivoSancion;
import modelo.Jugador;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;

public class DaoMotivoSancion extends GenericDao {
	
	public List<MotivoSancion> buscarPorJugador(Jugador jugador) {
		Session sesion = getSession();
		Transaction tx = sesion.beginTransaction();
		Criteria c = sesion.createCriteria(MotivoSancion.class)
		.createCriteria("datoConducta")
		.add(Restrictions.eq("jugador", jugador));
		return c.list();
	}

}
