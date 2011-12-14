package modelo;

// Generated 13-dic-2011 23:21:03 by Hibernate Tools 3.4.0.CR1

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
 * TipoMaterial generated by hbm2java
 */
@Entity
@Table(name = "tipo_material")
public class TipoMaterial implements java.io.Serializable {

	private String codigoTipoMaterial;
	private ClaseMaterial claseMaterial;
	private String descripcion;
	private char estatus;
	private Set<Material> materials = new HashSet<Material>(0);
	private Set<Material> materials_1 = new HashSet<Material>(0);

	public TipoMaterial() {
	}

	public TipoMaterial(String codigoTipoMaterial, ClaseMaterial claseMaterial,
			String descripcion, char estatus) {
		this.codigoTipoMaterial = codigoTipoMaterial;
		this.claseMaterial = claseMaterial;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public TipoMaterial(String codigoTipoMaterial, ClaseMaterial claseMaterial,
			String descripcion, char estatus, Set<Material> materials,
			Set<Material> materials_1) {
		this.codigoTipoMaterial = codigoTipoMaterial;
		this.claseMaterial = claseMaterial;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.materials = materials;
		this.materials_1 = materials_1;
	}

	@Id
	@Column(name = "codigo_tipo_material", unique = true, nullable = false)
	public String getCodigoTipoMaterial() {
		return this.codigoTipoMaterial;
	}

	public void setCodigoTipoMaterial(String codigoTipoMaterial) {
		this.codigoTipoMaterial = codigoTipoMaterial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_clase_material", nullable = false)
	public ClaseMaterial getClaseMaterial() {
		return this.claseMaterial;
	}

	public void setClaseMaterial(ClaseMaterial claseMaterial) {
		this.claseMaterial = claseMaterial;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoMaterial")
	public Set<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(Set<Material> materials) {
		this.materials = materials;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoMaterial")
	public Set<Material> getMaterials_1() {
		return this.materials_1;
	}

	public void setMaterials_1(Set<Material> materials_1) {
		this.materials_1 = materials_1;
	}

}
