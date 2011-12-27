package modelo;

// Generated 26-dic-2011 21:37:05 by Hibernate Tools 3.4.0.CR1

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
 * TallaPorJugador generated by hbm2java
 */
@Entity
@Table(name = "talla_por_jugador", schema = "public")
public class TallaPorJugador implements java.io.Serializable {

	private TallaPorJugadorId id;
	private TallaPorIndumentaria tallaPorIndumentaria;
	private Jugador jugador;
	private char estatus;

	public TallaPorJugador() {
	}

	public TallaPorJugador(TallaPorJugadorId id,
			TallaPorIndumentaria tallaPorIndumentaria, Jugador jugador,
			char estatus) {
		this.id = id;
		this.tallaPorIndumentaria = tallaPorIndumentaria;
		this.jugador = jugador;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cedulaRif", column = @Column(name = "cedula_rif", nullable = false)),
			@AttributeOverride(name = "codigoTallaIndumentaria", column = @Column(name = "codigo_talla_indumentaria", nullable = false)) })
	public TallaPorJugadorId getId() {
		return this.id;
	}

	public void setId(TallaPorJugadorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_talla_indumentaria", nullable = false, insertable = false, updatable = false)
	public TallaPorIndumentaria getTallaPorIndumentaria() {
		return this.tallaPorIndumentaria;
	}

	public void setTallaPorIndumentaria(
			TallaPorIndumentaria tallaPorIndumentaria) {
		this.tallaPorIndumentaria = tallaPorIndumentaria;
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

}
