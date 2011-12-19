package servicio.jugador;

import java.util.List;

import comun.TipoDatoBasico;

import dao.jugador.DaoAfeccionJugador;
import dao.jugador.DaoDatoBasico;
import dao.jugador.DaoRecaudoPorProceso;
import modelo.AfeccionJugador;
import modelo.DatoBasico;
import modelo.RecaudoPorProceso;

public class ServicioRecaudoPorProceso implements IServicioRecaudoPorProceso {

	DaoRecaudoPorProceso daoRecaudoPorProceso;
	
	public DaoRecaudoPorProceso getDaoRecaudoPorProceso() {
		return daoRecaudoPorProceso;
	}

	public void setDaoRecaudoPorProceso(DaoRecaudoPorProceso daoRecaudoPorProceso) {
		this.daoRecaudoPorProceso = daoRecaudoPorProceso;
	}

	@Override
	public void eliminar(RecaudoPorProceso c) {
		// TODO Auto-generated method stub
	}

	@Override
	public void agregar(RecaudoPorProceso c) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actualizar(RecaudoPorProceso c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecaudoPorProceso> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecaudoPorProceso> buscarPorProceso(DatoBasico proceso,
			TipoDatoBasico tipoDocumento) {
		return daoRecaudoPorProceso.buscarPorProceso(proceso, tipoDocumento);
		
	}

	
	
}
