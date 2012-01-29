package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

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
 * JugadorForaneo generated by hbm2java
 */
@Entity
@Table(name = "jugador_foraneo", schema = "public")
public class JugadorForaneo implements java.io.Serializable {

	private String cedula;
	private Equipo equipo;
	private String nombre;
	private char estatus;
	private Set<JugadorForaneoRosterCompetencia> jugadorForaneoRosterCompetencias = new HashSet<JugadorForaneoRosterCompetencia>(
			0);

	public JugadorForaneo() {
	}

	public JugadorForaneo(String cedula, Equipo equipo, String nombre,
			char estatus) {
		this.cedula = cedula;
		this.equipo = equipo;
		this.nombre = nombre;
		this.estatus = estatus;
	}

	public JugadorForaneo(
			String cedula,
			Equipo equipo,
			String nombre,
			char estatus,
			Set<JugadorForaneoRosterCompetencia> jugadorForaneoRosterCompetencias) {
		this.cedula = cedula;
		this.equipo = equipo;
		this.nombre = nombre;
		this.estatus = estatus;
		this.jugadorForaneoRosterCompetencias = jugadorForaneoRosterCompetencias;
	}

	@Id
	@Column(name = "cedula", unique = true, nullable = false)
	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_equipo", nullable = false)
	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jugadorForaneo")
	public Set<JugadorForaneoRosterCompetencia> getJugadorForaneoRosterCompetencias() {
		return this.jugadorForaneoRosterCompetencias;
	}

	public void setJugadorForaneoRosterCompetencias(
			Set<JugadorForaneoRosterCompetencia> jugadorForaneoRosterCompetencias) {
		this.jugadorForaneoRosterCompetencias = jugadorForaneoRosterCompetencias;
	}

}
