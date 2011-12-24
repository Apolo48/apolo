package comun;

import org.zkoss.zul.Messagebox;

public class Mensaje {
	public static final String TITULO ="Fundalara";
	public static final String INFORMACION ="Informaci�n";
	public static final String EXITO ="Operaci�n exitosa";
	public static final String ERROR ="Operaci�n no exitosa";
	public static final String ERROR_DATOS ="Datos incorrectos";
		
 public static void mostrarMensaje(String mensaje,String tituloMsj, String icon){
	 try {
		Messagebox.show(mensaje, TITULO+" - "+tituloMsj, Messagebox.OK,icon);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
 }
 

	
}
