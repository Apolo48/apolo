package controlador.jugador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.DatoAcademico;
import modelo.DatoBasico;
import modelo.DatoMedico;
import modelo.DatoSocial;
import modelo.Equipo;
import modelo.Medico;

import org.zkoss.image.AImage;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

import comun.Util;
import controlador.jugador.bean.Familiar;

/**
 * Clase controladora de los eventos de la vista de igual nombre y manejo de los
 * servicios de datos para la inscripcion de jugadores nuevo ingreso
 * 
 * @author Robert A
 * @author German L
 * @version 0.1 22/01/2012
 * 
 * */
public class CntrlVistaPreviaJugador extends GenericForwardComposer {
	private Window winVistaPreviaJugador;   
	private Component vista;
	private Label lblCedula;
	private Label lblPrimerNombre;
	private Label lblSegundoNombre;
	private Label lblPrimerApellido;
	private Label lblSegundoApellido;
	private Label lblGenero;
	private Image imgJugador;
	private Label lblFechaNac;
	private Label lblEdad;
	private Label lblPais;
	private Label lblEstado;
	private Label lblMunicipio;
	private Label lblParroquia;
	private Label lblEstadoResi;
	private Label lblMunicipioResi;
	private Label lblParroquiaResi;
	private Label lblDireccion;
	private Label lblTelefonoHabitacion;
	private Label lblTelefonoCelular;
	private Label lblCorreo;
	private Label lblTwitter;
	private Label lblGrupoSan;
	private Label lblMedico;
	private Label lblNumeroCol;
	private Label lblFechaRev;
	private Listbox listAfeccionesActuales;
	private Label lblObservacion;
	private Label lblInstitucion;
	private Label lblAnnoEsc;
	private Label lblCurso;
	private Listbox listActividadesSociales;
	private Label lblCategoria;
	private Label lblEquipo;
	private Label lblNumero;
	private Label lblPeso;
	private Label lblAltura;
	private Label lblBrazo;
	private Label lblPosicion;
	private Label lblCamisa;
	private Label lblPantalon;
	private Label lblCalzado;
	private Listbox listFamiliares;
	
	private AnnotateDataBinder binder;
	
	private controlador.jugador.bean.Jugador jugador;
	private Medico medico;
	private DatoMedico datoMedico = new DatoMedico();
	private List<DatoBasico> afeccionesJugador = new ArrayList<DatoBasico>();
	private DatoAcademico datoAcademico = new DatoAcademico();
	private List<DatoSocial> datoSociales = new ArrayList<DatoSocial>();
	private Categoria categoria = new Categoria();
	private Equipo equipo = new Equipo();
	private List<controlador.jugador.bean.Familiar> familiares = new ArrayList<controlador.jugador.bean.Familiar>();
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		vista = comp;
	}

	public void onCreate$winVistaPreviaJugador() {
		jugador = (controlador.jugador.bean.Jugador) vista.getVariable(
				"jugadorBean", false);
		medico = (Medico) vista.getVariable("medico", false);
		datoMedico = (DatoMedico) vista.getVariable("datoMedico", false);
		afeccionesJugador = (List<DatoBasico>) vista.getVariable("afeccionesJugador", false);
		datoAcademico = (DatoAcademico) vista.getVariable("datoAcademico", false);
		datoSociales = (List<DatoSocial>) vista.getVariable("datoSociales", false);
		categoria = (Categoria) vista.getVariable("categoria", false);
		equipo = (Equipo) vista.getVariable("equipo", false);
		familiares = (List<Familiar>) vista.getVariable("familiares", false);
		
		//mostrarValores(jugador);
		mostrarValores();
	}

	//private void mostrarValores(controlador.jugador.bean.Jugador jugador) {
	private void mostrarValores() {
		// Datos Basicos
		lblCedula.setValue(jugador.getCedulaCompleta());
		lblPrimerNombre.setValue(jugador.getPrimerNombre());
		lblSegundoNombre.setValue(jugador.getSegundoNombre());
		lblPrimerApellido.setValue(jugador.getPrimerApellido());
		lblSegundoApellido.setValue(jugador.getSegundoNombre());
		lblGenero.setValue(jugador.getGenero().getNombre());
		if (jugador.getFoto() != null) {
			try {
				AImage aImage = new AImage("foto.jpg", jugador.getFoto());
				imgJugador.setContent(aImage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (jugador.getFechaNacimiento() != null) {
			lblFechaNac.setValue(Util.convertirFecha(jugador.getFechaNacimiento(),"dd/MM/yyyy"));
			lblEdad.setValue(String.valueOf(Util.calcularDiferenciaAnnios(jugador.getFechaNacimiento())));
		}
		if (jugador.getPaisNac() != null) {
			lblPais.setValue(jugador.getPaisNac().getNombre());
		}
		if (jugador.getParroquiaNac() != null) {
			lblEstado.setValue(jugador.getParroquiaNac().getDatoBasico().getDatoBasico().getNombre());
			lblMunicipio.setValue(jugador.getParroquiaNac().getDatoBasico().getNombre());
			lblParroquia.setValue(jugador.getParroquiaNac().getNombre());
		}
		if (jugador.getParroquiaResi() != null) {
			lblEstadoResi.setValue(jugador.getParroquiaResi().getDatoBasico().getDatoBasico().getNombre());
			lblMunicipioResi.setValue(jugador.getParroquiaResi().getDatoBasico().getNombre());
			lblParroquiaResi.setValue(jugador.getParroquiaResi().getNombre());
		}
		lblDireccion.setValue(jugador.getDireccion());
		lblTelefonoHabitacion.setValue(jugador.getTelefonoHabitacion()
				.getTelefonoCompleto());
		lblTelefonoCelular.setValue(jugador.getTelefonoCelular()
				.getTelefonoCompleto());
		lblCorreo.setValue(jugador.getCorreoElectronico());
		lblTwitter.setValue(jugador.getTwitter());

		// Cargar Datos Medicos
		String tipoSangre = "";
		if (jugador.getTipoSangre().getGrupoSanguineo().getNombre() != null){
			tipoSangre += jugador.getTipoSangre().getGrupoSanguineo().getNombre();
		}
		if (jugador.getTipoSangre().getFactorRH().getNombre() != null){
			tipoSangre += jugador.getTipoSangre().getFactorRH().getNombre();
		}
		lblGrupoSan.setValue(tipoSangre);
		if (medico.getNombre() != null) {
			lblMedico.setValue(medico.getNombre() + " " + medico.getApellido());
		}
		lblNumeroCol.setValue(medico.getNumeroColegio());
		if (datoMedico.getFechaInforme() != null) {
			lblFechaRev.setValue(datoMedico.getFechaInforme().toString());
		}
		//listAfeccionesActuales;
		lblObservacion.setValue(datoMedico.getObservacion());
		
		//Datos Academicos
		if (datoAcademico.getInstitucion() != null) {
			lblInstitucion.setValue(datoAcademico.getInstitucion().getNombre());
		}
		if (datoAcademico.getDatoBasicoByCodigoAnnoEscolar() != null) {
			lblAnnoEsc.setValue(datoAcademico.getDatoBasicoByCodigoAnnoEscolar().getNombre());
		}
		if (datoAcademico.getDatoBasicoByCodigoCurso() != null) {
			lblCurso.setValue(datoAcademico.getDatoBasicoByCodigoCurso().getNombre());
		}
		
		//Datos Sociales
		//for (int i = 0; i < datoSociales.size(); i++) {
		//listActividadesSociales;
		
		//Datos Deportivos
		lblCategoria.setValue(categoria.getNombre());
		lblEquipo.setValue(equipo.getNombre());
		lblNumero.setValue(String.valueOf(jugador.getNumero()));
		lblPeso.setValue(String.valueOf(jugador.getPeso()));
		lblAltura.setValue(String.valueOf(jugador.getAltura()));
		if (jugador.getBrazoLanzar() != null) {
			lblBrazo.setValue(jugador.getBrazoLanzar().getNombre());
		}
		if (jugador.getPosicionBateo() != null) {
			lblPosicion.setValue(jugador.getPosicionBateo().getNombre());
		}
		if (jugador.getTallaCamisa() != null) {
			lblCamisa.setValue(jugador.getTallaCamisa().getNombre());;
		}
		if (jugador.getTallaPantalon() != null) {
			lblPantalon.setValue(jugador.getTallaPantalon().getNombre());
		}
		if (jugador.getTallaCalzado() != null) {
			lblCalzado.setValue(jugador.getTallaCalzado().getNombre());
		}
		
		// Datos de Familiares
		//listFamiliares;

	}

	public controlador.jugador.bean.Jugador getJugador() {
		return jugador;
	}

	public void setJugador(controlador.jugador.bean.Jugador jugadorBean) {
		this.jugador = jugadorBean;
	}
	
	public void onClick$btnSalir(){
		winVistaPreviaJugador.detach();
	}

}
