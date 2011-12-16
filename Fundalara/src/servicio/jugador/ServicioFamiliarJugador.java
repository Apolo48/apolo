package servicio.jugador;

import java.util.List;

import dao.jugador.DaoFamiliarJugador;
import modelo.FamiliarJugador;

public class ServicioFamiliarJugador implements IServicioFamiliarJugador {

	DaoFamiliarJugador daofamiliarJugador;
	
	public DaoFamiliarJugador getDaofamiliarJugador() {
		return daofamiliarJugador;
	}

	public void setDaofamiliarJugador(DaoFamiliarJugador daofamiliarJugador) {
		this.daofamiliarJugador = daofamiliarJugador;
	}

	@Override
	public void eliminar(FamiliarJugador c) {
		daofamiliarJugador.eliminar(c);

	}

	@Override
	public void agregar(FamiliarJugador c) {
		daofamiliarJugador.guardar(c);

	}

	@Override
	public void actualizar(FamiliarJugador c) {
		daofamiliarJugador.actualizar(c);

	}

	@Override
	public List<FamiliarJugador> listar() {
		return daofamiliarJugador.listar( FamiliarJugador.class);
	}

}
