package modelo;

// Generated 04-feb-2012 16:31:02 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
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
 * Instalacion generated by hbm2java
 */
@Entity
@Table(name = "instalacion", schema = "public")
public class Instalacion implements java.io.Serializable {

	private int codigoInstalacion;
	private DatoBasico datoBasico;
	private String descripcion;
	private Integer capacidad;
	private char estatus;
	private BigDecimal tamano;
	private String ubicacion;
	private Set<Almacen> almacens = new HashSet<Almacen>(0);
	private Set<InstalacionUtilizada> instalacionUtilizadas = new HashSet<InstalacionUtilizada>(
			0);
	private Set<InstalacionEjecutada> instalacionEjecutadas = new HashSet<InstalacionEjecutada>(
			0);

	public Instalacion() {
	}

	public Instalacion(int codigoInstalacion, DatoBasico datoBasico,
			char estatus) {
		this.codigoInstalacion = codigoInstalacion;
		this.datoBasico = datoBasico;
		this.estatus = estatus;
	}

	public Instalacion(int codigoInstalacion, DatoBasico datoBasico,
			String descripcion, Integer capacidad, char estatus,
			BigDecimal tamano, String ubicacion, Set<Almacen> almacens,
			Set<InstalacionUtilizada> instalacionUtilizadas,
			Set<InstalacionEjecutada> instalacionEjecutadas) {
		this.codigoInstalacion = codigoInstalacion;
		this.datoBasico = datoBasico;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.estatus = estatus;
		this.tamano = tamano;
		this.ubicacion = ubicacion;
		this.almacens = almacens;
		this.instalacionUtilizadas = instalacionUtilizadas;
		this.instalacionEjecutadas = instalacionEjecutadas;
	}

	@Id
	@Column(name = "codigo_instalacion", unique = true, nullable = false)
	public int getCodigoInstalacion() {
		return this.codigoInstalacion;
	}

	public void setCodigoInstalacion(int codigoInstalacion) {
		this.codigoInstalacion = codigoInstalacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_instalacion", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "capacidad")
	public Integer getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@Column(name = "tamano", precision = 131089, scale = 0)
	public BigDecimal getTamano() {
		return this.tamano;
	}

	public void setTamano(BigDecimal tamano) {
		this.tamano = tamano;
	}

	@Column(name = "ubicacion")
	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instalacion")
	public Set<Almacen> getAlmacens() {
		return this.almacens;
	}

	public void setAlmacens(Set<Almacen> almacens) {
		this.almacens = almacens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instalacion")
	public Set<InstalacionUtilizada> getInstalacionUtilizadas() {
		return this.instalacionUtilizadas;
	}

	public void setInstalacionUtilizadas(
			Set<InstalacionUtilizada> instalacionUtilizadas) {
		this.instalacionUtilizadas = instalacionUtilizadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instalacion")
	public Set<InstalacionEjecutada> getInstalacionEjecutadas() {
		return this.instalacionEjecutadas;
	}

	public void setInstalacionEjecutadas(
			Set<InstalacionEjecutada> instalacionEjecutadas) {
		this.instalacionEjecutadas = instalacionEjecutadas;
	}

}
