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
 * Material generated by hbm2java
 */
@Entity
@Table(name = "material")
public class Material implements java.io.Serializable {

	private String codigoMaterial;
	private UnidadMedida unidadMedida;
	private TipoMaterial tipoMaterial;
	private String descripcion;
	private char estadoMaterial;
	private int cantidadExistencia;
	private int cantidadPresentacion;
	private int cantidadDisponible;
	private boolean reutilizable;
	private int stockMinimo;
	private int stockMaximo;
	private char estatus;
	private Set<MaterialMantenimiento> materialMantenimientos = new HashSet<MaterialMantenimiento>(
			0);
	private Set<MaterialMantenimientoPlanificado> materialMantenimientoPlanificados = new HashSet<MaterialMantenimientoPlanificado>(
			0);

	public Material() {
	}

	public Material(String codigoMaterial, UnidadMedida unidadMedida,
			TipoMaterial tipoMaterial, String descripcion, char estadoMaterial,
			int cantidadExistencia, int cantidadPresentacion,
			int cantidadDisponible, boolean reutilizable, int stockMinimo,
			int stockMaximo, char estatus) {
		this.codigoMaterial = codigoMaterial;
		this.unidadMedida = unidadMedida;
		this.tipoMaterial = tipoMaterial;
		this.descripcion = descripcion;
		this.estadoMaterial = estadoMaterial;
		this.cantidadExistencia = cantidadExistencia;
		this.cantidadPresentacion = cantidadPresentacion;
		this.cantidadDisponible = cantidadDisponible;
		this.reutilizable = reutilizable;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		this.estatus = estatus;
	}

	public Material(
			String codigoMaterial,
			UnidadMedida unidadMedida,
			TipoMaterial tipoMaterial,
			String descripcion,
			char estadoMaterial,
			int cantidadExistencia,
			int cantidadPresentacion,
			int cantidadDisponible,
			boolean reutilizable,
			int stockMinimo,
			int stockMaximo,
			char estatus,
			Set<MaterialMantenimiento> materialMantenimientos,
			Set<MaterialMantenimientoPlanificado> materialMantenimientoPlanificados) {
		this.codigoMaterial = codigoMaterial;
		this.unidadMedida = unidadMedida;
		this.tipoMaterial = tipoMaterial;
		this.descripcion = descripcion;
		this.estadoMaterial = estadoMaterial;
		this.cantidadExistencia = cantidadExistencia;
		this.cantidadPresentacion = cantidadPresentacion;
		this.cantidadDisponible = cantidadDisponible;
		this.reutilizable = reutilizable;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		this.estatus = estatus;
		this.materialMantenimientos = materialMantenimientos;
		this.materialMantenimientoPlanificados = materialMantenimientoPlanificados;
	}

	@Id
	@Column(name = "codigo_material", unique = true, nullable = false)
	public String getCodigoMaterial() {
		return this.codigoMaterial;
	}

	public void setCodigoMaterial(String codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_unidad_medida", nullable = false)
	public UnidadMedida getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_material", nullable = false)
	public TipoMaterial getTipoMaterial() {
		return this.tipoMaterial;
	}

	public void setTipoMaterial(TipoMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estado_material", nullable = false, length = 1)
	public char getEstadoMaterial() {
		return this.estadoMaterial;
	}

	public void setEstadoMaterial(char estadoMaterial) {
		this.estadoMaterial = estadoMaterial;
	}

	@Column(name = "cantidad_existencia", nullable = false)
	public int getCantidadExistencia() {
		return this.cantidadExistencia;
	}

	public void setCantidadExistencia(int cantidadExistencia) {
		this.cantidadExistencia = cantidadExistencia;
	}

	@Column(name = "cantidad_presentacion", nullable = false)
	public int getCantidadPresentacion() {
		return this.cantidadPresentacion;
	}

	public void setCantidadPresentacion(int cantidadPresentacion) {
		this.cantidadPresentacion = cantidadPresentacion;
	}

	@Column(name = "cantidad_disponible", nullable = false)
	public int getCantidadDisponible() {
		return this.cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	@Column(name = "reutilizable", nullable = false)
	public boolean isReutilizable() {
		return this.reutilizable;
	}

	public void setReutilizable(boolean reutilizable) {
		this.reutilizable = reutilizable;
	}

	@Column(name = "stock_minimo", nullable = false)
	public int getStockMinimo() {
		return this.stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	@Column(name = "stock_maximo", nullable = false)
	public int getStockMaximo() {
		return this.stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "material")
	public Set<MaterialMantenimiento> getMaterialMantenimientos() {
		return this.materialMantenimientos;
	}

	public void setMaterialMantenimientos(
			Set<MaterialMantenimiento> materialMantenimientos) {
		this.materialMantenimientos = materialMantenimientos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "material")
	public Set<MaterialMantenimientoPlanificado> getMaterialMantenimientoPlanificados() {
		return this.materialMantenimientoPlanificados;
	}

	public void setMaterialMantenimientoPlanificados(
			Set<MaterialMantenimientoPlanificado> materialMantenimientoPlanificados) {
		this.materialMantenimientoPlanificados = materialMantenimientoPlanificados;
	}

}
