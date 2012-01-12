package servicio.interfaz;

import java.util.List;

import modelo.PersonaNatural;

public interface IServicioPersonaNatural {

	public abstract void eliminar(PersonaNatural a);

	public abstract void agregar(PersonaNatural a);

	public abstract void actualizar(PersonaNatural a);

	public abstract List<PersonaNatural> listar();
}
