package dao.general;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import modelo.ComisionFamiliar;
import modelo.Familiar;

import dao.generico.GenericDao;

public class DaoComisionFamiliar extends GenericDao {

	public void guardar(List<ComisionFamiliar> comisionesFamiliares) {

		List<ComisionFamiliar> comisionesAlmacenadasPorFamiliar = null;
		Familiar familiar = null;
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		for (ComisionFamiliar comisionFamiliar : comisionesFamiliares) {
			if ((familiar == null ? true : !familiar.getCedulaRif().equals(
					comisionFamiliar.getFamiliarJugador().getFamiliar()
							.getCedulaRif()))) {
				if (familiar != null) {
					// condicion  de tamaaño
					for (ComisionFamiliar comisionNoEnviadas : comisionesAlmacenadasPorFamiliar) {
						comisionNoEnviadas.setEstatus('E');
						super.actualizar(comisionNoEnviadas);
					}
				}
				Criteria c = session.createCriteria(ComisionFamiliar.class)
				.createCriteria("familiarJugador")
				.add(Restrictions.eq("familiar", comisionFamiliar
						.getFamiliarJugador().getFamiliar()))
				.add(Restrictions.eq("estatus", 'A'));
				comisionesAlmacenadasPorFamiliar = c.list();
			} 

			if (comisionFamiliar.getDatoBasico() != null) {
				
				System.out.println("Imprimiendo  la tira sql");
				Criteria c2 = session.createCriteria(ComisionFamiliar.class)
				.createCriteria("familiarJugador")
				.add(Restrictions.eq("familiar", comisionFamiliar
						.getFamiliarJugador().getFamiliar()))
				.add(Restrictions.eq("estatus", 'A'))
				.createCriteria("datoBasico")
				.add(Restrictions.eq("codigoDatoBasico", comisionFamiliar
						.getDatoBasico().getCodigoDatoBasico()));
				ComisionFamiliar comisionAlmacenadaPorFamiliar = (ComisionFamiliar) c2
						.uniqueResult();
				System.out.println(" FIN Imprimiendo  la tira sql");
				if (comisionAlmacenadaPorFamiliar == null) {
					comisionFamiliar.setEstatus('A');
					super.guardar(comisionFamiliar);
				} else {
					depurarLista(comisionesAlmacenadasPorFamiliar,
							comisionAlmacenadaPorFamiliar);
					if (comisionAlmacenadaPorFamiliar.getEstatus() == 'E') {
						comisionAlmacenadaPorFamiliar.setEstatus('A');
					}
					super.actualizar(comisionAlmacenadaPorFamiliar);
				}
			}
			familiar = comisionFamiliar.getFamiliarJugador().getFamiliar();
		}
		for (ComisionFamiliar comisionNoEnviadas : comisionesAlmacenadasPorFamiliar) {
			comisionNoEnviadas.setEstatus('E');
			session.update(comisionNoEnviadas);
		}
		//tx.commit();
	}

	private void depurarLista(List<ComisionFamiliar> lista,
			ComisionFamiliar comisionRemover) {
		System.out.println("antes "+lista.size());
		lista.remove(comisionRemover);
		System.out.println("despues "+lista.size());
	}
}
