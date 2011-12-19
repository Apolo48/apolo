package servicio.logistica;

import java.util.List;

import dao.logistica.DaoComisionEquipo;

import modelo.ComisionEquipo;

public class ServicioComisionEquipo implements IServicioComisionEquipo {

	DaoComisionEquipo daoComisionEquipo;
	
	public DaoComisionEquipo getDaoComisionEquipo() {
		return daoComisionEquipo;
	}

	public void setDaoComisionEquipo(DaoComisionEquipo daoComisionEquipo) {
		this.daoComisionEquipo = daoComisionEquipo;
	}

	@Override
	public void eliminar(ComisionEquipo c) {
		daoComisionEquipo.eliminar(c);

	}

	@Override
	public void agregar(ComisionEquipo c) {
		daoComisionEquipo.guardar(c);

	}

	@Override
	public void actualizar(ComisionEquipo c) {
		daoComisionEquipo.actualizar(c);

	}

	@Override
	public List<ComisionEquipo> listar() {
		return daoComisionEquipo.listar( ComisionEquipo.class);
	}

}
