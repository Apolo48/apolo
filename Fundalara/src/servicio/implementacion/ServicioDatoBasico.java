package servicio.implementacion;

import java.util.List;

import comun.TipoDatoBasico;

import servicio.interfaz.IServicioDatoBasico;

import dao.general.DaoDatoBasico;

import modelo.DatoBasico;
import modelo.TipoDato;

public class ServicioDatoBasico implements IServicioDatoBasico {
	DaoDatoBasico daoDatoBasico;
	
	public DaoDatoBasico getDaoDatoBasico() {
		return daoDatoBasico;
	}

	public void setDaoDatoBasico(DaoDatoBasico daoDatoBasico) {
		this.daoDatoBasico = daoDatoBasico;
	}
	
	@Override
	public void eliminar(DatoBasico d) {
		
	}

	@Override
	public void agregar(DatoBasico d) {
		daoDatoBasico.guardar(d);

	}

	@Override
	public void actualizar(DatoBasico d) {
		daoDatoBasico.actualizar(d);
	}

	@Override
	public List<DatoBasico> listar() {
		return daoDatoBasico.listar(DatoBasico.class);
	}
	

	@Override
	public List<DatoBasico> buscarPorTipoDato(TipoDato td) {
		// TODO Auto-generated method stub
		return daoDatoBasico.buscarPorTipoDato(td);
	}

	@Override
	public DatoBasico buscarPorCodigo(String td) {
		// TODO Auto-generated method stub
		return daoDatoBasico.buscarPorCodigo(td);
	}
	
	@Override
	public List<DatoBasico> buscar(TipoDatoBasico tipoDato) {
		return daoDatoBasico.buscar(tipoDato);
	}

	@Override
	public List<DatoBasico> buscarDatosPorRelacion(DatoBasico datoBasico) {
		return daoDatoBasico.buscarPorRelacion(datoBasico);
	}
	
	@Override
	public DatoBasico buscarTipo(TipoDatoBasico tipoDato, String nombre) {
		return daoDatoBasico.buscarTipo(tipoDato, nombre);
	}
	
	@Override
	public DatoBasico buscarDatosPorRelacion(DatoBasico datoBasico,
			String nombre) {
		return daoDatoBasico.buscarPorRelacion(datoBasico, nombre);
	}
	
	
}
