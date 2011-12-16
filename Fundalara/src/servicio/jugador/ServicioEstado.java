package servicio.jugador;

import java.util.List;

import dao.jugador.DaoEstado;
import modelo.Estado;

public class ServicioEstado implements IServicioEstado {
	DaoEstado daoEstado;
	
	public DaoEstado getDaoEstado() {
		return daoEstado;
	}

	public void setDaoEstado(DaoEstado daoEstado) {
		this.daoEstado = daoEstado;
	}

	@Override
	public void eliminar(Estado c) {
		daoEstado.eliminar(c);
	}

	@Override
	public void agregar(Estado c) {
		daoEstado.guardar(c);

	}

	@Override
	public void actualizar(Estado c) {
		daoEstado.actualizar(c);

	}

	@Override
	public List<Estado> listar() {
		return daoEstado.listar( Estado.class);
	}

}
