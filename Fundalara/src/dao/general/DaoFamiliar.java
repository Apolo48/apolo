package dao.general;

import java.util.List;

import modelo.Familiar;
import modelo.PersonaNatural;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;

public class DaoFamiliar extends GenericDao {
	
	public List<Familiar> cargarlista(String filtro1,String filtro2,String filtro3){
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		
		Criteria c = session.createCriteria(Familiar.class)
				.add(Restrictions.like("cedulaRif", filtro1+"%"))
				.createCriteria("personaNatural")
				.add(Restrictions.like("primerNombre", filtro2+"%"))
				.add(Restrictions.like("primerApellido", filtro3+"%"));
		List<Familiar> lista= c.list();
		
		return lista;
	}

}
