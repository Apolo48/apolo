package dao.general;

import dao.generico.GenericDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import modelo.RetiroTraslado;
import modelo.DatoBasico;

public class DaoRetiroTraslado extends GenericDao {

	/**
	 * Realiza el conteo del numero de filas en una tabla de datos
	 * @param r objeto retirotraslado a ser contado
	 * @param operacion valor del tipo de operacion seleccionado
	 */
	
	public int contarfilas (RetiroTraslado r, int operacion){
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		int cantidad=0;
		Criteria criteria = session.createCriteria(RetiroTraslado.class);
				criteria.setProjection(Projections.rowCount()).
				createCriteria("datoBasicoByCodigoTipoOperacion")
				.add(Restrictions.eq("codigoDatoBasico", operacion));
		cantidad = (Integer)criteria.list().get(0); 
		tx.commit();
		return cantidad;
	}
	

}
