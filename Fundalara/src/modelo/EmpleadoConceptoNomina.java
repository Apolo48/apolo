package modelo;

// Generated 05-dic-2011 18:58:46 by Hibernate Tools 3.4.0.CR1

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
 * EmpleadoConceptoNomina generated by hbm2java
 */
@Entity
@Table(name = "empleado_concepto_nomina")
public class EmpleadoConceptoNomina implements java.io.Serializable {

	private EmpleadoConceptoNominaId id;
	private ConceptoNomina conceptoNomina;
	private Empleado empleado;
	private double monto;
	private char estatus;
	private Date fechaInicio;
	private Date fechaFin;

	public EmpleadoConceptoNomina() {
	}

	public EmpleadoConceptoNomina(EmpleadoConceptoNominaId id,
			ConceptoNomina conceptoNomina, Empleado empleado, double monto,
			char estatus, Date fechaInicio, Date fechaFin) {
		this.id = id;
		this.conceptoNomina = conceptoNomina;
		this.empleado = empleado;
		this.monto = monto;
		this.estatus = estatus;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cedula", column = @Column(name = "cedula", nullable = false)),
			@AttributeOverride(name = "codigoConceptoNomina", column = @Column(name = "codigo_concepto_nomina", nullable = false)) })
	public EmpleadoConceptoNominaId getId() {
		return this.id;
	}

	public void setId(EmpleadoConceptoNominaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_concepto_nomina", nullable = false, insertable = false, updatable = false)
	public ConceptoNomina getConceptoNomina() {
		return this.conceptoNomina;
	}

	public void setConceptoNomina(ConceptoNomina conceptoNomina) {
		this.conceptoNomina = conceptoNomina;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio", nullable = false, length = 13)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin", nullable = false, length = 13)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
