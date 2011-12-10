package servicio.jugador;

import java.util.List;

import dao.jugador.DaoDatoMedico;
import modelo.DatoMedico;

public class ServicioDatoMedico implements IServicioDatoMedico {

	DaoDatoMedico daoDatoMedico;
	
	public DaoDatoMedico getDaoDatoMedico() {
		return daoDatoMedico;
	}

	public void setDaoDatoMedico(DaoDatoMedico daoDatoMedico) {
		this.daoDatoMedico = daoDatoMedico;
	}

	@Override
	public void eliminar(DatoMedico c) {
		daoDatoMedico.eliminar(c);

	}

	@Override
	public void agregar(DatoMedico c) {
		daoDatoMedico.guardar(c);

	}

	@Override
	public void actualizar(DatoMedico c) {
		daoDatoMedico.actualizar(c);

	}

	@Override
	public List<DatoMedico> listar() {
		return daoDatoMedico.listar(new DatoMedico());
	}

}
