package controlador.jugador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.event.ForwardEvent;

import modelo.Categoria;
import modelo.Divisa;
import modelo.Equipo;
import modelo.Institucion;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.*;

import comun.ConeccionBD;

import controlador.jugador.restriccion.Restriccion;

import servicio.implementacion.ServicioDivisa;
import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioEquipo;
import servicio.implementacion.ServicioInstitucion;

import java.awt.FlowLayout;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import javax.xml.bind.ParseConversionEvent;

/**
 * Clase controladora de los eventos de la vista de igual nombre el presente
 * controlador se encarga de agregar, eliminar logicamente y modifica
 * 
 * @author Miguel B
 * @author Benjamin S.
 * @author Cesar P
 * 
 * @version 4.0 6/02/2012
 * 
 * */


public class CntrlConfigurarCategoria extends GenericForwardComposer {

 private Textbox txtNombre;
 private Textbox txtEdadInferior;
 private Textbox txtEdadSuperior;
 private Intbox intEdadInferior;
 private Intbox intEdadSuperior;
 private Spinner spCantidadEquipo;
 private Spinner spEdadInferior;
 private Spinner spEdadSuperior;
 
 ServicioCategoria servicioCategoria;
 ServicioEquipo servicioEquipo;
 private Equipo equipo = new Equipo();
 private Categoria categoria = new Categoria();
 private Listbox listCategoria;
 private Listbox listEquipo;
 List<Categoria> listaCategoria;
 List<Categoria> categorias;
 List<Equipo> listaEquipo;
 private AnnotateDataBinder binder ;
 private Listcell item2;
 Button btnAgregar, btnQuitar, btnModificar,btnCancelar,btnSalir,btnAumentarES,btnAumentarEI,btnDisminuirES,btnDisminuirEI;
 private int edadInferior,edadSuperior;

 Iframe ifReporte;
 
 private Connection con;
	private String jrxmlSrc;
	private Map parameters = new HashMap();
	
 
 
 
    public void onCreate$winConfigurarCategoria(ForwardEvent event) {
	    // get the databinder for later extra load and save
	    // note: binder is not ready in doAfterCompose, so do it here
    	inicializar();
	  }
 
    public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);  //Hacemos visible el modelo para el databinder
		listaCategoria=servicioCategoria.listar();
		aplicarConstraints();
		

	}
	
	public void onSelect$listCategoria() {
		// btnagregar.setDisabled(false);
		btnModificar.setDisabled(false);
		btnQuitar.setDisabled(false);
		btnAgregar.setDisabled(true);
	}
	
	
	
	public  List<Categoria> getCategorias(){
		
		 return servicioCategoria.listar();
	}
	
	public void onClick$btnAumentarEI(){
		
		
		
		/*if (listaCategoria.get(0).equals(listaCategoria.get(0).getEdadInferior()) && listaCategoria.get(0).equals(listaCategoria.get(0).getEdadSuperior())){
				    edadInferior+=3;
					intEdadInferior.setValue(edadInferior);
					edadInferior+=2;
				    intEdadSuperior.setValue(edadInferior);
			}
			else {
				edadInferior+=2;
				intEdadInferior.setValue(edadInferior);
				edadInferior++;
			    intEdadSuperior.setValue(edadInferior);
				
	  
	   
			}*/
		 
		 edadInferior = (intEdadInferior.getValue());
		 edadInferior++;
		 intEdadInferior.setValue(edadInferior);
		 edadSuperior  = (intEdadSuperior.getValue());
		 edadInferior++;
		 intEdadSuperior.setValue(edadInferior);
		
	    
	}
	
	public void onClick$btnAumentarES(){
		
		 edadInferior = (intEdadInferior.getValue());
		 edadInferior++;
		 intEdadInferior.setValue(edadInferior);
		 edadSuperior  = (intEdadSuperior.getValue());
		 edadInferior++;
		 intEdadSuperior.setValue(edadInferior);
		
	}
	
	public void onClick$btnDisminuirES(){
		
		 edadSuperior = (intEdadInferior.getValue());
		 --edadSuperior;
		 intEdadInferior.setValue(edadInferior);
		 edadSuperior  = (intEdadSuperior.getValue());
		 --edadSuperior;
		 intEdadSuperior.setValue(edadSuperior); 
	}
	
	public void onClick$btnDisminuirEI(){
		  
		 edadSuperior = (intEdadInferior.getValue());
		 --edadSuperior;
		 intEdadInferior.setValue(edadInferior);
		 edadSuperior  = (intEdadSuperior.getValue());
		 --edadSuperior;
		 intEdadSuperior.setValue(edadSuperior); 
	}
	
	
	public void onClick$btnAgregar(){
		
	
	   edadInferior = (intEdadInferior.getValue());
	   edadSuperior = (intEdadSuperior.getValue());
		if (txtNombre.getText() == "") {
			alert("Seleccione una nombre");
			txtNombre.focus();
		} else if (edadInferior == 0) {
			alert("Seleccione una edad inferior");
			intEdadInferior.focus();
		} else if (edadSuperior == 0) {
			alert("Seleccione una edad superior");
			intEdadSuperior.focus();
		} else if (spCantidadEquipo.getValue() == 0) {
							alert("Seleccione la cantidad de equipos");
							spCantidadEquipo.focus();
		} else {	
	    if(validar()){
		   for (int i = 0; i < listaCategoria.size(); i++) {
			 if(txtNombre.getValue().equals(listaCategoria.get(i).getNombre())){
							alert("Ya existe la categoria");
							 return;
					 }
			
			 else if(intEdadInferior.getValue().equals(listaCategoria.get(i).getEdadInferior()) && intEdadSuperior.getValue().equals(listaCategoria.get(i).getEdadSuperior())) {
							alert("Edades ya asignadas");
							 return;
							
			         }
			
	        }			
			categoria.setEstatus('A');
			categoria.setNombre(txtNombre.getValue());
			categoria.setCantidadEquipo(spCantidadEquipo.getValue());
			categoria.setEdadInferior(intEdadInferior.getValue());
			categoria.setEdadSuperior(intEdadSuperior.getValue());
		    categoria.setCodigoCategoria(servicioCategoria.listar().size()+1);
		    servicioCategoria.agregar(categoria);
		   
			 try {
				Messagebox.show("Categoria agregada", "Exito", Messagebox.OK, Messagebox.INFORMATION);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 limpiar(); 
			 }
		}
		 
	}

   public void onClick$btnQuitar(){
	
		if (categoria!= null){
			   
				if (listCategoria.getSelectedIndex() >= 0) {
					
					Categoria categoriaTemp = (Categoria) listCategoria.getSelectedItem().getValue();
					  if (servicioCategoria.buscarPorCodigo(categoria)==false)
					//System.out.println(servicioCategoria.buscarPorCodigo(categoria));
						alert ("No se puede borrar mientras existan equipos en esta categoria");
					  else {
					 
						categoria.setEstatus('E');
			            listaCategoria.remove(categoriaTemp);
						servicioCategoria.eliminar(categoriaTemp);
						 try {
								Messagebox.show("Categoria eliminada", "Exito", Messagebox.OK, Messagebox.INFORMATION);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							 limpiar(); 
							 }  
					    }
					
					} 
				
				else {
					alert("Seleccione un dato para eliminar.");
				 } 
			
		}
		
  
  
	private void aplicarConstraints() {
		// Registro Jugador
		
		txtNombre.setConstraint(Restriccion.TEXTO_SIMPLE
				.asignarRestriccionExtra("no empty"));
	
		spCantidadEquipo.setConstraint(Restriccion.CANTIDAD_EQUIPO
				.getRestriccion());
		/*intEdadInferior.setConstraint(Restriccion.EDAD_INFERIOR
				.getRestriccion());
		intEdadSuperior.setConstraint(Restriccion.EDAD_SUPERIOR
				.getRestriccion());*/
		
		
		
	}
	
	public void onClick$btnModificar() throws InterruptedException{
		
				
		if (categoria!= null){
			edadInferior = (intEdadInferior.getValue());
		    edadSuperior = (intEdadSuperior.getValue());
			categoria.setNombre(txtNombre.getValue());
			categoria.setEdadInferior(edadInferior);
			categoria.setEdadSuperior(edadSuperior);
			categoria.setCantidadEquipo(spCantidadEquipo.getValue());
			categoria.setEstatus('A');
			
			servicioCategoria.actualizar(categoria);
			
			 try {
					Messagebox.show("Categoria modificada", "Exito", Messagebox.OK, Messagebox.INFORMATION);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 limpiar();
			
		}
		else{
			alert("Seleccione un dato");
		}
		
		
	}
	
	public void limpiar(){
		categoria= new Categoria();
		binder.loadAll();
		inicializar();
	}
	
	
	public void onSelect$spCantidadEquipo(){
		binder.loadAll();
	}
	
	public void onSelect$txtNombre(){
		binder.loadAll();
	}
	
	
	public void onClick$btnCancelar(){
		limpiar();
	}
	
	public void inicializar() {
	   
	
		//spEdadInferior.setValue(1);
		intEdadInferior.setValue(3);
		intEdadSuperior.setValue(5);
		btnAgregar.setDisabled(false);
		btnQuitar.setDisabled(true);
		btnModificar.setDisabled(true);
	    btnSalir.setDisabled(false);
		btnCancelar.setDisabled(false);
		
	}
	
	public boolean validar() {
		
		int edadInferior = (intEdadInferior.getValue());
	    int edadSuperior = (intEdadSuperior.getValue());
	    
		 if (spCantidadEquipo.getValue()==0 && edadInferior==0 && edadSuperior==0 ){
			 alert("Ningun dato numerico puede ser cero (0)");
			 txtEdadInferior.setFocus(true);
			 return false;
	         }
		 else if (edadInferior > edadSuperior ){
						 alert("La edad inferior es mayor a edad superior");
						 spEdadInferior.setFocus(true);
						 return false;
				         }
			
					 else {
						 int dif =  edadSuperior - edadInferior ;
						
						 if ( dif > 1 ){
							 alert("Rango de edad no permitido en esta categoria");
							 intEdadInferior.setFocus(true);
							 return false;
								
						 }
						 
						
								
				
					 }
			
	       return true; 
		}
	
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
		final AMedia amedia = new AMedia("CatalogoDeCategorias.pdf","pdf","pdf/application", arrayOutputStream.toByteArray());
		ifReporte.setContent(amedia);
	}
	// ---------------------------------------------------------------------------------------------------
	public void onClick$btnImprimir() throws SQLException, JRException, IOException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/Reporte_Categoria.jrxml");
		//parameters.put("NombreRepre",txtNombres.);
		showReportfromJrxml();
	}
}

