package servicio.atleta;

import dao.jugador.DaoTipoActividadSocial;
import modelo.TipoActividadSocial;

public class ServicioTipoActividadSocial implements
		IServicioTipoActividadSocial {

	
	DaoTipoActividadSocial daoTipoActividadSocial;
	
			
	@Override
	public void eliminar(TipoActividadSocial c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregar(TipoActividadSocial c) {
		daoTipoActividadSocial.guardar(c);

	}

	@Override
	public void actualizar(TipoActividadSocial c) {
		// TODO Auto-generated method stub

	}

	public DaoTipoActividadSocial getDaoTipoActividadSocial() {
		return daoTipoActividadSocial;
	}

	public void setDaoTipoActividadSocial(
			DaoTipoActividadSocial daoTipoActividadSocial) {
		this.daoTipoActividadSocial = daoTipoActividadSocial;
	}

}
