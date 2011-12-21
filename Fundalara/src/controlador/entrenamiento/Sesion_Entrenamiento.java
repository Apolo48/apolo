package controlador.entrenamiento;

import modelo.ActividadEntrenamiento;
import modelo.Categoria;
import modelo.Equipo;
import modelo.Fase;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Timebox;
import org.zkoss.zul.Window;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import servicio.atleta.ServicioCategoria;
import servicio.atleta.ServicioEquipo;
import servicio.entrenamiento.ServicioFase;
import servicio.entrenamiento.ServicioActividadEntrenamiento;

import java.util.Date;
import java.util.List;

public class Sesion_Entrenamiento extends GenericForwardComposer {
	Window wSesionEntrenamiento;
	Button btnSalir, btnAgregar1, btnQuitar1, btnAgregar2, btnQuitar2,
			btnCancelar, btnGuardar, btnImprimir;
	Combobox cmbFase, cmbActividad, cmbMaterial, cmbCantidad, cmbCategoria,
			cmbEtapa, cmbEquipo, cmbDias, cmbTemporada;
	Listitem lst2;
	Intbox ibTiempo;
	Listbox lbActividades, lsb;
	Datebox dtbox1, dtbox2;
	List<Fase> listFase;
	ServicioFase servicioFase;
	List<ActividadEntrenamiento> listActividadEntrenamiento;
	ServicioActividadEntrenamiento servicioActividadEntrenamiento;
	List<Categoria> listCategoria;
	ServicioCategoria servicioCategoria;
	List<Equipo> listEquipo;
	ServicioEquipo servicioEquipo;
	AnnotateDataBinder binder;
	Date hoy;

	public void onClick$btnSalir() {
		wSesionEntrenamiento.detach();
	}

	public List<Categoria> getListCategoria() {
		return listCategoria;
	}

	public void setListCategoria(List<Categoria> listCategoria) {
		this.listCategoria = listCategoria;
	}

	public Categoria buscarCategoria() {
		Categoria c;
		for (Object o : servicioCategoria.listar()) {
			c = (Categoria) o;
			if (c.getCodigoCategoria().equals(
					cmbCategoria.getSelectedItem().getValue()))
				return c;
		}
		return null;
	}
	
	

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("ctrl", this, true);
		listCategoria = servicioCategoria.listar();
		listEquipo = servicioEquipo.listar();
		listFase = servicioFase.listar();
		listActividadEntrenamiento = servicioActividadEntrenamiento.listar();
		for(int i=1; i<=100; i++)
			cmbCantidad.appendItem(""+i);

	}

	public List<Equipo> getListEquipo() {
		return listEquipo;
	}

	public void setListEquipo(List<Equipo> listEquipo) {
		this.listEquipo = listEquipo;
	}



	public List<Fase> getListFase() {
		return listFase;
	}

	public void setListFase(List<Fase> listFase) {
		this.listFase = listFase;
	}
	
	

	public List<ActividadEntrenamiento> getListActividadEntrenamiento() {
		return listActividadEntrenamiento;
	}

	public void setListActividadEntrenamiento(
			List<ActividadEntrenamiento> listActividadEntrenamiento) {
		this.listActividadEntrenamiento = listActividadEntrenamiento;
	}

	public void onCreate$wSesionEntrenamiento() {
		inicializar();
		System.out.println("");
	}

	public void inicializar() {
		Date hoy = new Date();
		dtbox1.setValue(hoy);
		dtbox2.setValue(hoy);
		dtbox1.setDisabled(true);
		dtbox2.setDisabled(true);
		cmbFase.setDisabled(true);
		cmbActividad.setDisabled(true);
		ibTiempo.setValue(0);
		ibTiempo.setDisabled(true);
		btnAgregar1.setDisabled(true);
		btnAgregar2.setDisabled(true);
		btnQuitar1.setDisabled(true);
		btnQuitar2.setDisabled(true);
		cmbMaterial.setDisabled(true);
		cmbCantidad.setDisabled(true);
		btnGuardar.setDisabled(true);
		btnImprimir.setDisabled(true);
		cmbCategoria.setDisabled(false);
		cmbEtapa.setDisabled(true);
		cmbEquipo.setDisabled(true);
		cmbDias.setDisabled(true);
		cmbTemporada.setDisabled(true);
		

	}

	public void onSelect$cmbCategoria() {
		cmbEtapa.setDisabled(false);

	}

	public void onSelect$cmbEtapa() {
		
		cmbTemporada.setDisabled(false);

	}
	
	public void onSelect$cmbTemporada() {
		dtbox1.setDisabled(false);
		dtbox2.setDisabled(false);
		cmbEquipo.setDisabled(false);

	}


	public void limpiar1() {
		cmbFase.setSelectedIndex(-1);
		cmbFase.setValue(cmbFase.getValue().valueOf("--Seleccione--"));
		cmbActividad.setSelectedIndex(-1);
		cmbActividad.setValue(cmbFase.getValue().valueOf("--Seleccione--"));
		ibTiempo.setValue(0);
		btnAgregar1.setDisabled(true);
	}

	public void limpiar2() {
		cmbMaterial.setSelectedIndex(-1);
		cmbMaterial.setValue(cmbMaterial.getValue().valueOf("--Seleccione--"));
		cmbCantidad.setSelectedIndex(-1);
		cmbCantidad.setValue(cmbCantidad.getValue().valueOf("--Seleccione--"));
		btnAgregar2.setDisabled(true);
	}

	public void onClick$btnAgregar1() {

		if (lbActividades.getItemCount() == 0) {
			Listitem item = new Listitem();
			item.appendChild(new Listcell(cmbFase.getSelectedItem().getLabel()));
			item.appendChild(new Listcell(cmbActividad.getSelectedItem()
					.getLabel()));
			item.appendChild(new Listcell(ibTiempo.getValue().toString()));
			lbActividades.appendChild(item);
			limpiar1();
			cmbActividad.setDisabled(true);
			ibTiempo.setDisabled(true);
		} else {
			int I = 0;
			do {
				Listitem item = lbActividades.getItemAtIndex(I);
				Listcell lc1 = (Listcell) item.getChildren().get(0);
				if (cmbFase.getSelectedItem().getLabel().equals(lc1.getLabel())) {
					Listcell lc2 = (Listcell) item.getChildren().get(1);
					if (cmbActividad.getSelectedItem().getLabel()
							.equals(lc2.getLabel())) {
						alert("Esta Fase y Actividad ya han sido incluida");
						return;
					}
				}
				I++;
			} while (I < lbActividades.getItemCount());
			Listitem item = new Listitem();
			item.appendChild(new Listcell(cmbFase.getSelectedItem().getLabel()));
			item.appendChild(new Listcell(cmbActividad.getSelectedItem()
					.getLabel()));
			item.appendChild(new Listcell(ibTiempo.getValue().toString()));
			lbActividades.appendChild(item);
			limpiar1();
			cmbActividad.setDisabled(true);
			ibTiempo.setDisabled(true);

		}
	}

	public void onClick$btnAgregar2() {
		// System.out.println("Tamaño "+ lsb.getItemCount());

		if (lsb.getItemCount() == 0) {
			Listitem item = new Listitem();
			item.appendChild(new Listcell(cmbMaterial.getSelectedItem()
					.getLabel()));
			item.appendChild(new Listcell(cmbCantidad.getSelectedItem()
					.getLabel()));
			lsb.appendChild(item);
		}

		else {
			int I = 0;
			do {
				Listitem item = lsb.getItemAtIndex(I);
				Listcell lc = (Listcell) item.getChildren().get(0);
				if (cmbMaterial.getSelectedItem().getLabel()
						.equals(lc.getLabel())) {
					alert("No puede seleccionar el mismo material");
					return;
				}
				I++;
			} while (I < lsb.getItemCount());
			Listitem item = new Listitem();
			item.appendChild(new Listcell(cmbMaterial.getSelectedItem()
					.getLabel()));
			item.appendChild(new Listcell(cmbCantidad.getSelectedItem()
					.getLabel()));
			lsb.appendChild(item);
		}
		limpiar2();
	}

	public void onClick$btnQuitar1() {
		lbActividades.removeItemAt(lbActividades.getSelectedIndex());
		btnQuitar1.setDisabled(true);
	}

	public void onChange$dtbox2() {

		Date date = dtbox2.getValue();
		if (date.before(dtbox1.getValue())) {
			alert("La Fecha de culminacion debe ser mayor a la fecha de inicio");
			dtbox2.setValue(null);
			cmbEquipo.setDisabled(true);

		} else {

			cmbEquipo.setDisabled(false);

		}
	}

	public void onSelect$cmbFase() {
		cmbActividad.setDisabled(false);
		ibTiempo.setDisabled(true);
		btnAgregar1.setDisabled(true);
		btnQuitar1.setDisabled(true);
	}

	public void onSelect$cmbActividad() {
		ibTiempo.setDisabled(false);
		btnAgregar1.setDisabled(false);
	}
	public void onSelect$cmbEquipo() {
		cmbDias.setDisabled(false);
	}
	public void onSelect$cmbDias() {
		cmbFase.setDisabled(false);
		cmbMaterial.setDisabled(false);
		
	}

	public void onFocus$ibTiempo() {
		btnAgregar1.setDisabled(false);
		btnQuitar1.setDisabled(true);
	}

	public void onSelect$lbActividades() {
		btnQuitar1.setDisabled(false);
	}

	public void removerTodoCombo(Combobox combo) {
		int cantidad = combo.getItemCount();
		for (int i = 0; i < cantidad; i++)
			combo.removeItemAt(0);
	}

	public void onSelect$cmbMaterial() {
		cmbCantidad.setDisabled(false);
	}

	public void onSelect$cmbCantidad() {
		btnAgregar2.setDisabled(false);
		btnQuitar2.setDisabled(false);
	}

	public void onClick$btnQuitar2() {

		lsb.removeItemAt(lsb.getSelectedIndex());

	}

	public void onClick$cmbMaterial() {
		cmbCantidad.setDisabled(true);
	}

	public void onClick$cmbCantidad() {
		btnAgregar2.setDisabled(true);
		btnQuitar2.setDisabled(true);
		
	}

	public void onClick$btnCancelar() {

		limpiar1();
		limpiar2();
		cmbCategoria.setValue(cmbCategoria.getValue().valueOf("--Seleccione--"));
		cmbEtapa.setValue(cmbEtapa.getValue().valueOf("--Seleccione--"));
		cmbEquipo.setValue(cmbEquipo.getValue().valueOf("--Seleccione--"));
		cmbDias.setValue(cmbDias.getValue().valueOf("--Seleccione--"));
		cmbTemporada.setValue(cmbTemporada.getValue().valueOf("--Seleccione--"));
		dtbox1.setValue(null);
		dtbox2.setValue(null);

		int cantidad = lsb.getItemCount();
		for (int I = 0; I < cantidad; I++) {
			lsb.removeItemAt(0);
		}
		int contador = lbActividades.getItemCount();
		for (int A = 0; A < contador; A++) {
			lbActividades.removeItemAt(0);
		}
		inicializar();
	}
}