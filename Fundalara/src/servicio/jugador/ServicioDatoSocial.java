package servicio.jugador;

import java.util.List;

import dao.jugador.DaoDatoSocial;
import modelo.DatoSocial;

public class ServicioDatoSocial implements IServicioDatoSocial {

	DaoDatoSocial daoDatoSocial;
	
	public DaoDatoSocial getDaoDatoSocial() {
		return daoDatoSocial;
	}

	public void setDaoDatoSocial(DaoDatoSocial daoDatoSocial) {
		this.daoDatoSocial = daoDatoSocial;
	}

	@Override
	public void eliminar(DatoSocial c) {
		daoDatoSocial.eliminar(c);

	}

	@Override
	public void agregar(DatoSocial c) {
		daoDatoSocial.guardar(c);

	}

	@Override
	public void actualizar(DatoSocial c) {
		daoDatoSocial.actualizar(c);

	}

	@Override
	public List<DatoSocial> listar() {
    	return daoDatoSocial.listar(new DatoSocial());
	}

}
