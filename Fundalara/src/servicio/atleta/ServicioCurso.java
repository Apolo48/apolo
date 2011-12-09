package servicio.atleta;

import java.util.List;

import dao.jugador.DaoCurso;
import modelo.Curso;

public class ServicioCurso implements IServicioCurso {

	 DaoCurso daoCurso; 
	 
	public DaoCurso getDaoCurso() {
		return daoCurso;
	}

	public void setDaoCurso(DaoCurso daoCurso) {
		this.daoCurso = daoCurso;
	}

	@Override
	public void eliminar(Curso c) {
		daoCurso.eliminar(c);

	}

	@Override
	public void agregar(Curso c) {
		daoCurso.guardar(c);

	}

	@Override
	public void actualizar(Curso c) {
		daoCurso.actualizar(c);

	}

	@Override
	public List<Curso> listar() {
		return daoCurso.listar(new Curso()); 
	}

}
