package dao.general;

import java.util.List;

import modelo.Institucion;
import modelo.DatoBasico;
import modelo.LapsoDeportivo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;
import org.hibernate.Query;
import dao.generico.SessionManager;


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
	
	public List<LapsoDeportivo> listarActivos(){
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(LapsoDeportivo.class);
		c.add(Restrictions.eq("estatus",'A'));
		return c.list();
	}
	

	/**
	 * Busca un lapso deportivo basado en su identificador
	 * 
	 * @param id código del lapso deportivo
	 * @return Institucion asociada al id o null en caso de no existir
	 */

	public LapsoDeportivo buscar(String id) {
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(LapsoDeportivo.class);
		c.add(Restrictions.eq("codigoLapsoDeportivo", id));
		List list = c.list();
		if (list.size() > 0) {
			return (LapsoDeportivo) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Busca todas los lapsos deportivos de un tipo dado
	 * 
	 * @param datoBasico
	 *            tipo de lapso deportivo
	 * @return List de lapsos deportivos del tipo especificado
	 */
	public List<LapsoDeportivo> buscarLapsoDeportivoTipo(DatoBasico datoBasico) {
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query query = session
				.createSQLQuery(
						"SELECT * FROM lapso_deportivo WHERE tipo_lapso="
						+ datoBasico.getCodigoDatoBasico()
						+ " AND estatus='A'").addEntity(LapsoDeportivo.class);		
		List<LapsoDeportivo> lista = query.list();
		tx.commit();
		return lista;
	}
	
	
}
