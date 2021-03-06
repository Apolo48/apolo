package dao.general;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import modelo.ComisionFamiliar;
import modelo.DatoBasico;
import modelo.Familiar;

import dao.generico.GenericDao;

/**
 * Clase DAO para acceso/manejo de las comisiones de un familiar
 * 
 * @author Robert A.
 * @author German L.
 * @version 0.1 30/01/2012
 * 
 */
public class DaoComisionFamiliar extends GenericDao {

	/**
	 * Guarda/actualiza las comisiones de la lista de familiares , en caso de
	 * enviar comision null, se interpretara como un familiar sin comisiones
	 * 
	 * @param comisionesFamiliares
	 *            lista de comisiones de los familiares
	 */
	public void guardar(List<ComisionFamiliar> comisionesFamiliares) {

		List<ComisionFamiliar> comisionesAlmacenadasPorFamiliar = new ArrayList<ComisionFamiliar>();
		Familiar familiar = null;
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		for (ComisionFamiliar comisionFamiliar : comisionesFamiliares) {
			if ((familiar == null ? true : !familiar.getCedulaRif().equals(
					comisionFamiliar.getFamiliarJugador().getFamiliar()
							.getCedulaRif()))) {
				if (familiar != null) {
					for (ComisionFamiliar comisionNoEnviadas : comisionesAlmacenadasPorFamiliar) {
						comisionNoEnviadas.setEstatus('E');
						session.update(comisionNoEnviadas);
					}
				}
				Criteria c = session
						.createCriteria(ComisionFamiliar.class)
						.createCriteria("familiarJugador")
						.add(Restrictions.eq("familiar", comisionFamiliar
								.getFamiliarJugador().getFamiliar()))
						.add(Restrictions.eq("estatus", 'A'));
				comisionesAlmacenadasPorFamiliar = c.list();
			}

			if (comisionFamiliar.getDatoBasico() != null) {
				String cedula = comisionFamiliar.getFamiliarJugador()
						.getFamiliar().getCedulaRif();
				int codigoComision = comisionFamiliar.getDatoBasico()
						.getCodigoDatoBasico();
				Query query = session
						.createSQLQuery(
								"SELECT cf.codigo_comision_familiar, cf.codigo_familiar_jugador,  cf.codigo_comision, cf.estatus FROM comision_familiar cf, familiar_jugador fj WHERE  cf.codigo_familiar_jugador=fj.codigo_familiar_jugador  AND fj.cedula_familiar='"
										+ cedula
										+ "' AND fj.estatus='A' AND cf.codigo_comision="
										+ codigoComision + "").addEntity(
								ComisionFamiliar.class);
				ComisionFamiliar comisionAlmacenadaPorFamiliar = (ComisionFamiliar) query
						.uniqueResult();

				if (comisionAlmacenadaPorFamiliar == null) {

					comisionFamiliar.setEstatus('A');
					session.save(comisionFamiliar);
				} else {
					depurarLista(comisionesAlmacenadasPorFamiliar,
							comisionAlmacenadaPorFamiliar);
					if (comisionAlmacenadaPorFamiliar.getEstatus() == 'E') {
						comisionAlmacenadaPorFamiliar.setEstatus('A');
					}
					session.update(comisionAlmacenadaPorFamiliar);
				}
			}
			familiar = comisionFamiliar.getFamiliarJugador().getFamiliar();
		}
		for (ComisionFamiliar comisionNoEnviadas : comisionesAlmacenadasPorFamiliar) {
			comisionNoEnviadas.setEstatus('E');
			session.update(comisionNoEnviadas);
		}
		tx.commit();
	}

	/**
	 * Elimina las comisiones que ya han sido actualizadas de la lista auxiliar
	 * 
	 * @param lista
	 * @param comisionRemover
	 */
	private void depurarLista(List<ComisionFamiliar> lista,
			ComisionFamiliar comisionRemover) {
		lista.remove(comisionRemover);
	}

	public List<DatoBasico> buscarComisiones(Familiar familiar) {
		List<DatoBasico> lista = new ArrayList<DatoBasico>();
		List<ComisionFamiliar> comisionesAlmacenadasPorFamiliar = new ArrayList<ComisionFamiliar>();
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();

		Criteria c = session.createCriteria(ComisionFamiliar.class)
				.add(Restrictions.eq("estatus", 'A'))
				.createCriteria("familiarJugador")
				.add(Restrictions.eq("familiar", familiar))
				.add(Restrictions.eq("estatus", 'A'));
		comisionesAlmacenadasPorFamiliar = c.list();
		for (ComisionFamiliar comisionFamiliar : comisionesAlmacenadasPorFamiliar) {
			lista.add(comisionFamiliar.getDatoBasico());
		}
		tx.commit();
		return lista;
	}
}
