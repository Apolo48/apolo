package servicio.jugador;

import java.util.List;

import dao.jugador.DaoFamiliarComisionEquipo;
import modelo.FamiliarComisionEquipo;

public class ServicioFamiliarComisionEquipo implements
		IServicioFamiliarComisionEquipo {

	DaoFamiliarComisionEquipo daoFamiliarComisionEquipo;
	
	public DaoFamiliarComisionEquipo getDaoFamiliarComisionEquipo() {
		return daoFamiliarComisionEquipo;
	}

	public void setDaoFamiliarComisionEquipo(
			DaoFamiliarComisionEquipo daoFamiliarComisionEquipo) {
		this.daoFamiliarComisionEquipo = daoFamiliarComisionEquipo;
	}

	@Override
	public void eliminar(FamiliarComisionEquipo c) {
		daoFamiliarComisionEquipo.eliminar(c);

	}

	@Override
	public void agregar(FamiliarComisionEquipo c) {
		daoFamiliarComisionEquipo.guardar(c);

	}

	@Override
	public void actualizar(FamiliarComisionEquipo c) {
		daoFamiliarComisionEquipo.actualizar(c);

	}

	@Override
	public List<FamiliarComisionEquipo> listar() {
		return daoFamiliarComisionEquipo.listar( FamiliarComisionEquipo.class);
		
	}

}
