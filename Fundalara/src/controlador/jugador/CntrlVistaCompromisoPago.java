package controlador.jugador;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;


/**
 * Clase controladora de los eventos de la vista de igual nombre 
 * @author Robert A
 * @author German L
 * @version 0.1 22/01/2012
 * 
 * */
public class CntrlVistaCompromisoPago  extends GenericForwardComposer{

	private Window winvistaCompromisoPago;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	
	}

	public void onClick$btnAceptar(){
		winvistaCompromisoPago.detach();
	}
}
