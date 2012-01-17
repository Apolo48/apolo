package dao.general;

import java.util.ArrayList;
import java.util.List;

import modelo.DatoBasico;
import modelo.FamiliarComisionEquipo;
import modelo.FamiliarJugador;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;

public class DaoFamiliarComisionEquipo extends GenericDao {
	
	public List<DatoBasico> buscarFamiliarComisionEquipo(FamiliarJugador familiarJugador){
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session
				.createCriteria(FamiliarComisionEquipo.class)
				.add(Restrictions.eq("familiarJugador", familiarJugador))
				.add(Restrictions.eq("estatus", 'A'));
		List<FamiliarComisionEquipo> lista =  c.list();

		List<DatoBasico> listta = new ArrayList<DatoBasico>();
		for (int a=0; a<lista.size();a++){
			listta.add(lista.get(a).getComisionEquipo().getDatoBasico());
		}
		return listta;
	}

}
