package modelo;

// Generated 04-feb-2012 16:31:02 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PersonalEquipoJuegoId generated by hbm2java
 */
@Embeddable
public class PersonalEquipoJuegoId implements java.io.Serializable {

	private int codigoEquipoJuego;
	private int codigoPersonalEquipo;

	public PersonalEquipoJuegoId() {
	}

	public PersonalEquipoJuegoId(int codigoEquipoJuego, int codigoPersonalEquipo) {
		this.codigoEquipoJuego = codigoEquipoJuego;
		this.codigoPersonalEquipo = codigoPersonalEquipo;
	}

	@Column(name = "codigo_equipo_juego", nullable = false)
	public int getCodigoEquipoJuego() {
		return this.codigoEquipoJuego;
	}

	public void setCodigoEquipoJuego(int codigoEquipoJuego) {
		this.codigoEquipoJuego = codigoEquipoJuego;
	}

	@Column(name = "codigo_personal_equipo", nullable = false)
	public int getCodigoPersonalEquipo() {
		return this.codigoPersonalEquipo;
	}

	public void setCodigoPersonalEquipo(int codigoPersonalEquipo) {
		this.codigoPersonalEquipo = codigoPersonalEquipo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonalEquipoJuegoId))
			return false;
		PersonalEquipoJuegoId castOther = (PersonalEquipoJuegoId) other;

		return (this.getCodigoEquipoJuego() == castOther.getCodigoEquipoJuego())
				&& (this.getCodigoPersonalEquipo() == castOther
						.getCodigoPersonalEquipo());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoEquipoJuego();
		result = 37 * result + this.getCodigoPersonalEquipo();
		return result;
	}

}
