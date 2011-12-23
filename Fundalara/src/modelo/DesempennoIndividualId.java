package modelo;

// Generated 22-dic-2011 17:58:31 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DesempennoIndividualId generated by hbm2java
 */
@Embeddable
public class DesempennoIndividualId implements java.io.Serializable {

	private int codigoIndicadorCompetencia;
	private int codigoLineUp;

	public DesempennoIndividualId() {
	}

	public DesempennoIndividualId(int codigoIndicadorCompetencia,
			int codigoLineUp) {
		this.codigoIndicadorCompetencia = codigoIndicadorCompetencia;
		this.codigoLineUp = codigoLineUp;
	}

	@Column(name = "codigo_indicador_competencia", nullable = false)
	public int getCodigoIndicadorCompetencia() {
		return this.codigoIndicadorCompetencia;
	}

	public void setCodigoIndicadorCompetencia(int codigoIndicadorCompetencia) {
		this.codigoIndicadorCompetencia = codigoIndicadorCompetencia;
	}

	@Column(name = "codigo_line_up", nullable = false)
	public int getCodigoLineUp() {
		return this.codigoLineUp;
	}

	public void setCodigoLineUp(int codigoLineUp) {
		this.codigoLineUp = codigoLineUp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DesempennoIndividualId))
			return false;
		DesempennoIndividualId castOther = (DesempennoIndividualId) other;

		return (this.getCodigoIndicadorCompetencia() == castOther
				.getCodigoIndicadorCompetencia())
				&& (this.getCodigoLineUp() == castOther.getCodigoLineUp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoIndicadorCompetencia();
		result = 37 * result + this.getCodigoLineUp();
		return result;
	}

}
