package modelo;

// Generated 04-feb-2012 16:31:02 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PersonalEquipoJuego generated by hbm2java
 */
@Entity
@Table(name = "personal_equipo_juego", schema = "public")
public class PersonalEquipoJuego implements java.io.Serializable {

	private PersonalEquipoJuegoId id;
	private EquipoJuego equipoJuego;
	private PersonalEquipo personalEquipo;
	private char estatus;

	public PersonalEquipoJuego() {
	}

	public PersonalEquipoJuego(PersonalEquipoJuegoId id,
			EquipoJuego equipoJuego, PersonalEquipo personalEquipo, char estatus) {
		this.id = id;
		this.equipoJuego = equipoJuego;
		this.personalEquipo = personalEquipo;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoEquipoJuego", column = @Column(name = "codigo_equipo_juego", nullable = false)),
			@AttributeOverride(name = "codigoPersonalEquipo", column = @Column(name = "codigo_personal_equipo", nullable = false)) })
	public PersonalEquipoJuegoId getId() {
		return this.id;
	}

	public void setId(PersonalEquipoJuegoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_equipo_juego", nullable = false, insertable = false, updatable = false)
	public EquipoJuego getEquipoJuego() {
		return this.equipoJuego;
	}

	public void setEquipoJuego(EquipoJuego equipoJuego) {
		this.equipoJuego = equipoJuego;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_personal_equipo", nullable = false, insertable = false, updatable = false)
	public PersonalEquipo getPersonalEquipo() {
		return this.personalEquipo;
	}

	public void setPersonalEquipo(PersonalEquipo personalEquipo) {
		this.personalEquipo = personalEquipo;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
