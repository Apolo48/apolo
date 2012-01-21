package dao.generico;

import java.util.List;

import modelo.DatoBasico;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.YesNoType;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenericDao {
	
	 Session session;
    public void guardar(Object o) {		
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		session.saveOrUpdate(o);
		tx.commit();		
	}

	public void actualizar(Object o) {
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		session.saveOrUpdate(o);
		tx.commit();
	}
	
	public void eliminar(Object o) {
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		session.saveOrUpdate(o);
	    tx.commit();
	}
	
	public List listar(Class o) {
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		List lista = session.createCriteria(o).list();
		return lista;
	}
	
	public Session getSession(){
		if (session == null){
				return session = SessionManager.getSession();
		}else{
			  if(!session.isOpen())
			      session = SessionManager.getSession();		    
		      return session;	
			}
		}
	
	
	public Object buscarDosCampos(Class o, String c1, Object v1, String c2, Object v2) {
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		Criteria cri = session.createCriteria(o);
		cri.add(Restrictions.eq(c1, v1));
		cri.add(Restrictions.eq(c2, v2));
		Object resultado = cri.list().get(0);
	    return resultado;
	}

}

