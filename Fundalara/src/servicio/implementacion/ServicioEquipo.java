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
		return daoEquipo.listar(Equipo.class);
	}

	@Override
	public List<Equipo> buscarPorCategoria(Categoria categoria) {
		return daoEquipo.buscarEquiposPorCategoria(categoria);
	}

	@Override
	public boolean buscarPorCodigo(Equipo equipo) {
		return daoEquipo.buscarPorCodigo(equipo);
	}

	@Override
	public List<Equipo> buscarPorCategoria(Categoria categoria,
			String lapsoDeportivo) {
		return daoEquipo.buscarEquiposPorCategoria(categoria, lapsoDeportivo);
	}

	@Override
	public List<Equipo> buscarPorCategoria(Categoria categoria,
			String lapsoDeportivo, String nombreDivisa) {
		return daoEquipo.buscarEquiposPorCategoria(categoria, lapsoDeportivo,
				nombreDivisa);
	}

	public List<Equipo> buscarEquiposDisponibles(Categoria categoria,
			String lapsoDeportivo, String nombreDivisa) {
		return daoEquipo.buscarEquiposDisponibles(categoria, lapsoDeportivo,
				nombreDivisa);
	}

	public List<Equipo> buscarEquiposDisponibles(Categoria categoria) {
		return daoEquipo.buscarEquiposDisponibles(categoria);
	}

	public List<Equipo> buscarEquiposDisponibles(Categoria categoria,
			String lapsoDeportivo) {
		return daoEquipo.buscarEquiposDisponibles(categoria, lapsoDeportivo);
	}

}