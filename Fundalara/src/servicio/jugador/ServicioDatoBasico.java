package servicio.jugador;

import java.util.List;

import comun.TipoDatoBasico;

import dao.jugador.DaoDatoBasico;

import modelo.DatoBasico;

public class ServicioDatoBasico implements IServicioDatoBasico {

	DaoDatoBasico daoDatoBasico;

	public DaoDatoBasico getDaoDatoBasico() {
		return daoDatoBasico;
	}

	public void setDaoDatoBasico(DaoDatoBasico daoDatoBasico) {
		this.daoDatoBasico = daoDatoBasico;
	}

	@Override
	public void eliminar(DatoBasico c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregar(DatoBasico c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(DatoBasico c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DatoBasico> listar(TipoDatoBasico tipoDato) {
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
	
}
