package controlador.jugador;

import java.util.ArrayList;
import java.util.List;

import modelo.DatoBasico;
import modelo.DatoSocial;
import modelo.RetiroTraslado;
//import controlador.jugador.bean.RetiroTraslado;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;

import servicio.implementacion.ServicioDatoBasico;
import servicio.implementacion.ServicioRetiroTraslado;

import comun.Mensaje;
import comun.Ruta;
import comun.TipoDatoBasico;
import comun.Util;
import controlador.jugador.bean.NuevoCurso;

public class CntrlTrasladarJugador extends GenericForwardComposer {
	private Combobox cmbTipoTraslado;
	private Include incCuerpo;
	//private List<RetiroTraslado> retiroTraslados= new ArrayList<RetiroTraslado>();
	//List<RetiroTraslado> retirosTraslados= new ArrayList<RetiroTraslado>();
	

	//Servicios
	private ServicioDatoBasico servicioDatoBasico;
	private ServicioRetiroTraslado servicioRetiroTraslado;
	//Modelo
	private DatoBasico tipoOperacion = new DatoBasico();
	private RetiroTraslado retiroTraslado = new RetiroTraslado();
	// Binder
	private AnnotateDataBinder binder;
	
	private String rutasJug = Ruta.JUGADOR.getRutaVista();	

	
	//Get y Ser
	public Include getIncCuerpo() {
		return incCuerpo;
	}

	public void setIncCuerpo(Include incCuerpo) {
		this.incCuerpo = incCuerpo;
	}

	public RetiroTraslado getRetiroTraslado() {
		return retiroTraslado;
	}

	public void setRetiroTraslado(RetiroTraslado retiroTraslado) {
		this.retiroTraslado = retiroTraslado;
	}

	public DatoBasico getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(DatoBasico tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable("controller", this, false);
	}

	//Metodos para la carga del combo
	public List<DatoBasico> getOperaciones() {
		return servicioDatoBasico.buscar(TipoDatoBasico.TIPO_OPERACION);
	}


	public void onChange$cmbTipoTraslado() {
		/*		String src = "";
				String valor = cmbTipoTraslado.getSelectedItem().getValue().toString();
				Util enlace = new Util();
				if (valor.equals("1")) {
					src = "Jugador/Vistas/frmRetirarJugador.zul";
				} else {
					src = "Jugador/Vistas/frmRegistrarPase.zul";
				}
				enlace.insertarContenido(incCuerpo, src);

		*/
				
				String src = "";
				String valor = cmbTipoTraslado.getSelectedItem().getLabel();
				Util enlace = new Util();
				if (valor.equalsIgnoreCase("RETIRO")) {
					src = "frmRetirarJugador.zul";
				} else if (valor.equalsIgnoreCase("PASE")) {
					int valormax = 1;
					if ((servicioRetiroTraslado.contarfilas2(retiroTraslado)) < valormax){			
						src = "frmRegistrarPase.zul";
					}
					else {
						Mensaje.mostrarMensaje("No puede realizar más pases",
						Mensaje.INFORMACION, Messagebox.EXCLAMATION);
					}
				}
				src = rutasJug+src;
				incCuerpo.setDynamicProperty("tipoOperacion", tipoOperacion);
				enlace.insertarContenido(incCuerpo, src);	
			}
		}
