package dao.general;


import java.util.List;



public class GenericDAO extends  BaseHibernateDAO{

	public void guardar(Object c) {
		
		getSession().saveOrUpdate(c);
		getSession().flush();
		getSession().close();
	}

	public void actualizar(Object c) {
		getSession().saveOrUpdate(c);
		getSession().flush();
	}
	
	public void eliminar(Object c) {
		getSession().delete(c);
		getSession().flush();

	}
	
	public List listar(Object o) {
		return getSession().createCriteria(o.getClass()).list();
	}
}