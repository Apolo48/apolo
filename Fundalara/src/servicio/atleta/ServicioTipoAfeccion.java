package servicio.atleta;

import java.util.List;

import dao.jugador.DaoTipoAfeccion;

import modelo.TipoAfeccion;

public class ServicioTipoAfeccion implements IServicioTipoAfeccion {
	DaoTipoAfeccion daoTipoAfeccion;
	
	public DaoTipoAfeccion getDaoTipoAfeccion() {
		return daoTipoAfeccion;
	}

	public void setDaoTipoAfeccion(DaoTipoAfeccion daoTipoAfeccion) {
		this.daoTipoAfeccion = daoTipoAfeccion;
	}

	@Override
	public void eliminar(TipoAfeccion c) {
		daoTipoAfeccion.eliminar(c);

	}

	@Override
	public void agregar(TipoAfeccion c) {
		daoTipoAfeccion.guardar(c);

	}

	@Override
	public void actualizar(TipoAfeccion c) {
		daoTipoAfeccion.actualizar(c);

	}

	@Override
	public List<TipoAfeccion> listar() {
		return daoTipoAfeccion.listar(new TipoAfeccion());
	}

}
