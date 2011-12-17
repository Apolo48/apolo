package controlador.jugador;

import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Tab;

import servicio.jugador.ServicioCategoria;
import servicio.jugador.ServicioDatoBasico;

import comun.FileLoader;
import comun.Ruta;
import comun.Util;
import comun.TipoDatoBasico;
import modelo.AfeccionJugador;
import modelo.Categoria;
import modelo.DatoBasico;
import modelo.DatoMedico;
import modelo.Jugador;

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

	private String rutasJug = Ruta.JUGADOR.getRutaVista();

	// Servicios
	private ServicioDatoBasico servicioDatoBasico;
	private ServicioCategoria servicioCategoria;

	// Modelos
	private Jugador jugador = new Jugador();
	private DatoBasico estadoVenezuela = new DatoBasico();
	private DatoBasico estadoVenezuelaResi = new DatoBasico();
	private DatoBasico municipioNac = new DatoBasico();
	private DatoBasico municipioResi = new DatoBasico();
	private DatoMedico datoMedico = new DatoMedico();
	// private List<TipoAfeccion> afeccionesActuales;
	// private List<AfeccionJugador> afeccionJugador;// = new AfeccionJugador();

	// Binder
	private AnnotateDataBinder binder;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
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

	// Metodos para carga de combos/listbox

	public List<Categoria> getCategorias() {
		return servicioCategoria.listar();
	}

	public List<DatoBasico> getCursos() {
		return servicioDatoBasico.listar(TipoDatoBasico.PAIS);
	}

	public List<DatoBasico> getEstadosVenezuela() {
		return servicioDatoBasico.listar(TipoDatoBasico.ESTADO_VENEZUELA);
	}

	public List<DatoBasico> getPaises() {
		return servicioDatoBasico.listar(TipoDatoBasico.PAIS);
	}

	public List<DatoBasico> getAfecciones() {
		return servicioDatoBasico.listar(TipoDatoBasico.PAIS);
	}

	public List<DatoBasico> getInstitucionesEducativas() {
		return servicioDatoBasico.listar(TipoDatoBasico.PAIS);
	}

	public List<DatoBasico> getInstitucionesRecreativas() {
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

	public void onChange$cmbEstadoResi() {
		cmbMunicipioResi.setValue("--Seleccione--");
		binder.loadAttribute(cmbMunicipioResi, "model");
	}

	public void onChange$cmbMunicipioResi() {
		cmbParroquiaResi.setValue("--Seleccione--");
		binder.loadAttribute(cmbParroquiaResi, "model");
	}

	public void onChange$cmbEstadoNac() {
		cmbMunicipioNac.setValue("--Seleccione--");
		binder.loadAttribute(cmbMunicipioNac, "model");
	}

	public void onChange$cmbMunicipioNac() {
		cmbParroquiaNac.setValue("--Seleccione--");
		binder.loadAttribute(cmbParroquiaNac, "model");
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
