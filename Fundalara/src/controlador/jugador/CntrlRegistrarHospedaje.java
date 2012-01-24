package controlador.jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Competencia;
import modelo.Familiar;
import modelo.FamiliarJugador;
import modelo.Hospedaje;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import servicio.implementacion.ServicioCompetencia;
import servicio.implementacion.ServicioFamiliar;
import servicio.implementacion.ServicioFamiliarJugador;
import servicio.implementacion.ServicioHospedaje;
import comun.Mensaje;
import comun.Ruta;
import comun.Util;

/**
 * Clase controladora de los eventos de la vista de igual nombre y manejo de los
 * servicios de datos para el registro de hospedaje
 * 
 * @author Erika O
 * @version 0.3 12/01/2012
 * 
 * */

public class CntrlRegistrarHospedaje extends GenericForwardComposer {

	private Window winRegistrarHospedaje;

	//Datos de la Competencia
	private Combobox cmbCompetencia;
	private Datebox dtboxFechaIni;
	private Datebox dtboxFechaFin;
	private Textbox txtEstado;
	private String rutasJug= Ruta.JUGADOR.getRutaVista();
	
	//Datos del Representate
	//private Combobox cmbCedulaRep;
	private Textbox txtCedulaRep;
	private Textbox txtNombreRep;
	private Textbox txtApellidoRep;
	private Textbox txtDireccionRep;
	private Listbox listHospedaje;

	//Botones
	private Button btnCatalogoRep;
	private Button btnAgregar;
	private Button btnQuitar;
	private Button btnGuardar;
	private Button btnCancelar;
	private Button btnSalir;
	
	//Variables
	//boolean sw = true;
	char estatus;
	boolean ok = true;
	
	//Catalogo
	private Component formulario;
	
	//Binder
	private AnnotateDataBinder binder;
	
	//Servicios
	private ServicioCompetencia servicioCompetencia;
	private ServicioHospedaje servicioHospedaje;
	private ServicioFamiliar servicioFamiliar;
	private ServicioFamiliarJugador servicioFamiliarJugador;
	
	//Modelo
	private Competencia competencia = new Competencia();
	private Familiar familiar = new Familiar();
	private List<Competencia> listCompetencias = new ArrayList<Competencia>();
	private List<Hospedaje> hospedajes = new ArrayList<Hospedaje>();
	private Hospedaje hospedaje = new Hospedaje();
	private FamiliarJugador familiarJugador = new FamiliarJugador();
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false); // Hacemos visible el modelo para el databinder
		formulario = comp;//se guarda la referencia al formulario actual
	}
	
	//Getters & Setters
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
	
	public Textbox getTxtEstado() {
		return txtEstado;
	}
	
	public void setTxtLugar(Textbox txtEstado) {
		this.txtEstado = txtEstado;
	}
	
	public Textbox getTxtCedulaRep() {
		return txtCedulaRep;
	}
	
	public void setTxtCedulaRep(Textbox txtCedulaRep) {
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
	
	public Competencia getCompetencia() {
		return competencia;
	}
	
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	
	//Método para el llenado de combo
	public List<Competencia> getCompetencias() {
		return servicioCompetencia.listar();
	}
	
	//Eventos
	/*Compara si la informacion seleccionada en el combo es igual a la lista de competencia, para traer de 
	la BD los datos requeridos para mostrar en la vista*/
	
	public void onChange$cmbCompetencia(){	
		competencia = (Competencia) cmbCompetencia.getSelectedItem().getValue();
		binder.loadComponent(dtboxFechaIni);
		binder.loadComponent(dtboxFechaFin);
		binder.loadComponent(txtEstado);//ERRROR EN ESTADO. VERIFICAR AUN GENERA ERROR A VECES
	}
			
	public void onClick$btnCatalogoRep() {
		int esta=1;
		Component catalogo = Executions.createComponents("/Jugador/Vistas/frmBuscarFamiliar.zul", null, null);
		//asigna una referencia del formulario al catalogo.
		catalogo.setVariable("formulario",formulario, false);
		catalogo.setVariable("estatus", esta, false);
		formulario.addEventListener("onCatalogoBuscarFamiliarCerrado", new EventListener() {

			@Override
			// Este metodo se llama cuando se envia la señal desde el catalogo
			public void onEvent(Event arg0) throws Exception {
				// se obtiene el familiar
				familiar = (Familiar) formulario.getVariable("familiar", false);
				txtDireccionRep.setValue(familiar.getPersonaNatural().getPersona().getDireccion() + ". " 
									+familiar.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getNombre()+". "
									+familiar.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getDatoBasico().getNombre()+" - ESTADO "
									+ familiar.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getDatoBasico().getDatoBasico().getNombre());
				hospedajes=servicioHospedaje.listarrepre(servicioFamiliarJugador.buscarFamiliar(familiar));
				binder.loadComponent(listHospedaje);
				binder.loadComponent(txtCedulaRep);
				binder.loadComponent(txtNombreRep);
				binder.loadComponent(txtApellidoRep);
				binder.loadComponent(txtDireccionRep);
			}
		});
	}

	
	public void onClick$btnAgregar() {
		guardar();
	}
	
	public void onClick$btnQuitar() {
	
	}
	
	public void guardar() {
		if ((cmbCompetencia.getSelectedIndex() >= 0) && (txtCedulaRep.getValue() != "")){ 
			hospedaje.setEstatus('A');
			hospedaje.setCompetencia(competencia);
			hospedaje.setFamiliarJugador(servicioFamiliarJugador.buscarFamiliar(familiar));
			servicioHospedaje.agregar(hospedaje);
			Mensaje.mostrarMensaje("Representante asociado a Hospedaje",
					Mensaje.EXITO, Messagebox.INFORMATION);
			limpiar();
		}
	}
	
	
	public void onClick$btnCancelar() { //DEBE MEJORARSE CON UN CONDICIONAL XQ IGUAL BORRAR AL HACER CLICK EN OK
	
			Mensaje.mostrarMensaje("Borrará TODOS los datos, está seguro?",
				Mensaje.INFORMACION, Messagebox.INFORMATION);
			if (ok); {
				limpiar();
		}
	}
	
	
	public void onClick$btnSalir() { //DEBE MEJORARSE CON UN CONDICIONAL XQ IGUAL BORRAR AL HACER CLICK EN OK
		
		Mensaje.mostrarMensaje("Saldrá de la ventana, está seguro?",
				Mensaje.INFORMACION, Messagebox.INFORMATION);
		if (ok); {
			winRegistrarHospedaje.detach();
		}
	}

	//Métodos propios del Controlador
	
	// Borra los datos introducidos en la interfaz
	public void limpiar() {
		txtCedulaRep.setValue(null);
		txtNombreRep.setValue(null);
		txtApellidoRep.setValue(null);
		txtDireccionRep.setValue(null);
		btnCatalogoRep.setDisabled(false);
		cmbCompetencia.setValue(null);
		dtboxFechaIni.setValue(null);
		dtboxFechaFin.setValue(null);
		txtEstado.setValue(null);
		competencia = new Competencia();
		familiar = new Familiar();
	}
	
	// Cambia el estatus del hospedaje
	public void cambiarEstatusHospedaje() {
		hospedaje.setEstatus('E');
		servicioHospedaje.actualizar(hospedaje);
		//hospedaje = new modelo.Hospedaje();
		//binder.loadAll();
	}

	public List<Hospedaje> getHospedajes() {
		return hospedajes;
	}

	public void setHospedajes(List<Hospedaje> hospedajes) {
		this.hospedajes = hospedajes;
	}
	
}