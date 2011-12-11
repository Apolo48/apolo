package controlador.jugador;

import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Tab;

import servicio.jugador.ServicioCategoria;
import servicio.jugador.ServicioCurso;

import comun.FileLoader;
import comun.Rutas;
import comun.Util;
import modelo.Categoria;
import modelo.Curso;


/**
 * Clase controladora de los eventos de la vista de igual nombre y manejo de los servicios de datos.
 * 
 * @author Robert A 
 * @author German L
 * @version 0.2 22/11/2011
 *
 * */
public class RegistrarJugadorCtrl extends GenericForwardComposer {
	private Datebox dtboxFechaNac;
	private Intbox txtEdad;
	private Button btnGuardar;
	private Button btnAntes;
	private Button btnDesp;
	private Button btnVistaPrevia;
	private Tab tabRegJugador;
	private Tab tabRegFamiliar;
	private Textbox txtPrimerNombre;
	private Button btnCatalogoMedico;
	private Image imgJugador;
	private Image imgFamiliar;
	private Combobox cmbNacionalidadFamiliar;
	private ServicioCurso servicioCurso;
	private ServicioCategoria servicioCategoria;
	private String rutasJug= Rutas.JUGADOR.getRutaVista();

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false); // Hacemos visible el
														// modelo para el
														// databinder
	}
	
	public List<Categoria> getCategorias() {
		return servicioCategoria.listar();
	}

	public List<Curso> getCursos(){
		return servicioCurso.listar();
	}

	public void onChange$dtboxFechaNac() {
		Date fecha = dtboxFechaNac.getValue();
		txtEdad.setValue(Util.calcularDiferenciaAnnios(fecha));
	}

	public void onClick$btnGuardar() {
		new Util().crearVentana(rutasJug+"vistaCompromisoPago.zul",
				null, null);
		
	}
	public void onClick$btnVistaPrevia() {
		new Util().crearVentana(rutasJug+"vistaRegistroJugador.zul",
				null, null);
	}

	public void onClick$btnDesp() {
		isFirstStepComplete();
	}

	public void onClick$btnAntes() {
		moveStep(false);
	}
	
	public void onClick$btnCatalogoMedico() {
		new Util().crearVentana(rutasJug+"buscarMedico.zul", null, null);
	}
	
	public void onClick$btnCatalogoInstitucionRecreativa() {
		new Util().crearVentana(rutasJug+"buscarInstitucion.zul", null, null);
	}

	public void onClick$btnCatalogoInstitucionEducativa() {
		new Util().crearVentana(rutasJug+"buscarInstitucion.zul", null, null);
	}

	public void onClick$btnFoto() {
		new FileLoader().cargarImagen(imgJugador);
	}
	public void onClick$btnFotoFamiliar() {
		new FileLoader().cargarImagen(imgFamiliar);
	}
	
	public void onClick$btnCatalogoFamiliar() {
		new Util().crearVentana(rutasJug+"buscarFamiliar.zul", null, null);
	}
	
	private void moveStep(boolean flag) {
		tabRegJugador.setVisible(!flag);
		tabRegFamiliar.setVisible(flag);
		if (flag) {
			tabRegFamiliar.setSelected(flag);
			cmbNacionalidadFamiliar.setFocus(true);
		} else {
			tabRegJugador.setSelected(!flag);
		}
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
}
