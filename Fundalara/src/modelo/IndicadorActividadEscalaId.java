package modelo;

// Generated 05-dic-2011 23:09:14 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IndicadorActividadEscalaId generated by hbm2java
 */
@Embeddable
public class IndicadorActividadEscalaId implements java.io.Serializable {

	private String codIndicador;
	private String codActividadEntrenamiento;

	public IndicadorActividadEscalaId() {
	}

	public IndicadorActividadEscalaId(String codIndicador,
			String codActividadEntrenamiento) {
		this.codIndicador = codIndicador;
		this.codActividadEntrenamiento = codActividadEntrenamiento;
	}

	@Column(name = "cod_indicador", nullable = false)
	public String getCodIndicador() {
		return this.codIndicador;
	}

	public void setCodIndicador(String codIndicador) {
		this.codIndicador = codIndicador;
	}

	@Column(name = "cod_actividad_entrenamiento", nullable = false)
	public String getCodActividadEntrenamiento() {
		return this.codActividadEntrenamiento;
	}

	public void setCodActividadEntrenamiento(String codActividadEntrenamiento) {
		this.codActividadEntrenamiento = codActividadEntrenamiento;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IndicadorActividadEscalaId))
			return false;
		IndicadorActividadEscalaId castOther = (IndicadorActividadEscalaId) other;

		return ((this.getCodIndicador() == castOther.getCodIndicador()) || (this
				.getCodIndicador() != null
				&& castOther.getCodIndicador() != null && this
				.getCodIndicador().equals(castOther.getCodIndicador())))
				&& ((this.getCodActividadEntrenamiento() == castOther
						.getCodActividadEntrenamiento()) || (this
						.getCodActividadEntrenamiento() != null
						&& castOther.getCodActividadEntrenamiento() != null && this
						.getCodActividadEntrenamiento().equals(
								castOther.getCodActividadEntrenamiento())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodIndicador() == null ? 0 : this.getCodIndicador()
						.hashCode());
		result = 37
				* result
				+ (getCodActividadEntrenamiento() == null ? 0 : this
						.getCodActividadEntrenamiento().hashCode());
		return result;
	}

}
