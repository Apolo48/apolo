package servicio.atleta;

import java.util.List;

import modelo.Talla;

public interface IServicioTalla {
	public abstract void eliminar(Talla c);

	public abstract void agregar(Talla c);

	public abstract void actualizar(Talla c);

	public abstract List<Talla> listar();
}
