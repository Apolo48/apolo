package modelo;

// Generated 05-dic-2011 22:14:58 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmpleadoMantenimientoId generated by hbm2java
 */
@Embeddable
public class EmpleadoMantenimientoId implements java.io.Serializable {

	private String codigoMantenimiento;
	private String cedula;

	public EmpleadoMantenimientoId() {
	}

	public EmpleadoMantenimientoId(String codigoMantenimiento, String cedula) {
		this.codigoMantenimiento = codigoMantenimiento;
		this.cedula = cedula;
	}

	@Column(name = "codigo_mantenimiento", nullable = false)
	public String getCodigoMantenimiento() {
		return this.codigoMantenimiento;
	}

	public void setCodigoMantenimiento(String codigoMantenimiento) {
		this.codigoMantenimiento = codigoMantenimiento;
	}

	@Column(name = "cedula", nullable = false)
	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmpleadoMantenimientoId))
			return false;
		EmpleadoMantenimientoId castOther = (EmpleadoMantenimientoId) other;

		return ((this.getCodigoMantenimiento() == castOther
				.getCodigoMantenimiento()) || (this.getCodigoMantenimiento() != null
				&& castOther.getCodigoMantenimiento() != null && this
				.getCodigoMantenimiento().equals(
						castOther.getCodigoMantenimiento())))
				&& ((this.getCedula() == castOther.getCedula()) || (this
						.getCedula() != null && castOther.getCedula() != null && this
						.getCedula().equals(castOther.getCedula())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoMantenimiento() == null ? 0 : this
						.getCodigoMantenimiento().hashCode());
		result = 37 * result
				+ (getCedula() == null ? 0 : this.getCedula().hashCode());
		return result;
	}

}
