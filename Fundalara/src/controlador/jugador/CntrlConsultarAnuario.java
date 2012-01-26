package controlador.jugador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.image.AImage;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import modelo.Categoria;

import modelo.Equipo;
import modelo.Jugador;
import modelo.Roster;
import modelo.Competencia;
import modelo.LapsoDeportivo;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.*;

import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioCompetencia;
import servicio.implementacion.ServicioEquipo;
import servicio.implementacion.ServicioRoster;
import servicio.implementacion.ServicioLapsoDeportivo;

/**
 * Clase controladora de los eventos de la vista de igual nombre, el presente
 * controlador se encarga de buscar por categoria, equipo y temporada a los
 * jugadores pertenecientes a la misma y mostrar su foto, nombre y número
 * 
 * @author Glendy Oliveros
 * @author Aimee Monsalve
 * @author Greisy Rodriguez
 * @author Alberto Perozo
 * @author Edgar Luzardo
 * 
 * @version 1.1 25/01/2012
 * 
 * */

public class CntrlConsultarAnuario extends GenericForwardComposer {
	private ServicioCategoria servicioCategoria;
	private ServicioEquipo servicioEquipo;
	private ServicioRoster servicioRoster;
	private ServicioCompetencia servicioCompetencia;

	private Window winAnuarioJugadores;
	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	private Jugador jugador = new Jugador();
	private Roster roster = new Roster();
	private static Roster rosters;
	private static String valorRetornado = "";
	private Competencia competencia = new Competencia();

	List<Jugador> Jugadores = new ArrayList<Jugador>();
	List<Equipo> Equipos;
	private List<Jugador> listaRoster = new ArrayList<Jugador>();

	Listbox listAnuario;
	private Div divLista;

	Component catalogo;
	private AnnotateDataBinder binder;

	Combobox cmbEquipo, cmbCategoria;
	//private Listcell img2, img3, img4, img5;
	private Listcell celda;
	private Image img1;

	@Override
	public void doAfterCompose(Component c) throws Exception {
		super.doAfterCompose(c);
		c.setVariable("controller", this, true);
		// se guarda la referencia al catalogo
		catalogo = c;
		cmbEquipo.setDisabled(true);
	}

	public void onSelect$cmbCategoria() {
		cmbEquipo.setDisabled(false);
		cmbEquipo.getItems().clear();
		cmbEquipo.setValue("--Seleccione--");
	}

	// Getters y Setters
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
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		jugador = jugador;
	}

	public void setListaRoster(List<Jugador> listaRoster) {
		this.listaRoster = listaRoster;
	}

	public List<Jugador> getListaRoster() {
		return listaRoster;
	}

	public static void setRosters(Roster rosters) {
		CntrlConsultarAnuario.rosters = rosters;
	}

	public static Roster getRosters() {
		return rosters;
	}

	public static void setValorRetornado(String valorRetornado) {
		CntrlConsultarAnuario.valorRetornado = valorRetornado;
	}

	public static String getValorRetornado() {
		return valorRetornado;
	}
	
	
	// Para llenar Listas y combos

	public List<Categoria> getCategorias() {
		return servicioCategoria.listar();
	}

	public List<Equipo> getEquipos() {
		return servicioEquipo.buscarPorCategoria(categoria);
	}

	public void onChange$cmbEquipo(){		
		listaRoster = servicioRoster.listarJugadores(equipo);

		divLista.removeChild(listAnuario);		
		Listitem listItem = null;
		listAnuario = new Listbox();
		
/*		for (int i = 0; i < listAnuario.getItemCount() ; i++) {
			listAnuario.removeItemAt(i);
		}
*/
									
		for (int i = 0; i < listaRoster.size() ; i++) {			
			img1 = new Image();
			img1.setHeight("80px");
			img1.setWidth("80px");
			
			if (i%4 == 0){
				listItem = new Listitem();
				listItem.setAttribute("align", "center");
			}
			
			Jugador jug = listaRoster.get(i);		
			byte[] foto = jug.getPersonaNatural().getFoto();			
	        if (foto != null){
	            try {
	              AImage aImage = new AImage("foto.jpg", foto);
	              img1.setContent(aImage);
	            } catch (IOException e) {
	              e.printStackTrace();
	            }	
	          }
	        
	        Listcell listCell = new Listcell();	        
	        listCell.appendChild(img1);	        	        
	        listItem.appendChild(listCell);	        
			listAnuario.appendChild(listItem);
						
			Listcell listCell2 = new Listcell();
			listCell2.setLabel(jug.getPersonaNatural().getPrimerNombre() + " " + jug.getPersonaNatural().getPrimerApellido());
			listItem.appendChild(listCell2);
			listAnuario.appendChild(listItem);
						
			}
		
		divLista.appendChild(listAnuario);		
	}
	

}
