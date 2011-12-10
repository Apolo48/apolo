package servicio.jugador;

import java.util.List;

import modelo.TipoInstitucion;

public interface IServicioTipoInstitucion {
	public abstract void eliminar(TipoInstitucion c);
	
	public abstract void agregar(TipoInstitucion c);
		
	public abstract void actualizar(TipoInstitucion c);	
	
	public abstract List<TipoInstitucion> listar();
} 
