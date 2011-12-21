package controlador.entrenamiento;

import java.util.List;

import modelo.ActividadEntrenamiento;
import modelo.Categoria;
import modelo.Temporada;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Timebox;
import org.zkoss.zul.Window;

import servicio.entrenamiento.ServicioCategoria;
import servicio.entrenamiento.ServicioTemporada;

import controlador.general.*;


public class Plan_Temporada extends GenericForwardComposer {
	
	Window pTemporada;
	Button btnAgregarHorario,btnEditarHorario,btnQuitarHorario,btnAgregarPersTecnico,
	btnEditarPersTecnico,btnQuitarPersTecnico,btnGuardar,btnImprimir,btnCancelar,btnSalir;
	Combobox cmbTemporada,cmbEquipo,cmbTipoPersonal,cmbNombre, cmbdia, cmbCategoria;
	Listbox listHorario,list;
	Timebox tmbinicio, tmbfin;
	Window planTemp;
	
	List<Temporada> temporadas;
	List<Categoria> categorias;
	ServicioTemporada servicioTemporada;
	ServicioCategoria servicioCategoria;
	
	
	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("ctrl", this, true);
		temporadas = servicioTemporada.listar();
		categorias = servicioCategoria.listar();
	}
	
	public void onClick$btnAgregarHorario(){

       
        String horai = (tmbinicio.getValue().getHours()+":0"+tmbinicio.getValue().getMinutes());
        String horaf = (tmbfin.getValue().getHours()+":0"+tmbfin.getValue().getMinutes());
       
        Listitem item = new Listitem();
        item.appendChild (new Listcell(cmbdia.getSelectedItem().getLabel()));
        item.appendChild(new Listcell(horai));
        item.appendChild(new Listcell(horaf));
        listHorario.appendChild(item);	
        cmbdia.setValue("--Seleccione--");
		tmbinicio.setValue(null);
		tmbfin.setValue(null);
		desbloquear();
        
	}

	
	
	public void onClick$btnAgregarPersTecnico(){
		int equipo = cmbEquipo.getSelectedIndex();
		int tipo = cmbTipoPersonal.getSelectedIndex();
		int nombre = cmbNombre.getSelectedIndex();
		
					Listitem item = new Listitem();
			        item.appendChild(new Listcell(cmbEquipo.getSelectedItem().getLabel()));
			        item.appendChild(new Listcell(cmbTipoPersonal.getSelectedItem().getLabel()));
			        item.appendChild(new Listcell(cmbNombre.getSelectedItem().getLabel()));
			        list.appendChild(item);
			        cmbEquipo.setValue("--Seleccione--");
			        cmbTipoPersonal.setValue("--Seleccione--");
					cmbNombre.setValue("--Seleccione--");
					desbloquearPersonal();
				}
//	}
	
	public void onClick$btnQuitarPersTecnico(){
		list.removeItemAt(list.getSelectedIndex());
	}
	
	public void onClick$btnQuitarHorario(){
		listHorario.removeItemAt(listHorario.getSelectedIndex());
	}
	
	public void onClick$btnEditarHorario(){}
	
	
	public void onClick$btnEditarPersTecnico(){}
	
		
	public void onClick$btnSalir(){

		pTemporada.detach();
	}
	
	public void onClick$btnCancelar(){
		cmbTemporada.setValue("--Seleccione--");
		cmbEquipo.setValue("--Seleccione--");
		cmbTipoPersonal.setValue("--Seleccione--");
		cmbNombre.setValue("--Seleccione--");
		cmbdia.setValue("--Seleccione--");
		tmbinicio.setValue(null);
		tmbfin.setValue(null);
	    removerTodoLista(list);
	    removerTodoLista(listHorario);
	}
	
	public void removerTodoLista(Listbox newlista) {
		int cant;
		cant=newlista.getItemCount();
		
		for (int i = cant-1; i>=0 ; i--)
			newlista.removeItemAt(i);		
	}
	
	public void onChange$cmbTemporada(){
		cmbCategoria.setDisabled(false);
	}
	
	public void onChange$cmbCategoria(){
		cmbdia.setDisabled(false);
	}
	
	public void onChange$cmbdia(){
		tmbinicio.setDisabled(false);
		tmbfin.setDisabled(false);
		btnAgregarHorario.setDisabled(false);
	}
	

	
	public void desbloquear(){
		
		btnEditarHorario.setVisible(true);
		btnQuitarHorario.setVisible(true);
		cmbEquipo.setDisabled(false);
	}
	
	public void onChange$cmbEquipo(){
		cmbTipoPersonal.setDisabled(false);
	}
	public void onChange$cmbTipoPersonal(){
		cmbNombre.setDisabled(false);
	}
	
	public void onChange$cmbNombre(){
		btnAgregarPersTecnico.setDisabled(false);
	}
	
    public void desbloquearPersonal(){
		
	btnEditarPersTecnico.setDisabled(false);
	btnQuitarPersTecnico.setDisabled(false);
	btnGuardar.setDisabled(false);
	}

}
