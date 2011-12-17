package dao.jugador;

import java.util.Date;
import java.util.List;

import modelo.Institucion;
import modelo.Roster;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dao.general.GenericDAO;

public class DaoRoster extends GenericDAO {

	
  public void buscar(String ced){
     for (Object o : getSession().createQuery("select equipo.nombre,categoria.nombre,jugador.primer_nombre,jugador.primer_apellido,jugador.fecha_nacimiento,jugador.numero from roster,equipo,categoria,jugador where roster.cedula_jugador="+ced+" and roster.estatus='A' and jugador.cedula_jugador=roster.cedula_jugador and roster.codigo_equipo = equipo.codigo_equipo and equipo.codigo_categoria=categoria.codigo_categoria").list()) {
		Object[] arr = (Object[])o;
		String equipo=(String) arr[0];
		String categoria=(String) arr[1];
		String nombre=(String) arr[2];
		String apellido=(String) arr[3];
		Date fecha=(Date) arr[4];
		Integer numero = (Integer)arr[5];
				
     }
     }
  
  public void buscarCategoria(String ced){
     for (Object o : getSession().createQuery("select categoria.nombre from categoria,roster,equipo where roster.cedula_jugador="+ced+" and roster.estatus='A' and roster.codigo_equipo=equipo.codigo_equipo and categoria.codigo_categoria > equipo.codigo_categoria").list()) {
    	 Object[] arr = (Object[])o;
 		 String categoria=(String) arr[0];

     }
}
  
}
