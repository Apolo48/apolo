package controlador.jugador;

import java.util.Date;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.api.Tab;

import comun.FileLoader;
import comun.Util;


/**
 * Clase controladora de los eventos de la vista de igual nombre.
 * 
 * @author Edgar L 
 * 
 * @version 0.1 10/12/2011
 *
 * */

public class RegistrarHospedajeCtrl extends GenericForwardComposer {
	private Window registrarHospedaje;
	
	private Combobox cmbCompetencia;
	private Datebox dtboxFechaIni;
	private Datebox dtboxFechaFin;
	private Textbox txtLugar;
	
	private Combobox cmbCedulaNac;
	private Intbox txtCedula;
	private Button btnCatalogoRepresentante;
	private Textbox txtNombreR;
	private Textbox txtApellidoR;
	private Textbox txtDireccionR;
	
	private Textbox txtNombreJ;
	private Textbox txtApellidoJ;
	private Combobox cmbCategoria;
	private Textbox txtDireccionJ;
	private Grid gridJugador;
	
	private Button btnAgregar;
	private Button btnQuitar;
	private Button btnGuardar;
	private Button btnCancelar;
	private Button btnSalir;
	
	
	
	public void onClick$btnCatalogoRepresentante() {
		new Util().crearVentana("Jugador/Vistas/buscarRepresentante.zul", null, null);
	}	

	public void onClick$btnAgregar() {
		
	}	
	
	public void onClick$btnQuitar() {
		
	}
	
	public void onClick$btnGuardar() {
		
	}
	
	public void onClick$btnCancelar() {
		
	}
	
	public void onClick$btnSalir() {
		registrarHospedaje.detach();
	}
}
