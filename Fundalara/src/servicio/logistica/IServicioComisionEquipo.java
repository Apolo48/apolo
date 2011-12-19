package servicio.logistica;

import java.util.List;

import modelo.ComisionEquipo;

public interface IServicioComisionEquipo {
	
	public abstract void eliminar(ComisionEquipo c);

	public abstract void agregar(ComisionEquipo c);

	public abstract void actualizar(ComisionEquipo c);

	public abstract List<ComisionEquipo> listar();
}
