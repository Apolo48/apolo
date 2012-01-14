package modelo;

// Generated 13-ene-2012 22:07:27 by Hibernate Tools 3.4.0.CR1

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
 * ActividadPlanificada generated by hbm2java
 */
@Entity
@Table(name = "actividad_planificada", schema = "public")
public class ActividadPlanificada implements java.io.Serializable {

	private ActividadPlanificadaId id;
	private Sesion sesion;
	private IndicadorActividadEscala indicadorActividadEscala;
	private int tiempo;
	private char estatus;

	public ActividadPlanificada() {
	}

	public ActividadPlanificada(ActividadPlanificadaId id, Sesion sesion,
			IndicadorActividadEscala indicadorActividadEscala, int tiempo,
			char estatus) {
		this.id = id;
		this.sesion = sesion;
		this.indicadorActividadEscala = indicadorActividadEscala;
		this.tiempo = tiempo;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoIndicadorActividadEscala", column = @Column(name = "codigo_indicador_actividad_escala", nullable = false)),
			@AttributeOverride(name = "codigoSesion", column = @Column(name = "codigo_sesion", nullable = false)) })
	public ActividadPlanificadaId getId() {
		return this.id;
	}

	public void setId(ActividadPlanificadaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_sesion", nullable = false, insertable = false, updatable = false)
	public Sesion getSesion() {
		return this.sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_indicador_actividad_escala", nullable = false, insertable = false, updatable = false)
	public IndicadorActividadEscala getIndicadorActividadEscala() {
		return this.indicadorActividadEscala;
	}

	public void setIndicadorActividadEscala(
			IndicadorActividadEscala indicadorActividadEscala) {
		this.indicadorActividadEscala = indicadorActividadEscala;
	}

	@Column(name = "tiempo", nullable = false)
	public int getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
