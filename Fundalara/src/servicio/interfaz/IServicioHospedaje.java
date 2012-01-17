package servicio.interfaz;

import java.util.List;

import modelo.Competencia;
import modelo.FamiliarJugador;
import modelo.Hospedaje;
import modelo.Representante;

public interface IServicioHospedaje {

	public abstract void eliminar(Hospedaje c);

	//public abstract void agregar(Hospedaje c, Competencia cm, FamiliarJugador fj);
	public abstract void agregar(Hospedaje c);

	public abstract void actualizar(Hospedaje c);

	public abstract List<Hospedaje> listar();

}
