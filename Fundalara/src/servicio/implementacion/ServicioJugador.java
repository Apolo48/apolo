package servicio.implementacion;

import java.util.List;

import servicio.interfaz.IServicioJugador;

import dao.general.DaoJugador;
import dao.general.DaoPersona;
import dao.general.DaoPersonaNatural;
import modelo.Jugador;
import modelo.PersonaNatural;

public class ServicioJugador implements IServicioJugador {
    
	DaoJugador daoJugador;
	
	public DaoJugador getDaoJugador() {
		return daoJugador;
	}

	public void setDaoJugador(DaoJugador daoJugador) {
		this.daoJugador = daoJugador;
	}

	@Override
	public void eliminar(Jugador c) {
		daoJugador.eliminar(c);

	}

	@Override
	public void agregar(Jugador c) {
		DaoPersona daoPersona = new DaoPersona();
		DaoPersonaNatural daoPersonaNatural = new DaoPersonaNatural();
		daoPersonaNatural.guardar(c.getPersona().getPersonaNatural());
		daoPersona.guardar(c.getPersona());
		daoJugador.guardar(c);

	}

	@Override
	public void actualizar(Jugador c) {
		daoJugador.actualizar(c);

	}

	@Override
	public List<Jugador> listar() {
		return daoJugador.listar( Jugador.class);
	}

}
