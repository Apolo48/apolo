package controlador.jugador;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.python.antlr.PythonParser.return_stmt_return;
import org.zkoss.zk.ui.Component;
import org.zkoss.zkplus.databind.TypeConverter;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Image;
import org.zkoss.zul.Radio;

public class ImageConverter implements TypeConverter{

	@Override
	public Object coerceToBean(Object arg0, Component arg1) {
		try {
			byte[] foto=(byte[]) arg0;
			InputStream in = new ByteArrayInputStream(foto);
			BufferedImage image = ImageIO.read(in);			
			return image;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;

	}

	@Override
	public Object coerceToUi(Object arg0, Component arg1) {
		if (arg0==null)
			return new Image("");
		else
			return arg0;
	}

}
