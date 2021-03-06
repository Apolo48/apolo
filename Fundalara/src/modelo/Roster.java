package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Roster generated by hbm2java
 */
@Entity
@Table(name = "roster", schema = "public")
@SequenceGenerator(name = "roster_seq", sequenceName = "roster_codigo_roster_seq1")
public class Roster implements java.io.Serializable {

	private int codigoRoster;
	private Jugador jugador;
	private Equipo equipo;
	private Date fechaIngreso;
	private char estatus;
	private Set<TestJugador> testJugadors = new HashSet<TestJugador>(0);
	private Set<Ascenso> ascensos = new HashSet<Ascenso>(0);
	private Set<Anuario> anuarios = new HashSet<Anuario>(0);
	private Set<AsistenciaJugador> asistenciaJugadors = new HashSet<AsistenciaJugador>(
			0);
	private Set<RosterCompetencia> rosterCompetencias = new HashSet<RosterCompetencia>(
			0);

	public Roster() {
	}

	public Roster(int codigoRoster, Jugador jugador, Equipo equipo,
			Date fechaIngreso, char estatus) {
		this.codigoRoster = codigoRoster;
		this.jugador = jugador;
		this.equipo = equipo;
		this.fechaIngreso = fechaIngreso;
		this.estatus = estatus;
	}

	public Roster(int codigoRoster, Jugador jugador, Equipo equipo,
			Date fechaIngreso, char estatus, Set<TestJugador> testJugadors,
			Set<Ascenso> ascensos, Set<Anuario> anuarios,
			Set<AsistenciaJugador> asistenciaJugadors,
			Set<RosterCompetencia> rosterCompetencias) {
		this.codigoRoster = codigoRoster;
		this.jugador = jugador;
		this.equipo = equipo;
		this.fechaIngreso = fechaIngreso;
		this.estatus = estatus;
		this.testJugadors = testJugadors;
		this.ascensos = ascensos;
		this.anuarios = anuarios;
		this.asistenciaJugadors = asistenciaJugadors;
		this.rosterCompetencias = rosterCompetencias;
	}

	@Id
	@Column(name = "codigo_roster", unique = true, nullable = false)
	@GeneratedValue(generator = "roster_seq")
	public int getCodigoRoster() {
		return this.codigoRoster;
	}

	public void setCodigoRoster(int codigoRoster) {
		this.codigoRoster = codigoRoster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_rif", nullable = false)
	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_equipo", nullable = false)
	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso", nullable = false, length = 13)
	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roster")
	public Set<TestJugador> getTestJugadors() {
		return this.testJugadors;
	}

	public void setTestJugadors(Set<TestJugador> testJugadors) {
		this.testJugadors = testJugadors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roster")
	public Set<Ascenso> getAscensos() {
		return this.ascensos;
	}

	public void setAscensos(Set<Ascenso> ascensos) {
		this.ascensos = ascensos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roster")
	public Set<Anuario> getAnuarios() {
		return this.anuarios;
	}

	public void setAnuarios(Set<Anuario> anuarios) {
		this.anuarios = anuarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roster")
	public Set<AsistenciaJugador> getAsistenciaJugadors() {
		return this.asistenciaJugadors;
	}

	public void setAsistenciaJugadors(Set<AsistenciaJugador> asistenciaJugadors) {
		this.asistenciaJugadors = asistenciaJugadors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roster")
	public Set<RosterCompetencia> getRosterCompetencias() {
		return this.rosterCompetencias;
	}

	public void setRosterCompetencias(Set<RosterCompetencia> rosterCompetencias) {
		this.rosterCompetencias = rosterCompetencias;
	}

}
