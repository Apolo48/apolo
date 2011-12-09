package servicio.atleta;

import java.util.List;

import modelo.Pais;

public interface IServicioPais {
	public abstract void eliminar(Pais c);

	public abstract void agregar(Pais c);

	public abstract void actualizar(Pais c);

	public abstract List<Pais> listar();
}
