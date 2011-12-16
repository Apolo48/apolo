package modelo;

// Generated 16-dic-2011 17:19:16 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Regla generated by hbm2java
 */
@Entity
@Table(name = "regla")
public class Regla implements java.io.Serializable {

	private String codigoRegla;
	private String nombre;
	private String descripcion;
	private Set<Categoria> categorias = new HashSet<Categoria>(0);

	public Regla() {
	}

	public Regla(String codigoRegla, String nombre, String descripcion) {
		this.codigoRegla = codigoRegla;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Regla(String codigoRegla, String nombre, String descripcion,
			Set<Categoria> categorias) {
		this.codigoRegla = codigoRegla;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categorias = categorias;
	}

	@Id
	@Column(name = "codigo_regla", unique = true, nullable = false)
	public String getCodigoRegla() {
		return this.codigoRegla;
	}

	public void setCodigoRegla(String codigoRegla) {
		this.codigoRegla = codigoRegla;
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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "regla_categoria", joinColumns = { @JoinColumn(name = "codigo_regla", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "codigo_categoria", nullable = false, updatable = false) })
	public Set<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

}
