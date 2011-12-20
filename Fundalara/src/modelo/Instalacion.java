package modelo;

// Generated 17-dic-2011 16:31:20 by Hibernate Tools 3.4.0.CR1

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
@Table(name = "instalacion")
public class Instalacion implements java.io.Serializable {

	private int codigoInstalacion;
	private DatoBasico datoBasico;
	private String descripcion;
	private Integer capacidad;
	private char estatus;
	private BigDecimal tamano;
	private String area;
	private Set<Almacen> almacens = new HashSet<Almacen>(0);
	private Set<PlanificacionActividad> planificacionActividads = new HashSet<PlanificacionActividad>(
			0);
	private Set<PlanRotacion> planRotacions = new HashSet<PlanRotacion>(0);
	private Set<SesionEjecutada> sesionEjecutadas = new HashSet<SesionEjecutada>(
			0);

	public Instalacion() {
	}

	public Instalacion(int codigoInstalacion, DatoBasico datoBasico,
			String descripcion, char estatus, BigDecimal tamano) {
		this.codigoInstalacion = codigoInstalacion;
		this.datoBasico = datoBasico;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.tamano = tamano;
	}

	public Instalacion(int codigoInstalacion, DatoBasico datoBasico,
			String descripcion, Integer capacidad, char estatus,
			BigDecimal tamano, String area, Set<Almacen> almacens,
			Set<PlanificacionActividad> planificacionActividads,
			Set<PlanRotacion> planRotacions,
			Set<SesionEjecutada> sesionEjecutadas) {
		this.codigoInstalacion = codigoInstalacion;
		this.datoBasico = datoBasico;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.estatus = estatus;
		this.tamano = tamano;
		this.area = area;
		this.almacens = almacens;
		this.planificacionActividads = planificacionActividads;
		this.planRotacions = planRotacions;
		this.sesionEjecutadas = sesionEjecutadas;
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

	@Column(name = "descripcion", nullable = false)
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

	@Column(name = "tamano", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getTamano() {
		return this.tamano;
	}

	public void setTamano(BigDecimal tamano) {
		this.tamano = tamano;
	}

	@Column(name = "area")
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instalacion")
	public Set<Almacen> getAlmacens() {
		return this.almacens;
	}

	public void setAlmacens(Set<Almacen> almacens) {
		this.almacens = almacens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instalacion")
	public Set<PlanificacionActividad> getPlanificacionActividads() {
		return this.planificacionActividads;
	}

	public void setPlanificacionActividads(
			Set<PlanificacionActividad> planificacionActividads) {
		this.planificacionActividads = planificacionActividads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instalacion")
	public Set<PlanRotacion> getPlanRotacions() {
		return this.planRotacions;
	}

	public void setPlanRotacions(Set<PlanRotacion> planRotacions) {
		this.planRotacions = planRotacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instalacion")
	public Set<SesionEjecutada> getSesionEjecutadas() {
		return this.sesionEjecutadas;
	}

	public void setSesionEjecutadas(Set<SesionEjecutada> sesionEjecutadas) {
		this.sesionEjecutadas = sesionEjecutadas;
	}

}