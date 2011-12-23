package modelo;

// Generated 22-dic-2011 17:58:31 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DesempeoJugadorId generated by hbm2java
 */
@Embeddable
public class DesempeoJugadorId implements java.io.Serializable {

	private int codigoAsistencia;
	private int codigoActividadEjecutada;

	public DesempeoJugadorId() {
	}

	public DesempeoJugadorId(int codigoAsistencia, int codigoActividadEjecutada) {
		this.codigoAsistencia = codigoAsistencia;
		this.codigoActividadEjecutada = codigoActividadEjecutada;
	}

	@Column(name = "codigo_asistencia", nullable = false)
	public int getCodigoAsistencia() {
		return this.codigoAsistencia;
	}

	public void setCodigoAsistencia(int codigoAsistencia) {
		this.codigoAsistencia = codigoAsistencia;
	}

	@Column(name = "codigo_actividad_ejecutada", nullable = false)
	public int getCodigoActividadEjecutada() {
		return this.codigoActividadEjecutada;
	}

	public void setCodigoActividadEjecutada(int codigoActividadEjecutada) {
		this.codigoActividadEjecutada = codigoActividadEjecutada;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DesempeoJugadorId))
			return false;
		DesempeoJugadorId castOther = (DesempeoJugadorId) other;

		return (this.getCodigoAsistencia() == castOther.getCodigoAsistencia())
				&& (this.getCodigoActividadEjecutada() == castOther
						.getCodigoActividadEjecutada());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoAsistencia();
		result = 37 * result + this.getCodigoActividadEjecutada();
		return result;
	}

}
