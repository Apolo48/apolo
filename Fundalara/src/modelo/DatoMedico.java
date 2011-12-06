package modelo;

// Generated 05-dic-2011 22:14:58 by Hibernate Tools 3.4.0.CR1

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
 * DatoMedico generated by hbm2java
 */
@Entity
@Table(name = "dato_medico")
public class DatoMedico implements java.io.Serializable {

	private String codigoRegistro;
	private Medico medico;
	private Jugador jugador;
	private String factorSanguineo;
	private String observacion;
	private char estatus;
	private Set<AfeccionJugador> afeccionJugadors = new HashSet<AfeccionJugador>(
			0);

	public DatoMedico() {
	}

	public DatoMedico(String codigoRegistro, Medico medico, Jugador jugador,
			String factorSanguineo, String observacion, char estatus) {
		this.codigoRegistro = codigoRegistro;
		this.medico = medico;
		this.jugador = jugador;
		this.factorSanguineo = factorSanguineo;
		this.observacion = observacion;
		this.estatus = estatus;
	}

	public DatoMedico(String codigoRegistro, Medico medico, Jugador jugador,
			String factorSanguineo, String observacion, char estatus,
			Set<AfeccionJugador> afeccionJugadors) {
		this.codigoRegistro = codigoRegistro;
		this.medico = medico;
		this.jugador = jugador;
		this.factorSanguineo = factorSanguineo;
		this.observacion = observacion;
		this.estatus = estatus;
		this.afeccionJugadors = afeccionJugadors;
	}

	@Id
	@Column(name = "codigo_registro", unique = true, nullable = false)
	public String getCodigoRegistro() {
		return this.codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matricula", nullable = false)
	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_jugador", nullable = false)
	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Column(name = "factor_sanguineo", nullable = false)
	public String getFactorSanguineo() {
		return this.factorSanguineo;
	}

	public void setFactorSanguineo(String factorSanguineo) {
		this.factorSanguineo = factorSanguineo;
	}

	@Column(name = "observacion", nullable = false)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoMedico")
	public Set<AfeccionJugador> getAfeccionJugadors() {
		return this.afeccionJugadors;
	}

	public void setAfeccionJugadors(Set<AfeccionJugador> afeccionJugadors) {
		this.afeccionJugadors = afeccionJugadors;
	}

}
