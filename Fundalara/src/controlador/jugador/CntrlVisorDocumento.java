package controlador.jugador;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import org.zkoss.image.AImage;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Image;
import org.zkoss.zul.Window;

public class CntrlVisorDocumento extends GenericForwardComposer {
	private Component formulario;
	private Iframe iframeDocumento;
	private Image imgImagen;
	private Window winVisorDocumento;
	byte[] archivo = null;
	AMedia amedia = null;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		formulario = comp;
	}

	public void onCreate$winVisorDocumento() {
		byte[] archivo = (byte[]) formulario.getVariable("documento", false);

		/**** CODIGO TEMPORAL PARA VIDEO Inicio****/
		AMedia media = (AMedia) formulario.getVariable("reporte", false);
		if (media != null) {
			iframeDocumento.setContent(media);
			winVisorDocumento.setTitle("Olimpo");
		}
		/**** CODIGO TEMPORAL PARA VIDEO Fin ****/
		if (archivo != null) {
			InputStream mediais = new ByteArrayInputStream(archivo);
			String mime = "";
			try {
				mime = URLConnection.guessContentTypeFromStream(mediais);
			} catch (IOException e) {

				e.printStackTrace();
			}
			String[] formato = new String[2];
			if (mime == null) {
				formato[0] = "";
				formato[1] = "pdf";
				mime = "application/pdf";
			} else {
				formato = mime.split("/");
			}
			amedia = new AMedia("archivo." + formato[1], formato[1], mime,
					mediais);
			iframeDocumento.setContent(amedia);
			/*
			 * if (formato[0].equals("image")){
			 * iframeDocumento.setVisible(false); AImage imagen=null; try {
			 * imagen = new AImage("imagen."+formato[1], mediais); } catch
			 * (IOException e) { e.printStackTrace(); }
			 * imgImagen.setContent(imagen); imgImagen.setVisible(true);
			 * winVisorDocumento.setHeight("300px");
			 * winVisorDocumento.setWidth("200px"); }else{
			 * iframeDocumento.setContent(amedia); }
			 */
		}

	}

	public void onClick$btnSalir() {
		onClose$winVisorDocumento();
	}

	public void onClose$winVisorDocumento() {
		amedia = null;
		winVisorDocumento.detach();

	}
}