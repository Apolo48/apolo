package controlador.jugador;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.*;

import comun.ConeccionBD;
import comun.TipoDatoBasico;
import controlador.jugador.restriccion.Restriccion;

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
 * controlador se encarga de agregar, eliminar logicamente y modifica
 * 
 * @author Robert A
 * @author Miguel B
 * @author Benjamin S.
 * @author Cesar P
 * 
 * @version 4.0 6/02/2012
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
	Iframe ifReporte;

	

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
	
	private Connection con;
	private String jrxmlSrc;
	private Map parameters = new HashMap();
	
	private Textbox txtNombre;
    Label lbTipo,lbTipoLapso;

	private Combobox cmbTipo;
	private Combobox cmbTipoLapso;
	private Combobox cmbCategoria;
	private Combobox cmbDivisa;
	private Spinner spMinJugadores,spMaxJugadores;
    private AnnotateDataBinder binder;
    Button btnSeleccionar,btnAgregar,btnQuitar, btnModificar,btnCancelar,btnSalir; 
    
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
		
		tipo.clear();
		tipo = servicioDatoBasico.buscar(TipoDatoBasico.CLASIFICACION_EQUIPO);
		tipoLapsos.clear();
		tipoLapsos = servicioDatoBasico.buscar(TipoDatoBasico.TIPO_LAPSO_DEPORTIVO);
		inicializar();
		
		
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
		//Events.postEvent(new Event(Events.ON_SELECT, cmbCategoria));
		tipo.clear();
		tipo.addAll(tip2);
		binder.loadComponent(cmbTipo);
		cmbTipo.setVisible(true);
		lbTipo.setVisible(true);
		
	}
	
	public void onChange$cmbTipo() {

		//buscarTipoLapso(equipo);
		String valor = cmbCategoria.getValue();
		String valor2 = tipo.get(cmbTipo.getSelectedIndex()).getNombre();
		txtNombre.setValue(valor+ " " +valor2);
		lbTipoLapso.setVisible(true);
	}
	
	public void onClick$SpMaxJugadores() {
		
	}
	
	public void onClick$SpMinJugadores() {
		
	}
	
	

	

	public void onClick$btnAgregar() {
		if (txtNombre.getText() == "") {
			alert("Seleccione un nombre");
			txtNombre.focus();
		} else if (cmbDivisa.getText() == "") {
			alert("Seleccione una Divisa");
			cmbDivisa.focus();
		} else if (cmbCategoria.getText() == "") {
			alert("Seleccione una Categoria");
			cmbCategoria.focus();
		} else if (cmbTipo.getText() == "") {
			alert("Seleccione una Categoria");
			cmbCategoria.focus();
		} else if (cmbTipoLapso.getText() == "") {
			alert("Seleccione una Categoria");
			cmbCategoria.focus();
		
		} else if (spMinJugadores.getValue() == 0) {
			alert("Seleccione la cantidad de equipos");
			spMinJugadores.focus();
		} else if (spMaxJugadores.getValue() == 0) {
							alert("Seleccione la cantidad de equipos");
							spMaxJugadores.focus();
		}
           
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
		equipo.setDatoBasicoByCodigoTipoLapso(tipoLapsos.get(cmbTipoLapso.getSelectedIndex()));
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
		
		if (txtNombre.getText() == "") {
			alert("Seleccione un nombre");
			txtNombre.focus();
			return;
		} else if (cmbDivisa.getText() == "") {
			alert("Seleccione una Divisa");
			cmbDivisa.focus();
			return;
		} else if (cmbCategoria.getText() == "") {
			alert("Seleccione una Categoria");
			cmbCategoria.focus();
			return;
		} else if (cmbTipo.getText() == "") {
			alert("Seleccione una Categoria");
			cmbCategoria.focus();
			return;
		} else if (cmbTipoLapso.getText() == "") {
			alert("Seleccione una Categoria");
			cmbCategoria.focus();
			return;
		
		} else if (spMinJugadores.getValue() == 0) {
			alert("Seleccione la cantidad de equipos");
			spMinJugadores.focus();
			return;
		} else if (spMaxJugadores.getValue() == 0) {
							alert("Seleccione la cantidad de equipos");
							spMaxJugadores.focus();
							return;
		}
		
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
           
		if (equipo!= null){
			equipo.setNombre(txtNombre.getValue()); 
			equipo.setDivisa(divisas.get(cmbDivisa.getSelectedIndex()));
			equipo.setDatoBasicoByCodigoClasificacion(tipo.get(cmbTipo.getSelectedIndex()));
			equipo.setDatoBasicoByCodigoTipoLapso(tipoLapsos.get(cmbTipoLapso.getSelectedIndex()));
			equipo.setCategoria(categorias.get(cmbCategoria.getSelectedIndex()));
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
				 try {
						Messagebox.show("Desea eliminar el equipo", "Exito", Messagebox.OK, Messagebox.QUESTION);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		txtNombre.setValue("");
		inicializar();
		binder.loadAll();
	}

	public void onClick$btnCancelar() {
		limpiar();
	}
	
	public void inicializar() {
		
		
		btnAgregar.setDisabled(false);
		btnQuitar.setDisabled(true);
		btnModificar.setDisabled(true);
	    btnSalir.setDisabled(false);
		btnCancelar.setDisabled(false);
		cmbTipo.setVisible(false);
		lbTipo.setVisible(false);
		lbTipoLapso.setVisible(false);
		spMinJugadores.setValue(12);
		spMaxJugadores.setValue(20);
		cmbCategoria.setText("");
		cmbDivisa.setText("");
		cmbTipo.setText("");
		cmbTipoLapso.setText("");
		
	}
	
   public void onSelect$listEquipo() {
	    cmbTipo.setVisible(true);
		cmbTipoLapso.setVisible(true);
		lbTipo.setVisible(true);
		lbTipoLapso.setVisible(true);
		cmbCategoria.setSelectedIndex(buscarCat(equipos.get(listEquipo.getSelectedIndex()).getCategoria()));
		//Events.postEvent(new Event(Events.ON_SELECT, cmbTipo));
        cmbDivisa.setSelectedIndex(buscarDiv(equipos.get(listEquipo.getSelectedIndex()).getDivisa()));
        cmbTipo.setSelectedIndex(buscarTipo(equipos.get(listEquipo.getSelectedIndex())));
		txtNombre.setValue((equipos.get(listEquipo.getSelectedIndex()).getNombre()));
		spMaxJugadores.setValue(equipos.get(listEquipo.getSelectedIndex()).getMaximoJugador());
		spMinJugadores.setValue(equipos.get(listEquipo.getSelectedIndex()).getMinimoJugador());
		cmbTipoLapso.setSelectedIndex(buscarTipoSelecionado(equipos.get(listEquipo.getSelectedIndex())));
		btnModificar.setDisabled(false);
		btnQuitar.setDisabled(false);
		btnAgregar.setDisabled(true);
		
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
				
				return i;
			}
			
		}
		
		       return -1; 
    }
	
	public int buscarTipoSelecionado(Equipo equipo){
		
		for (int i = 0; i < tipoLapsos.size(); i++) {
			if (tipoLapsos.get(i).getNombre().equals(equipo.getDatoBasicoByCodigoTipoLapso().getNombre())){
				
				return i;
			}
			
		}
		
		       return -1; 
		
		
    }
	
	private void aplicarConstraints() {
		// Registro Jugador
		
		txtNombre.setConstraint(Restriccion.TEXTO_SIMPLE
				.asignarRestriccionExtra("no empty"));
	
		spMinJugadores.setConstraint(Restriccion.MIN_JUGADORES
				.getRestriccion());
		
		spMaxJugadores.setConstraint(Restriccion.MAX_JUGADORES
				.getRestriccion());
		/*intEdadInferior.setConstraint(Restriccion.EDAD_INFERIOR
				.getRestriccion());
		intEdadSuperior.setConstraint(Restriccion.EDAD_SUPERIOR
				.getRestriccion());*/
		
		
		
	}
	
	
	public void showReportfromJrxml() throws JRException, IOException{
		JasperReport jasp = JasperCompileManager.compileReport(jrxmlSrc);
		JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, con);
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameters(parameters);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT ,jaspPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,arrayOutputStream);
		exporter.exportReport();
		arrayOutputStream.close();
		final AMedia amedia = new AMedia("CatalogoDeEquipos.pdf","pdf","pdf/application", arrayOutputStream.toByteArray());
		ifReporte.setContent(amedia);
	}
	// ---------------------------------------------------------------------------------------------------
	public void onClick$btnImprimir() throws SQLException, JRException, IOException {
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/Reporte_Categoria.jrxml");
		//parameters.put("NombreRepre",txtNombres.);
		showReportfromJrxml();
	}


	
}
