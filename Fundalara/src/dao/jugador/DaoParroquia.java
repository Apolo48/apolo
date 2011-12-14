package dao.jugador;

import java.util.List;


import modelo.Municipio;
import modelo.Parroquia;

import org.hibernate.Query;

import dao.general.GenericDAO;

public class DaoParroquia extends GenericDAO {

	public List<Parroquia> buscar (Municipio municipio){
		Query query = getSession().createSQLQuery("SELECT * FROM parroquia WHERE codigo_municipio='"+ municipio.getCodigoMunicipio()+"'").addEntity(Parroquia.class);
		return  query.list();
	}
}
