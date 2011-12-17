package modelo;

// Generated 17/12/2011 10:20:04 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Temporada generated by hbm2java
 */
@Entity
@Table(name = "temporada")
public class Temporada implements java.io.Serializable {

	private String codigoTemporada;
	private Date fechaInicio;
	private Date fechaFin;
	private String descripcion;
	private char estatus;
	private Set<Competencia> competencias = new HashSet<Competencia>(0);

	public Temporada() {
	}

	public Temporada(String codigoTemporada, Date fechaInicio, Date fechaFin,
			String descripcion, char estatus) {
		this.codigoTemporada = codigoTemporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public Temporada(String codigoTemporada, Date fechaInicio, Date fechaFin,
			String descripcion, char estatus, Set<Competencia> competencias) {
		this.codigoTemporada = codigoTemporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.competencias = competencias;
	}

	@Id
	@Column(name = "codigo_temporada", unique = true, nullable = false)
	public String getCodigoTemporada() {
		return this.codigoTemporada;
	}

	public void setCodigoTemporada(String codigoTemporada) {
		this.codigoTemporada = codigoTemporada;
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

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "temporada")
	public Set<Competencia> getCompetencias() {
		return this.competencias;
	}

	public void setCompetencias(Set<Competencia> competencias) {
		this.competencias = competencias;
	}

}
