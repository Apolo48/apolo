package dao.general;

import java.util.List;



import modelo.DatoSocial;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.generico.GenericDao;

public class DaoDatoSocial extends GenericDao {

	
	public void guardar(List<DatoSocial> datos){
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		for (DatoSocial dato : datos) {
			session.save(dato);	
		}
		tx.commit();
	}
}
