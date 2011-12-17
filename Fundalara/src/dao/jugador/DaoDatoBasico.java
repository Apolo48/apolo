package dao.jugador;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import dao.general.SessionManager;
import comun.TipoDatoBasico;
import dao.general.GenericDAO;
import modelo.DatoBasico;
/**
 * Clase DAO para acceso/manejo de los datos basicos  
 * @author Robert A.
 * @author German L.
 * @version 0.1
 *
 */
public class DaoDatoBasico extends GenericDAO {

	/**
	 * Busca los registros de un tipo de dato en particular
	 * @param tipoDato tipo de dato a buscar
	 * @return lista de los datos asociados al tipo de dato suministrado
	 * 
	 */
	public List<DatoBasico> buscar ( TipoDatoBasico tipoDato){
		 Session session = SessionManager.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
		Query query = getSession().createSQLQuery("SELECT * FROM dato_basico WHERE codigo_tipo_dato='"+ tipoDato.getCodigo()+"'").addEntity(DatoBasico.class);
		List<DatoBasico> lista = query.list(); 
		tx.commit();  
		return  lista;
	}
	
	/**
	 * Busca los datos que tiene como padre el datoBasico suministrado
	 * @param datoBasico dato del cual se desea buscar sus hijos (relacion de dependencia hacia el)
	 * @return lista de datos hijos
	 */
	public List<DatoBasico> buscarPorRelacion ( DatoBasico datoBasico){
		 Session session = SessionManager.getSession();
       org.hibernate.Transaction tx = session.beginTransaction();
		Query query = getSession().createSQLQuery("SELECT * FROM dato_basico WHERE parent_codigo_dato_basico='"+ datoBasico.getCodigoDatoBasico()+"'").addEntity(DatoBasico.class);
		List<DatoBasico> lista = query.list(); 
		tx.commit();  
		return  lista;
	}
	
}
