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
	
		 return null;

	}

	@Override
	public Object coerceToUi(Object arg0, Component arg1) {
		Image img ; 
		if (arg0==null){
			 img = new Image();
			img.setSrc("../../Recursos/Imagenes/noFoto.jpg");
			return img;//.getContent().getByteData();
		
		}else
			return arg0;
	}

}
