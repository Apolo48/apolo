package dao.general;

import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Competencia;
import modelo.Equipo;
import modelo.Familiar;
import modelo.Jugador;
import modelo.FamiliarJugador;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;

public class DaoFamiliarJugador extends GenericDao {
	
	public List<FamiliarJugador> buscarFamiliarJugador(Jugador jugador){
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session
				.createCriteria(FamiliarJugador.class)
				.add(Restrictions.eq("jugador", jugador))
				.add(Restrictions.eq("estatus", 'A'));
		List<FamiliarJugador> lista =  c.list();
		return lista;
	}
	
	public FamiliarJugador buscar(Familiar familiar){
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		FamiliarJugador elemento= new FamiliarJugador();
		Criteria c = session
				.createCriteria(FamiliarJugador.class)
				.add(Restrictions.eq("familiar", familiar))
				.add(Restrictions.eq("estatus", 'A'));
		List<FamiliarJugador> lista =  c.list();
		
		if(lista.size()>=1){
			elemento=lista.get(0);
		}
		return elemento;
	}

}
