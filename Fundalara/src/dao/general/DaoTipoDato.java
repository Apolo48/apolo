package dao.general;

import java.util.List;

import modelo.TipoDato;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import comun.TipoDatoBasico;

import dao.generico.GenericDao;
import dao.generico.SessionManager;

/**
 * Clase DAO para acceso/manejo de los tipos de datos basicos  
 * @author Robert A.
 * @author German L.
 * @version 0.1 18/12/2011
 *
 */

public class DaoTipoDato extends GenericDao {
	
	public TipoDato buscarPorTipo(String tipo) {
		// TODO Auto-generated method stub
		Criteria c = getSession().createCriteria(TipoDato.class);
		c.add(Restrictions.eq("nombre", tipo));
		return (TipoDato) c.list().get(0);
	}

	/**
	 * Busca el tipo de dato completo segun su tipo(c�digo)
	 * @param tipoDato tipo de dato b�sico
	 * @return Objeto de TipoDato, en caso de no encontrar retorna null
	 */
	public TipoDato buscarPorCodigo(TipoDatoBasico tipoDato) {
		TipoDato tipo;
		Session session = SessionManager.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery(
				"SELECT * FROM tipo_dato WHERE codigo_tipo_dato='"
						+ tipoDato.getCodigo() + "'").addEntity(TipoDato.class);
		List<Object> lista = query.list();
		if (!lista.isEmpty()) {
			tipo = (TipoDato) lista.get(0);
		} else {
			tipo = null;
		}
		tx.commit();
		return tipo;
	}
}
