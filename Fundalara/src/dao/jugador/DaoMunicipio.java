package dao.jugador;

import java.util.List;

import modelo.EstadoVenezuela;
import modelo.Municipio;


import org.hibernate.Query;
import org.hibernate.Session;


import dao.general.GenericDAO;
import dao.general.SessionManager;

public class DaoMunicipio extends GenericDAO {

	
	public List<Municipio> buscar (EstadoVenezuela estado){
		 Session session = SessionManager.getSession();
         org.hibernate.Transaction tx = session.beginTransaction();
		Query query = getSession().createSQLQuery("SELECT * FROM municipio WHERE codigo_estado='"+ estado.getCodigoEstado()+"'").addEntity(Municipio.class);
		List lista = query.list(); 
		tx.commit();
			
      
		return  lista;
	}
}
