package controlador.jugador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import modelo.DocumentoAcreedor;
import modelo.FamiliarJugador;
import modelo.Jugador;
import modelo.Roster;

import modelo.Persona;
import modelo.PersonaNatural;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Textbox;

import servicio.implementacion.ServicioJugador;
import servicio.implementacion.ServicioRoster;

import comun.ConeccionBD;
import comun.EstatusRegistro;

public class CntrlExpedienteJugador extends GenericForwardComposer {
	Component component;
	private Component formulario;
	private AnnotateDataBinder binder;
	private ServicioRoster servicioRoster;
	private ServicioJugador servicioJugador;
	Textbox txtCedula;
	private Textbox txtPrimerNombre;
	private Textbox txtSegundoNombre;
	private Textbox txtPrimerApellido;
	private Textbox txtSegundoApellido;
	Button btnCancelar, btnImprimir, btnCatalogoJugador;
	Iframe ifReport;
	Map parameters = new HashMap();
	private Connection con;
	private String jrxmlSrc;
	Jugador jugador;
	Roster roster;
	PersonaNatural personaN = new PersonaNatural();
	
	
	public Textbox getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(Textbox txtCedula) {
		this.txtCedula = txtCedula;
	}

	public Textbox getTxtPrimerNombre() {
		return txtPrimerNombre;
	}

	public void setTxtPrimerNombre(Textbox txtPrimerNombre) {
		this.txtPrimerNombre = txtPrimerNombre;
	}

	public Textbox getTxtSegundoNombre() {
		return txtSegundoNombre;
	}

	public void setTxtSegundoNombre(Textbox txtSegundoNombre) {
		this.txtSegundoNombre = txtSegundoNombre;
	}

	public Textbox getTxtPrimerApellido() {
		return txtPrimerApellido;
	}

	public void setTxtPrimerApellido(Textbox txtPrimerApellido) {
		this.txtPrimerApellido = txtPrimerApellido;
	}

	public Textbox getTxtSegundoApellido() {
		return txtSegundoApellido;
	}

	public void setTxtSegundoApellido(Textbox txtSegundoApellido) {
		this.txtSegundoApellido = txtSegundoApellido;
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		formulario  = comp;
	}
	
	// ---------------------------------------------------------------------------------------------------
	public void showReportfromJrxml() throws JRException, IOException{
		JasperReport jasp = JasperCompileManager.compileReport(jrxmlSrc);
		JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, con);
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameters(parameters);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT ,jaspPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,arrayOutputStream);
		exporter.exportReport();
		arrayOutputStream.close();
		final AMedia amedia = new AMedia("Expediente.pdf","pdf","pdf/application", arrayOutputStream.toByteArray());
		ifReport.setContent(amedia);
	}
	// ---------------------------------------------------------------------------------------------------
	public void onClick$btnImprimir() throws SQLException, JRException, IOException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/ExpedienteJugador.jrxml");
		parameters.put("cedulajug_1",txtCedula.getText());
		//parameters.put("fechemihas_1",dtbFechaEmiHasta.getText() );
		//parameters.put("fechvendes_1", dtbFechaVenDesde.getText());
		//parameters.put("fechvenchas_1", dtbFechaVenHasta.getText());
		showReportfromJrxml();
	}
	
		
	public void onClick$btnCatalogoJugador() {
		// se crea el catalogo y se llama
		Component catalogo = Executions.createComponents("/Jugador/Vistas/frmBuscarJugador.zul", null, null);
		// asigna una referencia del formulario al catalogo.
		catalogo.setVariable("formulario", formulario, false);
		catalogo.setVariable("estatus", EstatusRegistro.ACTIVO, false);
		formulario.addEventListener("onCatalogoBuscarJugadorCerrado", new EventListener() {

			@Override
			public void onEvent(Event arg0) throws Exception {
				jugador = (Jugador) formulario.getVariable("jugador",false);
				txtCedula.setValue(jugador.getCedulaRif());				
				txtPrimerNombre.setValue(jugador.getPersonaNatural().getPrimerNombre());
				txtSegundoNombre.setValue(jugador.getPersonaNatural().getSegundoNombre());
				txtPrimerApellido.setValue(jugador.getPersonaNatural().getPrimerApellido());
				txtSegundoApellido.setValue(jugador.getPersonaNatural().getSegundoApellido());
				
				java.util.Date date = new java.util.Date();
				date = jugador.getPersonaNatural().getPersona().getFechaIngreso();
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
				String fecha = sdf.format(date);
				
							
				roster= servicioRoster.buscarRoster(jugador.getCedulaRif());
				binder.loadAll();

			} 
		});
	}
	
}
