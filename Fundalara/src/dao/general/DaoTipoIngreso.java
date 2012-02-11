package dao.general;

import modelo.DatoBasico;
import modelo.TipoIngreso;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;

public class DaoTipoIngreso extends GenericDao {
	
	public TipoIngreso buscarPorNombre(String td) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		Criteria c = getSession().createCriteria(DatoBasico.class);
		c.add(Restrictions.eq("nombre", td));
		if (c.list().size()==0){
			return null;
		} else {
			return (TipoIngreso) c.list().get(0);
		}
	}
	
	

}
