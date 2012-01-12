package modelo;

// Generated 11-ene-2012 21:47:34 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CategoriaCompetenciaId generated by hbm2java
 */
@Embeddable
public class CategoriaCompetenciaId implements java.io.Serializable {

	private int codigoCompetencia;
	private int codigoCategoria;

	public CategoriaCompetenciaId() {
	}

	public CategoriaCompetenciaId(int codigoCompetencia, int codigoCategoria) {
		this.codigoCompetencia = codigoCompetencia;
		this.codigoCategoria = codigoCategoria;
	}

	@Column(name = "codigo_competencia", nullable = false)
	public int getCodigoCompetencia() {
		return this.codigoCompetencia;
	}

	public void setCodigoCompetencia(int codigoCompetencia) {
		this.codigoCompetencia = codigoCompetencia;
	}

	@Column(name = "codigo_categoria", nullable = false)
	public int getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CategoriaCompetenciaId))
			return false;
		CategoriaCompetenciaId castOther = (CategoriaCompetenciaId) other;

		return (this.getCodigoCompetencia() == castOther.getCodigoCompetencia())
				&& (this.getCodigoCategoria() == castOther.getCodigoCategoria());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoCompetencia();
		result = 37 * result + this.getCodigoCategoria();
		return result;
	}

}
