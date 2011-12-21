package controlador.entrenamiento;


import java.util.Date;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timebox;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listcell;



public class CumplimientoEntrenamiento extends GenericForwardComposer{

	Window CumplimientoEntrenamiento;	
	Button BtnGuardar, BtnCancelar, BtnSalir, BtnImprimir, BtnAgregar, BtnQuitar;
	Combobox CmbActRealizada, CmbNombManager, CmbNombMonitor, CmbInstUtiliz;
	Datebox FechaEntren;
	Listbox Actividades;
	Listitem Lst;
	Timebox HoraEntrenI, HoraEntrenF;
	Intbox idTiempo;
	Radio IdNo;
	Textbox ObservManager, ObservInst, ObservMonitor, ObservEnt;
	Date hoy;
	
		
	
public void onClick$BtnSalir(){
	CumplimientoEntrenamiento.detach();
}


	public void  onCreate$CumplimientoEntrenamiento() {
		inicializar();
		System.out.println("");
	}
	
	public void inicializar(){
		Date hoy = new Date();
		FechaEntren.setValue(hoy);
		CmbActRealizada.setDisabled(false);
//		CmbNombManager.setDisabled(true);
//		CmbNombMonitor.setDisabled(true);
//		CmbInstUtiliz.setDisabled(true);
		BtnGuardar.setDisabled(false);
		BtnCancelar.setDisabled(false);
		BtnSalir.setDisabled(false);
		BtnImprimir.setDisabled(true);
		BtnQuitar.setDisabled(false);
	}
	
	
//	public void onClick$BtnAgregar(){
//		Listitem item = new Listitem();
//		item.appendChild(new Listcell(CmbActRealizada.getSelectedItem().getLabel()));
//		item.appendChild(new Listcell(idTiempo.getValue().toString()));
//		Actividades.appendChild(item);
//		BtnQuitar.setDisabled(false);
				
//	}

	public void onClick$BtnAgregar(){

		if (Actividades.getItemCount() == 0) {
			Listitem item = new Listitem();
			item.appendChild(new Listcell(CmbActRealizada.getSelectedItem().getLabel()));
			item.appendChild(new Listcell(idTiempo.getValue().toString()));
			Actividades.appendChild(item);
//			BtnQuitar.setDisabled(true);
//			limpiar1();
//			CmbActRealizada.setDisabled(true);
//			idTiempo.setDisabled(true);
		} else {
			int I = 0;
			do {
				Listitem item = Actividades.getItemAtIndex(I);
				Listcell lc1 = (Listcell) item.getChildren().get(0);
				if (CmbActRealizada.getSelectedItem().getLabel().equals(lc1.getLabel())) {
					Listcell lc2 = (Listcell) item.getChildren().get(1);
					if (idTiempo.getValue().toString().equals(lc2.getLabel())) {
						alert("Esta actividad ya ha sido incluida");
						return;
					}
				}
				I++;
			} while (I < Actividades.getItemCount());
			Listitem item = new Listitem();
			item.appendChild(new Listcell(CmbActRealizada.getSelectedItem().getLabel()));
			item.appendChild(new Listcell(idTiempo.getValue().toString()));
			Actividades.appendChild(item);
//			limpiar1();
//			CmbActRealizada.setDisabled(false);
//			idTiempo.setDisabled(false);

		}
	}


	public void onClick$BtnQuitar(){
		
		Actividades.removeItemAt(Actividades.getSelectedIndex());
	}

	public void onCheck$IdNo() {
		ObservManager.setDisabled(true);
		ObservMonitor.setDisabled(true);
		ObservInst.setDisabled(true);
		FechaEntren.setDisabled(true);
		HoraEntrenF.setDisabled(true);
		HoraEntrenI.setDisabled(true);
		CmbActRealizada.setDisabled(true);
		idTiempo.setDisabled(true);
		CmbNombManager.setDisabled(true);
		CmbNombMonitor.setDisabled(true);
		CmbInstUtiliz.setDisabled(true);
		BtnQuitar.setDisabled(true);
		BtnAgregar.setDisabled(true);
		BtnCancelar.setDisabled(true);
		
	}
	
	public void onCheck$IdSi() {
		ObservManager.setDisabled(false);
		ObservMonitor.setDisabled(false);
		ObservInst.setDisabled(false);
		FechaEntren.setDisabled(false);
		HoraEntrenF.setDisabled(false);
		HoraEntrenI.setDisabled(false);
		CmbActRealizada.setDisabled(false);
		idTiempo.setDisabled(false);
		CmbNombManager.setDisabled(false);
		CmbNombMonitor.setDisabled(false);
		CmbInstUtiliz.setDisabled(false);
		BtnQuitar.setDisabled(false);
		BtnAgregar.setDisabled(false);
		BtnCancelar.setDisabled(false);
	}
	
	public void onClick$BtnCancelar(){
		Date hoy = new Date();
		CmbActRealizada.setSelectedIndex(-1);
		CmbActRealizada.setValue(CmbActRealizada.getValue().valueOf("--Seleccione--"));
		
		
		CmbNombManager.setSelectedIndex(-1);
		CmbNombManager.setValue(CmbNombManager.getValue().valueOf("--Seleccione--"));
		
		CmbNombMonitor.setSelectedIndex(-1);
		CmbNombMonitor.setValue(CmbNombMonitor.getValue().valueOf("--Seleccione--"));
		CmbInstUtiliz.setSelectedIndex(-1);
		CmbInstUtiliz.setValue(CmbInstUtiliz.getValue().valueOf("--Seleccione--"));
		ObservManager.setValue(null);
		ObservInst.setValue(null);
		ObservMonitor.setValue(null);
		idTiempo.setValue(0);
		HoraEntrenF.setValue(null);
		HoraEntrenI.setValue(null);
		int cantidad = Actividades.getItemCount();
		for (int I = 0; I < cantidad; I++) {
			Actividades.removeItemAt(0);
			inicializar();

	}
	}
	
}



