package controlador.jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javassist.expr.NewArray;

import org.hibernate.mapping.Array;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.Executions;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.implementacion.ServicioMedico;
import servicio.implementacion.ServicioDatoBasico;

import comun.TipoDatoBasico;

import modelo.Medico;

import modelo.DatoBasico;

/**
 * Clase controladora de los eventos de la vista de igual nombre el presente
 * controlador se encarga de agregar, eliminar logicamente, la modificacion se
 * ha pospuesto momentaneamente por problemas con los combos
 * 
 * @author Robert A
 * @author Miguel B
 * 
 * @version 2.0 29/12/2011
 * 
 * */
public class CntrlConfigurarMedico extends GenericForwardComposer {
	private ServicioMedico servicioMedico;
	private ServicioDatoBasico servicioDatoBasico;

	// private DatoBasico especialidad = new DatoBasico();
	private Medico medico = new Medico();

	Button btnGuardar;
	Button btnModificar;
	Button btnEliminar;
	Button btnCancelar;
	Button btnSalir;
	Button btnBuscar;
	Textbox txtApellido,txtTelefonoCelular,txtTelefonoHabitacion,txtNumcol, txtCedula,txtMatricula;
	Component formulario;
	private Combobox cmbEspecialidad,cmbNacionalidad,cmbCodCelular,cmbCodArea;
	
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
		btnModificar.setVisible(false);
		btnEliminar.setVisible(false);
	}

	public void onClick$btnGuardar() {
		
		if(txtApellido.getValue()!= "" && txtTelefonoCelular.getValue().toString().length()==7 
				&& txtTelefonoHabitacion.getValue().toString().length()==7 
				&& txtNumcol.getValue()!="" && txtNumcol.getValue().toString().length()==5
				&& txtCedula.getValue()!="" && cmbEspecialidad.getSelectedIndex()!=-1
				&& cmbNacionalidad.getSelectedIndex()!=-1 && cmbCodCelular.getSelectedIndex()!=-1
				&& cmbCodArea.getSelectedIndex()!=-1){		
		especialidades=servicioDatoBasico.buscar(TipoDatoBasico.ESPECIALIDAD);
		medico.setCedulaMedico(cmbNacionalidad.getValue()+"-"+txtCedula.getValue().toString());
		medico.setTelefonoCelular(codigosCelular.get(cmbCodCelular.getSelectedIndex()).getNombre()+txtTelefonoCelular.getValue());
		medico.setDatoBasico(especialidades.get(cmbEspecialidad.getSelectedIndex()));
		medico.setTelefonoOficina(codigosArea.get(cmbCodArea.getSelectedIndex()).getNombre()+txtTelefonoHabitacion.getValue());
		medico.setEstatus('A');
		Date fecha = new Date();
		medico.setFechaIngreso(fecha);
		servicioMedico.agregar(medico);
		limpiar();
		}
		else{
			alert("Complete los Datos Necesarios para Guardar el Medico");
		}
		
	}
	
	public void onBlur$txtNumcol(){
		if(servicioMedico.buscar(txtNumcol.getValue().toString())!=null){
			alert("El Numero de Colegio Ya Existe");
		}
	}

	public void onClick$btnModificar() {
		if(txtApellido.getValue()!= "" && txtTelefonoCelular.getValue().toString().length()==7 
				&& txtTelefonoHabitacion.getValue().toString().length()==7 
				&& txtNumcol.getValue()!="" && txtNumcol.getValue().toString().length()==5
				&& txtCedula.getValue()!="" && cmbEspecialidad.getSelectedIndex()!=-1
				&& cmbNacionalidad.getSelectedIndex()!=-1 && cmbCodCelular.getSelectedIndex()!=-1
				&& cmbCodArea.getSelectedIndex()!=-1){
		especialidades=servicioDatoBasico.buscar(TipoDatoBasico.ESPECIALIDAD);
			
		medico.setCedulaMedico(cmbNacionalidad.getValue()+"-"+txtCedula.getValue().toString());
		medico.setTelefonoCelular(cmbCodCelular.getValue()+txtTelefonoCelular.getValue());
		medico.setDatoBasico(especialidades.get(buscaresps(cmbEspecialidad.getValue())));
		medico.setTelefonoOficina(cmbCodArea.getValue()+txtTelefonoHabitacion.getValue());
		medico.setEstatus('A');
		servicioMedico.actualizar(medico);
		limpiar();
		}
		else{
			alert("Complete los Datos Necesarios para Registro de el Medico");
		}
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

	public void onClick$btnBuscar() {
		// se crea el catalogo y se llama
		Component catalogo = Executions.createComponents(
				"/Jugador/Vistas/FrmBuscarMedico.zul", null, null);
		// asigna una referencia del formulario al catalogo.
		catalogo.setVariable("formulario", formulario, false);
		
		formulario.addEventListener("onCatalogoCerrado", new EventListener() {
			@Override
			// Este metodo se llama cuando se envia la se�al desde el catalogo
			public void onEvent(Event arg0) throws Exception {
				// se obtiene el jugador
				medico = (Medico) formulario.getVariable("medico", false);
				cmbEspecialidad.setSelectedIndex(buscaresp(medico));
				cmbCodArea.setSelectedIndex(buscarcarea(medico));
				cmbCodCelular.setSelectedIndex(buscarcelu(medico));
				txtTelefonoCelular.setValue(medico.getTelefonoCelular().substring(5)); //Modificado el valor de 4 a 5
				txtTelefonoHabitacion.setValue(medico.getTelefonoOficina().substring(5)); //Modificado el valor de 4 a 5
				cmbNacionalidad.setSelectedIndex(buscarnac(medico));
				txtCedula.setValue(medico.getCedulaMedico().substring(2));
				txtNumcol.setReadonly(true);
				btnGuardar.setVisible(false);
				btnModificar.setVisible(true);
				btnEliminar.setVisible(true);
				binder.loadAll();
				
			}
		});
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
		txtTelefonoCelular.setValue("");
		txtTelefonoHabitacion.setValue("");
		cmbEspecialidad.setValue("--Seleccione--");
		cmbNacionalidad.setValue("-");
		cmbCodCelular.setValue("--");
		cmbCodArea.setValue("--");
		txtCedula.setValue("");
		medico = new Medico();
		txtNumcol.setReadonly(false);
		btnGuardar.setVisible(true);
		btnModificar.setVisible(false);
		btnEliminar.setVisible(false);
		binder.loadAll();
		txtNumcol.setFocus(true);
		
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
	
}
