package servicio.atleta;

import java.util.List;

import dao.atleta.DaoParroquia;

import modelo.Cliente;
import modelo.Parroquia;

public class ServicioParroquia implements IServicioParroquia {
	DaoParroquia daoParroquia;

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
