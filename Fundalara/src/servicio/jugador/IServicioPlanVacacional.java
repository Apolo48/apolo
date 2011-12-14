package servicio.jugador;

import java.util.List;

import modelo.PlanVacacional;


public interface IServicioPlanVacacional {
	
		public abstract void eliminar(PlanVacacional c);
			
			public abstract void agregar(PlanVacacional c);
				
			public abstract void actualizar(PlanVacacional c);	
			
			public abstract List<PlanVacacional> listar();
		}


