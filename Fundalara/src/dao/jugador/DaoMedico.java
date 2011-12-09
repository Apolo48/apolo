package dao.jugador;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import modelo.Medico;
import dao.general.GenericDAO;

public class DaoMedico extends GenericDAO {
	
	public Medico buscar (String id){
		Criteria c = getSession().createCriteria(Medico.class);
		c.add(Restrictions.eq("numeroColegio", id));
		List list = c.list();
		if (list.size() > 0){
			return (Medico) list.get(0);
		}
		else {
			return null;
		}
	}
}
