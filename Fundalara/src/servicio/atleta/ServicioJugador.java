package servicio.atleta;

import java.util.List;
import dao.atleta.DaoJugador;
import modelo.Jugador;

public class ServicioJugador implements IServicioJugador {
    
	DaoJugador daoJugador;
	
	@Override
	public void eliminar(Jugador c) {
		daoJugador.eliminar(c);

	}

	@Override
	public void agregar(Jugador c) {
		daoJugador.guardar(c);

	}

	@Override
	public void actualizar(Jugador c) {
		daoJugador.actualizar(c);

	}

	@Override
	public List<Jugador> listar() {
		return daoJugador.listar(new Jugador());
	}

}
