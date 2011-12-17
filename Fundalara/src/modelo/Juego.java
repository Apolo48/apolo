package modelo;

// Generated 17/12/2011 10:20:04 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Juego generated by hbm2java
 */
@Entity
@Table(name = "juego")
public class Juego implements java.io.Serializable {

	private String codigoJuego;
	private Estadio estadio;
	private Competencia competencia;
	private DatoBasico datoBasico;
	private Date horaInicio;
	private Date fecha;
	private String anotador;
	private Set<EquipoJuego> equipoJuegos = new HashSet<EquipoJuego>(0);
	private Set<Umpire> umpires = new HashSet<Umpire>(0);

	public Juego() {
	}

	public Juego(String codigoJuego, Estadio estadio, Competencia competencia,
			DatoBasico datoBasico, Date horaInicio, Date fecha, String anotador) {
		this.codigoJuego = codigoJuego;
		this.estadio = estadio;
		this.competencia = competencia;
		this.datoBasico = datoBasico;
		this.horaInicio = horaInicio;
		this.fecha = fecha;
		this.anotador = anotador;
	}

	public Juego(String codigoJuego, Estadio estadio, Competencia competencia,
			DatoBasico datoBasico, Date horaInicio, Date fecha,
			String anotador, Set<EquipoJuego> equipoJuegos, Set<Umpire> umpires) {
		this.codigoJuego = codigoJuego;
		this.estadio = estadio;
		this.competencia = competencia;
		this.datoBasico = datoBasico;
		this.horaInicio = horaInicio;
		this.fecha = fecha;
		this.anotador = anotador;
		this.equipoJuegos = equipoJuegos;
		this.umpires = umpires;
	}

	@Id
	@Column(name = "codigo_juego", unique = true, nullable = false)
	public String getCodigoJuego() {
		return this.codigoJuego;
	}

	public void setCodigoJuego(String codigoJuego) {
		this.codigoJuego = codigoJuego;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_estadio", nullable = false)
	public Estadio getEstadio() {
		return this.estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_competencia", nullable = false)
	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_estado", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_inicio", nullable = false, length = 15)
	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 13)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "anotador", nullable = false)
	public String getAnotador() {
		return this.anotador;
	}

	public void setAnotador(String anotador) {
		this.anotador = anotador;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "juego")
	public Set<EquipoJuego> getEquipoJuegos() {
		return this.equipoJuegos;
	}

	public void setEquipoJuegos(Set<EquipoJuego> equipoJuegos) {
		this.equipoJuegos = equipoJuegos;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "juegos")
	public Set<Umpire> getUmpires() {
		return this.umpires;
	}

	public void setUmpires(Set<Umpire> umpires) {
		this.umpires = umpires;
	}

}
