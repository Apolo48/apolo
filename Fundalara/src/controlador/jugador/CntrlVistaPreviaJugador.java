package controlador.jugador;

import java.io.IOException;
import java.util.Date;

import org.zkoss.image.AImage;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;

import comun.Util;

/**
 * Clase controladora de los eventos de la vista de igual nombre y manejo de los
 * servicios de datos para la inscripcion de jugadores nuevo ingreso
 * 
 * @author Robert A
 * @author German L
 * @version 0.1 22/01/2012
 * 
 * */
public class CntrlVistaPreviaJugador extends GenericForwardComposer {

	private controlador.jugador.bean.Jugador jugador;
	private AnnotateDataBinder binder;
	private Component vista;
	private Label lblCedula;
	private Label lblPrimerNombre;
	private Label lblSegundoNombre;
	private Label lblPrimerApellido;
	private Label lblSegundoApellido;
	private Label lblGenero;
	private Image imgJugador;
	private Label lblFechaNac;
	private Label lblEdad;
	private Label lblPais;
	private Label lblEstado;
	private Label lblMunicipio;
	private Label lblParroquia;
	private Label lblEstadoResi;
	private Label lblMunicipioResi;
	private Label lblParroquiaResi;
	private Label lblDireccion;
	private Label lblTelefonoHabitacion;
	private Label lblTelefonoCelular;
	private Label lblCorreo;
	private Label lblTwitter;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		vista = comp;
	}

	public void onCreate$winVistaPreviaJugador() {
		jugador = (controlador.jugador.bean.Jugador) vista.getVariable(
				"jugadorBean", false);
		mostrarValores(jugador);
	}

	private void mostrarValores(controlador.jugador.bean.Jugador jugador) {
		lblCedula.setValue(jugador.getCedulaCompleta());
		lblPrimerNombre.setValue(jugador.getPrimerNombre());
		lblSegundoNombre.setValue(jugador.getSegundoNombre());
		lblPrimerApellido.setValue(jugador.getPrimerApellido());
		lblSegundoApellido.setValue(jugador.getSegundoNombre());
		lblGenero.setValue(jugador.getGenero().getNombre());
		if (jugador.getFoto() != null) {
			try {
				AImage aImage = new AImage("foto.jpg", jugador.getFoto());
				imgJugador.setContent(aImage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		lblFechaNac.setValue(Util.convertirFecha(jugador.getFechaNacimiento(),"dd/MM/yyyy"));	
		lblEdad.setValue(String.valueOf(Util.calcularDiferenciaAnnios(jugador.getFechaNacimiento())));
		lblPais.setValue(jugador.getPaisNac().getNombre());
		// lblEstado , no lo tiene el bean
		// lblMunicipio; no lo tiene el bean
		lblParroquia.setValue(jugador.getParroquiaNac().getNombre());
		// lblEstadoResi; no lo tiene el bean
		// lblMunicipioResi; no lo tiene el bean
		lblParroquiaResi.setValue(jugador.getParroquiaResi().getNombre());
		lblDireccion.setValue(jugador.getDireccion());
		lblTelefonoHabitacion.setValue(jugador.getTelefonoHabitacion()
				.getTelefonoCompleto());
		lblTelefonoCelular.setValue(jugador.getTelefonoCelular()
				.getTelefonoCompleto());
		lblCorreo.setValue(jugador.getCorreoElectronico());
		lblTwitter.setValue(jugador.getTwitter());

	}

	public controlador.jugador.bean.Jugador getJugador() {
		return jugador;
	}

	public void setJugador(controlador.jugador.bean.Jugador jugadorBean) {
		this.jugador = jugadorBean;
	}

}
