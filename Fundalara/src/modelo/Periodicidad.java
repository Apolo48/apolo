package modelo;

// Generated 05-dic-2011 23:09:14 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Periodicidad generated by hbm2java
 */
@Entity
@Table(name = "periodicidad")
public class Periodicidad implements java.io.Serializable {

	private String codigoPeriodicidad;
	private PlanificacionMantenimiento planificacionMantenimiento;
	private String frecuenciaPeriodicidad;
	private int lapsoRepeticion;
	private String periodicidadSemanal;
	private int diaRepeticion;
	private int mesRepeticion;
	private int numeroRepeticionesPeriodicidad;
	private Date fechaFinalizacionPeriodicidad;
	private String estatus;

	public Periodicidad() {
	}

	public Periodicidad(String codigoPeriodicidad,
			PlanificacionMantenimiento planificacionMantenimiento,
			String frecuenciaPeriodicidad, int lapsoRepeticion,
			String periodicidadSemanal, int diaRepeticion, int mesRepeticion,
			int numeroRepeticionesPeriodicidad,
			Date fechaFinalizacionPeriodicidad, String estatus) {
		this.codigoPeriodicidad = codigoPeriodicidad;
		this.planificacionMantenimiento = planificacionMantenimiento;
		this.frecuenciaPeriodicidad = frecuenciaPeriodicidad;
		this.lapsoRepeticion = lapsoRepeticion;
		this.periodicidadSemanal = periodicidadSemanal;
		this.diaRepeticion = diaRepeticion;
		this.mesRepeticion = mesRepeticion;
		this.numeroRepeticionesPeriodicidad = numeroRepeticionesPeriodicidad;
		this.fechaFinalizacionPeriodicidad = fechaFinalizacionPeriodicidad;
		this.estatus = estatus;
	}

	@Id
	@Column(name = "codigo_periodicidad", unique = true, nullable = false)
	public String getCodigoPeriodicidad() {
		return this.codigoPeriodicidad;
	}

	public void setCodigoPeriodicidad(String codigoPeriodicidad) {
		this.codigoPeriodicidad = codigoPeriodicidad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_planificacion_mantenimiento", nullable = false)
	public PlanificacionMantenimiento getPlanificacionMantenimiento() {
		return this.planificacionMantenimiento;
	}

	public void setPlanificacionMantenimiento(
			PlanificacionMantenimiento planificacionMantenimiento) {
		this.planificacionMantenimiento = planificacionMantenimiento;
	}

	@Column(name = "frecuencia_periodicidad", nullable = false)
	public String getFrecuenciaPeriodicidad() {
		return this.frecuenciaPeriodicidad;
	}

	public void setFrecuenciaPeriodicidad(String frecuenciaPeriodicidad) {
		this.frecuenciaPeriodicidad = frecuenciaPeriodicidad;
	}

	@Column(name = "lapso_repeticion", nullable = false)
	public int getLapsoRepeticion() {
		return this.lapsoRepeticion;
	}

	public void setLapsoRepeticion(int lapsoRepeticion) {
		this.lapsoRepeticion = lapsoRepeticion;
	}

	@Column(name = "periodicidad_semanal", nullable = false)
	public String getPeriodicidadSemanal() {
		return this.periodicidadSemanal;
	}

	public void setPeriodicidadSemanal(String periodicidadSemanal) {
		this.periodicidadSemanal = periodicidadSemanal;
	}

	@Column(name = "dia_repeticion", nullable = false)
	public int getDiaRepeticion() {
		return this.diaRepeticion;
	}

	public void setDiaRepeticion(int diaRepeticion) {
		this.diaRepeticion = diaRepeticion;
	}

	@Column(name = "mes_repeticion", nullable = false)
	public int getMesRepeticion() {
		return this.mesRepeticion;
	}

	public void setMesRepeticion(int mesRepeticion) {
		this.mesRepeticion = mesRepeticion;
	}

	@Column(name = "numero_repeticiones_periodicidad", nullable = false)
	public int getNumeroRepeticionesPeriodicidad() {
		return this.numeroRepeticionesPeriodicidad;
	}

	public void setNumeroRepeticionesPeriodicidad(
			int numeroRepeticionesPeriodicidad) {
		this.numeroRepeticionesPeriodicidad = numeroRepeticionesPeriodicidad;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_finalizacion_periodicidad", nullable = false, length = 13)
	public Date getFechaFinalizacionPeriodicidad() {
		return this.fechaFinalizacionPeriodicidad;
	}

	public void setFechaFinalizacionPeriodicidad(
			Date fechaFinalizacionPeriodicidad) {
		this.fechaFinalizacionPeriodicidad = fechaFinalizacionPeriodicidad;
	}

	@Column(name = "estatus", nullable = false)
	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}
