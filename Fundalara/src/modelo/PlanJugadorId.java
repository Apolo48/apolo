package modelo;

// Generated 13-dic-2011 23:21:03 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PlanJugadorId generated by hbm2java
 */
@Embeddable
public class PlanJugadorId implements java.io.Serializable {

	private String codigoPlan;
	private String codigoParticipante;

	public PlanJugadorId() {
	}

	public PlanJugadorId(String codigoPlan, String codigoParticipante) {
		this.codigoPlan = codigoPlan;
		this.codigoParticipante = codigoParticipante;
	}

	@Column(name = "codigo_plan", nullable = false)
	public String getCodigoPlan() {
		return this.codigoPlan;
	}

	public void setCodigoPlan(String codigoPlan) {
		this.codigoPlan = codigoPlan;
	}

	@Column(name = "codigo_participante", nullable = false)
	public String getCodigoParticipante() {
		return this.codigoParticipante;
	}

	public void setCodigoParticipante(String codigoParticipante) {
		this.codigoParticipante = codigoParticipante;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PlanJugadorId))
			return false;
		PlanJugadorId castOther = (PlanJugadorId) other;

		return ((this.getCodigoPlan() == castOther.getCodigoPlan()) || (this
				.getCodigoPlan() != null && castOther.getCodigoPlan() != null && this
				.getCodigoPlan().equals(castOther.getCodigoPlan())))
				&& ((this.getCodigoParticipante() == castOther
						.getCodigoParticipante()) || (this
						.getCodigoParticipante() != null
						&& castOther.getCodigoParticipante() != null && this
						.getCodigoParticipante().equals(
								castOther.getCodigoParticipante())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoPlan() == null ? 0 : this.getCodigoPlan()
						.hashCode());
		result = 37
				* result
				+ (getCodigoParticipante() == null ? 0 : this
						.getCodigoParticipante().hashCode());
		return result;
	}

}
