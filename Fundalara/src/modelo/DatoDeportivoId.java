package modelo;

// Generated 05-dic-2011 23:09:14 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DatoDeportivoId generated by hbm2java
 */
@Embeddable
public class DatoDeportivoId implements java.io.Serializable {

	private String cedulaJugador;
	private String codigoCompetencia;
	private String codigoLogro;

	public DatoDeportivoId() {
	}

	public DatoDeportivoId(String cedulaJugador, String codigoCompetencia,
			String codigoLogro) {
		this.cedulaJugador = cedulaJugador;
		this.codigoCompetencia = codigoCompetencia;
		this.codigoLogro = codigoLogro;
	}

	@Column(name = "cedula_jugador", nullable = false)
	public String getCedulaJugador() {
		return this.cedulaJugador;
	}

	public void setCedulaJugador(String cedulaJugador) {
		this.cedulaJugador = cedulaJugador;
	}

	@Column(name = "codigo_competencia", nullable = false)
	public String getCodigoCompetencia() {
		return this.codigoCompetencia;
	}

	public void setCodigoCompetencia(String codigoCompetencia) {
		this.codigoCompetencia = codigoCompetencia;
	}

	@Column(name = "codigo_logro", nullable = false)
	public String getCodigoLogro() {
		return this.codigoLogro;
	}

	public void setCodigoLogro(String codigoLogro) {
		this.codigoLogro = codigoLogro;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DatoDeportivoId))
			return false;
		DatoDeportivoId castOther = (DatoDeportivoId) other;

		return ((this.getCedulaJugador() == castOther.getCedulaJugador()) || (this
				.getCedulaJugador() != null
				&& castOther.getCedulaJugador() != null && this
				.getCedulaJugador().equals(castOther.getCedulaJugador())))
				&& ((this.getCodigoCompetencia() == castOther
						.getCodigoCompetencia()) || (this
						.getCodigoCompetencia() != null
						&& castOther.getCodigoCompetencia() != null && this
						.getCodigoCompetencia().equals(
								castOther.getCodigoCompetencia())))
				&& ((this.getCodigoLogro() == castOther.getCodigoLogro()) || (this
						.getCodigoLogro() != null
						&& castOther.getCodigoLogro() != null && this
						.getCodigoLogro().equals(castOther.getCodigoLogro())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCedulaJugador() == null ? 0 : this.getCedulaJugador()
						.hashCode());
		result = 37
				* result
				+ (getCodigoCompetencia() == null ? 0 : this
						.getCodigoCompetencia().hashCode());
		result = 37
				* result
				+ (getCodigoLogro() == null ? 0 : this.getCodigoLogro()
						.hashCode());
		return result;
	}

}
