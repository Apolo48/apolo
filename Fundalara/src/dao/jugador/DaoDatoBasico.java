package dao.jugador;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import dao.general.SessionManager;
import comun.TipoDatoBasico;
import dao.general.GenericDAO;
import modelo.DatoBasico;
public class DaoDatoBasico extends GenericDAO {

	public List<DatoBasico> buscar ( TipoDatoBasico tipoDato){
		 Session session = SessionManager.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
		Query query = getSession().createSQLQuery("SELECT * FROM dato_basico WHERE codigo_tipo_dato='"+ tipoDato.getCodigo()+"'").addEntity(DatoBasico.class);
		List<DatoBasico> lista = query.list(); 
		tx.commit();  
		return  lista;
	}
	
}
