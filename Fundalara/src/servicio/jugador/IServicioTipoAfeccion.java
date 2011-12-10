package servicio.jugador;

import java.util.List;

import modelo.TipoAfeccion;

public interface IServicioTipoAfeccion {
	public abstract void eliminar(TipoAfeccion c);

	public abstract void agregar(TipoAfeccion c);

	public abstract void actualizar(TipoAfeccion c);

	public abstract List<TipoAfeccion> listar();
}
