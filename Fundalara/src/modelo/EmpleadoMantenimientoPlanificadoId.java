package modelo;

// Generated 05-dic-2011 22:14:58 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmpleadoMantenimientoPlanificadoId generated by hbm2java
 */
@Embeddable
public class EmpleadoMantenimientoPlanificadoId implements java.io.Serializable {

	private String codigoPlanificacionMantenimiento;
	private String cedula;

	public EmpleadoMantenimientoPlanificadoId() {
	}

	public EmpleadoMantenimientoPlanificadoId(
			String codigoPlanificacionMantenimiento, String cedula) {
		this.codigoPlanificacionMantenimiento = codigoPlanificacionMantenimiento;
		this.cedula = cedula;
	}

	@Column(name = "codigo_planificacion_mantenimiento", nullable = false)
	public String getCodigoPlanificacionMantenimiento() {
		return this.codigoPlanificacionMantenimiento;
	}

	public void setCodigoPlanificacionMantenimiento(
			String codigoPlanificacionMantenimiento) {
		this.codigoPlanificacionMantenimiento = codigoPlanificacionMantenimiento;
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
		if (!(other instanceof EmpleadoMantenimientoPlanificadoId))
			return false;
		EmpleadoMantenimientoPlanificadoId castOther = (EmpleadoMantenimientoPlanificadoId) other;

		return ((this.getCodigoPlanificacionMantenimiento() == castOther
				.getCodigoPlanificacionMantenimiento()) || (this
				.getCodigoPlanificacionMantenimiento() != null
				&& castOther.getCodigoPlanificacionMantenimiento() != null && this
				.getCodigoPlanificacionMantenimiento().equals(
						castOther.getCodigoPlanificacionMantenimiento())))
				&& ((this.getCedula() == castOther.getCedula()) || (this
						.getCedula() != null && castOther.getCedula() != null && this
						.getCedula().equals(castOther.getCedula())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoPlanificacionMantenimiento() == null ? 0 : this
						.getCodigoPlanificacionMantenimiento().hashCode());
		result = 37 * result
				+ (getCedula() == null ? 0 : this.getCedula().hashCode());
		return result;
	}

}
