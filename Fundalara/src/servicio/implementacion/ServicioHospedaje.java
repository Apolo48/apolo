package servicio.implementacion;

import java.util.List;

import servicio.interfaz.IServicioHospedaje;

import dao.general.DaoHospedaje;

import modelo.Competencia;
import modelo.FamiliarJugador;
import modelo.Hospedaje;


public class ServicioHospedaje implements IServicioHospedaje {

	DaoHospedaje daoHospedaje;
	
	public DaoHospedaje getDaoHospedaje() {
		return daoHospedaje;
	}

	public void setDaoHospedaje(DaoHospedaje daoHospedaje) {
		this.daoHospedaje = daoHospedaje;
	}

	@Override
	public void eliminar(Hospedaje c) {
		daoHospedaje.eliminar(c);
	}

	@Override
	public void agregar(Hospedaje c, Competencia cm, FamiliarJugador fj) {
		daoHospedaje.guardar(c, cm, fj);

	}

	@Override
	public void actualizar(Hospedaje c) {
		daoHospedaje.actualizar(c);

	}

	@Override
	public List<Hospedaje> listar() {
		return daoHospedaje.listar(Hospedaje.class);
	}
	

}
