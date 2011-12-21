package dao.general;

import java.util.List;

import modelo.DatoBasico;
import modelo.Institucion;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;
import dao.generico.SessionManager;

public class DaoInstitucion extends GenericDao {
	 
	public Institucion buscar (String id){
		Session session = SessionManager.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Institucion.class);
		c.add(Restrictions.eq("codigoInstitucion", id));
		List list = c.list();
		if (list.size() > 0){
			return (Institucion) list.get(0);
		}
		else {
			return null;
		}
	}
	
	public List<Institucion> buscarInstitucionTipo(DatoBasico datoBasico){
		Session session = SessionManager.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("SELECT * FROM institucion WHERE codigo_tipo_institucion="+ datoBasico.getCodigoDatoBasico()+" AND estatus='A'").addEntity(Institucion.class);
		List<Institucion> lista = query.list(); 
		tx.commit();
		return  lista;
	}
	
}
