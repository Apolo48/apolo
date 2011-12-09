package dao.jugador;

import java.util.List;

import modelo.Institucion;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dao.general.GenericDAO;


public class DaoInstitucion extends GenericDAO {
	 
	public Institucion buscar (String id){
			Criteria c = getSession().createCriteria(Institucion.class);
			c.add(Restrictions.eq("codigoInstitucion", id));
			List list = c.list();
			if (list.size() > 0){
				return (Institucion) list.get(0);
			}
			else {
				return null;
			}
		}
	
}
