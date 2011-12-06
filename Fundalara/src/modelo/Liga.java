package modelo;

// Generated 05-dic-2011 18:58:46 by Hibernate Tools 3.4.0.CR1

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
 * Liga generated by hbm2java
 */
@Entity
@Table(name = "liga")
public class Liga implements java.io.Serializable {

	private String codigoLiga;
	private String nombre;
	private byte[] logo;
	private Set<Categoria> categorias = new HashSet<Categoria>(0);

	public Liga() {
	}

	public Liga(String codigoLiga, String nombre, byte[] logo) {
		this.codigoLiga = codigoLiga;
		this.nombre = nombre;
		this.logo = logo;
	}

	public Liga(String codigoLiga, String nombre, byte[] logo,
			Set<Categoria> categorias) {
		this.codigoLiga = codigoLiga;
		this.nombre = nombre;
		this.logo = logo;
		this.categorias = categorias;
	}

	@Id
	@Column(name = "codigo_liga", unique = true, nullable = false)
	public String getCodigoLiga() {
		return this.codigoLiga;
	}

	public void setCodigoLiga(String codigoLiga) {
		this.codigoLiga = codigoLiga;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "logo", nullable = false)
	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liga_categoria", joinColumns = { @JoinColumn(name = "codigo_liga", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "codigo_categoria", nullable = false, updatable = false) })
	public Set<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

}
