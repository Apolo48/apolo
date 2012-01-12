package dao.general;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import comun.TipoDatoBasico;

import modelo.Categoria;
import modelo.DatoBasico;
import modelo.Equipo;


import dao.generico.GenericDao;
import dao.generico.SessionManager;

/**
 * Clase de acceso y manejo de los datos relacionados a los equipos de la divisa
 * @author Robert A
 * @author German L
 * @version 0.1.3 12/01/2012
 *
 */
public class DaoEquipo extends GenericDao {
	
	/**
	 * Busca los equipos que pertenecen a una categoria dada
	 * @param categoria Categoria para filtrar los equipos 
	 * @return List<Equipo> Lista de equipos de una categoria
	 */
	public List<Equipo> buscarEquiposPorCategoria(Categoria categoria){
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		DaoDatoBasico daoDatobasico = new DaoDatoBasico();
		DatoBasico tipoLapso= daoDatobasico.buscarTipo(TipoDatoBasico.TIPO_LAPSO_DEPORTIVO,"TEMPORADA REGULAR");
		Criteria c = session
				.createCriteria(Equipo.class)
				.add(Restrictions.eq("categoria", categoria))
				.add(Restrictions.eq("datoBasicoByCodigoTipoLapso",tipoLapso))
				.add(Restrictions.eq("estatus", 'A'));
		List<Equipo> lista =  c.list();
		return lista;
		
	}
	
	/**
	 * Busca todos los equipos activos de todas las divisas
	 * @param o Class del modelo a filtrar
	 * @return List lista de equipos 
	 */
	public List listarActivos(Class o) {
		Session session = getSession();
		Transaction tx =  session.beginTransaction();
		List lista = session.createCriteria(o).add(Restrictions.eq("estatus", 'A')).list();
		return lista;
	}

}
