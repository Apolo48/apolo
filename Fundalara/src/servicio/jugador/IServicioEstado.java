package servicio.jugador;

import java.util.List;

import modelo.Estado;

public interface IServicioEstado {
public abstract void eliminar(Estado c);
	
	public abstract void agregar(Estado c);
		
	public abstract void actualizar(Estado c);	
	
	public abstract List<Estado> listar();
}
