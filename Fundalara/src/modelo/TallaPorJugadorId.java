package modelo;

// Generated 13-ene-2012 22:07:27 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TallaPorJugadorId generated by hbm2java
 */
@Embeddable
public class TallaPorJugadorId implements java.io.Serializable {

	private int codigoTallaIndumentaria;
	private String cedulaRif;

	public TallaPorJugadorId() {
	}

	public TallaPorJugadorId(int codigoTallaIndumentaria, String cedulaRif) {
		this.codigoTallaIndumentaria = codigoTallaIndumentaria;
		this.cedulaRif = cedulaRif;
	}

	@Column(name = "codigo_talla_indumentaria", nullable = false)
	public int getCodigoTallaIndumentaria() {
		return this.codigoTallaIndumentaria;
	}

	public void setCodigoTallaIndumentaria(int codigoTallaIndumentaria) {
		this.codigoTallaIndumentaria = codigoTallaIndumentaria;
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
		if (!(other instanceof TallaPorJugadorId))
			return false;
		TallaPorJugadorId castOther = (TallaPorJugadorId) other;

		return (this.getCodigoTallaIndumentaria() == castOther
				.getCodigoTallaIndumentaria())
				&& ((this.getCedulaRif() == castOther.getCedulaRif()) || (this
						.getCedulaRif() != null
						&& castOther.getCedulaRif() != null && this
						.getCedulaRif().equals(castOther.getCedulaRif())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoTallaIndumentaria();
		result = 37 * result
				+ (getCedulaRif() == null ? 0 : this.getCedulaRif().hashCode());
		return result;
	}

}
