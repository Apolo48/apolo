package modelo;

// Generated 13/02/2012 02:19:00 PM by Hibernate Tools 3.4.0.CR1

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
 * IndicadorCategoriaCompetencia generated by hbm2java
 */
@Entity
@Table(name = "indicador_categoria_competencia", schema = "public")
public class IndicadorCategoriaCompetencia implements java.io.Serializable {

	private int codigoIndicadorCategoriaCompetencia;
	private Categoria categoria;
	private Competencia competencia;
	private Indicador indicador;
	private char estatus;
	private Set<DesempennoIndividual> desempennoIndividuals = new HashSet<DesempennoIndividual>(
			0);
	private Set<DesempennoColectivo> desempennoColectivos = new HashSet<DesempennoColectivo>(
			0);

	public IndicadorCategoriaCompetencia() {
	}

	public IndicadorCategoriaCompetencia(
			int codigoIndicadorCategoriaCompetencia, Categoria categoria,
			Competencia competencia, Indicador indicador, char estatus) {
		this.codigoIndicadorCategoriaCompetencia = codigoIndicadorCategoriaCompetencia;
		this.categoria = categoria;
		this.competencia = competencia;
		this.indicador = indicador;
		this.estatus = estatus;
	}

	public IndicadorCategoriaCompetencia(
			int codigoIndicadorCategoriaCompetencia, Categoria categoria,
			Competencia competencia, Indicador indicador, char estatus,
			Set<DesempennoIndividual> desempennoIndividuals,
			Set<DesempennoColectivo> desempennoColectivos) {
		this.codigoIndicadorCategoriaCompetencia = codigoIndicadorCategoriaCompetencia;
		this.categoria = categoria;
		this.competencia = competencia;
		this.indicador = indicador;
		this.estatus = estatus;
		this.desempennoIndividuals = desempennoIndividuals;
		this.desempennoColectivos = desempennoColectivos;
	}

	@Id
	@Column(name = "codigo_indicador_categoria_competencia", unique = true, nullable = false)
	public int getCodigoIndicadorCategoriaCompetencia() {
		return this.codigoIndicadorCategoriaCompetencia;
	}

	public void setCodigoIndicadorCategoriaCompetencia(
			int codigoIndicadorCategoriaCompetencia) {
		this.codigoIndicadorCategoriaCompetencia = codigoIndicadorCategoriaCompetencia;
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
	@JoinColumn(name = "codigo_competencia", nullable = false)
	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_indicador", nullable = false)
	public Indicador getIndicador() {
		return this.indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "indicadorCategoriaCompetencia")
	public Set<DesempennoIndividual> getDesempennoIndividuals() {
		return this.desempennoIndividuals;
	}

	public void setDesempennoIndividuals(
			Set<DesempennoIndividual> desempennoIndividuals) {
		this.desempennoIndividuals = desempennoIndividuals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "indicadorCategoriaCompetencia")
	public Set<DesempennoColectivo> getDesempennoColectivos() {
		return this.desempennoColectivos;
	}

	public void setDesempennoColectivos(
			Set<DesempennoColectivo> desempennoColectivos) {
		this.desempennoColectivos = desempennoColectivos;
	}

}
