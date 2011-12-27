package modelo;

// Generated 26-dic-2011 21:37:05 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * DatoDeportivo generated by hbm2java
 */
@Entity
@Table(name = "dato_deportivo", schema = "public")
public class DatoDeportivo implements java.io.Serializable {

	private DatoDeportivoId id;
	private Competencia competencia;
	private Jugador jugador;
	private char estatus;
	private Set<LogroPorJugador> logroPorJugadors = new HashSet<LogroPorJugador>(
			0);

	public DatoDeportivo() {
	}

	public DatoDeportivo(DatoDeportivoId id, Competencia competencia,
			Jugador jugador, char estatus) {
		this.id = id;
		this.competencia = competencia;
		this.jugador = jugador;
		this.estatus = estatus;
	}

	public DatoDeportivo(DatoDeportivoId id, Competencia competencia,
			Jugador jugador, char estatus, Set<LogroPorJugador> logroPorJugadors) {
		this.id = id;
		this.competencia = competencia;
		this.jugador = jugador;
		this.estatus = estatus;
		this.logroPorJugadors = logroPorJugadors;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoCompetencia", column = @Column(name = "codigo_competencia", nullable = false)),
			@AttributeOverride(name = "cedulaRif", column = @Column(name = "cedula_rif", nullable = false)) })
	public DatoDeportivoId getId() {
		return this.id;
	}

	public void setId(DatoDeportivoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_competencia", nullable = false, insertable = false, updatable = false)
	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_rif", nullable = false, insertable = false, updatable = false)
	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoDeportivo")
	public Set<LogroPorJugador> getLogroPorJugadors() {
		return this.logroPorJugadors;
	}

	public void setLogroPorJugadors(Set<LogroPorJugador> logroPorJugadors) {
		this.logroPorJugadors = logroPorJugadors;
	}

}
