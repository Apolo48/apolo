package servicio.implementacion;

import java.util.List;

import dao.general.DaoPlanVacacional;

import modelo.PlanVacacional;

public class ServicioPlanVacacional implements IServicioPlanVacacional {

	DaoPlanVacacional daoPlanVacacional;
	
	public DaoPlanVacacional getDaoPlanVacacional() {
		return daoPlanVacacional;
	}

	public void setDaoPlanVacacional(DaoPlanVacacional daoPlanVacacional) {
		this.daoPlanVacacional = daoPlanVacacional;
	}

	@Override
	public void eliminar(PlanVacacional c) {
		daoPlanVacacional.eliminar(c);

	}

	@Override
	public void agregar(PlanVacacional c) {
		daoPlanVacacional.guardar(c);

	}

	@Override
	public void actualizar(PlanVacacional c) {
		daoPlanVacacional.actualizar(c);

	}

	@Override
	public List<PlanVacacional> listar() {
		return daoPlanVacacional.listar(PlanVacacional.class); 
	}

}
