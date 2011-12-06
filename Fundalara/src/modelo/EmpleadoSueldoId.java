package modelo;

// Generated 05-dic-2011 18:58:46 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmpleadoSueldoId generated by hbm2java
 */
@Embeddable
public class EmpleadoSueldoId implements java.io.Serializable {

	private String cedula;
	private Date fecha;

	public EmpleadoSueldoId() {
	}

	public EmpleadoSueldoId(String cedula, Date fecha) {
		this.cedula = cedula;
		this.fecha = fecha;
	}

	@Column(name = "cedula", nullable = false)
	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Column(name = "fecha", nullable = false, length = 13)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmpleadoSueldoId))
			return false;
		EmpleadoSueldoId castOther = (EmpleadoSueldoId) other;

		return ((this.getCedula() == castOther.getCedula()) || (this
				.getCedula() != null && castOther.getCedula() != null && this
				.getCedula().equals(castOther.getCedula())))
				&& ((this.getFecha() == castOther.getFecha()) || (this
						.getFecha() != null && castOther.getFecha() != null && this
						.getFecha().equals(castOther.getFecha())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCedula() == null ? 0 : this.getCedula().hashCode());
		result = 37 * result
				+ (getFecha() == null ? 0 : this.getFecha().hashCode());
		return result;
	}

}
