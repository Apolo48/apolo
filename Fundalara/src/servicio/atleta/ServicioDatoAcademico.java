package servicio.atleta;

import java.util.List;

import dao.jugador.DaoDatoAcademico;
import modelo.DatoAcademico;

public class ServicioDatoAcademico implements IServicioDatoAcademico {

	DaoDatoAcademico daoDatoAcademico;
	
	
	public DaoDatoAcademico getDaoDatoAcademico() {
		return daoDatoAcademico;
	}

	public void setDaoDatoAcademico(DaoDatoAcademico daoDatoAcademico) {
		this.daoDatoAcademico = daoDatoAcademico;
	}

	@Override
	public void eliminar(DatoAcademico c) {
		daoDatoAcademico.eliminar(c);

	}

	@Override
	public void agregar(DatoAcademico c) {
		daoDatoAcademico.guardar(c);

	}

	@Override
	public void actualizar(DatoAcademico c) {
		daoDatoAcademico.actualizar(c);

	}

	@Override
	public List<DatoAcademico> listar() {
		return daoDatoAcademico.listar(new DatoAcademico());
	}

}
