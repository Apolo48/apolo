package servicio;

import java.util.List;

import dao.DaoCurso;
import modelo.Curso;

public class ServicioCurso implements IServicioCurso {

	DaoCurso cursoDAO;
	
	public DaoCurso getCursoDAO() {
		return cursoDAO;
	}

	public void setCursoDAO(DaoCurso cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	@Override
	public void eliminar(Curso c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregar(Curso c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Curso c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Curso> buscar() {
		return cursoDAO.listar( new Curso());
	}
	
	
}
