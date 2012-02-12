package servicio.interfaz;

import java.util.List;

import modelo.JugadorPlan;
import modelo.RepresentanteJugadorPlan;

public interface IServicioRepresentanteJugadorPlan {
	public abstract void eliminar(RepresentanteJugadorPlan a);

	public abstract void agregar(RepresentanteJugadorPlan a);

	public abstract void actualizar(RepresentanteJugadorPlan a);

	public abstract List<RepresentanteJugadorPlan> listar();
	
	public abstract List<RepresentanteJugadorPlan> buscarRepresentanteJugador(JugadorPlan jugadorPlan);
}
