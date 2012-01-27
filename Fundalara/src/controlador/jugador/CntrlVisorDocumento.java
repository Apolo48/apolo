package controlador.jugador;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Window;

public class CntrlVisorDocumento extends GenericForwardComposer {
	private Component formulario;
	private Iframe iframeDocumento;
	private Window winVisorDocumento;
	byte[] archivo = null;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
		formulario = comp;
	}

	public void onCreate$winVisorDocumento() {
		byte[] archivo = (byte[]) formulario.getVariable("documento", false);
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
				formato[0] = "pdf";
				formato[1] = "pdf";
				mime = "application/pdf";
			} else {
				formato = mime.split("/");
			}
			AMedia amedia = new AMedia("archivo." + formato[1], formato[1],
					mime, mediais);
			iframeDocumento.setContent(amedia);

		}

	}
}