package servicio.jugador;

import java.util.List;

import modelo.EstadoVenezuela;

public interface IServicioEstadoVenezuela {
public abstract void eliminar(EstadoVenezuela c);
	
	public abstract void agregar(EstadoVenezuela c);
		
	public abstract void actualizar(EstadoVenezuela c);	
	
	public abstract List<EstadoVenezuela> listar();
}
