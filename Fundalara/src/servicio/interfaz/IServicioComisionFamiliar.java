package servicio.interfaz;

import java.util.List;

import modelo.ComisionFamiliar;
import modelo.DatoBasico;
import modelo.Familiar;

public interface IServicioComisionFamiliar {
	public abstract void eliminar(ComisionFamiliar c);

	public abstract void agregar(ComisionFamiliar c);

	public abstract void actualizar(ComisionFamiliar c);

	public abstract List<ComisionFamiliar> listar();

	public abstract void agregar(List<ComisionFamiliar> comisiones);
	
	public abstract List<DatoBasico> buscarComisiones(Familiar familiar);
}
