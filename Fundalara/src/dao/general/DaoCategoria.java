package dao.general;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import modelo.Categoria;
import dao.generico.GenericDao;

public class DaoCategoria extends GenericDao {

	public Categoria buscarPorEdad(int edad){		
	Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session
				.createCriteria(Categoria.class)
				.add(Restrictions.le("edadInferior", edad))
				.add(Restrictions.ge("edadSuperior", edad))
				.add(Restrictions.eq("estatus", 'A'));	
		return (Categoria)c.uniqueResult();
	}
}
