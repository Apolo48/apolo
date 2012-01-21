package controlador.jugador;

import java.util.Date;
import java.util.List;

import modelo.Categoria;
import modelo.DatoBasico;
import modelo.Equipo;
import modelo.JugadorPlan;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioDatoBasico;
import servicio.implementacion.ServicioEquipo;

import comun.TipoDatoBasico;
import comun.Util;

/**
 * Clase controladora de los eventos de la vista Plan Vacacional.
 * 
 * @author Maria F,Luis D
 * @version 1.0 26/11/2011
 */

public class CntrlRegistrarPlanVacacional extends GenericForwardComposer {
	private Combobox cmbTurno;
	private Combobox cmbHorario;
	private Combobox cmbEquipo;
	private Combobox cmbTipoJugador;
	private Combobox cmbCategoria;
	private Combobox cmbTalla;
	private Combobox cmbCodArea;
	private Combobox cmbCodCelular;
	private Combobox cmbNacionalidad;
	private Combobox cmbNacionalidadF;
	private Datebox dtboxFechaNac;
	private Intbox txtCedula;
	private Intbox txtCedulaSecuencia;
	private Intbox txtEdad;
	private Intbox txtTelefono;
	private Intbox txtCelular;
	private Intbox txtCedulaF;
	private Textbox txtNombre;
	private Textbox txtApellido;
	private Textbox txtNombreRepr;
	private Textbox txtApellidoRepr;
	private Button btnCatalogoJugador;
	private Button btnGuardar;
	private Button btnModificar;
	private Button btnEliminar;
	private Button btnCancelar;
	private Button btnSalir;
	private Window winRegistrarPlanVacacional;
	
	private JugadorPlan jugadorPlan= new JugadorPlan();
	private Categoria categoria = new Categoria();
	private Equipo equipo= new Equipo();
	
	// Servicios
	private ServicioDatoBasico servicioDatoBasico;
	private ServicioDatoBasico Jugador;
	private ServicioCategoria servicioCategoria;
	private ServicioEquipo servicioEquipo;
	
	//Modelos
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false); // Hacemos visible el
														// modelo para el
														// databinder
	}
	
	
/*Habilita o deshabilita los campos de la vista.*/
	
	private void disabledFields(boolean flag) {
		txtNombre.setDisabled(flag);   
		txtApellido.setDisabled(flag);
		dtboxFechaNac.setDisabled(flag);
		cmbTipoJugador.setDisabled(flag);
		cmbCategoria.setDisabled(flag);
		cmbEquipo.setDisabled(flag);
		cmbNacionalidad.setDisabled(flag);
		cmbNacionalidadF.setDisabled(flag);
		txtCedula.setDisabled(flag);
		txtCedulaF.setDisabled(flag);
		txtNombreRepr.setDisabled(flag);
		txtApellidoRepr.setDisabled(flag);
		cmbCodArea.setDisabled(flag);
		txtTelefono.setDisabled(flag);
		cmbCodCelular.setDisabled(flag);
		txtCelular.setDisabled(flag);
	}

	
	/**
	 * Coloca visible o no el boton buscar y habilita o deshabilita los campos
	 * segun la seleccion del combo Tipo Alumno.
	 */
	private void visibleButton(boolean flag) {
		if (cmbTipoJugador.getSelectedItem().getValue().equals("REGULAR")) {
			btnCatalogoJugador.setVisible(flag);
			btnCatalogoJugador.setFocus(true);
			/*Deshabilita los campos*/
			disabledFields(flag);
		}

		else {
			btnCatalogoJugador.setVisible(!flag);
			txtCedula.setFocus(true);
			/*Habilita los campos*/
			disabledFields(!flag);
		}
	}

	
	
	/**
	 * Muestra la vista del compromiso de pago si se han 
	 * introducido los campos, sino muestra un mensaje.
	 */
	private void viewcompromiso() {
		if (txtNombre.getValue().equals("")) {
			try {
				Messagebox.show(
						"Existen campos obligatorios, por favor verifique.",
						"Fundalara", Messagebox.OK, Messagebox.EXCLAMATION);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		else if (txtApellido.getValue().equals("")) {
			try {
				Messagebox.show(
						"Existen campos obligatorios, por favor verifique.",
						"Fundalara", Messagebox.OK, Messagebox.EXCLAMATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if (txtNombreRepr.getValue().equals("")) {
			try {
				Messagebox.show(
						"Existen campos obligatorios, por favor verifique.",
						"Fundalara", Messagebox.OK, Messagebox.EXCLAMATION);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		else {
			new Util().crearVentana("Jugador/Vistas/frmVistaCompromisoPago.zul",
					null, null);
		}
	}

	public void onChange$cmbTipoAlumno() {
		visibleButton(true);
	}

	public void onClick$btnGuardar() {
		viewcompromiso();
	}
	
	public void onClick$btnCancelar() {
		/*plan= new PlanVacacional();
		binder.loadAll();*/
	}

	public void onClick$btnBuscar() {
		new Util().crearVentana("Jugador/Vistas/buscarJugador.zul", null, null);
	}

	public void onChange$dtboxFechaNac() {
		Date fecha = dtboxFechaNac.getValue();
		txtEdad.setValue(Util.calcularDiferenciaAnnios(fecha));
	}
	
	public void onClick$btnSalir() {
		winRegistrarPlanVacacional.detach();
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

}
