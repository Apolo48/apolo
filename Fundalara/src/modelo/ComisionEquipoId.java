package modelo;

// Generated 13-dic-2011 21:15:29 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ComisionEquipoId generated by hbm2java
 */
@Embeddable
public class ComisionEquipoId implements java.io.Serializable {

	private String codigoComision;
	private String codigoEquipo;

	public ComisionEquipoId() {
	}

	public ComisionEquipoId(String codigoComision, String codigoEquipo) {
		this.codigoComision = codigoComision;
		this.codigoEquipo = codigoEquipo;
	}

	@Column(name = "codigo_comision", nullable = false)
	public String getCodigoComision() {
		return this.codigoComision;
	}

	public void setCodigoComision(String codigoComision) {
		this.codigoComision = codigoComision;
	}

	@Column(name = "codigo_equipo", nullable = false)
	public String getCodigoEquipo() {
		return this.codigoEquipo;
	}

	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ComisionEquipoId))
			return false;
		ComisionEquipoId castOther = (ComisionEquipoId) other;

		return ((this.getCodigoComision() == castOther.getCodigoComision()) || (this
				.getCodigoComision() != null
				&& castOther.getCodigoComision() != null && this
				.getCodigoComision().equals(castOther.getCodigoComision())))
				&& ((this.getCodigoEquipo() == castOther.getCodigoEquipo()) || (this
						.getCodigoEquipo() != null
						&& castOther.getCodigoEquipo() != null && this
						.getCodigoEquipo().equals(castOther.getCodigoEquipo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoComision() == null ? 0 : this.getCodigoComision()
						.hashCode());
		result = 37
				* result
				+ (getCodigoEquipo() == null ? 0 : this.getCodigoEquipo()
						.hashCode());
		return result;
	}

}
