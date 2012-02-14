package servicio.implementacion;

import java.util.List;

import dao.general.DaoDesempennoIndividual;

import modelo.DatoBasico;
import modelo.DesempennoIndividual;
import modelo.Roster;
import servicio.interfaz.IServicioDesempennoIndividual;

public class ServicioDesempennoIndividual implements
		IServicioDesempennoIndividual {
	
	DaoDesempennoIndividual daoDesempennoIndividual; 

	public DaoDesempennoIndividual getDaoDesempennoIndividual() {
		return daoDesempennoIndividual;
	}

	public void setDaoDesempennoIndividual(
			DaoDesempennoIndividual daoDesempennoIndividual) {
		this.daoDesempennoIndividual = daoDesempennoIndividual;
	}

	@Override
	public void eliminar(DesempennoIndividual d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregar(DesempennoIndividual d) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DesempennoIndividual> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DesempennoIndividual> listarActivos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**ESTE ES!*/
	@Override
	public List<Object> calcularDesempenno(DatoBasico datoBasico,Roster r){
		return daoDesempennoIndividual.calcularDesempenno(datoBasico, r);
	}

}
