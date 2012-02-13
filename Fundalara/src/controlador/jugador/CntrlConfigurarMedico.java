package controlador.jugador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.zkoss.util.media.AMedia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javassist.expr.NewArray;

import org.hibernate.mapping.Array;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;



import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Window;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.implementacion.ServicioMedico;
import servicio.implementacion.ServicioDatoBasico;

import comun.ConeccionBD;
import comun.Ruta;

import comun.TipoDatoBasico;

import modelo.Medico;

import modelo.DatoBasico;

/**
 * Clase controladora de los eventos de la vista de igual nombre el presente
 * controlador se encarga de agregar, eliminar logicamente y modifica
 * 
 * 
 * @author Robert A
 * @author Miguel B
 * 
 * @version 4.0 6/02/2012
 * 
 * */
public class CntrlConfigurarMedico extends GenericForwardComposer {
	private ServicioMedico servicioMedico;
	private ServicioDatoBasico servicioDatoBasico;

	// private DatoBasico especialidad = new DatoBasico();
	private Medico medico = new Medico();
	Window winConfigurarMedico;

	Button btnGuardar;
	Button btnModificar;
	Button btnEliminar;
	Button btnCancelar;
	Button btnSalir;
	Button btnBuscar;


	private Connection con;
	private String jrxmlSrc;
	private Map parameters = new HashMap();
	
	private String rutasGen = Ruta.GENERAL.getRutaVista();

	Listbox listmedico;
	
	Textbox txtApellido,txtTelefonoCelular,txtTelefonoHabitacion,txtNumcol, txtCedula,txtMatricula,txtNombre;
	Component formulario;
	private Combobox cmbEspecialidad,cmbNacionalidad,cmbCodCelular,cmbCodArea;
	
	List<Medico> medicos = new ArrayList<Medico>();
	List<DatoBasico> codigosArea;
	List<DatoBasico> codigosCelular;
	List<DatoBasico> especialidades = new ArrayList<DatoBasico>() ;


	private AnnotateDataBinder binder;

	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, true);
		// se guarda la referencia al formulario actual
		formulario = comp;
		txtNumcol.setFocus(true);
		btnModificar.setDisabled(true);
		btnEliminar.setDisabled(true);
		medicos=servicioMedico.listar();
		
		
		

	}

	public void onClick$btnGuardar() {
		
		if(txtApellido.getValue()!= "" && txtNombre.getValue()!= "" && txtTelefonoCelular.getValue().toString().length()==7 
				&& txtTelefonoHabitacion.getValue().toString().length()==7 
				&& txtNumcol.getValue()!="" && txtNumcol.getValue().toString().length()==6
				&& txtCedula.getValue()!="" && cmbEspecialidad.getSelectedIndex()!=-1
				&& cmbNacionalidad.getSelectedIndex()!=-1 && cmbCodCelular.getSelectedIndex()!=-1
				&& cmbCodArea.getSelectedIndex()!=-1 && txtMatricula.getValue()!="" 
				&& txtMatricula.getValue().length()==6) {		
		especialidades=servicioDatoBasico.buscar(TipoDatoBasico.ESPECIALIDAD);
		medico.setApellido(txtApellido.getValue().toUpperCase());
		medico.setNombre(txtNombre.getValue().toUpperCase());
		medico.setCedulaMedico(cmbNacionalidad.getValue().toUpperCase()+"-"+txtCedula.getValue().toString().toUpperCase());
		medico.setTelefonoCelular(codigosCelular.get(cmbCodCelular.getSelectedIndex()).getNombre()+"-"+txtTelefonoCelular.getValue().toUpperCase());
		medico.setDatoBasico(especialidades.get(cmbEspecialidad.getSelectedIndex()));
		medico.setTelefonoOficina(codigosArea.get(cmbCodArea.getSelectedIndex()).getNombre()+"-"+txtTelefonoHabitacion.getValue().toUpperCase());
		medico.setEstatus('A');
		Date fecha = new Date();
		medico.setFechaIngreso(fecha);
		servicioMedico.agregar(medico);
		limpiar();
		}
		else{
			alert("Debe Completar los Datos Necesarios para Guardar el Medico");
		}
		
	}
	
	public void onBlur$txtNumcol(){
		if(servicioMedico.buscar(txtNumcol.getValue().toString())!=null){
			alert("El Numero de Colegio Ya Existe");
			txtNumcol.setRawValue(null);
		}
		
	}

	public void onClick$btnModificar() throws InterruptedException {
		if(txtApellido.getValue()!= "" && txtNombre.getValue()!= "" && txtTelefonoCelular.getValue().toString().length()==7 
				&& txtTelefonoHabitacion.getValue().toString().length()==7 
				&& txtNumcol.getValue()!="" && txtNumcol.getValue().toString().length()==6
				&& txtCedula.getValue()!="" && txtMatricula.getValue()!="" 
				&& txtMatricula.getValue().length()==6){
		especialidades=servicioDatoBasico.buscar(TipoDatoBasico.ESPECIALIDAD);
		medico.setApellido(txtApellido.getValue().toUpperCase());
		medico.setNombre(txtNombre.getValue().toUpperCase());
		medico.setCedulaMedico(cmbNacionalidad.getValue()+"-"+txtCedula.getValue().toString());
		medico.setTelefonoCelular(cmbCodCelular.getValue()+"-"+txtTelefonoCelular.getValue());
		medico.setDatoBasico(especialidades.get(buscaresps(cmbEspecialidad.getValue())));
		medico.setTelefonoOficina(cmbCodArea.getValue()+"-"+txtTelefonoHabitacion.getValue());
		medico.setEstatus('A');
		Messagebox.show("Esta seguro que Desea Modificar el Medico?", "MODIFICAR", Messagebox.YES|Messagebox.NO, Messagebox.QUESTION,
			     new EventListener() {
			       public void onEvent(Event evt) {
			         switch (((Integer)evt.getData()).intValue()) {
			           case Messagebox.YES: actualizar(); break; 
			           case Messagebox.NO: limpiar(); break; 
			      }
			    }
			   });
		}
		else{
			alert("Debe Completar los Datos Necesarios para Registro de el Medico");
		}
	}

	public void actualizar(){
		servicioMedico.actualizar(medico);
		limpiar();
	}


	public void onClick$btnEliminar() throws InterruptedException {
		Messagebox.show("Esta seguro que Desea Desactivar el Medico?", "ELIMINAR", Messagebox.YES|Messagebox.NO, Messagebox.QUESTION,
			     new EventListener() {
			       public void onEvent(Event evt) {
			         switch (((Integer)evt.getData()).intValue()) {
			           case Messagebox.YES: doYes(); break; 
			           case Messagebox.NO: break; 
			      }
			    }
			   });
		
		
		
	}
	
	public void doYes(){
		medico.setEstatus('E');
		servicioMedico.actualizar(medico);
		limpiar();
	}

	public void onClick$btnCancelar() {
		limpiar();
	}


	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public List<DatoBasico> getEspecialidades() {
		especialidades=servicioDatoBasico.buscar(TipoDatoBasico.ESPECIALIDAD);
		return servicioDatoBasico.buscar(TipoDatoBasico.ESPECIALIDAD);
	}
	
	public List<DatoBasico> getCodigosCelular() {
		codigosCelular=servicioDatoBasico.buscar(TipoDatoBasico.CODIGO_CELULAR);
		return servicioDatoBasico.buscar(TipoDatoBasico.CODIGO_CELULAR);
	}
	
	public List<DatoBasico> getCodigosArea() {
		codigosArea=servicioDatoBasico.buscar(TipoDatoBasico.CODIGO_AREA);
		return servicioDatoBasico.buscar(TipoDatoBasico.CODIGO_AREA);
	}

	public void setCodigosArea(List<DatoBasico> codigosArea) {
		this.codigosArea = codigosArea;
	}
	
	public void limpiar(){
		txtTelefonoCelular.setRawValue(null);
		txtTelefonoHabitacion.setRawValue(null);
		cmbEspecialidad.setValue("--Seleccione--");
		cmbNacionalidad.setValue("-");
		cmbCodCelular.setValue("--");
		cmbCodArea.setValue("--");
		txtCedula.setRawValue(null);
		medico = new Medico();
		txtNumcol.setReadonly(false);
		btnGuardar.setDisabled(false);
		btnModificar.setDisabled(true);
		btnEliminar.setDisabled(true);
		binder.loadAll();
		binder.loadComponent(listmedico);
		txtNumcol.setFocus(true);
		btnGuardar.setImage("/Recursos/Imagenes/agregar.ico");
		btnModificar.setImage("/Recursos/Imagenes/editar.ico");
		btnEliminar.setImage("/Recursos/Imagenes/quitar.ico");
	}

	public int buscaresp(Medico medico){
		for (int i = 0; i < especialidades.size(); i++) {
			if (especialidades.get(i).getNombre().equals(medico.getDatoBasico().getNombre())){
				return i;
			}
		}
		return -1;
	}
	
	public int buscaresps(String medico){
		for (int i = 0; i < especialidades.size(); i++) {
			if (especialidades.get(i).getNombre().equals(medico)){
				return i;
			}
		}
		return -1;
	}
	
	public int buscarcarea(Medico medico){
		for (int i = 0; i < codigosArea.size(); i++) {
			if (codigosArea.get(i).getNombre().equals(medico.getTelefonoOficina().substring(0,4))){
				return i;
			}
		}
		return -1;
	}
	
	public int buscarcelu(Medico medico){
		for (int i = 0; i < codigosCelular.size(); i++) {
			if (codigosCelular.get(i).getNombre().equals(medico.getTelefonoCelular().substring(0,4))){
				return i;
			}
		}
		return -1;
	}
	
	public int buscarnac(Medico medico){
		if (medico.getCedulaMedico().substring(0,1).equals("V")) {
			return 0;
		}
		else{ 
			if (medico.getCedulaMedico().substring(0,1).equals("E")) {
			return 1;
		}
			else{
				if (medico.getCedulaMedico().substring(0,1).equals("R")) {
					return 2;
				}
			}
		}
		return -1;
	}
	
	public  List<Medico> getMedicos() {
		return servicioMedico.filtrar("",""
				,"","");
		
	}
	
	
		
	public void onSelect$listmedico(){
		//System.out.println(listmedico.getSelectedIndex());
		medicos=servicioMedico.filtrar("",""
				,"","");
		medico = (Medico) medicos.get(listmedico.getSelectedIndex());
		cmbEspecialidad.setSelectedIndex(buscaresp(medico));
		cmbCodArea.setSelectedIndex(buscarcarea(medico));
		cmbCodCelular.setSelectedIndex(buscarcelu(medico));
		txtTelefonoCelular.setValue(medico.getTelefonoCelular().substring(5));
		txtTelefonoHabitacion.setValue(medico.getTelefonoOficina().substring(5));
		cmbNacionalidad.setSelectedIndex(buscarnac(medico));
		txtCedula.setValue(medico.getCedulaMedico().substring(2));
		txtNumcol.setReadonly(true);
		btnGuardar.setDisabled(true);
		btnModificar.setDisabled(false);
		if(medico.getEstatus()=='A'){
		btnEliminar.setDisabled(false);
		}
		else{
			btnEliminar.setDisabled(true);	
		}
		binder.loadAll();
		
	}
	
	public void onClick$btnSalir(){
		winConfigurarMedico.detach();
	}
	
	
	public void onClick$btnImprimir() throws SQLException, JRException, IOException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/ReporteListadoMedico.jrxml");
		//parameters.put("nombreTemporada",lapsoDeportivo.getNombre());
		mostrarVisor();
	}


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
	final AMedia amedia = new AMedia("ListadoDeMedicos.pdf","pdf","application/pdf", archivo);
	
	
	Component visor = Executions.createComponents(rutasGen
				+ "frmVisorDocumento.zul", null, null);
		visor.setVariable("archivo", amedia, false);
}
	
}
