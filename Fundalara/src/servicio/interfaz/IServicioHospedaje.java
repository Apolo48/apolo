package servicio.interfaz;

import java.util.List;

import modelo.Competencia;
import modelo.FamiliarJugador;
import modelo.Hospedaje;
import modelo.Representante;

public interface IServicioHospedaje {

	public abstract void eliminar(Hospedaje c);

	public abstract void agregar(Hospedaje c);

	public abstract void actualizar(Hospedaje c);

	public abstract List<Hospedaje> listar();

	public abstract List<Hospedaje> listarrepre(FamiliarJugador familiarJugador);

	public boolean verificar(Competencia competencia,
			FamiliarJugador familiarJugador);

	public abstract Hospedaje activar(Competencia competencia,
			FamiliarJugador familiarJugador);

}
