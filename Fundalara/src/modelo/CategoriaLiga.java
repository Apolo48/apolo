package modelo;

// Generated 04-feb-2012 16:31:02 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CategoriaLiga generated by hbm2java
 */
@Entity
@Table(name = "categoria_liga", schema = "public")
public class CategoriaLiga implements java.io.Serializable {

	private CategoriaLigaId id;
	private Categoria categoria;
	private Liga liga;
	private char estatus;

	public CategoriaLiga() {
	}

	public CategoriaLiga(CategoriaLigaId id, Categoria categoria, Liga liga,
			char estatus) {
		this.id = id;
		this.categoria = categoria;
		this.liga = liga;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoLiga", column = @Column(name = "codigo_liga", nullable = false)),
			@AttributeOverride(name = "codigoCategoria", column = @Column(name = "codigo_categoria", nullable = false)) })
	public CategoriaLigaId getId() {
		return this.id;
	}

	public void setId(CategoriaLigaId id) {
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
	@JoinColumn(name = "codigo_liga", nullable = false, insertable = false, updatable = false)
	public Liga getLiga() {
		return this.liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}