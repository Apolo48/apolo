package servicio.jugador;

import java.util.List;

import modelo.CodigoCelular;

public interface IServicioCodigoCelular {
public abstract void eliminar(CodigoCelular c);
	
	public abstract void agregar(CodigoCelular c);
		
	public abstract void actualizar(CodigoCelular c);	
	
	public abstract List<CodigoCelular> listar();
}
