package modelo;

// Generated 26-dic-2011 21:37:05 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LapsoDeportivo generated by hbm2java
 */
@Entity
@Table(name = "lapso_deportivo", schema = "public")
public class LapsoDeportivo implements java.io.Serializable {

	private int codigoLapsoDeportivo;
	private DatoBasico datoBasico;
	private Date fechaInicio;
	private Date fechaFin;
	private String nombre;
	private char estatus;
	private Set<Competencia> competencias = new HashSet<Competencia>(0);
	private Set<PlanTemporada> planTemporadas = new HashSet<PlanTemporada>(0);

	public LapsoDeportivo() {
	}

	public LapsoDeportivo(int codigoLapsoDeportivo, DatoBasico datoBasico,
			Date fechaInicio, Date fechaFin, String nombre, char estatus) {
		this.codigoLapsoDeportivo = codigoLapsoDeportivo;
		this.datoBasico = datoBasico;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.nombre = nombre;
		this.estatus = estatus;
	}

	public LapsoDeportivo(int codigoLapsoDeportivo, DatoBasico datoBasico,
			Date fechaInicio, Date fechaFin, String nombre, char estatus,
			Set<Competencia> competencias, Set<PlanTemporada> planTemporadas) {
		this.codigoLapsoDeportivo = codigoLapsoDeportivo;
		this.datoBasico = datoBasico;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.nombre = nombre;
		this.estatus = estatus;
		this.competencias = competencias;
		this.planTemporadas = planTemporadas;
	}

	@Id
	@Column(name = "codigo_lapso_deportivo", unique = true, nullable = false)
	public int getCodigoLapsoDeportivo() {
		return this.codigoLapsoDeportivo;
	}

	public void setCodigoLapsoDeportivo(int codigoLapsoDeportivo) {
		this.codigoLapsoDeportivo = codigoLapsoDeportivo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_lapso", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio", nullable = false, length = 13)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin", nullable = false, length = 13)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lapsoDeportivo")
	public Set<Competencia> getCompetencias() {
		return this.competencias;
	}

	public void setCompetencias(Set<Competencia> competencias) {
		this.competencias = competencias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lapsoDeportivo")
	public Set<PlanTemporada> getPlanTemporadas() {
		return this.planTemporadas;
	}

	public void setPlanTemporadas(Set<PlanTemporada> planTemporadas) {
		this.planTemporadas = planTemporadas;
	}

}
