package servicio.compentencia;

import java.util.List;

import dao.compentencia.DaoDivisa;

import modelo.Divisa;

public class ServicioDivisa implements IServicioDivisa {
    
	DaoDivisa daoDivisa;
	
	public DaoDivisa getDaoDivisa() {
		return daoDivisa;
	}

	public void setDaoDivisa(DaoDivisa daoDivisa) {
		this.daoDivisa = daoDivisa;
	}

	@Override
	public void eliminar(Divisa d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregar(Divisa d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(Divisa d) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Divisa> listar() {
		// TODO Auto-generated method stub
		return daoDivisa.listar(new Divisa());
	}

}
