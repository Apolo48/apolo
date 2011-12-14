package dao.jugador;

import java.util.List;

import modelo.EstadoVenezuela;
import modelo.Municipio;


import org.hibernate.Query;


import dao.general.GenericDAO;

public class DaoMunicipio extends GenericDAO {

	
	public List<Municipio> buscar (EstadoVenezuela estado){
		Query query = getSession().createSQLQuery("SELECT * FROM municipio WHERE codigo_estado='"+ estado.getCodigoEstado()+"'").addEntity(Municipio.class);
		return  query.list();
	}
}
