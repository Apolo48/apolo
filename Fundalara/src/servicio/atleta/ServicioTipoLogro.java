package servicio.atleta;

import java.util.List;

import dao.jugador.DaoTipoLogro;

import modelo.TipoLogro;

public class ServicioTipoLogro implements IServicioTipoLogro {
	DaoTipoLogro daoTipoLogro;
	
	public DaoTipoLogro getDaoTipoLogro() {
		return daoTipoLogro;
	}

	public void setDaoTipoLogro(DaoTipoLogro daoTipoLogro) {
		this.daoTipoLogro = daoTipoLogro;
	}

	@Override
	public void eliminar(TipoLogro c) {
		daoTipoLogro.eliminar(c);

	}

	@Override
	public void agregar(TipoLogro c) {
		daoTipoLogro.guardar(c);

	}

	@Override
	public void actualizar(TipoLogro c) {
		daoTipoLogro.actualizar(c);

	}

	@Override
	public List<TipoLogro> listar() {
		return daoTipoLogro.listar(new TipoLogro());
	}

}
