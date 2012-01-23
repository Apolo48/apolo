package servicio.interfaz;

import java.util.List;

import modelo.Familiar;

public interface IServicioFamiliar {
	public abstract void eliminar(Familiar c);
	
	public abstract void agregar(Familiar c);
		
	public abstract void actualizar(Familiar c);	
	
	public abstract List<Familiar> listar();
	
	public abstract List<Familiar> filtrar(int num,String filtro1,String filtro2,String filtro3);
}
