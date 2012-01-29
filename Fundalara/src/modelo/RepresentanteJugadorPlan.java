package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

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
 * RepresentanteJugadorPlan generated by hbm2java
 */
@Entity
@Table(name = "representante_jugador_plan", schema = "public")
public class RepresentanteJugadorPlan implements java.io.Serializable {

	private RepresentanteJugadorPlanId id;
	private Familiar familiar;
	private JugadorPlan jugadorPlan;
	private char estatus;

	public RepresentanteJugadorPlan() {
	}

	public RepresentanteJugadorPlan(RepresentanteJugadorPlanId id,
			Familiar familiar, JugadorPlan jugadorPlan, char estatus) {
		this.id = id;
		this.familiar = familiar;
		this.jugadorPlan = jugadorPlan;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cedulaJugador", column = @Column(name = "cedula_jugador", nullable = false)),
			@AttributeOverride(name = "cedulaFamiliar", column = @Column(name = "cedula_familiar", nullable = false)) })
	public RepresentanteJugadorPlanId getId() {
		return this.id;
	}

	public void setId(RepresentanteJugadorPlanId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_familiar", nullable = false, insertable = false, updatable = false)
	public Familiar getFamiliar() {
		return this.familiar;
	}

	public void setFamiliar(Familiar familiar) {
		this.familiar = familiar;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_jugador", nullable = false, insertable = false, updatable = false)
	public JugadorPlan getJugadorPlan() {
		return this.jugadorPlan;
	}

	public void setJugadorPlan(JugadorPlan jugadorPlan) {
		this.jugadorPlan = jugadorPlan;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
