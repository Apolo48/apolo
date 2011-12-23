package modelo;

// Generated 22-dic-2011 17:58:31 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MaterialActividad generated by hbm2java
 */
@Entity
@Table(name = "material_actividad", schema = "public")
public class MaterialActividad implements java.io.Serializable {

	private int codigoMaterialActividad;
	private Material material;
	private Actividad actividad;
	private char estatus;
	private int cantidadEntregada;
	private int cantidadDevuelta;
	private Date fechaDevolucion;
	private String observacion;

	public MaterialActividad() {
	}

	public MaterialActividad(int codigoMaterialActividad, Material material,
			Actividad actividad, char estatus, int cantidadEntregada,
			int cantidadDevuelta, Date fechaDevolucion, String observacion) {
		this.codigoMaterialActividad = codigoMaterialActividad;
		this.material = material;
		this.actividad = actividad;
		this.estatus = estatus;
		this.cantidadEntregada = cantidadEntregada;
		this.cantidadDevuelta = cantidadDevuelta;
		this.fechaDevolucion = fechaDevolucion;
		this.observacion = observacion;
	}

	@Id
	@Column(name = "codigo_material_actividad", unique = true, nullable = false)
	public int getCodigoMaterialActividad() {
		return this.codigoMaterialActividad;
	}

	public void setCodigoMaterialActividad(int codigoMaterialActividad) {
		this.codigoMaterialActividad = codigoMaterialActividad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_material", nullable = false)
	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_actividad", nullable = false)
	public Actividad getActividad() {
		return this.actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@Column(name = "cantidad_entregada", nullable = false)
	public int getCantidadEntregada() {
		return this.cantidadEntregada;
	}

	public void setCantidadEntregada(int cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}

	@Column(name = "cantidad_devuelta", nullable = false)
	public int getCantidadDevuelta() {
		return this.cantidadDevuelta;
	}

	public void setCantidadDevuelta(int cantidadDevuelta) {
		this.cantidadDevuelta = cantidadDevuelta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_devolucion", nullable = false, length = 13)
	public Date getFechaDevolucion() {
		return this.fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	@Column(name = "observacion", nullable = false)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
