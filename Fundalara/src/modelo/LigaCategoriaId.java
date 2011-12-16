package modelo;

// Generated 13-dic-2011 23:21:03 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LigaCategoriaId generated by hbm2java
 */
@Embeddable
public class LigaCategoriaId implements java.io.Serializable {

	private String codigoLiga;
	private String codigoCategoria;

	public LigaCategoriaId() {
	}

	public LigaCategoriaId(String codigoLiga, String codigoCategoria) {
		this.codigoLiga = codigoLiga;
		this.codigoCategoria = codigoCategoria;
	}

	@Column(name = "codigo_liga", nullable = false)
	public String getCodigoLiga() {
		return this.codigoLiga;
	}

	public void setCodigoLiga(String codigoLiga) {
		this.codigoLiga = codigoLiga;
	}

	@Column(name = "codigo_categoria", nullable = false)
	public String getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LigaCategoriaId))
			return false;
		LigaCategoriaId castOther = (LigaCategoriaId) other;

		return ((this.getCodigoLiga() == castOther.getCodigoLiga()) || (this
				.getCodigoLiga() != null && castOther.getCodigoLiga() != null && this
				.getCodigoLiga().equals(castOther.getCodigoLiga())))
				&& ((this.getCodigoCategoria() == castOther
						.getCodigoCategoria()) || (this.getCodigoCategoria() != null
						&& castOther.getCodigoCategoria() != null && this
						.getCodigoCategoria().equals(
								castOther.getCodigoCategoria())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoLiga() == null ? 0 : this.getCodigoLiga()
						.hashCode());
		result = 37
				* result
				+ (getCodigoCategoria() == null ? 0 : this.getCodigoCategoria()
						.hashCode());
		return result;
	}

}