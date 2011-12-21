package controlador.entrenamiento;

import java.awt.Container;

import org.zkoss.idom.Item;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.api.Datebox;

public class Asignar_Instalacion extends GenericForwardComposer {
	Combobox cmbinstalacion, cmbequipo, cmbCategoria;
	// Textbox txtmanager;
	Button btnagregar, btnquitar, btnguardar, btnimprimir, btncancelar,
			btnsalir;
	Window wndAsignarInstalacion;
	Listbox lbxAsignarInstalacion;
	Datebox dbxAsignarInstalacion;

	public void onCreate$wndAsignarInstalacion() {
		inicializar();
	}

	public void onChange$cmbinstalacion() {
		cmbequipo.setDisabled(false);

	}

	public void onChange$cmbCategoria() {
		// cmbequipo.setDisabled(false);
		cmbinstalacion.setDisabled(false);
	}

	public void onChange$dbxAsignarInstalacion() {
		// cmbinstalacion.setDisabled(false);
		cmbCategoria.setDisabled(false);
	}

	public void onChange$cmbequipo() {
		// btnagregar.setDisabled(false);
		btnagregar.setVisible(true);
	}

	public void onClick$btnagregar() {

		if (dbxAsignarInstalacion.getText() == "") {
			alert("Seleccione una fecha");
			dbxAsignarInstalacion.focus();
		} else if (cmbCategoria.getSelectedItem() == null) {
			alert("Seleccione una Categoria");
			cmbCategoria.focus();
		} else if (cmbinstalacion.getSelectedItem() == null) {
			alert("Seleccione una Instalacion");
			cmbinstalacion.focus();
		} else if (cmbequipo.getSelectedItem() == null) {
			alert("Seleccione un Equipo");
			cmbequipo.focus();
		} else {

			int i = 0;
			boolean repetido = true;
			while (i < lbxAsignarInstalacion.getItems().size()) {
				Listitem item = lbxAsignarInstalacion.getItemAtIndex(i);
				Listcell lc0 = (Listcell) item.getChildren().get(0);
				Listcell lc1 = (Listcell) item.getChildren().get(1);
				Listcell lc2 = (Listcell) item.getChildren().get(2);
				Listcell lc3 = (Listcell) item.getChildren().get(3);
				if ((dbxAsignarInstalacion.getText().equals(lc0.getLabel()))
						&&(cmbinstalacion.getValue().equals(lc1.getLabel()))&& (cmbequipo.getValue().equals(lc3.getLabel()))
						&& (cmbCategoria.getValue().equals(lc2.getLabel()))) {
					alert("La instalacion esta asignada a un equipo de la categoria seleccionada en esa fecha");
					return;
				}
				i++;
			}
			if (repetido) {
				Listitem Itm = new Listitem();
				Itm.appendChild(new Listcell(dbxAsignarInstalacion.getText()));
				Itm.appendChild(new Listcell(cmbinstalacion.getValue()));
				Itm.appendChild(new Listcell(cmbCategoria.getValue()));
				Itm.appendChild(new Listcell(cmbequipo.getValue()));
				lbxAsignarInstalacion.appendChild(Itm);
				// btnguardar.setDisabled(false);
				btnguardar.setVisible(true);
				btnimprimir.setVisible(true);
				inicializarCombos();
			}

		}
	}

	public void onClick$btnquitar() {
		if (lbxAsignarInstalacion.getSelectedItem() != null) {
			if (lbxAsignarInstalacion.getItems().size() != 0) {
				lbxAsignarInstalacion.removeItemAt(lbxAsignarInstalacion
						.getSelectedItem().getIndex());
				if (lbxAsignarInstalacion.getItems().size() == 0) {
					// btnQuitar.setDisabled(true);
					btnquitar.setVisible(false);
					btnguardar.setVisible(false);
					btnimprimir.setVisible(false);
				}
			}
		}
	}

	public void onClick$btnguardar() {
		//btnimprimir.setDisabled(false);
	}

	public void onClick$btncancelar() {
		inicializar();
	}

	public void onClick$btnsalir() {
		wndAsignarInstalacion.detach();
	}

	public void inicializar() {
		inicializarCombos();
		cmbCategoria.setText("--Seleccione--");
		dbxAsignarInstalacion.setText("");
		// btnagregar.setDisabled(true);
		btnagregar.setVisible(false);
		// btnquitar.setDisabled(true);
		btnquitar.setVisible(false);
		// btnguardar.setDisabled(true);
		btnguardar.setVisible(false);
		// btnimprimir.setDisabled(true);
		btnimprimir.setVisible(false);
		int numElementos = lbxAsignarInstalacion.getItems().size();
		for (int I = 0; I < numElementos; I++) {
			lbxAsignarInstalacion.removeItemAt(0);
		}
	}

	public void inicializarCombos() {
		cmbinstalacion.setText("--Seleccione--");
		cmbequipo.setText("--Seleccione--");
	}

	public void onSelect$lbxAsignarInstalacion() {
		if (lbxAsignarInstalacion.getItems().size() > 0) {
			// btnquitar.setDisabled(false);
			btnquitar.setVisible(true);
		}
	}

}
