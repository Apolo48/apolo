package servicio.atleta;

import java.util.List;

import dao.atleta.DaoMunicipio;

import modelo.Cliente;
import modelo.Municipio;

public class ServicioMunicipio implements IServicioMunicipio {
    DaoMunicipio daoMunicipio;
    @Override
	
	public void eliminar(Municipio c) {

		// TODO Auto-generated method stub
	daoMunicipio.eliminar(c);	

	}

	@Override
	public void agregar(Municipio c) {
		// TODO Auto-generated method stub
           daoMunicipio.guardar(c);
	}

	@Override
	public void actualizar(Municipio c) {
		// TODO Auto-generated method stub
		daoMunicipio.actualizar(c);

	}

	@Override
	public List<Municipio> listar() {
		// TODO Auto-generated method stub
		return (List<Municipio>) daoMunicipio.listar(new Municipio());
	}

}
