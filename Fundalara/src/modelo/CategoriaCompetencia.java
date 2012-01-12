package modelo;

// Generated 11-ene-2012 21:47:34 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CategoriaCompetencia generated by hbm2java
 */
@Entity
@Table(name = "categoria_competencia", schema = "public")
public class CategoriaCompetencia implements java.io.Serializable {

	private CategoriaCompetenciaId id;
	private Categoria categoria;
	private Competencia competencia;
	private Date duracionHora;
	private Integer duracionInning;

	public CategoriaCompetencia() {
	}

	public CategoriaCompetencia(CategoriaCompetenciaId id, Categoria categoria,
			Competencia competencia) {
		this.id = id;
		this.categoria = categoria;
		this.competencia = competencia;
	}

	public CategoriaCompetencia(CategoriaCompetenciaId id, Categoria categoria,
			Competencia competencia, Date duracionHora, Integer duracionInning) {
		this.id = id;
		this.categoria = categoria;
		this.competencia = competencia;
		this.duracionHora = duracionHora;
		this.duracionInning = duracionInning;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoCompetencia", column = @Column(name = "codigo_competencia", nullable = false)),
			@AttributeOverride(name = "codigoCategoria", column = @Column(name = "codigo_categoria", nullable = false)) })
	public CategoriaCompetenciaId getId() {
		return this.id;
	}

	public void setId(CategoriaCompetenciaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_categoria", nullable = false, insertable = false, updatable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_competencia", nullable = false, insertable = false, updatable = false)
	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "duracion_hora", length = 15)
	public Date getDuracionHora() {
		return this.duracionHora;
	}

	public void setDuracionHora(Date duracionHora) {
		this.duracionHora = duracionHora;
	}

	@Column(name = "duracion_inning")
	public Integer getDuracionInning() {
		return this.duracionInning;
	}

	public void setDuracionInning(Integer duracionInning) {
		this.duracionInning = duracionInning;
	}

}
