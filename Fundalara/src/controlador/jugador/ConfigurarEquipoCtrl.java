package controlador.jugador;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import modelo.Categoria;
import modelo.ClasificacionEquipo;
import modelo.Divisa;
import modelo.Equipo;
import servicio.compentencia.*;
import servicio.jugador.ServicioCategoria;
import servicio.jugador.ServicioClasificacionEquipo;
import servicio.jugador.ServicioEquipo;

/**
 * Clase controladora de los eventos de la vista de igual nombre.
 * 
 * @author Robert A
 * 
 * @version 1.0 22/11/2011
 * 
 * */
public class ConfigurarEquipoCtrl extends GenericForwardComposer {
	private ServicioCategoria servicioCategoria;
	private ServicioEquipo servicioEquipo;
	private ServicioDivisa servicioDivisa;
	private ServicioClasificacionEquipo servicioClasificacionEquipo;
	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	private Divisa divisa = new Divisa();
	private ClasificacionEquipo clasificacionEquipo = new ClasificacionEquipo();
	private Textbox txtNombre;
	private AnnotateDataBinder binder;

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
														// modelo para el
														// databinder
	}

	public List<Categoria> getCategorias() {
		return servicioCategoria.listar();

	}

	public List<ClasificacionEquipo> getTipos() {
		return servicioClasificacionEquipo.listar();

	}

	public List<Equipo> getEquipos() {
		return servicioEquipo.listar();

	}

	public void onClick$btnAgregar() {

		// Divisa y Clasificacion fijas
		equipo.setDivisa(servicioDivisa.listar().get(0));
		equipo.setClasificacionEquipo(clasificacionEquipo);
		equipo.setEstatus('A');
		equipo.setCategoria(categoria);
		equipo.setCodigoEquipo(String
				.valueOf(servicioEquipo.listar().size() + 1));
		servicioEquipo.agregar(equipo);
		try {
			Messagebox.show("Equipo agregado", "Exito", Messagebox.OK,
					Messagebox.INFORMATION);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		equipo = new Equipo();
		binder.loadAll();
	}

}
