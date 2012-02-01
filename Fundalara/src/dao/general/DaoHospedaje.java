package dao.general;

//import java.util.List;

import java.util.List;

import modelo.Competencia;
import modelo.FamiliarJugador;
import modelo.Hospedaje;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;

/**
 * Clase de acceso y manejo de los datos relacionados al Hospedaje
 * 
 * @author Erika O
 * @version 0.3 27-01-12
 * 
 */

public class DaoHospedaje extends GenericDao {

	/**
	 * Guarda los datos del hospedaje en la entidad correspondiente que lo
	 * conforma
	 * 
	 * @param c
	 *            Objeto Hospedaje a ser guardado
	 */
	public void guardar(Hospedaje c) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		//session.save(c.getCompetencia().getCodigoCompetencia());
		//session.save(c.getFamiliarJugador().getCodigoFamiliarJugador());
		session.save(c);
		tx.commit();
	}

	/**
	 * Actualiza los datos del hospedaje en las entidades correspondientes que lo conforman
	 * @param h Objeto Hospedaje a ser actualizado 
	 *
	 */
	
	public void actualizar(Hospedaje h) {
		Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Hospedaje.class)
				.add(Restrictions.eq("hospedaje", h))
				.add(Restrictions.eq("estatus", 'A'));
		
		Competencia competencia = (Competencia) c.uniqueResult();
		if (competencia != null) {
			competencia.setEstatus('E');
			session.saveOrUpdate(competencia);
		
		tx.commit();
		}
	}
	
	/**
	 * Método usado en Registrar Hospedaje, para listar los representantes y se pueda guardar en la grid
	 * los datos del familiarJugador necesarios
	 * 
	 * @param familiarJugador a ser listado
	 * @return
	 */
	
	public List<Hospedaje> listarrepre(FamiliarJugador familiarJugador){
		Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Hospedaje.class)
				.add(Restrictions.eq("familiarJugador", familiarJugador))
				.add(Restrictions.eq("estatus", 'A'));
		return c.list();
	}
	
}
	