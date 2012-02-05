package modelo;

// Generated 04-feb-2012 16:31:02 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LigaCompetenciaId generated by hbm2java
 */
@Embeddable
public class LigaCompetenciaId implements java.io.Serializable {

	private int codigoLiga;
	private int codigoCompetencia;

	public LigaCompetenciaId() {
	}

	public LigaCompetenciaId(int codigoLiga, int codigoCompetencia) {
		this.codigoLiga = codigoLiga;
		this.codigoCompetencia = codigoCompetencia;
	}

	@Column(name = "codigo_liga", nullable = false)
	public int getCodigoLiga() {
		return this.codigoLiga;
	}

	public void setCodigoLiga(int codigoLiga) {
		this.codigoLiga = codigoLiga;
	}

	@Column(name = "codigo_competencia", nullable = false)
	public int getCodigoCompetencia() {
		return this.codigoCompetencia;
	}

	public void setCodigoCompetencia(int codigoCompetencia) {
		this.codigoCompetencia = codigoCompetencia;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LigaCompetenciaId))
			return false;
		LigaCompetenciaId castOther = (LigaCompetenciaId) other;

		return (this.getCodigoLiga() == castOther.getCodigoLiga())
				&& (this.getCodigoCompetencia() == castOther
						.getCodigoCompetencia());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoLiga();
		result = 37 * result + this.getCodigoCompetencia();
		return result;
	}

}
