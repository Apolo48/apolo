package modelo;

// Generated 26-dic-2011 21:37:05 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Actividad generated by hbm2java
 */
@Entity
@Table(name = "actividad", schema = "public")
public class Actividad implements java.io.Serializable {

	private int codigoActividad;
	private PlanificacionActividad planificacionActividad;
	private Date fechaInicio;
	private Date fechaCulminacion;
	private char estatus;
	private Date horaInicio;
	private Date horaFin;
	private Set<SolicitudMantenimiento> solicitudMantenimientos = new HashSet<SolicitudMantenimiento>(
			0);
	private Set<MaterialActividad> materialActividads = new HashSet<MaterialActividad>(
			0);
	private Set<PersonalActividad> personalActividads = new HashSet<PersonalActividad>(
			0);
	private Set<ResultadoActividad> resultadoActividads = new HashSet<ResultadoActividad>(
			0);
	private Set<EstadoActividad> estadoActividads = new HashSet<EstadoActividad>(
			0);
	private Set<TareaActividad> tareaActividads = new HashSet<TareaActividad>(0);
	private Set<ActividadCalendario> actividadCalendarios = new HashSet<ActividadCalendario>(
			0);
	private Set<DatoBasico> datoBasicos = new HashSet<DatoBasico>(0);

	public Actividad() {
	}

	public Actividad(int codigoActividad,
			PlanificacionActividad planificacionActividad, Date fechaInicio,
			Date fechaCulminacion, char estatus, Date horaInicio, Date horaFin) {
		this.codigoActividad = codigoActividad;
		this.planificacionActividad = planificacionActividad;
		this.fechaInicio = fechaInicio;
		this.fechaCulminacion = fechaCulminacion;
		this.estatus = estatus;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public Actividad(int codigoActividad,
			PlanificacionActividad planificacionActividad, Date fechaInicio,
			Date fechaCulminacion, char estatus, Date horaInicio, Date horaFin,
			Set<SolicitudMantenimiento> solicitudMantenimientos,
			Set<MaterialActividad> materialActividads,
			Set<PersonalActividad> personalActividads,
			Set<ResultadoActividad> resultadoActividads,
			Set<EstadoActividad> estadoActividads,
			Set<TareaActividad> tareaActividads,
			Set<ActividadCalendario> actividadCalendarios,
			Set<DatoBasico> datoBasicos) {
		this.codigoActividad = codigoActividad;
		this.planificacionActividad = planificacionActividad;
		this.fechaInicio = fechaInicio;
		this.fechaCulminacion = fechaCulminacion;
		this.estatus = estatus;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.solicitudMantenimientos = solicitudMantenimientos;
		this.materialActividads = materialActividads;
		this.personalActividads = personalActividads;
		this.resultadoActividads = resultadoActividads;
		this.estadoActividads = estadoActividads;
		this.tareaActividads = tareaActividads;
		this.actividadCalendarios = actividadCalendarios;
		this.datoBasicos = datoBasicos;
	}

	@Id
	@Column(name = "codigo_actividad", unique = true, nullable = false)
	public int getCodigoActividad() {
		return this.codigoActividad;
	}

	public void setCodigoActividad(int codigoActividad) {
		this.codigoActividad = codigoActividad;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio", nullable = false, length = 13)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_culminacion", nullable = false, length = 13)
	public Date getFechaCulminacion() {
		return this.fechaCulminacion;
	}

	public void setFechaCulminacion(Date fechaCulminacion) {
		this.fechaCulminacion = fechaCulminacion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_inicio", nullable = false, length = 15)
	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_fin", nullable = false, length = 15)
	public Date getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividad")
	public Set<SolicitudMantenimiento> getSolicitudMantenimientos() {
		return this.solicitudMantenimientos;
	}

	public void setSolicitudMantenimientos(
			Set<SolicitudMantenimiento> solicitudMantenimientos) {
		this.solicitudMantenimientos = solicitudMantenimientos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividad")
	public Set<MaterialActividad> getMaterialActividads() {
		return this.materialActividads;
	}

	public void setMaterialActividads(Set<MaterialActividad> materialActividads) {
		this.materialActividads = materialActividads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividad")
	public Set<PersonalActividad> getPersonalActividads() {
		return this.personalActividads;
	}

	public void setPersonalActividads(Set<PersonalActividad> personalActividads) {
		this.personalActividads = personalActividads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividad")
	public Set<ResultadoActividad> getResultadoActividads() {
		return this.resultadoActividads;
	}

	public void setResultadoActividads(
			Set<ResultadoActividad> resultadoActividads) {
		this.resultadoActividads = resultadoActividads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividad")
	public Set<EstadoActividad> getEstadoActividads() {
		return this.estadoActividads;
	}

	public void setEstadoActividads(Set<EstadoActividad> estadoActividads) {
		this.estadoActividads = estadoActividads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividad")
	public Set<TareaActividad> getTareaActividads() {
		return this.tareaActividads;
	}

	public void setTareaActividads(Set<TareaActividad> tareaActividads) {
		this.tareaActividads = tareaActividads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividad")
	public Set<ActividadCalendario> getActividadCalendarios() {
		return this.actividadCalendarios;
	}

	public void setActividadCalendarios(
			Set<ActividadCalendario> actividadCalendarios) {
		this.actividadCalendarios = actividadCalendarios;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "comision_actividad", schema = "public", joinColumns = { @JoinColumn(name = "codigo_actividad", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "codigo_comision", nullable = false, updatable = false) })
	public Set<DatoBasico> getDatoBasicos() {
		return this.datoBasicos;
	}

	public void setDatoBasicos(Set<DatoBasico> datoBasicos) {
		this.datoBasicos = datoBasicos;
	}

}
