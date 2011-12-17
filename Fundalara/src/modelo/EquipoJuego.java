package modelo;

// Generated 17/12/2011 10:20:04 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * EquipoJuego generated by hbm2java
 */
@Entity
@Table(name = "equipo_juego")
public class EquipoJuego implements java.io.Serializable {

	private String codigoEquipoJuego;
	private Juego juego;
	private EquipoCompetencia equipoCompetencia;
	private boolean homeClub;
	private DesempennoColectivo desempennoColectivo;

	public EquipoJuego() {
	}

	public EquipoJuego(String codigoEquipoJuego, Juego juego,
			EquipoCompetencia equipoCompetencia, boolean homeClub) {
		this.codigoEquipoJuego = codigoEquipoJuego;
		this.juego = juego;
		this.equipoCompetencia = equipoCompetencia;
		this.homeClub = homeClub;
	}

	public EquipoJuego(String codigoEquipoJuego, Juego juego,
			EquipoCompetencia equipoCompetencia, boolean homeClub,
			DesempennoColectivo desempennoColectivo) {
		this.codigoEquipoJuego = codigoEquipoJuego;
		this.juego = juego;
		this.equipoCompetencia = equipoCompetencia;
		this.homeClub = homeClub;
		this.desempennoColectivo = desempennoColectivo;
	}

	@Id
	@Column(name = "codigo_equipo_juego", unique = true, nullable = false)
	public String getCodigoEquipoJuego() {
		return this.codigoEquipoJuego;
	}

	public void setCodigoEquipoJuego(String codigoEquipoJuego) {
		this.codigoEquipoJuego = codigoEquipoJuego;
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
	@JoinColumn(name = "codigo_equipo_competencia", nullable = false)
	public EquipoCompetencia getEquipoCompetencia() {
		return this.equipoCompetencia;
	}

	public void setEquipoCompetencia(EquipoCompetencia equipoCompetencia) {
		this.equipoCompetencia = equipoCompetencia;
	}

	@Column(name = "home_club", nullable = false)
	public boolean isHomeClub() {
		return this.homeClub;
	}

	public void setHomeClub(boolean homeClub) {
		this.homeClub = homeClub;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "equipoJuego")
	public DesempennoColectivo getDesempennoColectivo() {
		return this.desempennoColectivo;
	}

	public void setDesempennoColectivo(DesempennoColectivo desempennoColectivo) {
		this.desempennoColectivo = desempennoColectivo;
	}

}
