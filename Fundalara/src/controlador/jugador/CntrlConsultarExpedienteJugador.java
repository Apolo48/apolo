package controlador.jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import org.zkoss.zul.Image;
import org.zkoss.zul.Include;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Tab;

import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioDatoBasico;
import servicio.implementacion.ServicioDatoAcademico;
import servicio.implementacion.ServicioDatoMedico;
import servicio.implementacion.ServicioDatoSocial;
import servicio.implementacion.ServicioEquipo;
import servicio.implementacion.ServicioJugador;
import servicio.implementacion.ServicioPersona;
import servicio.implementacion.ServicioRecaudoPorProceso;
import servicio.implementacion.ServicioInstitucion;
import servicio.implementacion.ServicioLapsoDeportivo;
import servicio.implementacion.ServicioRoster;

import comun.FileLoader;
import comun.Ruta;
import comun.Util;
import comun.TipoDatoBasico;
import comun.Mensaje;

import controlador.jugador.bean.ActividadSocial;
import controlador.jugador.bean.NuevoCurso;
import controlador.jugador.bean.Afeccion;
//import controlador.jugador.bean.Persona;

import modelo.AfeccionJugador;
import modelo.Categoria;
import modelo.DatoBasico;
import modelo.AfeccionJugadorId;
import modelo.DatoAcademico;
import modelo.DatoMedico;
import modelo.DatoSocial;
import modelo.DocumentoEntregado;
import modelo.Equipo;
import modelo.Institucion;
import modelo.LapsoDeportivo;
import modelo.Jugador;
import modelo.Medico;
import modelo.Persona;
import modelo.PersonaNatural;
import modelo.RecaudoPorProceso;
import modelo.RetiroTraslado;
import modelo.Roster;

/**
 * Clase controladora de los eventos de la vista de igual nombre y manejo de los
 * servicios de datos para la actualizacion de los datos correspondientes a un
 * jugador.
 * 
 * @author Edgar L.
 * @author Alberto P.
 * @author Aimee M.
 * @author Glendy O.
 * @author Greisy R.
 * @version 0.1.0 09/01/2012
 * 
 * */
public class CntrlConsultarExpedienteJugador extends GenericForwardComposer {
	private static final DatoBasico Actualizar = null;
	// Componentes visuales
	private Textbox txtFechaNac;
	private Button btnCatalogoJugador;
	private Intbox txtEdad;
	private Textbox txtCedulaSecuencia;
	private Textbox txtCedula;
	private Textbox txtPrimerNombre;
	private Textbox txtPrimerApellido;
	private Textbox txtSegundoNombre;
	private Textbox txtSegundoApellido;
	private Image imgJugador;
	private Textbox txtNacionalidad;
	private Textbox txtGenero;
	private Textbox txtEstadoNac;
	private Textbox txtMunicipioNac;
	private Textbox txtParroquiaNac;
	private Textbox txtParroquiaResi;
	private Textbox txtMunicipioResi;
	private Textbox txtEstadoResi;
	private Textbox txtTemporada;
	private Textbox txtPaisNac;
	private Textbox txtCodArea;
	private Textbox txtTelefonoHabitacion;
	private Textbox txtTelefonoCelular;
	private Label lblSeparador;
	private Listbox listAfeccionesActuales;
	private Listbox listActividadesSociales;
	private Listbox listNuevosCursos;
	private Listbox listMotivos;
	private Listbox listDocAcademicos;
	private Listbox listAfecciones;
	private Component formulario;
	private Include incCuerpo;

	private String rutasJug = Ruta.JUGADOR.getRutaVista();

	// Servicios
	private ServicioDatoBasico servicioDatoBasico;
	private ServicioCategoria servicioCategoria;
	private ServicioEquipo servicioEquipo;
	private ServicioRecaudoPorProceso servicioRecaudoPorProceso;
	private ServicioInstitucion servicioInstitucion;
	private ServicioLapsoDeportivo servicioLapsoDeportivo;
	private ServicioRoster servicioRoster;
	private ServicioJugador servicioJugador;
	private ServicioPersona servicioPersona;

	// Modelos
	private Jugador jugador = new Jugador();
	private controlador.jugador.bean.Jugador jugadorBean = new controlador.jugador.bean.Jugador();
	private Persona persona = new Persona();
	private DatoMedico afeccJug = new DatoMedico();

	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	private DatoBasico estadoVenezuela = new DatoBasico();
	private DatoBasico estadoVenezuelaResi = new DatoBasico();
	private DatoBasico municipioNac = new DatoBasico();
	private DatoBasico municipioResi = new DatoBasico();
	private DatoMedico datoMedico = new DatoMedico();
	private DatoBasico institucionEducativa = new DatoBasico();
	private DatoBasico institucionRecreativa = new DatoBasico();
	private Afeccion afeccion = new Afeccion();
	private DatoBasico comision = new DatoBasico();
	private DatoBasico actualizacionMedica = new DatoBasico();
	private DatoBasico logro;
	private DatoBasico sancion;
	private DatoBasico suspension;
	private Medico medico = new Medico();
	List<Afeccion> afeccionesJugador = new ArrayList<Afeccion>();
	private NuevoCurso nuevosCursos = new NuevoCurso();
	List<NuevoCurso> nuevoCurso = new ArrayList<NuevoCurso>();
	private DatoAcademico datoAcademico = new DatoAcademico();
	private DatoSocial datoSocial = new DatoSocial();
	private List<DatoSocial> datoSociales = new ArrayList<DatoSocial>();
	List<DatoMedico> AfeccionesJug = new ArrayList<DatoMedico>();
	

	// private List<DatoAcademico> datoAcademicos = new
	// ArrayList<DatoAcademico>();
	Roster roster;
	RetiroTraslado retJugador;
	PersonaNatural personaN = new PersonaNatural();

	// Binder
	private AnnotateDataBinder binder;
	/**
	 * Mantiene un Map con todos los atributos asociados a la ejecucion actual
	 */
	private Map<String, Object> requestScope;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		formulario = comp;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public DatoBasico getEstadoVenezuela() {
		return estadoVenezuela;
	}

	public void setEstadoVenezuela(DatoBasico estadoVenezuela) {
		this.estadoVenezuela = estadoVenezuela;
	}

	public DatoBasico getEstadoVenezuelaResi() {
		return estadoVenezuelaResi;
	}

	public void setEstadoVenezuelaResi(DatoBasico estadoVenezuelaResi) {
		this.estadoVenezuelaResi = estadoVenezuelaResi;
	}

	public DatoBasico getMunicipioNac() {
		return municipioNac;
	}

	public void setMunicipioNac(DatoBasico municipioNac) {
		this.municipioNac = municipioNac;
	}

	public DatoBasico getMunicipioResi() {
		return municipioResi;
	}

	public void setMunicipioResi(DatoBasico municipioResi) {
		this.municipioResi = municipioResi;
	}

	public DatoMedico getDatoMedico() {
		return datoMedico;
	}

	public void setDatoMedico(DatoMedico datoMedico) {
		this.datoMedico = datoMedico;
	}

	public DatoBasico getInstitucionEducativa() {
		return institucionEducativa;
	}

	public void setInstitucionEducativa(DatoBasico institucionEducativa) {
		this.institucionEducativa = institucionEducativa;
	}

	public DatoBasico getInstitucionRecreativa() {
		return institucionRecreativa;
	}

	public void setInstitucionRecreativa(DatoBasico institucionRecreativa) {
		this.institucionRecreativa = institucionRecreativa;
	}

	public Map<String, Object> getRequestScope() {
		return requestScope;
	}

	public void setRequestScope(Map<String, Object> requestScope) {
		this.requestScope = requestScope;
	}

	public List<Afeccion> getAfeccionesJugador() {
		return afeccionesJugador;
	}

	public void setAfeccionesJugador(List<Afeccion> afeccionesJugador) {
		this.afeccionesJugador = afeccionesJugador;
	}

	public void setNuevoCurso(List<NuevoCurso> nuevoCurso) {
		this.nuevoCurso = nuevoCurso;
	}

	public List<NuevoCurso> getNuevoCurso() {
		return nuevoCurso;
	}

	public DatoBasico getLogro() {
		return logro;
	}

	public void setLogro(DatoBasico logro) {
		this.logro = logro;
	}

	public DatoBasico getSancion() {
		return sancion;
	}

	public void setSancion(DatoBasico sancion) {
		this.sancion = sancion;
	}

	public DatoBasico getSuspension() {
		return suspension;
	}

	public void setSuspension(DatoBasico suspension) {
		this.suspension = suspension;
	}

	public DatoBasico getActualizacionMedica() {
		return actualizacionMedica;
	}

	public Component getFormulario() {
		return formulario;
	}

	public void setFormulario(Component formulario) {
		this.formulario = formulario;
	}

	public Roster getRoster() {
		return roster;
	}

	public void setRoster(Roster roster) {
		this.roster = roster;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public PersonaNatural getPersonaN() {
		return personaN;
	}

	public void setPersonaN(PersonaNatural personaN) {
		this.personaN = personaN;
	}

	public void setActualizacionMedica(DatoBasico actualizacionMedica) {
		this.actualizacionMedica = actualizacionMedica;
	}

	public DatoSocial getDatoSocial() {
		return datoSocial;
	}

	public void setDatoSocial(DatoSocial datoSocial) {
		this.datoSocial = datoSocial;
	}

	public List<DatoSocial> getDatoSociales() {
		return datoSociales;
	}

	public void setDatoSociales(List<DatoSocial> datoSociales) {
		this.datoSociales = datoSociales;
	}
	
	public List<DatoMedico> getAfeccionesJug() {
		return AfeccionesJug;
	}

	public void setAfeccionesJug(List<DatoMedico> afeccionesJug) {
		AfeccionesJug = afeccionesJug;
	}
	
	public DatoMedico getAfeccJug() {
		return afeccJug;
	}

	public void setAfeccJug(DatoMedico afeccJug) {
		this.afeccJug = afeccJug;
	}

	/*
	 * public DatoAcademico getDatoAcademico() { return datoAcademico; }
	 * 
	 * public void setDatoAcademico(DatoAcademico datoAcademico) {
	 * this.datoAcademico = datoAcademico; }
	 * 
	 * public List<DatoAcademico> getDatoAcademicos() { return datoAcademicos; }
	 * 
	 * public void setDatoAcademicos(List<DatoAcademico> datoAcademicos) {
	 * this.datoAcademicos = datoAcademicos; }
	 */

	// Metodos para carga de combos/listbox
	public Include getIncCuerpo() {
		return incCuerpo;
	}

	public void setIncCuerpo(Include incCuerpo) {
		this.incCuerpo = incCuerpo;
	}

	public controlador.jugador.bean.Jugador getJugadorBean() {
		return jugadorBean;
	}

	public void setJugadorBean(controlador.jugador.bean.Jugador jugadorBean) {
		this.jugadorBean = jugadorBean;
	}

	public void onClick$btnCatalogoJugador() {
		// se crea el catalogo y se llama
		Component catalogo = Executions.createComponents(
				"/Jugador/Vistas/frmBuscarJugador.zul", null, null);
		// asigna una referencia del formulario al catalogo.
		catalogo.setVariable("formulario", formulario, false);

		formulario.addEventListener("onCatalogoCerrado", new EventListener() {

			@Override
			public void onEvent(Event arg0) throws Exception {
				//Jugador
				jugador = (Jugador) formulario.getVariable("jugador", false);
				//String cedula = jugador.getCedulaRif();
				//txtNacionalidad.setValue(cedula.substring(0, 1));
				txtCedula.setValue(jugador.getCedulaRif());
				txtPrimerNombre.setValue(jugador.getPersonaNatural()
						.getPrimerNombre());
				txtSegundoNombre.setValue(jugador.getPersonaNatural()
						.getSegundoNombre());
				txtPrimerApellido.setValue(jugador.getPersonaNatural()
						.getPrimerApellido());
				txtSegundoApellido.setValue(jugador.getPersonaNatural()
						.getSegundoApellido());
				txtGenero.setValue(jugador.getPersonaNatural().getDatoBasico()
						.getNombre());
				java.util.Date date = new java.util.Date();
				date = jugador.getPersonaNatural().getFechaNacimiento();
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
						"dd/MM/yyyy");
				String fecha = sdf.format(date);
				txtFechaNac.setValue(fecha);
				txtEdad.setValue(Util.calcularDiferenciaAnnios(date));
				txtPaisNac.setValue(jugador.getDatoBasicoByCodigoPais()
						.getNombre());
				
				//Persona
				//persona = servicioPersona.buscarPorCedulaRif(cedula);
				txtParroquiaResi.setContext(String
						.valueOf(jugador.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia()
								.getCodigoDatoBasico()));
				txtParroquiaResi.setValue(jugador.getPersonaNatural().getPersona()
						.getDatoBasicoByCodigoParroquia().getNombre());
				txtMunicipioResi.setValue(jugador.getPersonaNatural().getPersona()
						.getDatoBasicoByCodigoParroquia().getDatoBasico()
						.getNombre());
				txtEstadoResi.setValue(jugador.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia()
						.getDatoBasico().getDatoBasico().getNombre());
				
				binder.loadAll();

			}
		});
	}

	// Eventos
	public void onClick$btnCatalogoMedico() {
		new Util().crearVentana(rutasJug + "buscarMedico.zul", null, null);
	}

	public void onClick$btnGuardar() {

	}

	public void onClick$btnFoto() {
		new FileLoader().cargarImagenEnBean(imgJugador);
	}

	/*
	 * public void onChange$cmbTipoActualizacion() { String src = ""; String
	 * valor = cmbTipoActualizacion.getSelectedItem().getLabel(); Util enlace =
	 * new Util(); if (valor.equalsIgnoreCase("DATOS MÉDICOS")) { src =
	 * "frmActualizarDatosMedicos.zul"; } else if
	 * (valor.equalsIgnoreCase("AFECCIÓN")) { src = "frmActualizarAfeccion.zul";
	 * } else if (valor.equalsIgnoreCase("LESIÓN")) { src =
	 * "frmActualizarLesion.zul"; } src = rutasJug + src; incCuerpo
	 * .setDynamicProperty("actualizacionMedica", actualizacionMedica);
	 * enlace.insertarContenido(incCuerpo, src); }
	 */

	// Metodos propios del ctrl

}
