package modelo;

// Generated 05/12/2011 04:52:07 PM by Hibernate Tools 3.4.0.CR1

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
@Table(name = "indicador")
public class Indicador implements java.io.Serializable {

	private String codIndicador;
	private TipoIndicador tipoIndicador;
	private String nombre;
	private String descripcion;
	private char estatus;
	private Set<IndicadorActividadEscala> indicadorActividadEscalas = new HashSet<IndicadorActividadEscala>(
			0);

	public Indicador() {
	}

	public Indicador(String codIndicador, TipoIndicador tipoIndicador,
			String nombre, String descripcion, char estatus) {
		this.codIndicador = codIndicador;
		this.tipoIndicador = tipoIndicador;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public Indicador(String codIndicador, TipoIndicador tipoIndicador,
			String nombre, String descripcion, char estatus,
			Set<IndicadorActividadEscala> indicadorActividadEscalas) {
		this.codIndicador = codIndicador;
		this.tipoIndicador = tipoIndicador;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.indicadorActividadEscalas = indicadorActividadEscalas;
	}

	@Id
	@Column(name = "cod_indicador", unique = true, nullable = false)
	public String getCodIndicador() {
		return this.codIndicador;
	}

	public void setCodIndicador(String codIndicador) {
		this.codIndicador = codIndicador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_tipo_indicador", nullable = false)
	public TipoIndicador getTipoIndicador() {
		return this.tipoIndicador;
	}

	public void setTipoIndicador(TipoIndicador tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "indicador")
	public Set<IndicadorActividadEscala> getIndicadorActividadEscalas() {
		return this.indicadorActividadEscalas;
	}

	public void setIndicadorActividadEscalas(
			Set<IndicadorActividadEscala> indicadorActividadEscalas) {
		this.indicadorActividadEscalas = indicadorActividadEscalas;
	}

}
