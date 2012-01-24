package servicio.interfaz;

import java.util.List;

import modelo.Jugador;
import modelo.PersonaNatural;

public interface IServicioJugador {
public abstract void eliminar(Jugador c);
	
	public abstract void agregar(Jugador c);
		
	public abstract void actualizar(Jugador c);	
	
	public abstract List<Jugador> listar();
	
	public abstract List<Jugador> buscarJugadores(String filtro2, String filtro3, String filtro4, String filtro1, char estatus);
}
