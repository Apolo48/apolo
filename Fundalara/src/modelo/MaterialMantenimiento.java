package modelo;

// Generated 05/12/2011 04:52:07 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MaterialMantenimiento generated by hbm2java
 */
@Entity
@Table(name = "material_mantenimiento")
public class MaterialMantenimiento implements java.io.Serializable {

	private MaterialMantenimientoId id;
	private Material material;
	private Mantenimiento mantenimiento;
	private char estatus;
	private int cantidadEntregada;
	private int cantidadDevuelta;
	private Date fechaDevolucion;

	public MaterialMantenimiento() {
	}

	public MaterialMantenimiento(MaterialMantenimientoId id, Material material,
			Mantenimiento mantenimiento, char estatus, int cantidadEntregada,
			int cantidadDevuelta, Date fechaDevolucion) {
		this.id = id;
		this.material = material;
		this.mantenimiento = mantenimiento;
		this.estatus = estatus;
		this.cantidadEntregada = cantidadEntregada;
		this.cantidadDevuelta = cantidadDevuelta;
		this.fechaDevolucion = fechaDevolucion;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoMantenimiento", column = @Column(name = "codigo_mantenimiento", nullable = false)),
			@AttributeOverride(name = "codigoMaterial", column = @Column(name = "codigo_material", nullable = false)) })
	public MaterialMantenimientoId getId() {
		return this.id;
	}

	public void setId(MaterialMantenimientoId id) {
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
	@JoinColumn(name = "codigo_mantenimiento", nullable = false, insertable = false, updatable = false)
	public Mantenimiento getMantenimiento() {
		return this.mantenimiento;
	}

	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
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

}
