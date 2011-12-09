package servicio.atleta;

import java.util.List;

import dao.jugador.DaoTalla;

import modelo.Talla;

public class ServicioTalla implements IServicioTalla {
	DaoTalla daoTalla;
	
	public DaoTalla getDaoTalla() {
		return daoTalla;
	}

	public void setDaoTalla(DaoTalla daoTalla) {
		this.daoTalla = daoTalla;
	}

	@Override
	public void eliminar(Talla c) {
		daoTalla.eliminar(c);

	}

	@Override
	public void agregar(Talla c) {
	   daoTalla.guardar(c);

	}

	@Override
	public void actualizar(Talla c) {
		daoTalla.actualizar(c);

	}

	@Override
	public List<Talla> listar() {
		return daoTalla.listar(new Talla());
	}

}
