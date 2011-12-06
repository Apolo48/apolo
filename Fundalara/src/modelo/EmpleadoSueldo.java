package modelo;

// Generated 05-dic-2011 23:09:14 by Hibernate Tools 3.4.0.CR1

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
 * EmpleadoSueldo generated by hbm2java
 */
@Entity
@Table(name = "empleado_sueldo")
public class EmpleadoSueldo implements java.io.Serializable {

	private EmpleadoSueldoId id;
	private Empleado empleado;
	private double monto;
	private char estatus;

	public EmpleadoSueldo() {
	}

	public EmpleadoSueldo(EmpleadoSueldoId id, Empleado empleado, double monto,
			char estatus) {
		this.id = id;
		this.empleado = empleado;
		this.monto = monto;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cedula", column = @Column(name = "cedula", nullable = false)),
			@AttributeOverride(name = "fecha", column = @Column(name = "fecha", nullable = false, length = 13)) })
	public EmpleadoSueldoId getId() {
		return this.id;
	}

	public void setId(EmpleadoSueldoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula", nullable = false, insertable = false, updatable = false)
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Column(name = "monto", nullable = false, precision = 17, scale = 17)
	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
