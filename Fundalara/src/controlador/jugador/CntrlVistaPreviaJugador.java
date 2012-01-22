package controlador.jugador;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Label;



public class CntrlVistaPreviaJugador extends GenericForwardComposer {

	private controlador.jugador.bean.Jugador jugador ;
	private AnnotateDataBinder binder;
	private Component vista;
	private Label lblCedula;
	private Label lblTelefonoHabitacion;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		vista=comp;
	}


	public void onCreate$winVistaPreviaJugador(){
		jugador = (controlador.jugador.bean.Jugador )vista.getVariable("jugadorBean",false); 
		//forma 1
		lblCedula.setValue(jugador.getCedulaCompleta());
		//forma 2
		binder.loadComponent(lblTelefonoHabitacion);
	}
	public controlador.jugador.bean.Jugador getJugador() {
		return jugador;
	}


	public void setJugadorBean(controlador.jugador.bean.Jugador jugadorBean) {
		this.jugador = jugadorBean;
	}
	
	
	
}
