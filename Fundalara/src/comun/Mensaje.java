package comun;

import org.zkoss.zul.Messagebox;

public class Mensaje {
	public static final String TITULO ="Fundalara";
	
 public static void mostrarMensaje(String mensaje, String icon){
	 try {
		Messagebox.show(mensaje, TITULO, Messagebox.OK,icon);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
 }
 

	
}
