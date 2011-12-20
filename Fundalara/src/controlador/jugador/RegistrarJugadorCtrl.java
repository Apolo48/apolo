package controlador.jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Tab;

import servicio.jugador.ServicioCategoria;
import servicio.jugador.ServicioDatoBasico;
import servicio.jugador.ServicioRecaudoPorProceso;
import servicio.jugador.ServicioInstitucion;

import comun.FileLoader;
import comun.Ruta;
import comun.Util;
import comun.TipoDatoBasico;
import controlador.jugador.bean.ActividadSocial;
import controlador.jugador.bean.Afeccion;
import modelo.AfeccionJugador;
import modelo.Categoria;
import modelo.DatoBasico;
import modelo.DatoMedico;
import modelo.Institucion;
import modelo.Jugador;
import modelo.RecaudoPorProceso;

/**
 * Clase controladora de los eventos de la vista de igual nombre y manejo de los
 * servicios de datos para la inscripcion de jugadores nuevo ingreso
 * 
 * @author Robert A
 * @author German L
 * @version 0.2.1 17/12/2011 
 * 
 * */
public class RegistrarJugadorCtrl extends GenericForwardComposer {
	// Componentes visuales
	private Datebox dtboxFechaNac;
	private Datebox dtboxFechaInicioActividad;
	private Button btnGuardar;
	private Button btnAntes;
	private Button btnDesp;
	private Button btnVistaPrevia;
	private Button btnFoto;
	private Button btnCatalogoMedico;
	private Button btnAgregarAfeccion;
	private Button btnEliminarAfeccion;
	private Button btnAgregarActividad;
	private Button btnEliminarActividad;
	private Tab tabRegJugador;
	private Tab tabRegFamiliar;
	private Intbox txtEdad;
	private Intbox txtCedulaSecuencia;
	private Intbox txtCedula;
	private Intbox txtHorasSemanales;
	private Textbox txtPrimerNombre;
	private Textbox txtPrimerApellido;
	private Textbox txtSegundoNombre;
	private Textbox txtSegundoApellido;
	private Image imgJugador;
	private Image imgFamiliar;
	private Combobox cmbNacionalidadFamiliar;
	private Combobox cmbNacionalidad;
	private Combobox cmbGenero;
	private Combobox cmbEstadoNac;
	private Combobox cmbMunicipioNac;
	private Combobox cmbParroquiaNac;
	private Combobox cmbParroquiaResi;
	private Combobox cmbMunicipioResi;
	private Combobox cmbAfecciones;
	private Combobox cmbInstitucionRecreativa;
	private Combobox cmbActividad;
	private Label lblSeparador;
	private Listbox listAfeccionesActuales;
	private Listbox listActividadesSociales;

	private String rutasJug = Ruta.JUGADOR.getRutaVista();

	// Servicios
	private ServicioDatoBasico servicioDatoBasico;
	private ServicioCategoria servicioCategoria;
	private ServicioRecaudoPorProceso servicioRecaudoPorProceso;
	private ServicioInstitucion servicioInstitucion;

	// Modelos
	private Jugador jugador = new Jugador();
	private DatoBasico estadoVenezuela = new DatoBasico();
	private DatoBasico estadoVenezuelaResi = new DatoBasico();
	private DatoBasico municipioNac = new DatoBasico();
	private DatoBasico municipioResi = new DatoBasico();
	private DatoMedico datoMedico = new DatoMedico();
	private DatoBasico institucionEducativa = new DatoBasico();
	private DatoBasico institucionRecreativa = new DatoBasico();
	private DatoBasico tipoInscripcion = new DatoBasico();
	private RecaudoPorProceso recaudoAcademico = new RecaudoPorProceso();
	private RecaudoPorProceso recaudoMedico = new RecaudoPorProceso();
	private RecaudoPorProceso recaudoPersonal = new RecaudoPorProceso();
	
	private Afeccion afeccion = new Afeccion();
	List<Afeccion> afeccionesJugador = new ArrayList<Afeccion>();
	private ActividadSocial actividadSocial = new ActividadSocial();
	List<ActividadSocial> actividadesJugador = new ArrayList<ActividadSocial>();

	// Binder
	private AnnotateDataBinder binder;
	/**
	 * Mantiene un Map con todos los atributos asociados a la ejecucion actual
	 */
	private Map<String, Object>  requestScope;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		this.tipoInscripcion= (DatoBasico) requestScope.get("tipoInscripcion");
	}

	// Getters y setters
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
	
	public List<ActividadSocial> getActividadesJugador() {
		return actividadesJugador;
	}

	public void setActividadesJugador(List<ActividadSocial> actividadesJugador) {
		this.actividadesJugador = actividadesJugador;
	}

	// Metodos para carga de combos/listbox
	public List<Categoria> getCategorias() {
		return servicioCategoria.listar();
	}

	public List<DatoBasico> getCursos() {
		return servicioDatoBasico.listar(TipoDatoBasico.CURSO);
	}
	
	public List<DatoBasico> getAnnoEsc() {
		return servicioDatoBasico.listar(TipoDatoBasico.ANNO_ESCOLAR);
	}

	public List<DatoBasico> getActividadSoc() {
		return servicioDatoBasico.listar(TipoDatoBasico.ACTIVIDAD_SOCIAL);
	}

	public List<DatoBasico> getEstadosVenezuela() {
		return servicioDatoBasico.listar(TipoDatoBasico.ESTADO_VENEZUELA);
	}

	public List<DatoBasico> getPaises() {
		return servicioDatoBasico.listar(TipoDatoBasico.PAIS);
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
	
	public List<RecaudoPorProceso> getRecaudosPersonales() {
		return servicioRecaudoPorProceso.buscarPorProceso(this.tipoInscripcion, TipoDatoBasico.RECAUDOS_PERSONALES);
	}
	
	public List<RecaudoPorProceso> getRecaudosAcademicos() {
		return servicioRecaudoPorProceso.buscarPorProceso(this.tipoInscripcion, TipoDatoBasico.RECAUDOS_ACADEMICOS);
	}
	
	public List<RecaudoPorProceso> getRecaudosMedicos() {
		return servicioRecaudoPorProceso.buscarPorProceso(this.tipoInscripcion, TipoDatoBasico.RECAUDOS_MEDICOS);
	}
	
	public List<Institucion> getInstitucionesEducativas() {
	/*	List<DatoBasico> datoInstitucion = servicioDatoBasico.buscarTipo(TipoDatoBasico.INSTITUCION, "Educativa");
		if (datoInstitucion.isEmpty()) {
			return null;
		}
		else{
			return servicioInstitucion.buscarInstitucionTipo(datoInstitucion.get(datoInstitucion.size()-1));
		}*/
		List<Institucion> lista=null;
		DatoBasico datoInstitucion = servicioDatoBasico.buscarTipo(TipoDatoBasico.INSTITUCION, "Educativa");
		if (datoInstitucion!=null) {
			lista= servicioInstitucion.buscarInstitucionTipo(datoInstitucion);
		}
		
		return lista;
	}
	
	public List<Institucion> getInstitucionesRecreativas() {
		List<Institucion> lista=null;
		DatoBasico datoInstitucion = servicioDatoBasico.buscarTipo(TipoDatoBasico.INSTITUCION, "Recreativa");
		if (datoInstitucion!=null) {
			lista= servicioInstitucion.buscarInstitucionTipo(datoInstitucion);
		}
		return lista;
		/*
		List<DatoBasico> datoInstitucion = servicioDatoBasico.buscarTipo(TipoDatoBasico.INSTITUCION, "Recreativa");
		if (datoInstitucion.isEmpty()) {
			return null;
		}
		else{
			return servicioInstitucion.buscarInstitucionTipo(datoInstitucion.get(datoInstitucion.size()-1));
		}*/
	}
	
	public List<DatoBasico> getAfecciones() {
		List<DatoBasico> lista =null;
		DatoBasico datoAfeccion = servicioDatoBasico.buscarTipo(TipoDatoBasico.TIPO_AFECCION, "Afeccion");
		if (datoAfeccion!=null) {
			lista =servicioDatoBasico.buscarDatosPorRelacion(datoAfeccion);
		}
		return lista;
		/*
		List<DatoBasico> datoAfeccion = servicioDatoBasico.buscarTipo(TipoDatoBasico.TIPO_AFECCION, "Afeccion");
		if (datoAfeccion.isEmpty()) {
			return null;
		}
		else{
			return servicioDatoBasico.buscarDatosPorRelacion(datoAfeccion.get(datoAfeccion.size()-1));
		}*/
	}

	// Eventos
	public void onClick$btnCatalogoMedico() {
		new Util().crearVentana(rutasJug + "buscarMedico.zul", null, null);
	}

	public void onChange$dtboxFechaNac() {
		Date fecha = dtboxFechaNac.getValue();
		txtEdad.setValue(Util.calcularDiferenciaAnnios(fecha));
	}

	public void onChange$cmbNacionalidad() {
		boolean flag = false;
		if (cmbNacionalidad.getSelectedItem().getValue().equals("R")) {
			flag = true;
		}
		lblSeparador.setVisible(flag);
		txtCedulaSecuencia.setVisible(flag);
	}

	public void onClick$btnGuardar() {
		new Util().crearVentana(rutasJug + "vistaCompromisoPago.zul", null,
				null);
	}

	public void onClick$btnVistaPrevia() {
		new Util().crearVentana(rutasJug + "vistaRegistroJugador.zul", null,
				null);
	}

	public void onClick$btnDesp() {
		isFirstStepComplete();
	}

	public void onClick$btnAntes() {
		moveStep(false);
	}

	public void onClick$btnFoto() {
		new FileLoader().cargarImagenEnBean(imgJugador);
	}

	public void onClick$btnFotoFamiliar() {
		new FileLoader().cargarImagen(imgFamiliar);
	}

	public void onClick$btnCatalogoFamiliar() {
		new Util().crearVentana(rutasJug + "buscarFamiliar.zul", null, null);
	}
	
	public void onClick$btnAgregarAfeccion(){
		if (cmbAfecciones.getSelectedIndex() >= 0){
			for (int i = 0; i < afeccionesJugador.size(); i++) {
				if(cmbAfecciones.getSelectedItem().getLabel().equals(afeccionesJugador.get(i).getNombre())){
					alert("Afección Duplicada");
					return;
				}
			}
	
			afeccion.setCodigo(cmbAfecciones.getSelectedItem().getValue().toString());
			afeccion.setNombre(cmbAfecciones.getSelectedItem().getLabel());
			afeccionesJugador.add(afeccion);
			limpiarAfeccion();
			
		}
	}
	
	public void limpiarAfeccion(){
		afeccion= new Afeccion();
		cmbAfecciones.setSelectedIndex(-1);
		binder.loadComponent(listAfeccionesActuales);
	}
	
	public void onClick$btnEliminarAfeccion(){
		if (listAfeccionesActuales.getSelectedIndex() >= 0){
			Afeccion afeccionSel = (Afeccion) listAfeccionesActuales.getSelectedItem().getValue();
			afeccionesJugador.remove(afeccionSel);
			limpiarAfeccion();
		}
		else{
			alert("Seleccione un dato para eliminar");
		}
	}
	
	public void onClick$btnAgregarActividad(){
		if ((cmbInstitucionRecreativa.getSelectedIndex() >= 0)
			&& (cmbActividad.getSelectedIndex() >= 0)
			&& (txtHorasSemanales.getValue() > 0)
			&& (dtboxFechaInicioActividad.getText() != "")){
			for (int i = 0; i < actividadesJugador.size(); i++) {
				if((cmbInstitucionRecreativa.getSelectedItem().getLabel().equals(actividadesJugador.get(i).getNombreInstitucion()))
					|| ((cmbActividad.getSelectedItem().getLabel().equals(actividadesJugador.get(i).getActividad())))){
					alert("Actividad Social Duplicada");
					return;
				}
			}
	
			actividadSocial.setNombreInstitucion(cmbInstitucionRecreativa.getSelectedItem().getLabel());
			actividadSocial.setCodigoInstitucion(cmbInstitucionRecreativa.getSelectedItem().getValue().toString());
			actividadSocial.setActividad(cmbActividad.getSelectedItem().getLabel());
			actividadSocial.setCodigoActividad(cmbActividad.getSelectedItem().getValue().toString());
			actividadSocial.setFechaInicio(dtboxFechaInicioActividad.getText());
			actividadSocial.setHorasDedicadas(txtHorasSemanales.getValue());
			actividadesJugador.add(actividadSocial);
			limpiarActividad();
		}
	}
	
	public void limpiarActividad(){
		actividadSocial = new ActividadSocial();
		cmbInstitucionRecreativa.setSelectedIndex(-1);
		cmbActividad.setSelectedIndex(-1);
		txtHorasSemanales.setValue(null);
		dtboxFechaInicioActividad.setValue(null);
		binder.loadComponent(listActividadesSociales);
	}
	
	public void onClick$btnEliminarActividad(){
		if (listActividadesSociales.getSelectedIndex() >= 0){
			ActividadSocial actividadSel = (ActividadSocial) listActividadesSociales.getSelectedItem().getValue();
			actividadesJugador.remove(actividadSel);
			limpiarActividad();
		}
		else{
			alert("Seleccione un dato para eliminar");
		}
	}

	// Metodos propios del ctrl

	private void moveStep(boolean flag) {
		tabRegJugador.setVisible(!flag);
		tabRegFamiliar.setVisible(flag);
		if (flag) {
			tabRegFamiliar.setSelected(flag);
			cmbNacionalidadFamiliar.setFocus(true);

		} else {
			tabRegJugador.setSelected(!flag);
		}
		inhabilitarPerfil(flag);
		btnAntes.setVisible(flag);
		btnGuardar.setVisible(flag);
		btnDesp.setVisible(!flag);
	}

	/**
	 * Valida que se haya completado la primera fase de la inscripcion
	 */
	private void isFirstStepComplete() {
		if (txtPrimerNombre.isValid())
			moveStep(true);
		else {
			try {
				Messagebox.show(
						"Existen campos obligatorios, por favor verifique.",
						"Fundalara", Messagebox.OK, Messagebox.EXCLAMATION);
				txtPrimerNombre.setFocus(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void inhabilitarPerfil(boolean flag) {
		cmbNacionalidad.setDisabled(flag);
		txtCedula.setDisabled(flag);
		txtCedulaSecuencia.setDisabled(flag);
		txtPrimerApellido.setDisabled(flag);
		txtPrimerNombre.setDisabled(flag);
		txtSegundoApellido.setDisabled(flag);
		txtSegundoNombre.setDisabled(flag);
		cmbGenero.setDisabled(flag);
		// btnFoto.setDisabled(flag);
	}
}
