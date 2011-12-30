package modelo;

// Generated 30-dic-2011 0:38:42 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TareaActividadPlanificada generated by hbm2java
 */
@Entity
@Table(name = "tarea_actividad_planificada", schema = "public")
public class TareaActividadPlanificada implements java.io.Serializable {

	private int codigoPersonalActividadPlanificada;
	private DatoBasico datoBasico;
	private PlanificacionActividad planificacionActividad;
	private PersonalActividadPlanificada personalActividadPlanificada;
	private char estatus;

	public TareaActividadPlanificada() {
	}

	public TareaActividadPlanificada(int codigoPersonalActividadPlanificada,
			DatoBasico datoBasico,
			PlanificacionActividad planificacionActividad,
			PersonalActividadPlanificada personalActividadPlanificada,
			char estatus) {
		this.codigoPersonalActividadPlanificada = codigoPersonalActividadPlanificada;
		this.datoBasico = datoBasico;
		this.planificacionActividad = planificacionActividad;
		this.personalActividadPlanificada = personalActividadPlanificada;
		this.estatus = estatus;
	}

	@Id
	@Column(name = "codigo_personal_actividad_planificada", unique = true, nullable = false)
	public int getCodigoPersonalActividadPlanificada() {
		return this.codigoPersonalActividadPlanificada;
	}

	public void setCodigoPersonalActividadPlanificada(
			int codigoPersonalActividadPlanificada) {
		this.codigoPersonalActividadPlanificada = codigoPersonalActividadPlanificada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tarea", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_planificacion_actividad", nullable = false)
	public PlanificacionActividad getPlanificacionActividad() {
		return this.planificacionActividad;
	}

	public void setPlanificacionActividad(
			PlanificacionActividad planificacionActividad) {
		this.planificacionActividad = planificacionActividad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "cedula_rif", referencedColumnName = "cedula_rif", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "codigo_planificacion_actividad", referencedColumnName = "codigo_planificacion_actividad", nullable = false, insertable = false, updatable = false) })
	public PersonalActividadPlanificada getPersonalActividadPlanificada() {
		return this.personalActividadPlanificada;
	}

	public void setPersonalActividadPlanificada(
			PersonalActividadPlanificada personalActividadPlanificada) {
		this.personalActividadPlanificada = personalActividadPlanificada;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
