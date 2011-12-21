package controlador.entrenamiento;

import java.util.List;

import modelo.ActividadEntrenamiento;
import modelo.Categoria;
import modelo.DatoBasico;
import modelo.TipoDato;

import org.hibernate.cfg.AnnotationBinder;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.*;

import com.lowagie.text.Annotation;

import servicio.entrenamiento.ServicioActividadEntrenamiento;
import servicio.entrenamiento.ServicioCategoria;
import servicio.entrenamiento.ServicioDatoBasico;
import servicio.entrenamiento.ServicioTipoDato;


public class Actividad_Entrenamiento extends GenericForwardComposer {
	Button btnSalir, btnCancelar, btnAgregar, btnEditar, btnQuitar;
	Window winActividadEntrenamiento;
	Textbox txtActividades;
	Listbox lbxActividades;
	Treecell treecell;
	Combobox cmbCategoria, cmbFase, logro;
	ActividadEntrenamiento actividadEntrenamiento;
	ServicioCategoria servicioCategoria;
	ServicioTipoDato servicioTipoDato;
	ServicioDatoBasico servicioDatoBasico;
	ServicioActividadEntrenamiento servicioActividadEntrenamiento;
	List <Categoria> listCategoria;
	List <DatoBasico> listFase;
	AnnotateDataBinder binder;
	boolean editar;
	
	public void cargarFases() {
		TipoDato td;
		for (Object o : servicioTipoDato.listar()) {
			td=(TipoDato)o;
			if(td.getNombre().toUpperCase().equals("FASE")){
				listFase= servicioDatoBasico.buscarPorTipoDato(td);
				return;
			}
		}
	}
	
	public DatoBasico buscarFase() {
		DatoBasico fase;
		for (Object o : servicioDatoBasico.listar()) {
			fase=(DatoBasico)o;
			if(fase.getCodigoDatoBasico().equals(cmbFase.getSelectedItem().getValue()))
				return fase;
		}
		return null;
	}
	
	public Categoria buscarCategoria() {
		Categoria c;
		for (Object o : servicioCategoria.listar()) {
			c=(Categoria)o;
			if(c.getCodigoCategoria().equals(cmbCategoria.getSelectedItem().getValue()))
				return c;
		}
		return null;
	}

	public List<DatoBasico> getListFase() {
		return listFase;
	}

	public void setListFase(List<DatoBasico> listFase) {
		this.listFase = listFase;
	}

	public List<Categoria> getListCategoria() {
		return listCategoria;
	}

	public void setListCategoria(List<Categoria> listCategoria) {
		this.listCategoria = listCategoria;
	}

	public ActividadEntrenamiento getActividadEntrenamiento() {
		return actividadEntrenamiento;
	}

	public void setActividadEntrenamiento(
			ActividadEntrenamiento actividadEntrenamiento) {
		this.actividadEntrenamiento = actividadEntrenamiento;
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("ctrl", this, true);
		actividadEntrenamiento = new ActividadEntrenamiento();
		listCategoria = servicioCategoria.listar();
		cargarFases();
		editar=false;
	}
	
	public void onClick$btnSalir() {
		winActividadEntrenamiento.detach();
	}
	
	

	public void onCreate$winActividadEntrenamiento() {
		inicializar();
		System.out.println("");
	}
	
	public void onSelect$cmbCategoria(){
		cmbFase.setDisabled(false);
		btnCancelar.setDisabled(false);
		if (cmbCategoria.getSelectedItem()!=null && cmbFase.getSelectedItem()!=null) {
			int cant = lbxActividades.getItemCount();
			for (int i = 0; i < cant; i++) {
				lbxActividades.removeItemAt(0);
			}
			ActividadEntrenamiento act;
			for (Object o : servicioActividadEntrenamiento.buscarTodo(buscarCategoria(),buscarFase())){
				act=(ActividadEntrenamiento)o;
				lbxActividades.appendItem(act.getNombre(), act.getCodActividadEntrenamiento());				
			}			
		}
	}
	
	public void onSelect$cmbFase(){
		txtActividades.setDisabled(false);
		if (cmbCategoria.getSelectedItem()!=null && cmbFase.getSelectedItem()!=null) {
			int cant = lbxActividades.getItemCount();
			for (int i = 0; i < cant; i++) {
				lbxActividades.removeItemAt(0);
			}
			ActividadEntrenamiento act;
			for (Object o : servicioActividadEntrenamiento.buscarTodo(buscarCategoria(),buscarFase())){
				act=(ActividadEntrenamiento)o;
				lbxActividades.appendItem(act.getNombre(), act.getCodActividadEntrenamiento());
			}			
		}
		
	}

	public void inicializar() {
		// txtActividades.setDisabled(true);
		// lbxActividades.setDisabled(true);
		// btnAgregar.setDisabled(true);
		btnCancelar.setDisabled(true);
		btnEditar.setDisabled(true);
		btnQuitar.setDisabled(true);
//		cmbCategoria.setValue("- Categoria -");
//		cmbFase.setValue("- Fase -");
	}

	public void onSelect$lbxActividades() {
		if (lbxActividades.getSelectedItem().getIndex() >= 0) {
			btnEditar.setDisabled(false);
			btnQuitar.setDisabled(false);
			btnCancelar.setDisabled(false);
		}
	}

	public void onClick$btnAgregar() {
		if(!editar){
			if (cmbCategoria.getSelectedItem()==null) {
				alert("Seleccione una categoria");
				cmbCategoria.focus();
			} else if (cmbFase.getSelectedItem()==null) {
				alert("Seleccione una Fase");
				cmbFase.focus();
			} else if (txtActividades.getValue() == "") {
				alert("Debe ingresar una actividad");
				txtActividades.focus();
			} else {
				int i = 0;
				while(i<lbxActividades.getItemCount()){
					if(lbxActividades.getItemAtIndex(i).getLabel().equals(txtActividades.getValue())){
						alert("No puedes agregar una actividad duplicada");
						return;
					}
					i++;
				}			
				lbxActividades.appendItem(txtActividades.getValue(),""+(servicioActividadEntrenamiento.listar().size()+1));
				actividadEntrenamiento.setCodActividadEntrenamiento(""+(servicioActividadEntrenamiento.listar().size()+1));
				actividadEntrenamiento.setCategoria(buscarCategoria());
				actividadEntrenamiento.setDatoBasico(buscarFase());
				actividadEntrenamiento.setEstatus('A');
				servicioActividadEntrenamiento.agregar(actividadEntrenamiento);
				actividadEntrenamiento.setNombre("");
				binder.loadAll();		
			} 
		}
		else{
			if (txtActividades.getValue() == "") {
				alert("Debe ingresar una actividad");
				txtActividades.focus();
			} 
			else{
				editar=false;
				servicioActividadEntrenamiento.actualizar(actividadEntrenamiento);
				lbxActividades.appendItem(txtActividades.getValue(),actividadEntrenamiento.getCodActividadEntrenamiento());
				cmbCategoria.setDisabled(false);
				cmbFase.setDisabled(false);
				txtActividades.setValue("");
			}
		}
	}
	
	public void onClick$btnQuitar() {		
		if (lbxActividades.getItems().size() != 0) {						
			btnEditar.setDisabled(true);
			btnQuitar.setDisabled(true);
			actividadEntrenamiento.setCodActividadEntrenamiento(lbxActividades.getSelectedItem().getValue().toString());
			actividadEntrenamiento.setEstatus('E');
			servicioActividadEntrenamiento.actualizar(actividadEntrenamiento);
			lbxActividades.removeItemAt(lbxActividades.getSelectedItem().getIndex());			
		}
	}

	public void onClick$btnEditar() {
		if (lbxActividades.getSelectedItem().getIndex() >= 0) {
			System.out.println(lbxActividades.getSelectedItem().getValue()+" "+lbxActividades.getSelectedItem().getLabel());
			editar=true;
			cmbCategoria.setDisabled(true);
			cmbFase.setDisabled(true);
			actividadEntrenamiento = servicioActividadEntrenamiento.buscarClaveForegn(buscarCategoria(), buscarFase(), ""+lbxActividades.getSelectedItem().getValue());
			servicioActividadEntrenamiento.actualizar(actividadEntrenamiento);
			binder.loadAll();			
			lbxActividades.removeItemAt(lbxActividades.getSelectedItem().getIndex());
		}
	}

	public void onClick$btnCancelar(){
		inicializar();
		int numElementos = lbxActividades.getItems().size();		
		for (int I = 2; I <= numElementos; I++) {
			lbxActividades.removeItemAt(0);
		}
		cmbFase.setDisabled(true);
		txtActividades.setDisabled(true);
	}

}
