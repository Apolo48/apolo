package modelo;

// Generated 11-ene-2012 21:47:34 by Hibernate Tools 3.4.0.CR1

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
 * Sesion generated by hbm2java
 */
@Entity
@Table(name = "sesion", schema = "public")
public class Sesion implements java.io.Serializable {

	private int codigoSesion;
	private PlanEntrenamiento planEntrenamiento;
	private DatoBasico datoBasico;
	private Equipo equipo;
	private char estatus;
	private Set<SesionEjecutada> sesionEjecutadas = new HashSet<SesionEjecutada>(
			0);
	private Set<ActividadPlanificada> actividadPlanificadas = new HashSet<ActividadPlanificada>(
			0);
	private Set<MaterialActividadPlanificada> materialActividadPlanificadas = new HashSet<MaterialActividadPlanificada>(
			0);
	private Set<PlanRotacion> planRotacions = new HashSet<PlanRotacion>(0);
	private Set<ActividadCalendario> actividadCalendarios = new HashSet<ActividadCalendario>(
			0);

	public Sesion() {
	}

	public Sesion(int codigoSesion, PlanEntrenamiento planEntrenamiento,
			DatoBasico datoBasico, Equipo equipo, char estatus) {
		this.codigoSesion = codigoSesion;
		this.planEntrenamiento = planEntrenamiento;
		this.datoBasico = datoBasico;
		this.equipo = equipo;
		this.estatus = estatus;
	}

	public Sesion(int codigoSesion, PlanEntrenamiento planEntrenamiento,
			DatoBasico datoBasico, Equipo equipo, char estatus,
			Set<SesionEjecutada> sesionEjecutadas,
			Set<ActividadPlanificada> actividadPlanificadas,
			Set<MaterialActividadPlanificada> materialActividadPlanificadas,
			Set<PlanRotacion> planRotacions,
			Set<ActividadCalendario> actividadCalendarios) {
		this.codigoSesion = codigoSesion;
		this.planEntrenamiento = planEntrenamiento;
		this.datoBasico = datoBasico;
		this.equipo = equipo;
		this.estatus = estatus;
		this.sesionEjecutadas = sesionEjecutadas;
		this.actividadPlanificadas = actividadPlanificadas;
		this.materialActividadPlanificadas = materialActividadPlanificadas;
		this.planRotacions = planRotacions;
		this.actividadCalendarios = actividadCalendarios;
	}

	@Id
	@Column(name = "codigo_sesion", unique = true, nullable = false)
	public int getCodigoSesion() {
		return this.codigoSesion;
	}

	public void setCodigoSesion(int codigoSesion) {
		this.codigoSesion = codigoSesion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_plan_entrenamiento", nullable = false)
	public PlanEntrenamiento getPlanEntrenamiento() {
		return this.planEntrenamiento;
	}

	public void setPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) {
		this.planEntrenamiento = planEntrenamiento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dia_semana", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_equipo", nullable = false)
	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sesion")
	public Set<SesionEjecutada> getSesionEjecutadas() {
		return this.sesionEjecutadas;
	}

	public void setSesionEjecutadas(Set<SesionEjecutada> sesionEjecutadas) {
		this.sesionEjecutadas = sesionEjecutadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sesion")
	public Set<ActividadPlanificada> getActividadPlanificadas() {
		return this.actividadPlanificadas;
	}

	public void setActividadPlanificadas(
			Set<ActividadPlanificada> actividadPlanificadas) {
		this.actividadPlanificadas = actividadPlanificadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sesion")
	public Set<MaterialActividadPlanificada> getMaterialActividadPlanificadas() {
		return this.materialActividadPlanificadas;
	}

	public void setMaterialActividadPlanificadas(
			Set<MaterialActividadPlanificada> materialActividadPlanificadas) {
		this.materialActividadPlanificadas = materialActividadPlanificadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sesion")
	public Set<PlanRotacion> getPlanRotacions() {
		return this.planRotacions;
	}

	public void setPlanRotacions(Set<PlanRotacion> planRotacions) {
		this.planRotacions = planRotacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sesion")
	public Set<ActividadCalendario> getActividadCalendarios() {
		return this.actividadCalendarios;
	}

	public void setActividadCalendarios(
			Set<ActividadCalendario> actividadCalendarios) {
		this.actividadCalendarios = actividadCalendarios;
	}

}
