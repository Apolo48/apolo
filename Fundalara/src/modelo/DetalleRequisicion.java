package modelo;

// Generated 13-ene-2012 22:07:27 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DetalleRequisicion generated by hbm2java
 */
@Entity
@Table(name = "detalle_requisicion", schema = "public")
public class DetalleRequisicion implements java.io.Serializable {

	private DetalleRequisicionId id;
	private Material material;
	private Requisicion requisicion;
	private int cantidadSolicitada;
	private int cantidadEntregada;
	private char estatus;

	public DetalleRequisicion() {
	}

	public DetalleRequisicion(DetalleRequisicionId id, Material material,
			Requisicion requisicion, int cantidadSolicitada,
			int cantidadEntregada, char estatus) {
		this.id = id;
		this.material = material;
		this.requisicion = requisicion;
		this.cantidadSolicitada = cantidadSolicitada;
		this.cantidadEntregada = cantidadEntregada;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoMaterial", column = @Column(name = "codigo_material", nullable = false)),
			@AttributeOverride(name = "codigoRequisicion", column = @Column(name = "codigo_requisicion", nullable = false)) })
	public DetalleRequisicionId getId() {
		return this.id;
	}

	public void setId(DetalleRequisicionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_material", nullable = false, insertable = false, updatable = false)
	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_requisicion", nullable = false, insertable = false, updatable = false)
	public Requisicion getRequisicion() {
		return this.requisicion;
	}

	public void setRequisicion(Requisicion requisicion) {
		this.requisicion = requisicion;
	}

	@Column(name = "cantidad_solicitada", nullable = false)
	public int getCantidadSolicitada() {
		return this.cantidadSolicitada;
	}

	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	@Column(name = "cantidad_entregada", nullable = false)
	public int getCantidadEntregada() {
		return this.cantidadEntregada;
	}

	public void setCantidadEntregada(int cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
