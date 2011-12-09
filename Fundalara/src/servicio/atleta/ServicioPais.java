package servicio.atleta;

import java.util.List;

import dao.jugador.DaoPais;

import modelo.Curso;
import modelo.Pais;

public class ServicioPais implements IServicioPais {
    
	DaoPais daoPais;
	
	public DaoPais getDaoPais() {
		return daoPais;
	}

	public void setDaoPais(DaoPais daoPais) {
		this.daoPais = daoPais;
	}

	@Override
	public void eliminar(Pais c) {
		daoPais.eliminar(c);

	}

	@Override
	public void agregar(Pais c) {
		daoPais.guardar(c);

	}

	@Override
	public void actualizar(Pais c) {
		daoPais.actualizar(c);

	}

	@Override
	public List<Pais> listar() {
		return daoPais.listar(new Pais());
		 
	}

}
