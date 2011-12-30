package modelo;

// Generated 30-dic-2011 0:38:42 by Hibernate Tools 3.4.0.CR1

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
 * Indicador generated by hbm2java
 */
@Entity
@Table(name = "indicador", schema = "public")
public class Indicador implements java.io.Serializable {

	private int codigoIndicador;
	private DatoBasico datoBasicoByCodigoModalidad;
	private DatoBasico datoBasicoByCodigoTipo;
	private String nombre;
	private String abreviatura;
	private char estatus;
	private Set<IndicadorCategoriaCompetencia> indicadorCategoriaCompetencias = new HashSet<IndicadorCategoriaCompetencia>(
			0);

	public Indicador() {
	}

	public Indicador(int codigoIndicador,
			DatoBasico datoBasicoByCodigoModalidad,
			DatoBasico datoBasicoByCodigoTipo, String nombre,
			String abreviatura, char estatus) {
		this.codigoIndicador = codigoIndicador;
		this.datoBasicoByCodigoModalidad = datoBasicoByCodigoModalidad;
		this.datoBasicoByCodigoTipo = datoBasicoByCodigoTipo;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.estatus = estatus;
	}

	public Indicador(int codigoIndicador,
			DatoBasico datoBasicoByCodigoModalidad,
			DatoBasico datoBasicoByCodigoTipo, String nombre,
			String abreviatura, char estatus,
			Set<IndicadorCategoriaCompetencia> indicadorCategoriaCompetencias) {
		this.codigoIndicador = codigoIndicador;
		this.datoBasicoByCodigoModalidad = datoBasicoByCodigoModalidad;
		this.datoBasicoByCodigoTipo = datoBasicoByCodigoTipo;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.estatus = estatus;
		this.indicadorCategoriaCompetencias = indicadorCategoriaCompetencias;
	}

	@Id
	@Column(name = "codigo_indicador", unique = true, nullable = false)
	public int getCodigoIndicador() {
		return this.codigoIndicador;
	}

	public void setCodigoIndicador(int codigoIndicador) {
		this.codigoIndicador = codigoIndicador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_modalidad", nullable = false)
	public DatoBasico getDatoBasicoByCodigoModalidad() {
		return this.datoBasicoByCodigoModalidad;
	}

	public void setDatoBasicoByCodigoModalidad(
			DatoBasico datoBasicoByCodigoModalidad) {
		this.datoBasicoByCodigoModalidad = datoBasicoByCodigoModalidad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo", nullable = false)
	public DatoBasico getDatoBasicoByCodigoTipo() {
		return this.datoBasicoByCodigoTipo;
	}

	public void setDatoBasicoByCodigoTipo(DatoBasico datoBasicoByCodigoTipo) {
		this.datoBasicoByCodigoTipo = datoBasicoByCodigoTipo;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "abreviatura", nullable = false)
	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "indicador")
	public Set<IndicadorCategoriaCompetencia> getIndicadorCategoriaCompetencias() {
		return this.indicadorCategoriaCompetencias;
	}

	public void setIndicadorCategoriaCompetencias(
			Set<IndicadorCategoriaCompetencia> indicadorCategoriaCompetencias) {
		this.indicadorCategoriaCompetencias = indicadorCategoriaCompetencias;
	}

}
