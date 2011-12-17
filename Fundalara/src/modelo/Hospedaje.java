package modelo;

// Generated 17/12/2011 10:20:04 AM by Hibernate Tools 3.4.0.CR1

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
 * Hospedaje generated by hbm2java
 */
@Entity
@Table(name = "hospedaje")
public class Hospedaje implements java.io.Serializable {

	private HospedajeId id;
	private Competencia competencia;
	private FamiliarJugador familiarJugador;
	private char estatus;

	public Hospedaje() {
	}

	public Hospedaje(HospedajeId id, Competencia competencia,
			FamiliarJugador familiarJugador, char estatus) {
		this.id = id;
		this.competencia = competencia;
		this.familiarJugador = familiarJugador;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoHospedaje", column = @Column(name = "codigo_hospedaje", nullable = false)),
			@AttributeOverride(name = "cedulaRif", column = @Column(name = "cedula_rif", nullable = false)),
			@AttributeOverride(name = "cedulaFamiliar", column = @Column(name = "cedula_familiar", nullable = false)) })
	public HospedajeId getId() {
		return this.id;
	}

	public void setId(HospedajeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_competencia", nullable = false)
	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "cedula_rif", referencedColumnName = "cedula_rif", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "cedula_familiar", referencedColumnName = "cedula_familiar", nullable = false, insertable = false, updatable = false) })
	public FamiliarJugador getFamiliarJugador() {
		return this.familiarJugador;
	}

	public void setFamiliarJugador(FamiliarJugador familiarJugador) {
		this.familiarJugador = familiarJugador;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
