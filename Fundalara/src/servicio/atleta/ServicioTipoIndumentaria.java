package servicio.atleta;

import java.util.List;

import dao.jugador.DaoTipoIndumentaria;

import modelo.TipoIndumentaria;

public class ServicioTipoIndumentaria implements IServicioTipoIndumentaria {
	DaoTipoIndumentaria daoTipoIndumentaria;
	
	public DaoTipoIndumentaria getDaoTipoIndumentaria() {
		return daoTipoIndumentaria;
	}

	public void setDaoTipoIndumentaria(DaoTipoIndumentaria daoTipoIndumentaria) {
		this.daoTipoIndumentaria = daoTipoIndumentaria;
	}

	@Override
	public void eliminar(TipoIndumentaria c) {
		daoTipoIndumentaria.eliminar(c);

	}

	@Override
	public void agregar(TipoIndumentaria c) {
		daoTipoIndumentaria.guardar(c);

	}

	@Override
	public void actualizar(TipoIndumentaria c) {
		daoTipoIndumentaria.actualizar(c);

	}

	@Override
	public List<TipoIndumentaria> listar() {
		return daoTipoIndumentaria.listar(new TipoIndumentaria());
	}

}
