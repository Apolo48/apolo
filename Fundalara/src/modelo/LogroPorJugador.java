package modelo;

// Generated 02-ene-2012 20:17:38 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LogroPorJugador generated by hbm2java
 */
@Entity
@Table(name = "logro_por_jugador", schema = "public")
public class LogroPorJugador implements java.io.Serializable {

	private LogroPorJugadorId id;
	private DatoDeportivo datoDeportivo;
	private DatoBasico datoBasico;
	private String observacion;
	private char estatus;

	public LogroPorJugador() {
	}

	public LogroPorJugador(LogroPorJugadorId id, DatoDeportivo datoDeportivo,
			DatoBasico datoBasico, char estatus) {
		this.id = id;
		this.datoDeportivo = datoDeportivo;
		this.datoBasico = datoBasico;
		this.estatus = estatus;
	}

	public LogroPorJugador(LogroPorJugadorId id, DatoDeportivo datoDeportivo,
			DatoBasico datoBasico, String observacion, char estatus) {
		this.id = id;
		this.datoDeportivo = datoDeportivo;
		this.datoBasico = datoBasico;
		this.observacion = observacion;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoCompetencia", column = @Column(name = "codigo_competencia", nullable = false)),
			@AttributeOverride(name = "cedulaRif", column = @Column(name = "cedula_rif", nullable = false)),
			@AttributeOverride(name = "codigoLogro", column = @Column(name = "codigo_logro", nullable = false)) })
	public LogroPorJugadorId getId() {
		return this.id;
	}

	public void setId(LogroPorJugadorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "codigo_competencia", referencedColumnName = "codigo_competencia", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "cedula_rif", referencedColumnName = "cedula_rif", nullable = false, insertable = false, updatable = false) })
	public DatoDeportivo getDatoDeportivo() {
		return this.datoDeportivo;
	}

	public void setDatoDeportivo(DatoDeportivo datoDeportivo) {
		this.datoDeportivo = datoDeportivo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_logro", nullable = false, insertable = false, updatable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "observacion")
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
