package modelo;

// Generated 09/01/2012 10:19:56 AM by Hibernate Tools 3.4.0.CR1

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
 * PlanTemporada generated by hbm2java
 */
@Entity
@Table(name = "plan_temporada", schema = "public")
public class PlanTemporada implements java.io.Serializable {

	private int codigoPlanTemporada;
	private Categoria categoria;
	private LapsoDeportivo lapsoDeportivo;
	private char estatus;
	private Set<Horario> horarios = new HashSet<Horario>(0);
	private Set<PersonalEquipo> personalEquipos = new HashSet<PersonalEquipo>(0);
	private Set<PlanEntrenamiento> planEntrenamientos = new HashSet<PlanEntrenamiento>(
			0);

	public PlanTemporada() {
	}

	public PlanTemporada(int codigoPlanTemporada, Categoria categoria,
			LapsoDeportivo lapsoDeportivo, char estatus) {
		this.codigoPlanTemporada = codigoPlanTemporada;
		this.categoria = categoria;
		this.lapsoDeportivo = lapsoDeportivo;
		this.estatus = estatus;
	}

	public PlanTemporada(int codigoPlanTemporada, Categoria categoria,
			LapsoDeportivo lapsoDeportivo, char estatus, Set<Horario> horarios,
			Set<PersonalEquipo> personalEquipos,
			Set<PlanEntrenamiento> planEntrenamientos) {
		this.codigoPlanTemporada = codigoPlanTemporada;
		this.categoria = categoria;
		this.lapsoDeportivo = lapsoDeportivo;
		this.estatus = estatus;
		this.horarios = horarios;
		this.personalEquipos = personalEquipos;
		this.planEntrenamientos = planEntrenamientos;
	}

	@Id
	@Column(name = "codigo_plan_temporada", unique = true, nullable = false)
	public int getCodigoPlanTemporada() {
		return this.codigoPlanTemporada;
	}

	public void setCodigoPlanTemporada(int codigoPlanTemporada) {
		this.codigoPlanTemporada = codigoPlanTemporada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_categoria", nullable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_lapso_deportivo", nullable = false)
	public LapsoDeportivo getLapsoDeportivo() {
		return this.lapsoDeportivo;
	}

	public void setLapsoDeportivo(LapsoDeportivo lapsoDeportivo) {
		this.lapsoDeportivo = lapsoDeportivo;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planTemporada")
	public Set<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planTemporada")
	public Set<PersonalEquipo> getPersonalEquipos() {
		return this.personalEquipos;
	}

	public void setPersonalEquipos(Set<PersonalEquipo> personalEquipos) {
		this.personalEquipos = personalEquipos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planTemporada")
	public Set<PlanEntrenamiento> getPlanEntrenamientos() {
		return this.planEntrenamientos;
	}

	public void setPlanEntrenamientos(Set<PlanEntrenamiento> planEntrenamientos) {
		this.planEntrenamientos = planEntrenamientos;
	}

}
