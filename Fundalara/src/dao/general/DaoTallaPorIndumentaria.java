package dao.general;

import modelo.DatoBasico;
import modelo.TallaPorIndumentaria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;

public class DaoTallaPorIndumentaria extends GenericDao {

	/**
	 * Obtiene una talla por indumentaria dado un datoBasico
	 * 
	 * @param datoBasico
	 *            datoBasico que representa un talla
	 * @return TallaPorIndumentaria de uniforme de entrenamiento
	 * 
	 */
	public TallaPorIndumentaria buscarPorDatoBasico(DatoBasico datoBasico) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(TallaPorIndumentaria.class);
		c.add(Restrictions.eq("datoBasicoByCodigoTalla.codigoDatoBasico", datoBasico.getCodigoDatoBasico()));
		c.add(Restrictions.eq("datoBasicoByCodigoTipoUniforme.codigoDatoBasico", 52));
		c.add(Restrictions.eq("estatus", "A"));
		TallaPorIndumentaria result = (TallaPorIndumentaria) c.uniqueResult();
		tx.commit();
		return result;
	}

}