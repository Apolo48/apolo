package servicio.atleta;

import java.util.List;

import modelo.TipoLogro;

public interface IServicioTipoLogro {
	public abstract void eliminar(TipoLogro c);

	public abstract void agregar(TipoLogro c);

	public abstract void actualizar(TipoLogro c);

	public abstract List<TipoLogro> listar();
}
