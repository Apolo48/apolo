package controlador.jugador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Iframe;

import comun.ConeccionBD;
import comun.Ruta;

import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioLapsoDeportivo;

import modelo.Categoria;
import modelo.LapsoDeportivo;

public class CntrlReporteInscritosRetirados extends GenericForwardComposer {
	
	private Component formulario;
	private Iframe ifReport;
	private Jasperreport jReport;
	private Map parameters = new HashMap();
	private Connection con;
	private String jrxmlSrc;
	private String jasperSrc;
	
	// Servicios
	private ServicioLapsoDeportivo servicioLapsoDeportivo;
	private ServicioCategoria servicioCategoria;
	
	private String rutasGen = Ruta.GENERAL.getRutaVista();
	
	// Binder
	private AnnotateDataBinder binder;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		formulario  = comp;
	}
	
	/*public List<LapsoDeportivo> getLapsosDeportivo() {
		return servicioLapsoDeportivo.listar();*/
	public List<Categoria> getLapsosDeportivo() {
		return servicioCategoria.listar();
	}
	
	//Metodos del Controlador
	public void mostrarVisor() throws JRException {
		/*
		 * Funciona para IExplorer, Firefox, Chrome y Opera
		 * Permite ver, guardar e imprimir, todo desde el visor
		 * Observacion: uso de codigo mas sencillo para generar pdf
		 * El codigo usado en mostrarFrame tambien puede usarse en este caso
		 * */
		JasperReport jasp = JasperCompileManager.compileReport(jrxmlSrc);
		JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, con);
		
		byte[] archivo = JasperExportManager.exportReportToPdf(jaspPrint);//Generar Pdf
		final AMedia amedia = new AMedia("inscritosRetirados.pdf","pdf","application/pdf", archivo);
		
		
		Component visor = Executions.createComponents(rutasGen
					+ "frmVisorDocumento.zul", null, null);
			visor.setVariable("archivo", amedia, false);
	}
	
	public void mostrarFrame() throws JRException, IOException {
		/*
		 * Funciona para IExplorer, Firefox, Chrome y Opera
		 * Permite ver, guardar e imprimir, todo desde el iframe
		 * Desventaja, debe usarse con un zul con ancho adecuado al reporte
 		 * Observacion: uso de codigo algo mas complejo para generar pdf
		 * El codigo usado en mostrarVisor no puede usarse en este caso
		 * */
		JasperReport jasp = JasperCompileManager.compileReport(jrxmlSrc);
		JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, con);
		
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameters(parameters);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT ,jaspPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,arrayOutputStream);
		exporter.exportReport();
		arrayOutputStream.close();
		ifReport.setVisible(true);
		final AMedia amedia = new AMedia("inscritosRetirados.pdf","pdf","application/pdf", arrayOutputStream.toByteArray());
		
		ifReport.setContent(amedia);
	}
	
/*	public void exportarArchivo() throws JRException, IOException {
		
		 * 1-Funciona para IExplorer desde el zul o visor, no permite exportar (ventana guardar)
		 * 2-Funciona para Firefox, abre ventana para exportar
		 * 3-No funciona en Chrome, ni en visor o zul, ni permite exportar
		 * 4-Opera falta prueba - Posiblemente funcione por pruebas anteriores
		 * 
		JasperReport jasp = JasperCompileManager.compileReport(jrxmlSrc);
		JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, con);
		
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameters(parameters);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT ,jaspPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,arrayOutputStream);
		exporter.exportReport();
		arrayOutputStream.close();
		
		ifReport.setVisible(true);
		final AMedia amedia = new AMedia("inscritosRetirados.pdf","pdf","pdf/application", arrayOutputStream.toByteArray());
		ifReport.setContent(amedia);
	}*/
	
	public void mostrarViewer() throws JRException {
		/*
		 * Funciona para IExplorer, Firefox, Chrome y Opera
		 * Permite ver, guardar e imprimir, todo desde el jasperViewer
		 * Observacion: no es necesario crea pdf
		 * Tiene opcion de guardar en diferentes formatos pero se pierden datos en Docx y HTML
		 * guarda bien en PDF
		 * */
		JasperReport jasp = JasperCompileManager.compileReport(jrxmlSrc);
		JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, con);
		
		JasperViewer.viewReport(jaspPrint, false);
	}
	
	public void imprimirReporte() throws JRException {
		/*
		 * Funciona para IExplorer, Firefox, Chrome y Opera
		 * Permite imprimir desde PrintDialog de java
		 * */
		JasperReport jasp = JasperCompileManager.compileReport(jrxmlSrc);
		JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, con);
		
		JasperPrintManager.printReport(jaspPrint, true);
	}
	
	public void exportarReporte() throws JRException {
		/*
		 * Funciona para Firefox, Chrome y Opera
		 * No Funciona en IExplorer
		 * Permite crea un pdf en la ruta indicada
		 * */
		JasperReport jasp = JasperCompileManager.compileReport(jrxmlSrc);
		JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, con);
		
		/*String destino = "C://inscritosRetirados.pdf"; //DEBE SER PARAMETRO
		JasperExportManager.exportReportToPdfFile(jaspPrint, destino);*/
		
		byte[] archivo = JasperExportManager.exportReportToPdf(jaspPrint);//Generar Pdf
		final AMedia amedia = new AMedia("inscritosRetirados.pdf","pdf","application/pdf", archivo);
		 
		Filedownload.save(amedia);
	}
	
	//Eventos
	public void onClick$btnImprimirVisor() throws SQLException, JRException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/inscritosRetirados.jrxml");
		parameters.put("temporada","k");
		mostrarVisor();
	}
	
	public void onClick$btnImprimirFrame() throws SQLException, JRException, IOException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/inscritosRetirados.jrxml");
        parameters.put("temporada","2011-2012");
		mostrarFrame();
	}
	
/*	public void onClick$btnImprimirExportar() throws SQLException, JRException, IOException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/inscritosRetirados.jrxml");
		parameters.put("temporada","2011-2012");
		exportarArchivo();
	}*/
	
	public void onClick$btnImprimirViewer() throws SQLException, JRException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/inscritosRetirados.jrxml");
		parameters.put("temporada","2011-2012");
		mostrarViewer();
	}
	
	public void onClick$btnImprimirReporte() throws SQLException, JRException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/inscritosRetirados.jrxml");
		parameters.put("temporada","2011-2012");
		imprimirReporte();
	}
	
	public void onClick$btnExportarReporte() throws SQLException, JRException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/inscritosRetirados.jrxml");
        parameters.put("temporada","2011-2012");
        exportarReporte();
	}
	
}