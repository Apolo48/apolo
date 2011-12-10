package servicio.jugador;

import java.util.List;

import modelo.Municipio;

public interface IServicioMunicipio {
public abstract void eliminar(Municipio c);
	
	public abstract void agregar(Municipio c);
		
	public abstract void actualizar(Municipio c);
	
	public abstract List<Municipio> listar();
	

}
