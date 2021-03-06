package modelo;

// Generated 13/02/2012 02:19:00 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TareaActividadPlanificada generated by hbm2java
 */
@Entity
@Table(name = "tarea_actividad_planificada", schema = "public")
public class TareaActividadPlanificada implements java.io.Serializable {

	private int codigoTareaActividadPlanificada;
	private DatoBasico datoBasico;
	private ComisionFamiliar comisionFamiliar;
	private PlanificacionActividad planificacionActividad;
	private PersonalActividadPlanificada personalActividadPlanificada;
	private char estatus;

	public TareaActividadPlanificada() {
	}

	public TareaActividadPlanificada(int codigoTareaActividadPlanificada,
			DatoBasico datoBasico,
			PlanificacionActividad planificacionActividad, char estatus) {
		this.codigoTareaActividadPlanificada = codigoTareaActividadPlanificada;
		this.datoBasico = datoBasico;
		this.planificacionActividad = planificacionActividad;
		this.estatus = estatus;
	}

	public TareaActividadPlanificada(int codigoTareaActividadPlanificada,
			DatoBasico datoBasico, ComisionFamiliar comisionFamiliar,
			PlanificacionActividad planificacionActividad,
			PersonalActividadPlanificada personalActividadPlanificada,
			char estatus) {
		this.codigoTareaActividadPlanificada = codigoTareaActividadPlanificada;
		this.datoBasico = datoBasico;
		this.comisionFamiliar = comisionFamiliar;
		this.planificacionActividad = planificacionActividad;
		this.personalActividadPlanificada = personalActividadPlanificada;
		this.estatus = estatus;
	}

	@Id
	@Column(name = "codigo_tarea_actividad_planificada", unique = true, nullable = false)
	public int getCodigoTareaActividadPlanificada() {
		return this.codigoTareaActividadPlanificada;
	}

	public void setCodigoTareaActividadPlanificada(
			int codigoTareaActividadPlanificada) {
		this.codigoTareaActividadPlanificada = codigoTareaActividadPlanificada;
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
	@JoinColumn(name = "codigo_comision_familiar")
	public ComisionFamiliar getComisionFamiliar() {
		return this.comisionFamiliar;
	}

	public void setComisionFamiliar(ComisionFamiliar comisionFamiliar) {
		this.comisionFamiliar = comisionFamiliar;
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
	@JoinColumn(name = "codigo_personal_actividad_plan")
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
