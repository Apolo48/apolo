package servicio.jugador;

import java.util.List;

import dao.jugador.DaoCodigoCelular;
import modelo.CodigoCelular;

public class ServicioCodigoCelular implements IServicioCodigoCelular {

	DaoCodigoCelular daoCodigoCelular;
	
	public DaoCodigoCelular getDaoCodigoCelular() {
		return daoCodigoCelular;
	}

	public void setDaoCodigoCelular(DaoCodigoCelular daoCodigoCelular) {
		this.daoCodigoCelular = daoCodigoCelular;
	}

	@Override
	public void eliminar(CodigoCelular c) {
		daoCodigoCelular.eliminar(c);

	}

	@Override
	public void agregar(CodigoCelular c) {
		daoCodigoCelular.guardar(c);

	}

	@Override
	public void actualizar(CodigoCelular c) {
		daoCodigoCelular.actualizar(c);

	}

	@Override
	public List<CodigoCelular> listar() {
		return daoCodigoCelular.listar(CodigoCelular.class);
	}

}
