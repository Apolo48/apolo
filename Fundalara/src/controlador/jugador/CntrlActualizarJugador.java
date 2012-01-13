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
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Include;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
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
import controlador.jugador.bean.SancionJugador;
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
 * @version 0.2.8 06/01/2012
 * 
 * */
public class CntrlActualizarJugador extends GenericForwardComposer {
	private static final DatoBasico Actualizar = null;
	// Componentes visuales
	private Window winActualizarJugador;
	private Textbox txtFechaNac;
	private Datebox dtboxFechaInicioActividad;
	private Button btnGuardar;
	private Button btnFoto;
	private Button btnCatalogoMedico;
	private Button btnCatalogoJugador;
	private Button btnAgregarAfeccion;
	private Button btnEliminarAfeccion;
	private Button btnAgregarActividad;
	private Button btnEliminarActividad;
	private Button btnAgregarInstitucion;
	private Button btnQuitarInstitucion;
	private Button btnSalir;
	private Intbox txtEdad;
	private Textbox txtCedulaSecuencia;
	private Textbox txtCedula;
	private Intbox txtHorasSemanales;
	private Textbox txtPrimerNombre;
	private Textbox txtPrimerApellido;
	private Textbox txtSegundoNombre;
	private Textbox txtSegundoApellido;
	private Intbox txtTelefonoHabitacion;
	private Intbox txtTelefonoCelular;
	private Textbox txtCorreo;
	private Textbox txtTwitter;
	private Textbox txtFacebook;
	private Decimalbox txtPeso;
	private Decimalbox txtAltura;
	private Image imgJugador;
	private Combobox cmbNacionalidadFamiliar;
	private Textbox txtNacionalidad;
	private Textbox txtGenero;
	private Combobox cmbEstadoNac;
	private Combobox cmbMunicipioNac;
	private Combobox cmbParroquiaNac;
	private Combobox cmbParroquiaResi;
	private Combobox cmbMunicipioResi;
	private Combobox cmbEstadoResi;
	private Textbox txtDireccion;
	private Combobox cmbAfecciones;
	private Combobox cmbInstitucionEducativa;
	private Combobox cmbCurso;
	private Combobox cmbAnnioEscolar;
	private Combobox cmbInstitucionRecreativa;
	private Combobox cmbActividad;
	private Combobox cmbMotivo;
	private Combobox cmbLapsoDeportivo;
	private Combobox cmbTemporada;
	private Combobox cmbTipoActualizacion;
	private Combobox cmbPaisNac;
	private Combobox cmbCodArea;
	private Combobox cmbCodCelular;
	private Combobox cmbBrazoLanzar;
	private Combobox cmbPosicionBateo;
	private Combobox cmbTallaCamisa;
	private Combobox cmbTallaPantalon;
	private Combobox cmbTallaCalzado;
	private Label lblSeparador;
	private Listbox listAfeccionesActuales;
	private Listbox listActividadesSociales;
	private Listbox listNuevosCursos;
	private Listbox listMotivos;
	private Listbox listDocAcademicos;
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
	// private controlador.jugador.bean.Persona personaBean = new
	// controlador.jugador.bean.Persona();

	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	private DatoBasico estadoVenezuela = new DatoBasico();
	private DatoBasico estadoVenezuelaResi = new DatoBasico();
	private DatoBasico municipioNac = new DatoBasico();
	private DatoBasico municipioResi = new DatoBasico();
	private DatoMedico datoMedico = new DatoMedico();
	private DatoBasico institucionEducativa = new DatoBasico();
	private DatoBasico institucionRecreativa = new DatoBasico();
	private DatoBasico temporadaRegular = new DatoBasico();
	private List<DocumentoEntregado> documentosAcademicos = new ArrayList<DocumentoEntregado>();
	private List<DocumentoEntregado> documentosMedicos = new ArrayList<DocumentoEntregado>();
	private List<DocumentoEntregado> documentosPersonales = new ArrayList<DocumentoEntregado>();
	private RecaudoPorProceso recaudoAcademico = new RecaudoPorProceso();
	private RecaudoPorProceso recaudoMedico = new RecaudoPorProceso();
	private RecaudoPorProceso recaudoPersonal = new RecaudoPorProceso();
	private Afeccion afeccion = new Afeccion();
	private DocumentoEntregado docEntAcad = new DocumentoEntregado();
	private DocumentoEntregado docEntPersonal = new DocumentoEntregado();
	private DocumentoEntregado docEntMed = new DocumentoEntregado();
	private DatoBasico comision = new DatoBasico();
	private DatoBasico actualizacionMedica = new DatoBasico();
	private DatoBasico logro;
	private DatoBasico sancion;
	private DatoBasico suspension;
	private Medico medico = new Medico();
	List<Afeccion> afeccionesJugador = new ArrayList<Afeccion>();
	private NuevoCurso nuevosCursos = new NuevoCurso();
	private SancionJugador sancionJugador = new SancionJugador();
	List<NuevoCurso> nuevoCurso = new ArrayList<NuevoCurso>();
	List<SancionJugador> nuevo_motivo = new ArrayList<SancionJugador>();
	private DatoAcademico datoAcademico = new DatoAcademico();
	private DatoSocial datoSocial = new DatoSocial();
	private List<DatoSocial> datoSociales = new ArrayList<DatoSocial>();
	// private List<DatoAcademico> datoAcademicos = new
	// ArrayList<DatoAcademico>();
	Roster roster;
	Persona persona;
	private Persona Pers = new Persona();
	RetiroTraslado retJugador;
	PersonaNatural personaN = new PersonaNatural();

	// Binder
	private AnnotateDataBinder binder;
	/**
	 * Mantiene un Map con todos los atributos asociados a la ejecucion actual
	 */
	private Map<String, Object> requestScope;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		formulario = comp;
	}

	// Getters y setters	
	
	public Jugador getJugador() {
		return jugador;
	}

	public Decimalbox getTxtPeso() {
		return txtPeso;
	}

	public void setTxtPeso(Decimalbox txtPeso) {
		this.txtPeso = txtPeso;
	}

	public Decimalbox getTxtAltura() {
		return txtAltura;
	}

	public void setTxtAltura(Decimalbox txtAltura) {
		this.txtAltura = txtAltura;
	}

	public Combobox getCmbBrazoLanzar() {
		return cmbBrazoLanzar;
	}

	public void setCmbBrazoLanzar(Combobox cmbBrazoLanzar) {
		this.cmbBrazoLanzar = cmbBrazoLanzar;
	}

	public Combobox getCmbPosicionBateo() {
		return cmbPosicionBateo;
	}

	public void setCmbPosicionBateo(Combobox cmbPosicionBateo) {
		this.cmbPosicionBateo = cmbPosicionBateo;
	}

	public Combobox getCmbTallaCamisa() {
		return cmbTallaCamisa;
	}

	public void setCmbTallaCamisa(Combobox cmbTallaCamisa) {
		this.cmbTallaCamisa = cmbTallaCamisa;
	}

	public Combobox getCmbTallaPantalon() {
		return cmbTallaPantalon;
	}

	public void setCmbTallaPantalon(Combobox cmbTallaPantalon) {
		this.cmbTallaPantalon = cmbTallaPantalon;
	}

	public Combobox getCmbTallaCalzado() {
		return cmbTallaCalzado;
	}

	public void setCmbTallaCalzado(Combobox cmbTallaCalzado) {
		this.cmbTallaCalzado = cmbTallaCalzado;
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

	public DatoBasico getTemporadaRegular() {
		return temporadaRegular;
	}

	public void setTemporadaRegular(DatoBasico temporadaRegular) {
		this.temporadaRegular = temporadaRegular;
	}

	public Map<String, Object> getRequestScope() {
		return requestScope;
	}

	public void setRequestScope(Map<String, Object> requestScope) {
		this.requestScope = requestScope;
	}

	public RecaudoPorProceso getRecaudoAcademico() {
		return recaudoAcademico;
	}

	public void setRecaudoAcademico(RecaudoPorProceso recaudoAcademico) {
		this.recaudoAcademico = recaudoAcademico;
	}

	public RecaudoPorProceso getRecaudoMedico() {
		return recaudoMedico;
	}

	public void setRecaudoMedico(RecaudoPorProceso recaudoMedico) {
		this.recaudoMedico = recaudoMedico;
	}

	public RecaudoPorProceso getRecaudoPersonal() {
		return recaudoPersonal;
	}

	public void setRecaudoPersonal(RecaudoPorProceso recaudoPersonal) {
		this.recaudoPersonal = recaudoPersonal;
	}

	public List<Afeccion> getAfeccionesJugador() {
		return afeccionesJugador;
	}

	public void setAfeccionesJugador(List<Afeccion> afeccionesJugador) {
		this.afeccionesJugador = afeccionesJugador;
	}

	public SancionJugador getsancionJugador() {
		return sancionJugador;
	}

	public void setsancionJugador(SancionJugador sancionJugador) {
		this.sancionJugador = sancionJugador;
	}

	public void setNuevoCurso(List<NuevoCurso> nuevoCurso) {
		this.nuevoCurso = nuevoCurso;
	}

	public List<NuevoCurso> getNuevoCurso() {
		return nuevoCurso;
	}

	public void setNuevo_Motivos(List<SancionJugador> nuevo_motivo) {
		this.nuevo_motivo = nuevo_motivo;
	}

	public List<SancionJugador> getNuevo_Motivos() {
		return nuevo_motivo;
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
	public List<Categoria> getCategorias() {
		return servicioCategoria.listar();
	}

	public List<DatoBasico> getCursos() {
		return servicioDatoBasico.buscar(TipoDatoBasico.CURSO);
	}

	public List<DatoBasico> getAnnoEsc() {
		return servicioDatoBasico.buscar(TipoDatoBasico.ANNO_ESCOLAR);
	}

	public List<DatoBasico> getActividadSoc() {
		return servicioDatoBasico.buscar(TipoDatoBasico.ACTIVIDAD_SOCIAL);
	}

	public List<DatoBasico> getEstadosVenezuela() {
		return servicioDatoBasico.buscar(TipoDatoBasico.ESTADO_VENEZUELA);
	}

	public List<DatoBasico> getPaises() {
		return servicioDatoBasico.buscar(TipoDatoBasico.PAIS);
	}

	public List<DatoBasico> getMunicipiosEstados() {
		return servicioDatoBasico.buscarDatosPorRelacion(estadoVenezuela);
	}

	public List<DatoBasico> getMunicipiosEstadosResi() {
		return servicioDatoBasico.buscarDatosPorRelacion(estadoVenezuelaResi);
	}

	public List<DatoBasico> getParroquiasMunicipio() {
		return servicioDatoBasico.buscarDatosPorRelacion(municipioNac);
	}

	public List<DatoBasico> getParroquiasMunicipioResi() {
		return servicioDatoBasico.buscarDatosPorRelacion(municipioResi);
	}

	public List<DatoBasico> getCodigosArea() {
		return servicioDatoBasico.buscar(TipoDatoBasico.CODIGO_AREA);
	}

	public List<DatoBasico> getCodigosCelular() {
		return servicioDatoBasico.buscar(TipoDatoBasico.CODIGO_CELULAR);
	}

	public List<DatoBasico> getSanciones() {
		return servicioDatoBasico.buscar(TipoDatoBasico.SANCION);
	}

	public List<DatoBasico> getSuspensiones() {
		return servicioDatoBasico.buscar(TipoDatoBasico.SUSPENSION);
	}

	public List<Equipo> getEquipos() {
		return servicioEquipo.buscarPorCategoria(categoria);
	}

	public List<DatoBasico> getValoresBrazoLanzamiento() {
		return servicioDatoBasico.buscar(TipoDatoBasico.BRAZO_LANZAR);
	}

	public List<DatoBasico> getValoresPosicionBateo() {
		return servicioDatoBasico.buscar(TipoDatoBasico.POSICION_BATEO);
	}

	public List<DatoBasico> getLogros() {
		return servicioDatoBasico.buscar(TipoDatoBasico.LOGRO);
	}

	public List<DatoBasico> getActualizacion() {
		return servicioDatoBasico.buscar(TipoDatoBasico.ACTUALIZACION_MEDICA);
	}

	public Include getIncCuerpo() {
		return incCuerpo;
	}

	public void setIncCuerpo(Include incCuerpo) {
		this.incCuerpo = incCuerpo;
	}

	public List<DocumentoEntregado> getRecaudosPersonales() {
		List<RecaudoPorProceso> lista = servicioRecaudoPorProceso
				.buscarPorProceso(Actualizar, TipoDatoBasico.TIPO_DOCUMENTO,
						"Personal");
		for (RecaudoPorProceso recaudoPorProceso : lista) {
			DocumentoEntregado docE = new DocumentoEntregado();
			docE.setRecaudoPorProceso(recaudoPorProceso);
			documentosPersonales.add(docE);
		}
		return documentosPersonales;
	}

	public List<DocumentoEntregado> getRecaudosAcademicos() {
		List<RecaudoPorProceso> lista = servicioRecaudoPorProceso
				.buscarPorProceso(Actualizar, TipoDatoBasico.TIPO_DOCUMENTO,
						"Academico");
		for (RecaudoPorProceso recaudoPorProceso : lista) {
			DocumentoEntregado docE = new DocumentoEntregado();
			docE.setRecaudoPorProceso(recaudoPorProceso);
			documentosAcademicos.add(docE);
		}
		return documentosAcademicos;
	}

	public List<DocumentoEntregado> getRecaudosMedicos() {
		List<RecaudoPorProceso> lista = servicioRecaudoPorProceso
				.buscarPorProceso(Actualizar, TipoDatoBasico.TIPO_DOCUMENTO,
						"Medico");
		for (RecaudoPorProceso recaudoPorProceso : lista) {
			DocumentoEntregado docE = new DocumentoEntregado();
			docE.setRecaudoPorProceso(recaudoPorProceso);
			documentosMedicos.add(docE);
		}
		return documentosMedicos;
	}

	public controlador.jugador.bean.Jugador getJugadorBean() {
		return jugadorBean;
	}

	public void setJugadorBean(controlador.jugador.bean.Jugador jugadorBean) {
		this.jugadorBean = jugadorBean;
	}

	public List<Institucion> getInstitucionesEducativas() {
		List<Institucion> lista = null;
		DatoBasico datoInstitucion = servicioDatoBasico.buscarTipo(
				TipoDatoBasico.INSTITUCION, "Educativa");
		if (datoInstitucion != null) {
			lista = servicioInstitucion.buscarInstitucionTipo(datoInstitucion);
		}

		return lista;
	}

	public List<Institucion> getInstitucionesRecreativas() {
		List<Institucion> lista = null;
		DatoBasico datoInstitucion = servicioDatoBasico.buscarTipo(
				TipoDatoBasico.INSTITUCION, "Recreativa");
		if (datoInstitucion != null) {
			lista = servicioInstitucion.buscarInstitucionTipo(datoInstitucion);
		}
		return lista;
	}

	public void onClick$btnCatalogoJugador() {
		// se crea el catalogo y se llama
		Component catalogo = Executions.createComponents(
				"/Jugador/Vistas/frmBuscarJugador.zul", null, null);
		// asigna una referencia del formulario al catalogo.
		catalogo.setVariable("formulario", formulario, false);

		formulario.addEventListener("onCatalogoCerrado", new EventListener() {

			/* (non-Javadoc)
			 * @see org.zkoss.zk.ui.event.EventListener#onEvent(org.zkoss.zk.ui.event.Event)
			 */
			@Override
			public void onEvent(Event arg0) throws Exception {
				jugador = (Jugador) formulario.getVariable("jugador", false);
				txtCedula.setValue(jugador.getCedulaRif());
				txtPrimerNombre.setValue(jugador.getPersonaNatural().getPrimerNombre());
				txtSegundoNombre.setValue(jugador.getPersonaNatural().getSegundoNombre());
				txtPrimerApellido.setValue(jugador.getPersonaNatural().getPrimerApellido());
				txtSegundoApellido.setValue(jugador.getPersonaNatural().getSegundoApellido());
				txtGenero.setValue(jugador.getPersonaNatural().getDatoBasico().getNombre());				

				
				//PERSONALES
				java.util.Date date = new java.util.Date();
				date = jugador.getPersonaNatural().getFechaNacimiento();
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
				String fecha = sdf.format(date);
				txtFechaNac.setValue(fecha);				
				txtEdad.setValue(Util.calcularDiferenciaAnnios(date));
								
				cmbPaisNac.setValue(jugador.getDatoBasicoByCodigoPais().getNombre());
				cmbEstadoNac.setValue(jugador
						.getDatoBasicoByCodigoParroquiaNacimiento()
						.getDatoBasico().getDatoBasico().getNombre());				
				cmbMunicipioNac.setValue(jugador
						.getDatoBasicoByCodigoParroquiaNacimiento()
						.getDatoBasico().getNombre()); 
				cmbParroquiaNac.setValue(jugador
						.getDatoBasicoByCodigoParroquiaNacimiento()
						.getNombre());

				cmbEstadoResi.setValue(jugador.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia()
						.getDatoBasico().getDatoBasico().getNombre());
				cmbMunicipioResi.setValue(jugador.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia()
						.getDatoBasico().getNombre());
				cmbParroquiaResi.setValue(jugador.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia()
						.getNombre());

				txtDireccion.setValue(jugador.getPersonaNatural().getPersona().getDireccion());
				String telf = jugador.getPersonaNatural().getPersona().getTelefonoHabitacion();
				cmbCodArea.setValue(telf.substring(0,4));
				int numEntero = Integer.parseInt(telf.substring(5,telf.length()));
				txtTelefonoHabitacion.setValue(numEntero);
				
				String telfcel = jugador.getPersonaNatural().getCelular();
				cmbCodCelular.setValue(telfcel.substring(0,4));
				int numEnteroCel = Integer.parseInt(telfcel.substring(5,telfcel.length()));
				txtTelefonoCelular.setValue(numEnteroCel);				
				
				txtCorreo.setValue(jugador.getPersonaNatural().getPersona().getCorreoElectronico());
				txtTwitter.setValue(jugador.getPersonaNatural().getPersona().getTwitter());
	
				
				//DEPORTIVOS
				
				//txtPeso.setValue(jugador.getPeso());
				//txtAltura.setValue(jugador.getAltura());
				cmbBrazoLanzar.setValue(jugador.getBrazoLanzar());
				cmbPosicionBateo.setValue(jugador.getPosicionBateo());
				//cmbTallaCamisa
				//cmbTallaPantalon
				//cmbTallaCalzado
				
				
				
				//binder.loadAll();

			}
		});
	}

	public List<DatoBasico> getTallasCalzado() {
		List<DatoBasico> lista = null;
		DatoBasico datoIndumentaria = servicioDatoBasico.buscarTipo(
				TipoDatoBasico.INDUMENTARIA, "Calzado");
		if (datoIndumentaria != null) {
			lista = servicioDatoBasico.buscarDatosPorRelacion(datoIndumentaria);
		}
		return lista;
	}

	public List<DatoBasico> getTallasCamisa() {
		List<DatoBasico> lista = null;
		DatoBasico datoIndumentaria = servicioDatoBasico.buscarTipo(
				TipoDatoBasico.INDUMENTARIA, "Camisa");
		if (datoIndumentaria != null) {
			lista = servicioDatoBasico.buscarDatosPorRelacion(datoIndumentaria);
		}
		return lista;
	}

	public List<DatoBasico> getTallasPantalon() {
		List<DatoBasico> lista = null;
		DatoBasico datoIndumentaria = servicioDatoBasico.buscarTipo(
				TipoDatoBasico.INDUMENTARIA, "Pantalon");
		if (datoIndumentaria != null) {
			lista = servicioDatoBasico.buscarDatosPorRelacion(datoIndumentaria);
		}
		return lista;
	}

	// Eventos
	public void onClick$btnCatalogoMedico() {
		new Util().crearVentana(rutasJug + "buscarMedico.zul", null, null);
	}

	public void onChange$dtboxFechaNac() {
		//Date fecha = dtboxFechaNac.getValue();
		//txtEdad.setValue(Util.calcularDiferenciaAnnios(fecha));
	}

	public void onClick$btnGuardar() {

		
		
	}

	public void onClick$btnFoto() {
		new FileLoader().cargarImagenEnBean(imgJugador);
	}

	public void onChange$cmbTipoActualizacion() {
		String src = "";
		String valor = cmbTipoActualizacion.getSelectedItem().getLabel();
		Util enlace = new Util();
		if (valor.equalsIgnoreCase("DATOS MÉDICOS")) {
			src = "frmActualizarDatosMedicos.zul";
		} else if (valor.equalsIgnoreCase("AFECCIÓN")) {
			src = "frmActualizarAfeccion.zul";
		} else if (valor.equalsIgnoreCase("LESIÓN")) {
			src = "frmActualizarLesion.zul";
		}
		src = rutasJug + src;
		incCuerpo.setDynamicProperty("actualizacionMedica", actualizacionMedica);
		enlace.insertarContenido(incCuerpo, src);
	}

	public void onClick$btnAgregarInstitucion() {
		if ((cmbInstitucionEducativa.getSelectedIndex() >= 0)
				&& (cmbCurso.getSelectedIndex() >= 0)
				&& (cmbAnnioEscolar.getSelectedIndex() >= 0)) {
			for (int i = 0; i < nuevoCurso.size(); i++) {
				if ((cmbInstitucionEducativa.getSelectedItem().getLabel()
						.equals(nuevoCurso.get(i).getNombreInstitucion()))
						&& ((cmbAnnioEscolar.getSelectedItem().getLabel()
								.equals(nuevoCurso.get(i).getAnnoEscolar())))
						&& ((cmbCurso.getSelectedItem().getLabel()
								.equals(nuevoCurso.get(i).getCurso())))) {
					Mensaje.mostrarMensaje("Año Escolar Duplicado.",
							Mensaje.ERROR_DATOS, Messagebox.EXCLAMATION);
					return;
				}
			}

			nuevosCursos.setNombreInstitucion(cmbInstitucionEducativa
					.getSelectedItem().getLabel());
			nuevosCursos.setCodigoInstitucion(cmbInstitucionEducativa
					.getSelectedItem().getValue().toString());
			nuevosCursos.setAnnoEscolar(cmbAnnioEscolar.getSelectedItem()
					.getLabel());
			nuevosCursos.setCodigoAnno_Escolar(cmbAnnioEscolar
					.getSelectedItem().getValue().toString());
			nuevosCursos.setCurso(cmbCurso.getSelectedItem().getLabel());
			nuevosCursos.setCodigoCurso(cmbCurso.getSelectedItem().getValue()
					.toString());
			nuevoCurso.add(nuevosCursos);
			limpiarCurso();
		}
	}

	public void onClick$btnQuitarInstitucion() {
		if (listNuevosCursos.getSelectedIndex() >= 0) {
			NuevoCurso cursoSel = (NuevoCurso) listNuevosCursos
					.getSelectedItem().getValue();
			nuevoCurso.remove(cursoSel);
			limpiarCurso();
		} else {
			Mensaje.mostrarMensaje("Seleccione un dato para eliminar.",
					Mensaje.INFORMACION, Messagebox.EXCLAMATION);
		}
	}

	public void onClick$btnAgregarActividad() {
		if (cmbInstitucionRecreativa.getSelectedIndex() >= 0) {
			if (cmbActividad.getSelectedIndex() >= 0) {
				if (txtHorasSemanales.getValue() != null ? txtHorasSemanales
						.getValue() > 0 : false) {
					if (dtboxFechaInicioActividad.getText() != "") {
						for (int i = 0; i < datoSociales.size(); i++) {
							if ((cmbInstitucionRecreativa.getSelectedItem()
									.getLabel().equals(datoSociales.get(i)
									.getInstitucion().getNombre()))
									&& ((cmbActividad.getSelectedItem()
											.getLabel()
											.equals(datoSociales.get(i)
													.getDatoBasico()
													.getNombre())))) {
								Mensaje.mostrarMensaje(
										"Actividad Social Duplicada.",
										Mensaje.ERROR_DATOS,
										Messagebox.EXCLAMATION);
								return;
							}
						}
						datoSocial.setEstatus('A');
						datoSociales.add(datoSocial);
						limpiarActividad();
					} else {
						Mensaje.mostrarMensaje("Seleccione una fecha.",
								Mensaje.INFORMACION, Messagebox.EXCLAMATION);
						dtboxFechaInicioActividad.setFocus(true);
					}
				} else {
					Mensaje.mostrarMensaje(
							"Ingrese un número de horas semanales válidas.",
							Mensaje.INFORMACION, Messagebox.EXCLAMATION);
					txtHorasSemanales.setFocus(true);
				}
			} else {
				Mensaje.mostrarMensaje("Seleccione una actividad.",
						Mensaje.INFORMACION, Messagebox.EXCLAMATION);
				cmbActividad.setFocus(true);
			}
		} else {
			Mensaje.mostrarMensaje("Seleccione una institución.",
					Mensaje.INFORMACION, Messagebox.EXCLAMATION);
			cmbInstitucionRecreativa.setFocus(true);
		}
	}

	public void onClick$btnEliminarActividad() {
		if (listActividadesSociales.getSelectedIndex() >= 0) {
			DatoSocial actividadSel = (DatoSocial) listActividadesSociales
					.getSelectedItem().getValue();
			datoSociales.remove(actividadSel);
			limpiarActividad();
		} else {
			Mensaje.mostrarMensaje("Seleccione un dato para eliminar.",
					Mensaje.INFORMACION, Messagebox.EXCLAMATION);
		}
	}

	public void onClick$btnAgregarMotivo() {
		Listitem nuevoItem = new Listitem();
		nuevoItem.appendChild(new Listcell(this.cmbMotivo.getSelectedItem()
				.getLabel()));
		listMotivos.appendChild(nuevoItem);
	}

	// Metodos propios del ctrl
	public void limpiarCurso() {
		nuevosCursos = new NuevoCurso();
		cmbInstitucionEducativa.setSelectedIndex(-1);
		cmbCurso.setSelectedIndex(-1);
		cmbAnnioEscolar.setSelectedIndex(-1);
		binder.loadComponent(listNuevosCursos);
	}

	public void limpiarActividad() {
		datoSocial = new DatoSocial();
		cmbInstitucionRecreativa.setSelectedIndex(-1);
		cmbActividad.setSelectedIndex(-1);
		txtHorasSemanales.setValue(null);
		dtboxFechaInicioActividad.setValue(null);
		binder.loadComponent(listActividadesSociales);
	}

	public void limpiarMotivo() {
		sancionJugador = new SancionJugador();
		cmbMotivo.setSelectedIndex(-1);
		binder.loadComponent(listMotivos);
	}

	public void onClick$btnSalir() {
		winActualizarJugador.detach();
	}	
	
}
