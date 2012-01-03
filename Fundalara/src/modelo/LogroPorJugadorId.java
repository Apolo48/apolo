package modelo;

// Generated 02-ene-2012 20:17:38 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LogroPorJugadorId generated by hbm2java
 */
@Embeddable
public class LogroPorJugadorId implements java.io.Serializable {

	private int codigoCompetencia;
	private String cedulaRif;
	private int codigoLogro;

	public LogroPorJugadorId() {
	}

	public LogroPorJugadorId(int codigoCompetencia, String cedulaRif,
			int codigoLogro) {
		this.codigoCompetencia = codigoCompetencia;
		this.cedulaRif = cedulaRif;
		this.codigoLogro = codigoLogro;
	}

	@Column(name = "codigo_competencia", nullable = false)
	public int getCodigoCompetencia() {
		return this.codigoCompetencia;
	}

	public void setCodigoCompetencia(int codigoCompetencia) {
		this.codigoCompetencia = codigoCompetencia;
	}

	@Column(name = "cedula_rif", nullable = false)
	public String getCedulaRif() {
		return this.cedulaRif;
	}

	public void setCedulaRif(String cedulaRif) {
		this.cedulaRif = cedulaRif;
	}

	@Column(name = "codigo_logro", nullable = false)
	public int getCodigoLogro() {
		return this.codigoLogro;
	}

	public void setCodigoLogro(int codigoLogro) {
		this.codigoLogro = codigoLogro;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LogroPorJugadorId))
			return false;
		LogroPorJugadorId castOther = (LogroPorJugadorId) other;

		return (this.getCodigoCompetencia() == castOther.getCodigoCompetencia())
				&& ((this.getCedulaRif() == castOther.getCedulaRif()) || (this
						.getCedulaRif() != null
						&& castOther.getCedulaRif() != null && this
						.getCedulaRif().equals(castOther.getCedulaRif())))
				&& (this.getCodigoLogro() == castOther.getCodigoLogro());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoCompetencia();
		result = 37 * result
				+ (getCedulaRif() == null ? 0 : this.getCedulaRif().hashCode());
		result = 37 * result + this.getCodigoLogro();
		return result;
	}

}
