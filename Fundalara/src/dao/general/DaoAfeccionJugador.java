package dao.general;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.AfeccionJugador;

import dao.generico.GenericDao;

public class DaoAfeccionJugador extends GenericDao {

	public void guardar(List<AfeccionJugador> afecciones){
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		for (AfeccionJugador afeccionJugador : afecciones) {
			session.save(afeccionJugador);	
		}
		tx.commit();
	}

}
