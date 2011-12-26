package modelo;

// Generated 26-dic-2011 15:15:53 by Hibernate Tools 3.4.0.CR1

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
 * AsistenciaJugador generated by hbm2java
 */
@Entity
@Table(name = "asistencia_jugador", schema = "public")
public class AsistenciaJugador implements java.io.Serializable {

	private int codigoAsistencia;
	private Roster roster;
	private SesionEjecutada sesionEjecutada;
	private DatoBasico datoBasico;
	private boolean asistencia;
	private String observacion;
	private Set<DesempeoJugador> desempeoJugadors = new HashSet<DesempeoJugador>(
			0);

	public AsistenciaJugador() {
	}

	public AsistenciaJugador(int codigoAsistencia, Roster roster,
			SesionEjecutada sesionEjecutada, DatoBasico datoBasico,
			boolean asistencia, String observacion) {
		this.codigoAsistencia = codigoAsistencia;
		this.roster = roster;
		this.sesionEjecutada = sesionEjecutada;
		this.datoBasico = datoBasico;
		this.asistencia = asistencia;
		this.observacion = observacion;
	}

	public AsistenciaJugador(int codigoAsistencia, Roster roster,
			SesionEjecutada sesionEjecutada, DatoBasico datoBasico,
			boolean asistencia, String observacion,
			Set<DesempeoJugador> desempeoJugadors) {
		this.codigoAsistencia = codigoAsistencia;
		this.roster = roster;
		this.sesionEjecutada = sesionEjecutada;
		this.datoBasico = datoBasico;
		this.asistencia = asistencia;
		this.observacion = observacion;
		this.desempeoJugadors = desempeoJugadors;
	}

	@Id
	@Column(name = "codigo_asistencia", unique = true, nullable = false)
	public int getCodigoAsistencia() {
		return this.codigoAsistencia;
	}

	public void setCodigoAsistencia(int codigoAsistencia) {
		this.codigoAsistencia = codigoAsistencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_roster", nullable = false)
	public Roster getRoster() {
		return this.roster;
	}

	public void setRoster(Roster roster) {
		this.roster = roster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_sesion_ejecutada", nullable = false)
	public SesionEjecutada getSesionEjecutada() {
		return this.sesionEjecutada;
	}

	public void setSesionEjecutada(SesionEjecutada sesionEjecutada) {
		this.sesionEjecutada = sesionEjecutada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eventualidad", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "asistencia", nullable = false)
	public boolean isAsistencia() {
		return this.asistencia;
	}

	public void setAsistencia(boolean asistencia) {
		this.asistencia = asistencia;
	}

	@Column(name = "observacion", nullable = false)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "asistenciaJugador")
	public Set<DesempeoJugador> getDesempeoJugadors() {
		return this.desempeoJugadors;
	}

	public void setDesempeoJugadors(Set<DesempeoJugador> desempeoJugadors) {
		this.desempeoJugadors = desempeoJugadors;
	}

}
