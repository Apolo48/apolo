package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IngresoInscripcionId generated by hbm2java
 */
@Embeddable
public class IngresoInscripcionId implements java.io.Serializable {

	private int codigoTipoIngreso;
	private int codigoInscripcion;

	public IngresoInscripcionId() {
	}

	public IngresoInscripcionId(int codigoTipoIngreso, int codigoInscripcion) {
		this.codigoTipoIngreso = codigoTipoIngreso;
		this.codigoInscripcion = codigoInscripcion;
	}

	@Column(name = "codigo_tipo_ingreso", nullable = false)
	public int getCodigoTipoIngreso() {
		return this.codigoTipoIngreso;
	}

	public void setCodigoTipoIngreso(int codigoTipoIngreso) {
		this.codigoTipoIngreso = codigoTipoIngreso;
	}

	@Column(name = "codigo_inscripcion", nullable = false)
	public int getCodigoInscripcion() {
		return this.codigoInscripcion;
	}

	public void setCodigoInscripcion(int codigoInscripcion) {
		this.codigoInscripcion = codigoInscripcion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IngresoInscripcionId))
			return false;
		IngresoInscripcionId castOther = (IngresoInscripcionId) other;

		return (this.getCodigoTipoIngreso() == castOther.getCodigoTipoIngreso())
				&& (this.getCodigoInscripcion() == castOther
						.getCodigoInscripcion());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoTipoIngreso();
		result = 37 * result + this.getCodigoInscripcion();
		return result;
	}

}