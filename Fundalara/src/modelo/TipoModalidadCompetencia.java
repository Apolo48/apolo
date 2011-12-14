package modelo;

// Generated 13-dic-2011 21:15:29 by Hibernate Tools 3.4.0.CR1

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
 * TipoModalidadCompetencia generated by hbm2java
 */
@Entity
@Table(name = "tipo_modalidad_competencia")
public class TipoModalidadCompetencia implements java.io.Serializable {

	private String codigoTipoModalidadCompetencia;
	private TipoCompetencia tipoCompetencia;
	private ModalidadCompetencia modalidadCompetencia;
	private Set<Competencia> competencias = new HashSet<Competencia>(0);
	private Set<Competencia> competencias_1 = new HashSet<Competencia>(0);

	public TipoModalidadCompetencia() {
	}

	public TipoModalidadCompetencia(String codigoTipoModalidadCompetencia,
			TipoCompetencia tipoCompetencia,
			ModalidadCompetencia modalidadCompetencia) {
		this.codigoTipoModalidadCompetencia = codigoTipoModalidadCompetencia;
		this.tipoCompetencia = tipoCompetencia;
		this.modalidadCompetencia = modalidadCompetencia;
	}

	public TipoModalidadCompetencia(String codigoTipoModalidadCompetencia,
			TipoCompetencia tipoCompetencia,
			ModalidadCompetencia modalidadCompetencia,
			Set<Competencia> competencias, Set<Competencia> competencias_1) {
		this.codigoTipoModalidadCompetencia = codigoTipoModalidadCompetencia;
		this.tipoCompetencia = tipoCompetencia;
		this.modalidadCompetencia = modalidadCompetencia;
		this.competencias = competencias;
		this.competencias_1 = competencias_1;
	}

	@Id
	@Column(name = "codigo_tipo_modalidad_competencia", unique = true, nullable = false)
	public String getCodigoTipoModalidadCompetencia() {
		return this.codigoTipoModalidadCompetencia;
	}

	public void setCodigoTipoModalidadCompetencia(
			String codigoTipoModalidadCompetencia) {
		this.codigoTipoModalidadCompetencia = codigoTipoModalidadCompetencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_competencia", nullable = false)
	public TipoCompetencia getTipoCompetencia() {
		return this.tipoCompetencia;
	}

	public void setTipoCompetencia(TipoCompetencia tipoCompetencia) {
		this.tipoCompetencia = tipoCompetencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_modalidad_competencia", nullable = false)
	public ModalidadCompetencia getModalidadCompetencia() {
		return this.modalidadCompetencia;
	}

	public void setModalidadCompetencia(
			ModalidadCompetencia modalidadCompetencia) {
		this.modalidadCompetencia = modalidadCompetencia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoModalidadCompetencia")
	public Set<Competencia> getCompetencias() {
		return this.competencias;
	}

	public void setCompetencias(Set<Competencia> competencias) {
		this.competencias = competencias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoModalidadCompetencia")
	public Set<Competencia> getCompetencias_1() {
		return this.competencias_1;
	}

	public void setCompetencias_1(Set<Competencia> competencias_1) {
		this.competencias_1 = competencias_1;
	}

}
