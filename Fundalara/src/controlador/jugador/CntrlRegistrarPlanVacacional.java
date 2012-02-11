package controlador.jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Categoria;
import modelo.Competencia;
import modelo.DatoBasico;
import modelo.Equipo;
import modelo.Familiar;
import modelo.FamiliarJugador;
import modelo.HorarioPlanTemporada;
import modelo.Hospedaje;
import modelo.Jugador;
import modelo.JugadorPlan;
import modelo.Persona;
import modelo.PersonaNatural;
import modelo.RepresentanteJugadorPlan;
import modelo.TallaPorIndumentaria;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
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
import servicio.implementacion.ServicioRepresentanteJugadorPlan;
import servicio.implementacion.ServicioRoster;
import servicio.implementacion.ServicioTallaPorJugador;

import comun.EstatusRegistro;
import comun.Mensaje;
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
	// Jugador
	private Combobox cmbTipoJugador;
	private Combobox cmbNacionalidad;
	private Datebox dtboxFechaNac;
	private Intbox txtCedula;
	private Intbox txtCedulaSecuencia;
	private Intbox txtEdad;
	private Combobox cmbTalla;
	//Representante
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
	// Plan Vacacional
	private Combobox cmbEquipo;
	private Combobox cmbCategoria;
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

	private Component formulario;

	// Binder
	private AnnotateDataBinder binder;

	// Modelos
	private JugadorPlan jugadorPlan = new JugadorPlan();
	private Familiar representante = new Familiar();
	private Persona persona = new Persona();
	private PersonaNatural personaNatural = new PersonaNatural();
	private Jugador jugador = new Jugador();
	private Categoria categoria = new Categoria();
	private Equipo equipo = new Equipo();
	private DatoBasico tipoIndumentaria = new DatoBasico();
	private RepresentanteJugadorPlan representanteJugadorPlan = new RepresentanteJugadorPlan();

	private DatoBasico estadoVenezuela = new DatoBasico();
	private DatoBasico municipio = new DatoBasico();
	private DatoBasico parroquia = new DatoBasico();
	
	// Servicios
	private ServicioDatoBasico servicioDatoBasico;
	private ServicioCategoria servicioCategoria;
	private ServicioEquipo servicioEquipo;
	private ServicioJugadorPlan servicioJugadorPlan;
	private ServicioTallaPorJugador servicioTallaPorJugador;
	private ServicioRoster servicioRoster;
	private ServicioHorarioPlanTemporada servicioHorarioPlanTemporada;
	private ServicioRepresentanteJugadorPlan servicioRepresentanteJugadorPlan;
	private ServicioFamiliarJugador servicioFamiliarJugador;
	
	List<FamiliarJugador> listaFamiliarJugador = new ArrayList<FamiliarJugador>();

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		formulario = comp;
	}

	//Getters y setters
	public JugadorPlan getJugadorPlan() {
		return jugadorPlan;
	}
	
	public void setJugadorPlan(JugadorPlan jugadorPlan) {
		this.jugadorPlan = jugadorPlan;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public PersonaNatural getPersonaNatural() {
		return personaNatural;
	}

	public void setPersonaNatural(PersonaNatural personaNatural) {
		this.personaNatural = personaNatural;
	}

	public RepresentanteJugadorPlan getRepresentanteJugadorPlan() {
		return representanteJugadorPlan;
	}

	public void setRepresentanteJugadorPlan(
			RepresentanteJugadorPlan representanteJugadorPlan) {
		this.representanteJugadorPlan = representanteJugadorPlan;
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
	

	public DatoBasico getParroquia() {
		return parroquia;
	}

	public void setParroquia(DatoBasico parroquia) {
		this.parroquia = parroquia;
	}

	// Metodos para carga de combos/listbox
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
		int edad = (txtEdad.getValue() == null ? 0 : txtEdad.getValue());
		return servicioCategoria.buscarCategorias(edad);
	}

	public List<Equipo> getEquipos() {
		return servicioEquipo.buscarPorCategoria(categoria, "PLAN VACACIONAL");
	}

	public List<HorarioPlanTemporada> getHorariosPlan() {
		return servicioHorarioPlanTemporada.buscarPorEquipo(equipo);
	}

	// Eventos
	public void onChange$cmbTipoJugador() {
		visibleButton(true);
	}

	public void onClick$btnGuardar() throws InterruptedException {
		guardar();
		limpiar();
	}

	public void onClick$btnCancelar() {
		if ((cmbTipoJugador.getSelectedIndex() >= 0)
				&& (txtCedula.getText() != "") && (txtCedulaF.getText() != "")) {
			Mensaje.mostrarConfirmacion("¿Está seguro de cancelar la operación?",
					Mensaje.CONFIRMAR, Messagebox.YES | Messagebox.NO,
					new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event evt) throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								limpiar();
							}
						}
					});
		}
	}

	public void onChange$dtboxFechaNac() {
		Date fecha = dtboxFechaNac.getValue();
		txtEdad.setValue(Util.calcularDiferenciaAnnios(fecha));
	}

	public void onClick$btnSalir() {
		onClose$winRegistrarPlanVacacional();
	}
	
	public void onClose$winRegistrarPlanVacacional() {
		Mensaje.mostrarConfirmacion("¿Está seguro de cerrar la ventana?",
				Mensaje.CONFIRMAR, Messagebox.YES | Messagebox.NO,
				new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onYes")) {
							winRegistrarPlanVacacional.detach();
						}
					}
				});
	}

	public void onClick$btnCatalogoJugador() {
		//Crear y ejecutar catalogo
		Component catalogo = Executions.createComponents(
				"/Jugador/Vistas/frmBuscarJugador.zul", null, null);
		catalogo.setVariable("formulario", formulario, false);//Asignar referencia del formulario al catalogo.
		catalogo.setVariable("estatus", EstatusRegistro.ACTIVO, false);

		formulario.addEventListener("onCatalogoBuscarJugadorCerrado",
				new EventListener() {
					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.zkoss.zk.ui.event.EventListener#onEvent(org.zkoss
					 * .zk.ui.event.Event)
					 */
					@Override
					public void onEvent(Event arg0) throws Exception {
						jugador = (Jugador) formulario.getVariable("jugador",
								false);
						String datosCedula[] = jugador.getCedulaRif().split("-");
						cmbNacionalidad.setValue(datosCedula[0]);
						txtCedula.setValue(Integer.valueOf(datosCedula[1]));
						if (datosCedula.length == 3) {
							txtCedulaSecuencia.setValue(Integer.valueOf(datosCedula[2]));
						}
						if (jugador.getPersonaNatural().getPrimerNombre() != null) {
							txtNombre.setValue(jugador.getPersonaNatural()
									.getPrimerNombre());
							if (jugador.getPersonaNatural().getSegundoNombre() != null) {
								txtNombre.setValue(txtNombre.getValue()
										+ " "
										+ jugador.getPersonaNatural()
												.getSegundoNombre());
							}
						}
						if (jugador.getPersonaNatural().getPrimerApellido() != null) {
							txtApellido.setValue(jugador.getPersonaNatural()
									.getPrimerApellido());
							if (jugador.getPersonaNatural()
									.getSegundoApellido() != null) {
								txtApellido.setValue(txtApellido.getValue()
										+ " "
										+ jugador.getPersonaNatural()
												.getSegundoApellido());
							}
						}
						dtboxFechaNac.setValue(jugador.getPersonaNatural()
								.getFechaNacimiento());

						List<DatoBasico> listTallasEntrenamiento = servicioTallaPorJugador
								.buscarTallasPorTipo(jugador, tipoIndumentaria);
						for (DatoBasico datoBasico : listTallasEntrenamiento) {

							if (datoBasico.getDatoBasico().getNombre()
									.equals("CAMISA")) {
								cmbTalla.setValue(datoBasico.getNombre());
							}
						}

						listaFamiliarJugador = servicioFamiliarJugador
								.buscarFamiliarJugador(jugador);
						for (int i = 0; i < listaFamiliarJugador.size(); i++) {
							if (listaFamiliarJugador.get(i)
									.isRepresentanteActual()) {
								representante = listaFamiliarJugador.get(i)
										.getFamiliar();
								break;
							}
						}
						
						String datosCedulaF[] = representante.getCedulaRif().split("-");
						cmbNacionalidadF.setValue(datosCedulaF[0]);
						txtCedulaF.setValue(Integer.valueOf(datosCedulaF[1]));
						
						if (representante.getPersonaNatural().getPrimerNombre() != null) {
							txtNombreRepr.setValue(representante
									.getPersonaNatural().getPrimerNombre());
							if (representante.getPersonaNatural()
									.getSegundoNombre() != null) {
								txtNombreRepr.setValue(txtNombreRepr.getValue()
										+ " "
										+ representante.getPersonaNatural()
												.getSegundoNombre());
							}
						}
						if (representante.getPersonaNatural()
								.getPrimerApellido() != null) {
							txtApellidoRepr.setValue(representante
									.getPersonaNatural().getPrimerApellido());
							if (representante.getPersonaNatural()
									.getSegundoApellido() != null) {
								txtApellidoRepr.setValue(txtApellidoRepr
										.getValue()
										+ " "
										+ representante.getPersonaNatural()
												.getSegundoApellido());
							}
						}
						cmbEstadoRepr.setValue(representante
								.getPersonaNatural().getPersona()
								.getDatoBasicoByCodigoParroquia()
								.getDatoBasico().getDatoBasico().getNombre());
						cmbMunicipioRepr.setValue(representante
								.getPersonaNatural().getPersona()
								.getDatoBasicoByCodigoParroquia()
								.getDatoBasico().getNombre());
						cmbParroquiaRepr.setValue(representante
								.getPersonaNatural().getPersona()
								.getDatoBasicoByCodigoParroquia().getNombre());
						txtDireccionHabRepr.setValue(representante
								.getPersonaNatural().getPersona()
								.getDireccion());
						
						if (representante.getPersonaNatural().getPersona()
								.getTelefonoHabitacion() != null) {
							String[] numeroHab = Util.separarCadena(representante
									.getPersonaNatural().getPersona()
									.getTelefonoHabitacion(), "-");
							if (numeroHab.length == 2) {
								cmbCodArea.setValue(numeroHab[0]);
								txtTelefono.setRawValue(numeroHab[1]);
							}
						}

						if (representante.getPersonaNatural().getCelular() != null) {
							String[] numeroCel = Util.separarCadena(representante.getPersonaNatural().getCelular(), "-");
							if (numeroCel.length == 2) {
								cmbCodCelular.setValue(numeroCel[0]);
								txtCelular.setRawValue(numeroCel[1]);
							}
						}
						
						categoria = servicioRoster.buscarRoster(jugador.getCedulaRif()).getEquipo().getCategoria();
						cmbCategoria.setValue(categoria.getNombre());
						binder.loadComponent(cmbEquipo);
					}
				});
	}

	// Metodos propios del ctrl
	/* Habilita o deshabilita los campos de la vista. */
	private void disabledFields(boolean flag) {
		txtNombre.setReadonly(flag);
		txtApellido.setReadonly(flag);
		dtboxFechaNac.setReadonly(flag);
		cmbTipoJugador.setDisabled(flag);
		cmbCategoria.setDisabled(flag);
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
			disabledFields(flag);//Deshabilitar campos
		}
		else {
			btnCatalogoJugador.setVisible(!flag);
			txtCedula.setFocus(true);
			disabledFields(!flag);//Habilitar campos
		}
	}

	// modificaciones echas hasta ahora. por Luis
	public void guardar() throws InterruptedException {
		if ((cmbTipoJugador.getSelectedIndex() >= 0)
				&& (txtCedula.getText() != "") && (txtCedulaF.getText() != "")) {

			Comboitem item = cmbTipoJugador.getSelectedItem();
			DatoBasico dato = (DatoBasico) item.getValue();
			Comboitem itemtalla = cmbTalla.getSelectedItem();
			TallaPorIndumentaria talla = (TallaPorIndumentaria) itemtalla.getValue();
			/*Comboitem itemestado = cmbEstadoRepr.getSelectedItem();
			DatoBasico datoestado = (DatoBasico) itemestado.getValue();
			Comboitem itemmunicipio = cmbMunicipioRepr.getSelectedItem();
			DatoBasico datomunicipio = (DatoBasico) itemmunicipio.getValue();
			Comboitem itemdatoparroquia = cmbParroquiaRepr.getSelectedItem();
			DatoBasico datoparroquia = (DatoBasico) itemdatoparroquia
					.getValue();
			Comboitem itemtelefono = cmbCodArea.getSelectedItem();
			DatoBasico datoarea = (DatoBasico) itemtelefono.getValue();
			Comboitem itemcelular = cmbCodCelular.getSelectedItem();
			DatoBasico datocelular = (DatoBasico) itemcelular.getValue();*/
		
			jugadorPlan.setCedulaRif(jugador.getCedulaRif());
			jugadorPlan.setNombre(txtNombre.getText());
			jugadorPlan.setApellido(txtApellido.getText());
			jugadorPlan.setFechaNacimiento(dtboxFechaNac.getValue());
			jugadorPlan.setDatoBasico(dato);
			jugadorPlan.setTallaPorIndumentaria(talla);
			jugadorPlan.setEstatus('A');
			/*personaN.setCedulaRif(jugador.getCedulaRif());
			personaN.setPrimerNombre(txtNombreRepr.getText());
			personaN.setPrimerApellido(txtApellidoRepr.getText());
					
			servicioJugadorPlan.agregar(jugadorPlan);
			servicioRepresentanteJugadorPlan.agregar(representanteJugadorPlan);
			servicioDatoBasico.agregar(tipoIndumentaria);
			servicioDatoBasico.agregar(estadoVenezuela);
			servicioDatoBasico.agregar(municipio);
			servicioDatoBasico.agregar(parroquia);
			servicioDatoBasico.agregar(Telefono);
			servicioDatoBasico.agregar(Celular);
			servicioCategoria.agregar(categoria);
			servicioEquipo.agregar(equipo);
			
*/			// representanteJugadorPlan = new RepresentateJugadorPlan();
			// representanteJugadorPlan.setFamiliar(familiar);
			// servicioJugadorPlan.agregar(jugador);
			Mensaje.mostrarMensaje("Jugador asociado a el Plan Vacacional ",
					Mensaje.EXITO, Messagebox.INFORMATION);
		}
	}

	public void limpiar() {
		//Componentes
		cmbTipoJugador.setSelectedIndex(-1);
		jugadorPlan = new JugadorPlan();
		txtCedula.setValue(null);
		txtNombre.setValue(null);
		txtApellido.setValue(null);
		dtboxFechaNac.setValue(null);
		txtEdad.setValue(null);
		cmbTalla.setValue(null);
		txtCedulaF.setValue(null);
		txtNombreRepr.setValue(null);
		txtApellidoRepr.setValue(null);
		txtDireccionHabRepr.setValue(null);
		cmbEstadoRepr.setSelectedIndex(-1);
		cmbMunicipioRepr.setSelectedIndex(-1);
		cmbParroquiaRepr.setSelectedIndex(-1);
		cmbCodArea.setSelectedIndex(-1);
		cmbCodCelular.setSelectedIndex(-1);
		txtTelefono.setValue(null);
		txtCelular.setValue(null);
		cmbCategoria.setSelectedIndex(-1);
		cmbEquipo.setSelectedIndex(-1);
		
		//Inicializar
		jugadorPlan = new JugadorPlan();
		representante = new Familiar();
		persona = new Persona();
		personaNatural = new PersonaNatural();
		jugador = new Jugador();
		categoria = new Categoria();
		equipo = new Equipo();
		tipoIndumentaria = new DatoBasico();
		representanteJugadorPlan = new RepresentanteJugadorPlan();

		estadoVenezuela = new DatoBasico();
		municipio = new DatoBasico();
		parroquia = new DatoBasico();

		binder.loadAll();
		disabledFields(false);
	}

	/*
	 * if (!existe) { if (servicioJugadorPlan.verificar(jugador,
	 * servicioJugador.actualizar(jugador))) { JugadorPlan = new JugadorPlan();
	 * JugadorPlan = servicioJugador.activar(jugador,
	 * servicioFamiliarJugador.buscarFamiliar(familiar));
	 * JugadorPlan.setEstatus('A'); servicioJugadorPlan.actualizar(JugadorPlan);
	 * Mensaje.mostrarMensaje( "Representante asociado a Plan", Mensaje.EXITO,
	 * Messagebox.INFORMATION); JugadorPlan = new JugadorPlan(); limpiar(); }
	 * else { JugadorPlan = new JugadorPlan();
	 * JugadorPlan.setFamiliarJugador(servicioFamiliarJugador
	 * .buscarFamiliar(familiar)); JugadorPlan.setJugador(Jugador);
	 * JugadorPlan.setEstatus('A'); servicioJugadorPlan.agregar(Jugador);
	 * Mensaje.mostrarMensaje( "Representante asociado a Hospedaje",
	 * Mensaje.EXITO, Messagebox.INFORMATION); JugadorPlan = new JugadorPlan();
	 * limpiar(); }
	 * 
	 * }
	 */

}