package modelo;

// Generated 04-feb-2012 16:31:02 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PersonalActividadPlanificada generated by hbm2java
 */
@Entity
@Table(name = "personal_actividad_planificada", schema = "public")
public class PersonalActividadPlanificada implements java.io.Serializable {

	private int codigoPersonalActividadPlan;
	private PlanificacionActividad planificacionActividad;
	private Personal personal;
	private char estatus;
	private Set<TareaActividadPlanificada> tareaActividadPlanificadas = new HashSet<TareaActividadPlanificada>(
			0);

	public PersonalActividadPlanificada() {
	}

	public PersonalActividadPlanificada(int codigoPersonalActividadPlan,
			PlanificacionActividad planificacionActividad, Personal personal,
			char estatus) {
		this.codigoPersonalActividadPlan = codigoPersonalActividadPlan;
		this.planificacionActividad = planificacionActividad;
		this.personal = personal;
		this.estatus = estatus;
	}

	public PersonalActividadPlanificada(int codigoPersonalActividadPlan,
			PlanificacionActividad planificacionActividad, Personal personal,
			char estatus,
			Set<TareaActividadPlanificada> tareaActividadPlanificadas) {
		this.codigoPersonalActividadPlan = codigoPersonalActividadPlan;
		this.planificacionActividad = planificacionActividad;
		this.personal = personal;
		this.estatus = estatus;
		this.tareaActividadPlanificadas = tareaActividadPlanificadas;
	}

	@Id
	@Column(name = "codigo_personal_actividad_plan", unique = true, nullable = false)
	public int getCodigoPersonalActividadPlan() {
		return this.codigoPersonalActividadPlan;
	}

	public void setCodigoPersonalActividadPlan(int codigoPersonalActividadPlan) {
		this.codigoPersonalActividadPlan = codigoPersonalActividadPlan;
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
	@JoinColumn(name = "cedula_rif", nullable = false)
	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personalActividadPlanificada")
	public Set<TareaActividadPlanificada> getTareaActividadPlanificadas() {
		return this.tareaActividadPlanificadas;
	}

	public void setTareaActividadPlanificadas(
			Set<TareaActividadPlanificada> tareaActividadPlanificadas) {
		this.tareaActividadPlanificadas = tareaActividadPlanificadas;
	}

}
