package servicio.implementacion;

import java.util.List;

import dao.general.DaoComisionFamiliar;

import modelo.ComisionFamiliar;
import servicio.interfaz.IServicioComisionFamiliar;

public class ServicioComisionFamiliar implements IServicioComisionFamiliar {

	 DaoComisionFamiliar daoComisionFamiliar;
	 
	 
	public DaoComisionFamiliar getDaoComisionFamiliar() {
		return daoComisionFamiliar;
	}

	public void setDaoComisionFamiliar(DaoComisionFamiliar daoComisionFamiliar) {
		this.daoComisionFamiliar = daoComisionFamiliar;
	}

	@Override
	public void eliminar(ComisionFamiliar c) {
		daoComisionFamiliar.eliminar(c);

	}

	@Override
	public void agregar(ComisionFamiliar c) {
		daoComisionFamiliar.guardar(c);

	}

	@Override
	public void actualizar(ComisionFamiliar c) {
		daoComisionFamiliar.actualizar(c);

	}

	@Override
	public List<ComisionFamiliar> listar() {
		return daoComisionFamiliar.listar(ComisionFamiliar.class);
	}
	
	@Override
	public void agregar(List<ComisionFamiliar> comisiones) {
		daoComisionFamiliar.guardar(comisiones);
	}

}
