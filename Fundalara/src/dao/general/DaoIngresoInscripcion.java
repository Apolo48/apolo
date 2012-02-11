package dao.general;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;
import modelo.IngresoInscripcion;

public class DaoIngresoInscripcion extends GenericDao {
         public List<IngresoInscripcion> listarPorTipoInscripcion(int i){      	 
        			// TODO Auto-generated method stub
        			Session session = getSession();
        			Transaction tx =  session.beginTransaction();
        			Criteria c = getSession().createCriteria(IngresoInscripcion.class);
        			c.add(Restrictions.eq("datoBasico.codigoDatoBasico", i));
        			c.add(Restrictions.eq("estatus", "A"));
        			return c.list();      		
         }
}

