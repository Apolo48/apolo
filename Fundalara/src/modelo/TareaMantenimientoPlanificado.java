package modelo;

// Generated 05/12/2011 04:52:07 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TareaMantenimientoPlanificado generated by hbm2java
 */
@Entity
@Table(name = "tarea_mantenimiento_planificado")
public class TareaMantenimientoPlanificado implements java.io.Serializable {

	private TareaMantenimientoPlanificadoId id;
	private PlanificacionMantenimiento planificacionMantenimiento;
	private Tarea tarea;
	private EmpleadoMantenimientoPlanificado empleadoMantenimientoPlanificado;
	private char estatus;

	public TareaMantenimientoPlanificado() {
	}

	public TareaMantenimientoPlanificado(TareaMantenimientoPlanificadoId id,
			PlanificacionMantenimiento planificacionMantenimiento, Tarea tarea,
			EmpleadoMantenimientoPlanificado empleadoMantenimientoPlanificado,
			char estatus) {
		this.id = id;
		this.planificacionMantenimiento = planificacionMantenimiento;
		this.tarea = tarea;
		this.empleadoMantenimientoPlanificado = empleadoMantenimientoPlanificado;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoTarea", column = @Column(name = "codigo_tarea", nullable = false)),
			@AttributeOverride(name = "codigoPlanificacionMantenimiento", column = @Column(name = "codigo_planificacion_mantenimiento", nullable = false)) })
	public TareaMantenimientoPlanificadoId getId() {
		return this.id;
	}

	public void setId(TareaMantenimientoPlanificadoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_planificacion_mantenimiento", nullable = false, insertable = false, updatable = false)
	public PlanificacionMantenimiento getPlanificacionMantenimiento() {
		return this.planificacionMantenimiento;
	}

	public void setPlanificacionMantenimiento(
			PlanificacionMantenimiento planificacionMantenimiento) {
		this.planificacionMantenimiento = planificacionMantenimiento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tarea", nullable = false, insertable = false, updatable = false)
	public Tarea getTarea() {
		return this.tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "codigo_planificacion_mantenimiento", referencedColumnName = "codigo_planificacion_mantenimiento", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "cedula", referencedColumnName = "cedula", nullable = false, insertable = false, updatable = false) })
	public EmpleadoMantenimientoPlanificado getEmpleadoMantenimientoPlanificado() {
		return this.empleadoMantenimientoPlanificado;
	}

	public void setEmpleadoMantenimientoPlanificado(
			EmpleadoMantenimientoPlanificado empleadoMantenimientoPlanificado) {
		this.empleadoMantenimientoPlanificado = empleadoMantenimientoPlanificado;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
