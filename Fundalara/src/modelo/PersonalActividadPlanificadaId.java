package modelo;

// Generated 30-dic-2011 0:38:42 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PersonalActividadPlanificadaId generated by hbm2java
 */
@Embeddable
public class PersonalActividadPlanificadaId implements java.io.Serializable {

	private String cedulaRif;
	private int codigoPlanificacionActividad;

	public PersonalActividadPlanificadaId() {
	}

	public PersonalActividadPlanificadaId(String cedulaRif,
			int codigoPlanificacionActividad) {
		this.cedulaRif = cedulaRif;
		this.codigoPlanificacionActividad = codigoPlanificacionActividad;
	}

	@Column(name = "cedula_rif", nullable = false)
	public String getCedulaRif() {
		return this.cedulaRif;
	}

	public void setCedulaRif(String cedulaRif) {
		this.cedulaRif = cedulaRif;
	}

	@Column(name = "codigo_planificacion_actividad", nullable = false)
	public int getCodigoPlanificacionActividad() {
		return this.codigoPlanificacionActividad;
	}

	public void setCodigoPlanificacionActividad(int codigoPlanificacionActividad) {
		this.codigoPlanificacionActividad = codigoPlanificacionActividad;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonalActividadPlanificadaId))
			return false;
		PersonalActividadPlanificadaId castOther = (PersonalActividadPlanificadaId) other;

		return ((this.getCedulaRif() == castOther.getCedulaRif()) || (this
				.getCedulaRif() != null && castOther.getCedulaRif() != null && this
				.getCedulaRif().equals(castOther.getCedulaRif())))
				&& (this.getCodigoPlanificacionActividad() == castOther
						.getCodigoPlanificacionActividad());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCedulaRif() == null ? 0 : this.getCedulaRif().hashCode());
		result = 37 * result + this.getCodigoPlanificacionActividad();
		return result;
	}

}
