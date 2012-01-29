package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AfeccionJugadorId generated by hbm2java
 */
@Embeddable
public class AfeccionJugadorId implements java.io.Serializable {

	private int codigoAfeccion;
	private int codigoDatoMedico;

	public AfeccionJugadorId() {
	}

	public AfeccionJugadorId(int codigoAfeccion, int codigoDatoMedico) {
		this.codigoAfeccion = codigoAfeccion;
		this.codigoDatoMedico = codigoDatoMedico;
	}

	@Column(name = "codigo_afeccion", nullable = false)
	public int getCodigoAfeccion() {
		return this.codigoAfeccion;
	}

	public void setCodigoAfeccion(int codigoAfeccion) {
		this.codigoAfeccion = codigoAfeccion;
	}

	@Column(name = "codigo_dato_medico", nullable = false)
	public int getCodigoDatoMedico() {
		return this.codigoDatoMedico;
	}

	public void setCodigoDatoMedico(int codigoDatoMedico) {
		this.codigoDatoMedico = codigoDatoMedico;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AfeccionJugadorId))
			return false;
		AfeccionJugadorId castOther = (AfeccionJugadorId) other;

		return (this.getCodigoAfeccion() == castOther.getCodigoAfeccion())
				&& (this.getCodigoDatoMedico() == castOther
						.getCodigoDatoMedico());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoAfeccion();
		result = 37 * result + this.getCodigoDatoMedico();
		return result;
	}

}
