package controlador.jugador;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;

import comun.TipoDatoBasico;

import modelo.Categoria;

import modelo.Divisa;
import modelo.Equipo;
import modelo.Medico;

import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioDatoBasico;
import modelo.DatoBasico;

import servicio.implementacion.ServicioEquipo;
import servicio.implementacion.ServicioDivisa;

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
public class CntrlConfigurarEquipo extends GenericForwardComposer {
	private ServicioCategoria servicioCategoria;
	private ServicioEquipo servicioEquipo;
	private ServicioDivisa servicioDivisa;
	private ServicioDatoBasico servicioDatoBasico;

	private DatoBasico clasificacion = new DatoBasico();
	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	private Divisa divisa = new Divisa();

	

	List<Categoria> categorias =new ArrayList<Categoria>();
	Listbox listEquipo;
	List<Equipo> equipos = new ArrayList<Equipo>();
	List<DatoBasico> tip = new ArrayList<DatoBasico>();
	List<DatoBasico> tip2 = new ArrayList<DatoBasico>();
	List<DatoBasico> tipo = new ArrayList<DatoBasico>();
	List<DatoBasico> tip3 = new ArrayList<DatoBasico>();
	List<DatoBasico> tip4 = new ArrayList<DatoBasico>();
	List<Divisa> divisas = new ArrayList<Divisa>();
	List<DatoBasico> tipoLapsos = new ArrayList<DatoBasico>();
	
	
	private Textbox txtNombre;
	private Combobox cmbTipo;
	private Combobox cmbTipoLapso;
	private Combobox cmbCategoria;
	private Combobox cmbDivisa;
	private Spinner spMinJugadores;
	private Spinner spMaxJugadores;
    private AnnotateDataBinder binder;
    private Button btnSeleccionar,btnAgregar, btnQuitar, btnModificar,btnCancelar,btnSalir; 
    
    //tipolapso
    
  
    
    public DatoBasico getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(DatoBasico clasificacion) {
		this.clasificacion = clasificacion;
	}
    
    public List<DatoBasico> getTipo() {
		return tipo;
	}

	public void setTipo(List<DatoBasico> tipo) {
		this.tipo = tipo;
	}

	
   public Divisa getDivisa() {
		return divisa;
	}

	public void setDivisa(Divisa divisa) {
		this.divisa = divisa;
	}



	public List<DatoBasico> getTipoLapsos() {
		return tipoLapsos;
	}

	public void setTipoLapsos(List<DatoBasico> tipoLapsos) {
		this.tipoLapsos = tipoLapsos;
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
		comp.setVariable("controller", this, false); // Hacemos visible el
		equipos = servicioEquipo.listar();			// modelo para el
													// databinder
		
	}

	public List<Categoria> getCategorias() {
		categorias=servicioCategoria.listar();
		return servicioCategoria.listar();

	}

	public List<Equipo> getEquipos() {
		return equipos;
		// return servicioEquipo.listar();

	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<Divisa> getDivisas() {
		divisas=servicioDivisa.listar();
		return servicioDivisa.listar();

	}
	
	public void onChange$cmbCategoria() {
		categorias=servicioCategoria.listar();
		tip.clear();
		tip2.clear();
		tip = servicioDatoBasico.buscar(TipoDatoBasico.CLASIFICACION_EQUIPO);
		for (int i = 0; i < categorias.get(cmbCategoria.getSelectedIndex()).getCantidadEquipo(); i++) {
			tip2.add(tip.get(i));
		}
		Events.postEvent(new Event(Events.ON_SELECT, cmbCategoria));
		tipo.clear();
		tipo.addAll(tip2);
		binder.loadComponent(cmbTipo);
		
		
	}
	
	public void onChange$cmbTipo() {
		/*categorias=servicioCategoria.listar();
		tip.clear();
		tip2.clear();
		tip = servicioDatoBasico.buscar(TipoDatoBasico.CLASIFICACION_EQUIPO);
		for (int i = 0; i < categorias.get(cmbCategoria.getSelectedIndex()).getCantidadEquipo(); i++) {
			tip2.add(tip.get(i));
		}
		tipo.clear();
		tipo.addAll(tip2);
		binder.loadComponent(cmbTipo);*/
		buscarTipoLapso(equipo);
		
	}

	

	public void onClick$btnAgregar() {
		// Divisa y Clasificacion fijas
		// equipo.setDivisa(servicioDivisa.listar().get(0));
           
		for (int i = 0; i < equipos.size(); i++) {
			if (cmbTipo.getSelectedItem().getLabel()
					.equals(equipos.get(i).getDatoBasicoByCodigoClasificacion().getNombre())) {

				if (cmbCategoria.getSelectedItem().getLabel()
						.equals(equipos.get(i).getCategoria().getNombre())) {

					alert("Ya existe el equipo para la categoria");
					return;
				}

			}
		}

		equipo.setDivisa(divisas.get(cmbDivisa.getSelectedIndex()));
		equipo.setDatoBasicoByCodigoClasificacion(tipo.get(cmbTipo.getSelectedIndex()));
		equipo.setDatoBasicoByCodigoTipoLapso(tipo.get(cmbTipoLapso.getSelectedIndex()));
		equipo.setCategoria(categorias.get(cmbCategoria.getSelectedIndex()));
		equipo.setNombre(txtNombre.getValue());
		equipo.setMaximoJugador(spMaxJugadores.getValue());
		equipo.setMinimoJugador(spMinJugadores.getValue());
		equipo.setEstatus('A');
		equipo.setCodigoEquipo(servicioEquipo.listar().size() + 1);
		servicioEquipo.agregar(equipo);
		try {
			Messagebox.show("Equipo agregado", "Exito", Messagebox.OK,
					Messagebox.INFORMATION);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		equipos.add(equipo);
		limpiar();
		binder.loadAll();

	}

	public void onClick$btnModificar() throws InterruptedException{
		
		
		if (equipo!= null){
			 
			equipo.setDivisa(divisas.get(cmbDivisa.getSelectedIndex()));
			equipo.setDatoBasicoByCodigoClasificacion(tipo.get(cmbTipo.getSelectedIndex()));
			equipo.setDatoBasicoByCodigoTipoLapso(tipo.get(cmbTipoLapso.getSelectedIndex()));
			equipo.setCategoria(categorias.get(cmbCategoria.getSelectedIndex()));
			equipo.setNombre(txtNombre.getValue());
			equipo.setMaximoJugador(spMaxJugadores.getValue());
			equipo.setMinimoJugador(spMinJugadores.getValue());
			equipo.setEstatus('A');
			servicioEquipo.actualizar(equipo);
			
			 try {
					Messagebox.show("Equipo modificado", "Exito", Messagebox.OK, Messagebox.INFORMATION);
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
	
	

	

	public void onClick$btnQuitar() {
		if (listEquipo.getSelectedIndex() >= 0) {
			Equipo equipoSeleccionado = (Equipo) listEquipo.getSelectedItem()
					.getValue();
			  if (servicioEquipo.buscarPorCodigo(equipo)==false)
					//System.out.println(servicioCategoria.buscarPorCodigo(categoria));
						alert ("No se puede borrar mientras existan equipos en esta categoria");
			  else
			if (equipoSeleccionado != null) {
				equipos.remove(equipoSeleccionado);
				servicioEquipo.eliminar(equipoSeleccionado);
				limpiar();
			}
		} else {
			alert("Seleccione un dato");
		}
	}

	public void limpiar() {
		equipo = new Equipo();
		categoria = new Categoria();
		divisa = new Divisa();
		binder.loadAll();
		txtNombre.setValue("");
	}

	public void onClick$btnCancelar() {
		limpiar();
	}
	
	
   public void onSelect$listEquipo() {
		
		
		cmbCategoria.setSelectedIndex(buscarCat(equipos.get(listEquipo.getSelectedIndex()).getCategoria()));
        cmbDivisa.setSelectedIndex(buscarDiv(equipos.get(listEquipo.getSelectedIndex()).getDivisa()));
		buscarTipoSelecionado(equipos.get(listEquipo.getSelectedIndex()));
		cmbTipo.setSelectedIndex(buscarTipo(equipos.get(listEquipo.getSelectedIndex())));
		txtNombre.setValue((equipos.get(listEquipo.getSelectedIndex()).getNombre()));
		spMaxJugadores.setValue(equipos.get(listEquipo.getSelectedIndex()).getMaximoJugador());
		spMinJugadores.setValue(equipos.get(listEquipo.getSelectedIndex()).getMinimoJugador());
		buscarTipoLapso(equipos.get(listEquipo.getSelectedIndex()));
		cmbTipoLapso.setSelectedIndex(buscarTipo(equipos.get(listEquipo.getSelectedIndex())));
	    System.out.println(buscarTipo(equipos.get(listEquipo.getSelectedIndex())));
		
		
	}
	
	
	public int buscarCat(Categoria categoria){
		for (int i = 0; i < categorias.size(); i++) {
			if (categorias.get(i).getNombre().equals(categoria.getNombre())){
				
				return i;
				
			}
			
		}
		
		return -1;
		
	}
	
	public int buscarDiv(Divisa divisa){
		for (int i = 0; i < divisas.size(); i++) {
			if (divisas.get(i).getNombre().equals(divisa.getNombre())){
				return i;
				
			}
			
		}
		return -1;
	    
    }
	
	public int buscarTipo(Equipo equipo){

		///
		for (int i = 0; i < tipo.size(); i++) {
			if (tipo.get(i).getNombre().equals(equipo.getDatoBasicoByCodigoClasificacion().getNombre())){
				System.out.println(i);
				return i;
			}
			
		}
		
		       return -1; 
    }
	
	public void buscarTipoSelecionado(Equipo equipo){
		categorias=servicioCategoria.listar();
		tip.clear();
		tip2.clear();
		tip = servicioDatoBasico.buscar(TipoDatoBasico.CLASIFICACION_EQUIPO);
		for (int i = 0; i < equipo.getCategoria().getCantidadEquipo(); i++) {
			tip2.add(tip.get(i));
		}
		tipo.clear();
		tipo.addAll(tip2);
		binder.loadComponent(cmbTipo);
		
    }
	

	public void buscarTipoLapso(Equipo equipo){
		
		categorias=servicioCategoria.listar();
		tip3.clear();
		tip4.clear();
		tip3 = servicioDatoBasico.buscar(TipoDatoBasico.TIPO_LAPSO_DEPORTIVO);
		System.out.println(tip3.get(0).getNombre());
		System.out.println(tip3.get(1).getNombre());
		for (int i = 0; i < tip3.size(); i++) {
			tip4.add(tip3.get(i));
		}
		tipoLapsos.clear();
		tipoLapsos.addAll(tip4);
		binder.loadComponent(cmbTipoLapso);
	}	
}
