package controlador.jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import modelo.Ascenso;
import modelo.Categoria;
import modelo.DatoBasico;
import modelo.DocumentoAscenso;
import modelo.DocumentoAscensoId;
import modelo.DocumentoEntregado;
import modelo.FamiliarComisionEquipo;
import modelo.Jugador;
import modelo.Equipo;
import modelo.PersonaNatural;
import modelo.Persona;
import modelo.RecaudoPorProceso;
import modelo.Roster;
import modelo.FamiliarJugador;
import modelo.Familiar;

import org.zkoss.zhtml.Sup;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;

import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.api.Bandbox;
import org.zkoss.zul.Listcell;

import comun.FileLoader;
import comun.Mensaje;
import comun.Ruta;
import comun.TipoDatoBasico;
import comun.Util;

import servicio.implementacion.ServicioAscenso;
import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioDatoBasico;
import servicio.implementacion.ServicioDocumentoAscenso;
import servicio.implementacion.ServicioDocumentoEntregado;
import servicio.implementacion.ServicioEquipo;
import servicio.implementacion.ServicioJugador;
import servicio.implementacion.ServicioPersonaNatural;
import servicio.implementacion.ServicioRecaudoPorProceso;
import servicio.implementacion.ServicioRoster;
import servicio.implementacion.ServicioFamiliarJugador;
import servicio.implementacion.ServicioFamiliar;
import servicio.implementacion.ServicioPersona;
import servicio.implementacion.ServicioFamiliarComisionEquipo;

public class CntrlActualizarFamiliar extends GenericForwardComposer{


	//Servicios
	private ServicioFamiliar servicioFamiliar;
	private ServicioRoster servicioRoster;
	private ServicioJugador servicioJugador;
	private ServicioCategoria servicioCategoria;
	private ServicioEquipo servicioEquipo;
	private ServicioAscenso servicioAscenso;
	private ServicioDatoBasico servicioDatoBasico;
	private ServicioRecaudoPorProceso servicioRecaudoPorProceso;
	private ServicioDocumentoAscenso servicioDocumentoAscenso;
	private ServicioDocumentoEntregado servicioDocumentoEntregado;
	private ServicioFamiliarJugador servicioFamiliarJugador;
	private ServicioPersona servicioPersona;
	private ServicioPersonaNatural servicioPersonaNatural;
	private ServicioFamiliarComisionEquipo servicioFamiliarComisionEquipo;
	
	
	
	// Modelos
	

	private Familiar familiar = new Familiar();

	private Jugador jugador = new Jugador();

	private Roster roster = new Roster();
	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	private Ascenso ascenso= new Ascenso();
	private DatoBasico tipoAscenso = new DatoBasico();
	private DatoBasico parentesco = new DatoBasico();
	private DatoBasico profesion = new DatoBasico();
	private DatoBasico comision = new DatoBasico();
	private FamiliarComisionEquipo familiarComisionEquipo = new FamiliarComisionEquipo();
	
	private RecaudoPorProceso recaudoAscenso = new RecaudoPorProceso();
	private DocumentoEntregado docEntAscenso = new DocumentoEntregado();
	
	private Persona persona = new Persona();
	private PersonaNatural personaNatural = new PersonaNatural();
	
	Listbox listComisiones;
	List<DatoBasico> comisionesFamiliar = new ArrayList<DatoBasico>();
			
	
	
	Listbox listaFamiliar;
	private FamiliarJugador familiarJugador = new FamiliarJugador();
	List<FamiliarJugador> listaFamiliarJugador = new ArrayList<FamiliarJugador>();

	
	// Binder
	private AnnotateDataBinder binder;

	// Variables
	int edad;
	String nombres;
	String apellidos;
	String primerNombre;
	Boolean sw=false;
	
	private Textbox txtCedula;
	private Textbox txtCedulaFamiliar;
	private Textbox txtNombre;
	private Textbox txtApellido;
	private Textbox txtCategoria;
	private Textbox txtEquipo;
    private Intbox txtNumero;
	private Datebox dtboxFechaNac;
	private Image imgJugador;
	private Image imgFamiliar;
	private Window winActualizarFamiliar;
	private Combobox cmbNacionalidad;
	private Combobox cmbNacionalidadFamiliar;	
	private Combobox cmbCategoria;
	private Combobox cmbEquipo;
	private Textbox txtPrimerNombre;
	private Textbox txtSegundoNombre;
	private Textbox txtPrimerApellido;
	private Textbox txtSegundoApellido;
	private Combobox cmbParentesco;
	private Combobox cmbProfesion;
	private Combobox cmbFuncion;
	private Combobox cmbComisiones;
	private Listcell celdaRepresentante;
	private String rutasJug = Ruta.JUGADOR.getRutaVista();
	private Panel panelFamiliar;
	private Button btnEditar, btnAgregar, btnQuitar;
	
	Component formulario;
	private Map<String, Object> requestScope;
	//private Datebox dtboxFechaNac;
	/* 
	 public void onCreate$winActualizarFamiliar(ForwardEvent event) {
		    // get the databinder for later extra load and save
		    // note: binder is not ready in doAfterCompose, so do it here
		    binder = (AnnotateDataBinder) event.getTarget().getVariable("binder", false);
		  }
	 */
	
	Combobox cmbTipo, cmbEstadoResi, cmbParroquiaResi, cmbMunicipioResi, cmbCodArea, cmbCodCelular;
	Textbox txtDireccionHabitacion, txtTelefonoHabitacion, txtCorreo, txtTwitter, txtTelefonoCelular;
	
	private DatoBasico estado = new DatoBasico();
	private DatoBasico municipio = new DatoBasico();
	private DatoBasico parroquia = new DatoBasico();
	private DatoBasico codigoArea = new DatoBasico();
	private DatoBasico codigoCel = new DatoBasico();
	private DatoBasico datoBasico = new DatoBasico();
	
	
	
	 @Override
		public void doAfterCompose(Component comp) throws Exception {
			super.doAfterCompose(comp);
			comp.setVariable("controller", this, false);  //Hacemos visible el modelo para el databinder
			formulario=comp;
		//	btnEditar.setDisabled(true);
		//	btnAgregar.setDisabled(true);
		//	btnQuitar.setDisabled(true);
			
			
		}
	
		public Map<String, Object> getRequestScope() {
			return requestScope;
		}

		public void setRequestScope(Map<String, Object> requestScope) {
			this.requestScope = requestScope;
		}
		
	public void onClick$btnFotoFamiliar() {
		new FileLoader().cargarImagen(imgFamiliar);
	}
	
	
	public void onClick$btnBuscar(){
		 Component catalogo= Executions.createComponents(rutasJug +
	 "frmBuscarJugador.zul", null, null);
//		Component catalogo = Executions.createComponents(
//				"frmBuscarJugador.zul", null, null);
		catalogo.setVariable("formulario", formulario, false);
		formulario.addEventListener("onCatalogoCerrado", new EventListener() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub
				jugador = (Jugador) formulario.getVariable("jugador", false);
				sw=true;
				agregarCampos();
				roster= servicioRoster.buscarRoster(jugador.getCedulaRif());
				//listaFamiliarJugador = servicioFamiliarJugador.buscarFamiliarJugador(jugador.getCedulaRif());
				Date fechaN = jugador.getPersonaNatural()
						.getFechaNacimiento();
				edad = Util.calcularDiferenciaAnnios(fechaN);
				//System.out.println(edad);
				binder.loadAll();							
			}
		});
		  	
	  }

	public void agregarCampos() {
		String segNombre = jugador.getPersonaNatural()
				.getSegundoNombre();
		nombres = jugador.getPersonaNatural().getPrimerNombre()
				+ (segNombre == null ? "" : " " + segNombre);
		String segApellido = jugador.getPersonaNatural()
				.getSegundoApellido();
		apellidos = jugador.getPersonaNatural()
				.getPrimerApellido()
				+ (segApellido == null ? "" : " " + segApellido);
		String cedula = jugador.getCedulaRif();
		cmbNacionalidad.setValue(cedula.substring(0, 1));
		txtCedula.setValue(cedula.substring(2));
		
		btnEditar.setDisabled(false);
		btnAgregar.setDisabled(false);
		btnQuitar.setDisabled(false);
		
		listaFamiliarJugador = servicioFamiliarJugador.buscarFamiliarJugador(jugador);
		
		//System.out.println(listaFamiliarJugador.get(0).isRepresentanteActual());

  
	}
	
	private void limpiarFamiliar() {
		familiar = new Familiar();
		//cmbComisiones.setSelectedIndex(-1);
	//	List<FamiliarJugador> listaFamiliarJugador = new ArrayList<FamiliarJugador>();
		binder.loadComponent(listaFamiliar);
	}
	
	private void limpiarCamposFamiliar(){
		binder.loadAll();
		txtCedulaFamiliar.setValue("");
		txtPrimerNombre.setValue("");
		txtSegundoNombre.setValue("");
		txtPrimerApellido.setValue("");
		txtSegundoApellido.setValue("");
		txtDireccionHabitacion.setValue("");
		txtTelefonoCelular.setValue("");
		txtTelefonoHabitacion.setValue("");
		txtCorreo.setValue("");
		txtTwitter.setValue("");
		limpiarComision();

		
	}


	
	
	public void onClick$btnEditar() {
		/*familiar = (Familiar) formulario.getVariable("familiar", false);
		sw = true;
		binder.loadAll();	
		*/
		panelFamiliar.setVisible(true);
		if (listaFamiliar.getSelectedIndex() >= 0) {
			FamiliarJugador familiarSeleccionado = (FamiliarJugador) listaFamiliar.getSelectedItem()
					.getValue();
			familiar = familiarSeleccionado.getFamiliar();
			String ced = familiar.getCedulaRif();
			cmbNacionalidadFamiliar.setValue(ced.substring(0,1));
			txtCedulaFamiliar.setValue(ced.substring(2));
			//familiarJugador =  familiarSeleccionado;
			//System.out.println(familiarSeleccionado.getFamiliar().getCedulaRif());
			
			// lista de dato basico
			comisionesFamiliar = servicioFamiliarComisionEquipo.buscarFamiliarComisionEquipo(familiarSeleccionado);
			//System.out.println(familiarComisionEquipo.getComisionEquipo().getDatoBasico().getNombre());
	       
			if (comisionesFamiliar.size()>0){
				  binder.loadComponent(listComisiones);
			}

			
			//binder.loadAll();
			txtPrimerNombre.setValue(familiar.getPersonaNatural().getPrimerNombre());
			txtSegundoNombre.setValue(familiar.getPersonaNatural().getSegundoNombre());
			txtPrimerApellido.setValue(familiar.getPersonaNatural().getPrimerApellido());
			txtSegundoApellido.setValue(familiar.getPersonaNatural().getSegundoApellido());
			cmbParentesco.setValue(familiarJugador.getDatoBasico().getNombre());
			cmbProfesion.setValue(familiar.getDatoBasico().getNombre());
			
			persona = familiar.getPersonaNatural().getPersona();
			
			cmbParroquiaResi.setValue(persona.getDatoBasicoByCodigoParroquia().getNombre());
			cmbMunicipioResi.setValue(persona.getDatoBasicoByCodigoParroquia().getDatoBasico().getNombre());
			cmbEstadoResi.setValue(persona.getDatoBasicoByCodigoParroquia().getDatoBasico().getDatoBasico().getNombre());
			txtDireccionHabitacion.setValue(persona.getDireccion());
			
			String telf  = persona.getTelefonoHabitacion();
			cmbCodArea.setValue(telf.substring(0,4));
			txtTelefonoHabitacion.setValue(telf.substring(5));
			String celu = persona.getPersonaNatural().getCelular();
			cmbCodCelular.setValue(celu.substring(0,4));
			txtTelefonoCelular.setValue(celu.substring(5));
			txtCorreo.setValue(persona.getCorreoElectronico());
			txtTwitter.setValue(persona.getTwitter());
			
			//System.out.println(persona.getCedulaRif());

		} else {
			alert("Seleccione un dato");
		}
	}
	
	public void onClick$btnCancelar() {

	}
	
	public void onClick$btnAgregar() {
		limpiarCamposFamiliar();
		panelFamiliar.setVisible(true);
		cmbNacionalidadFamiliar.setDisabled(false);
		txtCedulaFamiliar.setReadonly(false);
		
	}
	
	public void onClick$btnSalir() {
		//FALTA VALIDACION DE SALIDA
		winActualizarFamiliar.detach();
	}
	
	
	public FamiliarJugador getFamiliarJugador() {
		return familiarJugador;
	}

	public void setFamiliarJugador(FamiliarJugador familiarJugador) {
		this.familiarJugador = familiarJugador;
	}

	public List<FamiliarJugador> getListaFamiliarJugador() {
		return listaFamiliarJugador;
	}

	public void setListaFamiliarJugador(List<FamiliarJugador> listaFamiliarJugador) {
		this.listaFamiliarJugador = listaFamiliarJugador;
	}

	public List<Equipo> getEquipos() {
		return servicioEquipo.buscarPorCategoria(categoria);
	}

	public List<Roster> getRosters() {
		return servicioRoster.listar();
	}

	public Image getImgFamiliar() {
		return imgFamiliar;
	}

	public void setImgFamiliar(Image imgFamiliar) {
		this.imgFamiliar = imgFamiliar;
	}

	public ServicioJugador getServicioJugador() {
		return servicioJugador;
	}

	public void setServicioJugador(ServicioJugador servicioJugador) {
		this.servicioJugador = servicioJugador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Roster getRoster() {
		return roster;
	}

	public void setRoster(Roster roster) {
		this.roster = roster;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public DatoBasico getParentesco() {
		return parentesco;
	}

	public void setParentesco(DatoBasico parentesco) {
		this.parentesco = parentesco;
	}
	
	public List<DatoBasico> getParentescos() {
		return servicioDatoBasico.buscar(TipoDatoBasico.PARENTESCO);
	}

	public Familiar getFamiliar() {
		return familiar;
	}

	public void setFamiliar(Familiar familiar) {
		this.familiar = familiar;
	}

	public DatoBasico getProfesion() {
		return profesion;
	}

	public void setProfesion(DatoBasico profesion) {
		this.profesion = profesion;
	}
	
	public List<DatoBasico> getProfesiones() {
		return servicioDatoBasico.buscar(TipoDatoBasico.PROFESION);
	}
	
	public DatoBasico getComision() {
		return comision;
	}

	public void setComision(DatoBasico comision) {
		this.comision = comision;
	}
	
	public List<DatoBasico> getComisiones() {
/*		List<DatoBasico> lista = null;
		DatoBasico datoComision = servicioDatoBasico.buscarTipo(
				TipoDatoBasico.COMISION, "comision");
		if (datoComision != null) {
			lista = servicioDatoBasico.buscarDatosPorRelacion(datoComision);
		}
		return lista;   */
		return servicioDatoBasico.buscar(TipoDatoBasico.COMISION);
	}
	
	// Eventos

	public void onClick$btnAgregarComision() {
		if (cmbComisiones.getSelectedIndex() >= 0) {
			for (int a=0; a<comisionesFamiliar.size();a++){
				System.out.println(comisionesFamiliar.get(a).getNombre());
			}
			
			int aux =0;
			int n =comisionesFamiliar.size();
			
			System.out.println(n);
			int i;
			for (i = 0; i < n; i++) {
				System.out.println(i);
				System.out.println(comisionesFamiliar.get(i).getCodigoDatoBasico());
				System.out.println(comision.getCodigoDatoBasico());
				if (comisionesFamiliar.get(i).getCodigoDatoBasico()==comision.getCodigoDatoBasico()){
					
					aux = 0;
				}
				else
				{
					//comisionesFamiliar.add(comision);
					//comisionesFamiliar.set(n, comision.getDatoBasico());
					aux =1;
					limpiarComision();
				}
			}
			System.out.println(i);
		/*	for (int i=0;i<comisionesFamiliar.size();i++){
				System.out.println(i);
				if (comisionesFamiliar.get(i).getDatoBasico()!=comision){
					comisionesFamiliar.add(comision);
					aux =1;
					limpiarComision();
				}
			}*/
			if (aux==0){
				 
						Mensaje.mostrarMensaje("Comision Duplicada.",
								Mensaje.ERROR_DATOS, Messagebox.EXCLAMATION);
				
			}
		} else {
			Mensaje.mostrarMensaje("Seleccione una Comision.",
					Mensaje.INFORMACION, Messagebox.EXCLAMATION);
			cmbComisiones.setFocus(true);
		}
		
		for (int a=0; a<comisionesFamiliar.size();a++){
			System.out.println(comisionesFamiliar.get(a).getNombre());
		}
}
	
	
	private void limpiarComision() {
		//comision = new DatoBasico();
		cmbComisiones.setSelectedIndex(-1);
		
	//	List<FamiliarComisionEquipo> comisionesFamiliar = new ArrayList<FamiliarComisionEquipo>();
		//Listbox listComisiones = null;
		binder.loadComponent(listComisiones);
	}

	public FamiliarComisionEquipo getFamiliarComisionEquipo() {
		return familiarComisionEquipo;
	}

	public void setFamiliarComisionEquipo(
			FamiliarComisionEquipo familiarComisionEquipo) {
		this.familiarComisionEquipo = familiarComisionEquipo;
	}

	public List<DatoBasico> getComisionesFamiliar() {
		return comisionesFamiliar;
	}

	public void setComisionesFamiliar(
			List<DatoBasico> comisionesFamiliar) {
		this.comisionesFamiliar = comisionesFamiliar;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public DatoBasico getCodigoCel() {
		return codigoCel;
	}

	public void setCodigoCel(DatoBasico codigoCel) {
		this.codigoCel = codigoCel;
	}

	public List<DatoBasico> getCodigosCel() {
		return servicioDatoBasico.buscar(TipoDatoBasico.CODIGO_CELULAR);
	}
	// Getters y setters
	public DatoBasico getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(DatoBasico codigoArea) {
		this.codigoArea = codigoArea;
	}
	
	public List<DatoBasico> getCodigosArea() {
		return servicioDatoBasico.buscar(TipoDatoBasico.CODIGO_AREA);
	}

	
	public DatoBasico getEstado() {
		return estado;
	}


	public void setEstado(DatoBasico estado) {
		this.estado = estado;
	}


	public DatoBasico getMunicipio() {
		return municipio;
	}

	public void setMunicipio(DatoBasico municipio) {
		this.municipio = municipio;
	}


	public DatoBasico getParroquia() {
		return parroquia;
	}

	public void setParroquia(DatoBasico parroquia) {
		this.parroquia = parroquia;
	}
	
	public List<DatoBasico> getEstadosVenezuela() {
		return servicioDatoBasico.buscar(TipoDatoBasico.ESTADO_VENEZUELA);
	}

	public List<DatoBasico> getMunicipiosEstadosResi() {
		return servicioDatoBasico.buscarDatosPorRelacion(estado);
	}

	public List<DatoBasico> getParroquiasMunicipioResi() {
		return servicioDatoBasico.buscarDatosPorRelacion(municipio);
	}



}