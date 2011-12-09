package controlador.jugador;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Include;

import comun.Util;


public class InscribirJugadorCtrl extends GenericForwardComposer {
	private Combobox cmbTipoInscrip;
	private Include incCuerpo;

	public void onChange$cmbTipoInscrip() {
		String src = "";
		String valor = cmbTipoInscrip.getSelectedItem().getValue().toString();
		Util enlace = new Util();
		if (valor.equals("1")) {
			src = "Jugador/Vistas/registrarJugador.zul";
		} else if (valor.equals("2")) {
			src = "Jugador/Vistas/reingresarJugador.zul";
		} else {
			src = "Jugador/Vistas/registrarPlanVacacional.zul";
		}
		enlace.insertarContenido(incCuerpo, src);
	}

}