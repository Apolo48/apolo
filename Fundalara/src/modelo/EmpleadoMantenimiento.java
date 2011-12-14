package modelo;

// Generated 13-dic-2011 23:21:03 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EmpleadoMantenimiento generated by hbm2java
 */
@Entity
@Table(name = "empleado_mantenimiento")
public class EmpleadoMantenimiento implements java.io.Serializable {

	private EmpleadoMantenimientoId id;
	private Mantenimiento mantenimiento;
	private Empleado empleado;
	private char estatus;
	private Set<TareaMantenimiento> tareaMantenimientosForEmpleadoMantenimientoTareaMantenimientoFk = new HashSet<TareaMantenimiento>(
			0);
	private Set<TareaMantenimiento> tareaMantenimientosForFk2be9c788a2d2a5db = new HashSet<TareaMantenimiento>(
			0);

	public EmpleadoMantenimiento() {
	}

	public EmpleadoMantenimiento(EmpleadoMantenimientoId id,
			Mantenimiento mantenimiento, Empleado empleado, char estatus) {
		this.id = id;
		this.mantenimiento = mantenimiento;
		this.empleado = empleado;
		this.estatus = estatus;
	}

	public EmpleadoMantenimiento(
			EmpleadoMantenimientoId id,
			Mantenimiento mantenimiento,
			Empleado empleado,
			char estatus,
			Set<TareaMantenimiento> tareaMantenimientosForEmpleadoMantenimientoTareaMantenimientoFk,
			Set<TareaMantenimiento> tareaMantenimientosForFk2be9c788a2d2a5db) {
		this.id = id;
		this.mantenimiento = mantenimiento;
		this.empleado = empleado;
		this.estatus = estatus;
		this.tareaMantenimientosForEmpleadoMantenimientoTareaMantenimientoFk = tareaMantenimientosForEmpleadoMantenimientoTareaMantenimientoFk;
		this.tareaMantenimientosForFk2be9c788a2d2a5db = tareaMantenimientosForFk2be9c788a2d2a5db;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoMantenimiento", column = @Column(name = "codigo_mantenimiento", nullable = false)),
			@AttributeOverride(name = "cedula", column = @Column(name = "cedula", nullable = false)) })
	public EmpleadoMantenimientoId getId() {
		return this.id;
	}

	public void setId(EmpleadoMantenimientoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_mantenimiento", nullable = false, insertable = false, updatable = false)
	public Mantenimiento getMantenimiento() {
		return this.mantenimiento;
	}

	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula", nullable = false, insertable = false, updatable = false)
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleadoMantenimientoByFk2be9c788a2d2a5db")
	public Set<TareaMantenimiento> getTareaMantenimientosForEmpleadoMantenimientoTareaMantenimientoFk() {
		return this.tareaMantenimientosForEmpleadoMantenimientoTareaMantenimientoFk;
	}

	public void setTareaMantenimientosForEmpleadoMantenimientoTareaMantenimientoFk(
			Set<TareaMantenimiento> tareaMantenimientosForEmpleadoMantenimientoTareaMantenimientoFk) {
		this.tareaMantenimientosForEmpleadoMantenimientoTareaMantenimientoFk = tareaMantenimientosForEmpleadoMantenimientoTareaMantenimientoFk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleadoMantenimientoByFk2be9c788a2d2a5db")
	public Set<TareaMantenimiento> getTareaMantenimientosForFk2be9c788a2d2a5db() {
		return this.tareaMantenimientosForFk2be9c788a2d2a5db;
	}

	public void setTareaMantenimientosForFk2be9c788a2d2a5db(
			Set<TareaMantenimiento> tareaMantenimientosForFk2be9c788a2d2a5db) {
		this.tareaMantenimientosForFk2be9c788a2d2a5db = tareaMantenimientosForFk2be9c788a2d2a5db;
	}

}
