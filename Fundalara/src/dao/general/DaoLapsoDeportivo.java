package dao.general;

import java.util.List;

import modelo.DatoBasico;
import modelo.LapsoDeportivo;
import dao.generico.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Clase de acceso y manejo de los datos relacionados a las instituciones
 * 
 * @author Edgar
 * @author Greisy
 * @author Alberto
 * @author Aimee
 * @author Glendy
 * @version 0.1 16/01/2012
 * 
 */
public class DaoLapsoDeportivo extends GenericDao {

	/**
	 * Busca todas las temporadas disponibles dado el tipo de lapso deportivo
	 * @param db: Es el dato basico del tipo de lapso deportivo 
	 * @return lista de los lapsos deportivos disponibles al momento 
	 */
	public List<LapsoDeportivo> buscarPorTipoLapso(DatoBasico db){		
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		Criteria where =  getSession().createCriteria(LapsoDeportivo.class);
		where.add(Restrictions.eq("datoBasico", db));
		where.add(Restrictions.eq("estatus", 'A'));
		return where.list();
	}

}