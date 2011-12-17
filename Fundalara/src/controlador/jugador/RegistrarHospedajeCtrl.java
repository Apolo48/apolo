package controlador.jugador;

import java.util.List;

import modelo.Curso;
import modelo.Competencia;
import modelo.Hospedaje;
import modelo.HospedajeJugador;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import servicio.jugador.ServicioCurso;

import comun.FileLoader;
import comun.Rutas;
import comun.Util;

/**
 * Clase controladora de los eventos de la vista de igual nombre y manejo de los
 * servicios de datos para el registro de hospedaje
 * 
 * @author Edgar L
 * @author Erika O
 * @version 0.2 16/12/2011
 * 
 * */

public class RegistrarHospedajeCtrl extends GenericForwardComposer {

	private Window winRegistrarHospedaje;

	//Datos de la Competencia
	private Combobox cmbCompetencia;
	private Datebox dtboxFechaIni;
	private Datebox dtboxFechaFin;
	private Textbox txtLugar;
	//private ServicioCurso servicioCurso;
	
	//Datos del Representate
	private Combobox cmbCedulaRep;
	private Intbox txtCedulaRep;
	private Button btnCatalogoRepresentante;
	private Textbox txtNombreRep;
	private Textbox txtApellidoRep;
	private Textbox txtDireccionRep;

	//Botones
	private Button btnAgregar;
	private Button btnQuitar;
	private Button btnGuardar;
	private Button btnCancelar;
	private Button btnSalir;

	private AnnotateDataBinder binder;
	private String rutasJug= Rutas.JUGADOR.getRutaVista();

	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false); // Hacemos visible el
														// modelo para el
														// databinder
	}

	//Set y Get
		
	public Combobox getCmbCompetencia() {
		return cmbCompetencia;
	}

	public void setCmbCompetencia(Combobox cmbCompetencia) {
		this.cmbCompetencia = cmbCompetencia;
	}

	public Datebox getDtboxFechaIni() {
		return dtboxFechaIni;
	}

	public void setDtboxFechaIni(Datebox dtboxFechaIni) {
		this.dtboxFechaIni = dtboxFechaIni;
	}

	public Datebox getDtboxFechaFin() {
		return dtboxFechaFin;
	}

	public void setDtboxFechaFin(Datebox dtboxFechaFin) {
		this.dtboxFechaFin = dtboxFechaFin;
	}

	public Textbox getTxtLugar() {
		return txtLugar;
	}

	public void setTxtLugar(Textbox txtLugar) {
		this.txtLugar = txtLugar;
	}

	public Combobox getCmbCedulaRep() {
		return cmbCedulaRep;
	}

	public void setCmbCedulaRep(Combobox cmbCedulaRep) {
		this.cmbCedulaRep = cmbCedulaRep;
	}

	public Intbox getTxtCedulaRep() {
		return txtCedulaRep;
	}

	public void setTxtCedulaRep(Intbox txtCedulaRep) {
		this.txtCedulaRep = txtCedulaRep;
	}

	public Textbox getTxtNombreRep() {
		return txtNombreRep;
	}

	public void setTxtNombreRep(Textbox txtNombreRep) {
		this.txtNombreRep = txtNombreRep;
	}

	public Textbox getTxtApellidoRep() {
		return txtApellidoRep;
	}

	public void setTxtApellidoRep(Textbox txtApellidoRep) {
		this.txtApellidoRep = txtApellidoRep;
	}

	public Textbox getTxtDireccionRep() {
		return txtDireccionRep;
	}

	public void setTxtDireccionRep(Textbox txtDireccionRep) {
		this.txtDireccionRep = txtDireccionRep;
	}

	
	//Metodos
	
	public void onCreate$win(ForwardEvent event){
		 binder = (AnnotateDataBinder) event.getTarget().getVariable("binder", false);  
	}
	
	public void onClick$btnCatalogoRepresentante() {
		new Util().crearVentana(rutasJug+"buscarRepresentante.zul", null, null);
	}

	/*public List<Curso> getCursos() {
		return servicioCurso.listar();
	}*/

	public void onClick$btnAgregar() {

	}

	public void onClick$btnQuitar() {

	}

	public void onClick$btnGuardar() {
		
	}

	public void onClick$btnCancelar() {

	}

	public void onClick$btnSalir() {

		winRegistrarHospedaje.detach();
	}

}
