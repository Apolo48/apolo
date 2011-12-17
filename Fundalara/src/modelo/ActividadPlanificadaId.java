package modelo;

// Generated 17-dic-2011 16:31:20 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ActividadPlanificadaId generated by hbm2java
 */
@Embeddable
public class ActividadPlanificadaId implements java.io.Serializable {

	private int codigoIndicadorActividadEscala;
	private int codigoSesion;

	public ActividadPlanificadaId() {
	}

	public ActividadPlanificadaId(int codigoIndicadorActividadEscala,
			int codigoSesion) {
		this.codigoIndicadorActividadEscala = codigoIndicadorActividadEscala;
		this.codigoSesion = codigoSesion;
	}

	@Column(name = "codigo_indicador_actividad_escala", nullable = false)
	public int getCodigoIndicadorActividadEscala() {
		return this.codigoIndicadorActividadEscala;
	}

	public void setCodigoIndicadorActividadEscala(
			int codigoIndicadorActividadEscala) {
		this.codigoIndicadorActividadEscala = codigoIndicadorActividadEscala;
	}

	@Column(name = "codigo_sesion", nullable = false)
	public int getCodigoSesion() {
		return this.codigoSesion;
	}

	public void setCodigoSesion(int codigoSesion) {
		this.codigoSesion = codigoSesion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ActividadPlanificadaId))
			return false;
		ActividadPlanificadaId castOther = (ActividadPlanificadaId) other;

		return (this.getCodigoIndicadorActividadEscala() == castOther
				.getCodigoIndicadorActividadEscala())
				&& (this.getCodigoSesion() == castOther.getCodigoSesion());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoIndicadorActividadEscala();
		result = 37 * result + this.getCodigoSesion();
		return result;
	}

}
