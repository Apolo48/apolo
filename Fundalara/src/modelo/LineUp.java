package modelo;

// Generated 04-feb-2012 16:31:02 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * LineUp generated by hbm2java
 */
@Entity
@Table(name = "line_up", schema = "public")
public class LineUp implements java.io.Serializable {

	private int codigoLineUp;
	private RosterCompetencia rosterCompetencia;
	private Juego juego;
	private DatoBasico datoBasicoByCodigoPosicion;
	private DatoBasico datoBasicoByCodigoEstadoLineUp;
	private Integer ordenBate;
	private Set<DesempennoIndividual> desempennoIndividuals = new HashSet<DesempennoIndividual>(
			0);

	public LineUp() {
	}

	public LineUp(int codigoLineUp, RosterCompetencia rosterCompetencia,
			Juego juego, DatoBasico datoBasicoByCodigoEstadoLineUp) {
		this.codigoLineUp = codigoLineUp;
		this.rosterCompetencia = rosterCompetencia;
		this.juego = juego;
		this.datoBasicoByCodigoEstadoLineUp = datoBasicoByCodigoEstadoLineUp;
	}

	public LineUp(int codigoLineUp, RosterCompetencia rosterCompetencia,
			Juego juego, DatoBasico datoBasicoByCodigoPosicion,
			DatoBasico datoBasicoByCodigoEstadoLineUp, Integer ordenBate,
			Set<DesempennoIndividual> desempennoIndividuals) {
		this.codigoLineUp = codigoLineUp;
		this.rosterCompetencia = rosterCompetencia;
		this.juego = juego;
		this.datoBasicoByCodigoPosicion = datoBasicoByCodigoPosicion;
		this.datoBasicoByCodigoEstadoLineUp = datoBasicoByCodigoEstadoLineUp;
		this.ordenBate = ordenBate;
		this.desempennoIndividuals = desempennoIndividuals;
	}

	@Id
	@Column(name = "codigo_line_up", unique = true, nullable = false)
	public int getCodigoLineUp() {
		return this.codigoLineUp;
	}

	public void setCodigoLineUp(int codigoLineUp) {
		this.codigoLineUp = codigoLineUp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_roster_competencia", nullable = false)
	public RosterCompetencia getRosterCompetencia() {
		return this.rosterCompetencia;
	}

	public void setRosterCompetencia(RosterCompetencia rosterCompetencia) {
		this.rosterCompetencia = rosterCompetencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_juego", nullable = false)
	public Juego getJuego() {
		return this.juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_posicion")
	public DatoBasico getDatoBasicoByCodigoPosicion() {
		return this.datoBasicoByCodigoPosicion;
	}

	public void setDatoBasicoByCodigoPosicion(
			DatoBasico datoBasicoByCodigoPosicion) {
		this.datoBasicoByCodigoPosicion = datoBasicoByCodigoPosicion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_estado_line_up", nullable = false)
	public DatoBasico getDatoBasicoByCodigoEstadoLineUp() {
		return this.datoBasicoByCodigoEstadoLineUp;
	}

	public void setDatoBasicoByCodigoEstadoLineUp(
			DatoBasico datoBasicoByCodigoEstadoLineUp) {
		this.datoBasicoByCodigoEstadoLineUp = datoBasicoByCodigoEstadoLineUp;
	}

	@Column(name = "orden_bate")
	public Integer getOrdenBate() {
		return this.ordenBate;
	}

	public void setOrdenBate(Integer ordenBate) {
		this.ordenBate = ordenBate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lineUp")
	public Set<DesempennoIndividual> getDesempennoIndividuals() {
		return this.desempennoIndividuals;
	}

	public void setDesempennoIndividuals(
			Set<DesempennoIndividual> desempennoIndividuals) {
		this.desempennoIndividuals = desempennoIndividuals;
	}

}
