package servicio.interfaz;

import java.util.List;

import modelo.DatoBasico;
import modelo.Familiar;
import modelo.FamiliarJugador;
import modelo.Jugador;

public interface IServicioFamiliarJugador {
	public abstract void eliminar(FamiliarJugador c);
	
	public abstract void agregar(FamiliarJugador c);
		
	public abstract void actualizar(FamiliarJugador c);	
	
	public abstract List<FamiliarJugador> listar();
	
	public abstract List<FamiliarJugador> buscarFamiliarJugador(Jugador jugador);

	public abstract FamiliarJugador buscarFamiliar(Familiar familiar);
	
	public abstract DatoBasico buscarParentesco(Familiar familiar, String cedulaJugador);
}
