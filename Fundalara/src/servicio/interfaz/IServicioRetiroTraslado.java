package servicio.interfaz;

import java.util.List;

import modelo.RetiroTraslado;

public interface IServicioRetiroTraslado {
	
	public abstract void eliminar(RetiroTraslado c);

	public abstract void agregar(RetiroTraslado c);

	public abstract void actualizar(RetiroTraslado c);
	
	public abstract int contarfilas(RetiroTraslado r, int operacion);

	public abstract List<RetiroTraslado> listar();
}
