package modelo;

// Generated 26-dic-2011 21:37:05 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DesempennoColectivoId generated by hbm2java
 */
@Embeddable
public class DesempennoColectivoId implements java.io.Serializable {

	private int codigoEquipoJuego;
	private int codigoIndicadorCompetencia;

	public DesempennoColectivoId() {
	}

	public DesempennoColectivoId(int codigoEquipoJuego,
			int codigoIndicadorCompetencia) {
		this.codigoEquipoJuego = codigoEquipoJuego;
		this.codigoIndicadorCompetencia = codigoIndicadorCompetencia;
	}

	@Column(name = "codigo_equipo_juego", nullable = false)
	public int getCodigoEquipoJuego() {
		return this.codigoEquipoJuego;
	}

	public void setCodigoEquipoJuego(int codigoEquipoJuego) {
		this.codigoEquipoJuego = codigoEquipoJuego;
	}

	@Column(name = "codigo_indicador_competencia", nullable = false)
	public int getCodigoIndicadorCompetencia() {
		return this.codigoIndicadorCompetencia;
	}

	public void setCodigoIndicadorCompetencia(int codigoIndicadorCompetencia) {
		this.codigoIndicadorCompetencia = codigoIndicadorCompetencia;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DesempennoColectivoId))
			return false;
		DesempennoColectivoId castOther = (DesempennoColectivoId) other;

		return (this.getCodigoEquipoJuego() == castOther.getCodigoEquipoJuego())
				&& (this.getCodigoIndicadorCompetencia() == castOther
						.getCodigoIndicadorCompetencia());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoEquipoJuego();
		result = 37 * result + this.getCodigoIndicadorCompetencia();
		return result;
	}

}
