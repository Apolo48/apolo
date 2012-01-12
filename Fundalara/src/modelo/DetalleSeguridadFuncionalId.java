package modelo;

// Generated 11-ene-2012 21:47:34 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DetalleSeguridadFuncionalId generated by hbm2java
 */
@Embeddable
public class DetalleSeguridadFuncionalId implements java.io.Serializable {

	private int codigoSeguridad;
	private int codigoTipoDato;

	public DetalleSeguridadFuncionalId() {
	}

	public DetalleSeguridadFuncionalId(int codigoSeguridad, int codigoTipoDato) {
		this.codigoSeguridad = codigoSeguridad;
		this.codigoTipoDato = codigoTipoDato;
	}

	@Column(name = "codigo_seguridad", nullable = false)
	public int getCodigoSeguridad() {
		return this.codigoSeguridad;
	}

	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	@Column(name = "codigo_tipo_dato", nullable = false)
	public int getCodigoTipoDato() {
		return this.codigoTipoDato;
	}

	public void setCodigoTipoDato(int codigoTipoDato) {
		this.codigoTipoDato = codigoTipoDato;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DetalleSeguridadFuncionalId))
			return false;
		DetalleSeguridadFuncionalId castOther = (DetalleSeguridadFuncionalId) other;

		return (this.getCodigoSeguridad() == castOther.getCodigoSeguridad())
				&& (this.getCodigoTipoDato() == castOther.getCodigoTipoDato());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoSeguridad();
		result = 37 * result + this.getCodigoTipoDato();
		return result;
	}

}
