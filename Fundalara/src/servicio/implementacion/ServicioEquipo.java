package servicio.implementacion;

import java.util.List;

import servicio.interfaz.IServicioEquipo;

import dao.general.DaoEquipo;
import modelo.Categoria;
import modelo.Equipo;

public class ServicioEquipo implements IServicioEquipo {

	DaoEquipo daoEquipo;
		
	public DaoEquipo getDaoEquipo() {
		return daoEquipo;
	}

	public void setDaoEquipo(DaoEquipo daoEquipo) {
		this.daoEquipo = daoEquipo;
	}

	@Override
	public void eliminar(Equipo c) {
		c.setEstatus('E');
		daoEquipo.eliminar(c);

	}

	@Override
	public void agregar(Equipo c) {
		daoEquipo.guardar(c);

	}

	@Override
	public void actualizar(Equipo c) {
		daoEquipo.actualizar(c);

	}

	@Override
	public List<Equipo> listar() {
		return daoEquipo.listarActivos(Equipo.class);
				//daoEquipo.listar(Equipo.class);
	}
	
	
	
	public List<Equipo> buscarPorCategoria(Categoria categoria){
		return daoEquipo.buscarEquiposPorCategoria(categoria);
		
	}

}
