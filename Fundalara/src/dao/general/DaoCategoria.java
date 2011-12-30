package dao.general;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import modelo.Categoria;
import dao.generico.GenericDao;

/**
 * Clase de acceso y manejo de los datos relacionados a las categorias de los
 * jugadores
 * 
 * @author Robert A
 * @author German L
 * @version 0.1 23/12/2011
 * 
 */
public class DaoCategoria extends GenericDao {

	/**
	 * Determina la categoria a la cual pertenece la edad suministrada
	 * 
	 * @param edad
	 *            edad del jugador
	 * @return Categoria que contiene la edad suministrada, en caso de no
	 *         existir se retorna null
	 */
	public Categoria buscarPorEdad(int edad) {
		Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(Categoria.class)
				.add(Restrictions.le("edadInferior", edad))
				.add(Restrictions.ge("edadSuperior", edad))
				.add(Restrictions.eq("estatus", 'A'));
		return (Categoria) c.uniqueResult();
	}
}
