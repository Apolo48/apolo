package servicio.jugador;

import java.util.List;

import dao.jugador.DaoMunicipio;
import modelo.EstadoVenezuela;
import modelo.Municipio;

public class ServicioMunicipio implements IServicioMunicipio {
    DaoMunicipio daoMunicipio;
    
    public DaoMunicipio getDaoMunicipio() {
		return daoMunicipio;
	}

	public void setDaoMunicipio(DaoMunicipio daoMunicipio) {
		this.daoMunicipio = daoMunicipio;
	}

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
		return (List<Municipio>) daoMunicipio.listar(new Municipio());
	}
	
	public List<Municipio> buscar(EstadoVenezuela estado) {
		return  daoMunicipio.buscar(estado);
	}

}
