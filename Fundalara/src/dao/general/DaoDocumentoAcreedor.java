package dao.general;

import java.util.List;

import dao.generico.GenericDao;
import modelo.DatoBasico;
import modelo.DocumentoAcreedor;
import modelo.Persona;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
public class DaoDocumentoAcreedor extends GenericDao {
	public List <DocumentoAcreedor> buscarPendientesPorRif(Persona td) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		Criteria c = getSession().createCriteria(DocumentoAcreedor.class);
		c.add(Restrictions.eq("personaByCedulaRif", td));
		c.add(Restrictions.eq("estatus", "A"));
		return c.list();
	}
	
	
	public List <DocumentoAcreedor> buscarPendientesPorRifAtleta(Persona td) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		Criteria c = getSession().createCriteria(DocumentoAcreedor.class);
		c.add(Restrictions.eq("personaByCedulaAtleta", td));
		c.add(Restrictions.eq("estatus", "A"));
		return c.list();
	}
	

}
