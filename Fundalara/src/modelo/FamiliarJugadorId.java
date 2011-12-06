package modelo;

// Generated 05-dic-2011 18:58:46 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FamiliarJugadorId generated by hbm2java
 */
@Embeddable
public class FamiliarJugadorId implements java.io.Serializable {

	private String cedulaJugador;
	private String cedulaFamiliar;

	public FamiliarJugadorId() {
	}

	public FamiliarJugadorId(String cedulaJugador, String cedulaFamiliar) {
		this.cedulaJugador = cedulaJugador;
		this.cedulaFamiliar = cedulaFamiliar;
	}

	@Column(name = "cedula_jugador", nullable = false)
	public String getCedulaJugador() {
		return this.cedulaJugador;
	}

	public void setCedulaJugador(String cedulaJugador) {
		this.cedulaJugador = cedulaJugador;
	}

	@Column(name = "cedula_familiar", nullable = false)
	public String getCedulaFamiliar() {
		return this.cedulaFamiliar;
	}

	public void setCedulaFamiliar(String cedulaFamiliar) {
		this.cedulaFamiliar = cedulaFamiliar;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FamiliarJugadorId))
			return false;
		FamiliarJugadorId castOther = (FamiliarJugadorId) other;

		return ((this.getCedulaJugador() == castOther.getCedulaJugador()) || (this
				.getCedulaJugador() != null
				&& castOther.getCedulaJugador() != null && this
				.getCedulaJugador().equals(castOther.getCedulaJugador())))
				&& ((this.getCedulaFamiliar() == castOther.getCedulaFamiliar()) || (this
						.getCedulaFamiliar() != null
						&& castOther.getCedulaFamiliar() != null && this
						.getCedulaFamiliar().equals(
								castOther.getCedulaFamiliar())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCedulaJugador() == null ? 0 : this.getCedulaJugador()
						.hashCode());
		result = 37
				* result
				+ (getCedulaFamiliar() == null ? 0 : this.getCedulaFamiliar()
						.hashCode());
		return result;
	}

}
