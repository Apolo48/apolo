package servicio.jugador;

import java.util.List;

import dao.jugador.DaoAfeccionJugador;
import modelo.AfeccionJugador;

public class ServicioAfeccionJugador implements IServicioAfeccionJugador {

	DaoAfeccionJugador daoAfeccionJugador;
	
	public DaoAfeccionJugador getDaoAfeccionJugador() {
		return daoAfeccionJugador;
	}

	public void setDaoAfeccionJugador(DaoAfeccionJugador daoAfeccionJugador) {
		this.daoAfeccionJugador = daoAfeccionJugador;
	}

	@Override
	public void eliminar(AfeccionJugador c) {
		daoAfeccionJugador.eliminar(c);

	}

	@Override
	public void agregar(AfeccionJugador c) {
		daoAfeccionJugador.guardar(c);

	}

	@Override
	public void actualizar(AfeccionJugador c) {
		daoAfeccionJugador.actualizar(c);

	}

	@Override
	public List<AfeccionJugador> listar() {
		return daoAfeccionJugador.listar( AfeccionJugador.class);
	}

}
