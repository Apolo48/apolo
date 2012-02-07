package controlador.jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Categoria;
import modelo.DatoBasico;
import modelo.Equipo;
import modelo.Familiar;
import modelo.FamiliarJugador;
import modelo.HorarioPlanTemporada;
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
import servicio.implementacion.ServicioFamiliarJugador;
import servicio.implementacion.ServicioHorario;
import servicio.implementacion.ServicioHorarioPlanTemporada;
import servicio.implementacion.ServicioJugador;
import servicio.implementacion.ServicioJugadorPlan;
import servicio.implementacion.ServicioLapsoDeportivo;
import servicio.implementacion.ServicioPlanTemporada;
import servicio.implementacion.ServicioRoster;
import servicio.implementacion.ServicioTallaPorJugador;

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
	private Combobox cmbEstadoRepr;
	private Combobox cmbMunicipioRepr;
	private Combobox cmbParroquiaRepr;
	private Textbox txtDireccionHabRepr;
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
	private DatoBasico tipoIndumentaria = new DatoBasico();
	private HorarioPlanTemporada horarioPlan = new HorarioPlanTemporada();
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
	private ServicioFamiliarJugador servicioFamiliarJugador;
	private ServicioTallaPorJugador servicioTallaPorJugador;
	private ServicioRoster servicioRoster;
	private ServicioPlanTemporada servicioPlanTemporada;
	private ServicioLapsoDeportivo servicioLapsoDeportivo;
	private ServicioHorario servicioHorario;
	private ServicioHorarioPlanTemporada servicioHorarioPlanTemporada;
	
	List<FamiliarJugador> listaFamiliarJugador = new ArrayList<FamiliarJugador>();
	
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
	
	public HorarioPlanTemporada getHorarioPlan() {
		return horarioPlan;
	}

	public void setHorarioPlan(HorarioPlanTemporada horarioPlan) {
		this.horarioPlan = horarioPlan;
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
		return servicioEquipo.buscarPorCategoria(categoria, "PLAN VACACIONAL");
	}
	
	/*public List<HorarioPlanTemporada> getHorariosPlan() {
		DatoBasico datoLapsoDeportivo = servicioDatoBasico.buscarTipo(
				TipoDatoBasico.TIPO_LAPSO_DEPORTIVO, "PLAN VACACIONAL");
		PlanTemporada plan = servicioPlanTemporada.buscarPorCategoriaLapDep(categoria,servicioLapsoDeportivo.buscarDosCampos(datoLapsoDeportivo));
		HorarioPlanTemporada horarioPlan = servicioHorarioPlanTemporada.buscarPorEquipo(equipo);
		return servicioHorarioPlanTemporada.buscarPorEquipo(equipo);

	}*/
	
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
				if (jugador.getCedulaRif() != null) {
					cmbNacionalidad.setValue(jugador.getCedulaRif().substring(0,1));
					if (cmbNacionalidad.getValue().toCharArray()[0] == 'R') {
						txtCedula.setRawValue(jugador.getCedulaRif().substring(2, jugador.getCedulaRif().length()-2));
						txtCedulaSecuencia.setValue(Integer.decode(jugador.getCedulaRif().substring(jugador.getCedulaRif().length()-1, jugador.getCedulaRif().length()).toString()));
					} else {
						txtCedula.setRawValue(jugador.getCedulaRif().substring(2, jugador.getCedulaRif().length()));
					}
					
				}
				if (jugador.getPersonaNatural().getPrimerNombre() != null) {
					txtNombre.setValue(jugador.getPersonaNatural().getPrimerNombre());
					if (jugador.getPersonaNatural().getSegundoNombre() != null) {
						txtNombre.setValue(txtNombre.getValue() + " " +jugador.getPersonaNatural().getSegundoNombre());
					}
				}
				if (jugador.getPersonaNatural().getPrimerApellido() != null) {
					txtApellido.setValue(jugador.getPersonaNatural().getPrimerApellido());
					if (jugador.getPersonaNatural().getSegundoApellido() != null) {
						txtApellido.setValue(txtApellido.getValue() + " " +jugador.getPersonaNatural().getSegundoApellido());
					}
				}
				dtboxFechaNac.setValue(jugador.getPersonaNatural().getFechaNacimiento());
				//Events.sendEvent(new Event("onChange",dtboxFechaNac));
				
				List<DatoBasico> listTallasEntrenamiento = servicioTallaPorJugador
						.buscarTallasPorTipo(jugador, tipoIndumentaria);
				for (DatoBasico datoBasico : listTallasEntrenamiento) {
					
					if (datoBasico.getDatoBasico().getNombre().equals("CAMISA")){
						cmbTalla.setValue(datoBasico.getNombre());
					}				
				}
				
				Familiar representante = new Familiar();
				listaFamiliarJugador = servicioFamiliarJugador.buscarFamiliarJugador(jugador);
				for (int i = 0; i < listaFamiliarJugador.size(); i++) {
					if (listaFamiliarJugador.get(i).isRepresentanteActual()) {
						representante = listaFamiliarJugador.get(i).getFamiliar();
						break;
					}
				}
				if (representante.getCedulaRif() != null) {
					cmbNacionalidadF.setValue(representante.getCedulaRif().substring(0,1));
					txtCedulaF.setRawValue(representante.getCedulaRif().substring(2, representante.getCedulaRif().length()));
				}
				if (representante.getPersonaNatural().getPrimerNombre() != null) {
					txtNombreRepr.setValue(representante.getPersonaNatural().getPrimerNombre());
					if (representante.getPersonaNatural().getSegundoNombre() != null) {
						txtNombreRepr.setValue(txtNombreRepr.getValue() + " " +representante.getPersonaNatural().getSegundoNombre());
					}
				}
				if (representante.getPersonaNatural().getPrimerApellido() != null) {
					txtApellidoRepr.setValue(representante.getPersonaNatural().getPrimerApellido());
					if (representante.getPersonaNatural().getSegundoApellido() != null) {
						txtApellidoRepr.setValue(txtApellidoRepr.getValue() + " " +representante.getPersonaNatural().getSegundoApellido());
					}
				}
				cmbEstadoRepr.setValue(representante.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getDatoBasico().getDatoBasico().getNombre());
				cmbMunicipioRepr.setValue(representante.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getDatoBasico().getNombre());
				cmbParroquiaRepr.setValue(representante.getPersonaNatural().getPersona().getDatoBasicoByCodigoParroquia().getNombre());
				txtDireccionHabRepr.setValue(representante.getPersonaNatural().getPersona().getDireccion());
				if (representante.getPersonaNatural().getPersona().getTelefonoHabitacion() != null) {
					cmbCodArea.setValue(representante.getPersonaNatural().getPersona().getTelefonoHabitacion().substring(0, 4));
					txtTelefono.setRawValue(representante.getPersonaNatural().getPersona().getTelefonoHabitacion().substring(5, representante.getPersonaNatural().getPersona().getTelefonoHabitacion().length()));
				}
				if (representante.getPersonaNatural().getCelular() != null) {
					cmbCodCelular.setValue(representante.getPersonaNatural().getCelular().substring(0, 4));
					txtCelular.setRawValue(representante.getPersonaNatural().getCelular().substring(5, representante.getPersonaNatural().getCelular().length()));
				}
				//Falta Categoria
				categoria = servicioRoster.buscarRoster(jugador.getCedulaRif()).getEquipo().getCategoria();
				cmbCategoria.setValue(categoria.getNombre());
				//Events.sendEvent(Events.ON_CHANGE,cmbCategoria));
				//Events.sendEvent(Events.ON_CHANGE);
				binder.loadComponent(cmbEquipo);
			}
		});
	}

	//Metodos propios del ctrl
	/*Habilita o deshabilita los campos de la vista.*/
	private void disabledFields(boolean flag) {
		/*txtNombre.setDisabled(flag);  
		txtApellido.setDisabled(flag);
		dtboxFechaNac.setDisabled(flag);
		//cmbTipoJugador.setDisabled(flag);
		cmbCategoria.setDisabled(flag);
		//cmbEquipo.setDisabled(flag);
		cmbNacionalidad.setDisabled(flag);
		cmbNacionalidadF.setDisabled(flag);
		txtCedula.setDisabled(flag);
		txtCedulaF.setDisabled(flag);
		txtNombreRepr.setDisabled(flag);
		txtApellidoRepr.setDisabled(flag);
		cmbCodArea.setDisabled(flag);
		txtTelefono.setDisabled(flag);
		cmbCodCelular.setDisabled(flag);
		txtCelular.setDisabled(flag);*/
		
		txtNombre.setReadonly(flag);
		txtApellido.setReadonly(flag);
		dtboxFechaNac.setReadonly(flag);
		//cmbTipoJugador.setDisabled(flag);
		cmbCategoria.setDisabled(flag);
		//cmbEquipo.setDisabled(flag);
		cmbNacionalidad.setDisabled(flag);
		cmbNacionalidadF.setDisabled(flag);
		txtCedula.setReadonly(flag);
		txtCedulaF.setReadonly(flag);
		txtNombreRepr.setReadonly(flag);
		txtApellidoRepr.setReadonly(flag);
		cmbCodArea.setDisabled(flag);
		txtTelefono.setReadonly(flag);
		cmbCodCelular.setDisabled(flag);
		txtCelular.setReadonly(flag);
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