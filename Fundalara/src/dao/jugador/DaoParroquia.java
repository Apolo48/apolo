package dao.jugador;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import dao.general.GenericDAO;
import dao.general.SessionManager;

public class DaoParroquia extends GenericDAO {
/*
	public List<Parroquia> buscar (Municipio municipio){
		 Session session = SessionManager.getSession();
         org.hibernate.Transaction tx = session.beginTransaction();
		Query query = getSession().createSQLQuery("SELECT * FROM parroquia WHERE codigo_municipio='"+ municipio.getCodigoMunicipio()+"'").addEntity(Parroquia.class);
		List lista = query.list(); 
		tx.commit();
	
		return  lista;
	}*/
}
