package controlador.entrenamiento;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.api.Datebox;
import modelo.Temporada;
import servicio.entrenamiento.ServicioTemporada;


public class ControladorTemporada extends GenericForwardComposer {
	
	Combobox cmbinstalacion, cmbequipo, cmbCategoria;
	Button btnGuardar, btnCancelar,btnSalir;
	Window wndTemporada;
	Textbox txtNombre;
	Datebox dbInicio,dbFinal;
	Temporada temporada;
	ServicioTemporada servicioTemporada;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("cntrl", this, true);
		temporada = new Temporada();
	}

//	public void onChange$cmbinstalacion() {
//		cmbequipo.setDisabled(false);
//	}
//	
//	public void onClick$btnGuardar() {
//		Integer codigo;
//		System.out.println(servicioTemporada.listar().size());
//		if (servicioTemporada.listar() == null){
//			codigo = 1;
//		}else{
//			codigo=servicioTemporada.listar().size()+1;
//		}
//		temporada.setCodigoTemporada("1");
//		temporada.setEstatus('A');
//		temporada.setCategoria(null);
//		servicioTemporada.agregar(temporada);
//		dbFinal.setValue(null);
//		dbInicio.setValue(null);
//		txtNombre.setText("");
//	}
//
//	public void onClick$btnCancelar() {
//		dbFinal.setValue(null);
//		dbInicio.setValue(null);
//		txtNombre.setText("");
//	}
//	
//	public void onChange$dbFinal(){
//		txtNombre.setValue("2011-2012");
//		//txtNombre
//	}
//	
//	public void onClick$btnSalir() {
//		wndTemporada.detach();
//	}

	

}
