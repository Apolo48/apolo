package servicio.jugador;

import java.util.List;

import dao.jugador.DaoTipoInstitucion;
import modelo.TipoInstitucion;

public class ServicioTipoInstitucion implements IServicioTipoInstitucion {

	DaoTipoInstitucion daoTipoInstitucion;
	
	public DaoTipoInstitucion getDaoTipoInstitucion() {
		return daoTipoInstitucion;
	}

	public void setDaoTipoInstitucion(DaoTipoInstitucion daoTipoInstitucion) {
		this.daoTipoInstitucion = daoTipoInstitucion;
	}

	@Override
	public void eliminar(TipoInstitucion c) {
		daoTipoInstitucion.eliminar(c);

	}

	@Override
	public void agregar(TipoInstitucion c) {
		daoTipoInstitucion.guardar(c);

	}

	@Override
	public void actualizar(TipoInstitucion c) {
		daoTipoInstitucion.actualizar(c);

	}

	@Override
	public List<TipoInstitucion> listar() {
		return daoTipoInstitucion.listar(new TipoInstitucion());
		 
	}

}
