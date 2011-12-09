package servicio.atleta;

import java.util.List;

import dao.jugador.DaoDatoDeportivo;
import modelo.DatoDeportivo;

public class ServicioDatoDeportivo implements IServicioDatoDeportivo {

	DaoDatoDeportivo daoDatoDeportivo;
	
	public DaoDatoDeportivo getDaoDatoDeportivo() {
		return daoDatoDeportivo;
	}

	public void setDaoDatoDeportivo(DaoDatoDeportivo daoDatoDeportivo) {
		this.daoDatoDeportivo = daoDatoDeportivo;
	}

	@Override
	public void eliminar(DatoDeportivo c) {
		daoDatoDeportivo.eliminar(c);

	}

	@Override
	public void agregar(DatoDeportivo c) {
		daoDatoDeportivo.guardar(c);

	}

	@Override
	public void actualizar(DatoDeportivo c) {
		daoDatoDeportivo.actualizar(c);

	}

	@Override
	public List<DatoDeportivo> listar() {
		return daoDatoDeportivo.listar(new DatoDeportivo());
	}

}
