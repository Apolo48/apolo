package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

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
 * PlanificacionActividad generated by hbm2java
 */
@Entity
@Table(name = "planificacion_actividad", schema = "public")
public class PlanificacionActividad implements java.io.Serializable {

	private int codigoPlanificacionActividad;
	private DatoBasico datoBasico;
	private InstalacionUtilizada instalacionUtilizada;
	private Personal personal;
	private char estatus;
	private boolean actividadPeriodico;
	private boolean actividadPlantilla;
	private String descripcion;
	private String descripcionInstalacion;
	private Set<MaterialActividadPlanificada> materialActividadPlanificadas = new HashSet<MaterialActividadPlanificada>(
			0);
	private Set<Actividad> actividads = new HashSet<Actividad>(0);
	private Set<PersonalActividadPlanificada> personalActividadPlanificadas = new HashSet<PersonalActividadPlanificada>(
			0);
	private Set<Periodicidad> periodicidads = new HashSet<Periodicidad>(0);
	private Set<ComisionActividadPlanificada> comisionActividadPlanificadas = new HashSet<ComisionActividadPlanificada>(
			0);
	private Set<TareaActividadPlanificada> tareaActividadPlanificadas = new HashSet<TareaActividadPlanificada>(
			0);

	public PlanificacionActividad() {
	}

	public PlanificacionActividad(int codigoPlanificacionActividad,
			DatoBasico datoBasico, char estatus, boolean actividadPeriodico,
			boolean actividadPlantilla, String descripcion) {
		this.codigoPlanificacionActividad = codigoPlanificacionActividad;
		this.datoBasico = datoBasico;
		this.estatus = estatus;
		this.actividadPeriodico = actividadPeriodico;
		this.actividadPlantilla = actividadPlantilla;
		this.descripcion = descripcion;
	}

	public PlanificacionActividad(int codigoPlanificacionActividad,
			DatoBasico datoBasico, InstalacionUtilizada instalacionUtilizada,
			Personal personal, char estatus, boolean actividadPeriodico,
			boolean actividadPlantilla, String descripcion,
			String descripcionInstalacion,
			Set<MaterialActividadPlanificada> materialActividadPlanificadas,
			Set<Actividad> actividads,
			Set<PersonalActividadPlanificada> personalActividadPlanificadas,
			Set<Periodicidad> periodicidads,
			Set<ComisionActividadPlanificada> comisionActividadPlanificadas,
			Set<TareaActividadPlanificada> tareaActividadPlanificadas) {
		this.codigoPlanificacionActividad = codigoPlanificacionActividad;
		this.datoBasico = datoBasico;
		this.instalacionUtilizada = instalacionUtilizada;
		this.personal = personal;
		this.estatus = estatus;
		this.actividadPeriodico = actividadPeriodico;
		this.actividadPlantilla = actividadPlantilla;
		this.descripcion = descripcion;
		this.descripcionInstalacion = descripcionInstalacion;
		this.materialActividadPlanificadas = materialActividadPlanificadas;
		this.actividads = actividads;
		this.personalActividadPlanificadas = personalActividadPlanificadas;
		this.periodicidads = periodicidads;
		this.comisionActividadPlanificadas = comisionActividadPlanificadas;
		this.tareaActividadPlanificadas = tareaActividadPlanificadas;
	}

	@Id
	@Column(name = "codigo_planificacion_actividad", unique = true, nullable = false)
	public int getCodigoPlanificacionActividad() {
		return this.codigoPlanificacionActividad;
	}

	public void setCodigoPlanificacionActividad(int codigoPlanificacionActividad) {
		this.codigoPlanificacionActividad = codigoPlanificacionActividad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_actividad", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_instalacion_utilizada")
	public InstalacionUtilizada getInstalacionUtilizada() {
		return this.instalacionUtilizada;
	}

	public void setInstalacionUtilizada(
			InstalacionUtilizada instalacionUtilizada) {
		this.instalacionUtilizada = instalacionUtilizada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_rif")
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

	@Column(name = "actividad_periodico", nullable = false)
	public boolean isActividadPeriodico() {
		return this.actividadPeriodico;
	}

	public void setActividadPeriodico(boolean actividadPeriodico) {
		this.actividadPeriodico = actividadPeriodico;
	}

	@Column(name = "actividad_plantilla", nullable = false)
	public boolean isActividadPlantilla() {
		return this.actividadPlantilla;
	}

	public void setActividadPlantilla(boolean actividadPlantilla) {
		this.actividadPlantilla = actividadPlantilla;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "descripcion_instalacion")
	public String getDescripcionInstalacion() {
		return this.descripcionInstalacion;
	}

	public void setDescripcionInstalacion(String descripcionInstalacion) {
		this.descripcionInstalacion = descripcionInstalacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planificacionActividad")
	public Set<MaterialActividadPlanificada> getMaterialActividadPlanificadas() {
		return this.materialActividadPlanificadas;
	}

	public void setMaterialActividadPlanificadas(
			Set<MaterialActividadPlanificada> materialActividadPlanificadas) {
		this.materialActividadPlanificadas = materialActividadPlanificadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planificacionActividad")
	public Set<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(Set<Actividad> actividads) {
		this.actividads = actividads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planificacionActividad")
	public Set<PersonalActividadPlanificada> getPersonalActividadPlanificadas() {
		return this.personalActividadPlanificadas;
	}

	public void setPersonalActividadPlanificadas(
			Set<PersonalActividadPlanificada> personalActividadPlanificadas) {
		this.personalActividadPlanificadas = personalActividadPlanificadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planificacionActividad")
	public Set<Periodicidad> getPeriodicidads() {
		return this.periodicidads;
	}

	public void setPeriodicidads(Set<Periodicidad> periodicidads) {
		this.periodicidads = periodicidads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planificacionActividad")
	public Set<ComisionActividadPlanificada> getComisionActividadPlanificadas() {
		return this.comisionActividadPlanificadas;
	}

	public void setComisionActividadPlanificadas(
			Set<ComisionActividadPlanificada> comisionActividadPlanificadas) {
		this.comisionActividadPlanificadas = comisionActividadPlanificadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planificacionActividad")
	public Set<TareaActividadPlanificada> getTareaActividadPlanificadas() {
		return this.tareaActividadPlanificadas;
	}

	public void setTareaActividadPlanificadas(
			Set<TareaActividadPlanificada> tareaActividadPlanificadas) {
		this.tareaActividadPlanificadas = tareaActividadPlanificadas;
	}

}
