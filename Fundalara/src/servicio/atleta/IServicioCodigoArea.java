package servicio.atleta;

import java.util.List;

import modelo.CodigoArea;

public interface IServicioCodigoArea {
	public abstract void eliminar(CodigoArea c);
	
	public abstract void agregar(CodigoArea c);
		
	public abstract void actualizar(CodigoArea c);	
	
	public abstract List<CodigoArea> listar();
}
