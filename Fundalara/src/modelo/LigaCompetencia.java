package modelo;

// Generated 13/02/2012 02:19:00 PM by Hibernate Tools 3.4.0.CR1

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
 * LigaCompetencia generated by hbm2java
 */
@Entity
@Table(name = "liga_competencia", schema = "public")
public class LigaCompetencia implements java.io.Serializable {

	private LigaCompetenciaId id;
	private Liga liga;
	private Competencia competencia;
	private char estatus;

	public LigaCompetencia() {
	}

	public LigaCompetencia(LigaCompetenciaId id, Liga liga,
			Competencia competencia, char estatus) {
		this.id = id;
		this.liga = liga;
		this.competencia = competencia;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoLiga", column = @Column(name = "codigo_liga", nullable = false)),
			@AttributeOverride(name = "codigoCompetencia", column = @Column(name = "codigo_competencia", nullable = false)) })
	public LigaCompetenciaId getId() {
		return this.id;
	}

	public void setId(LigaCompetenciaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_liga", nullable = false, insertable = false, updatable = false)
	public Liga getLiga() {
		return this.liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_competencia", nullable = false, insertable = false, updatable = false)
	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
