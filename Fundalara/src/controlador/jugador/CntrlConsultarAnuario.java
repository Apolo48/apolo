package controlador.jugador;

//import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.NewArray;

import javax.swing.ImageIcon;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.zkoss.image.AImage;
import org.zkoss.util.media.AMedia;
import modelo.Categoria;

import modelo.DatoBasico;
import modelo.Equipo;
import modelo.Jugador;
import modelo.LapsoDeportivo;
import modelo.Roster;
import modelo.Competencia;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.*;

import comun.ConeccionBD;
import comun.TipoDatoBasico;
import controlador.jugador.bean.Anuario;

import servicio.implementacion.ServicioCategoria;
import servicio.implementacion.ServicioCompetencia;
import servicio.implementacion.ServicioDatoBasico;
import servicio.implementacion.ServicioEquipo;
import servicio.implementacion.ServicioLapsoDeportivo;
import servicio.implementacion.ServicioRoster;

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
	private ServicioLapsoDeportivo servicioLapsoDeportivo;
	private ServicioDatoBasico servicioDatoBasico;

	private Window winAnuarioJugadores;
	private Equipo equipo = new Equipo();
	private Categoria categoria = new Categoria();
	private Jugador jugador = new Jugador();
	private Roster roster = new Roster();
	private static Roster rosters;
	private static String valorRetornado = "";
	private Competencia competencia = new Competencia();
	private LapsoDeportivo temporada = new LapsoDeportivo();
	
	private Anuario anuario = new Anuario();
	private List<Anuario> listaAnuario = new ArrayList<Anuario>();

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
	private java.awt.Image img2;
	
	private Connection con;
	private String jrxmlSrc;
	Map parameters = new HashMap();
	Iframe ifReport;
	
	private Button btnImprimir;
	private Button btnsalir;

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
	
	public LapsoDeportivo getTemporada() {
		return temporada;
	}

	public void setTemporada(LapsoDeportivo temporada) {
		this.temporada = temporada;
	}
	
	
	// Para llenar Listas y combos

	public List<Categoria> getCategorias() {
		return servicioCategoria.listar();
	}

	public List<Equipo> getEquipos() {
		return servicioEquipo.buscarPorCategoria(categoria);
	}

	public List<LapsoDeportivo> getLapsosDeportivos() {
		DatoBasico datoLapsoDeportivo = servicioDatoBasico.buscarTipo(
				TipoDatoBasico.TIPO_LAPSO_DEPORTIVO, "TEMPORADA REGULAR");
		System.out.println("datoBasico: " + datoLapsoDeportivo.getNombre());
		servicioLapsoDeportivo = new ServicioLapsoDeportivo();
		return servicioLapsoDeportivo.buscarPorTipoLapso(datoLapsoDeportivo);
	}
	
	public void onChange$cmbEquipo(){		
		listaRoster = servicioRoster.listarJugadores(equipo);

		divLista.removeChild(listAnuario);		
		Listitem listItem = null;
		listAnuario = new Listbox();
		
		listaAnuario = new ArrayList<Anuario>();
		
/*		for (int i = 0; i < listAnuario.getItemCount() ; i++) {
			listAnuario.removeItemAt(i);
		}
*/									
		for (int i = 0; i < listaRoster.size() ; i++) {
			ImageIcon n = new ImageIcon();
			AImage aImage = null;
			anuario = new Anuario();
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
	              //AImage aImage = new AImage("foto.jpg", foto);
	              aImage = new AImage("foto.jpg", foto);
	              n = new ImageIcon((byte[]) jug.getPersonaNatural().getFoto());
	              img1.setContent(aImage);
	              //img2 = n.getImage();
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
			
			anuario.setNombreJugador(jug.getPersonaNatural().getPrimerNombre());
			anuario.setApellidoJugador(jug.getPersonaNatural().getPrimerApellido());
			anuario.setFotoJugador(n.getImage());
			listaAnuario.add(anuario);
			
			listItem.appendChild(listCell2);
			listAnuario.appendChild(listItem);						
			}
		
		divLista.appendChild(listAnuario);		
	}

	
	public void onClick$btnImprimir() throws SQLException, JRException, IOException {
			
		con = ConeccionBD.getCon("postgres","postgres","123456");
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/Anuario2.jrxml");
		//jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/ExpedienteJugador.jrxml");
		parameters.put("categoriaJug" , cmbCategoria.getSelectedItem().getLabel());
		parameters.put("equipoJug" , cmbEquipo.getSelectedItem().getLabel());
		//parameters.put("fotoJug" , listaRoster.get(0).getPersonaNatural().getFoto());

		
	/*	ImageIcon n;
		Jugador jug = listaRoster.get(0);
		if (jug.getPersonaNatural().getFoto() != null) {
			n = new ImageIcon((byte[]) jug.getPersonaNatural().getFoto());
		} else {
			n = new ImageIcon();
		}
		parameters.put("fotoJug" , (Object) n);	*/
		
/*		byte[] foto = jugador.getPersonaNatural().getFoto();
        if (foto != null){
          try {
            AImage aImage = new AImage("foto.jpg", foto);
          } catch (IOException e) {
            e.printStackTrace();
          }	
        }	
        parameters.put("fotoJug" , aImage);
*/        
        
		parameters.put("nombreJug" , listaRoster.get(0).getPersonaNatural().getPrimerNombre() + " " +
				listaRoster.get(0).getPersonaNatural().getPrimerApellido());
		//parameters.put("cedulajug_1",listaRoster.get(0).getCedulaRif());
		showReportfromJrxml();
		
		// El codigo anterior debe volver a descomentarse luego de video
		/**** CODIGO TEMPORAL PARA VIDEO Inicio****//*
		jrxmlSrc = Sessions.getCurrent().getWebApp().getRealPath("/WEB-INF/reportes/anuario.pdf");
		//File archivo = new File( "C:\\reporteTemporal\\anuario.pdf");
		File archivo = new File(jrxmlSrc);
		AMedia amedia=null;
		try {
			 amedia = new AMedia(null,null,null,archivo,true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
					
		 Component visor = Executions.createComponents("Jugador/Vistas/"
					+ "frmVisorDocumento.zul", null, null);
			visor.setVariable("archivo", amedia, false);
		*//**** CODIGO TEMPORAL PARA VIDEO Fin ****/
		
		
	}	
	
	public void showReportfromJrxml() throws JRException, IOException{
/*		JasperReport jasp = JasperCompileManager.compileReport(jrxmlSrc);
		
		//JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaRoster);
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaAnuario);
		JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, ds);
		
		//JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, con);
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameters(parameters);
		
		//exporter.setDatasource(listaRoster);
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT ,jaspPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,arrayOutputStream);
		exporter.exportReport();
		arrayOutputStream.close();
		ifReport.setVisible(true);
		final AMedia amedia = new AMedia("Anuario.pdf","pdf","application/pdf", arrayOutputStream.toByteArray());
		ifReport.setContent(amedia);
*/		
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaAnuario);	
		JasperReport jasp = JasperCompileManager.compileReport(jrxmlSrc);
		JasperPrint jaspPrint = JasperFillManager.fillReport(jasp, parameters, ds);
		
		byte[] archivo = JasperExportManager.exportReportToPdf(jaspPrint);//Generar Pdf
		final AMedia amedia = new AMedia("Anuario.pdf","pdf","application/pdf", archivo);
		
		
		Component visor = Executions.createComponents("Jugador/Vistas/"
					+ "frmVisorDocumento.zul", null, null);
			visor.setVariable("archivo", amedia, false);
	}	
	
	public void onClick$btnSalir(){
		winAnuarioJugadores.detach();
	}

}
