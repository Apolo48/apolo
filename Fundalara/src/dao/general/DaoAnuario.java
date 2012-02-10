package dao.general;

import java.util.Date;

import modelo.DatoBasico;
import modelo.LapsoDeportivo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.generico.GenericDao;

public class DaoAnuario extends GenericDao {
	
	public void guardar(){
		DatoBasico lapso= new DatoBasico();
		Date fecha = new Date();
		//Buscar al lapso FALTA
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(LapsoDeportivo.class)
				.add(Restrictions.eq("tipoLapso", lapso))
				.add(Restrictions.le("fechaInicio", fecha))
				.add(Restrictions.ge("fechaFin",fecha ))
				.add(Restrictions.eq("estatus", 'A'));

		tx.commit();
	}

}
