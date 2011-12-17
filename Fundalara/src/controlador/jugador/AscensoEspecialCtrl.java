package controlador.jugador;

import java.util.Date;
import java.util.List;

import modelo.Categoria;
import modelo.Jugador;
import modelo.Equipo;
import modelo.Roster;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.jugador.ServicioCategoria;
import servicio.jugador.ServicioEquipo;
import servicio.jugador.ServicioJugador;
import servicio.jugador.ServicioRoster;

public class AscensoEspecialCtrl extends GenericForwardComposer {
	ServicioRoster servicioRoster;
	ServicioJugador servicioJugador;
	ServicioCategoria servicioCategoria;
	ServicioEquipo servicioEquipo;

	private Jugador jugador = new Jugador();
	private Roster roster = new Roster();
	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	List<Roster> listRoster;
	
	Textbox txtCedula;
	Textbox txtNombre;
	Textbox txtApellido;
	Textbox txtCategoria;
	Textbox txtEquipo;
	Intbox txtNumero;
	Combobox cmbNacionalidad;
	Combobox cmbCategoria;
	Combobox cmbEquipo;
	AnnotateDataBinder binder;

	public void onCreate$winAscensoEspecial(ForwardEvent event) {
		binder = (AnnotateDataBinder) event.getTarget().getVariable("binder",
				false);
	}
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);  //Hacemos visible el modelo para el databinder
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

	public List<Roster> getListRoster() {
		return listRoster;
	}

	public void setListRoster(List<Roster> listRoster) {
		this.listRoster = listRoster;
	}
	
	public  List<Categoria> getCategorias() {
		return servicioCategoria.listar();
		
	}
	
	public  List<Equipo> getEquipos() {
		return servicioEquipo.listar();
		
	}	
	
	public  List<Roster> getRosters() {
		return servicioRoster.listar();
		
	}
	

	public void onClick$btnBuscar(){
		if (txtCedula.getValue().equals("")){
		try {
			Messagebox.show(
					"Por favor introduzca la cedula",
					"Fundalara", Messagebox.OK, Messagebox.EXCLAMATION);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} else {
	    alert("hhhh");
		//servicioRoster.buscar(txtCedula.getValue());
	}

			
}	
	public void onClick$btnCancelar(){
		limpiar();
	}
	
	public void limpiar(){
		txtCedula.setValue("");
		txtNombre.setValue("");
		txtApellido.setValue("");
		txtCategoria.setValue("");
		txtEquipo.setValue("");
	    cmbCategoria.setValue("--Seleccione--");
		cmbEquipo.setValue("--Seleccione--");
		
	}
	
	public boolean camposVacios(){
		boolean vacio=false;
		if (txtCedula.getValue().equals("")
			&& cmbCategoria.getValue().equals("--Seleccione--")&& cmbEquipo.getSelectedIndex() == -1){
			  vacio=true;		 
	  
	}
		 return vacio;
		
	}
	
	public void onClick$btnGuardar(){
	  if (camposVacios()==false){
		//roster.setEstatus("A");  
		roster.setEquipo(equipo);
		roster.setEstatus('A');
		Date fecha = new Date();
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
		String cadenaFecha = formato.format(fecha);
//		roster.setFechaIngreso(fecha);
		eliminarRoster();
		servicioRoster.agregar(roster);
		try {
			Messagebox.show("Jugador cambiado de categoría", "Exito", Messagebox.OK, Messagebox.INFORMATION);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		limpiar();
	  
	}
	  else{
		  try {
				Messagebox.show(
						"Existen campos obligatorios, por favor verifique.",
						"Fundalara", Messagebox.OK, Messagebox.EXCLAMATION);
		   } catch (InterruptedException e) {
				e.printStackTrace();
			}
		  
	  }
	  
	  
	}
	
	public void eliminarRoster(){
		listRoster= servicioRoster.listar();
		for (int i = 0; i < listRoster.size(); i++) {
			if (listRoster.get(i).getJugador().equals(txtCedula.getValue())){
				servicioRoster.eliminar(listRoster.get(i));
				//Ahora getJugador se llama getCedula
			} 
		}
	}

}
