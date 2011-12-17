package controlador.jugador;

import java.util.Date;
import java.util.List;

import org.python.apache.xerces.impl.xpath.regex.REUtil;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Tab;

import servicio.compentencia.ServicioDivisa;
import servicio.jugador.ServicioAfeccionJugador;
import servicio.jugador.ServicioCategoria;
/*
import servicio.jugador.ServicioClasificacionEquipo;
import servicio.jugador.ServicioCurso;
import servicio.jugador.ServicioEstadoVenezuela;
import servicio.jugador.ServicioMunicipio;
import servicio.jugador.ServicioPais;
import servicio.jugador.ServicioParroquia;
import servicio.jugador.ServicioTipoAfeccion;
*/
import comun.FileLoader;
import comun.Rutas;
import comun.Util;
import modelo.AfeccionJugador;
import modelo.Categoria;
//import modelo.Curso;
import modelo.DatoMedico;
import modelo.Divisa;
import modelo.Equipo;
//import modelo.EstadoVenezuela;
import modelo.Jugador;
/*import modelo.Municipio;
import modelo.Pais;
import modelo.Parroquia;
import modelo.TipoAfeccion;
*/
/**
 * Clase controladora de los eventos de la vista de igual nombre y manejo de los
 * servicios de datos para la inscripcion de jugadores nuevo ingreso
 * 
 * @author Robert A
 * @author German L
 * @version 0.2 22/11/2011
 * 
 * */
public class RegistrarJugadorCtrl extends GenericForwardComposer {
	// Componentes visuales
	private Datebox dtboxFechaNac;
	private Button btnGuardar;
	private Button btnAntes;
	private Button btnDesp;
	private Button btnVistaPrevia;
	private Button btnFoto;
	private Button btnCatalogoMedico;
	private Tab tabRegJugador;
	private Tab tabRegFamiliar;
	private Intbox txtEdad;
	private Intbox txtCedulaSecuencia;
	private Intbox txtCedula;
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
	private Label lblSeparador;

	private String rutasJug = Rutas.JUGADOR.getRutaVista();
/*
	// Servicios
	private ServicioCurso servicioCurso;
	private ServicioCategoria servicioCategoria;
	ServicioEstadoVenezuela servicioEstadoVenezuela;
	private ServicioMunicipio servicioMunicipio;
	private ServicioParroquia servicioParroquia;
	private ServicioPais servicioPais;
	private ServicioTipoAfeccion servicioTipoAfeccion;
	*/
	// Model
	private Jugador jugador = new Jugador();
/*	private EstadoVenezuela estadoVenezuela = new EstadoVenezuela();
	private EstadoVenezuela estadoVenezuelaResi = new EstadoVenezuela();
	private Municipio municipioNac = new Municipio();
	private Municipio municipioResi = new Municipio();
	private DatoMedico datoMedico = new DatoMedico();
	private List<TipoAfeccion> afeccionesActuales;
	private List<AfeccionJugador> afeccionJugador;// = new AfeccionJugador();
	/*/
	// Binder
	private AnnotateDataBinder binder;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false); // Hacemos visible el
														// modelo para el
														// databinder
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public List<Categoria> getCategorias() {
		return null;
				//servicioCategoria.listar();
	}

	public List getCursos() {
		return null;
				//servicioCurso.listar();
	}

	public List getEstadosVenezuela() {
		return null;
				//servicioEstadoVenezuela.listar();
	}

	public List getPaises() {
		return null;
				//servicioPais.listar();
	}
/*	
	public List<TipoAfeccion> getAfecciones() {
		return servicioTipoAfeccion.listar();
	}
	
	public EstadoVenezuela getEstadoVenezuela() {
		return estadoVenezuela;
	}

	public void setEstadoVenezuela(EstadoVenezuela estado) {
		this.estadoVenezuela = estado;
	}

	public Municipio getMunicipioNac() {
		return municipioNac;
	}

	public void setMunicipioNac(Municipio municipioNac) {
		this.municipioNac = municipioNac;
	}

	public Combobox getCmbParroquiaResi() {
		return cmbParroquiaResi;
	}

	public void setCmbParroquiaResi(Combobox cmbParroquiaResi) {
		this.cmbParroquiaResi = cmbParroquiaResi;
	}

	public Combobox getCmbMunicipioResi() {
		return cmbMunicipioResi;
	}

	public void setCmbMunicipioResi(Combobox cmbMunicipioResi) {
		this.cmbMunicipioResi = cmbMunicipioResi;
	}

	public EstadoVenezuela getEstadoVenezuelaResi() {
		return estadoVenezuelaResi;
	}

	public void setEstadoVenezuelaResi(EstadoVenezuela estadoVenezuelaResi) {
		this.estadoVenezuelaResi = estadoVenezuelaResi;
	}

	public Municipio getMunicipioResi() {
		return municipioResi;
	}

	public void setMunicipioResi(Municipio municipioResi) {
		this.municipioResi = municipioResi;
	}

	public List<TipoAfeccion> getAfeccionesActuales() {
		return afeccionesActuales;
	}

	public void setAfeccionesActuales(List<TipoAfeccion> afeccionesActuales) {
		this.afeccionesActuales = afeccionesActuales;
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

	public void onChange$cmbEstadoNac() {
		cmbMunicipioNac.setValue("--Seleccione--");
		binder.loadAttribute(cmbMunicipioNac, "model");
	}

	public List<Municipio> getMunicipiosEstados() {
		List<Municipio> lista = servicioMunicipio.buscar(estadoVenezuela);
		return lista;
	}

	public List<Municipio> getMunicipiosEstadosResi() {
		List<Municipio> lista = servicioMunicipio.buscar(estadoVenezuelaResi);
		return lista;
	}

	public void onChange$cmbMunicipioNac() {
		cmbParroquiaNac.setValue("--Seleccione--");
		binder.loadAttribute(cmbParroquiaNac, "model");
	}

	public List<Parroquia> getParroquiasMunicipio() {
		List<Parroquia> lista = servicioParroquia.buscar(municipioNac);
		return lista;
	}

	public List<Parroquia> getParroquiasMunicipioResi() {
		List<Parroquia> lista = servicioParroquia.buscar(municipioResi);
		return lista;
	}

	public DatoMedico getDatoMedico() {
		return datoMedico;
	}

	public void setDatoMedico(DatoMedico datoMedico) {
		this.datoMedico = datoMedico;
	}

/*	public AfeccionJugador getAfeccionJugador() {
		return afeccionJugador;
	}

	public void setAfeccionJugador(AfeccionJugador afeccionJugador) {
		this.afeccionJugador = afeccionJugador;
	}

	public void onChange$cmbEstadoResi() {
		cmbMunicipioResi.setValue("--Seleccione--");
		binder.loadAttribute(cmbMunicipioResi, "model");
	}

	public void onChange$cmbMunicipioResi() {
		cmbParroquiaResi.setValue("--Seleccione--");
		binder.loadAttribute(cmbParroquiaResi, "model");
	}

	public void onClick$btnCatalogoMedico() {
		new Util().crearVentana(rutasJug + "buscarMedico.zul", null, null);
	}

	public void onClick$btnCatalogoInstitucionRecreativa() {
		new Util().crearVentana(rutasJug + "buscarInstitucion.zul", null, null);
	}

	public void onClick$btnCatalogoInstitucionEducativa() {
		new Util().crearVentana(rutasJug + "buscarInstitucion.zul", null, null);
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
*/
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
	
	private void inhabilitarPerfil(boolean flag){
		cmbNacionalidad.setDisabled(flag);
		txtCedula.setDisabled(flag);
		txtCedulaSecuencia.setDisabled(flag);
		txtPrimerApellido.setDisabled(flag);
		txtPrimerNombre.setDisabled(flag);
		txtSegundoApellido.setDisabled(flag);
		txtSegundoNombre.setDisabled(flag);
		cmbGenero.setDisabled(flag);
		//btnFoto.setDisabled(flag);
	}
}

