package servicio.atleta;

import java.util.List;

import dao.jugador.DaoParentesco;

import modelo.Curso;
import modelo.Parentesco;

public class ServicioParentesco implements IServicioParentesco {

	DaoParentesco daoParentesco;
	
	public DaoParentesco getDaoParentesco() {
		return daoParentesco;
	}

	public void setDaoParentesco(DaoParentesco daoParentesco) {
		this.daoParentesco = daoParentesco;
	}

	@Override
	public void eliminar(Parentesco c) {
		daoParentesco.eliminar(c);

	}

	@Override
	public void agregar(Parentesco c) {
		daoParentesco.guardar(c);

	}

	@Override
	public void actualizar(Parentesco c) {
		daoParentesco.actualizar(c);

	}

	@Override
	public List<Parentesco> listar() {
		return daoParentesco.listar(new Parentesco()); 
	}

}
