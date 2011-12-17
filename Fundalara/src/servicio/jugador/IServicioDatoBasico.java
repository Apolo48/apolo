package servicio.jugador;

import java.util.List;

import comun.TipoDatoBasico;

import modelo.DatoBasico;;

public interface IServicioDatoBasico {
public abstract void eliminar(DatoBasico c);
	
	public abstract void agregar(DatoBasico c);
		
	public abstract void actualizar(DatoBasico c);	
	
	public abstract List<DatoBasico> listar( TipoDatoBasico tipoDato);
	
	public abstract List<DatoBasico> buscarDatosPorRelacion (DatoBasico datoBasico);
}
