package modelo;

// Generated 17/12/2011 10:20:04 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DatoDeportivoId generated by hbm2java
 */
@Embeddable
public class DatoDeportivoId implements java.io.Serializable {

	private String codigoCompetencia;
	private String cedulaRif;

	public DatoDeportivoId() {
	}

	public DatoDeportivoId(String codigoCompetencia, String cedulaRif) {
		this.codigoCompetencia = codigoCompetencia;
		this.cedulaRif = cedulaRif;
	}

	@Column(name = "codigo_competencia", nullable = false)
	public String getCodigoCompetencia() {
		return this.codigoCompetencia;
	}

	public void setCodigoCompetencia(String codigoCompetencia) {
		this.codigoCompetencia = codigoCompetencia;
	}

	@Column(name = "cedula_rif", nullable = false)
	public String getCedulaRif() {
		return this.cedulaRif;
	}

	public void setCedulaRif(String cedulaRif) {
		this.cedulaRif = cedulaRif;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DatoDeportivoId))
			return false;
		DatoDeportivoId castOther = (DatoDeportivoId) other;

		return ((this.getCodigoCompetencia() == castOther
				.getCodigoCompetencia()) || (this.getCodigoCompetencia() != null
				&& castOther.getCodigoCompetencia() != null && this
				.getCodigoCompetencia()
				.equals(castOther.getCodigoCompetencia())))
				&& ((this.getCedulaRif() == castOther.getCedulaRif()) || (this
						.getCedulaRif() != null
						&& castOther.getCedulaRif() != null && this
						.getCedulaRif().equals(castOther.getCedulaRif())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoCompetencia() == null ? 0 : this
						.getCodigoCompetencia().hashCode());
		result = 37 * result
				+ (getCedulaRif() == null ? 0 : this.getCedulaRif().hashCode());
		return result;
	}

}
