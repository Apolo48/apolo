package controlador.jugador;


import java.util.ArrayList;
import java.util.List;

import org.jruby.ext.posix.FreeBSDHeapFileStat.time_t;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;


import modelo.Categoria;
import modelo.ClasificacionEquipo;
import modelo.Divisa;
import modelo.Equipo;
import modelo.TipoActividadSocial;
import modelo.ValorEscalaMedicion;
import servicio.jugador.ServicioCategoria;
import servicio.jugador.ServicioClasificacionEquipo;
import servicio.jugador.ServicioEquipo;
import servicio.compentencia.*;

/**
 * Clase controladora de los eventos de la vista de igual nombre.
 * 
 * @author Robert A 
 * 
 * @version 1.0 22/11/2011
 *
 * */
public class ConfigurarEquipoCtrl extends GenericForwardComposer {
	ServicioCategoria servicioCategoria;
	ServicioEquipo servicioEquipo;
	ServicioDivisa servicioDivisa;
	ServicioClasificacionEquipo servicioClasificacionEquipo;
	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	private Divisa divisa = new Divisa();
	Listbox listEquipo;
	List<Equipo> equipos;
	
	
	public Divisa getDivisa() {
		return divisa;
	}

	public void setDivisa(Divisa divisa) {
		this.divisa = divisa;
	}

	public ClasificacionEquipo getClasificacionEquipo() {
		return clasificacionEquipo;
	}

	public void setClasificacionEquipo(ClasificacionEquipo clasificacionEquipo) {
		this.clasificacionEquipo = clasificacionEquipo;
	}

	private ClasificacionEquipo clasificacionEquipo= new ClasificacionEquipo(); 
	private Textbox txtNombre;
	private Textbox txt;
	private Combobox cmbTipo;
	private Combobox cmbCategoria;
	private Combobox cmbDivisa;
	
	private AnnotateDataBinder binder ;
	 
	 
	 public void onCreate$winConfigurarEquipo(ForwardEvent event) {
		    // get the databinder for later extra load and save
		    // note: binder is not ready in doAfterCompose, so do it here
		    binder = (AnnotateDataBinder) event.getTarget().getVariable("binder", false);
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


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);  //Hacemos visible el modelo para el databinder
	equipos=servicioEquipo.listar();
	}
	
	public  List<Categoria> getCategorias() {
		return servicioCategoria.listar();
		
	}
	
	public  List<ClasificacionEquipo> getTipos() {
		return servicioClasificacionEquipo.listar();
		
	}
	
	public  List<Equipo> getEquipos() {
		//return equipos;
		return servicioEquipo.listar();
		
	}
	
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	public  List<Divisa> getDivisas() {
		return servicioDivisa.listar();
		
	}
	
	public void onClick$btnAgregar(){
		
		//Divisa y Clasificacion fijas
//		equipo.setDivisa(servicioDivisa.listar().get(0));
		for (int i = 0; i < equipos.size(); i++) {
			if(cmbTipo.getSelectedItem().getLabel().equals(equipos.get(i).getClasificacionEquipo().getNombre())){
				if(cmbCategoria.getSelectedItem().getLabel().equals(equipos.get(i).getCategoria().getNombre())){
					alert("Ya existe el equipo para la categoria");
					return;
					
				}
			
			}
			
			
		}
		
		
		equipo.setDivisa(divisa);
		equipo.setClasificacionEquipo(clasificacionEquipo);
		equipo.setEstatus('A');
		equipo.setCategoria(categoria);
		equipo.setNombre(txtNombre.getValue());
		equipo.setCodigoEquipo("eq0"+String.valueOf(servicioEquipo.listar().size()+1));
		
		servicioEquipo.agregar(equipo);
		 try {
			Messagebox.show("Equipo agregado", "Exito", Messagebox.OK, Messagebox.INFORMATION);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 limpiar();
		 
		 binder.loadAll();
		
	}
	

	public void onSelect$listEquipo(){
	 int n= listEquipo.getSelectedIndex();
	 
	 cmbTipo.setValue(equipos.get(n).getClasificacionEquipo().getNombre());
	 txtNombre.setValue(equipos.get(n).getNombre().toString());
	 cmbCategoria.setValue(equipos.get(n).getCategoria().getNombre());
	 cmbDivisa.setValue(equipos.get(n).getDivisa().getNombre());
	
	 
		
		
	}
	
	public void onClick$btnEditar(){
		
		
		
		
	}
	
	public void onClick$btnQuitar(){
		Equipo equipoSeleccionado =  (Equipo) listEquipo.getSelectedItem().getValue();
		if (equipo!= null){
			servicioEquipo.eliminar(equipoSeleccionado);
			limpiar();
		}
		else{
			alert("Seleccione un dato");
		}
	}
	
	public void limpiar(){
		equipo= new Equipo();
		binder.loadAll();
		txtNombre.setValue("");
	}
	
	public void onClick$btnCancelar(){
		limpiar();
	}

}

