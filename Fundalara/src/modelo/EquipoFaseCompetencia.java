package modelo;

// Generated 13/02/2012 02:19:00 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EquipoFaseCompetencia generated by hbm2java
 */
@Entity
@Table(name = "equipo_fase_competencia", schema = "public")
public class EquipoFaseCompetencia implements java.io.Serializable {

	private int codigoEquipoFaseCompetencia;
	private FaseCompetencia faseCompetencia;
	private EquipoCompetencia equipoCompetencia;
	private char estatus;

	public EquipoFaseCompetencia() {
	}

	public EquipoFaseCompetencia(int codigoEquipoFaseCompetencia,
			FaseCompetencia faseCompetencia,
			EquipoCompetencia equipoCompetencia, char estatus) {
		this.codigoEquipoFaseCompetencia = codigoEquipoFaseCompetencia;
		this.faseCompetencia = faseCompetencia;
		this.equipoCompetencia = equipoCompetencia;
		this.estatus = estatus;
	}

	@Id
	@Column(name = "codigo_equipo_fase_competencia", unique = true, nullable = false)
	public int getCodigoEquipoFaseCompetencia() {
		return this.codigoEquipoFaseCompetencia;
	}

	public void setCodigoEquipoFaseCompetencia(int codigoEquipoFaseCompetencia) {
		this.codigoEquipoFaseCompetencia = codigoEquipoFaseCompetencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_fase_competencia", nullable = false)
	public FaseCompetencia getFaseCompetencia() {
		return this.faseCompetencia;
	}

	public void setFaseCompetencia(FaseCompetencia faseCompetencia) {
		this.faseCompetencia = faseCompetencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_equipo_competencia", nullable = false)
	public EquipoCompetencia getEquipoCompetencia() {
		return this.equipoCompetencia;
	}

	public void setEquipoCompetencia(EquipoCompetencia equipoCompetencia) {
		this.equipoCompetencia = equipoCompetencia;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}