package modelo;

// Generated 26-dic-2011 21:37:05 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TallaPorJugadorId generated by hbm2java
 */
@Embeddable
public class TallaPorJugadorId implements java.io.Serializable {

	private String cedulaRif;
	private int codigoTallaIndumentaria;

	public TallaPorJugadorId() {
	}

	public TallaPorJugadorId(String cedulaRif, int codigoTallaIndumentaria) {
		this.cedulaRif = cedulaRif;
		this.codigoTallaIndumentaria = codigoTallaIndumentaria;
	}

	@Column(name = "cedula_rif", nullable = false)
	public String getCedulaRif() {
		return this.cedulaRif;
	}

	public void setCedulaRif(String cedulaRif) {
		this.cedulaRif = cedulaRif;
	}

	@Column(name = "codigo_talla_indumentaria", nullable = false)
	public int getCodigoTallaIndumentaria() {
		return this.codigoTallaIndumentaria;
	}

	public void setCodigoTallaIndumentaria(int codigoTallaIndumentaria) {
		this.codigoTallaIndumentaria = codigoTallaIndumentaria;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TallaPorJugadorId))
			return false;
		TallaPorJugadorId castOther = (TallaPorJugadorId) other;

		return ((this.getCedulaRif() == castOther.getCedulaRif()) || (this
				.getCedulaRif() != null && castOther.getCedulaRif() != null && this
				.getCedulaRif().equals(castOther.getCedulaRif())))
				&& (this.getCodigoTallaIndumentaria() == castOther
						.getCodigoTallaIndumentaria());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCedulaRif() == null ? 0 : this.getCedulaRif().hashCode());
		result = 37 * result + this.getCodigoTallaIndumentaria();
		return result;
	}

}
