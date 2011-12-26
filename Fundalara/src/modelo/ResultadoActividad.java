package modelo;

// Generated 26-dic-2011 15:15:53 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ResultadoActividad generated by hbm2java
 */
@Entity
@Table(name = "resultado_actividad", schema = "public")
public class ResultadoActividad implements java.io.Serializable {

	private ResultadoActividadId id;
	private DatoBasico datoBasico;
	private Actividad actividad;
	private String observaciones;
	private char estatus;

	public ResultadoActividad() {
	}

	public ResultadoActividad(ResultadoActividadId id, DatoBasico datoBasico,
			Actividad actividad, char estatus) {
		this.id = id;
		this.datoBasico = datoBasico;
		this.actividad = actividad;
		this.estatus = estatus;
	}

	public ResultadoActividad(ResultadoActividadId id, DatoBasico datoBasico,
			Actividad actividad, String observaciones, char estatus) {
		this.id = id;
		this.datoBasico = datoBasico;
		this.actividad = actividad;
		this.observaciones = observaciones;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoResultado", column = @Column(name = "codigo_resultado", nullable = false)),
			@AttributeOverride(name = "codigoActividad", column = @Column(name = "codigo_actividad", nullable = false)) })
	public ResultadoActividadId getId() {
		return this.id;
	}

	public void setId(ResultadoActividadId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_resultado", nullable = false, insertable = false, updatable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_actividad", nullable = false, insertable = false, updatable = false)
	public Actividad getActividad() {
		return this.actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	@Column(name = "observaciones")
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
