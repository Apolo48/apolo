package servicio.interfaz;

import java.util.List;

import comun.TipoDatoBasico;

import modelo.DatoBasico;
import modelo.TipoDato;

public interface IServicioDatoBasico {
	
	public abstract void eliminar(DatoBasico d);
	
	public abstract void agregar(DatoBasico d);
		
	public abstract void actualizar(DatoBasico d);	
	
	public abstract List<DatoBasico> listar();	
	
	public abstract List<DatoBasico> buscarPorTipoDato(TipoDato td);
	
	public abstract DatoBasico buscarPorCodigo(String td);
	
	public abstract List<DatoBasico> buscar( TipoDatoBasico tipoDato);
	
	public abstract List<DatoBasico> buscarDatosPorRelacion (DatoBasico datoBasico);
	
	public abstract DatoBasico buscarTipo( TipoDatoBasico tipoDato, String nombre);
	
	public abstract DatoBasico buscarDatosPorRelacion (DatoBasico datoBasico, String nombre);

}
