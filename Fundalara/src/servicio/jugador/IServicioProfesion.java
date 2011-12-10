package servicio.jugador;

import java.util.List;

import modelo.Profesion;

public interface IServicioProfesion {
	public abstract void eliminar(Profesion c);

	public abstract void agregar(Profesion c);

	public abstract void actualizar(Profesion c);

	public abstract List<Profesion> listar();
}
