package servicio.atleta;

import java.util.List;

import modelo.ClasificacionEquipo;

public interface IServicioClasificacionEquipo {
	public abstract void eliminar(ClasificacionEquipo c);

	public abstract void agregar(ClasificacionEquipo c);

	public abstract void actualizar(ClasificacionEquipo c);

	public abstract List<ClasificacionEquipo> listar();
}
