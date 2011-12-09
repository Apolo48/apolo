package servicio.atleta;

import java.util.List;

import dao.jugador.DaoClasificacionEquipo;

import modelo.ClasificacionEquipo;

public class ServicioClasificacionEquipo implements
		IServicioClasificacionEquipo {
	
	DaoClasificacionEquipo daoClasificacionEquipo;

	public DaoClasificacionEquipo getDaoClasificacionEquipo() {
		return daoClasificacionEquipo;
	}

	public void setDaoClasificacionEquipo(
			DaoClasificacionEquipo daoClasificacionEquipo) {
		this.daoClasificacionEquipo = daoClasificacionEquipo;
	}

	@Override
	public void eliminar(ClasificacionEquipo c) {
		daoClasificacionEquipo.eliminar(c);

	}

	@Override
	public void agregar(ClasificacionEquipo c) {
		daoClasificacionEquipo.guardar(c);

	}

	@Override
	public void actualizar(ClasificacionEquipo c) {
		daoClasificacionEquipo.actualizar(c);

	}

	@Override
	public List<ClasificacionEquipo> listar() {
		return daoClasificacionEquipo.listar(new ClasificacionEquipo());
	}

}
