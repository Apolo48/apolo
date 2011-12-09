package servicio.atleta;

import java.util.List;

import modelo.TipoIndumentaria;

public interface IServicioTipoIndumentaria {
	public abstract void eliminar(TipoIndumentaria c);

	public abstract void agregar(TipoIndumentaria c);

	public abstract void actualizar(TipoIndumentaria c);

	public abstract List<TipoIndumentaria> listar();
}
