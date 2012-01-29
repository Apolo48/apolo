package controlador.jugador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import modelo.Ascenso;
import modelo.Categoria;
import modelo.DatoBasico;
import modelo.DocumentoAscenso;
import modelo.DocumentoAscensoId;
import modelo.DocumentoEntregado;
import modelo.Jugador;
import modelo.Equipo;
import modelo.LapsoDeportivo;
import modelo.RecaudoPorProceso;
import modelo.Roster;

import org.zkoss.image.AImage;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;

import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.api.Bandbox;

import comun.EstatusRegistro;
import comun.FileLoader;
import comun.Mensaje;
import comun.Ruta;
import comun.TipoDatoBasico;
import comun.Util;
import controlador.jugador.converter.DateConverter;

import servicio.implementacion.ServicioAscenso;
import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioDatoBasico;
import servicio.implementacion.ServicioDocumentoAscenso;
import servicio.implementacion.ServicioDocumentoEntregado;
import servicio.implementacion.ServicioEquipo;
import servicio.implementacion.ServicioJugador;
import servicio.implementacion.ServicioLapsoDeportivo;
import servicio.implementacion.ServicioRecaudoPorProceso;
import servicio.implementacion.ServicioRoster;

/**
 * Clase controladora de los eventos de la vista de igual nombre y manejo de los
 * servicios de datos para el ascenso especial de los jugadores
 * 
 * @author Maria F
 * @author Romel V
 * @version 0.5 03/01/2012
 * 
 * */

public class CntrlAscensoEspecial extends GenericForwardComposer {

	// Servicios
	private ServicioRoster servicioRoster;
	private ServicioJugador servicioJugador;
	private ServicioCategoria servicioCategoria;
	private ServicioEquipo servicioEquipo;
	private ServicioAscenso servicioAscenso;
	private ServicioDatoBasico servicioDatoBasico;
	private ServicioRecaudoPorProceso servicioRecaudoPorProceso;
	private ServicioDocumentoAscenso servicioDocumentoAscenso;
	private ServicioDocumentoEntregado servicioDocumentoEntregado;
	private ServicioLapsoDeportivo servicioLapsoDeportivo;

	// Modelos
	private Jugador jugador = new Jugador();
	private Roster roster = new Roster();
	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	private Ascenso ascenso = new Ascenso();
	private DatoBasico tipoAscenso = new DatoBasico();
	private RecaudoPorProceso recaudoAscenso = new RecaudoPorProceso();
	private DocumentoEntregado docEntAscenso = new DocumentoEntregado();
    private LapsoDeportivo lapso=new LapsoDeportivo();
    
	// binder
	private AnnotateDataBinder binder;

	// Lista
	private List<Categoria> listaCategoria = null;
	private List<DocumentoEntregado> documentosAscenso = new ArrayList<DocumentoEntregado>();
	private List<DocumentoEntregado> recaudosAscenso = new ArrayList<DocumentoEntregado>();
	
	// id de la interfaz
	private Textbox txtCedula;
	private Textbox txtNombre;
	private Textbox txtApellido;
	private Textbox txtCategoria;
	private Textbox txtEquipo;
	private Intbox txtNumero;
	private Textbox txtFechaNac;
	private Image imgJugador;
	private Combobox cmbCategoria;
	private Combobox cmbEquipo;
	private Window winAscensoEspecial;
	private Bandbox bboxNumero;
	private Listbox listDoc;
	private Spinner spCantidad;
	private Button btnCatalogoJugador;
	private Button btnGuardar;
	private String rutasJug = Ruta.JUGADOR.getRutaVista();

	private Map<String, Object> requestScope;
	Component formulario;

	// Variables
	int edad;
	String nombres;
	String apellidos;
	Boolean sw = false;

	@Override
	// Coloca visible el modelo para el databinder
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, true);
		formulario = comp;
		this.tipoAscenso = (DatoBasico) requestScope.get("tipoAscenso");
	}

	// Getters y Setters
	public Map<String, Object> getRequestScope() {
		return requestScope;
	}

	public void setRequestScope(Map<String, Object> requestScope) {
		this.requestScope = requestScope;
	}
	
	public Image getImgJugador() {
		return imgJugador;
	}

	public void setImgJugador(Image imgJugador) {
		this.imgJugador = imgJugador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Roster getRoster() {
		return roster;
	}

	public void setRoster(Roster roster) {
		this.roster = roster;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public RecaudoPorProceso getRecaudoAscenso() {
		return recaudoAscenso;
	}

	public void setRecaudoAscenso(RecaudoPorProceso recaudoAscenso) {
		this.recaudoAscenso = recaudoAscenso;
	}

	public DocumentoEntregado getDocEntAscenso() {
		return docEntAscenso;
	}

	public void setDocEntAscenso(DocumentoEntregado docEntAscenso) {
		this.docEntAscenso = docEntAscenso;
	}

	public List<DocumentoEntregado> getDocumentosAscenso() {
		return documentosAscenso;
	}

	public void setDocumentosAscenso(List<DocumentoEntregado> documentosAscenso) {
		this.documentosAscenso = documentosAscenso;
	}

	// Para llenar los combos
	public List<Equipo> getEquipos() {
		return servicioEquipo.buscarPorCategoria(categoria);
	}

	public List<Categoria> getCategorias() {
		listaCategoria = servicioCategoria.buscarCategorias(edad);
		return listaCategoria;
	}

	public List<DocumentoEntregado> getRecaudosAscenso() {
		documentosAscenso = new ArrayList<DocumentoEntregado>();
		if (sw == true) {
			List<RecaudoPorProceso> lista = servicioRecaudoPorProceso
					.buscarPorProceso(this.tipoAscenso,
							TipoDatoBasico.TIPO_DOCUMENTO, "ESPECIAL");
			for (RecaudoPorProceso recaudoPorProceso : lista) {
				DocumentoEntregado docE = new DocumentoEntregado();
				docE.setRecaudoPorProceso(recaudoPorProceso);
				documentosAscenso.add(docE);
			}
		}
		return documentosAscenso;
	}

	// Eventos
	public void onClick$btnCatalogoJugador() {
		 Component catalogo = Executions.createComponents(rutasJug
		 + "frmBuscarJugador.zul", null, null);
		catalogo.setVariable("formulario", formulario, false);
		catalogo.setVariable("estatus", EstatusRegistro.ACTIVO, false);
		formulario.addEventListener("onCatalogoBuscarJugadorCerrado",
				new EventListener() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						// TODO Auto-generated method stub
						btnCatalogoJugador.setDisabled(true);
						jugador = (Jugador) formulario.getVariable("jugador",
								false);
						roster = servicioRoster.buscarRoster(jugador
								.getCedulaRif());
						sw = true;
						cmbCategoria.setFocus(true);
						btnGuardar.setDisabled(false);
						Date fecha = jugador.getPersonaNatural()
								.getFechaNacimiento();
						java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat(
								"dd/MM/yyyy");
						String fechaNac = formato.format(fecha);
						txtFechaNac.setValue(fechaNac);
						agregarCampos();
						edad = Util.calcularDiferenciaAnnios(fecha);
						binder.loadAll();

					}
				});
	}

	public void onSelect$cmbCategoria() {
		cmbEquipo.setDisabled(false);
	}

	public void onClick$btnCancelar() {
		limpiar();
	}

	public void onClick$btnSalir() {
		winAscensoEspecial.detach();
	}

	public void onClick$btnGuardar() {
		if (camposVacios() != true) {
			// Cambia de estatus el registro anterior del ascenso
		     servicioAscenso.actualizarAscenso(roster);
			 cambiarEstatusRoster();
			 nuevoRoster();
			 agregarAscenso();
			 actualizarNroJugador();
			 documentoEnt(documentosAscenso);
			Mensaje.mostrarMensaje("Jugador cambiado de categoría",
					Mensaje.EXITO, Messagebox.INFORMATION);
			limpiar();
		}
	}

	// Métodos propios del controlador

	// Concatena y muestra algunos datos en la interfaz
	public void agregarCampos() {
		String segNombre = jugador.getPersonaNatural().getSegundoNombre();
		nombres = jugador.getPersonaNatural().getPrimerNombre()
				+ (segNombre == null ? "" : " " + segNombre);
		String segApellido = jugador.getPersonaNatural().getSegundoApellido();
		apellidos = jugador.getPersonaNatural().getPrimerApellido()
				+ (segApellido == null ? "" : " " + segApellido);
	 
		byte[] foto = jugador.getPersonaNatural().getFoto();
        if (foto != null){
          try {
            AImage aImage = new AImage("foto.jpg", foto);
            imgJugador.setContent(aImage);
          } catch (IOException e) {
            e.printStackTrace();
          }	
        }	

		cmbCategoria.setDisabled(false);
	}

	private void actualizarArchivo(String codigo,
			List<DocumentoEntregado> lista, byte[] archivo) {
		int cod = Integer.valueOf(codigo);
		for (DocumentoEntregado de : lista) {
			if (de.getRecaudoPorProceso().getCodigoRecaudoPorProceso() == cod) {
				de.setDocumento(archivo);
				break;
			}
		}
	}

	private void cargarArchivo(String codigo, Listcell lc,
			List<DocumentoEntregado> docsE) {
		if (lc.getLabel().equals("Subir")) {
			FileLoader fl = new FileLoader();
			byte[] archivo = fl.cargarArchivo();
			if (archivo != null) {
				actualizarArchivo(codigo, docsE, archivo);
				lc.setLabel("Eliminar");
			}
		} else {
			actualizarArchivo(codigo, docsE, null);
			lc.setLabel("Subir");
		}

	}

	public void subirDocumento(Listcell lc, Listbox listbox) {
		Listcell primerElemento = (Listcell) lc.getParent().getFirstChild();
		String codigo = primerElemento.getLabel();
		cargarArchivo(codigo, lc, documentosAscenso);
	}

	// Agrega los documentos entregados
	public void documentoEnt(List<DocumentoEntregado> listaDoc) {
		for (DocumentoEntregado doc : listaDoc) {
			if (doc.getDocumento() != null) {
				doc.setFecha(new Date());
				doc.setEstatus(EstatusRegistro.ACTIVO);
				servicioDocumentoEntregado.agregar(doc);
				// Agrega el registro en documentos ascenso
				DocumentoAscensoId docId = new DocumentoAscensoId(
						doc.getCodigoDocumentoEntregado(),
						ascenso.getCodigoAscenso());
				DocumentoAscenso docAscenso = new DocumentoAscenso(docId, doc,
						ascenso, EstatusRegistro.ACTIVO);
				servicioDocumentoAscenso.agregar(docAscenso);
			}
		}
	}

	// Borra los datos introducidos en la interfaz
	public void limpiar() {
		jugador = new Jugador();
		roster = new Roster();
		equipo = new Equipo();
		categoria = new Categoria();
		recaudoAscenso = new RecaudoPorProceso();
		docEntAscenso = new DocumentoEntregado();
		binder.loadAll();
		txtCedula.setValue(null);
		txtNombre.setValue(null);
		txtApellido.setValue(null);
		txtCategoria.setValue(null);
		txtEquipo.setValue(null);
		txtNumero.setValue(null);
		txtFechaNac.setValue(null);
		cmbCategoria.setDisabled(true);
		cmbEquipo.setDisabled(true);
		btnCatalogoJugador.setDisabled(false);
		btnCatalogoJugador.setFocus(true);
		btnGuardar.setDisabled(true);
		limpiarList();
		Image imgJ = new Image();
	    imgJ.setSrc("../../Recursos/Imagenes/noFoto.jpg");
	    imgJugador.setContent(imgJ.getContent());
	    
	}

	public void limpiarList() {
		if (listDoc.getItems().size() > 0) {
			int size = listDoc.getItemCount();
			for (int i = size - 1; i >= 0; i--) {
				listDoc.removeItemAt(i);
			}
		}
	}

	public boolean camposVacios() {
		boolean vacio = false;
		if (cmbCategoria.getSelectedIndex() == -1) {
			Mensaje.mostrarMensaje("Seleccione una categoria", Mensaje.ERROR,
					Messagebox.EXCLAMATION);
			cmbCategoria.setFocus(true);
			vacio = true;
		} else {
			if (cmbEquipo.getSelectedIndex() == -1) {
				Mensaje.mostrarMensaje("Seleccione un equipo", Mensaje.ERROR,
						Messagebox.EXCLAMATION);
				cmbEquipo.setFocus(true);
				vacio = true;
//			} else {
//				System.out.println(spCantidad.getValue());
//				if (spCantidad.getValue() != null ) {
//					if(spCantidad.getValue()<0){
//						System.out.println(spCantidad.getValue());
//						Mensaje.mostrarMensaje("Cantidad no válida", Mensaje.ERROR,
//								Messagebox.EXCLAMATION);
//						spCantidad.setFocus(true);
//						vacio = true;
//						}
//				}
			}
		}
		return vacio;
	}

	// Actualiza el Nro del jugador
	public void actualizarNroJugador() {
		int nro = Integer.valueOf(bboxNumero.getValue());
		jugador.setNumero(nro);
		servicioJugador.actualizar(jugador);
	}

	// Cambia de estatus el registro anterior del roster
	public void cambiarEstatusRoster() {
		roster.setEstatus(EstatusRegistro.ELIMINADO);
		servicioRoster.actualizar(roster);
	}
	
	// Agrega un nuevo registro del roster
	public void nuevoRoster() {
		roster.setEstatus(EstatusRegistro.ACTIVO);
		roster.setEquipo(equipo);
		roster.setFechaIngreso(new Date());
		servicioRoster.agregar(roster);
	}



	// Agrega el registro en la tabla ascenso correspondiente al roster
	public void agregarAscenso() {
		ascenso.setEstatus(EstatusRegistro.ACTIVO);
		ascenso.setRoster(roster);
		ascenso.setTipoAscenso(tipoAscenso.getNombre());
		ascenso.setFechaAscenso(new Date());
		servicioAscenso.agregar(ascenso);
	}
}
