package controlador.jugador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.*;

import comun.ConeccionBD;
import comun.Ruta;
import comun.TipoDatoBasico;
import modelo.Equipo;
import modelo.Institucion;
import modelo.DatoBasico;
import modelo.Medico;
import servicio.implementacion.ServicioDatoBasico;
import servicio.implementacion.ServicioInstitucion;

/**
 * Clase controladora de los eventos de la vista de igual nombre y manejo de los
 * servicios de datos para la configuración de la institución
 * 
 * @author Mariangel M
 * @version 0.1.0 29/12/2011
 * 
 * */

public class CntrlConfigurarInstitucion extends GenericForwardComposer {
	// Componentes visuales
	List<DatoBasico> datosbasicos;
	Textbox txtCodigo;
	Textbox txtNombre;
	Textbox txtDireccion;
	Window winconfigurarInstitucion;
	Combobox cmbTipo, cmbEstadoResi, cmbParroquiaResi, cmbMunicipioResi;
	AnnotateDataBinder binder;
	Component formulario;
	Listbox lboxInstitucion;
	Groupbox grboxInstitucion;
    Button btnGuardar, btnModificar, btnEliminar;
	
	// Servicios
	ServicioInstitucion servicioInstitucion;
	ServicioDatoBasico servicioDatoBasico;

	private Connection con;
	private String jrxmlSrc;
	private Map parameters = new HashMap();
	
	private String rutasGen = Ruta.GENERAL.getRutaVista();
	
	// Modelos
	private DatoBasico estado = new DatoBasico();
	private Institucion institucionlista = new Institucion();
	private Institucion institucion = new Institucion();
	private Institucion institucionAux = new Institucion();
	private List<Institucion> listaInstitucion = new ArrayList<Institucion>();
	
	// Getters y setters
	public DatoBasico getEstado() {
		return estado;
	}

	public void setEstado(DatoBasico estado) {
		this.estado = estado;
	}

	private DatoBasico municipio = new DatoBasico();

	public DatoBasico getMunicipio() {
		return municipio;
	}

	public void setMunicipio(DatoBasico municipio) {
		this.municipio = municipio;
	}

	private DatoBasico parroquia = new DatoBasico();

	public DatoBasico getParroquia() {
		return parroquia;
	}

	public void setParroquia(DatoBasico parroquia) {
		this.parroquia = parroquia;
	}

	private DatoBasico tipoinstitucion = new DatoBasico();

	public DatoBasico getTipoinstitucion() {
		return tipoinstitucion;
	}

	public void setTipoinstitucion(DatoBasico tipoinstitucion) {
		this.tipoinstitucion = tipoinstitucion;
	}

	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public List<DatoBasico> getDatosBasico() {
		return servicioDatoBasico.listar();
	}

	// Metodos para carga de combos/listbox
	public List<DatoBasico> getDatosBasicos() {
		return servicioDatoBasico.listar();
	}

	public List<DatoBasico> getTipoInstituciones() {
		return servicioDatoBasico.buscar(TipoDatoBasico.INSTITUCION);
	}

	public List<DatoBasico> getEstadosVenezuela() {
		return servicioDatoBasico.buscar(TipoDatoBasico.ESTADO_VENEZUELA);
	}

	public List<DatoBasico> getMunicipiosEstadosResi() {
		return servicioDatoBasico.buscarDatosPorRelacion(estado);
	}

	public List<DatoBasico> getParroquiasMunicipioResi() {
		return servicioDatoBasico.buscarDatosPorRelacion(municipio);
	}
    
	public List<Institucion> getListaInstitucion() {
		return listaInstitucion;
	}

	public void setListaInstitucion(List<Institucion> listaInstitucion) {
		this.listaInstitucion = listaInstitucion;
	}
	
	// Eventos
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("cntrl", this, true);
		// se guarda la referencia al formulario actual
		formulario = comp;
	}

	public void onClick$btnGuardar() throws InterruptedException {
		if (txtNombre.getText() == "") {
			alert("Seleccione un nombre");
			txtNombre.focus();
		} else if (cmbTipo.getText() == "") {
			alert("Seleccione un Tipo");
			cmbTipo.focus();
		} else if (cmbEstadoResi.getText() == "") {
			alert("Seleccione un Estado");
			cmbEstadoResi.focus();
		} else if (cmbMunicipioResi.getText() == "") {
			alert("Seleccione un Municipio");
			cmbMunicipioResi.focus();
		}
		
		else if (cmbParroquiaResi.getText() == "") {
			alert("Seleccione una Parroquia");
			cmbParroquiaResi.focus();
		}
		
		else if (txtDireccion.getText() == "") {
			alert("Seleccione una Dirección");
			txtDireccion.focus();
		}
		else{
		
		institucionAux = servicioInstitucion.buscarpornombre(txtNombre.getValue().toUpperCase());
		if (institucionAux!= null)
			alert("La Institución ya había sido agregada");
		else
		{
		
			Messagebox.show("Está seguro que desea agregar la institución?", "AGREGAR", Messagebox.YES|Messagebox.NO, Messagebox.QUESTION,
				     new EventListener() {
				       public void onEvent(Event evt) {
				         switch (((Integer)evt.getData()).intValue()) {
				           case Messagebox.YES: doyes2(); break; 
				           case Messagebox.NO: limpiar(); break; 
				      }
				    }
				   });
		
		}
		}
			
	
		
	}
	
	public void doyes2(){
		institucion.setCodigoInstitucion(servicioInstitucion.listar().size() + 1);
		institucion.setNombre(txtNombre.getValue().toUpperCase());
		institucion.setDireccion(txtDireccion.getValue().toUpperCase());
		institucion.setDatoBasicoByCodigoParroquia(parroquia);
		institucion.setEstatus('A');
		institucion.setDatoBasicoByCodigoTipoInstitucion(tipoinstitucion);
		 servicioInstitucion.agregar(institucion);
		listaInstitucion = servicioInstitucion.buscarInstitucionTipo(tipoinstitucion);
		limpiar();
		binder.loadComponent(cmbTipo);
		binder.loadComponent(lboxInstitucion);
	}
	
    
	public void onClick$btnModificar() throws InterruptedException {
		if (txtNombre.getText() == "") {
			alert("Seleccione un nombre");
			txtNombre.focus();
		} else if (cmbTipo.getText() == "") {
			alert("Seleccione un Tipo");
			cmbTipo.focus();
		} else if (cmbEstadoResi.getText() == "") {
			alert("Seleccione un Estado");
			cmbEstadoResi.focus();
		} else if (cmbMunicipioResi.getText() == "") {
			alert("Seleccione un Municipio");
			cmbMunicipioResi.focus();
		}
		
		else if (cmbParroquiaResi.getText() == "") {
			alert("Seleccione una Parroquia");
			cmbParroquiaResi.focus();
		}
		
		else if (txtDireccion.getText() == "") {
			alert("Seleccione una Dirección");
			txtDireccion.focus();
		}
		else{
		
	
		Messagebox.show("Está seguro que desea modifciar la institución?", "MODIFICAR", Messagebox.YES|Messagebox.NO, Messagebox.QUESTION,
			     new EventListener() {
			       public void onEvent(Event evt) {
			         switch (((Integer)evt.getData()).intValue()) {
			           case Messagebox.YES: doyes1(); break; 
			           case Messagebox.NO: limpiar(); break; 
			      }
			    }
			   });
		//servicioInstitucion.actualizar(institucion);
		
		}
	}
	
	public void doyes1(){
		institucion = servicioInstitucion.buscar(listaInstitucion.get(lboxInstitucion.getSelectedIndex()).getCodigoInstitucion());
		institucion.setNombre(txtNombre.getValue().toUpperCase());
		institucion.setDireccion(txtDireccion.getValue().toUpperCase());
		institucion.setDatoBasicoByCodigoParroquia(parroquia);
		institucion.setDatoBasicoByCodigoTipoInstitucion(tipoinstitucion);
		institucion.setEstatus('A');
		servicioInstitucion.actualizar(institucion);
		listaInstitucion = servicioInstitucion.buscarInstitucionTipo(tipoinstitucion);
		limpiar();
		binder.loadComponent(cmbTipo);
		binder.loadComponent(lboxInstitucion);
	}
	
	public void onClick$btnEliminar() throws InterruptedException {
		
		Messagebox.show("Está seguro que desea eliminar la institución?", "ELIMINAR", Messagebox.YES|Messagebox.NO, Messagebox.QUESTION,
			     new EventListener() {
			       public void onEvent(Event evt) {
			         switch (((Integer)evt.getData()).intValue()) {
			           case Messagebox.YES: doyes(); break; 
			           case Messagebox.NO: limpiar(); break; 
			      }
			    }
			   });
		//servicioInstitucion.actualizar(institucion);
		
		
	}
	
	public void doyes(){
		institucion = servicioInstitucion.buscar(listaInstitucion.get(lboxInstitucion.getSelectedIndex()).getCodigoInstitucion());
		institucion.setEstatus('E');
		servicioInstitucion.actualizar(institucion);
		listaInstitucion = servicioInstitucion.buscarInstitucionTipo(tipoinstitucion);
		tipoinstitucion=institucion.getDatoBasicoByCodigoTipoInstitucion();
		limpiar();
		
		binder.loadComponent(cmbTipo);
		binder.loadComponent(lboxInstitucion);
	}
	
	
	
	public void limpiar() {
		btnGuardar.setDisabled(false);
		btnModificar.setDisabled(true);
		btnEliminar.setDisabled(true);
		institucion = new Institucion();
		binder.loadAll();
		txtNombre.setRawValue(null);
		txtDireccion.setRawValue(null);
		cmbParroquiaResi.setSelectedIndex(-1);
		cmbEstadoResi.setSelectedIndex(-1);
		cmbMunicipioResi.setSelectedIndex(-1);
		cmbParroquiaResi.setText("");
		cmbEstadoResi.setText("");
		cmbMunicipioResi.setText("");
		estado=new DatoBasico();
		municipio=new DatoBasico();
		parroquia=new DatoBasico();
	
	}

	public void onClick$btnCancelar() {
		limpiar();
	}

	

	public void onChange$cmbTipo() {
		
		DatoBasico datoB = ((DatoBasico) cmbTipo.getSelectedItem().getValue());
		listaInstitucion = servicioInstitucion
				.buscarInstitucionTipo(datoB);
		

	}
	
	public void onSelect$lboxInstitucion() {
		txtNombre.setValue(listaInstitucion.get(lboxInstitucion.getSelectedIndex()).getNombre());
		txtDireccion.setValue(listaInstitucion.get(lboxInstitucion.getSelectedIndex()).getDireccion());
		parroquia = listaInstitucion.get(lboxInstitucion.getSelectedIndex()).getDatoBasicoByCodigoParroquia(); 
		cmbParroquiaResi.setValue(parroquia.getNombre());
		municipio = parroquia.getDatoBasico();
		cmbMunicipioResi.setValue(municipio.getNombre());
		estado = municipio.getDatoBasico(); 	
		cmbEstadoResi.setValue(estado.getNombre());
		cmbTipo.setValue(listaInstitucion.get(lboxInstitucion.getSelectedIndex()).getDatoBasicoByCodigoTipoInstitucion().getNombre());
		if (listaInstitucion.get(lboxInstitucion.getSelectedIndex()).getEstatus()=='E')
		{
			btnGuardar.setDisabled(true);
			btnModificar.setDisabled(false);
			btnEliminar.setDisabled(true);
		}
		else 
		{
		btnGuardar.setDisabled(true);
		btnModificar.setDisabled(false);
		btnEliminar.setDisabled(false);
		}
		
	}
	
	public void onClick$btnSalir(){
		winconfigurarInstitucion.detach();
	}
	
	public void onClick$btnImprimir() throws SQLException, JRException, IOException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/Reporte_Institucion.jrxml");
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
	final AMedia amedia = new AMedia("ListadoDeInstituciones.pdf","pdf","application/pdf", archivo);
	
	
	Component visor = Executions.createComponents(rutasGen
				+ "frmVisorDocumento.zul", null, null);
		visor.setVariable("archivo", amedia, false);
}
	

}
