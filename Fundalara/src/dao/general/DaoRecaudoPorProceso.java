package dao.general;

import java.util.List;

import modelo.DatoBasico;
import modelo.RecaudoPorProceso;
import modelo.TipoDato;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import comun.TipoDatoBasico;

import dao.generico.GenericDao;
import dao.generico.SessionManager;
import dao.general.DaoTipoDato;

/**
 * Clase de acceso y manejo de los datos relacionados a los recaudos solicitados por los procesos de la gestion deportiva
 * @author Robert A
 * @author German L
 * @version 0.1 18/12/2011
 *
 */

public class DaoRecaudoPorProceso extends GenericDao {

	/**
	 * Busca los recaudos asociados a un proceso y los filtra segun el tipo de documento indicado
	 * @param proceso Tipo de proceso de la gestion
	 * @param tipoDocumento Tipo de documento (Academico, Personal,...)
	 * @return lista de recaudos solicitados 
	 */
	public List<RecaudoPorProceso> buscarPorProceso(DatoBasico proceso,
			TipoDatoBasico tipoDocumento) {

		DaoTipoDato daoTipoDato = new DaoTipoDato();
		TipoDato tipoDoc = daoTipoDato.buscarPorCodigo(tipoDocumento);
		Session session = SessionManager.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session
				.createCriteria(RecaudoPorProceso.class)
				.add(Restrictions.eq("datoBasicoByCodigoProceso", proceso))
				.setFetchMode("datoBasicoByCodigoDocumento", FetchMode.JOIN)
				.setFetchMode("datoBasicoByCodigoProceso", FetchMode.JOIN)
				.setFetchMode("datoBasicoByCodigoImportancia", FetchMode.JOIN)
				.setFetchMode("datoBasicoByCodigoDocumento.tipoDato",
						FetchMode.JOIN);
		Criteria c2 = c.createCriteria("datoBasicoByCodigoDocumento").add(
				Restrictions.eq("tipoDato", tipoDoc));
		List<RecaudoPorProceso> lista =  c2.list();
		return lista;
	}
}
