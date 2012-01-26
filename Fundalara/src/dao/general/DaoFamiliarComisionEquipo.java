package dao.general;

import java.util.ArrayList;
import java.util.List;

import modelo.DatoBasico;
import modelo.Equipo;
import modelo.Familiar;
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
	
	
 public void guardar(Familiar familiar, Equipo equipo, List<DatoBasico> comisiones){
	 
	 
 }	

}
