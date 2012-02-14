package dao.general;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import modelo.Equipo;
import modelo.Horario;
import modelo.HorarioPlanTemporada;
import modelo.PlanTemporada;
import dao.generico.GenericDao;

public class DaoHorarioPlanTemporada extends GenericDao {

	/**
	 * FROM COMPETENCIA
	 * */
	public List<HorarioPlanTemporada> buscarPorEquipo(Equipo equipo) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Criteria cri = session.createCriteria(HorarioPlanTemporada.class);
		cri.add(Restrictions.eq("equipo", equipo));
		cri.add(Restrictions.eq("estatus", 'A'));
		return cri.list();
	}
	
}