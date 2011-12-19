package dao.jugador;

import java.util.List;

import modelo.TipoDato;

import org.hibernate.Query;
import org.hibernate.Session;

import comun.TipoDatoBasico;

import dao.general.GenericDAO;
import dao.general.SessionManager;

/**
 * Clase DAO para acceso/manejo de los tipos de datos basicos  
 * @author Robert A.
 * @author German L.
 * @version 0.1 18/12/2011
 *
 */

public class DaoTipoDato extends GenericDAO {

	/**
	 * Busca el tipo de dato completo segun su tipo(código)
	 * @param tipoDato tipo de dato básico
	 * @return Objeto de TipoDato, en caso de no encontrar retorna null
	 */
	public TipoDato buscarPorCodigo(TipoDatoBasico tipoDato) {
		TipoDato tipo;
		Session session = SessionManager.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query query = getSession().createSQLQuery(
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
