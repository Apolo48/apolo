package dao.general;

import java.util.List;

import modelo.DatoBasico;
import modelo.DesempennoIndividual;
import modelo.Roster;
import modelo.TipoDato;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.generico.GenericDao;

public class DaoDesempennoIndividual extends GenericDao {

	public List<Object> calcularDesempenno(DatoBasico datoBasico, Roster r) {
		Session session = this.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query query = session
				.createSQLQuery("SELECT distinct i.abreviatura, SUM(d.valor) FROM indicador i,desempenno_individual d, roster_competencia rc,line_up l,indicador_categoria_competencia ic"
						+ " WHERE rc.codigo_roster="
						+ r.getCodigoRoster()
						+ "AND l.codigo_roster_competencia= rc.codigo_roster_competencia "
						+ "AND i.codigo_modalidad="
						+ datoBasico.getCodigoDatoBasico()
						+ ""
						+ " AND ic.codigo_categoria= "
						+ r.getEquipo().getCategoria().getCodigoCategoria()
						+ ""
						+ "AND ic.codigo_indicador=i.codigo_indicador"
						+ " AND d.codigo_indicador_categoria_competencia=ic.codigo_indicador_categoria_competencia"
						+ " AND d.codigo_line_up= l.codigo_line_up GROUP BY i.abreviatura");
		List<Object> lista = query.list();
		tx.commit();
		return lista;
	}

}
