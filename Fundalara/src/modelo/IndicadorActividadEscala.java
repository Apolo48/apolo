package modelo;

// Generated 02-ene-2012 20:17:38 by Hibernate Tools 3.4.0.CR1

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
 * IndicadorActividadEscala generated by hbm2java
 */
@Entity
@Table(name = "indicador_actividad_escala", schema = "public")
public class IndicadorActividadEscala implements java.io.Serializable {

	private int codigoIndicadorActividadEscala;
	private EscalaMedicion escalaMedicion;
	private DatoBasico datoBasico;
	private ActividadEntrenamiento actividadEntrenamiento;
	private char estatus;
	private Set<ActividadesEjecutadas> actividadesEjecutadases = new HashSet<ActividadesEjecutadas>(
			0);
	private Set<ActividadPlanificada> actividadPlanificadas = new HashSet<ActividadPlanificada>(
			0);

	public IndicadorActividadEscala() {
	}

	public IndicadorActividadEscala(int codigoIndicadorActividadEscala,
			EscalaMedicion escalaMedicion, DatoBasico datoBasico,
			ActividadEntrenamiento actividadEntrenamiento, char estatus) {
		this.codigoIndicadorActividadEscala = codigoIndicadorActividadEscala;
		this.escalaMedicion = escalaMedicion;
		this.datoBasico = datoBasico;
		this.actividadEntrenamiento = actividadEntrenamiento;
		this.estatus = estatus;
	}

	public IndicadorActividadEscala(int codigoIndicadorActividadEscala,
			EscalaMedicion escalaMedicion, DatoBasico datoBasico,
			ActividadEntrenamiento actividadEntrenamiento, char estatus,
			Set<ActividadesEjecutadas> actividadesEjecutadases,
			Set<ActividadPlanificada> actividadPlanificadas) {
		this.codigoIndicadorActividadEscala = codigoIndicadorActividadEscala;
		this.escalaMedicion = escalaMedicion;
		this.datoBasico = datoBasico;
		this.actividadEntrenamiento = actividadEntrenamiento;
		this.estatus = estatus;
		this.actividadesEjecutadases = actividadesEjecutadases;
		this.actividadPlanificadas = actividadPlanificadas;
	}

	@Id
	@Column(name = "codigo_indicador_actividad_escala", unique = true, nullable = false)
	public int getCodigoIndicadorActividadEscala() {
		return this.codigoIndicadorActividadEscala;
	}

	public void setCodigoIndicadorActividadEscala(
			int codigoIndicadorActividadEscala) {
		this.codigoIndicadorActividadEscala = codigoIndicadorActividadEscala;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_escala", nullable = false)
	public EscalaMedicion getEscalaMedicion() {
		return this.escalaMedicion;
	}

	public void setEscalaMedicion(EscalaMedicion escalaMedicion) {
		this.escalaMedicion = escalaMedicion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indicador", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_actividad_entrenamiento", nullable = false)
	public ActividadEntrenamiento getActividadEntrenamiento() {
		return this.actividadEntrenamiento;
	}

	public void setActividadEntrenamiento(
			ActividadEntrenamiento actividadEntrenamiento) {
		this.actividadEntrenamiento = actividadEntrenamiento;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "indicadorActividadEscala")
	public Set<ActividadesEjecutadas> getActividadesEjecutadases() {
		return this.actividadesEjecutadases;
	}

	public void setActividadesEjecutadases(
			Set<ActividadesEjecutadas> actividadesEjecutadases) {
		this.actividadesEjecutadases = actividadesEjecutadases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "indicadorActividadEscala")
	public Set<ActividadPlanificada> getActividadPlanificadas() {
		return this.actividadPlanificadas;
	}

	public void setActividadPlanificadas(
			Set<ActividadPlanificada> actividadPlanificadas) {
		this.actividadPlanificadas = actividadPlanificadas;
	}

}
