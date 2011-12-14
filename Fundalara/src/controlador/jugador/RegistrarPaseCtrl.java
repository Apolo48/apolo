/**
 * Clase controladora de los eventos de la vista de igual nombre.
 * 
 * @author Glendy Oliveros
 * @author Aimee Monsalve
 * @author Greisy Rodriguez
 * @author Alberto Perozo
 * @author Edgar Luzardo
 * 
 * @version 1.0 12/12/2011
 *
 * */

package controlador.jugador;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Institucion;
import modelo.Parroquia;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Include;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Window;

import servicio.compentencia.ServicioDivisa;
import servicio.jugador.ServicioCategoria;
import servicio.jugador.ServicioEquipo;
import servicio.jugador.ServicioFamiliar;
import servicio.jugador.ServicioJugador;
//import servicio.jugador.ServicioLiga;
import servicio.jugador.ServicioMunicipio;


import comun.Util;

public class RegistrarPaseCtrl extends GenericForwardComposer {

	private Window windregistrarPase;
	private String txtnNumeroPase;
	private String txtFechaSolic; 
	private Button btnExportar;
	private Button btnCancelar;
	private Button btnSalir;
	private List<Categoria> categorias;
	private List<String> lista;
	
	
	//Panel A
	//Datos del Jugador
	private String txtCedulaJug;
	private Button btnCatalogoJugador; 
	private Datebox dtboxFechaNac;
	private String txtNombreJug;
	private String txtApellidoJug;
	
	//Datos del representante
	private String txtCedulaRep;  
	private Button btnCatalogoRepresentante;
	private String txtNombreRep;
	
	//Datos de donde quiere jugar
	private String txtDivisaNueva;
	private Combobox cmbCategoriaNueva;
	private String txtLigaNueva;
	private Combobox cmbEstado;
	private String txtMotivoCambio;
	private String txtObseDivisaNueva;
	
	//Panel B
	//Datos de la Divisa
	private String txtDivisaActual;
	private String txtPresidActual;
	private String txtSecGenActual;
	private Radiogroup radioBecado;
	private Radiogroup radioSolvente;
	private Integer txtTiempoDivisa;
	private Combobox cmbTiempoDivisa;
	private Radiogroup radioRefuerzo;
	private String txtDivisaReforz;
	private Combobox cmbCategoriaActual;
	private String txtObsDivisaActual;
	
	//Panel C
	//Directorio de la Liga Actual
	private String txtLigaActualC;
	private String txtPresidLigaActualC;
	private String txtSecGenLigaActualC;
	private String txtNuevaDivisaC;
	private Combobox cmbCategoriaActualC;
	private String txtPosicionActualC; 
	private String txtCampTempC;
	private String txtTotalEquiposC; 
	private Radiogroup radioCumple322C;
	private Radiogroup radioCumple328C;
	private Radiogroup radioJCLanzadorC;
	private Radiogroup radioJCBateadorC;
	private Radiogroup radioCambioResiC;
	private Radiogroup radioReservaLigaC;
	private Radiogroup radioSidoRefC;
	private Radiogroup radioEquipoDC;
	private Radiogroup radioPartMinimaC;
	private Radiogroup radioCumple3233C;
	private Radiogroup radioRegresaOrgC;
	private Radiogroup radioCondEspeC;
	private Radiogroup radioExcep3262C;
	private Radiogroup radioPaseAutC;
	private Radiogroup radioAprobDirecC;
	private String txtObsDirecActualC;
	
	//Panel D
	//Directorio Regional de la actual entidad federal
	private String txtEntFedD;
	private String txtPresidEntFD;
	private String txtSecGenEntFD;
	private String txtNuevaDivisaD;
	private String txtLigaActualD;
	private String txtCiudadD;
	private String txtEntFedD2;
	private Radiogroup radioJClaveD;
	private Radiogroup radioCumple328D;
	private Radiogroup radioCambiaMunD;
	private Radiogroup radioCumple3261D;
	private Radiogroup radioCambiaEntFD;
	private Radiogroup radioReservaLigaD;
	private Radiogroup radioSidoRefD;
	private Radiogroup radioEquipoDD;
	private Radiogroup radioPartMinimaD;
	private Radiogroup radioCumple3233D;
	private Radiogroup radioRegresaOrgD;
	private Radiogroup radioCondEspeD;
	private Radiogroup radioExcep3262D;
	private Radiogroup radioRegresaRegNatD;
	private Radiogroup radioPaseAutD;
	private String txtPaseLigaNro;
	private String txtObsDirActualEntF;
	
	//Panel E
	//Directorio de la Nueva Liga
	private String txtNuevaLigaE;
	private String txtPresidLigaNuevaE;
	private String txtSecGenLigaNuevaE;
	private String txtNuevaDivisaE;
	private Combobox cmbCategoriaNuevaE;
	private String txtPosicionNuevaE;
	private String txtCampTempE;
	private String txtTotalEquiposE;
	private Radiogroup radioCumple322E;
	private Radiogroup radioCumple328E;
	private Radiogroup radioJCLanzadorE;
	private Radiogroup radioJCBateadorE;
	private Radiogroup radioCambioResiE;
	private Radiogroup radioReservaLigaE;
	private Radiogroup radioSidoRefE;
	private Radiogroup radioEquipoDE;
	private Radiogroup radioPartMinimaE;
	private Radiogroup radioCumple3233E;
	private Radiogroup radioRegresaOrgE;
	private Radiogroup radioCondEspeE;
	private Radiogroup radioExcep3262E;
	private Radiogroup radioPaseAutE;
	private String txtObsDirecNuevaE;
	
	//Panel F
	//Directorio Regional de la nueva entidad federal
	private String txtEntFedF;
	private String txtPresidEntFF;
	private String txtSecGenEntFF;
	private String txtNuevaDivisaF;
	private Combobox cmbCategoriaNuevaF;
	private String txtLigaNuevaF;
	private String txtMunicipioF;
	private String txtCiudadF;
	private String txtObsDirNuevaEntF;
	
	private ServicioCategoria servicioCategoria;
	private ServicioDivisa servicioDivisa;
	private ServicioEquipo servicioEquipo;
	private ServicioFamiliar servicioFamiliar;
	private ServicioJugador servicioJugador;
	//private ServicioLiga servicioLiga;
	private ServicioMunicipio servicioMunicipio;
	private Categoria categ; 
	private AnnotateDataBinder binder;
	
	
	public void onCreate$win(ForwardEvent event){
		 binder = (AnnotateDataBinder) event.getTarget().getVariable("binder", false);  
	}
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false); // Hacemos visible el
													 // modelo para el databinder
	/*													
		categ =  new Categoria();
		int codigo = servicioCategoria.listar().size();
		categ.setCodigoCategoria(String.valueOf(codigo + 1));
		lista = new ArrayList<String>();
		categorias = servicioCategoria.listar(); */
	}
	
	
	
	
	public void onClick$btnCatalogoJugador(){
		new Util().crearVentana("Jugador/Vistas/buscarJugador.zul", null, null); 		
	}
	
	public void onClick$btnCatalogoRepresentante(){
		new Util().crearVentana("Jugador/Vistas/buscarRepresentante.zul", null, null); 		
	}
	
	public void onClick$btnSalir(){
		windregistrarPase.detach();
	}
		
	public void onClick$btnCancelar(){
				
	}
	
	public void onClick$btnExportar(){
/*		try{
			Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler c:\\reportepase.pdf ");
			System.out.println("Final");
			}
		catch(IOException e) {
			e.printStackTrace();
		}*/		
	}
	
	public void onSelect$CategoriaNueva(){
		
	}
	

	public Button getBtnCatalogoJugador() {
		return btnCatalogoJugador;
	}

	public void setBtnCatalogoJugador(Button btnCatalogoJugador) {
		this.btnCatalogoJugador = btnCatalogoJugador;
	}

	public Datebox getDtboxFechaNac() {
		return dtboxFechaNac;
	}

	public void setDtboxFechaNac(Datebox dtboxFechaNac) {
		this.dtboxFechaNac = dtboxFechaNac;
	}

	

	public Button getBtnCatalogoRepresentante() {
		return btnCatalogoRepresentante;
	}

	public void setBtnCatalogoRepresentante(Button btnCatalogoRepresentante) {
		this.btnCatalogoRepresentante = btnCatalogoRepresentante;
	}

	

	public Combobox getCmbCategoriaNueva() {
		return cmbCategoriaNueva;
	}

	public void setCmbCategoriaNueva(Combobox cmbCategoriaNueva) {
		this.cmbCategoriaNueva = cmbCategoriaNueva;
	}

	

	public Combobox getCmbEstado() {
		return cmbEstado;
	}

	public void setCmbEstado(Combobox cmbEstado) {
		this.cmbEstado = cmbEstado;
	}

	

	public Radiogroup getRadioBecado() {
		return radioBecado;
	}

	public void setRadioBecado(Radiogroup radioBecado) {
		this.radioBecado = radioBecado;
	}

	public Radiogroup getRadioSolvente() {
		return radioSolvente;
	}

	public void setRadioSolvente(Radiogroup radioSolvente) {
		this.radioSolvente = radioSolvente;
	}

	

	public Combobox getCmbTiempoDivisa() {
		return cmbTiempoDivisa;
	}

	public void setCmbTiempoDivisa(Combobox cmbTiempoDivisa) {
		this.cmbTiempoDivisa = cmbTiempoDivisa;
	}

	public Radiogroup getRadioRefuerzo() {
		return radioRefuerzo;
	}

	public void setRadioRefuerzo(Radiogroup radioRefuerzo) {
		this.radioRefuerzo = radioRefuerzo;
	}

	

	public Combobox getCmbCategoriaActual() {
		return cmbCategoriaActual;
	}

	public void setCmbCategoriaActual(Combobox cmbCategoriaActual) {
		this.cmbCategoriaActual = cmbCategoriaActual;
	}

	

	public Combobox getCmbCategoriaActualC() {
		return cmbCategoriaActualC;
	}

	public void setCmbCategoriaActualC(Combobox cmbCategoriaActualC) {
		this.cmbCategoriaActualC = cmbCategoriaActualC;
	}

	

	public Radiogroup getRadioCumple322C() {
		return radioCumple322C;
	}

	public void setRadioCumple322C(Radiogroup radioCumple322C) {
		this.radioCumple322C = radioCumple322C;
	}

	public Radiogroup getRadioCumple328C() {
		return radioCumple328C;
	}

	public void setRadioCumple328C(Radiogroup radioCumple328C) {
		this.radioCumple328C = radioCumple328C;
	}

	public Radiogroup getRadioJCLanzadorC() {
		return radioJCLanzadorC;
	}

	public void setRadioJCLanzadorC(Radiogroup radioJCLanzadorC) {
		this.radioJCLanzadorC = radioJCLanzadorC;
	}

	public Radiogroup getRadioJCBateadorC() {
		return radioJCBateadorC;
	}

	public void setRadioJCBateadorC(Radiogroup radioJCBateadorC) {
		this.radioJCBateadorC = radioJCBateadorC;
	}

	public Radiogroup getRadioCambioResiC() {
		return radioCambioResiC;
	}

	public void setRadioCambioResiC(Radiogroup radioCambioResiC) {
		this.radioCambioResiC = radioCambioResiC;
	}

	public Radiogroup getRadioReservaLigaC() {
		return radioReservaLigaC;
	}

	public void setRadioReservaLigaC(Radiogroup radioReservaLigaC) {
		this.radioReservaLigaC = radioReservaLigaC;
	}

	public Radiogroup getRadioSidoRefC() {
		return radioSidoRefC;
	}

	public void setRadioSidoRefC(Radiogroup radioSidoRefC) {
		this.radioSidoRefC = radioSidoRefC;
	}

	public Radiogroup getRadioEquipoDC() {
		return radioEquipoDC;
	}

	public void setRadioEquipoDC(Radiogroup radioEquipoDC) {
		this.radioEquipoDC = radioEquipoDC;
	}

	public Radiogroup getRadioPartMinimaC() {
		return radioPartMinimaC;
	}

	public void setRadioPartMinimaC(Radiogroup radioPartMinimaC) {
		this.radioPartMinimaC = radioPartMinimaC;
	}

	public Radiogroup getRadioCumple3233C() {
		return radioCumple3233C;
	}

	public void setRadioCumple3233C(Radiogroup radioCumple3233C) {
		this.radioCumple3233C = radioCumple3233C;
	}

	public Radiogroup getRadioRegresaOrgC() {
		return radioRegresaOrgC;
	}

	public void setRadioRegresaOrgC(Radiogroup radioRegresaOrgC) {
		this.radioRegresaOrgC = radioRegresaOrgC;
	}

	public Radiogroup getRadioCondEspeC() {
		return radioCondEspeC;
	}

	public void setRadioCondEspeC(Radiogroup radioCondEspeC) {
		this.radioCondEspeC = radioCondEspeC;
	}

	public Radiogroup getRadioExcep3262C() {
		return radioExcep3262C;
	}

	public void setRadioExcep3262C(Radiogroup radioExcep3262C) {
		this.radioExcep3262C = radioExcep3262C;
	}

	public Radiogroup getRadioPaseAutC() {
		return radioPaseAutC;
	}

	public void setRadioPaseAutC(Radiogroup radioPaseAutC) {
		this.radioPaseAutC = radioPaseAutC;
	}

	public Radiogroup getRadioAprobDirecC() {
		return radioAprobDirecC;
	}

	public void setRadioAprobDirecC(Radiogroup radioAprobDirecC) {
		this.radioAprobDirecC = radioAprobDirecC;
	}

	
	public String getTxtnNumeroPase() {
		return txtnNumeroPase;
	}


	public void setTxtnNumeroPase(String txtnNumeroPase) {
		this.txtnNumeroPase = txtnNumeroPase;
	}


	public String getTxtFechaSolic() {
		return txtFechaSolic;
	}


	public void setTxtFechaSolic(String txtFechaSolic) {
		this.txtFechaSolic = txtFechaSolic;
	}


	public String getTxtCedulaJug() {
		return txtCedulaJug;
	}


	public void setTxtCedulaJug(String txtCedulaJug) {
		this.txtCedulaJug = txtCedulaJug;
	}


	public String getTxtNombreJug() {
		return txtNombreJug;
	}


	public void setTxtNombreJug(String txtNombreJug) {
		this.txtNombreJug = txtNombreJug;
	}


	public String getTxtApellidoJug() {
		return txtApellidoJug;
	}


	public void setTxtApellidoJug(String txtApellidoJug) {
		this.txtApellidoJug = txtApellidoJug;
	}


	public String getTxtCedulaRep() {
		return txtCedulaRep;
	}


	public void setTxtCedulaRep(String txtCedulaRep) {
		this.txtCedulaRep = txtCedulaRep;
	}


	public String getTxtNombreRep() {
		return txtNombreRep;
	}


	public void setTxtNombreRep(String txtNombreRep) {
		this.txtNombreRep = txtNombreRep;
	}


	public String getTxtDivisaNueva() {
		return txtDivisaNueva;
	}


	public void setTxtDivisaNueva(String txtDivisaNueva) {
		this.txtDivisaNueva = txtDivisaNueva;
	}


	public String getTxtLigaNueva() {
		return txtLigaNueva;
	}


	public void setTxtLigaNueva(String txtLigaNueva) {
		this.txtLigaNueva = txtLigaNueva;
	}


	public String getTxtMotivoCambio() {
		return txtMotivoCambio;
	}


	public void setTxtMotivoCambio(String txtMotivoCambio) {
		this.txtMotivoCambio = txtMotivoCambio;
	}


	public String getTxtObseDivisaNueva() {
		return txtObseDivisaNueva;
	}


	public void setTxtObseDivisaNueva(String txtObseDivisaNueva) {
		this.txtObseDivisaNueva = txtObseDivisaNueva;
	}


	public String getTxtDivisaActual() {
		return txtDivisaActual;
	}


	public void setTxtDivisaActual(String txtDivisaActual) {
		this.txtDivisaActual = txtDivisaActual;
	}


	public String getTxtPresidActual() {
		return txtPresidActual;
	}


	public void setTxtPresidActual(String txtPresidActual) {
		this.txtPresidActual = txtPresidActual;
	}


	public String getTxtSecGenActual() {
		return txtSecGenActual;
	}


	public void setTxtSecGenActual(String txtSecGenActual) {
		this.txtSecGenActual = txtSecGenActual;
	}


	public Integer getTxtTiempoDivisa() {
		return txtTiempoDivisa;
	}


	public void setTxtTiempoDivisa(Integer txtTiempoDivisa) {
		this.txtTiempoDivisa = txtTiempoDivisa;
	}


	public String getTxtDivisaReforz() {
		return txtDivisaReforz;
	}


	public void setTxtDivisaReforz(String txtDivisaReforz) {
		this.txtDivisaReforz = txtDivisaReforz;
	}


	public String getTxtObsDivisaActual() {
		return txtObsDivisaActual;
	}


	public void setTxtObsDivisaActual(String txtObsDivisaActual) {
		this.txtObsDivisaActual = txtObsDivisaActual;
	}


	public String getTxtLigaActualC() {
		return txtLigaActualC;
	}


	public void setTxtLigaActualC(String txtLigaActualC) {
		this.txtLigaActualC = txtLigaActualC;
	}


	public String getTxtPresidLigaActualC() {
		return txtPresidLigaActualC;
	}


	public void setTxtPresidLigaActualC(String txtPresidLigaActualC) {
		this.txtPresidLigaActualC = txtPresidLigaActualC;
	}


	public String getTxtSecGenLigaActualC() {
		return txtSecGenLigaActualC;
	}


	public void setTxtSecGenLigaActualC(String txtSecGenLigaActualC) {
		this.txtSecGenLigaActualC = txtSecGenLigaActualC;
	}


	public String getTxtNuevaDivisaC() {
		return txtNuevaDivisaC;
	}


	public void setTxtNuevaDivisaC(String txtNuevaDivisaC) {
		this.txtNuevaDivisaC = txtNuevaDivisaC;
	}


	public String getTxtPosicionActualC() {
		return txtPosicionActualC;
	}


	public void setTxtPosicionActualC(String txtPosicionActualC) {
		this.txtPosicionActualC = txtPosicionActualC;
	}


	public String getTxtCampTempC() {
		return txtCampTempC;
	}


	public void setTxtCampTempC(String txtCampTempC) {
		this.txtCampTempC = txtCampTempC;
	}


	public String getTxtTotalEquiposC() {
		return txtTotalEquiposC;
	}


	public void setTxtTotalEquiposC(String txtTotalEquiposC) {
		this.txtTotalEquiposC = txtTotalEquiposC;
	}


	public String getTxtObsDirecActualC() {
		return txtObsDirecActualC;
	}


	public void setTxtObsDirecActualC(String txtObsDirecActualC) {
		this.txtObsDirecActualC = txtObsDirecActualC;
	}


	public String getTxtEntFedD() {
		return txtEntFedD;
	}


	public void setTxtEntFedD(String txtEntFedD) {
		this.txtEntFedD = txtEntFedD;
	}


	public String getTxtPresidEntFD() {
		return txtPresidEntFD;
	}


	public void setTxtPresidEntFD(String txtPresidEntFD) {
		this.txtPresidEntFD = txtPresidEntFD;
	}


	public String getTxtSecGenEntFD() {
		return txtSecGenEntFD;
	}


	public void setTxtSecGenEntFD(String txtSecGenEntFD) {
		this.txtSecGenEntFD = txtSecGenEntFD;
	}


	public String getTxtNuevaDivisaD() {
		return txtNuevaDivisaD;
	}


	public void setTxtNuevaDivisaD(String txtNuevaDivisaD) {
		this.txtNuevaDivisaD = txtNuevaDivisaD;
	}


	public String getTxtLigaActualD() {
		return txtLigaActualD;
	}


	public void setTxtLigaActualD(String txtLigaActualD) {
		this.txtLigaActualD = txtLigaActualD;
	}


	public String getTxtCiudadD() {
		return txtCiudadD;
	}


	public void setTxtCiudadD(String txtCiudadD) {
		this.txtCiudadD = txtCiudadD;
	}


	public String getTxtEntFedD2() {
		return txtEntFedD2;
	}


	public void setTxtEntFedD2(String txtEntFedD2) {
		this.txtEntFedD2 = txtEntFedD2;
	}


	public String getTxtPaseLigaNro() {
		return txtPaseLigaNro;
	}


	public void setTxtPaseLigaNro(String txtPaseLigaNro) {
		this.txtPaseLigaNro = txtPaseLigaNro;
	}


	public String getTxtObsDirActualEntF() {
		return txtObsDirActualEntF;
	}


	public void setTxtObsDirActualEntF(String txtObsDirActualEntF) {
		this.txtObsDirActualEntF = txtObsDirActualEntF;
	}


	public String getTxtNuevaLigaE() {
		return txtNuevaLigaE;
	}


	public void setTxtNuevaLigaE(String txtNuevaLigaE) {
		this.txtNuevaLigaE = txtNuevaLigaE;
	}


	public String getTxtPresidLigaNuevaE() {
		return txtPresidLigaNuevaE;
	}


	public void setTxtPresidLigaNuevaE(String txtPresidLigaNuevaE) {
		this.txtPresidLigaNuevaE = txtPresidLigaNuevaE;
	}


	public String getTxtSecGenLigaNuevaE() {
		return txtSecGenLigaNuevaE;
	}


	public void setTxtSecGenLigaNuevaE(String txtSecGenLigaNuevaE) {
		this.txtSecGenLigaNuevaE = txtSecGenLigaNuevaE;
	}


	public String getTxtNuevaDivisaE() {
		return txtNuevaDivisaE;
	}


	public void setTxtNuevaDivisaE(String txtNuevaDivisaE) {
		this.txtNuevaDivisaE = txtNuevaDivisaE;
	}


	public String getTxtPosicionNuevaE() {
		return txtPosicionNuevaE;
	}


	public void setTxtPosicionNuevaE(String txtPosicionNuevaE) {
		this.txtPosicionNuevaE = txtPosicionNuevaE;
	}


	public String getTxtCampTempE() {
		return txtCampTempE;
	}


	public void setTxtCampTempE(String txtCampTempE) {
		this.txtCampTempE = txtCampTempE;
	}


	public String getTxtTotalEquiposE() {
		return txtTotalEquiposE;
	}


	public void setTxtTotalEquiposE(String txtTotalEquiposE) {
		this.txtTotalEquiposE = txtTotalEquiposE;
	}


	public String getTxtObsDirecNuevaE() {
		return txtObsDirecNuevaE;
	}


	public void setTxtObsDirecNuevaE(String txtObsDirecNuevaE) {
		this.txtObsDirecNuevaE = txtObsDirecNuevaE;
	}


	public String getTxtEntFedF() {
		return txtEntFedF;
	}


	public void setTxtEntFedF(String txtEntFedF) {
		this.txtEntFedF = txtEntFedF;
	}


	public String getTxtPresidEntFF() {
		return txtPresidEntFF;
	}


	public void setTxtPresidEntFF(String txtPresidEntFF) {
		this.txtPresidEntFF = txtPresidEntFF;
	}


	public String getTxtSecGenEntFF() {
		return txtSecGenEntFF;
	}


	public void setTxtSecGenEntFF(String txtSecGenEntFF) {
		this.txtSecGenEntFF = txtSecGenEntFF;
	}


	public String getTxtNuevaDivisaF() {
		return txtNuevaDivisaF;
	}


	public void setTxtNuevaDivisaF(String txtNuevaDivisaF) {
		this.txtNuevaDivisaF = txtNuevaDivisaF;
	}


	public String getTxtLigaNuevaF() {
		return txtLigaNuevaF;
	}


	public void setTxtLigaNuevaF(String txtLigaNuevaF) {
		this.txtLigaNuevaF = txtLigaNuevaF;
	}


	public String getTxtMunicipioF() {
		return txtMunicipioF;
	}


	public void setTxtMunicipioF(String txtMunicipioF) {
		this.txtMunicipioF = txtMunicipioF;
	}


	public String getTxtCiudadF() {
		return txtCiudadF;
	}


	public void setTxtCiudadF(String txtCiudadF) {
		this.txtCiudadF = txtCiudadF;
	}


	public String getTxtObsDirNuevaEntF() {
		return txtObsDirNuevaEntF;
	}


	public void setTxtObsDirNuevaEntF(String txtObsDirNuevaEntF) {
		this.txtObsDirNuevaEntF = txtObsDirNuevaEntF;
	}


	public Radiogroup getRadioJClaveD() {
		return radioJClaveD;
	}

	public void setRadioJClaveD(Radiogroup radioJClaveD) {
		this.radioJClaveD = radioJClaveD;
	}

	public Radiogroup getRadioCumple328D() {
		return radioCumple328D;
	}

	public void setRadioCumple328D(Radiogroup radioCumple328D) {
		this.radioCumple328D = radioCumple328D;
	}

	public Radiogroup getRadioCambiaMunD() {
		return radioCambiaMunD;
	}

	public void setRadioCambiaMunD(Radiogroup radioCambiaMunD) {
		this.radioCambiaMunD = radioCambiaMunD;
	}

	public Radiogroup getRadioCumple3261D() {
		return radioCumple3261D;
	}

	public void setRadioCumple3261D(Radiogroup radioCumple3261D) {
		this.radioCumple3261D = radioCumple3261D;
	}

	public Radiogroup getRadioCambiaEntFD() {
		return radioCambiaEntFD;
	}

	public void setRadioCambiaEntFD(Radiogroup radioCambiaEntFD) {
		this.radioCambiaEntFD = radioCambiaEntFD;
	}

	public Radiogroup getRadioReservaLigaD() {
		return radioReservaLigaD;
	}

	public void setRadioReservaLigaD(Radiogroup radioReservaLigaD) {
		this.radioReservaLigaD = radioReservaLigaD;
	}

	public Radiogroup getRadioSidoRefD() {
		return radioSidoRefD;
	}

	public void setRadioSidoRefD(Radiogroup radioSidoRefD) {
		this.radioSidoRefD = radioSidoRefD;
	}

	public Radiogroup getRadioEquipoDD() {
		return radioEquipoDD;
	}

	public void setRadioEquipoDD(Radiogroup radioEquipoDD) {
		this.radioEquipoDD = radioEquipoDD;
	}

	public Radiogroup getRadioPartMinimaD() {
		return radioPartMinimaD;
	}

	public void setRadioPartMinimaD(Radiogroup radioPartMinimaD) {
		this.radioPartMinimaD = radioPartMinimaD;
	}

	public Radiogroup getRadioCumple3233D() {
		return radioCumple3233D;
	}

	public void setRadioCumple3233D(Radiogroup radioCumple3233D) {
		this.radioCumple3233D = radioCumple3233D;
	}

	public Radiogroup getRadioRegresaOrgD() {
		return radioRegresaOrgD;
	}

	public void setRadioRegresaOrgD(Radiogroup radioRegresaOrgD) {
		this.radioRegresaOrgD = radioRegresaOrgD;
	}

	public Radiogroup getRadioCondEspeD() {
		return radioCondEspeD;
	}

	public void setRadioCondEspeD(Radiogroup radioCondEspeD) {
		this.radioCondEspeD = radioCondEspeD;
	}

	public Radiogroup getRadioExcep3262D() {
		return radioExcep3262D;
	}

	public void setRadioExcep3262D(Radiogroup radioExcep3262D) {
		this.radioExcep3262D = radioExcep3262D;
	}

	public Radiogroup getRadioRegresaRegNatD() {
		return radioRegresaRegNatD;
	}

	public void setRadioRegresaRegNatD(Radiogroup radioRegresaRegNatD) {
		this.radioRegresaRegNatD = radioRegresaRegNatD;
	}

	public Radiogroup getRadioPaseAutD() {
		return radioPaseAutD;
	}

	public void setRadioPaseAutD(Radiogroup radioPaseAutD) {
		this.radioPaseAutD = radioPaseAutD;
	}

	
	public Combobox getCmbCategoriaNuevaE() {
		return cmbCategoriaNuevaE;
	}

	public void setCmbCategoriaNuevaE(Combobox cmbCategoriaNuevaE) {
		this.cmbCategoriaNuevaE = cmbCategoriaNuevaE;
	}

	
	public Radiogroup getRadioCumple322E() {
		return radioCumple322E;
	}

	public void setRadioCumple322E(Radiogroup radioCumple322E) {
		this.radioCumple322E = radioCumple322E;
	}

	public Radiogroup getRadioCumple328E() {
		return radioCumple328E;
	}

	public void setRadioCumple328E(Radiogroup radioCumple328E) {
		this.radioCumple328E = radioCumple328E;
	}

	public Radiogroup getRadioJCLanzadorE() {
		return radioJCLanzadorE;
	}

	public void setRadioJCLanzadorE(Radiogroup radioJCLanzadorE) {
		this.radioJCLanzadorE = radioJCLanzadorE;
	}

	public Radiogroup getRadioJCBateadorE() {
		return radioJCBateadorE;
	}

	public void setRadioJCBateadorE(Radiogroup radioJCBateadorE) {
		this.radioJCBateadorE = radioJCBateadorE;
	}

	public Radiogroup getRadioCambioResiE() {
		return radioCambioResiE;
	}

	public void setRadioCambioResiE(Radiogroup radioCambioResiE) {
		this.radioCambioResiE = radioCambioResiE;
	}

	public Radiogroup getRadioReservaLigaE() {
		return radioReservaLigaE;
	}

	public void setRadioReservaLigaE(Radiogroup radioReservaLigaE) {
		this.radioReservaLigaE = radioReservaLigaE;
	}

	public Radiogroup getRadioSidoRefE() {
		return radioSidoRefE;
	}

	public void setRadioSidoRefE(Radiogroup radioSidoRefE) {
		this.radioSidoRefE = radioSidoRefE;
	}

	public Radiogroup getRadioEquipoDE() {
		return radioEquipoDE;
	}

	public void setRadioEquipoDE(Radiogroup radioEquipoDE) {
		this.radioEquipoDE = radioEquipoDE;
	}

	public Radiogroup getRadioPartMinimaE() {
		return radioPartMinimaE;
	}

	public void setRadioPartMinimaE(Radiogroup radioPartMinimaE) {
		this.radioPartMinimaE = radioPartMinimaE;
	}

	public Radiogroup getRadioCumple3233E() {
		return radioCumple3233E;
	}

	public void setRadioCumple3233E(Radiogroup radioCumple3233E) {
		this.radioCumple3233E = radioCumple3233E;
	}

	public Radiogroup getRadioRegresaOrgE() {
		return radioRegresaOrgE;
	}

	public void setRadioRegresaOrgE(Radiogroup radioRegresaOrgE) {
		this.radioRegresaOrgE = radioRegresaOrgE;
	}

	public Radiogroup getRadioCondEspeE() {
		return radioCondEspeE;
	}

	public void setRadioCondEspeE(Radiogroup radioCondEspeE) {
		this.radioCondEspeE = radioCondEspeE;
	}

	public Radiogroup getRadioExcep3262E() {
		return radioExcep3262E;
	}

	public void setRadioExcep3262E(Radiogroup radioExcep3262E) {
		this.radioExcep3262E = radioExcep3262E;
	}

	public Radiogroup getRadioPaseAutE() {
		return radioPaseAutE;
	}

	public void setRadioPaseAutE(Radiogroup radioPaseAutE) {
		this.radioPaseAutE = radioPaseAutE;
	}

	
	public Combobox getCmbCategoriaNuevaF() {
		return cmbCategoriaNuevaF;
	}

	public void setCmbCategoriaNuevaF(Combobox cmbCategoriaNuevaF) {
		this.cmbCategoriaNuevaF = cmbCategoriaNuevaF;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}	
	
	

}



