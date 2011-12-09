package servicio.atleta;

import java.util.List;

import dao.jugador.DaoProfesion;

import modelo.Profesion;

public class ServicioProfesion implements IServicioProfesion {
	DaoProfesion daoProfesion;
	
	public DaoProfesion getDaoProfesion() {
		return daoProfesion;
	}

	public void setDaoProfesion(DaoProfesion daoProfesion) {
		this.daoProfesion = daoProfesion;
	}

	@Override
	public void eliminar(Profesion c) {
		daoProfesion.eliminar(c);

	}

	@Override
	public void agregar(Profesion c) {
		daoProfesion.actualizar(c);

	}

	@Override
	public void actualizar(Profesion c) {
		daoProfesion.actualizar(c);

	}

	@Override
	public List<Profesion> listar() {
		return daoProfesion.listar(new Profesion());
	}

}
