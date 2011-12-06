package servicio;

import java.util.List;

import dao.CursoDAO;
import modelo.Curso;

public class ServicioCurso implements IServicioCurso {

	CursoDAO cursoDAO;
	
	public CursoDAO getCursoDAO() {
		return cursoDAO;
	}

	public void setCursoDAO(CursoDAO cursoDAO) {
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
