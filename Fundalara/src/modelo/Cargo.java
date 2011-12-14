package modelo;

// Generated 13-dic-2011 23:21:03 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cargo generated by hbm2java
 */
@Entity
@Table(name = "cargo")
public class Cargo implements java.io.Serializable {

	private String codigoCargo;
	private String descripcion;
	private Date fechaActualizacion;
	private char estatus;
	private Set<EmpleadoCargo> empleadoCargos = new HashSet<EmpleadoCargo>(0);
	private Set<EmpleadoCargo> empleadoCargos_1 = new HashSet<EmpleadoCargo>(0);

	public Cargo() {
	}

	public Cargo(String codigoCargo, String descripcion,
			Date fechaActualizacion, char estatus) {
		this.codigoCargo = codigoCargo;
		this.descripcion = descripcion;
		this.fechaActualizacion = fechaActualizacion;
		this.estatus = estatus;
	}

	public Cargo(String codigoCargo, String descripcion,
			Date fechaActualizacion, char estatus,
			Set<EmpleadoCargo> empleadoCargos,
			Set<EmpleadoCargo> empleadoCargos_1) {
		this.codigoCargo = codigoCargo;
		this.descripcion = descripcion;
		this.fechaActualizacion = fechaActualizacion;
		this.estatus = estatus;
		this.empleadoCargos = empleadoCargos;
		this.empleadoCargos_1 = empleadoCargos_1;
	}

	@Id
	@Column(name = "codigo_cargo", unique = true, nullable = false)
	public String getCodigoCargo() {
		return this.codigoCargo;
	}

	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actualizacion", nullable = false, length = 13)
	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
	public Set<EmpleadoCargo> getEmpleadoCargos() {
		return this.empleadoCargos;
	}

	public void setEmpleadoCargos(Set<EmpleadoCargo> empleadoCargos) {
		this.empleadoCargos = empleadoCargos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
	public Set<EmpleadoCargo> getEmpleadoCargos_1() {
		return this.empleadoCargos_1;
	}

	public void setEmpleadoCargos_1(Set<EmpleadoCargo> empleadoCargos_1) {
		this.empleadoCargos_1 = empleadoCargos_1;
	}

}
