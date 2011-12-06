package servicio.atleta;

import dao.atleta.DaoTipoActividadSocial;
import modelo.TipoActividadSocial;

public class ServicioTipoActividadSocial implements
		IServicioTipoActividadSocial {

	
	DaoTipoActividadSocial daoTipoActividadSocial;
	
	public DaoTipoActividadSocial getDaoActividadSocial() {
		return daoTipoActividadSocial;
	}

	public void setDaoP(DaoTipoActividadSocial daoTipoActividadSocial) {
		this.daoTipoActividadSocial = daoTipoActividadSocial;
	}
	
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
