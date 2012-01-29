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
 * AfeccionJugador generated by hbm2java
 */
@Entity
@Table(name = "afeccion_jugador", schema = "public")
public class AfeccionJugador implements java.io.Serializable {

	private AfeccionJugadorId id;
	private DatoMedico datoMedico;
	private DatoBasico datoBasico;
	private char estatus;

	public AfeccionJugador() {
	}

	public AfeccionJugador(AfeccionJugadorId id, DatoMedico datoMedico,
			DatoBasico datoBasico, char estatus) {
		this.id = id;
		this.datoMedico = datoMedico;
		this.datoBasico = datoBasico;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoAfeccion", column = @Column(name = "codigo_afeccion", nullable = false)),
			@AttributeOverride(name = "codigoDatoMedico", column = @Column(name = "codigo_dato_medico", nullable = false)) })
	public AfeccionJugadorId getId() {
		return this.id;
	}

	public void setId(AfeccionJugadorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_dato_medico", nullable = false, insertable = false, updatable = false)
	public DatoMedico getDatoMedico() {
		return this.datoMedico;
	}

	public void setDatoMedico(DatoMedico datoMedico) {
		this.datoMedico = datoMedico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_afeccion", nullable = false, insertable = false, updatable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
