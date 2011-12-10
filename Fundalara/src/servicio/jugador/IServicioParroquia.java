package servicio.jugador;

import java.util.List;

import modelo.Parroquia;

public interface IServicioParroquia {
public abstract void eliminar(Parroquia c);
	
	public abstract void agregar(Parroquia c);
		
	public abstract void actualizar(Parroquia c);
	
	public abstract List<Parroquia> listar();
	


}
