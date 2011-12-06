package servicio;

import java.util.List;
import modelo.Curso; 

public interface IServicioCurso {
	
	public abstract void eliminar(Curso c);
	
	public abstract void agregar(Curso c);
		
	public abstract void actualizar(Curso c);
	
	public abstract List<Curso> buscar ();
}