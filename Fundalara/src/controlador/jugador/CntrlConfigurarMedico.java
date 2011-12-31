package controlador.jugador;

import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.Executions;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
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
	Textbox txtApellido;
	Component formulario;
	private Combobox cmbEspecialidad;

	private AnnotateDataBinder binder;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, true);
		// se guarda la referencia al formulario actual
		formulario = comp;

	}

	public void onClick$btnGuardar() {

		medico.setEstatus('A');
		Date fecha = new Date();
		medico.setFechaIngreso(fecha);
		servicioMedico.agregar(medico);
		medico = new Medico();
		binder.loadAll();
	}

	public void onClick$btnModificar() {

		// problemas con asignar el valor del combo cuando traigo los datos
		/*
		 * if (especialidad != null) { medico.setEstatus('A');
		 * //medico.setDatoBasico(especialidad);
		 * servicioMedico.actualizar(medico); medico = new Medico();
		 * binder.loadAll(); } else {
		 */
		medico.setEstatus('A');
		servicioMedico.actualizar(medico);
		medico = new Medico();
		binder.loadAll();

		// }
	}

	public void onClick$btnEliminar() {
		medico.setEstatus('E');
		servicioMedico.actualizar(medico);
		medico = new Medico();
		binder.loadAll();
	}

	public void onClick$btnCancelar() {
		medico = new Medico();
		binder.loadAll();
	}

	public void onClick$btnBuscar() {
		// se crea el catalogo y se llama
		Component catalogo = Executions.createComponents(
				"/Jugador/Vistas/FrmBuscarMedico.zul", null, null);
		// asigna una referencia del formulario al catalogo.
		catalogo.setVariable("formulario", formulario, false);

		formulario.addEventListener("onCatalogoCerrado", new EventListener() {
			@Override
			// Este metodo se llama cuando se envia la señal desde el catalogo
			public void onEvent(Event arg0) throws Exception {
				// se obtiene el jugador
				medico = (Medico) formulario.getVariable("medico", false);
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
		return servicioDatoBasico.buscar(TipoDatoBasico.ESPECIALIDAD);
	}

}
