package servicio.atleta;

import java.util.List;

import dao.jugador.DaoCodigoArea;
import modelo.CodigoArea;

public class ServicioCodigoArea implements IServicioCodigoArea {
   
	DaoCodigoArea daoCodigoArea;
	
	public DaoCodigoArea getDaoCodigoArea() {
		return daoCodigoArea;
	}

	public void setDaoCodigoArea(DaoCodigoArea daoCodigoArea) {
		this.daoCodigoArea = daoCodigoArea;
	}

	@Override
	public void eliminar(CodigoArea c) {
		daoCodigoArea.eliminar(c);

	}

	@Override
	public void agregar(CodigoArea c) {
		daoCodigoArea.guardar(c);

	}

	@Override
	public void actualizar(CodigoArea c) {
		daoCodigoArea.actualizar(c);

	}

	@Override
	public List<CodigoArea> listar() {
		return daoCodigoArea.listar(new CodigoArea());
	}

}
