package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

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

/**
 * ComisionFamiliar generated by hbm2java
 */
@Entity
@Table(name = "comision_familiar", schema = "public")
@SequenceGenerator(name = "comisionFamiliar_seq", sequenceName = "comision_familiar_codigo_comision_familiar_seq_1_2")
public class ComisionFamiliar implements java.io.Serializable {

	private int codigoComisionFamiliar;
	private DatoBasico datoBasico;
	private FamiliarJugador familiarJugador;
	private char estatus;
	private Set<TareaActividadPlanificada> tareaActividadPlanificadas = new HashSet<TareaActividadPlanificada>(
			0);

	public ComisionFamiliar() {
	}

	public ComisionFamiliar(int codigoComisionFamiliar, DatoBasico datoBasico,
			FamiliarJugador familiarJugador, char estatus) {
		this.codigoComisionFamiliar = codigoComisionFamiliar;
		this.datoBasico = datoBasico;
		this.familiarJugador = familiarJugador;
		this.estatus = estatus;
	}

	public ComisionFamiliar(int codigoComisionFamiliar, DatoBasico datoBasico,
			FamiliarJugador familiarJugador, char estatus,
			Set<TareaActividadPlanificada> tareaActividadPlanificadas) {
		this.codigoComisionFamiliar = codigoComisionFamiliar;
		this.datoBasico = datoBasico;
		this.familiarJugador = familiarJugador;
		this.estatus = estatus;
		this.tareaActividadPlanificadas = tareaActividadPlanificadas;
	}

	@Id
	@Column(name = "codigo_comision_familiar", unique = true, nullable = false)
	@GeneratedValue(generator = "comisionFamiliar_seq")
	public int getCodigoComisionFamiliar() {
		return this.codigoComisionFamiliar;
	}

	public void setCodigoComisionFamiliar(int codigoComisionFamiliar) {
		this.codigoComisionFamiliar = codigoComisionFamiliar;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_comision", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_familiar_jugador", nullable = false)
	public FamiliarJugador getFamiliarJugador() {
		return this.familiarJugador;
	}

	public void setFamiliarJugador(FamiliarJugador familiarJugador) {
		this.familiarJugador = familiarJugador;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comisionFamiliar")
	public Set<TareaActividadPlanificada> getTareaActividadPlanificadas() {
		return this.tareaActividadPlanificadas;
	}

	public void setTareaActividadPlanificadas(
			Set<TareaActividadPlanificada> tareaActividadPlanificadas) {
		this.tareaActividadPlanificadas = tareaActividadPlanificadas;
	}

}
