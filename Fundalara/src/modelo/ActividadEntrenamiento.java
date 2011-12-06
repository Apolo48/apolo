package modelo;

// Generated 05-dic-2011 23:09:14 by Hibernate Tools 3.4.0.CR1

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
 * ActividadEntrenamiento generated by hbm2java
 */
@Entity
@Table(name = "actividad_entrenamiento")
public class ActividadEntrenamiento implements java.io.Serializable {

	private String codActividadEntrenamiento;
	private Categoria categoria;
	private Fase fase;
	private String nombre;
	private String descripcion;
	private char estatus;
	private Set<IndicadorActividadEscala> indicadorActividadEscalas = new HashSet<IndicadorActividadEscala>(
			0);

	public ActividadEntrenamiento() {
	}

	public ActividadEntrenamiento(String codActividadEntrenamiento,
			Categoria categoria, Fase fase, String nombre, String descripcion,
			char estatus) {
		this.codActividadEntrenamiento = codActividadEntrenamiento;
		this.categoria = categoria;
		this.fase = fase;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public ActividadEntrenamiento(String codActividadEntrenamiento,
			Categoria categoria, Fase fase, String nombre, String descripcion,
			char estatus,
			Set<IndicadorActividadEscala> indicadorActividadEscalas) {
		this.codActividadEntrenamiento = codActividadEntrenamiento;
		this.categoria = categoria;
		this.fase = fase;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.indicadorActividadEscalas = indicadorActividadEscalas;
	}

	@Id
	@Column(name = "cod_actividad_entrenamiento", unique = true, nullable = false)
	public String getCodActividadEntrenamiento() {
		return this.codActividadEntrenamiento;
	}

	public void setCodActividadEntrenamiento(String codActividadEntrenamiento) {
		this.codActividadEntrenamiento = codActividadEntrenamiento;
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
	@JoinColumn(name = "cod_fase_entrenamiento", nullable = false)
	public Fase getFase() {
		return this.fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividadEntrenamiento")
	public Set<IndicadorActividadEscala> getIndicadorActividadEscalas() {
		return this.indicadorActividadEscalas;
	}

	public void setIndicadorActividadEscalas(
			Set<IndicadorActividadEscala> indicadorActividadEscalas) {
		this.indicadorActividadEscalas = indicadorActividadEscalas;
	}

}
