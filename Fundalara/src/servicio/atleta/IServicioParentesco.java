package servicio.atleta;

import java.util.List;

import modelo.Parentesco;

public interface IServicioParentesco {
	public abstract void eliminar(Parentesco c);

	public abstract void agregar(Parentesco c);

	public abstract void actualizar(Parentesco c);

	public abstract List<Parentesco> listar();
}
