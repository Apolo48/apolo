package controlador.jugador;

import java.util.Date;
import java.util.List;

import modelo.Categoria;
import modelo.DatoBasico;
import modelo.Equipo;
import modelo.Jugador;
import modelo.JugadorPlan;
import modelo.Persona;
import modelo.PersonaNatural;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
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
import servicio.implementacion.ServicioJugador;
import servicio.implementacion.ServicioJugadorPlan;

import comun.EstatusRegistro;
import comun.TipoDatoBasico;
import comun.Util;

/**
 * Clase controladora de los eventos de la vista Plan Vacacional.
 * 
 * @author Maria F,Luis D
 * @version 1.0 26/11/2011
 */

public class CntrlRegistrarPlanVacacional extends GenericForwardComposer {
	// Componentes visuales
	//Datos del Jugador 
	private Combobox cmbTipoJugador;
	private Combobox cmbNacionalidad;
	private Datebox dtboxFechaNac;
	private Intbox txtCedula;
	private Intbox txtCedulaSecuencia;
	private Intbox txtEdad;
	private Combobox cmbTalla;// hace referencia a las Tallas de camisa
	//Datos del representante
	private Combobox cmbNacionalidadF;
	private Intbox txtTelefono;
	private Intbox txtCelular;
	private Intbox txtCedulaF;
	private Textbox txtNombre;
	private Textbox txtApellido;
	private Textbox txtNombreRepr;
	private Textbox txtApellidoRepr;
	private Combobox cmbCodArea;
	private Combobox cmbCodCelular;
	//Datos de La Categoria y Equipo
	private Combobox cmbEquipo;
	private Combobox cmbCategoria;
	//Datos relativos a el Turno y Horario para realizar el Plan Vacacional 
	private Combobox cmbTurno;
	private Combobox cmbHorario;
	// Botones		
	private Button btnCatalogoJugador;
	private Button btnGuardar;
	private Button btnModificar;
	private Button btnEliminar;
	private Button btnCancelar;
	private Button btnSalir;
	private Window winRegistrarPlanVacacional;
	
	//Catalogo
	private Component formulario;
		
	//Binder
	private AnnotateDataBinder binder;
	
	//Modelos
	private JugadorPlan jugadorPlan= new JugadorPlan();
	private Categoria categoria = new Categoria();
	private Equipo equipo = new Equipo();
	private Persona persona = new Persona();
	private PersonaNatural personaN = new PersonaNatural();
	private Jugador jugador = new Jugador();
	private controlador.jugador.bean.Jugador jugadorBean = new controlador.jugador.bean.Jugador();
	//private RepresentantePlan representantePlan= new RepresentantePlan();//Cambiar x Familiar 
	
	private DatoBasico estadoVenezuela = new DatoBasico();
	private DatoBasico municipio = new DatoBasico();
	
	// Servicios
	private ServicioJugador servicioJugador;
	private ServicioDatoBasico servicioDatoBasico;
	private ServicioDatoBasico Jugador;
	private ServicioCategoria servicioCategoria;
	private ServicioEquipo servicioEquipo;
	private ServicioJugadorPlan servicioJugadorPlan;
	//private ServicioRepresentantePlan servicioRepresentantePlan; // CAMBIAR x familiar
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false); // Hacemos visible el
														// modelo para el
														// databinder
		formulario = comp;
	}
	
	//Getters y setters
	public JugadorPlan getJugadorPlan() {
		return jugadorPlan;
	}


	public void setJugadorPlan(JugadorPlan jugadorPlan) {
		this.jugadorPlan = jugadorPlan;
	}


/*	public RepresentantePlan getRepresentantePlan() {
		return representantePlan;
	}


	public void setRepresentantePlan(RepresentantePlan representantePlan) {
		this.representantePlan = representantePlan;
	}*/


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	public DatoBasico getEstadoVenezuela() {
		return estadoVenezuela;
	}


	public void setEstadoVenezuela(DatoBasico estadoVenezuela) {
		this.estadoVenezuela = estadoVenezuela;
	}


	public DatoBasico getMunicipio() {
		return municipio;
	}


	public void setMunicipio(DatoBasico municipio) {
		this.municipio = municipio;
	}

	
	//Metodos para carga de combos/listbox
	public List<DatoBasico> getEstadosVenezuela() {
		return servicioDatoBasico.buscar(TipoDatoBasico.ESTADO_VENEZUELA);
	}

	
	public List<DatoBasico> getMunicipiosEstados() {
		return servicioDatoBasico.buscarDatosPorRelacion(estadoVenezuela);
	}

	public List<DatoBasico> getParroquiasMunicipio() {
		return servicioDatoBasico.buscarDatosPorRelacion(municipio);
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

	public List<DatoBasico> getCodigosArea() {
		return servicioDatoBasico.buscar(TipoDatoBasico.CODIGO_AREA);
	}
	public List<DatoBasico> getCodigosCelular() {
		return servicioDatoBasico.buscar(TipoDatoBasico.CODIGO_CELULAR);
	}
	
	public List<DatoBasico> getTipoJugadores() {
		return servicioDatoBasico.buscar(TipoDatoBasico.TIPO_JUGADOR);
	}
	
	public List<Categoria> getCategorias() {
		int edad =(txtEdad.getValue()==null?0:txtEdad.getValue());
		return servicioCategoria.buscarCategorias(edad);
	}
	
	public List<Equipo> getEquipos() {
		return servicioEquipo.buscarPorCategoria(categoria);
	}
	
	//Eventos
	public void onChange$cmbTipoJugador() {
		visibleButton(true);
	}

	public void onClick$btnGuardar() {
		viewcompromiso();
	}
	
	public void onClick$btnCancelar() {
		/*plan= new PlanVacacional();
		binder.loadAll();*/
	}

	public void onChange$dtboxFechaNac() {
		Date fecha = dtboxFechaNac.getValue();
		txtEdad.setValue(Util.calcularDiferenciaAnnios(fecha));
	}
	
	public void onClick$btnSalir() {
		winRegistrarPlanVacacional.detach();
	}
	
	public void onClick$btnCatalogoJugador() {
		// se crea el catalogo y se llama
		Component catalogo = Executions.createComponents(
				"/Jugador/Vistas/frmBuscarJugador.zul", null, null);
		// asigna una referencia del formulario al catalogo.
		catalogo.setVariable("formulario", formulario, false);
		catalogo.setVariable("estatus", EstatusRegistro.ACTIVO, false);

		formulario.addEventListener("onCatalogoBuscarJugadorCerrado", new EventListener() {
			/* (non-Javadoc)
			 * @see org.zkoss.zk.ui.event.EventListener#onEvent(org.zkoss.zk.ui.event.Event)
			 */
			@Override
			public void onEvent(Event arg0) throws Exception {
				jugador = (Jugador) formulario.getVariable("jugador", false);
				//txtCedula.setValue(jugador.getCedulaRif());
				txtNombre.setValue(jugador.getPersonaNatural().getPrimerNombre() + jugador.getPersonaNatural().getSegundoNombre());
				//TODOS LOS DEMAS APLICA MISMO CASO LINEA ANTERIOR
				//REVISAR DONDE ESTAN UBICADOS LOS DATOS EN TABLAS JUGADOR, PERSONA_NATURAL, PERSONA
			}
		});
	}

	//Metodos propios del ctrl
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
		if (cmbTipoJugador.getSelectedItem().getLabel().equals("REGULAR")) {
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
	//CREO SE ELIMINARA SE SUSTITUIRA X UN METODO QUE CREE EL COMPROMISO USANDO UN SERVICIO
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

}