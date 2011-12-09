package servicio.atleta;

import java.util.List;

import dao.jugador.DaoEstadoVenezuela;
import modelo.EstadoVenezuela;

public class ServicioEstadoVenezuela implements IServicioEstadoVenezuela {
 
	DaoEstadoVenezuela daoEstadoVenezuela;
	
	public DaoEstadoVenezuela getDaoEstadoVenezuela() {
		return daoEstadoVenezuela;
	}

	public void setDaoEstadoVenezuela(DaoEstadoVenezuela daoEstadoVenezuela) {
		this.daoEstadoVenezuela = daoEstadoVenezuela;
	}

	@Override
	public void eliminar(EstadoVenezuela c) {
		daoEstadoVenezuela.eliminar(c);

	}

	@Override
	public void agregar(EstadoVenezuela c) {
		daoEstadoVenezuela.guardar(c);
	}

	@Override
	public void actualizar(EstadoVenezuela c) {
		daoEstadoVenezuela.actualizar(c);

	}

	@Override
	public List<EstadoVenezuela> listar() {
		return daoEstadoVenezuela.listar(new EstadoVenezuela());
	}

}
