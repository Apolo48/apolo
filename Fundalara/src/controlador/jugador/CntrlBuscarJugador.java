package controlador.jugador;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import modelo.Categoria;

import modelo.Equipo;
import modelo.Jugador;
import modelo.Roster;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.*;

import comun.EstatusRegistro;

import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioEquipo;
import servicio.implementacion.ServicioJugador;
import servicio.implementacion.ServicioRoster;

/**
 * Clase controladora de los eventos de la vista de igual nombre, el presente
 * controlador se encarga de buscar a un jugador dentro de un equipo devuelve al
 * catalogo que lo llamo el jugador seleccionado
 * 
 * @author Miguel B
 * 
 * @version 1.0 29/12/2011
 * 
 * */

public class CntrlBuscarJugador extends GenericForwardComposer {
	ServicioCategoria servicioCategoria;
	ServicioEquipo servicioEquipo;
	ServicioRoster servicioRoster;
	ServicioJugador servicioJugador;

	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	private Jugador Jugador = new Jugador();
	private Roster roster = new Roster();

	List<Jugador> Jugadores = new ArrayList<Jugador>();
	List<Equipo> listaEquipos = new ArrayList<Equipo>();
	List<Equipo> Equipos;

	Textbox filter2;
	Textbox filter1;
	Textbox filter3;
	Textbox filter4;
	Listbox listEquipo;

	Component catalogo;
	private AnnotateDataBinder binder;
	  char estatus ;

	  
	  private void  filtrarLista(){
		  Jugadores=servicioJugador.buscarJugadores(filter2.getValue()
					.toString(), filter3.getValue().toString(), filter4.getValue()
					.toString(), filter1.getValue().toString(), estatus);
		binder.loadComponent(listEquipo);
	  }
	public void onBlur$filter2(){
		filtrarLista();
	}
	
	public void onBlur$filter1(){
		filtrarLista();
	}
	
	public void onBlur$filter3(){
		filtrarLista();
		
	}
	
	public void onBlur$filter4(){
		filtrarLista();
		
	}
	
	public void onCreate$winBuscarjugador(){
	     estatus = (Character) catalogo.getVariable("estatus",false);	
	    System.out.println(estatus);
	    Jugadores=servicioJugador.buscarJugadores(filter2.getValue()
				.toString().toUpperCase(), filter3.getValue().toString().toUpperCase(), filter4.getValue()
				.toString().toUpperCase(), filter1.getValue().toString().toUpperCase(), estatus);
	    determinarTitulo(estatus);
	    binder.loadAll();
	}
	
	public void determinarTitulo(char estatus) {
		Window w = (Window) catalogo;
		switch (estatus) {
		    
		case 'A':
			w.setTitle("Catalogo Jugadores");
			break;
		case 'E':
			w.setTitle("Catalogo Reingreso");
			break;
		case 'T':
			w.setTitle("Catalogo Nuevo Ingreso");
			break;
				   
		}
	}
	
	@Override
	public void doAfterCompose(Component c) throws Exception {
		super.doAfterCompose(c);
		c.setVariable("controller", this, true);
		// se guarda la referencia al catalogo
		catalogo = c;

		
	}


	
	public void onClick$btnSeleccionar() throws InterruptedException{
		//Se comprueba que se haya seleccionado un elemento de la lista

		if (listEquipo.getSelectedIndex() != -1) {
			//se obtiene la divisa seleccionada
			Jugador d = (Jugador) listEquipo.getSelectedItem().getValue();
			//se obtiene la referencia del formulario
			Component formulario = (Component) catalogo.getVariable("formulario",false);
	        //se le asigna el objeto divisa al formulario
			formulario.setVariable("jugador", d,false);
			//se le envia una señal al formulario indicado que el formulario se cerro y que los datos se han enviado
			Events.sendEvent(new Event("onCatalogoBuscarJugadorCerrado",formulario));          
			//se cierra el catalogo
			catalogo.detach();
			
		} else {
			Messagebox.show("Seleccione un Jugador", "Mensaje", Messagebox.YES,
					Messagebox.INFORMATION);

		}
		
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

	public Jugador getJugador() {
		return Jugador;
	}

	public void setJugador(Jugador jugador) {
		Jugador = jugador;
	}

	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	public List<Jugador> getJugadores() {
		return Jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		Jugadores = jugadores;
	}


}
