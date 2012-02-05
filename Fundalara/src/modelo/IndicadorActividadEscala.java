package modelo;

// Generated 04-feb-2012 16:31:02 by Hibernate Tools 3.4.0.CR1

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
 * IndicadorActividadEscala generated by hbm2java
 */
@Entity
@Table(name = "indicador_actividad_escala", schema = "public")
public class IndicadorActividadEscala implements java.io.Serializable {

	private int codigoIndicadorActividadEscala;
	private EscalaMedicion escalaMedicion;
	private DatoBasico datoBasico;
	private ActividadEntrenamiento actividadEntrenamiento;
	private char estatus;
	private Set<IndicadorTest> indicadorTests = new HashSet<IndicadorTest>(0);
	private Set<PuntuacionJugador> puntuacionJugadors = new HashSet<PuntuacionJugador>(
			0);

	public IndicadorActividadEscala() {
	}

	public IndicadorActividadEscala(int codigoIndicadorActividadEscala,
			EscalaMedicion escalaMedicion, DatoBasico datoBasico,
			ActividadEntrenamiento actividadEntrenamiento, char estatus) {
		this.codigoIndicadorActividadEscala = codigoIndicadorActividadEscala;
		this.escalaMedicion = escalaMedicion;
		this.datoBasico = datoBasico;
		this.actividadEntrenamiento = actividadEntrenamiento;
		this.estatus = estatus;
	}

	public IndicadorActividadEscala(int codigoIndicadorActividadEscala,
			EscalaMedicion escalaMedicion, DatoBasico datoBasico,
			ActividadEntrenamiento actividadEntrenamiento, char estatus,
			Set<IndicadorTest> indicadorTests,
			Set<PuntuacionJugador> puntuacionJugadors) {
		this.codigoIndicadorActividadEscala = codigoIndicadorActividadEscala;
		this.escalaMedicion = escalaMedicion;
		this.datoBasico = datoBasico;
		this.actividadEntrenamiento = actividadEntrenamiento;
		this.estatus = estatus;
		this.indicadorTests = indicadorTests;
		this.puntuacionJugadors = puntuacionJugadors;
	}

	@Id
	@Column(name = "codigo_indicador_actividad_escala", unique = true, nullable = false)
	public int getCodigoIndicadorActividadEscala() {
		return this.codigoIndicadorActividadEscala;
	}

	public void setCodigoIndicadorActividadEscala(
			int codigoIndicadorActividadEscala) {
		this.codigoIndicadorActividadEscala = codigoIndicadorActividadEscala;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_escala", nullable = false)
	public EscalaMedicion getEscalaMedicion() {
		return this.escalaMedicion;
	}

	public void setEscalaMedicion(EscalaMedicion escalaMedicion) {
		this.escalaMedicion = escalaMedicion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indicador", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_actividad_entrenamiento", nullable = false)
	public ActividadEntrenamiento getActividadEntrenamiento() {
		return this.actividadEntrenamiento;
	}

	public void setActividadEntrenamiento(
			ActividadEntrenamiento actividadEntrenamiento) {
		this.actividadEntrenamiento = actividadEntrenamiento;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "indicadorActividadEscala")
	public Set<IndicadorTest> getIndicadorTests() {
		return this.indicadorTests;
	}

	public void setIndicadorTests(Set<IndicadorTest> indicadorTests) {
		this.indicadorTests = indicadorTests;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "indicadorActividadEscala")
	public Set<PuntuacionJugador> getPuntuacionJugadors() {
		return this.puntuacionJugadors;
	}

	public void setPuntuacionJugadors(Set<PuntuacionJugador> puntuacionJugadors) {
		this.puntuacionJugadors = puntuacionJugadors;
	}

}
