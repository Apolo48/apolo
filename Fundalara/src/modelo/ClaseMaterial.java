package modelo;

// Generated 13-dic-2011 21:15:29 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ClaseMaterial generated by hbm2java
 */
@Entity
@Table(name = "clase_material")
public class ClaseMaterial implements java.io.Serializable {

	private String codigoClaseMaterial;
	private String descripcion;
	private char estatus;
	private Set<TipoMaterial> tipoMaterials = new HashSet<TipoMaterial>(0);
	private Set<TipoMaterial> tipoMaterials_1 = new HashSet<TipoMaterial>(0);

	public ClaseMaterial() {
	}

	public ClaseMaterial(String codigoClaseMaterial, String descripcion,
			char estatus) {
		this.codigoClaseMaterial = codigoClaseMaterial;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public ClaseMaterial(String codigoClaseMaterial, String descripcion,
			char estatus, Set<TipoMaterial> tipoMaterials,
			Set<TipoMaterial> tipoMaterials_1) {
		this.codigoClaseMaterial = codigoClaseMaterial;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.tipoMaterials = tipoMaterials;
		this.tipoMaterials_1 = tipoMaterials_1;
	}

	@Id
	@Column(name = "codigo_clase_material", unique = true, nullable = false)
	public String getCodigoClaseMaterial() {
		return this.codigoClaseMaterial;
	}

	public void setCodigoClaseMaterial(String codigoClaseMaterial) {
		this.codigoClaseMaterial = codigoClaseMaterial;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "claseMaterial")
	public Set<TipoMaterial> getTipoMaterials() {
		return this.tipoMaterials;
	}

	public void setTipoMaterials(Set<TipoMaterial> tipoMaterials) {
		this.tipoMaterials = tipoMaterials;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "claseMaterial")
	public Set<TipoMaterial> getTipoMaterials_1() {
		return this.tipoMaterials_1;
	}

	public void setTipoMaterials_1(Set<TipoMaterial> tipoMaterials_1) {
		this.tipoMaterials_1 = tipoMaterials_1;
	}

}
