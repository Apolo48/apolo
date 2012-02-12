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
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioDatoBasico;
import servicio.implementacion.ServicioEquipo;
import servicio.implementacion.ServicioFamiliar;
import servicio.implementacion.ServicioFamiliarJugador;
import servicio.implementacion.ServicioHorarioPlanTemporada;
import servicio.implementacion.ServicioJugadorPlan;
import servicio.implementacion.ServicioPersona;
import servicio.implementacion.ServicioPersonaNatural;
import servicio.implementacion.ServicioRepresentanteJugadorPlan;
import servicio.implementacion.ServicioRoster;
import servicio.implementacion.ServicioTallaPorIndumentaria;
import servicio.implementacion.ServicioTallaPorJugador;

import comun.EstatusRegistro;
import comun.Mensaje;
import comun.Ruta;
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
	private Button btnCatalogoFamiliar;
	private Button btnGuardar;
	private Button btnModificar;
	private Button btnEliminar;
	private Button btnCancelar;
	private Button btnSalir;
	private Window winRegistrarPlanVacacional;

	private Component formulario;
	private String rutasJug = Ruta.JUGADOR.getRutaVista();

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
	private ServicioJugadorPlan servicioJugadorPlan;
	private ServicioFamiliar servicioFamiliar;
	private ServicioPersona servicioPersona;
	private ServicioPersonaNatural servicioPersonaNatural;
	private ServicioRepresentanteJugadorPlan servicioRepresentanteJugadorPlan;
	private ServicioFamiliarJugador servicioFamiliarJugador;
	private ServicioCategoria servicioCategoria;
	private ServicioEquipo servicioEquipo;
	private ServicioDatoBasico servicioDatoBasico;
	private ServicioTallaPorJugador servicioTallaPorJugador;
	private ServicioTallaPorIndumentaria servicioTallaPorIndumentaria;
	private ServicioRoster servicioRoster;
	private ServicioHorarioPlanTemporada servicioHorarioPlanTemporada;
	
	List<FamiliarJugador> listaFamiliarJugador = new ArrayList<FamiliarJugador>();
	List<RepresentanteJugadorPlan> listaRepresentanteJugador = new ArrayList<RepresentanteJugadorPlan>();
	
	private int seleccion = 0;

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

	public DatoBasico getTipoIndumentaria() {
		return tipoIndumentaria;
	}

	public void setTipoIndumentaria(DatoBasico tipoIndumentaria) {
		this.tipoIndumentaria = tipoIndumentaria;
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

	public int getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
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
			Mensaje.mostrarConfirmacion("�Est� seguro de cancelar la operaci�n?",
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
		Mensaje.mostrarConfirmacion("�Est� seguro de cerrar la ventana?",
				Mensaje.CONFIRMAR, Messagebox.YES | Messagebox.NO,
				new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onYes")) {
							winRegistrarPlanVacacional.detach();
						}
					}
				});
	}
	
	public void onClick$btnCatalogoFamiliar() {
		Component catalogo = Executions.createComponents(rutasJug
				+ "frmBuscarFamiliar.zul", null, null);
		catalogo.setVariable("formulario", formulario, false);
		// 2: Familiar
		catalogo.setVariable("estatus", 2, false);
		formulario.addEventListener("onCatalogoBuscarFamiliarCerrado",
				new EventListener() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						representante = (Familiar) formulario.getVariable("familiar", false);
						if (representante != null) {
							mostrarRepresentante();
						}

					}
				});
	}

	public void onClick$btnCatalogoJugador() {
		if (cmbTipoJugador.getSelectedIndex() >= 0) {
			Component catalogo = Executions.createComponents(rutasJug
					+ "frmBuscarJugador.zul", null, null);//Crear y ejecutar catalogo
			catalogo.setVariable("formulario", formulario, false);//Asignar referencia del formulario al catalogo.
			final boolean tipo = (cmbTipoJugador.getSelectedItem().getLabel().equalsIgnoreCase("NO REGULAR"));
			if (tipo) {
				catalogo.setVariable("estatus", EstatusRegistro.PLAN_VACACIONAL, false);
			} else {
				catalogo.setVariable("estatus", EstatusRegistro.ACTIVO, false);
			}

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
							if (tipo) {
								mostrarJugadorPlan();
								setSeleccion(1);
							} else {
								mostrarJugador();
								setSeleccion(2);
							}
						}
					});
		}
	}
	
	public void mostrarJugador() {
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
		
		if (representante.getCedulaRif() == null) {
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
			mostrarRepresentante();
		}
		
		categoria = servicioRoster.buscarRoster(jugador.getCedulaRif()).getEquipo().getCategoria();
		cmbCategoria.setValue(categoria.getNombre());
		binder.loadComponent(cmbEquipo);
	}
	
	public void mostrarJugadorPlan() {
		JugadorPlan jugadorPlan = (JugadorPlan) formulario.getVariable("jugadorPlan", false);
		String datosCedula[] = jugadorPlan.getCedulaRif().split("-");
		cmbNacionalidad.setValue(datosCedula[0]);
		txtCedula.setValue(Integer.valueOf(datosCedula[1]));
		if (datosCedula.length == 3) {
			txtCedulaSecuencia.setValue(Integer.valueOf(datosCedula[2]));
		}
		if (jugadorPlan.getNombre() != null) {
			txtNombre.setValue(jugadorPlan.getNombre());
		}
		if (jugador.getPersonaNatural().getPrimerApellido() != null) {
			txtApellido.setValue(jugadorPlan.getApellido());
		}
		dtboxFechaNac.setValue(jugadorPlan.getFechaNacimiento());
	
		cmbTalla.setValue(jugadorPlan.getTallaPorIndumentaria().getDatoBasicoByCodigoTalla().getNombre());
		
		List<DatoBasico> lista = null;
		DatoBasico datoIndumentaria = servicioDatoBasico.buscarTipo(
				TipoDatoBasico.INDUMENTARIA, "Camisa");
		if (datoIndumentaria != null) {
			lista = servicioDatoBasico.buscarDatosPorRelacion(datoIndumentaria);
		}

		listaRepresentanteJugador = servicioRepresentanteJugadorPlan
				.buscarRepresentanteJugador(jugadorPlan);
		for (int i = 0; i < listaRepresentanteJugador.size(); i++) {
			if (String.valueOf(listaRepresentanteJugador.get(i).getEstatus()).equalsIgnoreCase("A")) {
				representante = listaRepresentanteJugador.get(i).getFamiliar();
				break;
			}
		}
		
		mostrarRepresentante();
		
		categoria = servicioRoster.buscarRoster(jugador.getCedulaRif()).getEquipo().getCategoria();
		cmbCategoria.setValue(categoria.getNombre());
		binder.loadComponent(cmbEquipo);
	}
	
	public void mostrarRepresentante() {
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
	}

	// Metodos propios del ctrl
	/* Habilita o deshabilita los campos de la vista. */
	private void disabledFields(boolean flag) {
		txtNombre.setReadonly(flag);
		txtApellido.setReadonly(flag);
		dtboxFechaNac.setReadonly(flag);
		//cmbTipoJugador.setDisabled(flag);
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
		//btnCatalogoFamiliar.setDisabled(flag);
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
			//btnCatalogoJugador.setVisible(!flag);
			txtCedula.setFocus(true);
			disabledFields(!flag);//Habilitar campos
		}
	}

	// modificaciones echas hasta ahora. por Luis
	public void guardar() throws InterruptedException {
		if ((cmbTipoJugador.getSelectedIndex() >= 0)
				&& (txtCedula.getText() != "") && (txtCedulaF.getText() != "")) {
	
			if (getSeleccion() != 1) {
				//JugadorPlan
				String cedula = cmbNacionalidad.getValue()+"-"+txtCedula.getValue();
				jugadorPlan.setCedulaRif(cedula);
				jugadorPlan.setNombre(txtNombre.getText());
				jugadorPlan.setApellido(txtApellido.getText());
				jugadorPlan.setFechaNacimiento(dtboxFechaNac.getValue());
				jugadorPlan.setDatoBasico((DatoBasico) cmbTipoJugador.getSelectedItem().getValue());
				TallaPorIndumentaria talla = servicioTallaPorIndumentaria.buscarPorDatoBasico((DatoBasico) cmbTipoJugador.getSelectedItem().getValue());
				jugadorPlan.setTallaPorIndumentaria(talla);
				jugadorPlan.setEstatus('A');
				//jugadorPlan.setJugador(jugador);
				servicioJugadorPlan.agregar(jugadorPlan);
			} 
			//CASO CONTRARIO VERIFICA SI ACTUALIZA 
			
			
			String cedulaFamiliar = cmbNacionalidadF.getValue()+"-"+txtCedulaF.getValue();
			
			if (getSeleccion() == 0) {
				persona.setCedulaRif(cedulaFamiliar);
				persona.setDatoBasicoByCodigoParroquia((DatoBasico) cmbParroquiaRepr.getSelectedItem().getValue());
				DatoBasico tipoPersona = null;
				List<DatoBasico> tipos = servicioDatoBasico.buscar(TipoDatoBasico.TIPO_JUGADOR);
				for (int k = 0; k < tipos.size(); k++) {
					if (tipos.get(k).getNombre().equals(cmbTipoJugador.getSelectedItem().getValue())){
						tipoPersona = tipos.get(k);
						break;
					}
				}
				persona.setDatoBasicoByCodigoTipoPersona(tipoPersona);
				persona.setDireccion(txtDireccionHabRepr.getValue());
				persona.setTelefonoHabitacion(cmbCodArea+"-"+String.valueOf(txtTelefono.getValue()));
				persona.setEstatus('A');
				servicioPersona.agregar(persona);
				
				personaNatural.setCedulaRif(cedulaFamiliar);
				personaNatural.setPrimerNombre(txtNombreRepr.getValue());
				personaNatural.setPrimerApellido(txtApellidoRepr.getValue());
				personaNatural.setCelular(cmbCodCelular+"-"+String.valueOf(txtCelular.getValue()));
				personaNatural.setPersona(persona);
				personaNatural.setEstatus('A');
				servicioPersonaNatural.agregar(personaNatural);

				representante.setCedulaRif(cedulaFamiliar);
				representante.setPersonaNatural(personaNatural);
				representante.setEstatus('A');
				servicioFamiliar.agregar(representante);
			}
			
			
			if (getSeleccion() != 1) {
				representanteJugadorPlan.setFamiliar(representante);
				representanteJugadorPlan.setJugadorPlan(jugadorPlan);
				representanteJugadorPlan.setEstatus('A');
				servicioRepresentanteJugadorPlan.agregar(representanteJugadorPlan);
			}
			//CASO CONTRARIO VERIFICO SI ACTUALIZA
			
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
		
		setSeleccion(0);

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