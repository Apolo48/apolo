package controlador.entrenamiento;

import java.util.ArrayList;
import java.util.List;

import modelo.ActividadEntrenamiento;
import modelo.Categoria;
import modelo.EscalaMedicion;
import modelo.Indicador;
import modelo.ValorEscala;

import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Window;

import servicio.entrenamiento.ServicioActividadEntrenamiento;
import servicio.entrenamiento.ServicioCategoria;
import servicio.entrenamiento.ServicioDatoBasico;
import servicio.entrenamiento.ServicioEscalaMedicion;
import servicio.entrenamiento.ServicioIndicador;
import servicio.entrenamiento.ServicioTipoDato;

public class IndicadorEvaluacion extends GenericForwardComposer {
	Combobox cmbEscala, cmbCategoria, cmbActividad;
	Textbox txtIndicador;
	Comboitem nuevo;
	Window wndIndicadorEvaluacion;
	Listbox lbIndicador;
	Tree treeCategoria;
	Button btnAgregar, btnCancelar, btnSalir, btnModificar, btnQuitar;
	ServicioCategoria servicioCategoria;
	ServicioActividadEntrenamiento servicioActividadEntrenamiento;
	ServicioTipoDato servicioTipoDato;
	ServicioDatoBasico servicioDatoBasico;
	ServicioEscalaMedicion servicioEscalaMedicion;
	ServicioIndicador servicioIndicador;
	Indicador indicador;
	boolean editar;
	List <Categoria> listCategoria;
	List <EscalaMedicion> listEscala;
	AnnotateDataBinder binder;
	
	
	public List<EscalaMedicion> getListEscala() {
		return listEscala;
	}

	public void setListEscala(List<EscalaMedicion> listEscala) {
		this.listEscala = listEscala;
	}

	public Categoria buscarCategoria() {
		Categoria c;
		for (Object o : servicioCategoria.listar()) {
			c=(Categoria)o;
			if(c.getCodigoCategoria().equals(cmbCategoria.getSelectedItem().getValue()))
				return c;
		}
		return null;
	}
	
	public ActividadEntrenamiento buscarActividad() {
		ActividadEntrenamiento ae;
		for (Object o : servicioActividadEntrenamiento.listar()) {
			ae=(ActividadEntrenamiento)o;
			if(ae.getCodActividadEntrenamiento().equals(cmbActividad.getSelectedItem().getValue()))
				return ae;
		}
		return null;
	}
	
	
	
	public Indicador getIndicador() {
		return indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	public EscalaMedicion buscarEscala() {
		EscalaMedicion c;
		for (Object o : servicioEscalaMedicion.listar()) {
			c=(EscalaMedicion)o;
			if(c.getCodigoEscala().equals(cmbEscala.getSelectedItem().getValue()))
				return c;
		}
		return null;
	}
	
	public List<Categoria> getListCategoria() {
		return listCategoria;
	}

	public void setListCategoria(List<Categoria> listCategoria) {
		this.listCategoria = listCategoria;
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("ctrl", this, true);
		listCategoria = servicioCategoria.listar();
		listEscala = servicioEscalaMedicion.listar();
		editar=false;
		indicador=new Indicador();
	}
	
	public void onSelect$cmbCategoria() {
		if (cmbCategoria.getSelectedItem()!=null) {
			cmbActividad.setDisabled(!true);
			cmbEscala.setDisabled(!true);
			int c = cmbActividad.getItems().size();
			for (int i = 0; i < c; i++) 
				cmbActividad.removeItemAt(0);
			ActividadEntrenamiento ae;
			for (Object o : servicioActividadEntrenamiento.buscarPorCategoria(buscarCategoria())) {
				ae=(ActividadEntrenamiento)o;
				Comboitem combo =new Comboitem();
				combo.setLabel(ae.getNombre());
				combo.setValue(ae.getCodActividadEntrenamiento());
				cmbActividad.appendChild(combo);
			}
			cmbActividad.setSelectedIndex(-1);
		}
	}
	
	public void onCreate$wndIndicadorEvaluacion() {
		onClick$btnCancelar();
	}

	public void inicializar() {
		txtIndicador.setValue("");
		cmbEscala.setValue("-Escala de Medicion-");

	}

	public void onClick$btnAgregar() {
		if(!editar){
			if (cmbCategoria.getSelectedItem()!=null && cmbCategoria.getValue().equals("-Categoria-")) {
				alert("Seleccine la Categoria a la que desea asociar el indicador");
				cmbCategoria.focus();
	
			} else {
				if (cmbActividad.getSelectedItem()!=null && cmbActividad.getValue().equals("-Actividad-")) {
					alert("Seleccine la Actividad a la que desea asociar el indicador");
					cmbActividad.focus();
				} else {
					if (txtIndicador.getValue() == "") {
						alert("Debe introducir el nombre del Indicador que desea Registrar");
						txtIndicador.focus();
					} else {
						if (cmbEscala.getSelectedItem()!=null && cmbEscala.getValue().equals("-Escala de Medicion-")) {
							alert("Debe selecionar una Escala de Medición");
							cmbEscala.focus();
						} else {
							int i = 0;
							boolean repetido = true;
							while (i < lbIndicador.getItems().size()) {
								Listitem item = lbIndicador.getItemAtIndex(i);
								Listcell lc = (Listcell) item.getChildren().get(0);
								if (txtIndicador.getValue().equals(lc.getLabel())) {
									alert("El Indicador ya se encuentra registrado");
									repetido = false;
								}
								i++;
							}
							if (repetido) {
								indicador.setActividadEntrenamiento(buscarActividad());
								indicador.setCodigoIndicador(""+(servicioIndicador.listar().size()+1));
								indicador.setEscalaMedicion(buscarEscala());
								indicador.setEstatus('A');
								
								Listitem nvoItem = new Listitem();
								alert(nvoItem.toString());
								List<String> l = new ArrayList<String>();
								nvoItem.appendChild(new Listcell(txtIndicador.getValue()));
								String s="[";
								for (ValorEscala ve : indicador.getEscalaMedicion().getValoresEscala()) {
									s+=""+ve.getNombre()+",";
								}
								s=s.substring(0,s.length()-1);
								s+="]";
								nvoItem.appendChild(new Listcell(cmbEscala.getSelectedItem().getLabel()+" "+s));
								lbIndicador.appendChild(nvoItem);
								servicioIndicador.agregar(indicador);
								indicador.setCodigoIndicador("");
								indicador.setNombre("");
								
								binder.loadAll();
								inicializar();
							}
						}
					}
				}
			}
		}
		else{
			editar=false;
			int i = 0;
			boolean repetido = true;
			while (i < lbIndicador.getItems().size()) {
				Listitem item = lbIndicador.getItemAtIndex(i);
				Listcell lc = (Listcell) item.getChildren().get(0);
				if (txtIndicador.getValue().equals(lc.getLabel())) {
					repetido = false;
					break;
				}
				i++;
			}
			if (repetido) {
				indicador.setEscalaMedicion(buscarEscala());
				Listitem nvoItem = new Listitem();
				alert(nvoItem.toString());
				List<String> l = new ArrayList<String>();
				nvoItem.appendChild(new Listcell(txtIndicador.getValue()));
				String s="[";
				for (ValorEscala ve : indicador.getEscalaMedicion().getValoresEscala()) {
					s+=""+ve.getNombre()+",";
				}
				s=s.substring(0,s.length()-1);
				s+="]";
				nvoItem.appendChild(new Listcell(cmbEscala.getSelectedItem().getLabel()+" "+s));
				lbIndicador.appendChild(nvoItem);
				servicioIndicador.actualizar(indicador);
				indicador.setNombre("");
				binder.loadAll();
				inicializar();
			}
		}
	}

	public void onClick$btnCancelar() {
		inicializar();
		cmbCategoria.setValue("-Categoria-");
		cmbActividad.setValue("-Actividad-");
		if (lbIndicador.getItems().size() > 0) {
			int numItems = lbIndicador.getItems().size();
			for (int i = 0; i < numItems; i++) {
				lbIndicador.removeItemAt(0);
			}
		}
		cmbActividad.setDisabled(true);
		txtIndicador.setDisabled(true);
		cmbEscala.setDisabled(true);
		
		btnCancelar.setVisible(false);
		btnModificar.setVisible(false);
		btnQuitar.setVisible(false);
	}

	public void onSelect$lbIndicador() {
		if (lbIndicador.getItems().size() > 0) {
			btnModificar.setVisible(true);	
			btnQuitar.setVisible(true);

		}
	}

	public void onChange$cmbCategoria() {
		cmbActividad.setDisabled(false);
		btnCancelar.setVisible(true);
	}

	public void onChange$cmbActividad() {
		cmbEscala.setDisabled(false);
	txtIndicador.setDisabled(false);
	}

	public void onClick$btnSalir() {
		wndIndicadorEvaluacion.detach();
	}

	public void onClick$btnQuitar() {
		int n = lbIndicador.getSelectedIndex();
		lbIndicador.removeItemAt(n);

	}

	public void onClick$btnModificar() {
		if (lbIndicador.getSelectedIndex() >= 0) {
			editar=true;
			Listcell lc1 = (Listcell) lbIndicador.getSelectedItem()
					.getChildren().get(0);
			Listcell lc2 = (Listcell) lbIndicador.getSelectedItem()
					.getChildren().get(1);

			txtIndicador.setText(lc1.getLabel());
			cmbEscala.setValue(lc2.getLabel());
			lbIndicador.removeItemAt(lbIndicador.getSelectedIndex());
			txtIndicador.focus();
			}
	}

}
