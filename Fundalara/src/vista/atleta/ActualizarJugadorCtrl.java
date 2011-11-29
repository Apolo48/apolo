package vista.atleta;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Image;
import vista.comun.FileLoader;


public class ActualizarJugadorCtrl extends GenericForwardComposer {

	private static final long serialVersionUID = -5912226982837429181L;
	private Image imgJugador;

	public void onClick$btnLoad() {
		new FileLoader().cargarImagen(imgJugador);

	}

}