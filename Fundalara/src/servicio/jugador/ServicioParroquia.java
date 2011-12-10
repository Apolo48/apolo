package servicio.jugador;

import java.util.List;

import dao.jugador.DaoParroquia;
import modelo.Parroquia;

public class ServicioParroquia implements IServicioParroquia {
	DaoParroquia daoParroquia;

	public DaoParroquia getDaoParroquia() {
		return daoParroquia;
	}

	public void setDaoParroquia(DaoParroquia daoParroquia) {
		this.daoParroquia = daoParroquia;
	}

	@Override
	public void eliminar(Parroquia c) {
		// TODO Auto-generated method stub
		daoParroquia.eliminar(c);

	}

	@Override
	public void agregar(Parroquia c) {
		// TODO Auto-generated method stub
		daoParroquia.guardar(c);

	}

	@Override
	public void actualizar(Parroquia c) {
		// TODO Auto-generated method stub
        daoParroquia.actualizar(c);
	}

	@Override
	public List<Parroquia> listar() {
		// TODO Auto-generated method stub
		return (List<Parroquia>) daoParroquia.listar(new Parroquia());
	}

}
