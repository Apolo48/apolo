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
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import servicio.implementacion.ServicioCompetencia;
import servicio.implementacion.ServicioFamiliar;
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
	
	//Catalogo
	private Component formulario;
	
	//Binder
	private AnnotateDataBinder binder;
	
	//Servicios
	private ServicioCompetencia servicioCompetencia;
	private ServicioHospedaje servicioHospedaje;
	//private ServicioFamiliar servicioFamiliar;
	
	//Modelo
	private Competencia competencia = new Competencia();
	private Familiar familiar = new Familiar();
	private List<Competencia> listCompetencias = new ArrayList<Competencia>();
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
		/*if (cmbCompetencia.getSelectedIndex() >=0) {//PARA Q SIRVE ESTA CONDICION
			for (int i = 0; i < listCompetencias.size(); i++) {
				if(listCompetencias.get(i).getNombre().equals(cmbCompetencia.getSelectedItem().getLabel())) {
				}//AKI NO REALIZA NINGUN CAMBIO
			}
		}*/
		//binder.loadAll(); // actualiza para mostrar los cambios
		binder.loadComponent(dtboxFechaIni);
		binder.loadComponent(dtboxFechaFin);
		//binder.loadComponent(txtEstado);//ERRROR EN ESTADO
	}
			
	public void onClick$btnCatalogoRep() {
		// se crea el catalogo y se llama
		Component catalogo = Executions.createComponents(
				"/Jugador/Vistas/frmBuscarFamiliar.zul", null, null);

		// asigna una referencia del formulario al catalogo.
		catalogo.setVariable("formulario", formulario, false);
		formulario.addEventListener("onCatalogoCerrado", new EventListener() {

			@Override
			// Este metodo se llama cuando se envia la señal desde el catalogo
			public void onEvent(Event arg0) throws Exception {
				// se obtiene el familiar
				familiar = (Familiar) formulario.getVariable("familiar", false);
				//VERSION VIERNES 13-01
				//txtDireccionRep.setValue(familiar.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getDatoBasico().getDatoBasico().getNombre()+" "+familiar.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getDatoBasico().getNombre()+" "+familiar.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getNombre()+" "+familiar.getPersonaNatural().getPersona().getDireccion());
				//VERSION LUNES 16-01
				//txtDireccionRep.setValue(familiar.getPersonaNatural().getPersona().getDireccion()+"."+familiar.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getNombre());
				//VERSION DE PRUEBA LUNES 16-01
				txtDireccionRep.setValue(familiar.getPersonaNatural().getPersona().getDireccion() + ". " 
									+familiar.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getNombre()+". "
									+familiar.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getDatoBasico().getNombre()+". "
									+ familiar.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getDatoBasico().getDatoBasico().getNombre());
				//binder.loadAll(); COMENTADO X ERROR DE ESTADO
				binder.loadComponent(txtCedulaRep);
				binder.loadComponent(txtNombreRep);
				binder.loadComponent(txtApellidoRep);
			}
		});
	}

	
	public void onClick$btnAgregar() {
	
	}
	
	public void onClick$btnQuitar() {
	
	}
	
	public void onClick$btnGuardar() {
		if ((cmbCompetencia.getSelectedIndex() >= 0) && (txtCedulaRep.getValue() != "")){ 
			hospedaje.setEstatus('A');
			hospedaje.setCompetencia(competencia);
			hospedaje.setFamiliarJugador(familiarJugador);
			//servicioHospedaje.agregar(hospedaje, competencia, familiarJugador);
			servicioHospedaje.agregar(hospedaje);
			Mensaje.mostrarMensaje("Representante asociado a Hospedaje",
					Mensaje.EXITO, Messagebox.INFORMATION);
			limpiar();
			binder.loadAll();
		}
	}
	
	/* CODIGO ORIGINAL ERROR  EN CONDICION
	 public void onClick$btnGuardar() {
			if (cmbCompetencia.getSelectedIndex() > 2 && txtCedulaRep.getValue() != null) 
				hospedaje.setEstatus('A');
				hospedaje.setCompetencia(competencia);
				hospedaje.setFamiliarJugador(familiarJugador);
				servicioHospedaje.agregar(hospedaje, competencia, familiarJugador);
				Mensaje.mostrarMensaje("Representante asociado a Hospedaje",
						Mensaje.EXITO, Messagebox.INFORMATION);
				limpiar();
				binder.loadAll();
				
			}
*/
	
	public void onClick$btnCancelar() {
		limpiar();
	}
	
	public void onClick$btnSalir() {
		winRegistrarHospedaje.detach();
	}

	//Métodos propios del Controlador
	
	// Borra los datos introducidos en la interfaz
	public void limpiar() {
		cmbCompetencia.setValue(null);
		dtboxFechaIni.setValue(null);
		dtboxFechaFin.setValue(null);
		txtEstado.setValue(null);
		txtCedulaRep.setValue(null);
		txtNombreRep.setValue(null);
		txtApellidoRep.setValue(null);
		txtDireccionRep.setValue(null);
		btnCatalogoRep.setDisabled(false);
	}
	
	// Cambia el estatus del hospedaje
	public void cambiarEstatusHospedaje() {
		hospedaje.setEstatus('E');
		servicioHospedaje.actualizar(hospedaje);
		//hospedaje = new modelo.Hospedaje();
		//binder.loadAll();
	}
	
}